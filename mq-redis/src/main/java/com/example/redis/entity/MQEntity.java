package com.example.redis.entity;

import com.alibaba.fastjson.JSON;

/**
 * 消息队列传输实体
 * @author Administrator
 *
 * @param <T>
 */
public class MQEntity<T> {
	
	/**
	 * redis key
	 */
	private String key;
	
	/**
	 * 消息数据
	 */
	private  T t;
	
	
	public MQEntity(String key,T t) {
		this.key = key;
		this.t = t;
	}


	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}


	public T getT() {
		return t;
	}


	public void setT(T t) {
		this.t = t;
	}

}
