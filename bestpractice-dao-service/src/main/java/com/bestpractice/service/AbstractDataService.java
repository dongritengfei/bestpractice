package com.bestpractice.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.bestpractice.dao.mybatis.common.ReflectUtil;
import com.bestpractice.dao.mybatis.mapper.BaseMapper;
import com.bestpractice.dao.mybatis.model.BaseModel;

public abstract class AbstractDataService<T extends BaseModel> implements IDataService<T> {

	public abstract BaseMapper<T> getMapper();

	public T select(String uuid) {
		T t = getMapper().select(uuid);
		return afterSelect(t);
	}

	public List<T> selectList(T t, int beginPage, int pageSize) {
		preSelectList(t);
		Map<String, Object> paramMap = getSelectParamMap(t, beginPage, pageSize);
		List<T> resultList = getMapper().selectList(paramMap);
		return afterSelectList(resultList, t, beginPage, pageSize);
	}

	private Map<String, Object> getSelectParamMap(T t, int beginPage,
			int pageSize) {
		if (beginPage <= 0)
			beginPage = 1;
		if (pageSize <= 0)
			pageSize = 1;
		if (pageSize > 1000) {
			pageSize = 1000;
		}
		Map<String, Object> params = ReflectUtil.beanToMap(t);
		params.put("start", (beginPage - 1) * pageSize);
		params.put("count", pageSize);
		return params;
	}

	public int count(T t) {
		preCount(t);
		return getMapper().count(t);
	}

	@Transactional
	public boolean insert(T t) {
		preInsert(t);
		return getMapper().insert(t) == 1;
	}

	@Transactional
	public int insertList(List<T> list) {
		preInsertList(list);
		int count = getMapper().insertList(list);
		return afterInsertList(count, list);
	}

	@Transactional
	public int update(T t) {
		preUpdate(t);
		int count = getMapper().update(t);
		return afterUpdate(count, t);
	}

	@Transactional
	public boolean delete(String uuid) {
		int count = getMapper().delete(uuid);
		return afterDelete(count == 1, uuid);
	}

	@Transactional
	public int deleteList(List<String> uuidList) {
		int count = getMapper().deleteList(uuidList);
		return afterDeleteList(count, uuidList);
	}

	/**
	 * 在select后执行
	 * 
	 * @param result
	 *            查询的结果
	 * @return
	 */
	public T afterSelect(T result) {
		return result;
	}

	/**
	 * 在selectList前执行
	 * 
	 * @param t
	 *            selectList的参数
	 */
	public void preSelectList(T t) {
	}

	/**
	 * 在selectList后执行
	 * 
	 * @param resultList
	 *            查询的结果
	 * @param t
	 *            selectList的参数
	 * @return
	 */
	public List<T> afterSelectList(List<T> resultList, T t, int beginPage,
			int pageSize) {
		return resultList;
	}

	/**
	 * 在selectMap前执行
	 * 
	 * @param t
	 *            selectMap的参数
	 */
	public void preSelectMap(T t) {
	}

	/**
	 * 在selectMap后执行
	 * 
	 * @param resultMap
	 *            查询的结果，key为uuid
	 * @param t
	 *            selectMap的参数
	 * @param beginPage
	 * @param pageSize
	 * @return
	 */
	public Map<String, T> afterSelectMap(Map<String, T> resultMap, T t,
			int beginPage, int pageSize) {
		return resultMap;
	}

	/**
	 * 在count前执行
	 * 
	 * @param t
	 *            count的参数
	 */
	public void preCount(T t) {
	}

	/**
	 * 在insert前执行
	 * 
	 * @param t
	 *            insert的参数
	 */
	public void preInsert(T t) {
	}

	/**
	 * 在insert后执行
	 * 
	 * @param success
	 *            插入是否成功
	 * @param t
	 *            insert的参数
	 */
	public void afterInsert(boolean success, T t) {
	}

	/**
	 * 在insertList前执行
	 * 
	 * @param list
	 *            insertList的参数
	 */
	public void preInsertList(List<T> list) {
	}

	/**
	 * 在insertList后执行
	 * 
	 * @param count
	 *            成功插入的个数
	 * @param list
	 *            insertList的参数
	 */
	public int afterInsertList(int count, List<T> list) {
		return count;
	}

	/**
	 * 在update前执行
	 * 
	 * @param t
	 *            update的参数
	 */
	public void preUpdate(T t) {
	}

	/**
	 * 在update后执行
	 * 
	 * @param count
	 *            更新的个数
	 * @param t
	 *            update的参数
	 * @return 更新的个数
	 */
	public int afterUpdate(int count, T t) {
		return count;
	}

	/**
	 * 在delete后执行
	 * 
	 * @param success
	 *            删除是否成功
	 * @param uuid
	 *            delete的参数
	 */
	public boolean afterDelete(boolean success, String uuid) {
		return success;
	}

	/**
	 * 在deleteList后执行
	 * 
	 * @param count
	 *            删除的个数
	 * @param uuidList
	 *            deleteList的参数
	 */
	public int afterDeleteList(int count, List<String> uuidList) {
		return count;
	}

}
