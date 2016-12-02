/**
 * Copyright (c) 2011-2014, hubin (jobob@qq.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.mybatisX.core;

import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;

import org.apache.ibatis.exceptions.ExceptionFactory;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatisX.annotations.FieldStrategy;
import com.mybatisX.mapper.DBType;
import com.mybatisX.mapper.IMetaObjectHandler;
import com.mybatisX.mapper.ISqlInjector;
import com.mybatisX.toolkit.IOUtils;

/**
 * <p>
 * replace default SqlSessionFactoryBuilder class
 * </p>
 * 
 * @author hubin
 * @Date 2016-01-23
 */
public class MybatisSessionFactoryBuilder extends SqlSessionFactoryBuilder {

	@Override
	public SqlSessionFactory build(Reader reader, String environment, Properties properties) {
		try {
			MybatisXMLConfigBuilder parser = new MybatisXMLConfigBuilder(reader, environment, properties);
			return build(parser.parse());
		} catch (Exception e) {
			throw ExceptionFactory.wrapException("Error building SqlSession.", e);
		} finally {
			ErrorContext.instance().reset();
			IOUtils.closeQuietly(reader);
		}
	}

	@Override
	public SqlSessionFactory build(InputStream inputStream, String environment, Properties properties) {
		try {
			MybatisXMLConfigBuilder parser = new MybatisXMLConfigBuilder(inputStream, environment, properties);
			return build(parser.parse());
		} catch (Exception e) {
			throw ExceptionFactory.wrapException("Error building SqlSession.", e);
		} finally {
			ErrorContext.instance().reset();
			IOUtils.closeQuietly(inputStream);
		}
	}

	// TODO 注入数据库类型
	public void setDbType(String dbType) {
		MybatisConfiguration.DB_TYPE = DBType.getDBType(dbType);
	}

	// TODO 注入表字段使用下划线命名
	public void setDbColumnUnderline(boolean dbColumnUnderline) {
		MybatisConfiguration.DB_COLUMN_UNDERLINE = dbColumnUnderline;
	}

	// TODO 注入 SQL注入器
	public void setSqlInjector(ISqlInjector sqlInjector) {
		MybatisConfiguration.SQL_INJECTOR = sqlInjector;
	}

	// TODO 注入 元对象字段填充控制器
	public void setMetaObjectHandler(IMetaObjectHandler metaObjectHandler) {
		MybatisConfiguration.META_OBJECT_HANDLER = metaObjectHandler;
	}

	// TODO 注入 元对象字段填充控制器
	public void setFieldStrategy(int key) {
		MybatisConfiguration.FIELD_STRATEGY = FieldStrategy.getFieldStrategy(key);
	}

}
