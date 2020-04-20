package com.eparkingdata.service.impl;

import com.eparkingdata.service.TElectronPaymentService;
import com.eparkingdata.dao.TElectronPaymentMapper;
import com.eparkingdata.entity.TElectronPayment;
import com.eparkingdata.service.TElectronPaymentService;
import com.eparkingdata.entity.TElectronPaymentCriteria;
import com.eparkingdata.util.PageBean;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
* @Description: TElectronPaymentService接口实现类
* @author 谢轩然
* @date 2020/04/09 14:58
*/
@Service
public class TElectronPaymentServiceImpl  implements TElectronPaymentService {

    private  static final Logger logger= LoggerFactory.getLogger( TElectronPaymentServiceImpl.class);
    @Autowired
    private TElectronPaymentMapper tElectronPaymentMapper;

    /**
    * 设置查询条件
    * @param tElectronPayment
    * @return
    */
    private  TElectronPaymentCriteria setCriteria(TElectronPayment tElectronPayment){
        TElectronPaymentCriteria tElectronPaymentCriteria= new TElectronPaymentCriteria();
        if(tElectronPayment!=null){
        TElectronPaymentCriteria.Criteria criteria=tElectronPaymentCriteria.createCriteria();
        if(tElectronPayment.getId()!=null){
        criteria.andIdEqualTo(tElectronPayment.getId());
        }

        }
        return  tElectronPaymentCriteria;
    }

    /**
    * 获取数据总量
    * @param tElectronPayment
    * @return
    */
    private Integer getCount(TElectronPayment tElectronPayment){
    Integer total =(int)tElectronPaymentMapper.countByExample(setCriteria(tElectronPayment));
    return total;
    }

    /**
    *查询tElectronPayment(分页)
    * @param tElectronPayment
    * @param page
    * @param limit
    * @return
    */
    public PageBean<TElectronPayment> getTElectronPaymentbyPage(TElectronPayment tElectronPayment, Integer page, Integer limit){
        PageHelper.startPage(page, limit,"id desc");
        List<TElectronPayment> tElectronPayments=getTElectronPayment(tElectronPayment);
            Integer countNums =getCount(tElectronPayment);
            PageBean<TElectronPayment> pageData = new PageBean<>(page, limit, countNums);
            pageData.setItems(tElectronPayments);
            return pageData;
        }

    /**
    * 查询tElectronPayment
    * @param tElectronPayment
    * @return
    */
    public List<TElectronPayment> getTElectronPayment(TElectronPayment tElectronPayment){
    List<TElectronPayment>  tElectronPayments=tElectronPaymentMapper.selectByExample(setCriteria(tElectronPayment));
    return tElectronPayments;
    }

    /**
    * 更新tElectronPayment
    * @param tElectronPayment
    * @return
    */
    public String UpdateTElectronPayment(TElectronPayment tElectronPayment)
    {
            String msg="";
            try{
            if(tElectronPayment.getId()!=null){
            tElectronPaymentMapper.updateByPrimaryKeySelective(tElectronPayment);
                msg="更新TElectronPayment成功";
            }
            else
            {
            tElectronPaymentMapper.insertSelective(tElectronPayment);
                msg="新建TElectronPayment成功";
            }
            }
            catch (Exception e)
            {

            }
            return msg;
    }

    /**
    * 删除tElectronPayment
    * @param tElectronPayment
    * @return
    */
    public String DeleteTElectronPayment(TElectronPayment tElectronPayment){
            String msg="";
            if(tElectronPayment.getId()!=null){
            tElectronPaymentMapper.deleteByPrimaryKey(tElectronPayment.getId());
            msg="删除TElectronPayment成功";
            }
            return msg;
    }

    /**
    * 根据ID查询tElectronPayment
    * @param id
    * @return
    */
    public TElectronPayment getTElectronPaymentByID(Integer id) {
        return  tElectronPaymentMapper.selectByPrimaryKey(id);
    }
}
