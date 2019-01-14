package com.dyb.yanbangbang.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dyb.yanbangbang.common.JsonResult;
import com.dyb.yanbangbang.entity.Banner;
import com.dyb.yanbangbang.service.IBannerService;
import com.dyb.yanbangbang.utils.RedisClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Tang
 * @since 2019-01-08
 */
@CrossOrigin
@RestController
@RequestMapping("/banner/")
public class BannerController {
    private static final Logger log = LoggerFactory.getLogger(BannerController.class);

    @Autowired
    private RedisClient redisClinet;

    @Autowired
    private IBannerService iBannerService;

    @RequestMapping(value = "getAll")
    public JsonResult selectAll(){
        log.info("-=================查看首页");
        Map map=null;
        try {
//            map = JSON.parseObject(redisClinet.get("banners"),Map.class);
//            if (map ==null) {
//                map=new HashMap<>();
//                List<Banner> banners = new ArrayList<Banner>();
//                banners.addAll(iBannerService.selectList(new EntityWrapper<Banner>().eq("state",1)));
//                map.put("banners",banners);
//                redisClinet.set("banners", JSON.toJSONString(map));
//            }
            map=new HashMap<>();
            List<Banner> banners = new ArrayList<Banner>();
            banners.addAll(iBannerService.selectList(new EntityWrapper<Banner>().eq("state",1)));
            map.put("banners",banners);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new JsonResult(map);
    }

}

