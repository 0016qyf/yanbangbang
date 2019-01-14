package com.dyb.yanbangbang.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dyb.yanbangbang.entity.User;
import com.dyb.yanbangbang.mapper.UserMapper;
import com.dyb.yanbangbang.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Tang
 * @since 2018-12-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUser(Integer id) {
        if(id==null){
            throw new NullPointerException(""
                    + "传入的值为空");
        }
        return selectById(id);
    }

    @Override
    public List<User> selectByPid(User user) {
        if(user==null||user.getUserId()==null){
            throw new NullPointerException(""
                    + "传入的值为空");
        }
        return selectList(new EntityWrapper<User>().eq("pid",user.getUserId()));
    }

    @Override
    public void updateByUserId(User user) {

        int res = userMapper.updateById(user);
        if (res <= 0){
            throw new RuntimeException("信息保存失败！");
        }
    }

    @Override
    public int checkInviteCode(String inviteCode) {
        Map<String, Object> map = new HashMap<>();
        map.put("invite_code",inviteCode);
        List<User> list = userMapper.selectByMap(map);
        if (list.size() == 0){
            throw new RuntimeException("邀请码错误或无效！");
        }
        return list.get(0).getUserId();
    }
}
