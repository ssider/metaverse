package com.xr.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xr.common.annotation.Excel;
import com.xr.common.core.domain.BaseEntity;

/**
 * 任务管理对象 system_delete
 *
 * @author xr
 * @date 2022-08-12
 */
public class SystemDelete extends BaseEntity {
    private static final long serialVersionUID = 1L;

    public SystemDelete() {
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
    @Excel(name = "项目名称")
    private String projectName;

    /**
     * 项目信息
     */
    @Excel(name = "项目信息")
    private String projectInfomation;

    /**
     * 任务名称
     */
    @Excel(name = "任务名称")
    private String taskName;

    /**
     * 源系统
     */
    @Excel(name = "源系统")
    private String sourceSystem;

    /**
     * 源路径
     */
    @Excel(name = "源路径")
    private String sourcePath;

    /**
     * 目标系统
     */
    @Excel(name = "目标系统")
    private String targetSystem;

    /**
     * 任务处理进程
     */
    @Excel(name = "任务处理进程")
    private Long taskProcess;

    /**
     * 任务状态,0process,1pause,2completed,3canceled
     */
    @Excel(name = "任务状态,0process,1pause,2completed,3canceled")
    private String taskStatus;

    /**
     * 数据源
     */
    @Excel(name = "数据源")
    private String dataSource;

    /**
     * 任务内容
     */
    @Excel(name = "任务内容")
    private String taskContent;

    /**
     * unreal任务
     */
    @Excel(name = "unreal任务")
    private String unrealTask;

    /**
     * 详情百分比
     */
    @Excel(name = "详情百分比")
    private Long levelDetail;

    /**
     * 图片源
     */
    @Excel(name = "图片源")
    private String view;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifyTime;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createTime;

    /**
     * 子部门
     */
    private List<SystemDelete> children = new ArrayList<SystemDelete>();

    public SystemDelete(SystemDelete systemDelete) {
        this.taskNumber = systemDelete.taskNumber;
        this.parentNumber = systemDelete.parentNumber;
        this.projectName = systemDelete.projectName;
        this.projectInfomation = systemDelete.projectInfomation;
        this.taskName = systemDelete.taskName;
        this.sourceSystem = systemDelete.sourceSystem;
        this.sourcePath = systemDelete.sourcePath;
        this.targetSystem = systemDelete.targetSystem;
        this.taskProcess = systemDelete.taskProcess;
        this.taskStatus = systemDelete.taskStatus;
        this.dataSource = systemDelete.dataSource;
        this.taskContent = systemDelete.taskContent;
        this.unrealTask = systemDelete.unrealTask;
        this.levelDetail = systemDelete.levelDetail;
        this.view = systemDelete.view;
        this.modifyTime = systemDelete.modifyTime;
        this.createTime = systemDelete.createTime;
        this.children = systemDelete.getChildren().stream().map(SystemDelete::new).collect(Collectors.toList());
    }

    public void setTaskNumber(String taskNumber) {
        this.taskNumber = taskNumber;
    }

    public String getTaskNumber() {
        return taskNumber;
    }

    public void setParentNumber(String parentNumber) {
        this.parentNumber = parentNumber;
    }

    public String getParentNumber() {
        return parentNumber;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
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

    public void setLevelDetail(Long levelDetail) {
        this.levelDetail = levelDetail;
    }

    public Long getLevelDetail() {
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

    public Date getCreatetime() {
        return createTime;
    }

    public void setCreatetime(Date createtime) {
        this.createTime = createtime;
    }

    public List<SystemDelete> getChildren() {
        return children;
    }

    public void setChildren(List<SystemDelete> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "SystemDelete{" +
                "taskNumber='" + taskNumber + '\'' +
                ", parentNumber='" + parentNumber + '\'' +
                ", projectName='" + projectName + '\'' +
                ", projectInfomation='" + projectInfomation + '\'' +
                ", taskName='" + taskName + '\'' +
                ", sourceSystem='" + sourceSystem + '\'' +
                ", sourcePath='" + sourcePath + '\'' +
                ", targetSystem='" + targetSystem + '\'' +
                ", taskProcess=" + taskProcess +
                ", taskStatus='" + taskStatus + '\'' +
                ", dataSource='" + dataSource + '\'' +
                ", taskContent='" + taskContent + '\'' +
                ", unrealTask='" + unrealTask + '\'' +
                ", levelDetail=" + levelDetail +
                ", view='" + view + '\'' +
                ", createTime='" + createTime + '\'' +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
