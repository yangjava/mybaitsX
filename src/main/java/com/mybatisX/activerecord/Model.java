
package com.mybatisX.activerecord;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatisX.exceptions.MybatisXException;
import com.mybatisX.mapper.EntityWrapper;
import com.mybatisX.mapper.SqlMethod;
import com.mybatisX.plugins.Page;
import com.mybatisX.toolkit.CollectionUtil;
import com.mybatisX.toolkit.StringUtils;



/**
 * <p>
 * ActiveRecord 模式 CRUD
 * </p>
 * 
 * @author hubin
 * @param <T>
 * @Date 2016-11-06
 */
@SuppressWarnings({ "serial", "rawtypes" })
public abstract class Model<T extends Model> implements Serializable {

	/**
	 * <p>
	 * 插入
	 * </p>
	 */
	public boolean insert() {
		return retBool(sqlSession().insert(sqlStatement(SqlMethod.INSERT_ONE), this));
	}

	/**
	 * <p>
	 * 插入 OR 更新
	 * </p>
	 */
	public boolean insertOrUpdate() {
		if (null != this.getPrimaryKey()) {
			// update
			return retBool(sqlSession().update(sqlStatement(SqlMethod.UPDATE_BY_ID), this));
		} else {
			// insert
			return retBool(sqlSession().insert(sqlStatement(SqlMethod.INSERT_ONE), this));
		}
	}

	/**
	 * <p>
	 * 执行 SQL 插件
	 * </p>
	 * 
	 * @param sql
	 *            SQL语句
	 * @return
	 */
	public boolean insertSql(String sql) {
		return retBool(sqlSession().insert(sqlStatement("insertSql"), sql));
	}

	/**
	 * <p>
	 * 根据 ID 删除
	 * </p>
	 * 
	 * @param id
	 *            主键ID
	 * @return
	 */
	public boolean deleteById(Serializable id) {
		return retBool(sqlSession().delete(sqlStatement(SqlMethod.DELETE_BY_ID), id));
	}

	/**
	 * <p>
	 * 根据主键删除
	 * </p>
	 * 
	 * @return
	 */
	public boolean deleteById() {
		return deleteById(this.getPrimaryKey());
	}

	/**
	 * <p>
	 * 删除记录
	 * </p>
	 * 
	 * @param whereClause
	 *            查询条件
	 * @param args
	 *            查询条件值
	 * @return
	 */
	public boolean delete(String whereClause, Object... args) {
		Map<String, Object> map = new HashMap<String, Object>();
		EntityWrapper<T> ew = null;
		if (StringUtils.isNotEmpty(whereClause)) {
			ew = new EntityWrapper<T>();
			ew.addFilter(whereClause, args);
		}
		// delete
		map.put("ew", ew);
		return retBool(sqlSession().delete(sqlStatement(SqlMethod.DELETE), map));
	}

	/**
	 * <p>
	 * 执行 SQL 删除
	 * </p>
	 * 
	 * @param sql
	 *            SQL语句
	 * @return
	 */
	public boolean deleteSql(String sql) {
		return retBool(sqlSession().delete(sqlStatement("deleteSql"), sql));
	}

	/**
	 * <p>
	 * 更新
	 * </p>
	 * 
	 * @return
	 */
	public boolean updateById() {
		if (null == this.getPrimaryKey()) {
			throw new MybatisXException("primaryKey is null.");
		}
		// updateById
		return retBool(sqlSession().update(sqlStatement(SqlMethod.UPDATE_BY_ID), this));
	}

