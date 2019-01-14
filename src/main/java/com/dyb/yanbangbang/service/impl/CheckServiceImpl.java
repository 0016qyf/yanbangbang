package com.dyb.yanbangbang.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dyb.yanbangbang.entity.Check;
import com.dyb.yanbangbang.entity.Material;
import com.dyb.yanbangbang.mapper.CheckMapper;
import com.dyb.yanbangbang.service.ICheckService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Tang
 * @since 2018-12-29
 */
@Service
public class CheckServiceImpl extends ServiceImpl<CheckMapper, Check> implements ICheckService {

    @Override
    public List<Map> selectByMaterials(List<Material> materials) {
        if(materials==null){
            throw new NullPointerException(""
                    + "传入的值为空");
        }
        List<Map> list=new ArrayList<Map>();
        for (int i=0;i<materials.size();i++) {
            Map map=new HashMap<>();
            map.put("material",materials.get(i));
            map.put("checks",selectOne(new EntityWrapper<Check>().eq("material_id",materials.get(i).getMaterialId())));
            list.add(map);
        }
        return list;
    }
}
