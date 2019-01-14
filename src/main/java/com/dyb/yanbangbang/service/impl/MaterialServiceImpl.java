package com.dyb.yanbangbang.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dyb.yanbangbang.entity.Material;
import com.dyb.yanbangbang.entity.ShopGoodsMapping;
import com.dyb.yanbangbang.entity.User;
import com.dyb.yanbangbang.mapper.MaterialMapper;
import com.dyb.yanbangbang.service.IMaterialService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Tang
 * @since 2018-12-24
 */
@Service
public class MaterialServiceImpl extends ServiceImpl<MaterialMapper, Material> implements IMaterialService {


    /**
     * 查找商品
     * @param shopGoodsMappings
     * @return
     */
    @Override
    public List<Material> selectByShop(List<ShopGoodsMapping> shopGoodsMappings) {
        if(shopGoodsMappings==null){
            throw new NullPointerException(""
                    + "传入的值为空");
        }
        List list=new ArrayList<>();
        for (ShopGoodsMapping shopGoodsMapping:shopGoodsMappings){
            list.add(shopGoodsMapping.getMaterialId());
        }
        if(list.size()>0) {
            return selectBatchIds(list);
        }
        return null;
    }

    @Override
    public List<Material> selectByMajor(User user) {
        if(user==null){
            List<Material> materials= selectList(new EntityWrapper<Material>().eq("state",4));
            return materials;
        }else {
            List<Material> materials = selectList(new EntityWrapper<Material>().like("school", user.getSchool() != null ? user.getSchool() : "").eq("major", user.getMajor() != null ? user.getMajor() : "").eq("state", 4));
            return materials;
        }
    }

    /**
     * 查找店主的商品并分类型返回
     * @param user
     * @return
     */
    @Override
    public List selectByType(User user,Integer type) {
        if(user==null){
            throw new NullPointerException(""
                    + "传入的值为空");
        }
        //资料类型：1----笔记    2----真题     3----视频    4----其他
        List<Material> note=selectList(new EntityWrapper<Material>().eq("host_id",user.getUserId()).eq("state",2).eq("material_type",type));
        List list=new ArrayList<>();
        for (Material material:note){
            list.add(material.getMaterialId());
        }
        return list;
    }

    @Override
    public List<Material> selectByUser(User user) {
        if(user==null){
            throw new NullPointerException(""
                    + "传入的值为空");
        }
        return selectList(new EntityWrapper<Material>().eq("host_id",user.getUserId()));
    }

    @Override
    public List<Material> selectByMaterial(String school,String major,String type) {
        Integer materialType=-1;
        //资料类型：1----笔记    2----真题     3----视频    4----其他
        if(type!=null) {
            switch (type) {
                case "笔记":
                    materialType = 1;
                    break;
                case "真题":
                    materialType = 2;
                    break;
                case "视频":
                    materialType = 3;
                    break;
                case "其他":
                    materialType = 4;
                    break;
                default:
                    materialType = -1;
                    break;
            }
        }else {
            materialType = -1;
        }
        EntityWrapper<Material> wrapper = new EntityWrapper<Material>();
        if (materialType==-1) {
            return selectList(wrapper.like("school", school != null ? school : "").like("major", major != null ? major : ""));
        }else {
            return selectList(wrapper.like("school", school != null ? school : "").like("major", major != null ? major : "").eq("material_type", materialType));
        }
    }

    @Override
    public Material selectByMaterialId(Integer id) {
        if(id==null){
            throw new NullPointerException(""
                    + "传入的值为空");
        }
        return selectById(id);
    }


}
