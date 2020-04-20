package com.eparkingdata.controller;

import com.eparkingdata.service.TGlobalInfoService;
import com.eparkingdata.entity.TGlobalInfo;

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
* @Description: TGlobalInfoController类
* @author 谢轩然
* @date 2020/04/09 15:04
*/
@RestController
@RequestMapping("/tGlobalInfo")
public class TGlobalInfoController {

    private  static final Logger logger= LoggerFactory.getLogger(TGlobalInfoController.class);

    @Autowired
    private TGlobalInfoService tGlobalInfoService;

    /**
    * 查询TGlobalInfo信息
    * @paramtGlobalInfo
    * @return
    */
    @PostMapping(value = "/getTGlobalInfo")
    @HttpLog(operationType = "0",modularTypeName = "查询TGlobalInfo")
    public ActionRsp getTGlobalInfo(@RequestBody TGlobalInfo tGlobalInfo,HttpServletRequest request){
    return ActionRspUtil.Success(tGlobalInfoService.getTGlobalInfo(tGlobalInfo));
    }

    /**
    * 查询TGlobalInfo信息(分页)
    * @paramtGlobalInfo
    * @return
    */
    @PostMapping(value = "/getTGlobalInfobyPage")
    @HttpLog(operationType = "0",modularTypeName = "查询TGlobalInfo(分页)")
    public ControllerRsp getTGlobalInfobyPage(@RequestBody TGlobalInfo tGlobalInfo,HttpServletRequest request,Integer page, Integer limit){
    return ControllerRspUtil.Success(tGlobalInfoService.getTGlobalInfobyPage(tGlobalInfo,page,limit));
    }

    /**
    * 更新TGlobalInfo信息
    * @paramtGlobalInfo
    * @return
    */
    @PostMapping(value = "/updateTGlobalInfo")
    @HttpLog(operationType = "1",modularTypeName = "更新TGlobalInfo信息")
    public ActionRsp UpdateTGlobalInfo(@RequestBody TGlobalInfo tGlobalInfo,HttpServletRequest request)
    {
        return ActionRspUtil.Success(tGlobalInfoService. UpdateTGlobalInfo(tGlobalInfo));
    }

    /**
    * 删除TGlobalInfo信息
    * @param tGlobalInfo
    * @return
    */
    @PostMapping(value = "/deleteTGlobalInfo")
    @HttpLog(operationType = "1",modularTypeName = "删除TGlobalInfo信息")
    public ActionRsp DeleteTGlobalInfo(@RequestBody TGlobalInfo tGlobalInfo){
    return ActionRspUtil.Success(tGlobalInfoService.DeleteTGlobalInfo( tGlobalInfo));
    }
}