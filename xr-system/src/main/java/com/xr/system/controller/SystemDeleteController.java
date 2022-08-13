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
import com.xr.system.domain.SystemDelete;
import com.xr.system.service.ISystemDeleteService;
import com.xr.common.utils.poi.ExcelUtil;
import com.xr.common.core.page.TableDataInfo;

/**
 * 任务管理Controller
 *
 * @author xr
 * @date 2022-08-12
 */
@RestController
@RequestMapping("/system/delete")
public class SystemDeleteController extends BaseController {
    @Autowired
    private ISystemDeleteService systemDeleteService;

    /**
     * 查询任务管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:delete:list')")
    @GetMapping("/list")
    public TableDataInfo list(SystemDelete systemDelete) {
        startPage();
        List<SystemDelete> list = systemDeleteService.selectSystemDeleteList(systemDelete);
        return getDataTable(list);
    }

    /**
     * 导出任务管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:delete:export')")
    @Log(title = "任务管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SystemDelete systemDelete) {
        List<SystemDelete> list = systemDeleteService.selectSystemDeleteList(systemDelete);
        ExcelUtil<SystemDelete> util = new ExcelUtil<SystemDelete>(SystemDelete.class);
        util.exportExcel(response, list, "任务管理数据");
    }

    /**
     * 获取任务管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:delete:query')")
    @GetMapping(value = "/{taskNumber}")
    public AjaxResult getInfo(@PathVariable("taskNumber") String taskNumber) {
        return AjaxResult.success(systemDeleteService.selectSystemDeleteByTaskNumber(taskNumber));
    }

    /**
     * 新增任务管理
     */
    @PreAuthorize("@ss.hasPermi('system:delete:add')")
    @Log(title = "任务管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SystemDelete systemDelete) {
        return toAjax(systemDeleteService.insertSystemDelete(systemDelete));
    }

    /**
     * 修改任务管理
     */
    @PreAuthorize("@ss.hasPermi('system:delete:edit')")
    @Log(title = "任务管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SystemDelete systemDelete) {
        return toAjax(systemDeleteService.updateSystemDelete(systemDelete));
    }

    /**
     * 删除任务管理
     */
    @PreAuthorize("@ss.hasPermi('system:delete:remove')")
    @Log(title = "任务管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{taskNumbers}")
    public AjaxResult remove(@PathVariable String[] taskNumbers) {
        return toAjax(systemDeleteService.deleteSystemDeleteByTaskNumbers(taskNumbers));
    }
}
