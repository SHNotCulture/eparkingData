package com.eparkingdata.controller;

import com.eparkingdata.service.THouseholdFeedbackService;
import com.eparkingdata.entity.THouseholdFeedback;

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
* @Description: THouseholdFeedbackController类
* @author 谢轩然
* @date 2020/04/09 15:11
*/
@RestController
@RequestMapping("/tHouseholdFeedback")
public class THouseholdFeedbackController {

    private  static final Logger logger= LoggerFactory.getLogger(THouseholdFeedbackController.class);

    @Autowired
    private THouseholdFeedbackService tHouseholdFeedbackService;

    /**
    * 查询THouseholdFeedback信息
    * @paramtHouseholdFeedback
    * @return
    */
    @PostMapping(value = "/getTHouseholdFeedback")
    @HttpLog(operationType = "0",modularTypeName = "查询THouseholdFeedback")
    public ActionRsp getTHouseholdFeedback(@RequestBody THouseholdFeedback tHouseholdFeedback,HttpServletRequest request){
    return ActionRspUtil.Success(tHouseholdFeedbackService.getTHouseholdFeedback(tHouseholdFeedback));
    }

    /**
    * 查询THouseholdFeedback信息(分页)
    * @paramtHouseholdFeedback
    * @return
    */
    @PostMapping(value = "/getTHouseholdFeedbackbyPage")
    @HttpLog(operationType = "0",modularTypeName = "查询THouseholdFeedback(分页)")
    public ControllerRsp getTHouseholdFeedbackbyPage(@RequestBody THouseholdFeedback tHouseholdFeedback,HttpServletRequest request,Integer page, Integer limit){
    return ControllerRspUtil.Success(tHouseholdFeedbackService.getTHouseholdFeedbackbyPage(tHouseholdFeedback,page,limit));
    }

    /**
    * 更新THouseholdFeedback信息
    * @paramtHouseholdFeedback
    * @return
    */
    @PostMapping(value = "/updateTHouseholdFeedback")
    @HttpLog(operationType = "1",modularTypeName = "更新THouseholdFeedback信息")
    public ActionRsp UpdateTHouseholdFeedback(@RequestBody THouseholdFeedback tHouseholdFeedback,HttpServletRequest request)
    {
        return ActionRspUtil.Success(tHouseholdFeedbackService. UpdateTHouseholdFeedback(tHouseholdFeedback));
    }

    /**
    * 删除THouseholdFeedback信息
    * @param tHouseholdFeedback
    * @return
    */
    @PostMapping(value = "/deleteTHouseholdFeedback")
    @HttpLog(operationType = "1",modularTypeName = "删除THouseholdFeedback信息")
    public ActionRsp DeleteTHouseholdFeedback(@RequestBody THouseholdFeedback tHouseholdFeedback){
    return ActionRspUtil.Success(tHouseholdFeedbackService.DeleteTHouseholdFeedback( tHouseholdFeedback));
    }
}