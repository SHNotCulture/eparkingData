package com.eparkingdata.controller;

import com.eparkingdata.service.TBindingParkingService;
import com.eparkingdata.aspect.HttpLog;
import com.eparkingdata.entity.TBindingParking;
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
* @Description: TBindingParkingController类
* @author 谢轩然
* @date 2020/04/08 18:18
*/
@RestController
@RequestMapping("/tBindingParking")
public class TBindingParkingController {

    private  static final Logger logger= LoggerFactory.getLogger(TBindingParkingController.class);

    @Autowired
    private TBindingParkingService tBindingParkingService;

    /**
    * 查询TBindingParking信息
    * @paramtBindingParking
    * @return
    */
    @PostMapping(value = "/getTBindingParking")
    @HttpLog(operationType = "0",modularTypeName = "查询TBindingParking")
    public ActionRsp getTBindingParking(@RequestBody TBindingParking tBindingParking,HttpServletRequest request){
    return ActionRspUtil.Success(tBindingParkingService.getTBindingParking(tBindingParking));
    }

    /**
    * 查询TBindingParking信息(分页)
    * @paramtBindingParking
    * @return
    */
    @PostMapping(value = "/getTBindingParkingbyPage")
    @HttpLog(operationType = "0",modularTypeName = "查询TBindingParking(分页)")
    public ControllerRsp getTBindingParkingbyPage(@RequestBody TBindingParking tBindingParking,HttpServletRequest request,Integer page, Integer limit){
    return ControllerRspUtil.Success(tBindingParkingService.getTBindingParkingbyPage(tBindingParking,page,limit));
    }

    /**
    * 更新TBindingParking信息
    * @paramtBindingParking
    * @return
    */
    @PostMapping(value = "/updateTBindingParking")
    @HttpLog(operationType = "1",modularTypeName = "更新TBindingParking信息")
    public ActionRsp UpdateTBindingParking(@RequestBody TBindingParking tBindingParking,HttpServletRequest request)
    {
        return ActionRspUtil.Success(tBindingParkingService. UpdateTBindingParking(tBindingParking));
    }

    /**
    * 删除TBindingParking信息
    * @param tBindingParking
    * @return
    */
    @PostMapping(value = "/deleteTBindingParking")
    @HttpLog(operationType = "1",modularTypeName = "删除TBindingParking信息")
    public ActionRsp DeleteTBindingParking(@RequestBody TBindingParking tBindingParking){
    return ActionRspUtil.Success(tBindingParkingService.DeleteTBindingParking( tBindingParking));
    }
}