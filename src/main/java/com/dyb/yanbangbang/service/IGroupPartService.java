package com.dyb.yanbangbang.service;

import com.baomidou.mybatisplus.service.IService;
import com.dyb.yanbangbang.entity.Group;
import com.dyb.yanbangbang.entity.GroupPart;
import com.dyb.yanbangbang.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Tang
 * @since 2018-12-19
 */
public interface IGroupPartService extends IService<GroupPart> {

    boolean save(User user, String orderCode, Integer groupId);

    boolean isSuccess(Group group);
}
