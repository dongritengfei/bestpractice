package com.bestpractice.dao.mybatis.mapper;

import java.util.List;
import java.util.Map;

import com.bestpractice.dao.mybatis.model.BaseModel;

public interface BaseMapper<T extends BaseModel> {

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
	 * @param paramMap 该map由领域模型转换而来，其中必须包含这两个key：start、count，用于分页
	 * @return
	 */
	List<T> selectList(Map<String, Object> paramMap);

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
	 * @return
	 */
	int insert(T t);

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
	 * @return
	 */
	int delete(String uuid);

	/**
	 * 根据多个uuid进行批量删除
	 * 
	 * @param uuidList
	 * @return
	 */
	int deleteList(List<String> uuidList);
}
