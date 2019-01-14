package com.dyb.yanbangbang.service;

import com.baomidou.mybatisplus.service.IService;
import com.dyb.yanbangbang.entity.GoodEvaluate;
import com.dyb.yanbangbang.entity.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Tang
 * @since 2018-12-19
 */
public interface IGoodEvaluateService extends IService<GoodEvaluate> {

    Integer save(GoodEvaluate goodEvaluate,User user);

    boolean del(Integer[] goodEvaluates);

    List<GoodEvaluate> selectAll(GoodEvaluate goodEvaluate);
}
