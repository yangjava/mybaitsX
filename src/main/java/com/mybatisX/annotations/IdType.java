
package com.mybatisX.annotations;

/**
 * <p>
 * 生成ID类型枚举类
 * </p>
 * 
 * @author 杨京京
 */
public enum IdType {
	AUTO(0, "数据库ID自增"),
	INPUT(1, "用户输入ID"),
	
	/* 以下2种类型、只有当插入对象ID 为空，才自动填充。 */
	ID_WORKER(2, "全局唯一ID"),
	UUID(3, "全局唯一ID");

	/** 主键 */
	private final int key;

	/** 描述 */
	private final String desc;

	IdType(final int key, final String desc) {
		this.key = key;
		this.desc = desc;
	}

	public int getKey() {
		return this.key;
	}

	public String getDesc() {
		return this.desc;
	}

}
