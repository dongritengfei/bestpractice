package com.bestpractice.dao.mybatis.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class BaseModel implements Serializable{
	
	private static final long serialVersionUID = 5208901484752089708L;
	
	private String uuid;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}

}
