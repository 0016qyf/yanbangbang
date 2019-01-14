package com.dyb.yanbangbang.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dyb.yanbangbang.entity.Group;
import com.dyb.yanbangbang.entity.User;
import com.dyb.yanbangbang.mapper.GroupMapper;
import com.dyb.yanbangbang.service.IGroupService;
import org.springframework.stereotype.Service;

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
public class GroupServiceImpl extends ServiceImpl<GroupMapper, Group> implements IGroupService {

    @Override
    public Group save(Group group) {
        if(group==null){
            throw new NullPointerException(""
                    + "传入的值为空");
        }
        boolean flag=insert(group);
        if(flag){
            List<Group> groups= selectList(new EntityWrapper<Group>().eq("creator_id",group.getCreatorId()));
            return  groups.get(groups.size()-1);
        }
        return null;
    }

    @Override
    public List<Group> selectByUser(User user) {
        if(user==null){
            throw new NullPointerException(""
                    + "传入的值为空");
        }
        //查找正在拼团的
//        Date date = new Date();
//        long time = date.getTime() - group.getCreateTime().getTime();
//        time=time/(1000 * 60 * 60);
        return null;
    }
}
