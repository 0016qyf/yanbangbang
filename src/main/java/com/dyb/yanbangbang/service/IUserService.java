package com.dyb.yanbangbang.service;

import com.baomidou.mybatisplus.service.IService;
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
public interface IUserService extends IService<User> {

    User selectUser(Integer id);

    List<User> selectByPid(User user);

    /**
     * 修改用户信息
     */
    void updateByUserId(User user);

    /**
     * 验证邀请码
     * @param inviteCode
     */
    int checkInviteCode(String inviteCode);

}
