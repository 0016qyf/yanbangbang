package com.dyb.yanbangbang.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dyb.yanbangbang.common.JsonResult;
import com.dyb.yanbangbang.entity.Material;
import com.dyb.yanbangbang.entity.Orders;
import com.dyb.yanbangbang.entity.ResourceDetail;
import com.dyb.yanbangbang.entity.Shop;
import com.dyb.yanbangbang.service.IMaterialService;
import com.dyb.yanbangbang.service.IOrdersService;
import com.dyb.yanbangbang.service.IResourceDetailService;
import com.dyb.yanbangbang.service.IShopService;
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
 *  商品订单
 * </p>
 *
 * @author Tang
 * @since 2018-12-24
 */
@CrossOrigin
@RestController
@RequestMapping("/orders/")
public class OrdersController {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(OrdersController.class);

    @Autowired
    private IOrdersService iOrdersService;

    @Autowired
    private IShopService iShopService;

    @Autowired
    private IMaterialService iMaterialService;

    @Autowired
    private IResourceDetailService iResourceDetailService;

    /**
     * 修改订单状态
     * @param orderId
     * @param state
     * @return
     */
    @PostMapping(value = "updateState")
    public JsonResult updateState(Integer orderId,Integer state){
        return new JsonResult(iOrdersService.updateState(orderId,state));
    }

    /**
     * 查询订单的方法
     * @param userId
     * @return
     */
    @PostMapping(value = "selectAll")
    public JsonResult selectAll(Integer userId){
        log.info("进入订单方法");
        log.info("接收参数"+userId);
        Map map=new HashMap<>();
        List<Orders> list=iOrdersService.selectByUser(userId);
        //订单状态：1---待付款    2---待发货   3---已发货   4---待评价   5---待分享   6---已评价   7---已退款
        //8---交易取消   9---交易超时    10---交易成功    11---交易进行中

        map.put("total",getMaps(list,-1));
        map.put("waitPay",getMaps(list,1));
        map.put("waitSend",getMaps(list,2));
        map.put("alreadySend",getMaps(list,3));
        map.put("waitGoodEvaluate",getMaps(list,4));
        map.put("waitShare",getMaps(list,5));
        return  new JsonResult(map);
    }


    public Map getMaps(List<Orders> orders,Integer state){
        Map states=new HashMap<>();
        List<Map> list = new ArrayList<Map>();
        if(orders.size()>0) {
            for (Orders order : orders) {
                Map map = new HashMap<>();
                if(state==-1||order.getState()==state) {
                    Material material = iMaterialService.selectOne(new EntityWrapper<Material>().eq("material_id", order.getMaterialId()));
                    Shop shop = iShopService.selectOne(new EntityWrapper<Shop>().eq("host_id", material.getHostId()));
                    List<ResourceDetail> imgs = iResourceDetailService.selectList(new EntityWrapper<ResourceDetail>().eq("resource_id", shop.getShopImg()));
                    //订单
                    map.put("order", order);
                    //图片
                    map.put("img", imgs);
                    //店铺
                    map.put("shop", shop);
                    //商品
                    map.put("material", material);
                    list.add(map);
                }
            }
        }
        states.put("orders",list);
        states.put("nums",list.size());
        return states;
    }





}

