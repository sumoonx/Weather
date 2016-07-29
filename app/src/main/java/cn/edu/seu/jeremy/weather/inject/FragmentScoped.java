package cn.edu.seu.jeremy.weather.inject;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Author: Jeremy Xu on 2016/7/29 10:35
 * E-mail: jeremy_xm@163.com
 */
@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface FragmentScoped {
}