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
package com.mybatisX.mapper;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.session.RowBounds;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Mapper 继承该接口后，无需编写 mapper.xml 文件，即可获得CRUD功能
 * </p>
 * <p>
 * 这个 Mapper 支持 id 泛型
 * </p>
 * 
 * @author hubin
 * @Date 2016-01-23
 */
public interface BaseMapper<T> {

	/**
	 * <p>
	 * 插入一条记录
	 * </p>
	 * 
	 * @param entity
	 *            实体对象
	 * @return int
	 */
	int insert(T entity);

	/**
	 * <p>
	 * 执行 SQL 插入
	 * </p>
	 * 
	 * @param sql
	 *            SQL语句
	 * @return
	 */
	@InsertProvider(type = PureSqlProvider.class, method = "sql")
	int insertSql(String sql);

	/**
	 * <p>
	 * 根据 ID 删除
	 * </p>
	 * 
	 * @param id
	 *            主键ID
	 * @return int
	 */
	int deleteById(Serializable id);

	/**
	 * <p>
	 * 根据 columnMap 条件，删除记录
	 * </p>
	 * 
	 * @param columnMap
	 *            表字段 map 对象
	 * @return int
	 */
	int deleteByMap(@Param("cm") Map<String, Object> columnMap);

	/**
	 * <p>
	 * 根据 entity 条件，删除记录
	 * </p>
	 * 
	 * @param wrapper
	 *            实体对象封装操作类（可以为 null）
	 * @return int
	 */
	int delete(@Param("ew") Wrapper<T> wrapper);

	/**
	 * <p>
	 * 删除（根据ID 批量删除）
	 * </p>
	 * 
	 * @param idList
	 *            主键ID列表
	 * @return int
	 */
	int deleteBatchIds(List<? extends Serializable> idList);

	/**
	 * <p>
	 * 执行 SQL 删除
	 * </p>
	 * 
	 * @param sql
	 *            SQL语句
	 * @return
	 */
	@DeleteProvider(type = PureSqlProvider.class, method = "sql")
	int deleteSql(String sql);

	/**
	 * <p>
	 * 根据 ID 修改
	 * </p>
	 * 
	 * @param entity
	 *            实体对象
	 * @return int
	 */
	int updateById(T entity);

	/**
	 * <p>
	 * 根据 whereEntity 条件，更新记录
	 * </p>
	 * 
	 * @param entity
	 *            实体对象
	 * @param wrapper
	 *            实体对象封装操作类（可以为 null）
	 * @return
	 */
	int update(@Param("et") T entity, @Param("ew") Wrapper<T> wrapper);

	/**
	 * <p>
	 * 执行 SQL 更新
	 * </p>
	 * 
	 * @param sql
	 *            SQL语句
	 * @return
	 */
	@UpdateProvider(type = PureSqlProvider.class, method = "sql")
	int updateSql(String sql);

	/**
	 * <p>
	 * 根据 ID 查询
	 * </p>
	 * 
	 * @param id
	 *            主键ID
	 * @return T
	 */
	T selectById(Serializable id);

	/**
	 * <p>
	 * 查询（根据ID 批量查询）
	 * </p>
	 * 
	 * @param idList
	 *            主键ID列表
	 * @return List<T>
	 */
	List<T> selectBatchIds(List<? extends Serializable> idList);

	/**
	 * <p>
	 * 查询（根据 columnMap 条件）
	 * </p>
	 * 
	 * @param columnMap
	 *            表字段 map 对象
	 * @return List<T>
	 */
	List<T> selectByMap(@Param("cm") Map<String, Object> columnMap);

	/**
	 * <p>
	 * 根据 entity 条件，查询一条记录
	 * </p>
	 * 
	 * @param entity
	 *            实体对象
	 * @return T
	 */
	T selectOne(@Param("ew") T entity);

	/**
	 * <p>
	 * 根据 Wrapper 条件，查询总记录数
	 * </p>
	 * 
	 * @param wrapper
	 *            实体对象
	 * @return int
	 */
	int selectCount(@Param("ew") Wrapper<T> wrapper);

	/**
	 * <p>
	 * 根据 entity 条件，查询全部记录
	 * </p>
	 * 
	 * @param wrapper
	 *            实体对象封装操作类（可以为 null）
	 * @return List<T>
	 */
	List<T> selectList(@Param("ew") Wrapper<T> wrapper);

	/**
	 * <p>
	 * 执行 SQL 查询，查询全部记录
	 * </p>
	 * 
	 * @param sql
	 *            SQL语句
	 * @return
	 */
	@SelectProvider(type = PureSqlProvider.class, method = "sql")
	List<Map<String, Object>> selectListSql(String sql);

	/**
	 * <p>
	 * 根据 entity 条件，查询全部记录（并翻页）
	 * </p>
	 * 
	 * @param rowBounds
	 *            分页查询条件（可以为 RowBounds.DEFAULT）
	 * @param wrapper
	 *            实体对象封装操作类（可以为 null）
	 * @return List<T>
	 */
	List<T> selectPage(RowBounds rowBounds, @Param("ew") Wrapper<T> wrapper);

	/**
	 * <p>
	 * 执行 SQL 查询，查询全部记录（并翻页）
	 * </p>
	 * 
	 * @param sql
	 *            SQL语句
	 * @return
	 */
	@SelectProvider(type = PureSqlProvider.class, method = "sql")
	List<Map<String, Object>> selectPageSql(RowBounds rowBounds, String sql);

}
