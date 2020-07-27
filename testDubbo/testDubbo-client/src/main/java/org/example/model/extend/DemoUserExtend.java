package org.example.model.extend;

import java.io.Serializable;

import org.example.model.DemoUser;

public class DemoUserExtend extends DemoUser implements Serializable {

	/**
	 * 级别
	 * 1 - 专家
	 * 2 - 高级
	 */
	private Integer demoLevel;
	
	/**
	 * 级名称
	 */
	private String demoLevelName;

	public Integer getDemoLevel() {
		return demoLevel;
	}

	public void setDemoLevel(Integer demoLevel) {
		this.demoLevel = demoLevel;
	}

	public String getDemoLevelName() {
		return demoLevelName;
	}

	public void setDemoLevelName(String demoLevelName) {
		this.demoLevelName = demoLevelName;
	}
}
