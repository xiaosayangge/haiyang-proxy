package com.hy.proxy.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import org.springframework.beans.factory.FactoryBean;

import com.hy.annotation.Sql;

/**  
* CodeBeanFactoryBean
* Creater by chenhaiyang on 2020年5月11日
*/
public class CodeBeanFactoryBean<T> implements FactoryBean<T>, InvocationHandler {
    private Class<T> clazz;

    public CodeBeanFactoryBean(Class<T> clazz) {
        this.clazz = clazz;
        
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    	Sql annotation = method.getAnnotation(Sql.class);
    	String value = annotation.value();
    	System.out.println(value);
    	return value;
    }

    @Override
    public T getObject() throws Exception {
    	return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{clazz}, this);
    }

    @Override
    public Class<T> getObjectType() {
        return clazz;
    }
}
