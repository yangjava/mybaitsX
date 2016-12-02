/**
 * Copyright (c) 2011-2020, hubin (jobob@qq.com).
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
package com.mybatisX.test.mysql;

import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.session.Configuration;

import com.mybatisX.mapper.AutoSqlInjector;
import com.mybatisX.toolkit.TableInfo;

/**
 * <p>
 * 测试自定义注入 SQL
 * </p>
 * 
 * @author hubin
 * @Date 2016-07-23
 */
public class MySqlInjector extends AutoSqlInjector {

	@Override
	public void inject(Configuration configuration, MapperBuilderAssistant builderAssistant, Class<?> mapperClass,
			Class<?> modelClass, TableInfo table) {
		/* 添加一个自定义方法 */
		deleteAllUser(mapperClass, modelClass, table);
	}

	public void deleteAllUser(Class<?> mapperClass, Class<?> modelClass, TableInfo table) {

		/* 执行 SQL ，动态 SQL 参考类 SqlMethod */
		String sql = "delete from " + table.getTableName();

		/* mapper 接口方法名一致 */
		String method = "deleteAll";
		SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
		this.addDeleteMappedStatement(mapperClass, method, sqlSource);
	}

}
