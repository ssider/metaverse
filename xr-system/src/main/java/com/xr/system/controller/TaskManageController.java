package com.xr.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xr.common.annotation.Log;
import com.xr.common.core.controller.BaseController;
import com.xr.common.core.domain.AjaxResult;
import com.xr.common.enums.BusinessType;
import com.xr.system.domain.TaskManage;
import com.xr.system.service.ITaskManageService;
import com.xr.common.utils.poi.ExcelUtil;
import com.xr.common.core.page.TableDataInfo;

import static com.xr.common.constant.Constants.PARENTNOTFOUND;
import static com.xr.common.constant.Constants.UNREALTASKERROR;

/**
 * 任务管理Controller
 *
 * @author xr
 * @date 2022-08-09
 */
@RestController
@RequestMapping("/system/manage")
public class TaskManageController extends BaseController {
    @Autowired
    private ITaskManageService taskManageService;

    /**
     * 查询任务管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:manage:list')")
    @GetMapping("/listinfo")
    public TableDataInfo list(TaskManage taskManage) {
        startPage();
        List<TaskManage> list = taskManageService.selectTaskManageList(taskManage);
        return getDataTable(list);
    }

    /**
     * 查询任务管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:manage:list')")
    @GetMapping("/list")
    public TableDataInfo TaskManagelist(TaskManage taskManage) {
        startPage();
        List<TaskManage> list = taskManageService.selectTaskManageList(taskManage);
        return getDataTable(list);
    }

    /**
     * 导出任务管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:manage:export')")
    @Log(title = "任务管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TaskManage taskManage) {
        List<TaskManage> list = taskManageService.selectTaskManageList(taskManage);
        ExcelUtil<TaskManage> util = new ExcelUtil<TaskManage>(TaskManage.class);
        util.exportExcel(response, list, "任务管理数据");
    }

    /**
     * 获取任务管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:manage:query')")
    @GetMapping(value = "/{taskNumber}")
    public AjaxResult getInfo(@PathVariable("taskNumber") String taskNumber) {
        return AjaxResult.success(taskManageService.selectTaskManageByTaskNumber(taskNumber));
    }

    /**
     * 新增任务管理
     */
    @PreAuthorize("@ss.hasPermi('system:manage:add')")
    @Log(title = "任务管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TaskManage taskManage) {
        int result = taskManageService.insertTaskManage(taskManage);
        if (result == PARENTNOTFOUND) {
            return error("parent task not exist, please refresh");
        } else if (result == UNREALTASKERROR) {
            return error("send and create unrealEngine5 error");
        }
        return toAjax(result);
    }

    /**
     * 修改任务管理
     */
    @PreAuthorize("@ss.hasPermi('system:manage:edit')")
    @Log(title = "任务管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TaskManage taskManage) {
        return toAjax(taskManageService.updateTaskManage(taskManage));
    }

    /**
     * 删除任务管理
     */
    @PreAuthorize("@ss.hasPermi('system:manage:remove')")
    @Log(title = "任务管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{taskNumbers}")
    public AjaxResult remove(@PathVariable String[] taskNumbers) {
        int del = taskManageService.deleteTaskManageByTaskNumbers(taskNumbers);
        if (del == UNREALTASKERROR) {
            return error("delete unrealEngine5 error");
        }
        return toAjax(del);
    }
}
