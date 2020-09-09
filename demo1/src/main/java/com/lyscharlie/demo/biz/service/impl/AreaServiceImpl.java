package com.lyscharlie.demo.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyscharlie.demo.biz.entity.AreaDO;
import com.lyscharlie.demo.biz.mapper.AreaMapper;
import com.lyscharlie.demo.biz.service.AreaService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AreaServiceImpl extends ServiceImpl<AreaMapper, AreaDO> implements AreaService {
}
