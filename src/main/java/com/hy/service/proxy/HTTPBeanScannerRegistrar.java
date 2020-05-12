package com.hy.service.proxy;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.hy.annotation.HTTPBearScanner;
import com.hy.util.RegistrarBean;

/**  
* HTTPBeanScannerRegistrar
* Creater by chenhaiyang on 2020年5月12日
*/
public class HTTPBeanScannerRegistrar  implements ImportBeanDefinitionRegistrar {

	@Override
	    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
	        RegistrarBean.registrar(importingClassMetadata, registry, HTTPBearScanner.class,HTTPBeanFactoryBean.class);
	    }
}
