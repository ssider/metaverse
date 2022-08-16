package com.xr.system.domain.vo;

import com.xr.common.annotation.Excel;

public class TaskNumber {
    /**
     * 任务id
     */
    @Excel(name = "任务id")
    private String taskNumber;

    public String getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(String taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public String toString() {
        return "TaskNumber{" +
                "taskNumber='" + taskNumber + '\'' +
                '}';
    }
}
