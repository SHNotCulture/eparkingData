package com.eparkingdata.service.impl;

import com.eparkingdata.service.TBusinePayService;
import com.eparkingdata.dao.TBusinePayMapper;
import com.eparkingdata.entity.TBusinePay;
import com.eparkingdata.service.TBusinePayService;
import com.eparkingdata.entity.TBusinePayCriteria;
import com.eparkingdata.util.PageBean;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
* @Description: TBusinePayService接口实现类
* @author 谢轩然
* @date 2020/04/09 10:50
*/
@Service
public class TBusinePayServiceImpl  implements TBusinePayService {

    private  static final Logger logger= LoggerFactory.getLogger( TBusinePayServiceImpl.class);
    @Autowired
    private TBusinePayMapper tBusinePayMapper;

    /**
    * 设置查询条件
    * @param tBusinePay
    * @return
    */
    private  TBusinePayCriteria setCriteria(TBusinePay tBusinePay,String beginTime,String endTime){
        TBusinePayCriteria tBusinePayCriteria= new TBusinePayCriteria();
        if(tBusinePay!=null){
        TBusinePayCriteria.Criteria criteria=tBusinePayCriteria.createCriteria();
        if(tBusinePay.getId()!=null){
        criteria.andIdEqualTo(tBusinePay.getId());
        }
            if(tBusinePay.getParkId()!=null)
            {
                criteria.andParkIdEqualTo(tBusinePay.getParkId());
            }
            if(tBusinePay.getBusineName()!=null)
            {
                criteria.andBusineNameLike("%"+tBusinePay.getBusineName()+"%");
            }
            if(tBusinePay.getCompanyId()!=null){
                criteria.andCompanyIdEqualTo(tBusinePay.getCompanyId());
            }
            if(beginTime!=null&&endTime!=null&&beginTime!=""&&endTime!="")
            {
                criteria.andPayTimeBetween(beginTime,endTime);
            }
            tBusinePayCriteria.setOrderByClause("pay_time DESC");
        }
        return  tBusinePayCriteria;
    }

    /**
    * 获取数据总量
    * @param tBusinePay
    * @return
    */
    private Integer getCount(TBusinePay tBusinePay,String beginTime,String endTime){
    Integer total =(int)tBusinePayMapper.countByExample(setCriteria(tBusinePay,beginTime,endTime));
    return total;
    }

    /**
    *查询tBusinePay(分页)
    * @param tBusinePay
    * @param page
    * @param limit
    * @return
    */
    public PageBean<TBusinePay> getTBusinePaybyPage(TBusinePay tBusinePay, Integer page, Integer limit, String beginTime, String endTime) {
        PageHelper.startPage(page, limit,"id desc");
        List<TBusinePay> tBusinePays=getTBusinePay(tBusinePay,beginTime,endTime);
            Integer countNums =getCount(tBusinePay,beginTime,endTime);
            PageBean<TBusinePay> pageData = new PageBean<>(page, limit, countNums);
            pageData.setItems(tBusinePays);
            return pageData;
        }



    /**
    * 查询tBusinePay
    * @param tBusinePay
    * @return
    */
    public List<TBusinePay> getTBusinePay(TBusinePay tBusinePay, String beginTime, String endTime){
    List<TBusinePay>  tBusinePays=tBusinePayMapper.selectByExample(setCriteria(tBusinePay,beginTime,endTime));
    return tBusinePays;
    }

    /**
    * 更新tBusinePay
    * @param tBusinePay
    * @return
    */
    public String UpdateTBusinePay(TBusinePay tBusinePay)
    {
            String msg="";
            try{
            if(tBusinePay.getId()!=null){
            tBusinePayMapper.updateByPrimaryKeySelective(tBusinePay);
                msg="更新TBusinePay成功";
            }
            else
            {
            tBusinePayMapper.insertSelective(tBusinePay);
                msg="新建TBusinePay成功";
            }
            }
            catch (Exception e)
            {

            }
            return msg;
    }

    /**
    * 删除tBusinePay
    * @param tBusinePay
    * @return
    */
    public String DeleteTBusinePay(TBusinePay tBusinePay){
            String msg="";
            if(tBusinePay.getId()!=null){
            tBusinePayMapper.deleteByPrimaryKey(tBusinePay.getId());
            msg="删除TBusinePay成功";
            }
            return msg;
    }

    /**
    * 根据ID查询tBusinePay
    * @param id
    * @return
    */
    public TBusinePay getTBusinePayByID(Integer id) {
        return  tBusinePayMapper.selectByPrimaryKey(id);
    }
}
