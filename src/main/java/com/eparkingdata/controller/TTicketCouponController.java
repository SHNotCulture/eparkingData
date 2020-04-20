package com.eparkingdata.controller;

import com.eparkingdata.service.TTicketCouponService;
import com.eparkingdata.entity.TTicketCoupon;

import com.eparkingdata.service.TTicketCouponService;
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
* @Description: TTicketCouponController类
* @author 谢轩然
* @date 2020/04/10 11:47
*/
@RestController
@RequestMapping("/tTicketCoupon")
public class TTicketCouponController {

    private  static final Logger logger= LoggerFactory.getLogger(TTicketCouponController.class);

    @Autowired
    private TTicketCouponService tTicketCouponService;

    /**
    * 查询TTicketCoupon信息
    * @paramtTicketCoupon
    * @return
    */
    @PostMapping(value = "/getTTicketCoupon")
    @HttpLog(operationType = "0",modularTypeName = "查询TTicketCoupon")
    public ActionRsp getTTicketCoupon(@RequestBody TTicketCoupon tTicketCoupon,HttpServletRequest request){
    return ActionRspUtil.Success(tTicketCouponService.getTTicketCoupon(tTicketCoupon));
    }

    /**
    * 查询TTicketCoupon信息(分页)
    * @paramtTicketCoupon
    * @return
    */
    @PostMapping(value = "/getTTicketCouponbyPage")
    @HttpLog(operationType = "0",modularTypeName = "查询TTicketCoupon(分页)")
    public ControllerRsp getTTicketCouponbyPage(@RequestBody TTicketCoupon tTicketCoupon,HttpServletRequest request,Integer page, Integer limit){
    return ControllerRspUtil.Success(tTicketCouponService.getTTicketCouponbyPage(tTicketCoupon,page,limit));
    }

    /**
    * 更新TTicketCoupon信息
    * @paramtTicketCoupon
    * @return
    */
    @PostMapping(value = "/updateTTicketCoupon")
    @HttpLog(operationType = "1",modularTypeName = "更新TTicketCoupon信息")
    public ActionRsp UpdateTTicketCoupon(@RequestBody TTicketCoupon tTicketCoupon,HttpServletRequest request)
    {
        return ActionRspUtil.Success(tTicketCouponService. UpdateTTicketCoupon(tTicketCoupon));
    }

    /**
    * 删除TTicketCoupon信息
    * @param tTicketCoupon
    * @return
    */
    @PostMapping(value = "/deleteTTicketCoupon")
    @HttpLog(operationType = "1",modularTypeName = "删除TTicketCoupon信息")
    public ActionRsp DeleteTTicketCoupon(@RequestBody TTicketCoupon tTicketCoupon){
    return ActionRspUtil.Success(tTicketCouponService.DeleteTTicketCoupon( tTicketCoupon));
    }

    /**
     *电子优惠券记录查询
     * @return
     */
    @PostMapping(value = "/getticketCoupon")
    @HttpLog(operationType = "0",modularTypeName = "查询电子优惠券记录")
    public ControllerRsp gettTicketCoupon(@RequestBody TTicketCoupon tTicketCoupon,String InTimeBegin,String InTimeEnd,String OutTimeBegin,String OutTimeEnd){
        return ControllerRspUtil.Success(tTicketCouponService.getTElectronicTicket(tTicketCoupon,InTimeBegin,InTimeEnd,OutTimeBegin,OutTimeEnd));
    }
}