package com.eparkingdata.controller;

import com.eparkingdata.service.TJournalService;
import com.eparkingdata.entity.TJournal;

import com.eparkingdata.service.TJournalService;
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
* @Description: TJournalController类
* @author 谢轩然
* @date 2020/04/09 15:17
*/
@RestController
@RequestMapping("/tJournal")
public class TJournalController {

    private  static final Logger logger= LoggerFactory.getLogger(TJournalController.class);

    @Autowired
    private TJournalService tJournalService;

    /**
    * 查询TJournal信息
    * @paramtJournal
    * @return
    */
    @PostMapping(value = "/getTJournal")
    @HttpLog(operationType = "0",modularTypeName = "查询TJournal")
    public ActionRsp getTJournal(@RequestBody TJournal tJournal,HttpServletRequest request){
    return ActionRspUtil.Success(tJournalService.getTJournal(tJournal));
    }

    /**
    * 查询TJournal信息(分页)
    * @paramtJournal
    * @return
    */
    @PostMapping(value = "/getTJournalbyPage")
    @HttpLog(operationType = "0",modularTypeName = "查询TJournal(分页)")
    public ControllerRsp getTJournalbyPage(@RequestBody TJournal tJournal,HttpServletRequest request,Integer page, Integer limit){
    return ControllerRspUtil.Success(tJournalService.getTJournalbyPage(tJournal,page,limit));
    }

    /**
    * 更新TJournal信息
    * @paramtJournal
    * @return
    */
    @PostMapping(value = "/updateTJournal")
    @HttpLog(operationType = "1",modularTypeName = "更新TJournal信息")
    public ActionRsp UpdateTJournal(@RequestBody TJournal tJournal,HttpServletRequest request)
    {
        return ActionRspUtil.Success(tJournalService. UpdateTJournal(tJournal));
    }

    /**
    * 删除TJournal信息
    * @param tJournal
    * @return
    */
    @PostMapping(value = "/deleteTJournal")
    @HttpLog(operationType = "1",modularTypeName = "删除TJournal信息")
    public ActionRsp DeleteTJournal(@RequestBody TJournal tJournal){
    return ActionRspUtil.Success(tJournalService.DeleteTJournal( tJournal));
    }
}