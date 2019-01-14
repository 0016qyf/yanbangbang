package com.dyb.yanbangbang.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dyb.yanbangbang.common.JsonResult;
import com.dyb.yanbangbang.entity.Provinces;
import com.dyb.yanbangbang.entity.Schools;
import com.dyb.yanbangbang.service.IProvincesService;
import com.dyb.yanbangbang.service.ISchoolsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
 * @since 2018-12-19
 */
@RestController
@RequestMapping("/provinces/")
public class ProvincesController {

    private static final Logger log = LoggerFactory.getLogger(ProvincesController.class);
    @Autowired
    private IProvincesService iProvincesService;
    @Autowired
    private ISchoolsService iSchoolsService;

    /**
     * 获取所有省份信息和省份的学校信息
     * @return
     */
    @GetMapping("getProvinceAndSchool")
    public JsonResult getProvinceAndSchool(){
        List<Map<String,Object>> resList = new ArrayList<>();   //存放最终结果

        List<Provinces> provincesList = iProvincesService.selectList(new EntityWrapper<>());
        //查找本科院校
        List<Schools> schoolsList = iSchoolsService.selectList(new EntityWrapper<Schools>().eq("school_type_id","1"));
        if (provincesList.size() > 0 && schoolsList.size() > 0 )  {
            for (Provinces p: provincesList) {
                Map<String,Object> map = new HashMap<>();   //存放省份与学校映射信息
                List<String> schoolsName = new ArrayList<>();
                map.put("name",p.getName());
                for (Schools s: schoolsList ) {
                    if (s.getSchoolProId() == p.getProvinceId()){
                        schoolsName.add(s.getSchoolName());
                    }
                }
                map.put("school",schoolsName);

                resList.add(map);

                map = null;
                schoolsName = null;
            }
        }
        return new JsonResult(resList);
    }
}

