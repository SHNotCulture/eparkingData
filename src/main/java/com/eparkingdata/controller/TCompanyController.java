package com.eparkingdata.controller;

import com.eparkingdata.service.TCompanyService;
import com.eparkingdata.entity.TCompany;

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
* @Description: TCompanyController类
* @author 谢轩然
* @date 2020/04/09 14:42
*/
@RestController
@RequestMapping("/tCompany")
public class TCompanyController {

    private  static final Logger logger= LoggerFactory.getLogger(TCompanyController.class);

    @Autowired
    private TCompanyService tCompanyService;

    /**
    * 查询TCompany信息
    * @paramtCompany
    * @return
    */
    @PostMapping(value = "/getTCompany")
    @HttpLog(operationType = "0",modularTypeName = "查询TCompany")
    public ActionRsp getTCompany(@RequestBody TCompany tCompany,HttpServletRequest request){
    return ActionRspUtil.Success(tCompanyService.getTCompany(tCompany));
    }

    /**
    * 查询TCompany信息(分页)
    * @paramtCompany
    * @return
    */
    @PostMapping(value = "/getTCompanybyPage")
    @HttpLog(operationType = "0",modularTypeName = "查询TCompany(分页)")
    public ControllerRsp getTCompanybyPage(@RequestBody TCompany tCompany,HttpServletRequest request,@RequestParam("page") Integer page,@RequestParam("limit") Integer limit){
    return ControllerRspUtil.Success(tCompanyService.getTCompanybyPage(tCompany,page,limit));
    }

    /**
    * 更新TCompany信息
    * @paramtCompany
    * @return
    */
    @PostMapping(value = "/updateTCompany")
    @HttpLog(operationType = "1",modularTypeName = "更新TCompany信息")
    public ActionRsp UpdateTCompany(@RequestBody TCompany tCompany,HttpServletRequest request)
    {
        return ActionRspUtil.Success(tCompanyService. UpdateTCompany(tCompany));
    }

    /**
    * 删除TCompany信息
    * @param tCompany
    * @return
    */
    @PostMapping(value = "/deleteTCompany")
    @HttpLog(operationType = "1",modularTypeName = "删除TCompany信息")
    public ActionRsp DeleteTCompany(@RequestBody TCompany tCompany){
    return ActionRspUtil.Success(tCompanyService.DeleteTCompany(tCompany));
    }

    /**
     * 根据id查询tCompany
     * @param id
     * @return
     */
    @PostMapping(value = "/getTCompanyById")
    @HttpLog(operationType = "1",modularTypeName = "根据id查询tCompany")
    public ActionRsp getTCompanyById(@RequestParam("id") Integer id){
        return ActionRspUtil.Success(tCompanyService.getTCompanyByID(id));
    }
}