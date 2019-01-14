package com.dyb.yanbangbang.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dyb.yanbangbang.entity.ReceiveAddress;
import com.dyb.yanbangbang.entity.User;
import com.dyb.yanbangbang.mapper.ReceiveAddressMapper;
import com.dyb.yanbangbang.service.IReceiveAddressService;
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
 * @since 2019-01-04
 */
@Service
public class ReceiveAddressServiceImpl extends ServiceImpl<ReceiveAddressMapper, ReceiveAddress> implements IReceiveAddressService {


    @Override
    public ReceiveAddress save(ReceiveAddress receiveAddress) {

        if(receiveAddress==null){
            throw new NullPointerException(""
                    + "传入的值为空");
        }
        if(receiveAddress.getDetailAddressId()==null){
            receiveAddress.setCreateTime(new Date());
            if(receiveAddress.getIsDefault()==1){
                ReceiveAddress receive=new ReceiveAddress();
                EntityWrapper<ReceiveAddress> wrapper=new EntityWrapper<ReceiveAddress>();
                receive.setIsDefault(0);
                update(receive,wrapper.eq("user_id",receiveAddress.getUserId()).eq("is_default",1));
            }
            updateById(receiveAddress);
            insert(receiveAddress);
        }else {
            receiveAddress.setUpdateTime(new Date());
            if(receiveAddress.getIsDefault()==1){
                ReceiveAddress receive=new ReceiveAddress();
                EntityWrapper<ReceiveAddress> wrapper=new EntityWrapper<ReceiveAddress>();
                receive.setIsDefault(0);
                update(receive,wrapper.eq("user_id",receiveAddress.getUserId()).eq("is_default",1));
            }
            updateById(receiveAddress);
        }
        return receiveAddress;
    }

    @Override
    public List<ReceiveAddress> selectByUser(User user) {
        if(user==null){
            throw new NullPointerException(""
                    + "传入的值为空");
        }
        return selectList(new EntityWrapper<ReceiveAddress>().eq("user_id",user.getUserId()));
    }

    @Override
    public boolean del(Integer receiveAddressId) {
        if(receiveAddressId==null){
            throw new NullPointerException(""
                    + "传入的值为空");
        }
        return deleteById(receiveAddressId);
    }

    @Override
    public ReceiveAddress selectOne(User user) {
        if(user==null){
            throw new NullPointerException(""
                    + "传入的值为空");
        }
        List<ReceiveAddress> list= selectList(new EntityWrapper<ReceiveAddress>().eq("user_id",user.getUserId()));
        for (int i=0;i<list.size();i++){
            if(list.get(i).getIsDefault()==1){
                return list.get(i);
            }
        }
        return list.get(0);
    }
}