	/**
	 * <p>
	 * 执行 SQL 更新
	 * </p>
	 * 
	 * @param whereClause
	 *            查询条件
	 * @param args
	 *            查询条件值
	 * @return
	 */
	public boolean update(String whereClause, Object... args) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("et", this);
		if (StringUtils.isNotEmpty(whereClause)) {
			EntityWrapper<T> ew = new EntityWrapper<T>();
			ew.addFilter(whereClause, args);
			map.put("ew", ew);
		}
		// update
		return retBool(sqlSession().update(sqlStatement(SqlMethod.UPDATE), map));
	}

	/**
	 * <p>
	 * 执行 SQL 更新
	 * </p>
	 * 
	 * @param sql
	 *            SQL语句
	 * @return
	 */
	public boolean updateSql(String sql) {
		return retBool(sqlSession().update(sqlStatement("updateSql"), sql));
	}

	/**
	 * <p>
	 * 查询所有
	 * </p>
	 * 
	 * @return
	 */
	public List<T> selectAll() {
		return sqlSession().selectList(sqlStatement(SqlMethod.SELECT_LIST));
	}

	/**
	 * <p>
	 * 根据 ID 查询
	 * </p>
	 * 
	 * @param id
	 *            主键ID
	 * @return
	 */
	public T selectById(Serializable id) {
		return sqlSession().selectOne(sqlStatement(SqlMethod.SELECT_BY_ID), id);
	}

	/**
	 * <p>
	 * 根据主键查询
	 * </p>
	 * 
	 * @return
	 */
	public T selectById() {
		return selectById(this.getPrimaryKey());
	}

	/**
	 * <p>
	 * 查询总记录数
	 * </p>
	 * 
	 * @param columns
	 *            查询字段
	 * @param whereClause
	 *            查询条件
	 * @param args
	 *            查询条件值
	 * @return
	 */
	public List<T> selectList(String columns, String whereClause, Object... args) {
		Map<String, Object> map = new HashMap<String, Object>();
		EntityWrapper<T> ew = new EntityWrapper<T>(null, columns);
		if (StringUtils.isNotEmpty(whereClause)) {
			ew.addFilter(whereClause, args);
		}
		map.put("ew", ew);
		return sqlSession().selectList(sqlStatement(SqlMethod.SELECT_LIST), map);
	}

	/**
	 * <p>
	 * 查询所有
	 * </p>
	 * 
	 * @param whereClause
	 * @param args
	 * @return
	 */
	public List<T> selectList(String whereClause, Object... args) {
		return selectList(null, whereClause, args);
	}

	/**
	 * <p>
	 * 执行 SQL 查询
	 * </p>
	 * 
	 * @param sql
	 *            SQL 语句
	 * @return
	 */
	public List<Map<String, Object>> selectListSql(String sql) {
		return sqlSession().selectList(sqlStatement("selectListSql"), sql);
	}

	/**
	 * <p>
	 * 查询一条记录
	 * </p>
	 * 
	 * @param columns
	 * @param whereClause
	 * @param args
	 * @return
	 */
	public T selectOne(String columns, String whereClause, Object... args) {
		List<T> tl = selectList(columns, whereClause, args);
		if (CollectionUtil.isEmpty(tl)) {
			return null;
		}
		return tl.get(0);
	}

	/**
	 * <p>
	 * 查询一条记录
	 * </p>
	 * 
	 * @param whereClause
	 * @param args
	 * @return
	 */
	public T selectOne(String whereClause, Object... args) {
		return selectOne(null, whereClause, args);
	}

	/**
	 * <p>
	 * 翻页查询
	 * </p>
	 * 
	 * @param page
	 *            翻页查询条件
	 * @param columns
	 *            查询字段
	 * @param whereClause
	 *            查询条件
	 * @param args
	 *            查询条件值
	 * @return
	 */
	public Page<T> selectPage(Page<T> page, String columns, String whereClause, Object... args) {
		Map<String, Object> map = new HashMap<String, Object>();
		EntityWrapper<T> ew = new EntityWrapper<T>(null, columns);
		if (StringUtils.isNotEmpty(whereClause)) {
			ew.addFilter(whereClause, args);
		}
		map.put("ew", ew);
		List<T> tl = sqlSession().selectList(sqlStatement(SqlMethod.SELECT_PAGE), map, page);
		page.setRecords(tl);
		return page;
	}

	/**
	 * <p>
	 * 查询所有(分页)
	 * </p>
	 * 
	 * @param page
	 * @param whereClause
	 * @param args
	 * @return
	 */
	public Page<T> selectPage(Page<T> page, String whereClause, Object... args) {
		return selectPage(page, null, whereClause, args);
	}

	/**
	 * <p>
	 * 执行 SQL 查询，查询全部记录（并翻页）
	 * </p>
	 * 
	 * @param sql
	 *            SQL语句
	 * @return
	 */
	List<Map<String, Object>> selectPageSql(Page<T> page, String sql) {
		return sqlSession().selectList(sqlStatement("selectPageSql"), sql, page);
	}

	/**
	 * <p>
	 * 查询总数
	 * </p>
	 * 
	 * @param whereClause
	 *            查询条件
	 * @param args
	 *            查询条件值
	 * @return
	 */
	public int selectCount(String whereClause, Object... args) {
		List<T> tl = selectList(whereClause, args);
		if (CollectionUtil.isEmpty(tl)) {
			return 0;
		}
		return tl.size();
	}

	/**
	 * <p>
	 * 查询总数
	 * </p>
	 * 
	 * @return
	 */
	public int selectCount() {
		return selectCount(null);
	}

	/**
	 * <p>
	 * 判断数据库操作是否成功
	 * </p>
	 *
	 * @param result
	 *            数据库操作返回影响条数
	 * @return boolean
	 */
	private boolean retBool(int result) {
		return result >= 1;
	}

	/**
	 * <p>
	 * 获取Session 默认自动提交
	 * <p/>
	 */
	private SqlSession sqlSession() {
		return Record.sqlSession(getClass());
	}

	/**
	 * 获取SqlStatement
	 * 
	 * @param sqlMethod
	 * @return
	 */
	private String sqlStatement(SqlMethod sqlMethod) {
		return sqlStatement(sqlMethod.getMethod());
	}

	private String sqlStatement(String sqlMethod) {
		return Record.table(getClass()).getSqlStatement(sqlMethod);
	}

	protected abstract Serializable getPrimaryKey();

}
