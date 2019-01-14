package com.dyb.yanbangbang.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dyb.yanbangbang.common.JsonResult;
import com.dyb.yanbangbang.entity.*;
import com.dyb.yanbangbang.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  收藏表 用户收藏店铺和资料的信息
 * </p>
 *
 * @author Tang
 * @since 2018-12-19
 */
@CrossOrigin
@RestController
@RequestMapping("/collect/")
public class CollectController {

    private static final Logger log = LoggerFactory.getLogger(CollectController.class);

    @Autowired
    ICollectService iCollectService;

    @Autowired
    IShopService iShopService;

    @Autowired
    IResourceService iResourceService;

    @Autowired
    IUserService iUserService;

    @Autowired
    IOrdersService iOrdersService;

    @Autowired
    IResourceDetailService iResourceDetailService;

    @Autowired
    IMaterialService iMaterialService;

    /**
     * 此方法为用户添加新收藏
     * @param collect 收藏的信息
     * @return
     */
    @PostMapping(value = "save")
    public JsonResult save(Collect collect){
        log.info("进入添加方法");
        //返回添加结果
        return new JsonResult(iCollectService.save(collect));
    }

    /**
     * 此方法为用户移除自己收藏的店铺或资料
     * 批量删除
     * @return
     */
    @PostMapping(value = "del")
    public JsonResult del(Integer[] collectIds){
        log.info("进入删除方法");
        return new JsonResult(iCollectService.del(collectIds));
    }

    /**
     * 此方法为用户查看自己收藏信息
     * @param userId 当前用户的ID
     * @param current 分页参数
     * @return 返回店铺、店主和图片资料的结果集合
     */
    @PostMapping(value= "selectAll")
    public JsonResult selectAll(Integer userId,Integer current,String name){
        log.info("进入查询方法"+userId);
        List<Map> json1=new ArrayList<Map>();
        List<Map> json2=new ArrayList<Map>();
        //根据用户ID查询收藏表获得外键集合
        List foreignKey1= iCollectService.selectAll(userId,1);
        List foreignKey2= iCollectService.selectAll(userId,2);
        log.info("收藏店铺");
        //店铺
        List<Shop> shops =foreignKey1.size()==0?new ArrayList<Shop>() : iShopService.selectList(new EntityWrapper<Shop>().in("shop_id",foreignKey1).like("shop_name",name));
        for (int i = 0; i < shops.size(); i++) {
            Map map = new HashMap<>();
            //店铺
            map.put("shop", shops.get(i));
            //店铺主人
            map.put("host", iUserService.selectById(shops.get(i).getHostId()));
            //订单数
            map.put("ordernum", iOrdersService.selectList(new EntityWrapper<Orders>().eq("shop_id", shops.get(i).getShopId())).size());
            //图片
            map.put("imgs", iResourceDetailService.selectList(new EntityWrapper<ResourceDetail>().eq("resource_id", shops.get(i).getShopImg())));
            json1.add(map);
        }
        //资料
        List<Material>  materials=foreignKey2.size()==0?new ArrayList<Material>() :iMaterialService.selectList(new EntityWrapper<Material>().in("material_id",foreignKey2).like("material_name",name));
        log.info("收藏资料");
        for (int i = 0; i < materials.size(); i++) {
            Map map = new HashMap<>();
            //资料
            map.put("material", materials.get(i));
            //资料主人
            map.put("host", iUserService.selectById(materials.get(i).getHostId()));
            //图片
            map.put("imgs", iResourceDetailService.selectList(new EntityWrapper<ResourceDetail>().eq("resource_id", materials.get(i).getResourceId())));
            json2.add(map);
        }
        //留言
        Map maps=new HashMap<>();
        maps.put("shops",json1);
        maps.put("shopNum",json1.size());
        maps.put("materials",json2);
        maps.put("materialNum",json2.size());
        //获取到商品集合和资料集合并封装
        return new JsonResult(maps);
    }

}

