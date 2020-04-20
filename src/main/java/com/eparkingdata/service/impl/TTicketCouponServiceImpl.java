package com.eparkingdata.service.impl;

import com.eparkingdata.service.TTicketCouponService;
import com.eparkingdata.dao.TTicketCouponMapper;
import com.eparkingdata.entity.TTicketCoupon;
import com.eparkingdata.entity.TTicketCouponCriteria;
import com.eparkingdata.util.PageBean;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
* @Description: TTicketCouponService接口实现类
* @author 谢轩然
* @date 2020/04/10 11:47
*/
@Service
public class TTicketCouponServiceImpl  implements TTicketCouponService {

    private  static final Logger logger= LoggerFactory.getLogger( TTicketCouponServiceImpl.class);
    @Autowired
    private TTicketCouponMapper tTicketCouponMapper;

    /**
    * 设置查询条件
    * @param tTicketCoupon
    * @return
    */
    private  TTicketCouponCriteria setCriteria(TTicketCoupon tTicketCoupon){
        TTicketCouponCriteria tTicketCouponCriteria= new TTicketCouponCriteria();
        if(tTicketCoupon!=null){
        TTicketCouponCriteria.Criteria criteria=tTicketCouponCriteria.createCriteria();
        if(tTicketCoupon.getId()!=null){
        criteria.andIdEqualTo(tTicketCoupon.getId());
        }

        }
        return  tTicketCouponCriteria;
    }

    /**
    * 获取数据总量
    * @param tTicketCoupon
    * @return
    */
    private Integer getCount(TTicketCoupon tTicketCoupon){
    Integer total =(int)tTicketCouponMapper.countByExample(setCriteria(tTicketCoupon));
    return total;
    }

    /**
    *查询tTicketCoupon(分页)
    * @param tTicketCoupon
    * @param page
    * @param limit
    * @return
    */
    public PageBean<TTicketCoupon> getTTicketCouponbyPage(TTicketCoupon tTicketCoupon, Integer page, Integer limit){
        PageHelper.startPage(page, limit,"id desc");
        List<TTicketCoupon> tTicketCoupons=getTTicketCoupon(tTicketCoupon);
            Integer countNums =getCount(tTicketCoupon);
            PageBean<TTicketCoupon> pageData = new PageBean<>(page, limit, countNums);
            pageData.setItems(tTicketCoupons);
            return pageData;
        }

    /**
    * 查询tTicketCoupon
    * @param tTicketCoupon
    * @return
    */
    public List<TTicketCoupon> getTTicketCoupon(TTicketCoupon tTicketCoupon){
    List<TTicketCoupon>  tTicketCoupons=tTicketCouponMapper.selectByExample(setCriteria(tTicketCoupon));
    return tTicketCoupons;
    }

    /**
    * 更新tTicketCoupon
    * @param tTicketCoupon
    * @return
    */
    public String UpdateTTicketCoupon(TTicketCoupon tTicketCoupon)
    {
            String msg="";
            try{
            if(tTicketCoupon.getId()!=null){
            tTicketCouponMapper.updateByPrimaryKeySelective(tTicketCoupon);
                msg="更新TTicketCoupon成功";
            }
            else
            {
            tTicketCouponMapper.insertSelective(tTicketCoupon);
                msg="新建TTicketCoupon成功";
            }
            }
            catch (Exception e)
            {

            }
            return msg;
    }

    /**
    * 删除tTicketCoupon
    * @param tTicketCoupon
    * @return
    */
    public String DeleteTTicketCoupon(TTicketCoupon tTicketCoupon){
            String msg="";
            if(tTicketCoupon.getId()!=null){
            tTicketCouponMapper.deleteByPrimaryKey(tTicketCoupon.getId());
            msg="删除TTicketCoupon成功";
            }
            return msg;
    }

    /**
    * 根据ID查询tTicketCoupon
    * @param id
    * @return
    */
    public TTicketCoupon getTTicketCouponByID(Integer id) {
        return  tTicketCouponMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TTicketCoupon> getTElectronicTicket(TTicketCoupon tTicketCoupon, String InTimeBegin, String InTimeEnd, String OutTimeBegin, String OutTimeEnd) {
        TTicketCouponCriteria tTicketCouponCriteria = new TTicketCouponCriteria();
        TTicketCouponCriteria.Criteria criteria = tTicketCouponCriteria.createCriteria();
        StringBuffer stringBuffer = new StringBuffer();
        if (tTicketCoupon!=null){
            if (tTicketCoupon.getParkId()!=null ){        //车场ID
                criteria.andParkIdEqualTo(tTicketCoupon.getParkId());
            }
            if (tTicketCoupon.getCarplate()!=null && tTicketCoupon.getCarplate()!=""){        //车牌
                criteria.andCarplateLike(tTicketCoupon.getCarplate());
            }
            if (tTicketCoupon.getCouponCode()!=null && tTicketCoupon.getCouponCode()!=""){        //电子券编码
                criteria.andCouponCodeEqualTo(tTicketCoupon.getCouponCode());
            }
            if (tTicketCoupon.getParkName()!=null && tTicketCoupon.getParkName()!=""){        //车场名称
                criteria.andParkNameEqualTo(tTicketCoupon.getParkName());
            }
            if (tTicketCoupon.getTicketName()!=null && tTicketCoupon.getTicketName()!=""){        //电子券名称
                criteria.andTicketNameEqualTo(tTicketCoupon.getTicketName());
            }
        }
        if (InTimeBegin!=null && InTimeBegin!=""  && InTimeEnd!="" && InTimeEnd!=null ){        //进场时间
            criteria.andInTimeBetween(InTimeBegin,InTimeEnd);
        }
        if (OutTimeBegin!=null  && OutTimeBegin!="" && OutTimeEnd!="" && OutTimeEnd!=null){     //出场时间
            criteria.andOutTimeBetween(OutTimeBegin,OutTimeEnd);
        }
        return tTicketCouponMapper.selectByExample(tTicketCouponCriteria);
    }

}
