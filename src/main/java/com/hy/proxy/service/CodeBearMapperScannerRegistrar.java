package com.hy.proxy.service;

import java.io.File;
import java.util.Set;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

import com.hy.annotation.CodeBearMapperScanner;
import com.hy.util.ClassScaner;

/**  
* CodeBearMapperScannerRegistrar
* Creater by chenhaiyang on 2020年5月11日
*/
public class CodeBearMapperScannerRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        try {
            AnnotationAttributes annoAttrs =
                    AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(CodeBearMapperScanner.class.getName()));
            
            String packageValue = annoAttrs.getString("value");
            Set<Class> set= ClassScaner.scan(packageValue);
            set.forEach(aClass->{
            	if (aClass.isInterface()&&!aClass.isAnnotation()) {
                    BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition();
                    AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
                    beanDefinition.setBeanClass(CodeBeanFactoryBean.class);
                    beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(aClass.getName());
                    registry.registerBeanDefinition(aClass.getName(), beanDefinition);
                }
            });
            
        } catch (Exception ex) {
        }
    }
}
