package com.hy.service.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.factory.FactoryBean;

import com.hy.annotation.Sql;
import com.hy.annotation.Url;

/**  
* HTTPBeanFactoryBean
* Creater by chenhaiyang on 2020年5月12日
*/
public class HTTPBeanFactoryBean<T> implements FactoryBean<T>, InvocationHandler {
    private Class<T> clazz;

    public HTTPBeanFactoryBean(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    	if(method.getName().equals("toString")){
    		return clazz.toString();
    	}
    	Url annotation = method.getAnnotation(Url.class);
    	return annotation.value();
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