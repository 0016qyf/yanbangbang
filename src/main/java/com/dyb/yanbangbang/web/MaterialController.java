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

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Tang
 * @since 2018-12-24
 */
@CrossOrigin
@RestController
@RequestMapping("/material/")
public class MaterialController {
    private static final Logger log = LoggerFactory.getLogger(MaterialController.class);


    @Autowired
    private IUserService iUserService;

    @Autowired
    private IMaterialService iMaterialService;

    @Autowired
    private IResourceDetailService iResourceDetailService;

    @Autowired
    private IOrdersService iOrdersService;


    @Autowired
    private IGoodEvaluateService iGoodEvaluateService;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


    /**
     * 查找商品详情
     * @param materialId
     * @return
     */
    @PostMapping(value = "selectMaterialById")
    public JsonResult selectMaterialById(Integer materialId){
        log.info("进入查询方法");
        Map map=new HashMap<>();
        //查找获得商品信息
        Material material=iMaterialService.selectByMaterialId(materialId);
        if(material!=null){
            log.info("获得商品");
            //获取前一个月最后一天
            Calendar calendar2 = Calendar.getInstance();
            calendar2.set(Calendar.DAY_OF_MONTH, 0);
            String lastDay = sdf.format(calendar2.getTime());
            log.info("上个月="+lastDay);
            //商品主人
            User host=iUserService.selectById(material.getHostId());
            //商品图片
            List<ResourceDetail> imgs=iResourceDetailService.selectList(new EntityWrapper<ResourceDetail>().eq("resource_id",material.getResourceId()));
            //评论
            List<GoodEvaluate> goodEvaluates=iGoodEvaluateService.selectList(new EntityWrapper<GoodEvaluate>().eq("material_id",materialId));
            //月订单数
            List<Orders> orderses=iOrdersService.selectList(new EntityWrapper<Orders>().eq("material_id",materialId).gt("end_time",lastDay));
            map.put("material",material);
            map.put("host",host);
            map.put("imgs",imgs);
            map.put("month",orderses.size());
            map.put("goodEvaluates",goodEvaluates.get(0));
            map.put("num",goodEvaluates.size());
        }
        return new JsonResult(map);
    }

    /**
     * 查看用户相关商品
     * @param userid 当前用户，如果为-1查看所有商品
     * @param current 分页参数
     * @return
     */
    @PostMapping(value = "selectByUser")
    public JsonResult selectByUser(Integer userid,Integer current){
        log.info("进入方法");
        List<Map> list=new ArrayList<Map>();
        //查找用户
        User user=iUserService.selectUser(userid);
        List<Material> materials= iMaterialService.selectByMajor(user);
        log.info("商品数"+materials.size());
        if(materials.size()>0) {
            log.info("获得商品："+materials.size());
            for (Material material : materials) {
                list.add(getMaterial(material));
            }
        }
//        for (int i=0;i<list.size();i++) {
//            log.info(list.get(i).toString());
//        }
            return new JsonResult(new PageInfo(current,10,list).getRecords());
    }

    /**
     * 根据学校专业查找商品
     * @param type 类型
     * @param school 学校
     * @param maior 专业
     * @param current 分页参数
     * @return
     */
    @PostMapping(value = "selectByMaterial")
    public JsonResult selectByType(String type,String school,String maior,Integer current){
        log.info("进入方法");
        List<Map> list=new ArrayList<Map>();
        List<Material> materials= iMaterialService.selectByMaterial(school,maior,type);
        if(materials.size()>0) {
            log.info("获取商品="+materials.size());
            for (Material material : materials) {
                list.add(getMaterial(material));
            }
        }
        return new JsonResult(new PageInfo(current,10,list));
    }




    /**
     * 封装参数的方法
     * @param material
     * @return
     */
    public Map getMaterial(Material material){
        Map map = new HashMap<>();
        map.put("material", material);
        map.put("imgs", iResourceDetailService.selectList(new EntityWrapper<ResourceDetail>().eq("resource_id", material.getResourceId())));
        map.put("host", iUserService.selectById(material.getHostId()));
        List<Orders> orders = iOrdersService.selectList(new EntityWrapper<Orders>().eq("material_id",material.getMaterialId()));
        map.put("nums", orders.size());
        return map;
    }
}
