package com.xr.system.mapper;

import java.util.List;
import com.xr.system.domain.SystemDelete;

/**
 * 任务管理Mapper接口
 * 
 * @author xr
 * @date 2022-08-12
 */
public interface SystemDeleteMapper 
{
    /**
     * 查询任务管理
     * 
     * @param taskNumber 任务管理主键
     * @return 任务管理
     */
    public SystemDelete selectSystemDeleteByTaskNumber(String taskNumber);

    /**
     * 查询任务管理列表
     * 
     * @param systemDelete 任务管理
     * @return 任务管理集合
     */
    public List<SystemDelete> selectSystemDeleteList(SystemDelete systemDelete);

    /**
     * 新增任务管理
     * 
     * @param systemDelete 任务管理
     * @return 结果
     */
    public int insertSystemDelete(SystemDelete systemDelete);

    /**
     * 修改任务管理
     * 
     * @param systemDelete 任务管理
     * @return 结果
     */
    public int updateSystemDelete(SystemDelete systemDelete);

    /**
     * 删除任务管理
     * 
     * @param taskNumber 任务管理主键
     * @return 结果
     */
    public int deleteSystemDeleteByTaskNumber(String taskNumber);

    /**
     * 批量删除任务管理
     * 
     * @param taskNumbers 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSystemDeleteByTaskNumbers(String[] taskNumbers);
}
