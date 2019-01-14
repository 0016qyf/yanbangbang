package com.dyb.yanbangbang.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dyb.yanbangbang.entity.GoodEvaluate;
import com.dyb.yanbangbang.entity.User;
import com.dyb.yanbangbang.mapper.GoodEvaluateMapper;
import com.dyb.yanbangbang.service.IGoodEvaluateService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
public class GoodEvaluateServiceImpl extends ServiceImpl<GoodEvaluateMapper, GoodEvaluate> implements IGoodEvaluateService {

    @Override
    public Integer save(GoodEvaluate goodEvaluate,User user) {
        System.out.println(user);
        System.out.println(goodEvaluate);

        if(goodEvaluate==null||user.getAvatarurl()==null||user.getUserId()==null||user.getNikeName()==null){
            throw new NullPointerException(""
                    + "传入的值为空");
        }
        goodEvaluate.setEvaluationTime(new Date());
        goodEvaluate.setBuyerId(user.getUserId());
        goodEvaluate.setBuyerHeadImg(user.getAvatarurl());
        goodEvaluate.setBuyerNikeName(user.getNikeName());
        boolean flag= insert(goodEvaluate);
        return flag?goodEvaluate.getGoodEvaluateId():null;
    }

    /**
     * 根据id主键批量删除
     * @param ids
     * @return
     */
    @Override
    public boolean del(Integer[] ids) {
        if(ids==null){
            throw new NullPointerException(""
                    + "传入的值为空");
        }
        //数组转集合
        List list= Arrays.asList(ids);
        return deleteBatchIds(list);
    }


    /**
     * 查询评论 1：根据商品查询，2：根据用户查询
     * @param goodEvaluate
     * @param
     * @return
     */
    @Override
    public List<GoodEvaluate> selectAll(GoodEvaluate goodEvaluate) {
        if(goodEvaluate==null){
            throw new NullPointerException(""
                    + "传入的值为空");
        }
        EntityWrapper<GoodEvaluate> wrapper=new EntityWrapper<GoodEvaluate>();
        //根据资料查询评价
        if(goodEvaluate.getResourceId()!=null){
            wrapper.eq("resource_id",goodEvaluate.getMaterialId());
        }
        //根据用户查询评价
        if(goodEvaluate.getBuyerId()!=null){
            wrapper.eq("buyer_id",goodEvaluate.getBuyerId());
        }
        return selectList(wrapper);
    }
}
