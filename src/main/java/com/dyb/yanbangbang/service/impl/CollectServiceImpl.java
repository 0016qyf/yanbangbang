package com.dyb.yanbangbang.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dyb.yanbangbang.entity.Collect;
import com.dyb.yanbangbang.mapper.CollectMapper;
import com.dyb.yanbangbang.service.ICollectService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  服务实现类
 *  判定参数是否符合业务要求
 * </p>
 *
 * @author Tang
 * @since 2018-12-19
 */
@Service
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements ICollectService {


    @Override
    public boolean save(Collect collect) {
        if(collect==null){
            throw new NullPointerException(""
                    + "传入的值为空");
        }
        return save(collect);
    }

    @Override
    public boolean del(Integer[] ids) {
        if (ids==null){
            throw new NullPointerException(""
                    + "传入的值为空");
        }
        List list= Arrays.asList(ids);
        return deleteBatchIds(list);
    }

    /**
     * 查找收藏
     * @param userid
     * @param type
     * @return
     */
    @Override
    public List selectAll(Integer userid,Integer type) {
        if(userid==null){
            throw new NullPointerException(""
                    + "传入的值为空");
        }
        if(type==null){
            throw new NullPointerException(""
                    + "传入的值为空");
        }
        //查询用户收藏的全部
        List<Collect> list=selectList(new EntityWrapper<Collect>().eq("user_id",userid).eq("type",type));
        List ints=new ArrayList<>();
        for (Collect collect: list) {
            ints.add(collect.getObjectId());
        }
        return ints;
    }
}
