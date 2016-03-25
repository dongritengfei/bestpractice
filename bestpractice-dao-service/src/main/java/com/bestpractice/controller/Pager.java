package com.bestpractice.controller;

import java.io.Serializable;
import java.util.List;

import com.bestpractice.dao.mybatis.model.BaseModel;

public class Pager<T extends BaseModel> implements Serializable {
	private static final long serialVersionUID = -1291163483860037666L;
	private List<T> list;
	private int totalCount;

	public Pager() {
	}

	public Pager(List<T> list, int totalCount) {
		this.list = list;
		this.totalCount = totalCount;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

}
