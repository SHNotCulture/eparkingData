package com.eparkingdata.controller;

import com.eparkingdata.service.TBusinePayService;
import com.eparkingdata.entity.TBusinePay;

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
* @Description: TBusinePayController类
* @author 谢轩然
* @date 2020/04/09 10:50
*/
@RestController
@RequestMapping("/tBusinePay")
public class TBusinePayController {

    private  static final Logger logger= LoggerFactory.getLogger(TBusinePayController.class);

    @Autowired
    private TBusinePayService tBusinePayService;

    /**
    * 查询TBusinePay信息
    * @paramtBusinePay
    * @return
    */
    @PostMapping(value = "/getTBusinePay")
    @HttpLog(operationType = "0",modularTypeName = "查询TBusinePay")
    public ActionRsp getTBusinePay(@RequestBody TBusinePay tBusinePay,HttpServletRequest request, String beginTime, String endTime){
    return ActionRspUtil.Success(tBusinePayService.getTBusinePay(tBusinePay,beginTime,endTime));
    }

    /**
    * 查询TBusinePay信息(分页)
    * @paramtBusinePay
    * @return
    */
    @PostMapping(value = "/getTBusinePaybyPage")
    @HttpLog(operationType = "0",modularTypeName = "查询TBusinePay(分页)")
    public ControllerRsp getTBusinePaybyPage(@RequestBody TBusinePay tBusinePay,HttpServletRequest request,Integer page, Integer limit, String beginTime, String endTime){
    return ControllerRspUtil.Success(tBusinePayService.getTBusinePaybyPage(tBusinePay,page,limit,beginTime,endTime));
    }

    /**
    * 更新TBusinePay信息
    * @paramtBusinePay
    * @return
    */
    @PostMapping(value = "/updateTBusinePay")
    @HttpLog(operationType = "1",modularTypeName = "更新TBusinePay信息")
    public ActionRsp UpdateTBusinePay(@RequestBody TBusinePay tBusinePay,HttpServletRequest request)
    {
        return ActionRspUtil.Success(tBusinePayService. UpdateTBusinePay(tBusinePay));
    }

    /**
    * 删除TBusinePay信息
    * @param tBusinePay
    * @return
    */
    @PostMapping(value = "/deleteTBusinePay")
    @HttpLog(operationType = "1",modularTypeName = "删除TBusinePay信息")
    public ActionRsp DeleteTBusinePay(@RequestBody TBusinePay tBusinePay){
    return ActionRspUtil.Success(tBusinePayService.DeleteTBusinePay( tBusinePay));
    }
}