package com.dyb.yanbangbang.service.impl;

import com.dyb.yanbangbang.entity.Post;
import com.dyb.yanbangbang.mapper.PostMapper;
import com.dyb.yanbangbang.service.IPostService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Tang
 * @since 2019-01-07
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements IPostService {

}
