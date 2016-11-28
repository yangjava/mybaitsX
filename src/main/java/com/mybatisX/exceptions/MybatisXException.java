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
package com.mybatisX.exceptions;

/**
 * <p>
 * MybatisPlus 异常类
 * </p>
 * 
 * @author hubin
 * @Date 2016-01-23
 */
public class MybatisXException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MybatisXException(String message) {
		super(message);
	}

	public MybatisXException(Throwable throwable) {
		super(throwable);
	}

	public MybatisXException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
