package com.bestpractice.controller;

import java.util.List;

import com.bestpractice.dao.mybatis.model.BaseModel;

public interface IController<T extends BaseModel> {

	/**
	 * 根据uuid查询
	 * 
	 * @param uuid
	 * @return
	 */
	T select(String uuid);

	/**
	 * 根据领域模型的各个字段查询
	 * 
	 * @param t
	 * @param beginPage
	 * @param pageSize
	 * @return
	 */
	Pager<T> selectList(T t, int beginPage, int pageSize);

	/**
	 * 查询个数
	 * 
	 * @param t
	 * @return
	 */
	int count(T t);

	/**
	 * 插入一个领域模型对象，模型的uuid需要在调用该方法前设置好
	 * 
	 * @param t
	 * @return true：插入成功；false：插入失败
	 */
	boolean insert(T t);

	/**
	 * 批量插入领域模型对象，模型的uuid需要在调用该方法前设置好
	 * 
	 * @param list
	 * @return
	 */
	int insertList(List<T> list);

	/**
	 * 更新领域模型对象
	 * 
	 * @param t
	 * @return
	 */
	int update(T t);

	/**
	 * 根据uuid删除
	 * 
	 * @param t
	 * @return true：删除成功；false：删除失败
	 */
	boolean delete(String uuid);

	/**
	 * 根据多个uuid进行批量删除
	 * 
	 * @param uuidList
	 * @return
	 */
	int deleteList(List<String> uuidList);
}
