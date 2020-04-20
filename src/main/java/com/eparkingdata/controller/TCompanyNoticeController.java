package com.eparkingdata.controller;

import com.eparkingdata.service.TCompanyNoticeService;
import com.eparkingdata.entity.TCompanyNotice;

import com.eparkingdata.service.TCompanyNoticeService;
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
* @Description: TCompanyNoticeController类
* @author 谢轩然
* @date 2020/04/09 14:46
*/
@RestController
@RequestMapping("/tCompanyNotice")
public class TCompanyNoticeController {

    private  static final Logger logger= LoggerFactory.getLogger(TCompanyNoticeController.class);

    @Autowired
    private TCompanyNoticeService tCompanyNoticeService;

    /**
    * 查询TCompanyNotice信息
    * @paramtCompanyNotice
    * @return
    */
    @PostMapping(value = "/getTCompanyNotice")
    @HttpLog(operationType = "0",modularTypeName = "查询TCompanyNotice")
    public ActionRsp getTCompanyNotice(@RequestBody TCompanyNotice tCompanyNotice,HttpServletRequest request){
    return ActionRspUtil.Success(tCompanyNoticeService.getTCompanyNotice(tCompanyNotice));
    }

    /**
    * 查询TCompanyNotice信息(分页)
    * @paramtCompanyNotice
    * @return
    */
    @PostMapping(value = "/getTCompanyNoticebyPage")
    @HttpLog(operationType = "0",modularTypeName = "查询TCompanyNotice(分页)")
    public ControllerRsp getTCompanyNoticebyPage(@RequestBody TCompanyNotice tCompanyNotice,HttpServletRequest request,Integer page, Integer limit){
    return ControllerRspUtil.Success(tCompanyNoticeService.getTCompanyNoticebyPage(tCompanyNotice,page,limit));
    }

    /**
    * 更新TCompanyNotice信息
    * @paramtCompanyNotice
    * @return
    */
    @PostMapping(value = "/updateTCompanyNotice")
    @HttpLog(operationType = "1",modularTypeName = "更新TCompanyNotice信息")
    public ActionRsp UpdateTCompanyNotice(@RequestBody TCompanyNotice tCompanyNotice,HttpServletRequest request)
    {
        return ActionRspUtil.Success(tCompanyNoticeService. UpdateTCompanyNotice(tCompanyNotice));
    }

    /**
    * 删除TCompanyNotice信息
    * @param tCompanyNotice
    * @return
    */
    @PostMapping(value = "/deleteTCompanyNotice")
    @HttpLog(operationType = "1",modularTypeName = "删除TCompanyNotice信息")
    public ActionRsp DeleteTCompanyNotice(@RequestBody TCompanyNotice tCompanyNotice){
    return ActionRspUtil.Success(tCompanyNoticeService.DeleteTCompanyNotice( tCompanyNotice));
    }
}