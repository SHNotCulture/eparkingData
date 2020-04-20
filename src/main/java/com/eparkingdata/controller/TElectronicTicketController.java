package com.eparkingdata.controller;

import com.eparkingdata.service.TElectronicTicketService;
import com.eparkingdata.entity.TElectronicTicket;

import com.eparkingdata.service.TElectronicTicketService;
import com.eparkingdata.aspect.HttpLog;
import com.eparkingdata.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @Description: TElectronicTicketController类
* @author 谢轩然
* @date 2020/04/09 15:01
*/
@RestController
@RequestMapping("/tElectronicTicket")
public class TElectronicTicketController {

    private  static final Logger logger= LoggerFactory.getLogger(TElectronicTicketController.class);

    @Autowired
    private TElectronicTicketService tElectronicTicketService;

    /**
    * 查询TElectronicTicket信息
    * @paramtElectronicTicket
    * @return
    */
    @PostMapping(value = "/getTElectronicTicket")
    @HttpLog(operationType = "0",modularTypeName = "查询TElectronicTicket")
    public ActionRsp getTElectronicTicket(@RequestBody TElectronicTicket tElectronicTicket,HttpServletRequest request){
        tElectronicTicket.setCompanyId(SessionUtil.getCompany().getId());
        return ActionRspUtil.Success(tElectronicTicketService.getTElectronicTicket(tElectronicTicket));
    }

    /**
    * 查询TElectronicTicket信息(分页)
    * @paramtElectronicTicket
    * @return
    */
    @PostMapping(value = "/getTElectronicTicketbyPage")
    @HttpLog(operationType = "0",modularTypeName = "查询TElectronicTicket(分页)")
    public ControllerRsp getTElectronicTicketbyPage(@RequestBody TElectronicTicket tElectronicTicket, HttpServletRequest request, @RequestParam("page") Integer page,@RequestParam("limit") Integer limit){
        tElectronicTicket.setCompanyId(SessionUtil.getCompany().getId());
        return ControllerRspUtil.Success(tElectronicTicketService.getTElectronicTicketbyPage(tElectronicTicket,page,limit));
    }

    /**
    * 更新TElectronicTicket信息
    * @paramtElectronicTicket
    * @return
    */
    @PostMapping(value = "/updateTElectronicTicket")
    @HttpLog(operationType = "1",modularTypeName = "更新TElectronicTicket信息")
    public ActionRsp UpdateTElectronicTicket(@RequestBody TElectronicTicket tElectronicTicket,HttpServletRequest request)
    {
        tElectronicTicket.setCompanyId(SessionUtil.getCompany().getId());
        return ActionRspUtil.Success(tElectronicTicketService. UpdateTElectronicTicket(tElectronicTicket));
    }

    /**
    * 删除TElectronicTicket信息
    * @param tElectronicTicket
    * @return
    */
    @PostMapping(value = "/deleteTElectronicTicket")
    @HttpLog(operationType = "1",modularTypeName = "删除TElectronicTicket信息")
    public ActionRsp DeleteTElectronicTicket(@RequestBody TElectronicTicket tElectronicTicket){
    return ActionRspUtil.Success(tElectronicTicketService.DeleteTElectronicTicket( tElectronicTicket));
    }

    /**
     * 查询TElectronicTicket信息
     * @paramtElectronicTicket
     * @return
     */
    @PostMapping(value = "/getElectronicTicketByPrimaryKey")
    @HttpLog(operationType = "0",modularTypeName = "查询TElectronicTicket")
    public ActionRsp getTElectronicTicketByID(@RequestParam("id") Integer id){
        return ActionRspUtil.Success(tElectronicTicketService.getTElectronicTicketByID(id));
    }

    /**
     * 查询TElectronicTicket信息(分页)
     * @paramtElectronicTicket
     * @return
     */
    @PostMapping(value = "/geteTicketListbyPageAndIds")
    @HttpLog(operationType = "0",modularTypeName = "查询TElectronicTicket(分页)")
    public ControllerRsp geteTicketListbyPageAndIds(@RequestBody List<Integer> ids,@RequestParam("page") Integer page,@RequestParam("limit") Integer limit){
        return ControllerRspUtil.Success(tElectronicTicketService.geteTicketListbyPageAndIds(ids,page,limit));
    }
}