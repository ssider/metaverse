package com.xr.web.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xr.common.config.XRConfig;
import com.xr.common.utils.StringUtils;

/**
 * 首页
 *
 * @author xr
 */
@RestController
public class SysIndexController {
    /**
     * 系统基础配置
     */
    @Autowired
    private XRConfig XRConfig;

    /**
     * 访问首页，提示语
     */
    @RequestMapping("/")
    public String index() {
        return StringUtils.format("欢迎使用{}后台管理系统。", XRConfig.getName());
    }
}
