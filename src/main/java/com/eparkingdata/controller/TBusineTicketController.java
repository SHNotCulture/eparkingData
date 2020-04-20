package com.eparkingdata.controller;

import com.eparkingdata.service.TBusineTicketService;
import com.eparkingdata.entity.TBusineTicket;

import com.eparkingdata.service.TBusineTicketService;
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
import java.util.List;

/**
* @Description: TBusineTicketController类
* @author 谢轩然
* @date 2020/04/09 14:36
*/
@RestController
@RequestMapping("/tBusineTicket")
public class TBusineTicketController {

    private  static final Logger logger= LoggerFactory.getLogger(TBusineTicketController.class);

    @Autowired
    private TBusineTicketService tBusineTicketService;

    /**
    * 查询TBusineTicket信息
    * @paramtBusineTicket
    * @return
    */
    @PostMapping(value = "/getTBusineTicket")
    @HttpLog(operationType = "0",modularTypeName = "查询TBusineTicket")
    public ActionRsp getTBusineTicket(@RequestBody TBusineTicket tBusineTicket,List<Integer> busineIds){
    return ActionRspUtil.Success(tBusineTicketService.getTBusineTicket(tBusineTicket,busineIds));
    }

    /**
    * 查询TBusineTicket信息(分页)
    * @paramtBusineTicket
    * @return
    */
    @PostMapping(value = "/getTBusineTicketbyPage")
    @HttpLog(operationType = "0",modularTypeName = "查询TBusineTicket(分页)")
    public ControllerRsp getTBusineTicketbyPage(@RequestBody TBusineTicket tBusineTicket,Integer page, Integer limit,List<Integer> busineIds){
    return ControllerRspUtil.Success(tBusineTicketService.getTBusineTicketbyPage(tBusineTicket,page,limit,busineIds));
    }

    /**
    * 更新TBusineTicket信息
    * @paramtBusineTicket
    * @return
    */
    @PostMapping(value = "/updateTBusineTicket")
    @HttpLog(operationType = "1",modularTypeName = "更新TBusineTicket信息")
    public ActionRsp UpdateTBusineTicket(@RequestBody TBusineTicket tBusineTicket)
    {
        return ActionRspUtil.Success(tBusineTicketService. UpdateTBusineTicket(tBusineTicket));
    }

    /**
    * 删除TBusineTicket信息
    * @param tBusineTicket
    * @return
    */
    @PostMapping(value = "/deleteTBusineTicket")
    @HttpLog(operationType = "1",modularTypeName = "删除TBusineTicket信息")
    public ActionRsp DeleteTBusineTicket(@RequestBody TBusineTicket tBusineTicket){
    return ActionRspUtil.Success(tBusineTicketService.DeleteTBusineTicket(tBusineTicket));
    }

    /*查询商户拥有可用的电子券种类*/
    @PostMapping(value = "/getIdsByUsable")
    @HttpLog(operationType = "1",modularTypeName = "查询商户拥有可用的电子券种类")
    public ActionRsp getIdsByUsable(@RequestBody TBusineTicket tBusineTicket){
        return ActionRspUtil.Success(tBusineTicketService.DeleteTBusineTicket(tBusineTicket));
    }
}