package com.eparkingdata.controller;

import com.eparkingdata.service.TElectronPaymentService;
import com.eparkingdata.entity.TElectronPayment;

import com.eparkingdata.service.TElectronPaymentService;
import com.eparkingdata.aspect.HttpLog;
import com.eparkingdata.util.ControllerRspUtil;
import com.eparkingdata.util.ActionRspUtil;
import com.eparkingdata.util.ControllerRsp;
import com.eparkingdata.util.ActionRsp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

/**
* @Description: TElectronPaymentController类
* @author 谢轩然
* @date 2020/04/09 14:58
*/
@RestController
@RequestMapping("/tElectronPayment")
public class TElectronPaymentController {

    private  static final Logger logger= LoggerFactory.getLogger(TElectronPaymentController.class);

    @Autowired
    private TElectronPaymentService tElectronPaymentService;

    /**
    * 查询TElectronPayment信息
    * @paramtElectronPayment
    * @return
    */
    @PostMapping(value = "/getTElectronPayment")
    @HttpLog(operationType = "0",modularTypeName = "查询TElectronPayment")
    public ActionRsp getTElectronPayment(@RequestBody TElectronPayment tElectronPayment,HttpServletRequest request){
    return ActionRspUtil.Success(tElectronPaymentService.getTElectronPayment(tElectronPayment));
    }

    /**
    * 查询TElectronPayment信息(分页)
    * @paramtElectronPayment
    * @return
    */
    @PostMapping(value = "/getTElectronPaymentbyPage")
    @HttpLog(operationType = "0",modularTypeName = "查询TElectronPayment(分页)")
    public ControllerRsp getTElectronPaymentbyPage(@RequestBody TElectronPayment tElectronPayment,HttpServletRequest request,Integer page, Integer limit){
    return ControllerRspUtil.Success(tElectronPaymentService.getTElectronPaymentbyPage(tElectronPayment,page,limit));
    }

    /**
    * 更新TElectronPayment信息
    * @paramtElectronPayment
    * @return
    */
    @PostMapping(value = "/updateTElectronPayment")
    @HttpLog(operationType = "1",modularTypeName = "更新TElectronPayment信息")
    public ActionRsp UpdateTElectronPayment(@RequestBody TElectronPayment tElectronPayment,HttpServletRequest request)
    {
        return ActionRspUtil.Success(tElectronPaymentService. UpdateTElectronPayment(tElectronPayment));
    }

    /**
    * 删除TElectronPayment信息
    * @param tElectronPayment
    * @return
    */
    @PostMapping(value = "/deleteTElectronPayment")
    @HttpLog(operationType = "1",modularTypeName = "删除TElectronPayment信息")
    public ActionRsp DeleteTElectronPayment(@RequestBody TElectronPayment tElectronPayment){
    return ActionRspUtil.Success(tElectronPaymentService.DeleteTElectronPayment( tElectronPayment));
    }
}