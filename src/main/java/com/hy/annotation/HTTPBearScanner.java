package com.hy.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.context.annotation.Import;

import com.hy.service.proxy.HTTPBeanScannerRegistrar;


/**  
 * 扫描需要被代理mapper的接口
* CodeBearMapperScanner
* Creater by chenhaiyang on 2020年5月11日
*/
@Import(HTTPBeanScannerRegistrar.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface HTTPBearScanner {
    String value();
}
