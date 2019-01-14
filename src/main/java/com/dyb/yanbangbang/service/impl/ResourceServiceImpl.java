package com.dyb.yanbangbang.service.impl;

import com.dyb.yanbangbang.entity.Resource;
import com.dyb.yanbangbang.mapper.ResourceMapper;
import com.dyb.yanbangbang.service.IResourceService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Tang
 * @since 2018-12-19
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements IResourceService {

    @Override
    public Resource save(Integer userId,String resourceName,Integer type) {
        if(userId==null||resourceName==null||type==null){
            throw new NullPointerException(""
                    + "传入的值为空");
        }
        Resource resource=new Resource();
        resource.setCreateTime(new Date());
        resource.setResourceName(resourceName);
        resource.setType(type);
        resource.setUploaderId(userId);

        return insert(resource)?resource:null;
    }
}
