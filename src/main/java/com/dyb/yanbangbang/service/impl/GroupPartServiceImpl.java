package com.dyb.yanbangbang.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dyb.yanbangbang.entity.Group;
import com.dyb.yanbangbang.entity.GroupPart;
import com.dyb.yanbangbang.entity.User;
import com.dyb.yanbangbang.mapper.GroupPartMapper;
import com.dyb.yanbangbang.service.IGroupPartService;
import org.springframework.stereotype.Service;

import java.util.Date;
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
public class GroupPartServiceImpl extends ServiceImpl<GroupPartMapper, GroupPart> implements IGroupPartService {


    /**
     * 参加拼团
     * @param user
     * @param orderCode
     * @param groupId
     * @return
     */
    @Override
    public boolean save(User user, String orderCode, Integer groupId) {
        if(user==null||orderCode==null||groupId ==null){
            throw new NullPointerException(""
                    + "传入的值为空");
        }
        GroupPart groupPart=new GroupPart();
        groupPart.setGroupId(groupId);
        groupPart.setOrderCode(orderCode);
        groupPart.setPartId(user.getUserId());
        groupPart.setPartHeadImg(user.getAvatarurl());
        groupPart.setPartNikeName(user.getNikeName());
        groupPart.setPartTime(new Date());
        return insert(groupPart);
    }

    /**
     * 检查拼团是否成功
     * @param group
     * @return
     */
    @Override
    public boolean isSuccess(Group group) {
        if(group ==null){
            throw new NullPointerException(""
                    + "传入的值为空");
        }
        List<GroupPart> groupParts=selectList(new EntityWrapper<GroupPart>().eq("group_id",group.getGroupId()));
        //返回结果
        return groupParts.size()>=group.getGroupCount();
    }
}
