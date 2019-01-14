package com.dyb.yanbangbang.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dyb.yanbangbang.common.JsonResult;
import com.dyb.yanbangbang.entity.Schools;
import com.dyb.yanbangbang.service.ISchoolsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Tang
 * @since 2018-12-19
 */
@RestController
@RequestMapping("/schools/")
public class SchoolsController {
    private static final Logger log = LoggerFactory.getLogger(SchoolsController.class);
    @Autowired
    private ISchoolsService iSchoolsService;

    /**
     * 获取所有学校信息
     * @return
     */
    @GetMapping("getAll")
    public JsonResult getAll(){
        List<Schools> schools = iSchoolsService.selectList(new EntityWrapper<Schools>().eq("school_type_id","1"));
        return new JsonResult(schools);
    }

}

