package com.mybatisX.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * 数据库表相关
 * </p>
 * 
 * @author 杨京京
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TableName {

	/*
	 * <p>
	 * 实体对应的表名
	 * </p>
	 */
	String value() default "";

	/*
	 * <p>
	 * 实体映射结果集
	 * </p>
	 */
	String resultMap() default "";
}