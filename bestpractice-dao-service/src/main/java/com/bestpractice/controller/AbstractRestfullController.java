package com.bestpractice.controller;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bestpractice.dao.mybatis.common.UUIDUtil;
import com.bestpractice.dao.mybatis.model.BaseModel;
import com.bestpractice.service.IDataService;

public abstract class AbstractRestfullController<T extends BaseModel> implements IController<T> {
	
	private static class NumberEditor<T extends Number> extends CustomNumberEditor {
		public NumberEditor(Class<T> clazz) {
			super(clazz, true);
		}

		public void setAsText(String text) throws IllegalArgumentException {
			if (text == null || text.trim().equals("")) {
				// Treat empty String as null value.
				super.setAsText("0");
			} else {
				// Use default valueOf methods for parsing text.
				super.setAsText(text);
			}
		}
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(int.class, null, new NumberEditor<Integer>(Integer.class));
		binder.registerCustomEditor(long.class, null, new NumberEditor<Long>(Long.class));
		binder.registerCustomEditor(short.class, null, new NumberEditor<Short>(Short.class));
		binder.registerCustomEditor(byte.class, null, new NumberEditor<Byte>(Byte.class));
		binder.registerCustomEditor(double.class, null, new NumberEditor<Double>(Double.class));
		binder.registerCustomEditor(float.class, null, new NumberEditor<Float>(Float.class));
	}
	
	/**
	 * 获取该领域模型的Service
	 * 
	 * @return
	 */
	public abstract IDataService<T> getService();;

	@RequestMapping("select")
	@ResponseBody
	public T select(String uuid) {
		T t = getService().select(uuid);
		return t;
	}

	@RequestMapping("selectList")
	@ResponseBody
	public Pager<T> selectList(T t, 
			@RequestParam(value="beginPage", defaultValue="1")int beginPage, 
			@RequestParam(value="pageSize", defaultValue="10000")int pageSize) {
		List<T> resultList = getService().selectList(t, beginPage, pageSize);
		int totalCount = getService().count(t);
		return new Pager<T>(resultList, totalCount);
	}

	@RequestMapping("count")
	@ResponseBody
	public int count(T t) {
		return getService().count(t);
	}

	@RequestMapping("insert")
	@ResponseBody
	public boolean insert(T t) {
		t.setUuid(UUIDUtil.uuid());
		return getService().insert(t);
	}

	@RequestMapping("insertList")
	@ResponseBody
	public int insertList(List<T> list) {
		if(CollectionUtils.isNotEmpty(list)){
			for(T t : list){
				t.setUuid(UUIDUtil.uuid());
			}
		}
		int count = getService().insertList(list);
		return count;
	}

	@RequestMapping("update")
	@ResponseBody
	public int update(T t) {
		int count = getService().update(t);
		return count;
	}

	@RequestMapping("delete")
	@ResponseBody
	public boolean delete(String uuid) {
		return getService().delete(uuid);
	}

	@RequestMapping("deleteList")
	@ResponseBody
	public int deleteList(List<String> uuidList) {
		int count = getService().deleteList(uuidList);
		return count;
	}

}
