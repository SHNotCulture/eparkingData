package com.eparkingdata.controller;

import com.eparkingdata.aspect.HttpLog;
import com.eparkingdata.entity.TApikey;
import com.eparkingdata.service.TApikeyService;
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
* @Description: TApikeyController类
* @author 谢轩然
* @date 2020/04/08 17:46
*/
@RestController
@RequestMapping("/tApikey")
public class TApikeyController {

    private  static final Logger logger= LoggerFactory.getLogger(TApikeyController.class);

    @Autowired
    private TApikeyService tApikeyService;

    /**
    * 查询TApikey信息
    * @paramtApikey
    * @return
    */
    @PostMapping(value = "/getTApikey")
    @HttpLog(operationType = "0",modularTypeName = "查询TApikey")
    public ActionRsp getTApikey(@RequestBody TApikey tApikey,HttpServletRequest request){
    return ActionRspUtil.Success(tApikeyService.getTApikey(tApikey));
    }

    /**
    * 查询TApikey信息(分页)
    * @paramtApikey
    * @return
    */
    @PostMapping(value = "/getTApikeybyPage")
    @HttpLog(operationType = "0",modularTypeName = "查询TApikey(分页)")
    public ControllerRsp getTApikeybyPage(@RequestBody TApikey tApikey,HttpServletRequest request,Integer page, Integer limit){
    return ControllerRspUtil.Success(tApikeyService.getTApikeybyPage(tApikey,page,limit));
    }

    /**
    * 更新TApikey信息
    * @paramtApikey
    * @return
    */
    @PostMapping(value = "/updateTApikey")
    @HttpLog(operationType = "1",modularTypeName = "更新TApikey信息")
    public ActionRsp UpdateTApikey(@RequestBody TApikey tApikey,HttpServletRequest request)
    {
        return ActionRspUtil.Success(tApikeyService. UpdateTApikey(tApikey));
    }

    /**
    * 删除TApikey信息
    * @param tApikey
    * @return
    */
    @PostMapping(value = "/deleteTApikey")
    @HttpLog(operationType = "1",modularTypeName = "删除TApikey信息")
    public ActionRsp DeleteTApikey(@RequestBody TApikey tApikey){
    return ActionRspUtil.Success(tApikeyService.DeleteTApikey( tApikey));
    }
}