package com.xr.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xr.common.annotation.Excel;
import com.xr.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 任务管理对象 task_manage
 *
 * @author xr
 * @date 2022-08-09
 */
public class TaskManage extends BaseEntity {
    private static final long serialVersionUID = 1L;

    public TaskManage() {
    }

    /**
     * 任务ID
     */
    private String taskNumber;

    /**
     * 父任务ID
     */
    @Excel(name = "父任务ID")
    private String parentNumber;

    /**
     * 项目名称
     */
    @Excel(name = "项目名称", readConverterExp = "$column.readConverterExp()")
    private String projectName;

    /**
     * 项目信息
     */
    @Excel(name = "项目信息", readConverterExp = "$column.readConverterExp()")
    private String projectInfomation;

    /**
     * 任务名称
     */
    @Excel(name = "任务名称", readConverterExp = "$column.readConverterExp()")
    private String taskName;

    /**
     * 源系统
     */
    @Excel(name = "源系统", readConverterExp = "$column.readConverterExp()")
    private String sourceSystem;

    /**
     * $column.columnComment
     */
    @Excel(name = "源路径", readConverterExp = "$column.readConverterExp()")
    private String sourcePath;

    /**
     * 目标系统
     */
    @Excel(name = "目标系统", readConverterExp = "$column.readConverterExp()")
    private String targetSystem;

    /**
     * 任务处理进程
     */
    @Excel(name = "任务处理进程", readConverterExp = "$column.readConverterExp()")
    private Long taskProcess;

    /**
     * 任务状态
     */
    @Excel(name = "0process,1pause,2completed,3canceled")
    private String taskStatus;

    /**
     * 数据源
     */
    @Excel(name = "数据源", readConverterExp = "$column.readConverterExp()")
    private String dataSource;

    /**
     * 任务内容
     */
    @Excel(name = "任务内容", readConverterExp = "$column.readConverterExp()")
    private String taskContent;

    /**
     * unreal任务
     */
    @Excel(name = "unreal任务", readConverterExp = "$column.readConverterExp()")
    private String unrealTask;

    /**
     * 详情百分比
     */
    @Excel(name = "详情百分比")
    private String levelDetail;

    /**
     * 图片源
     */
    @Excel(name = "图片源", readConverterExp = "$column.readConverterExp()")
    private String view;

    /**
     * 修改时间
     */
    @Excel(name = "修改时间", readConverterExp = "$column.readConverterExp()")
    private Date modifyTime;
    /**
     * 创建时间
     */
    @Excel(name = "创建时间", readConverterExp = "$column.readConverterExp()")
    private Date createTime;

    /**
     * 子部门
     */
    private List<TaskManage> children = new ArrayList<TaskManage>();

    public TaskManage(TaskManage manage) {
        this.taskNumber = manage.taskNumber;
        this.parentNumber = manage.parentNumber;
        this.projectName = manage.projectName;
        this.projectInfomation = manage.projectInfomation;
        this.taskName = manage.taskName;
        this.sourceSystem = manage.sourceSystem;
        this.sourcePath = manage.sourcePath;
        this.targetSystem = manage.targetSystem;
        this.taskProcess = manage.taskProcess;
        this.taskStatus = manage.taskStatus;
        this.dataSource = manage.dataSource;
        this.taskContent = manage.taskContent;
        this.unrealTask = manage.unrealTask;
        this.levelDetail = manage.levelDetail;
        this.view = manage.view;
        this.modifyTime = manage.modifyTime;
        this.createTime = manage.createTime;
        this.children = manage.getChildren().stream().map(TaskManage::new).collect(Collectors.toList());
    }

    public void setTaskNumber(String taskNumber) {
        this.taskNumber = taskNumber;
    }

    public String getTaskNumber() {
        return taskNumber;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setParentNumber(String parentNumber) {
        this.parentNumber = parentNumber;
    }

    public String getParentNumber() {
        return parentNumber;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectInfomation(String projectInfomation) {
        this.projectInfomation = projectInfomation;
    }

    public String getProjectInfomation() {
        return projectInfomation;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public void setTargetSystem(String targetSystem) {
        this.targetSystem = targetSystem;
    }

    public String getTargetSystem() {
        return targetSystem;
    }

    public void setTaskProcess(Long taskProcess) {
        this.taskProcess = taskProcess;
    }

    public Long getTaskProcess() {
        return taskProcess;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setUnrealTask(String unrealTask) {
        this.unrealTask = unrealTask;
    }

    public String getUnrealTask() {
        return unrealTask;
    }

    public void setLevelDetail(String levelDetail) {
        this.levelDetail = levelDetail;
    }

    public String getLevelDetail() {
        return levelDetail;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getView() {
        return view;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public List<TaskManage> getChildren() {
        return children;
    }

    public void setChildren(List<TaskManage> children) {
        this.children = children;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("taskNumber", getTaskNumber())
                .append("parentNumber", getParentNumber())
                .append("projectName", getProjectName())
                .append("projectInfomation", getProjectInfomation())
                .append("taskName", getTaskName())
                .append("sourceSystem", getSourceSystem())
                .append("sourcePath", getSourcePath())
                .append("targetSystem", getTargetSystem())
                .append("taskProcess", getTaskProcess())
                .append("taskStatus", getTaskStatus())
                .append("dataSource", getDataSource())
                .append("taskContent", getTaskContent())
                .append("unrealTask", getUnrealTask())
                .append("levelDetail", getLevelDetail())
                .append("view", getView())
                .append("createTime", getCreateTime())
                .append("modifyTime", getModifyTime())
                .toString();
    }
}
