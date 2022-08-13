package com.xr.system.mapper;

import java.util.List;

import com.xr.system.domain.TaskManage;

/**
 * 任务管理Mapper接口
 *
 * @author xr
 * @date 2022-08-09
 */
public interface TaskManageMapper {
    /**
     * 查询任务管理
     *
     * @param taskNumber 任务管理主键
     * @return 任务管理
     */
    public TaskManage selectTaskManageByTaskNumber(String taskNumber);

    /**
     * 查询任务管理列表
     *
     * @param taskManage 任务管理
     * @return 任务管理集合
     */
    public List<TaskManage> selectTaskManageList(TaskManage taskManage);

    /**
     * 新增任务管理
     *
     * @param taskManage 任务管理
     * @return 结果
     */
    public int insertTaskManage(TaskManage taskManage);

    /**
     * 修改任务管理
     *
     * @param taskManage 任务管理
     * @return 结果
     */
    public int updateTaskManage(TaskManage taskManage);

    /**
     * 删除任务管理
     *
     * @param taskNumber 任务管理主键
     * @return 结果
     */
    public int deleteTaskManageByTaskNumber(String taskNumber);

    /**
     * 批量删除任务管理
     *
     * @param taskNumbers 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTaskManageByTaskNumbers(String[] taskNumbers);

    /**
     * 查询子任务数量
     *
     * @param parentNumber 父任务主键
     * @return 结果
     */
    public int selectCountTaskManageByParentNumber(String parentNumber);

    /**
     * 删除子任务数量
     *
     * @param parentNumber 父任务主键
     * @return 结果
     */
    public int deleteTaskManageByParentNumber(String parentNumber);
}
