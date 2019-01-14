package com.dyb.yanbangbang.web;


import com.dyb.yanbangbang.common.JsonResult;
import com.dyb.yanbangbang.entity.ReceiveAddress;
import com.dyb.yanbangbang.entity.User;
import com.dyb.yanbangbang.service.IReceiveAddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Tang
 * @since 2019-01-04
 */
@CrossOrigin
@RestController
@RequestMapping("/receiveAddress/")
public class ReceiveAddressController {
    private static final Logger log = LoggerFactory.getLogger(ReceiveAddressController.class);

    @Autowired
    private IReceiveAddressService iReceiveAddressService;

    /**
     * 添加和修改的方法
     * @param receiveAddress
     * @return
     */
    @PostMapping("save")
    public JsonResult save(ReceiveAddress receiveAddress){
        log.info("进入方法"+receiveAddress);
        iReceiveAddressService.save(receiveAddress);
        return new JsonResult();
    }

    /**
     * 查询的方法
     * @param user
     * @return
     */
    @PostMapping("selectAll")
    public JsonResult select(User user){
        log.info("进入查询方法");
        return new JsonResult(iReceiveAddressService.selectByUser(user));
    }

    /**
     * 删除的方法
     * @param addressId
     * @return
     */
    @PostMapping("del")
    public JsonResult del(Integer addressId){
        log.info("进入删除方法");
        return new JsonResult(iReceiveAddressService.del(addressId));
    }

    /**
     * 查询的方法
     * @param user
     * @return
     */
    @PostMapping("selectByUserId")
    public JsonResult selectOne(User user){
        log.info("进入查询方法");
        return new JsonResult(iReceiveAddressService.selectOne(user));
    }

}

