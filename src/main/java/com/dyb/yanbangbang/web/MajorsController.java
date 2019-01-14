package com.dyb.yanbangbang.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dyb.yanbangbang.common.JsonResult;
import com.dyb.yanbangbang.entity.Majors;
import com.dyb.yanbangbang.service.IMajorsService;
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
 * 大学专业表 前端控制器
 * </p>
 *
 * @author Tang
 * @since 2018-12-19
 */
@RestController
@RequestMapping("/majors/")
public class MajorsController {
    private static final Logger log = LoggerFactory.getLogger(MajorsController.class);
    @Autowired
    private IMajorsService iMajorsService;

    /**
     * 获取所有专业信息
     * @return
     */
    @GetMapping("getAll")
    public JsonResult getAll(){
        List<Map<String,Object>> resList = new ArrayList<>();   //存放最终结果
        //查找专业分类
        List<Majors> majorTypeList = iMajorsService.selectList(new EntityWrapper<Majors>().eq("p_id",0));
        List<Majors> majorsList = iMajorsService.selectList(new EntityWrapper<Majors>());
        if(majorTypeList.size() > 0 && majorsList.size() > 0){
            for(Majors t: majorTypeList){
                Map<String,Object> map = new HashMap<>();   //存放门类与专业映射信息
                List<String> majorName = new ArrayList<>();
                map.put("name",t.getMajorName().substring(5));
                for (Majors m: majorsList){
                   if(t.getMajorId() == m.getpId()){
                       majorName.add(m.getMajorName());
                   }
                }

                map.put("major",majorName);

                resList.add(map);

                map = null;
                majorName = null;

            }
        }
        return new JsonResult(resList);
    }

}

