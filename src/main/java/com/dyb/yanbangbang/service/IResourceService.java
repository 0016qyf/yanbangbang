package com.dyb.yanbangbang.service;

import com.dyb.yanbangbang.entity.Resource;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Tang
 * @since 2018-12-19
 */
public interface IResourceService extends IService<Resource> {

    /**
     * 根据用户添加资源
     * @param userId
     * @return
     */
    Resource save(Integer userId,String resourceName,Integer type);

}
