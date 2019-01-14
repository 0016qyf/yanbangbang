package com.dyb.yanbangbang.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dyb.yanbangbang.entity.Provinces;
import com.dyb.yanbangbang.entity.Schools;
import com.dyb.yanbangbang.mapper.ProvincesMapper;
import com.dyb.yanbangbang.mapper.SchoolsMapper;
import com.dyb.yanbangbang.service.IProvincesService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Tang
 * @since 2018-12-19
 */
@Service
public class ProvincesServiceImpl extends ServiceImpl<ProvincesMapper, Provinces> implements IProvincesService {

}
