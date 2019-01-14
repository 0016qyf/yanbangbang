package com.dyb.yanbangbang.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dyb.yanbangbang.common.JsonResult;
import com.dyb.yanbangbang.entity.Post;
import com.dyb.yanbangbang.service.IPostService;
import com.dyb.yanbangbang.utils.RedisClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Tang
 * @since 2019-01-07
 */
@CrossOrigin
@RestController
@RequestMapping("/post/")
public class PostController {
    private static final Logger log = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private IPostService iPostService;

    @Autowired
    private RedisClient redisClinet;




    /**
     * 显示所有帖子
     * @return
     */
    @PostMapping(value="selectAll")
    public JsonResult selectAll(Integer page, Integer limit){
        Map map=null;
        log.info("显示所有帖子");
        try {
//            map = JSON.parseObject(redisClinet.get("post"),Map.class);
//            if (map ==null) {
//                map=new HashMap<>();
//                List<Post> posts = new ArrayList<Post>();
//                posts.addAll(iPostService.selectList(new EntityWrapper<Post>().eq("state", 1).orderBy(false, "sort")));
//                map.put("posts",posts);
//                redisClinet.set("post", JSON.toJSONString(map));
//            }
                List<Post> posts = new ArrayList<Post>();
                posts.addAll(iPostService.selectList(new EntityWrapper<Post>().eq("state", 1).orderBy(false, "sort")));
                map.put("posts",posts);
        }catch (Exception e){
            e.printStackTrace();
        }
//        return  new JsonResult(new PageInfo(page,limit,posts));
        return new JsonResult(map);
    }

    @PostMapping(value = "read")
    public JsonResult readOne(){

        return  new JsonResult();
    }

}

