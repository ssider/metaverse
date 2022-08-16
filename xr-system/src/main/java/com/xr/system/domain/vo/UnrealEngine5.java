package com.xr.system.domain.vo;

import com.xr.common.annotation.Excel;

public class UnrealEngine5 {

    /**
     * 对象路径
     */
    @Excel(name = "对象路径")
    private String objectPath;

    /**
     * 函数名
     */
    @Excel(name = "函数名")
    private String functionName;
    /**
     * 任务id
     */
    @Excel(name = "任务id")
    private TaskNumber parameters;
    /**
     * 文件名
     */
    @Excel(name = "文件名")
    private String fileName;
    /**
     * 文件路径
     */
    @Excel(name = "文件路径")
    private String filePath;
    /**
     * 百分比
     */
    @Excel(name = "百分比")
    private String detailLevel;
    /**
     * 生成交易
     */
    @Excel(name = "生成交易")
    private Boolean generateTransaction;

    public String getObjectPath() {
        return objectPath;
    }

    public void setObjectPath(String objectPath) {
        this.objectPath = objectPath;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public TaskNumber getParameters() {
        return parameters;
    }

    public void setParameters(TaskNumber parameters) {
        this.parameters = parameters;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getDetailLevel() {
        return detailLevel;
    }

    public void setDetailLevel(String detailLevel) {
        this.detailLevel = detailLevel;
    }

    public Boolean getGenerateTransaction() {
        return generateTransaction;
    }

    public void setGenerateTransaction(Boolean generateTransaction) {
        this.generateTransaction = generateTransaction;
    }

    @Override
    public String toString() {
        return "UnrealEngine5{" +
                "objectPath='" + objectPath + '\'' +
                ", functionName='" + functionName + '\'' +
                ", parameters=" + parameters +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", detailLevel='" + detailLevel + '\'' +
                ", generateTransaction=" + generateTransaction +
                '}';
    }
}
