package com.lyscharlie.demo1.biz.mapper;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyscharlie.demo1.biz.entity.UserDO;

@Repository
public interface UserMapper extends BaseMapper<UserDO> {

	public Integer selectCountByRegisterReferId(Long registerReferId);

	public UserDO selectRandomUser();

}
