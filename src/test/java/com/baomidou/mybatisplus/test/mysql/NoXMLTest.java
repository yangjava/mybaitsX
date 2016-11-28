/**
 * Copyright (c) 2011-2014, hubin (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.baomidou.mybatisplus.test.mysql;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.baomidou.mybatisplus.test.mysql.entity.Test;
import com.mybatisX.core.MybatisSessionFactoryBuilder;
import com.mybatisX.toolkit.IdWorker;

/**
 * <p>
 * 测试没有XML同样注入CRUD SQL
 * </p>
 * 
 * @author Caratacus
 * @date 2016-09-26
 */
public class NoXMLTest {

	public static void main(String[] args) {
		/*
		 * 加载配置文件
		 */
		InputStream in = NoXMLTest.class.getClassLoader().getResourceAsStream("mysql-config.xml");
		MybatisSessionFactoryBuilder mf = new MybatisSessionFactoryBuilder();
		SqlSessionFactory sessionFactory = mf.build(in);
		SqlSession sqlSession = sessionFactory.openSession();
		/**
		 * 查询是否有结果
		 */
		TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
		testMapper.insert(new Test(IdWorker.getId(), "Caratacus"));
		List<Test> tests = testMapper.selectList(null);
		if (null != tests) {
			for (Test test : tests) {
				System.out.println("id:"+test.getId()+ " , type:" + test.getType());
			}
		} else {
			System.err.println(" tests is null. ");
		}
	}

}
