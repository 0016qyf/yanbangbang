package com.dyb.yanbangbang.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dyb.yanbangbang.entity.Material;
import com.dyb.yanbangbang.entity.Orders;
import com.dyb.yanbangbang.mapper.OrdersMapper;
import com.dyb.yanbangbang.service.IOrdersService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Tang
 * @since 2018-12-24
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {


    /**
     * 根据主键修改订单状态
     * @param orderId
     * @param states
     * @return
     */
    @Override
    public boolean updateState(Integer orderId, Integer states) {
        //抛异常
        if(orderId==null||states==null){
            throw new NullPointerException(""
                    + "传入的值为空");
        }
        Orders orders=new Orders();
        orders.setOrderId((long)orderId);
        orders.setState(states);
        return updateById(orders);
    }

    /**
     * 根据条件查找用户订单
     * @param userid
     * @return
     */
    @Override
    public  List<Orders> selectByUser(Integer userid) {
        if(userid==null){
            throw new NullPointerException(""
                    + "传入的值为空");
        }
        Map map=new HashMap<>();
        List<Orders> list=selectList(new EntityWrapper<Orders>().eq("buyer_id",userid));

        return list;
    }

    @Override
    public List<Orders> selectByMater(Integer materialId, Integer userid) {
        if(userid==null||materialId==null){
            throw new NullPointerException(""
                    + "传入的值为空");
        }
        return selectList(new EntityWrapper<Orders>().eq("material_id",materialId).and().eq("buyer_id",userid));
    }

    @Override
    public List<Orders> selectByMaterIds(List<Material> materials) {
        if(materials==null){
            throw new NullPointerException(""
                    + "传入的值为空");
        }
        List<Orders> list=new ArrayList<>();
        for (int i=0;i<materials.size();i++){
           list.addAll(selectList(new EntityWrapper<Orders>().in("state",new String[] {"2","3","4","9","1"}).eq("material_id",materials.get(i).getMaterialId())));
        }
        return list;
    }

    /**
     * 计算销量
     * @param material
     * @param type
     * @return
     */
    @Override
    public Integer selectNum(Material material,Integer type) {
        //获取销量
        if(material==null||type==null){
            throw new NullPointerException(""
                    + "传入的值为空");
        }
        //订单状态：0---未付款   1---已付款    2---待发货   3---已发货   4---已完成   5---申请退款   6---退款中   7---已退款    8---已取消    9---待评价
        //获取前一个月最后一天
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.DAY_OF_MONTH, 0);
        String lastDay = sdf.format(calendar2.getTime());
        List<Orders> list=null;
        //type:0查看所有   1查看本月
        list=type==0?selectList(new EntityWrapper<Orders>().in("state",new String[] {"2","3","4","9","1"}).eq("material_id",material.getMaterialId())):list;
        list=type==1?selectList(new EntityWrapper<Orders>().in("state",new String[] {"2","3","4","9","1"}).eq("material_id",material.getMaterialId()).gt("pay_time",lastDay)):list;
        return list.size();
    }

    /**
     * 计算金额
     * @param material
     * @param type
     * @return
     */
    @Override
    public BigDecimal selectMoney(Material material, Integer type) {
        //获取销量
        if(material==null||type==null){
            throw new NullPointerException(""
                    + "传入的值为空");
        }
        //订单状态：0---未付款   1---已付款    2---待发货   3---已发货   4---已完成   5---申请退款   6---退款中   7---已退款    8---已取消    9---待评价
        //获取前一个月最后一天
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.DAY_OF_MONTH, 0);
        String lastDay = sdf.format(calendar2.getTime());
        List<Orders> list=null;
        //type:0查看所有   1查看本月
        list=type==0?selectList(new EntityWrapper<Orders>().in("state",new String[] {"2","3","4","9","1"}).eq("material_id",material.getMaterialId())):list;
        list=type==1?selectList(new EntityWrapper<Orders>().in("state",new String[] {"2","3","4","9","1"}).eq("material_id",material.getMaterialId()).gt("pay_time",lastDay)):list;
        BigDecimal money=new BigDecimal(0);
        System.out.println("数量"+list.size());
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
            money=money.add(list.get(i).getTotalMoney());
        }
        return money;
    }
}
