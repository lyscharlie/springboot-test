package com.lyscharlie.demo.biz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.lyscharlie.biz.service.TestService;
import com.lyscharlie.common.annotation.RetryMethod;
import com.lyscharlie.common.config.CollectionTestConfig;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TestServiceImpl implements TestService {

	@Value("#{'${my.arr}'.split(',')}")
	private List<String> list;

	@Resource
	private CollectionTestConfig collectionTestConfig;

	@RetryMethod(times = 3)
	@Override
	public boolean test1() {
		boolean value = RandomUtils.nextBoolean();
		log.info("run value is {}", value);
		return value;
	}

	@Override
	public void test2() {

		if (CollectionUtils.isNotEmpty(list)) {
			log.info(JSON.toJSONString(list));
		}

		log.info("----------------------------------------");

		if (CollectionUtils.isNotEmpty(collectionTestConfig.getList())) {
			log.info(JSON.toJSONString(collectionTestConfig.getList()));
		}

		log.info("----------------------------------------");

		if (MapUtils.isNotEmpty(collectionTestConfig.getMap())) {
			log.info(JSON.toJSONString(collectionTestConfig.getMap()));
		}

	}

}
