package com.eparkingdata.service;

import com.eparkingdata.entity.THouseholdFeedback;
import com.eparkingdata.util.PageBean;

import java.util.List;

/**
* @Description: THouseholdFeedbackService接口
* @author 谢轩然
* @date 2020/04/09 15:11
*/
public interface THouseholdFeedbackService {
    /**
    *查询(分页)tHouseholdFeedback
    * @param tHouseholdFeedback
    * @param page
    * @param limit
    * @return
    */
    PageBean<THouseholdFeedback> getTHouseholdFeedbackbyPage(THouseholdFeedback tHouseholdFeedback, Integer page, Integer limit);

    /**
    * 查询tHouseholdFeedback
    * @param tHouseholdFeedback
    * @return
    */
    List<THouseholdFeedback> getTHouseholdFeedback(THouseholdFeedback tHouseholdFeedback);

    /**
    * 更新tHouseholdFeedback
    * @param tHouseholdFeedback
    * @return
    */
    String UpdateTHouseholdFeedback(THouseholdFeedback tHouseholdFeedback);

    /**
    * 删除tHouseholdFeedback
    * @param tHouseholdFeedback
    * @return
    */
    String DeleteTHouseholdFeedback(THouseholdFeedback tHouseholdFeedback);

    /**
    * 根据ID查询tHouseholdFeedback
    * @param id
    * @return
    */
    THouseholdFeedback getTHouseholdFeedbackByID(Integer id);

}