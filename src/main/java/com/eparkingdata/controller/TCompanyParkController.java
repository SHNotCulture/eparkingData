package com.eparkingdata.controller;

import com.eparkingdata.service.TCompanyParkService;
import com.eparkingdata.entity.TCompanyPark;

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
* @Description: TCompanyParkController类
* @author 谢轩然
* @date 2020/04/09 14:50
*/
@RestController
@RequestMapping("/tCompanyPark")
public class TCompanyParkController {

    private  static final Logger logger= LoggerFactory.getLogger(TCompanyParkController.class);

    @Autowired
    private TCompanyParkService tCompanyParkService;

    /**
    * 查询TCompanyPark信息
    * @paramtCompanyPark
    * @return
    */
    @PostMapping(value = "/getTCompanyPark")
    @HttpLog(operationType = "0",modularTypeName = "查询TCompanyPark")
    public ActionRsp getTCompanyPark(@RequestBody TCompanyPark tCompanyPark,HttpServletRequest request){
    return ActionRspUtil.Success(tCompanyParkService.getTCompanyPark(tCompanyPark));
    }

    /**
    * 查询TCompanyPark信息(分页)
    * @paramtCompanyPark
    * @return
    */
    @PostMapping(value = "/getTCompanyParkbyPage")
    @HttpLog(operationType = "0",modularTypeName = "查询TCompanyPark(分页)")
    public ControllerRsp getTCompanyParkbyPage(@RequestBody TCompanyPark tCompanyPark,HttpServletRequest request,Integer page, Integer limit){
    return ControllerRspUtil.Success(tCompanyParkService.getTCompanyParkbyPage(tCompanyPark,page,limit));
    }

    /**
    * 更新TCompanyPark信息
    * @paramtCompanyPark
    * @return
    */
    @PostMapping(value = "/updateTCompanyPark")
    @HttpLog(operationType = "1",modularTypeName = "更新TCompanyPark信息")
    public ActionRsp UpdateTCompanyPark(@RequestBody TCompanyPark tCompanyPark,HttpServletRequest request)
    {
        return ActionRspUtil.Success(tCompanyParkService. UpdateTCompanyPark(tCompanyPark));
    }

    /**
    * 删除TCompanyPark信息
    * @param tCompanyPark
    * @return
    */
    @PostMapping(value = "/deleteTCompanyPark")
    @HttpLog(operationType = "1",modularTypeName = "删除TCompanyPark信息")
    public ActionRsp DeleteTCompanyPark(@RequestBody TCompanyPark tCompanyPark){
    return ActionRspUtil.Success(tCompanyParkService.DeleteTCompanyPark( tCompanyPark));
    }
}