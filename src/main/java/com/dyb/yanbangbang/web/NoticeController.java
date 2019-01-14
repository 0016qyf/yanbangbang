package com.dyb.yanbangbang.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dyb.yanbangbang.common.JsonResult;
import com.dyb.yanbangbang.entity.Notice;
import com.dyb.yanbangbang.entity.ResourceDetail;
import com.dyb.yanbangbang.service.INoticeService;
import com.dyb.yanbangbang.service.IResourceDetailService;
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
 * @since 2018-12-29
 */
@CrossOrigin
@RestController
@RequestMapping("/notice/")
public class NoticeController {

    @Autowired
    private INoticeService iNoticeService;

    @Autowired
    private IResourceDetailService iResourceDetailService;

    /**
     * 添加公告
     * @return
     */
    public JsonResult save(){
        return new JsonResult();
    }

    /**
     * 查看全部已发布的公告
     * @return
     */
    @RequestMapping("selectAll")
    public JsonResult selectAll(){
        List<Map> list=new ArrayList<Map>();
        List<Notice> notices=iNoticeService.selectList(new EntityWrapper<Notice>().eq("state",2));
        for (int i=0;i<notices.size();i++){
            Map map=new HashMap<>();
            map.put("notice",notices.get(i));
            map.put("imgs",iResourceDetailService.selectList(new EntityWrapper<ResourceDetail>().eq("resource_id",notices.get(i).getResourceId())));
            list.add(map);
        }
        return new JsonResult(list);
    }
}

