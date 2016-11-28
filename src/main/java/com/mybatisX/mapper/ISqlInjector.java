/**
 * Copyright (c) 2011-2016, hubin (jobob@qq.com).
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

import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.apache.ibatis.session.Configuration;

/**
 * <p>
 * SQL 自动注入器接口
 * </p>
 * 
 * @author hubin
 * @Date 2016-07-24
 */
public interface ISqlInjector {

	/**
	 * 根据mapperClass注入SQL
	 * 
	 * @param configuration
	 * @param builderAssistant
	 * @param mapperClass
	 */
	void inject(Configuration configuration, MapperBuilderAssistant builderAssistant, Class<?> mapperClass);

	/**
	 * 检查SQL是否注入(已经注入过不再注入)
	 * 
	 * @param configuration
	 * @param builderAssistant
	 * @param mapperClass
	 */
	void inspectInject(Configuration configuration, MapperBuilderAssistant builderAssistant, Class<?> mapperClass);

}