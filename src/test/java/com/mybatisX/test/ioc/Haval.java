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
package com.mybatisX.test.ioc;

/**
 * <p>
 * 哈佛汽车
 * </p>
 * 
 * @author hubin
 * @Date 2016-07-06
 */
public class Haval implements ICar {

	public boolean start() {
		System.err.println(" 哈佛H9 点火启动... ");
		return true;
	}


	public void driver() {
		System.err.println(" 走你！哈佛H9 ... ");
	}

}
