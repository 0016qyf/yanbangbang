package com.dyb.yanbangbang.service;

import com.baomidou.mybatisplus.service.IService;
import com.dyb.yanbangbang.entity.Group;
import com.dyb.yanbangbang.entity.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Tang
 * @since 2018-12-19
 */
public interface IGroupService extends IService<Group> {

    Group save(Group group);

    List<Group> selectByUser(User user);
}
