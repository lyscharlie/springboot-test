package com.lyscharlie.demo1.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyscharlie.demo1.biz.entity.UserDO;

public interface UserService extends IService<UserDO> {

	/**
	 * 随机获取一个用户
	 *
	 * @return
	 */
	public UserDO randomUser();

	/**
	 * 根据用户名和密码查询账号信息
	 *
	 * @param userName
	 * @param password
	 * @return
	 */
	public UserDO findUserByNameAndPassword(String userName, String password);

}
