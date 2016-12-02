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
package com.mybatisX.plugins.pagination;



import static com.mybatisX.mapper.DBType.DB2;
import static com.mybatisX.mapper.DBType.H2;
import static com.mybatisX.mapper.DBType.HSQL;
import static com.mybatisX.mapper.DBType.MYSQL;
import static com.mybatisX.mapper.DBType.ORACLE;
import static com.mybatisX.mapper.DBType.POSTGRE;
import static com.mybatisX.mapper.DBType.SQLITE;
import static com.mybatisX.mapper.DBType.SQLSERVER;
import static com.mybatisX.mapper.DBType.SQLSERVER2005;

import com.mybatisX.exceptions.MybatisXException;
import com.mybatisX.plugins.pagination.dialects.DB2Dialect;
import com.mybatisX.plugins.pagination.dialects.H2Dialect;
import com.mybatisX.plugins.pagination.dialects.HSQLDialect;
import com.mybatisX.plugins.pagination.dialects.MySqlDialect;
import com.mybatisX.plugins.pagination.dialects.OracleDialect;
import com.mybatisX.plugins.pagination.dialects.PostgreDialect;
import com.mybatisX.plugins.pagination.dialects.SQLServer2005Dialect;
import com.mybatisX.plugins.pagination.dialects.SQLServerDialect;
import com.mybatisX.plugins.pagination.dialects.SQLiteDialect;

/**
 * <p>
 * 分页方言工厂类
 * </p>
 * 
 * @author hubin
 * @Date 2016-01-23
 */
public class DialectFactory {

	/**
	 * <p>
	 * 根据数据库类型选择不同分页方言
	 * </p>
	 * 
	 * @param dbtype
	 *            数据库类型
	 * @return
	 * @throws Exception
	 */
	public static IDialect getDialectByDbtype(String dbtype) throws Exception {
		if (MYSQL.getDb().equalsIgnoreCase(dbtype)) {
			return new MySqlDialect();
		} else if (ORACLE.getDb().equalsIgnoreCase(dbtype)) {
			return new OracleDialect();
		} else if (DB2.getDb().equalsIgnoreCase(dbtype)) {
			return new DB2Dialect();
		} else if (H2.getDb().equalsIgnoreCase(dbtype)) {
			return new H2Dialect();
		} else if (SQLSERVER.getDb().equalsIgnoreCase(dbtype)) {
			return new SQLServerDialect();
		} else if (SQLSERVER2005.getDb().equalsIgnoreCase(dbtype)) {
			return new SQLServer2005Dialect();
		} else if (POSTGRE.getDb().equalsIgnoreCase(dbtype)) {
			return new PostgreDialect();
		} else if (HSQL.getDb().equalsIgnoreCase(dbtype)) {
			return new HSQLDialect();
		} else if (SQLITE.getDb().equalsIgnoreCase(dbtype)) {
			return new SQLiteDialect();
		} else {
			throw new MybatisXException("The database is not supported！dbtype:" + dbtype);
		}
	}

}
