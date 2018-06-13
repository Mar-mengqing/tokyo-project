package com.baizhi.crm.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 条件
 * 
 * @author mengqing
 * 
 */
public class Where implements Serializable {

	private static final long serialVersionUID = -1810413214936764473L;
	private StringBuffer query;// 条件
	private Map<String, Object> params;// 条件对应的值
	private StringBuffer orderKeys;// 排序字段

	public Where() {
		query = new StringBuffer(" 1 = 1 ");
	}

	public Where append(String s) {
		query.append(" and ");
		query.append(s);
		return this;
	}

	public String getQuery() {
		return query.toString();
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public Where put(String key, Object value) {
		if (null == this.params) {
			params = new HashMap<String, Object>();
		}
		this.params.put(key, value);
		return this;
	}

	public String getOrderKeys() {
		if (null != orderKeys)
			return orderKeys.toString();
		else
			return null;
	}

	public Where addOrderKey(String key) {
		if (null == orderKeys) {
			orderKeys = new StringBuffer("");
		}
		orderKeys.append(key);
		return this;
	}
}
