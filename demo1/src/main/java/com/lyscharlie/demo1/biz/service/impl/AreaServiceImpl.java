package com.lyscharlie.demo1.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyscharlie.demo1.biz.entity.AreaDO;
import com.lyscharlie.demo1.biz.mapper.AreaMapper;
import com.lyscharlie.demo1.biz.service.AreaService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AreaServiceImpl extends ServiceImpl<AreaMapper, AreaDO> implements AreaService {
}
