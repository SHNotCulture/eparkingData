package com.eparkingdata.controller;

import com.eparkingdata.aspect.HttpLog;
import com.eparkingdata.entity.TCompanyUser;
import com.eparkingdata.service.TCompanyUserService;
import com.eparkingdata.util.ActionRsp;
import com.eparkingdata.util.ActionRspUtil;
import com.eparkingdata.util.ControllerRsp;
import com.eparkingdata.util.ControllerRspUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
* @Description: TCompanyUserController类
* @author 李书瀚
* @date 2020/04/08 17:24
*/
@RestController
@RequestMapping("/tCompanyUser")
public class TCompanyUserController {

    private  static final Logger logger= LoggerFactory.getLogger(TCompanyUserController.class);

    @Autowired
    private TCompanyUserService tCompanyUserService;

    /**
    * 查询TCompanyUser信息
    * @paramtCompanyUser
    * @return
    */
    @PostMapping(value = "/getTCompanyUser")
    @HttpLog(operationType = "0",modularTypeName = "查询TCompanyUser")
    public ActionRsp getTCompanyUser(@RequestBody TCompanyUser tCompanyUser,HttpServletRequest request){
    return ActionRspUtil.Success(tCompanyUserService.getTCompanyUser(tCompanyUser));
    }

    /**
    * 查询TCompanyUser信息(分页)
    * @paramtCompanyUser
    * @return
    */
    @PostMapping(value = "/getTCompanyUserbyPage")
    @HttpLog(operationType = "0",modularTypeName = "查询TCompanyUser(分页)")
    public ControllerRsp getTCompanyUserbyPage(@RequestBody TCompanyUser tCompanyUser,HttpServletRequest request,Integer page, Integer limit){
    return ControllerRspUtil.Success(tCompanyUserService.getTCompanyUserbyPage(tCompanyUser,page,limit));
    }

    /**
    * 更新TCompanyUser信息
    * @paramtCompanyUser
    * @return
    */
    @PostMapping(value = "/updateTCompanyUser")
    @HttpLog(operationType = "1",modularTypeName = "更新TCompanyUser信息")
    public ActionRsp UpdateTCompanyUser(@RequestBody TCompanyUser tCompanyUser,HttpServletRequest request)
    {
        return ActionRspUtil.Success(tCompanyUserService. UpdateTCompanyUser(tCompanyUser));
    }

    /**
    * 删除TCompanyUser信息
    * @param tCompanyUser
    * @return
    */
    @PostMapping(value = "/deleteTCompanyUser")
    @HttpLog(operationType = "1",modularTypeName = "删除TCompanyUser信息")
    public ActionRsp DeleteTCompanyUser(@RequestBody TCompanyUser tCompanyUser){
    return ActionRspUtil.Success(tCompanyUserService.DeleteTCompanyUser( tCompanyUser));
    }
}