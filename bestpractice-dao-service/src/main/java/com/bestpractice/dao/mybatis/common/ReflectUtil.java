package com.bestpractice.dao.mybatis.common;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;

public class ReflectUtil {
	public static Map<String, Object> beanToMap(Object object) {
		Map<String, Object> m = new HashMap<String, Object>();
		if (object == null) {
			return m;
		}
		try {
			m = PropertyUtils.describe(object);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		}
		return m;
	}
}
