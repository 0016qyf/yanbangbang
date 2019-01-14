package com.dyb.yanbangbang.web;


import com.dyb.yanbangbang.common.JsonResult;
import com.dyb.yanbangbang.entity.Group;
import com.dyb.yanbangbang.entity.User;
import com.dyb.yanbangbang.service.IGroupPartService;
import com.dyb.yanbangbang.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <p>
 *  拼团表
 * </p>
 *
 * @author Tang
 * @since 2018-12-19
 */
@CrossOrigin
@RestController
@RequestMapping("/group/")
public class GroupController {

    @Autowired
    private IGroupService iGroupService;

    @Autowired
    private IGroupPartService iGroupPartService;

    /**
     * 创建拼团
     * @param group
     * @return
     */
    @PostMapping(value = "createGroup")
    public JsonResult createGroup(Group group){
        group= iGroupService.save(group);
        return new JsonResult(group);
    }

    /**
     *
     * @return
     */
    @PostMapping(value = "")
    public JsonResult update(){
        return new JsonResult();
    }

    /**
     *
     * @return
     */
    @PostMapping(value = "selectByUser")
    public JsonResult selectByUser(){
        return new JsonResult();
    }

    /**
     * 参加团
     * @param user
     * @param ordercode
     * @param group
     * @return
     */
    public JsonResult part(User user,String ordercode,Group group){
        String result="fail";
        if(iGroupPartService.isSuccess(group)) {
            //获取时间差
            Date date = new Date();
            long time = date.getTime() - group.getCreateTime().getTime();
            time=time/(1000 * 60 * 60);
            if (time<group.getDuration()&&group.getState()==0) {
                result = iGroupPartService.save(user, ordercode, group.getGroupId()) ? "success" : result;
            }else {
                group.setState(2);
                iGroupService.updateById(group);
                result="timeout";
            }
        }
        return new JsonResult(result);
    }

}

