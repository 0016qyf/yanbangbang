package com.dyb.yanbangbang.service;

import com.baomidou.mybatisplus.service.IService;
import com.dyb.yanbangbang.entity.Check;
import com.dyb.yanbangbang.entity.Material;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Tang
 * @since 2018-12-29
 */
public interface ICheckService extends IService<Check> {

    List<Map> selectByMaterials(List<Material> materials);

}
