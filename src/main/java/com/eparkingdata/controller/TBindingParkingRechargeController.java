package com.eparkingdata.controller;

import com.eparkingdata.aspect.HttpLog;
import com.eparkingdata.entity.TBindingParkingRecharge;
import com.eparkingdata.service.TBindingParkingRechargeService;
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
* @Description: TBindingParkingRechargeController类
* @author 谢轩然
* @date 2020/04/08 18:25
*/
@RestController
@RequestMapping("/tBindingParkingRecharge")
public class TBindingParkingRechargeController {

    private  static final Logger logger= LoggerFactory.getLogger(TBindingParkingRechargeController.class);

    @Autowired
    private TBindingParkingRechargeService tBindingParkingRechargeService;

    /**
    * 查询TBindingParkingRecharge信息
    * @paramtBindingParkingRecharge
    * @return
    */
    @PostMapping(value = "/getTBindingParkingRecharge")
    @HttpLog(operationType = "0",modularTypeName = "查询TBindingParkingRecharge")
    public ActionRsp getTBindingParkingRecharge(@RequestBody TBindingParkingRecharge tBindingParkingRecharge,HttpServletRequest request){
    return ActionRspUtil.Success(tBindingParkingRechargeService.getTBindingParkingRecharge(tBindingParkingRecharge));
    }

    /**
    * 查询TBindingParkingRecharge信息(分页)
    * @paramtBindingParkingRecharge
    * @return
    */
    @PostMapping(value = "/getTBindingParkingRechargebyPage")
    @HttpLog(operationType = "0",modularTypeName = "查询TBindingParkingRecharge(分页)")
    public ControllerRsp getTBindingParkingRechargebyPage(@RequestBody TBindingParkingRecharge tBindingParkingRecharge,HttpServletRequest request,Integer page, Integer limit){
    return ControllerRspUtil.Success(tBindingParkingRechargeService.getTBindingParkingRechargebyPage(tBindingParkingRecharge,page,limit));
    }

    /**
    * 更新TBindingParkingRecharge信息
    * @paramtBindingParkingRecharge
    * @return
    */
    @PostMapping(value = "/updateTBindingParkingRecharge")
    @HttpLog(operationType = "1",modularTypeName = "更新TBindingParkingRecharge信息")
    public ActionRsp UpdateTBindingParkingRecharge(@RequestBody TBindingParkingRecharge tBindingParkingRecharge,HttpServletRequest request)
    {
        return ActionRspUtil.Success(tBindingParkingRechargeService. UpdateTBindingParkingRecharge(tBindingParkingRecharge));
    }

    /**
    * 删除TBindingParkingRecharge信息
    * @param tBindingParkingRecharge
    * @return
    */
    @PostMapping(value = "/deleteTBindingParkingRecharge")
    @HttpLog(operationType = "1",modularTypeName = "删除TBindingParkingRecharge信息")
    public ActionRsp DeleteTBindingParkingRecharge(@RequestBody TBindingParkingRecharge tBindingParkingRecharge){
    return ActionRspUtil.Success(tBindingParkingRechargeService.DeleteTBindingParkingRecharge( tBindingParkingRecharge));
    }
}