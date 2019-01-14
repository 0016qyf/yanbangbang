package com.dyb.yanbangbang.web;


import com.dyb.yanbangbang.common.JsonResult;
import com.dyb.yanbangbang.entity.FeedBack;
import com.dyb.yanbangbang.service.IFeedBackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Tang
 * @since 2018-12-29
 */
@RestController
@RequestMapping("/feedBack/")
public class FeedBackController {
    private static final Logger log = LoggerFactory.getLogger(FeedBackController.class);


    @Autowired
    private IFeedBackService iFeedBackService;

    @PostMapping(value = "save")
    public JsonResult save(FeedBack feedBack){
        log.info("进入反馈的添加方法");
        feedBack.setCreateTime(new Date());
        iFeedBackService.insert(feedBack);
        return new JsonResult();
    }
}

