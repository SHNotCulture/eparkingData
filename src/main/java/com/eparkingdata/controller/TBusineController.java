package com.eparkingdata.controller;

import com.eparkingdata.aspect.HttpLog;
import com.eparkingdata.entity.TBusine;
import com.eparkingdata.entity.TBusinePay;
import com.eparkingdata.service.TBusineService;
import com.eparkingdata.util.ActionRsp;
import com.eparkingdata.util.ActionRspUtil;
import com.eparkingdata.util.ControllerRsp;
import com.eparkingdata.util.ControllerRspUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
* @Description: TBusineController类
* @author 谢轩然
* @date 2020/04/08 18:35
*/
@RestController
@RequestMapping("/tBusine")
public class TBusineController {

    private  static final Logger logger= LoggerFactory.getLogger(TBusineController.class);

    @Autowired
    private TBusineService tBusineService;

    /**
    * 查询TBusine信息
    * @paramtBusine
    * @return
    */
    @PostMapping(value = "/getTBusine")
    @HttpLog(operationType = "0",modularTypeName = "查询TBusine")
    public ActionRsp getTBusine(@RequestBody TBusine tBusine,HttpServletRequest request){
    return ActionRspUtil.Success(tBusineService.getTBusine(tBusine));
    }

    /**
    * 查询TBusine信息(分页)
    * @paramtBusine
    * @return
    */
    @PostMapping(value = "/getTBusinebyPage")
    @HttpLog(operationType = "0",modularTypeName = "查询TBusine(分页)")
    public ControllerRsp getTBusinebyPage(@RequestBody TBusine tBusine,HttpServletRequest request,Integer page, Integer limit){
    return ControllerRspUtil.Success(tBusineService.getTBusinebyPage(tBusine,page,limit));
    }

    /**
    * 更新TBusine信息
    * @paramtBusine
    * @return
    */
    @PostMapping(value = "/updateTBusine")
    @HttpLog(operationType = "1",modularTypeName = "更新TBusine信息")
    public ActionRsp UpdateTBusine(@RequestBody TBusine tBusine,HttpServletRequest request)
    {
        return ActionRspUtil.Success(tBusineService.UpdateTBusine(tBusine));
    }

    /**
    * 删除TBusine信息
    * @param tBusine
    * @return
    */
    @PostMapping(value = "/deleteTBusine")
    @HttpLog(operationType = "1",modularTypeName = "删除TBusine信息")
    public ActionRsp DeleteTBusine(@RequestBody TBusine tBusine){
    return ActionRspUtil.Success(tBusineService.DeleteTBusine(tBusine));
    }

    @PostMapping(value = "/getBusineRecharge")
    @HttpLog(operationType = "1",modularTypeName = "")
    public ActionRsp getBusineRecharge(@RequestBody TBusinePay tBusinePay, String type){
        return ActionRspUtil.Success(tBusineService.BusineRecharge(tBusinePay,type));
    }

    @PostMapping(value = "/selectByAccount")
    @HttpLog(operationType = "1",modularTypeName = "根据账号查询商户")
    public ActionRsp selectByAccount(@RequestParam("account") String account){
        return ActionRspUtil.Success(tBusineService.selectByAccount(account));
    }
}