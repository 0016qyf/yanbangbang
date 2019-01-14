package com.dyb.yanbangbang.service;

import com.baomidou.mybatisplus.service.IService;
import com.dyb.yanbangbang.entity.Collect;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Tang
 * @since 2018-12-19
 */
public interface ICollectService extends IService<Collect>  {
    boolean save(Collect collect);

    boolean del(Integer[] collectIds);

    List selectAll(Integer user, Integer type);
}
