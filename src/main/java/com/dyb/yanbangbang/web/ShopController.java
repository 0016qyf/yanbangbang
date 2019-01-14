package com.dyb.yanbangbang.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dyb.yanbangbang.common.JsonResult;
import com.dyb.yanbangbang.entity.*;
import com.dyb.yanbangbang.service.*;
import com.dyb.yanbangbang.utils.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;

/**
 * <p>
 *  店铺表
 * </p>
 *
 * @author Tang
 * @since 2018-12-19
 */
@RestController
@RequestMapping("/shop/")
public class ShopController {
    private static final Logger log = LoggerFactory.getLogger(ShopController.class);


    @Autowired
    private IGoodEvaluateService iGoodEvaluateService;

    @Autowired
    private IShopService iShopService;

    @Autowired
    private IShopGoodsMappingService iShopGoodsMappingService;

    @Autowired
    private IMaterialService iMaterialService;

    @Autowired
    private IResourceDetailService iResourceDetailService;

    @Autowired
    private IOrdersService iOrdersService;

    @Autowired
    private IUserService iUserService;

    @Autowired
    private ICollectService iCollectService;

    /**
     * 查找店铺
     * @param shopId
     * @return  店铺基本信息，店主的基本信息，商品的信息，用户收藏，商品评价
     */
    @CrossOrigin
    @PostMapping(value = "selectShop")
    public JsonResult selectByShop(Integer shopId) {
        log.info("进入店铺页面");
        Map json=new HashMap<>();
        Shop shop=iShopService.selectByShopId(shopId);
        if(shop!=null) {
            log.info("找到该店铺");
            //店主信息
            User user = iUserService.selectById(shop.getHostId());
            //收藏数
            int num = iCollectService.selectList(new EntityWrapper<Collect>().eq("object_id", shopId).and().eq("type", 1)).size();
            List<GoodEvaluate> goodEvaluates=new ArrayList<GoodEvaluate>();
            List<Map> list = new ArrayList<Map>();
            List<ShopGoodsMapping> shopGoodsMappings = iShopGoodsMappingService.selectByShopId(shopId);
            List<Map> goodEvaluate = new ArrayList<Map>();
            //商品信息
            if(shopGoodsMappings.size()>0) {
                log.info("该店铺有商品");
                List<Material> materials = iMaterialService.selectByShop(shopGoodsMappings);
                if (materials.size() > 0) {
                    for (int i = 0; i < materials.size(); i++) {
                        Map map = new HashMap<>();
                        map.put("material", materials.get(i));
                        map.put("imgs", iResourceDetailService.selectList(new EntityWrapper<ResourceDetail>().eq("resource_id", materials.get(i).getResourceId())));
                        list.add(map);
                    }
                }
                goodEvaluates.addAll(iGoodEvaluateService.selectList(new EntityWrapper<GoodEvaluate>().orderBy("evaluation_time", true).eq("resource_id", materials.get(0).getResourceId())));
                //评价
                if (goodEvaluates.size() > 0) {
                    for (int i = 0; i < goodEvaluates.size(); i++) {
                        Map map = new HashMap<>();
                        User userEvaluate = iUserService.selectById(goodEvaluates.get(i).getBuyerId());
                        //评价的用户
                        map.put("userEvaluate", userEvaluate);
                        //评价内容
                        map.put("evaluate", goodEvaluates.get(i));
                        goodEvaluate.add(map);
                    }
                }
            }
            //店主
            json.put("host", user);
            //商品
            json.put("materials", list);
            //商店
            json.put("shop", shop);
            //收藏数
            json.put("collect", num);
            //第一件商品的评价
            json.put("evaluate", goodEvaluate);
        }
        return new JsonResult(json);
    }

    /**
     * 获取用户收入
     * @param user
     * @return
     */
    @PostMapping("getIncome")
    public JsonResult getIncome(User user){
        log.info("获取收入");
        Map map=new HashMap<>();
        //获得商品集合
        //笔记

        map.put("note",getMap(user,1));
        //真题
        map.put("exam",getMap(user,2));
        //视频
        map.put("video",getMap(user,3));
        //其他
        map.put("other",getMap(user,4));
        return new JsonResult(map);
    }

    /**
     * 获取学生信息
     * @param user
     * @param current
     * @return
     */
    @PostMapping(value = "getStudents")
    public JsonResult getStudent(User user,Integer current){
        log.info("进入查询学生的方法");
        //获得订单的方法
        List<Material> materials=iMaterialService.selectByUser(user);
        List<Orders> order=iOrdersService.selectByMaterIds(materials);
        List<Map> list=new ArrayList<>();
        Set set=new HashSet<>();
        Map map=new HashMap<>();
        //获取学生集合
        List<User> users=new ArrayList<>();
        for (int i=0;i<order.size();i++){
           set.add(order.get(i).getBuyerId());
        }
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            users.add(iUserService.selectById(it.next()));
        }
        map.put("num",users.size());
        map.put("studnets",new PageInfo(current,10,users).getRecords());
        return new JsonResult(map);
    }


    /**
     * 获得收入详细信息
     * @param user
     * @param type
     * @return
     */
    public Map getMap(User user,Integer type){
        log.info("查询方法"+user.getUserId()+"类型"+type);
        Map map=new HashMap<>();
        Integer totalNum=0;
        Integer monthNum=0;
        BigDecimal totalMoney=new BigDecimal(0);
        BigDecimal monthMoney=new BigDecimal(0);
        List<Material> list=iMaterialService.selectByType(user,type);
        log.info("商品数"+list.size());
        for (int i=0;i<list.size();i++){
            totalNum+=iOrdersService.selectNum(list.get(i),0);
            monthNum+=iOrdersService.selectNum(list.get(i),1);
            totalMoney= totalMoney.add(iOrdersService.selectMoney(list.get(i),0));
            monthMoney= monthMoney.add(iOrdersService.selectMoney(list.get(i),0));
        }
        map.put("totalNum",totalNum);
        map.put("monthNum",monthNum);
        map.put("totalMoney",totalMoney);
        map.put("monthMoney",monthMoney);
        return map;
    }
}

