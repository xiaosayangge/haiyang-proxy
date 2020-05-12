package com.hy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**  
 * 接口上写sql
* Sql
* Creater by chenhaiyang on 2020年5月11日
*/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Sql {
    String value();
}
