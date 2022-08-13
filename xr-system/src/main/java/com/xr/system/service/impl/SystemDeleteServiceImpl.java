package com.xr.system.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.xr.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xr.system.mapper.SystemDeleteMapper;
import com.xr.system.domain.SystemDelete;
import com.xr.system.service.ISystemDeleteService;

/**
 * 任务管理Service业务层处理
 *
 * @author xr
 * @date 2022-08-12
 */
@Service
public class SystemDeleteServiceImpl implements ISystemDeleteService {
    @Autowired
    private SystemDeleteMapper systemDeleteMapper;

    /**
     * 查询任务管理
     *
     * @param taskNumber 任务管理主键
     * @return 任务管理
     */
    @Override
    public SystemDelete selectSystemDeleteByTaskNumber(String taskNumber) {
        return systemDeleteMapper.selectSystemDeleteByTaskNumber(taskNumber);
    }

    /**
     * 查询任务管理列表
     *
     * @param systemDelete 任务管理
     * @return 任务管理
     */
    @Override
    public List<SystemDelete> selectSystemDeleteList(SystemDelete systemDelete) {
        List<SystemDelete> list = systemDeleteMapper.selectSystemDeleteList(systemDelete);
        List<SystemDelete> deptTrees = buildSystemTaskTree(list);
        return deptTrees.stream().map(SystemDelete::new).collect(Collectors.toList());
    }

    public List<SystemDelete> buildSystemTaskTree(List<SystemDelete> taskList) {
        List<SystemDelete> returnList = new ArrayList<SystemDelete>();
        List<String> tempList = new ArrayList<String>();
        for (SystemDelete delete : taskList) {
            tempList.add(delete.getTaskNumber());
        }
        for (SystemDelete task : taskList) {
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

    private void recursionFn(List<SystemDelete> list, SystemDelete t) {
        // 得到子节点列表
        List<SystemDelete> childList = getChildList(list, t);
        t.setChildren(childList);
        for (SystemDelete tChild : childList) {
            if (hasChild(list, tChild)) {
                recursionFn(list, tChild);
            }
        }
    }

    /**
     * 得到子节点列表
     */
    private List<SystemDelete> getChildList(List<SystemDelete> list, SystemDelete t) {
        List<SystemDelete> tlist = new ArrayList<SystemDelete>();
        Iterator<SystemDelete> it = list.iterator();
        while (it.hasNext()) {
            SystemDelete n = (SystemDelete) it.next();
            if (StringUtils.isNotEmpty(n.getParentNumber()) && n.getParentNumber().equals(t.getTaskNumber())) {
                tlist.add(n);
            }
        }
        return tlist;
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<SystemDelete> list, SystemDelete t) {
        return getChildList(list, t).size() > 0;
    }


    /**
     * 新增任务管理
     *
     * @param systemDelete 任务管理
     * @return 结果
     */
    @Override
    public int insertSystemDelete(SystemDelete systemDelete) {
//        systemDelete.setCreateTime(DateUtils.getNowDate());
        return systemDeleteMapper.insertSystemDelete(systemDelete);
    }

    /**
     * 修改任务管理
     *
     * @param systemDelete 任务管理
     * @return 结果
     */
    @Override
    public int updateSystemDelete(SystemDelete systemDelete) {
        return systemDeleteMapper.updateSystemDelete(systemDelete);
    }

    /**
     * 批量删除任务管理
     *
     * @param taskNumbers 需要删除的任务管理主键
     * @return 结果
     */
    @Override
    public int deleteSystemDeleteByTaskNumbers(String[] taskNumbers) {
        return systemDeleteMapper.deleteSystemDeleteByTaskNumbers(taskNumbers);
    }

    /**
     * 删除任务管理信息
     *
     * @param taskNumber 任务管理主键
     * @return 结果
     */
    @Override
    public int deleteSystemDeleteByTaskNumber(String taskNumber) {
        return systemDeleteMapper.deleteSystemDeleteByTaskNumber(taskNumber);
    }
}
