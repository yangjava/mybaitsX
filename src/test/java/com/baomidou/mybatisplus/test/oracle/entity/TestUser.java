package com.baomidou.mybatisplus.test.oracle.entity;

import java.io.Serializable;

import com.mybatisX.annotations.IdType;
import com.mybatisX.annotations.PK;
import com.mybatisX.annotations.TableField;
import com.mybatisX.annotations.TableName;

/**
 *
 * 用户表
 *
 */
@TableName("TEST_USER")
public class TestUser implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 主键ID */
	@PK(value = "TEST_ID", type = IdType.UUID)
	private String testId;

	/** 名称 */
	private String name;

	/** 年龄 */
	private Integer age;

	/** 测试下划线字段命名类型 */
	@TableField(value = "TEST_TYPE")
	private Integer testType;


	public TestUser( String testId, String name, Integer age, Integer testType ) {
		this.testId = testId;
		this.name = name;
		this.age = age;
		this.testType = testType;
	}
	
	
	public TestUser( String name, Integer age, Integer testType ) {
		this.name = name;
		this.age = age;
		this.testType = testType;
	}
	
	
	public TestUser( Integer testType ) {
		this.testType = testType;
	}


	public TestUser() {

	}


	public String getTestId() {
		return this.testId;
	}


	public void setTestId( String testId ) {
		this.testId = testId;
	}


	public String getName() {
		return this.name;
	}


	public void setName( String name ) {
		this.name = name;
	}


	public Integer getAge() {
		return this.age;
	}


	public void setAge( Integer age ) {
		this.age = age;
	}


	public Integer getTestType() {
		return this.testType;
	}


	public void setTestType( Integer testType ) {
		this.testType = testType;
	}

}
