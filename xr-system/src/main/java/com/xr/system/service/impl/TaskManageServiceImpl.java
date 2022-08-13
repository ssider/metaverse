package com.xr.system.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.xr.common.utils.DateUtils;
import com.xr.common.utils.StringUtils;
import com.xr.common.utils.uuid.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xr.system.mapper.TaskManageMapper;
import com.xr.system.domain.TaskManage;
import com.xr.system.service.ITaskManageService;

import static com.xr.common.constant.Constants.PARENTNOTFOUND;

/**
 * 任务管理Service业务层处理
 *
 * @author xr
 * @date 2022-08-09
 */
@Service
public class TaskManageServiceImpl implements ITaskManageService {
    @Autowired
    private TaskManageMapper taskManageMapper;

    /**
     * 查询任务管理
     *
     * @param taskNumber 任务管理主键
     * @return 任务管理
     */
    @Override
    public TaskManage selectTaskManageByTaskNumber(String taskNumber) {
        return taskManageMapper.selectTaskManageByTaskNumber(taskNumber);
    }

    /**
     * 查询任务管理列表
     *
     * @param taskManage 任务管理
     * @return 任务管理
     */
    @Override
    public List<TaskManage> selectTaskManageList(TaskManage taskManage) {
        List<TaskManage> tasks = taskManageMapper.selectTaskManageList(taskManage);
        List<TaskManage> taskTrees = buildTaskManageTree(tasks);
        return taskTrees.stream().map(TaskManage::new).collect(Collectors.toList());
    }


    /**
     * 新增任务管理
     *
     * @param taskManage 任务管理
     * @return 结果
     */
    @Override
    public int insertTaskManage(TaskManage taskManage) {
        if (!taskManage.getParentNumber().equals("0")) {
            TaskManage task = taskManageMapper.selectTaskManageByTaskNumber(taskManage.getParentNumber());
            if (null == task || StringUtils.isEmpty(task.getTaskNumber())) {
                return PARENTNOTFOUND;
            }
        }
        taskManage.setTaskNumber(IdUtils.lengthUUID(0, 6));
        taskManage.setCreateTime(DateUtils.getNowDate());
        taskManage.setModifyTime(DateUtils.getNowDate());
        if (StringUtils.isEmpty(taskManage.getTaskStatus())) {
            taskManage.setTaskStatus("0");
        }
        if (null == taskManage.getTaskProcess() || taskManage.getTaskProcess() <= 0) {
            taskManage.setTaskProcess(0L);
        }
        if (null == taskManage.getLevelDetail() || taskManage.getLevelDetail() <= 0) {
            taskManage.setLevelDetail(0L);
        }
        taskManage.setModifyTime(DateUtils.getNowDate());
        return taskManageMapper.insertTaskManage(taskManage);
    }

    /**
     * 修改任务管理
     *
     * @param taskManage 任务管理
     * @return 结果
     */
    @Override
    public int updateTaskManage(TaskManage taskManage) {
        taskManage.setModifyTime(DateUtils.getNowDate());
        return taskManageMapper.updateTaskManage(taskManage);
    }

    /**
     * 批量删除任务管理
     *
     * @param taskNumbers 需要删除的任务管理主键
     * @return 结果
     */
    @Override
    public int deleteTaskManageByTaskNumbers(String[] taskNumbers) {
        return taskManageMapper.deleteTaskManageByTaskNumbers(taskNumbers);
    }

    /**
     * 删除任务管理信息
     *
     * @param taskNumber 任务管理主键
     * @return 结果
     */
    @Override
    public int deleteTaskManageByTaskNumber(String taskNumber) {
        deleteSubTaskManageByTaskNumber(taskNumber);
        return taskManageMapper.deleteTaskManageByTaskNumber(taskNumber);
    }

    /**
     * 删除任务管理信息
     *
     * @param taskNumber 任务管理主键
     * @return 结果
     */
    public int deleteSubTaskManageByTaskNumber(String taskNumber) {
        int i = 0;
        TaskManage taskManage = taskManageMapper.selectTaskManageByTaskNumber(taskNumber);
        int parentNum = taskManageMapper.selectCountTaskManageByParentNumber(taskManage.getParentNumber());
        if (parentNum > 0) {
            i = deleteSubTaskManageByTaskNumber(taskNumber);
        } else {
            i = taskManageMapper.deleteTaskManageByParentNumber(taskManage.getParentNumber());
        }

        return i;
    }


    /**
     * 构建前端所需要树结构
     *
     * @param taskList 菜单列表
     * @return 树结构列表
     */
    public List<TaskManage> buildTaskManageTree(List<TaskManage> taskList) {
        List<TaskManage> returnList = new ArrayList<TaskManage>();
        List<String> tempList = new ArrayList<String>();
        for (TaskManage manage : taskList) {
            tempList.add(manage.getTaskNumber());
        }
        for (TaskManage task : taskList) {
            // 如果是顶级节点, 遍历该父节点的所有子节点
            if (!tempList.contains(task.getParentNumber())) {
                recursionFn(taskList, task);
                returnList.add(task);
            }
        }
        if (returnList.isEmpty()) {
            returnList = taskList;
        }
        return returnList;
    }

    private void recursionFn(List<TaskManage> list, TaskManage t) {
        // 得到子节点列表
        List<TaskManage> childList = getChildList(list, t);
        t.setChildren(childList);
        for (TaskManage tChild : childList) {
            if (hasChild(list, tChild)) {
                recursionFn(list, tChild);
            }
        }
    }

    /**
     * 得到子节点列表
     */
    private List<TaskManage> getChildList(List<TaskManage> list, TaskManage t) {
        List<TaskManage> newList = new ArrayList<TaskManage>();
        Iterator<TaskManage> it = list.iterator();
        while (it.hasNext()) {
            TaskManage n = (TaskManage) it.next();
            if (StringUtils.isNotEmpty(n.getParentNumber()) && n.getParentNumber().equals(t.getTaskNumber())) {
                newList.add(n);
            }
        }
        return newList;
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<TaskManage> list, TaskManage t) {
        return getChildList(list, t).size() > 0;
    }

}