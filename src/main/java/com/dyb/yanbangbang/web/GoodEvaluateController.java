package com.dyb.yanbangbang.web;


import com.dyb.yanbangbang.common.JsonResult;
import com.dyb.yanbangbang.entity.GoodEvaluate;
import com.dyb.yanbangbang.entity.Resource;
import com.dyb.yanbangbang.entity.ResourceDetail;
import com.dyb.yanbangbang.entity.User;
import com.dyb.yanbangbang.service.IGoodEvaluateService;
import com.dyb.yanbangbang.service.IResourceDetailService;
import com.dyb.yanbangbang.service.IResourceService;
import com.dyb.yanbangbang.service.IUserService;
import com.dyb.yanbangbang.utils.OSSClientUtil;
import com.dyb.yanbangbang.utils.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  商品评价表
 * </p>
 *
 * @author Tang
 * @since 2018-12-19
 */
@RestController
@RequestMapping("/goodEvaluate/")
public class GoodEvaluateController {

    private static final Logger log = LoggerFactory.getLogger(GoodEvaluateController.class);

    @Autowired
    private IGoodEvaluateService iGoodEvaluateService;

    @Autowired
    private IResourceService iResourceService;

    @Autowired
    private IResourceDetailService iResourceDetailService;

    @Autowired
    private IUserService iUserService;


    /**
     * 此方法为用户为商品写评价
     * @return
     */
    @PostMapping(value = "save")
    public JsonResult save(GoodEvaluate goodEvaluate,User user){
        log.info("添加评价");
        return new JsonResult(iGoodEvaluateService.save(goodEvaluate,user));
    }

    /**
     * 传评论图片
     * @return
     */
    @PostMapping(value = "upload")
    public JsonResult uploadImg(MultipartFile file, Integer goodEvaluateId, String fileName){
        log.info("上传评论图片");
        Map<String,Object> resMap = new HashMap<>();
        resMap.put("success",false);
        try {
            String originalFilename = file.getOriginalFilename();
            String substring = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
            String name = new Date().getTime()+"goodEvaluate"+ substring;
            log.info("获得文件名:"+name);
            InputStream inputStream = file.getInputStream();
            //上传图片
            String url=OSSClientUtil.uploadFile(name,inputStream);
            //添加resource
            log.info("获得路径"+url);
            GoodEvaluate goodEvaluate=iGoodEvaluateService.selectById(goodEvaluateId);
            Integer resourceId=null;
            if(goodEvaluate.getResourceId()==null){
                //添加resourceId
                resourceId=iResourceService.save(goodEvaluate.getBuyerId(),"评论图片",2).getResourceId();
            }else {
                resourceId=goodEvaluate.getResourceId();
            }
            ResourceDetail resourceDetail=new ResourceDetail();
            resourceDetail.setResourceId(resourceId);
            resourceDetail.setFileName(name);
            resourceDetail.setUrl(url);
            resourceDetail.setKey("goodevaluate");
            boolean flag=iResourceDetailService.insert(resourceDetail);
            if(flag) {
                resMap.put("success",true);
                resMap.put("msg","上传成功");
            }

        }catch (Exception e){
            e.printStackTrace();
            resMap.put("success",false);
            resMap.put("msg","上传失败");
            return  new JsonResult(resMap);

        }
        return  new JsonResult(resMap);
    }

    /**
     * 此方法为用户删除自己的评价
     * 批量删除
     * @return
     */
    @PostMapping(value = "del")
    public JsonResult del(Integer[] goodEvaluateIds){
        log.info("删除评价");
        return new JsonResult(iGoodEvaluateService.del(goodEvaluateIds));
    }

    /**
     * 此方法为用户查看商品历史评价
     * @return
     */
    @PostMapping(value = "selectAll")
    public JsonResult selectAll(GoodEvaluate goodEvaluate,Integer current){
        log.info("查找评价的方法");
        log.info("获取前端参数："+goodEvaluate);
        List<GoodEvaluate> goodEvaluateList=iGoodEvaluateService.selectAll(goodEvaluate);
        return new JsonResult(new PageInfo(current,10,goodEvaluateList).getRecords());
    }


}

