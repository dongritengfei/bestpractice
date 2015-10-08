package com.bestpractice.dao.mybatis.model;

import java.util.Date;

public class TimeModel extends BaseModel {
	private Date gmtModified;
	private Date gmtCreated;

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public Date getGmtCreated() {
		return gmtCreated;
	}

	public void setGmtCreated(Date gmtCreated) {
		this.gmtCreated = gmtCreated;
	}

}
