package com.lyscharlie.demo1.biz.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyscharlie.demo1.biz.entity.UserDO;
import com.lyscharlie.demo1.biz.mapper.UserMapper;
import com.lyscharlie.demo1.biz.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

	@Override
	public UserDO randomUser() {
		return this.baseMapper.selectRandomUser();
	}

	@Override
	public UserDO findUserByNameAndPassword(String userName, String password) {
		QueryWrapper<UserDO> wrapper = new QueryWrapper<>();
		wrapper.eq("user_name", userName)
				.eq("password", DigestUtils.md5Hex(password))
				.eq("is_delete", 0)
				.orderByAsc("user_id")
				.last("limit 1");
		return this.baseMapper.selectOne(wrapper);
	}

}
