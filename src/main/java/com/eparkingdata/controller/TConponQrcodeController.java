package com.eparkingdata.controller;

import com.eparkingdata.service.TConponQrcodeService;
import com.eparkingdata.entity.TConponQrcode;

import com.eparkingdata.service.TConponQrcodeService;
import com.eparkingdata.aspect.HttpLog;
import com.eparkingdata.util.ControllerRspUtil;
import com.eparkingdata.util.ActionRspUtil;
import com.eparkingdata.util.ControllerRsp;
import com.eparkingdata.util.ActionRsp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
* @Description: TConponQrcodeController类
* @author 谢轩然
* @date 2020/04/09 14:55
*/
@RestController
@RequestMapping("/tConponQrcode")
public class TConponQrcodeController {

    private  static final Logger logger= LoggerFactory.getLogger(TConponQrcodeController.class);

    @Autowired
    private TConponQrcodeService tConponQrcodeService;

    /**
    * 查询TConponQrcode信息
    * @paramtConponQrcode
    * @return
    */
    @PostMapping(value = "/getTConponQrcode")
    @HttpLog(operationType = "0",modularTypeName = "查询TConponQrcode")
    public ActionRsp getTConponQrcode(@RequestBody TConponQrcode tConponQrcode,HttpServletRequest request){
    return ActionRspUtil.Success(tConponQrcodeService.getTConponQrcode(tConponQrcode));
    }

    /**
    * 查询TConponQrcode信息(分页)
    * @paramtConponQrcode
    * @return
    */
    @PostMapping(value = "/getTConponQrcodebyPage")
    @HttpLog(operationType = "0",modularTypeName = "查询TConponQrcode(分页)")
    public ControllerRsp getTConponQrcodebyPage(@RequestBody TConponQrcode tConponQrcode,HttpServletRequest request,Integer page, Integer limit){
    return ControllerRspUtil.Success(tConponQrcodeService.getTConponQrcodebyPage(tConponQrcode,page,limit));
    }

    /**
    * 更新TConponQrcode信息
    * @paramtConponQrcode
    * @return
    */
    @PostMapping(value = "/updateTConponQrcode")
    @HttpLog(operationType = "1",modularTypeName = "更新TConponQrcode信息")
    public ActionRsp UpdateTConponQrcode(@RequestBody TConponQrcode tConponQrcode,HttpServletRequest request)
    {
        return ActionRspUtil.Success(tConponQrcodeService. UpdateTConponQrcode(tConponQrcode));
    }

    /**
    * 删除TConponQrcode信息
    * @param tConponQrcode
    * @return
    */
    @PostMapping(value = "/deleteTConponQrcode")
    @HttpLog(operationType = "1",modularTypeName = "删除TConponQrcode信息")
    public ActionRsp DeleteTConponQrcode(@RequestBody TConponQrcode tConponQrcode){
    return ActionRspUtil.Success(tConponQrcodeService.DeleteTConponQrcode(tConponQrcode));
    }


    @PostMapping(value = "/tConponQrcode/existTConponQrcodeName")
    @HttpLog(operationType = "1",modularTypeName = "")
    public void existTConponQrcodeName(@RequestBody TConponQrcode tConponQrcode){
     tConponQrcodeService.existTConponQrcodeName(tConponQrcode);
    }

    @PostMapping(value = "/tConponQrcode/lessDiscountAmount")
    @HttpLog(operationType = "1",modularTypeName = "")
    public void lessDiscountAmount(@RequestBody TConponQrcode tConponQrcode,@RequestParam("busineId") Integer busineId){
        tConponQrcodeService.lessDiscountAmount(tConponQrcode,busineId);
    }
}