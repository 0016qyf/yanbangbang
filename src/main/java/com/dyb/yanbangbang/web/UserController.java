package com.dyb.yanbangbang.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dyb.yanbangbang.common.FileTool;
import com.dyb.yanbangbang.common.JsonResult;
import com.dyb.yanbangbang.entity.Checks;
import com.dyb.yanbangbang.entity.Resource;
import com.dyb.yanbangbang.entity.ResourceDetail;
import com.dyb.yanbangbang.entity.User;
import com.dyb.yanbangbang.service.IChecksService;
import com.dyb.yanbangbang.service.IResourceDetailService;
import com.dyb.yanbangbang.service.IResourceService;
import com.dyb.yanbangbang.service.IUserService;
import com.dyb.yanbangbang.utils.OSSClientUtil;
import com.dyb.yanbangbang.utils.PageInfo;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  用户信息表
 * </p>
 *
 * @author Tang
 * @since 2018-12-19
 */
@CrossOrigin
@RestController
@RequestMapping("/user/")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private IUserService iUserService;

    @Autowired
    private IResourceDetailService iResourceDetailService;

    @Autowired
    private IResourceService iResourceService;

    @Autowired
    private IChecksService iChecksService;


    @PostMapping(value = "selectByUserId")
    public JsonResult selectByUserId(User user){
        log.info("根据主键查询uesr");
        return new JsonResult(iUserService.selectUser(user.getUserId()));
    }

    /**
     * 找用户下家的方法
     * @param user
     * @param current
     * @return
     */
    @PostMapping("selectByPid")
    public JsonResult selectByPid(User user, Integer current){
        log.info("进入找下家的方法");
        List<User> users=iUserService.selectByPid(user);
        return new JsonResult(new PageInfo(current,10,users));
    }
    /**
     * 修改用户信息
     * @return
     */
    @Transactional
    @PostMapping("updateUserInfo")
    public JsonResult updateUserInfo (User user,boolean isAddCheck){
        log.info("修改方法");
        if(isAddCheck){
            List<Checks> list=iChecksService.selectList(new EntityWrapper<Checks>().eq("be_checked_id",user.getUserId()));
            if(list.size()==0) {
                Checks checks = new Checks();
                checks.setState(2);
                checks.setType(2);
                checks.setBeCheckedId(user.getUserId());
                checks.setCheckTime(new Date());
                iChecksService.insert(checks);
            }else {
                Checks checks =list.get(0);
                checks.setType(2);
                checks.setState(2);
                checks.setCheckTime(new Date());
                iChecksService.updateById(checks);
            }
        }
        iUserService.updateByUserId(user);
        return new JsonResult();
    }

    /**
     * 验证邀请码
     * @param inviteCode
     * @return
     */
    @PostMapping("checkInviteCode")
    public JsonResult checkInviteCode(String inviteCode){
        int userId = iUserService.checkInviteCode(inviteCode);
        Map<String,Integer> map = new HashMap<>();
        map.put("userId",userId);
        return new JsonResult(map);
    }
    /**
     * 获取用户信息
     */
    @GetMapping("getUserInfo")
    public JsonResult getUserInfo (int userId){
        System.out.println("============ userId: "+userId);
        Map<String,Object> map = new HashMap<>();
        try {
            User user = iUserService.selectUser(userId);
            //对用户昵称进行解码
            String nikeName = new String(Base64.decodeBase64(user.getNikeName()),"UTF-8");
            map.put("userId",user.getUserId());
            map.put("openid",user.getOpenid());
            map.put("phone",user.getPhone());
            map.put("avatarurl",user.getAvatarurl());
            map.put("nikeName",nikeName);
            map.put("gender",user.getGender());
            map.put("type",user.getType());
            map.put("school",user.getSchool());
            map.put("major",user.getMajor());
            map.put("state",user.getState());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new JsonResult(map);
    }


    /**
     * 上传图片
     * @param request
     * @param userId
     * @param fileName
     * @return
     */
    @RequestMapping("uploadFiles")
    public synchronized Map upload(MultipartHttpServletRequest request, Integer userId, String fileName) {
        log.info("从前台获取到的userId： "+userId);
        log.info("从前台获取到的fileName： "+fileName);
        String filePath = "D://opt/uploadResource";
        Map<String,Object> resMap = new HashMap<>();
        resMap.put("success",false);
        try {
            User user=iUserService.selectById(userId);
            MultiValueMap<String,MultipartFile> multiValueMap = request.getMultiFileMap();
            List<MultipartFile> files = multiValueMap.get("files");
            if (null == files || files.size() == 0) {
                resMap.put("success",false);
                resMap.put("msg","检测到您未选择图片，请刷新页面后重试！");
            }

            if("身份证".equals(fileName)){
                if(user.getIdcardImg()!=null){
                    del(user.getIdcardImg(),true);
                }
            }
            if("学生证".equals(fileName)) {
                if(user.getStuCardOrOfferImg()!=null){
                    del(user.getStuCardOrOfferImg(),false);
                }
            }
            if("成绩证明".equals(fileName)) {
                if(user.getMajorScoreImg()!=null){
                    del(user.getMajorScoreImg(),false);
                }
            }
            synchronized (this) {
                log.info("保存本地============");
                List<String> urls = FileTool.uploadFileToLocal(files, filePath, new Date().getTime() + "" + userId + fileName);
                log.info("数量" + urls.size());
                for (String url : urls) {
                    log.info("文件上传到本地后获取到的url: " + url);
                    String name = url.substring(url.lastIndexOf("/") + 1);
                    log.info("截取到的文件名： " + name);
                    //上传文件到云存储并获取url
                    String remoteUrl = OSSClientUtil.upload(url, name);
                    Resource resource = iResourceService.selectOne(new EntityWrapper<Resource>().eq("uploader_id", userId).eq("resource_name", fileName));
                    if (remoteUrl != null && resource == null) {
                        //资源主表插入一条资源记录
                        Resource res = new Resource();
                        res.setCreateTime(new Date());
                        res.setResourceName(fileName);
                        res.setUploaderId(userId);
                        res.setResourceSummary(fileName + "照片");
                        log.info("执行添加方法");
                        boolean flag = iResourceService.insert(res);
                        if (flag) {
                            resource = iResourceService.selectOne(new EntityWrapper<Resource>().eq("uploader_id", userId).and().eq("resource_name", fileName));
                        }
                        if ("身份证".equals(fileName)) {
                            user.setIdcardImg(resource.getResourceId());
                        }
                        if ("学生证".equals(fileName)) {
                            user.setStuCardOrOfferImg(resource.getResourceId());
                        }
                        if ("成绩证明".equals(fileName)) {
                            user.setMajorScoreImg(resource.getResourceId());
                        }
                        log.info("修改的方法");
                        iUserService.updateById(user);


                    }

                    if (remoteUrl != null) {
                        ResourceDetail resourceDetail = new ResourceDetail();
                        resourceDetail.setUrl(remoteUrl);
                        resourceDetail.setFileName(name);
                        resourceDetail.setResourceId(resource.getResourceId());
                        resourceDetail.setKey(name);
                        resourceDetail.setType(1);
                        boolean res = iResourceDetailService.insert(resourceDetail);

                        if (res) {
                            resMap.put("success", true);
                            resMap.put("msg", "图片上传成功！");
                            return resMap;
                        }
                    }

                }
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        return resMap;
    }

    public void del(Integer id,boolean isIdcard){
        log.info("删除数据");
        List<ResourceDetail> resourceDetails=iResourceDetailService.selectList(new EntityWrapper<ResourceDetail>().eq("resource_id",id));
        if(!(isIdcard&&resourceDetails.size()<2)) {
            log.info("开始删除");
            for (int i = 0; i < resourceDetails.size(); i++) {
                log.info("删除云上的数据");
                OSSClientUtil.del(resourceDetails.get(i).getKey());
                iResourceDetailService.deleteById(resourceDetails.get(i).getResourceDetailId());
            }
            iResourceService.deleteById(id);
        }
    }


}

