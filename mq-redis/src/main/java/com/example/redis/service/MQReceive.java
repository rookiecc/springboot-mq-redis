package com.example.redis.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.redis.entity.MQEntity;

@Service
public class MQReceive {
	
	@Autowired
	private RedisService<String, String> redisService;
	
	@RabbitListener(queues="hello")
	public void  receiveAndPutRedis(String value) {
		 MQEntity<JSONObject> msg = JSON.parseObject(value,MQEntity.class);
		 if(msg != null ) {
			 redisService.setValue(msg.getKey(), msg.getT().toJSONString());
		 }
	}
	
	
}
