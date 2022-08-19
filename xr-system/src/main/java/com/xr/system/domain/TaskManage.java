package com.xr.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.xr.common.annotation.Excel;
import com.xr.common.core.domain.BaseEntity;

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
     * 详情百分比A
     */
    @Excel(name = "详情百分比A")
    private Long levelDetailA;

    /**
     * 详情百分比B
     */
    @Excel(name = "详情百分比B")
    private Long levelDetailB;

    /**
     * 详情百分比C
     */
    @Excel(name = "详情百分比C")
    private Long levelDetailC;

    /**
     * 图片源
     */
    @Excel(name = "图片源")
    private String images;

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
        this.levelDetailA = manage.levelDetailA;
        this.levelDetailB = manage.levelDetailB;
        this.levelDetailC = manage.levelDetailC;
        this.images = manage.images;
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

    public void setLevelDetailA(Long levelDetailA) {
        this.levelDetailA = levelDetailA;
    }

    public Long getLevelDetailA() {
        return levelDetailA;
    }

    public void setLevelDetailB(Long levelDetailB) {
        this.levelDetailB = levelDetailB;
    }

    public Long getLevelDetailB() {
        return levelDetailB;
    }

    public void setLevelDetailC(Long levelDetailC) {
        this.levelDetailC = levelDetailC;
    }

    public Long getLevelDetailC() {
        return levelDetailC;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getImages() {
        return images;
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
        return "TaskManage{" +
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
                ", levelDetailA=" + levelDetailA +
                ", levelDetailB=" + levelDetailB +
                ", levelDetailC=" + levelDetailC +
                ", images='" + images + '\'' +
                ", modifyTime=" + modifyTime +
                ", createTime=" + createTime +
                ", children=" + children +
                '}';
    }
}
