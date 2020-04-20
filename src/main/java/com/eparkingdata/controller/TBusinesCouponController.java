package com.eparkingdata.controller;

import com.eparkingdata.service.TBusinesCouponService;
import com.eparkingdata.entity.TBusinesCoupon;

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
* @Description: TBusinesCouponController类
* @author 谢轩然
* @date 2020/04/09 11:57
*/
@RestController
@RequestMapping("/tBusinesCoupon")
public class TBusinesCouponController {

    private  static final Logger logger= LoggerFactory.getLogger(TBusinesCouponController.class);

    @Autowired
    private TBusinesCouponService tBusinesCouponService;

    /**
    * 查询TBusinesCoupon信息
    * @paramtBusinesCoupon
    * @return
    */
    @PostMapping(value = "/getTBusinesCoupon")
    @HttpLog(operationType = "0",modularTypeName = "查询TBusinesCoupon")
    public ActionRsp getTBusinesCoupon(@RequestBody TBusinesCoupon tBusinesCoupon,HttpServletRequest request){
    return ActionRspUtil.Success(tBusinesCouponService.getTBusinesCoupon(tBusinesCoupon));
    }

    /**
    * 查询TBusinesCoupon信息(分页)
    * @paramtBusinesCoupon
    * @return
    */
    @PostMapping(value = "/getTBusinesCouponbyPage")
    @HttpLog(operationType = "0",modularTypeName = "查询TBusinesCoupon(分页)")
    public ControllerRsp getTBusinesCouponbyPage(@RequestBody TBusinesCoupon tBusinesCoupon,HttpServletRequest request,Integer page, Integer limit){
    return ControllerRspUtil.Success(tBusinesCouponService.getTBusinesCouponbyPage(tBusinesCoupon,page,limit));
    }

    /**
    * 更新TBusinesCoupon信息
    * @paramtBusinesCoupon
    * @return
    */
    @PostMapping(value = "/updateTBusinesCoupon")
    @HttpLog(operationType = "1",modularTypeName = "更新TBusinesCoupon信息")
    public ActionRsp UpdateTBusinesCoupon(@RequestBody TBusinesCoupon tBusinesCoupon,HttpServletRequest request)
    {
        return ActionRspUtil.Success(tBusinesCouponService. UpdateTBusinesCoupon(tBusinesCoupon));
    }

    /**
    * 删除TBusinesCoupon信息
    * @param tBusinesCoupon
    * @return
    */
    @PostMapping(value = "/deleteTBusinesCoupon")
    @HttpLog(operationType = "1",modularTypeName = "删除TBusinesCoupon信息")
    public ActionRsp DeleteTBusinesCoupon(@RequestBody TBusinesCoupon tBusinesCoupon){
    return ActionRspUtil.Success(tBusinesCouponService.DeleteTBusinesCoupon( tBusinesCoupon));
    }
}