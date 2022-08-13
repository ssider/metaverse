package com.xr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 *
 * @author xr
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class XRApplication {
    public static void main(String[] args) {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(XRApplication.class, args);
        System.out.println("==== launch successful ====\n");
    }
}
