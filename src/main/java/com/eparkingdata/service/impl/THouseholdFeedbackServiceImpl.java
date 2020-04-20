package com.eparkingdata.service.impl;

import com.eparkingdata.service.THouseholdFeedbackService;
import com.eparkingdata.dao.THouseholdFeedbackMapper;
import com.eparkingdata.entity.THouseholdFeedback;
import com.eparkingdata.service.THouseholdFeedbackService;
import com.eparkingdata.entity.THouseholdFeedbackCriteria;
import com.eparkingdata.util.PageBean;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
* @Description: THouseholdFeedbackService接口实现类
* @author 谢轩然
* @date 2020/04/09 15:11
*/
@Service
public class THouseholdFeedbackServiceImpl  implements THouseholdFeedbackService {

    private  static final Logger logger= LoggerFactory.getLogger( THouseholdFeedbackServiceImpl.class);
    @Autowired
    private THouseholdFeedbackMapper tHouseholdFeedbackMapper;

    /**
    * 设置查询条件
    * @param tHouseholdFeedback
    * @return
    */
    private  THouseholdFeedbackCriteria setCriteria(THouseholdFeedback tHouseholdFeedback){
        THouseholdFeedbackCriteria tHouseholdFeedbackCriteria= new THouseholdFeedbackCriteria();
        if(tHouseholdFeedback!=null){
        THouseholdFeedbackCriteria.Criteria criteria=tHouseholdFeedbackCriteria.createCriteria();
        if(tHouseholdFeedback.getId()!=null){
        criteria.andIdEqualTo(tHouseholdFeedback.getId());
        }

        }
        return  tHouseholdFeedbackCriteria;
    }

    /**
    * 获取数据总量
    * @param tHouseholdFeedback
    * @return
    */
    private Integer getCount(THouseholdFeedback tHouseholdFeedback){
    Integer total =(int)tHouseholdFeedbackMapper.countByExample(setCriteria(tHouseholdFeedback));
    return total;
    }

    /**
    *查询tHouseholdFeedback(分页)
    * @param tHouseholdFeedback
    * @param page
    * @param limit
    * @return
    */
    public PageBean<THouseholdFeedback> getTHouseholdFeedbackbyPage(THouseholdFeedback tHouseholdFeedback, Integer page, Integer limit){
        PageHelper.startPage(page, limit,"id desc");
        List<THouseholdFeedback> tHouseholdFeedbacks=getTHouseholdFeedback(tHouseholdFeedback);
            Integer countNums =getCount(tHouseholdFeedback);
            PageBean<THouseholdFeedback> pageData = new PageBean<>(page, limit, countNums);
            pageData.setItems(tHouseholdFeedbacks);
            return pageData;
        }

    /**
    * 查询tHouseholdFeedback
    * @param tHouseholdFeedback
    * @return
    */
    public List<THouseholdFeedback> getTHouseholdFeedback(THouseholdFeedback tHouseholdFeedback){
    List<THouseholdFeedback>  tHouseholdFeedbacks=tHouseholdFeedbackMapper.selectByExample(setCriteria(tHouseholdFeedback));
    return tHouseholdFeedbacks;
    }

    /**
    * 更新tHouseholdFeedback
    * @param tHouseholdFeedback
    * @return
    */
    public String UpdateTHouseholdFeedback(THouseholdFeedback tHouseholdFeedback)
    {
            String msg="";
            try{
            if(tHouseholdFeedback.getId()!=null){
            tHouseholdFeedbackMapper.updateByPrimaryKeySelective(tHouseholdFeedback);
                msg="更新THouseholdFeedback成功";
            }
            else
            {
            tHouseholdFeedbackMapper.insertSelective(tHouseholdFeedback);
                msg="新建THouseholdFeedback成功";
            }
            }
            catch (Exception e)
            {

            }
            return msg;
    }

    /**
    * 删除tHouseholdFeedback
    * @param tHouseholdFeedback
    * @return
    */
    public String DeleteTHouseholdFeedback(THouseholdFeedback tHouseholdFeedback){
            String msg="";
            if(tHouseholdFeedback.getId()!=null){
            tHouseholdFeedbackMapper.deleteByPrimaryKey(tHouseholdFeedback.getId());
            msg="删除THouseholdFeedback成功";
            }
            return msg;
    }

    /**
    * 根据ID查询tHouseholdFeedback
    * @param id
    * @return
    */
    public THouseholdFeedback getTHouseholdFeedbackByID(Integer id) {
        return  tHouseholdFeedbackMapper.selectByPrimaryKey(id);
    }
}
