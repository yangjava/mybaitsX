
package com.mybatisX.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * 表主键标识
 * </p>
 * 
 * @author 杨京京
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface PK {

	/*
	 * <p>
	 * 字段值（驼峰命名方式，该值可无）
	 * </p>
	 */
	String value() default "";

	/*
	 * <p>
	 * 主键ID，默认 ID 自增
	 * </p>
	 * {@link IdType}
	 */
	IdType type() default IdType.ID_WORKER;
}
