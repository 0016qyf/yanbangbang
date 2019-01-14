package com.dyb.yanbangbang.service.impl;

import com.dyb.yanbangbang.entity.Notice;
import com.dyb.yanbangbang.mapper.NoticeMapper;
import com.dyb.yanbangbang.service.INoticeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Tang
 * @since 2018-12-29
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements INoticeService {

    @Override
    public boolean save(Notice notice,Integer rescouceId) {
        if(notice==null){
            throw new NullPointerException(""
                    + "传入的值为空");
        }
        notice.setCreateTime(new Date());
        notice.setState(0);
        notice.setResourceId(rescouceId);
        return insert(notice);
    }

    @Override
    public List<Notice> selectAll() {

        return null;
    }
}
