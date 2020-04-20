package com.eparkingdata.service.impl;

import com.eparkingdata.service.TBusinesCouponService;
import com.eparkingdata.dao.TBusinesCouponMapper;
import com.eparkingdata.entity.TBusinesCoupon;
import com.eparkingdata.service.TBusinesCouponService;
import com.eparkingdata.entity.TBusinesCouponCriteria;
import com.eparkingdata.util.PageBean;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
* @Description: TBusinesCouponService接口实现类
* @author 谢轩然
* @date 2020/04/09 11:57
*/
@Service
public class TBusinesCouponServiceImpl  implements TBusinesCouponService {

    private  static final Logger logger= LoggerFactory.getLogger( TBusinesCouponServiceImpl.class);
    @Autowired
    private TBusinesCouponMapper tBusinesCouponMapper;

    /**
    * 设置查询条件
    * @param tBusinesCoupon
    * @return
    */
    private  TBusinesCouponCriteria setCriteria(TBusinesCoupon tBusinesCoupon){
        TBusinesCouponCriteria tBusinesCouponCriteria= new TBusinesCouponCriteria();
        if(tBusinesCoupon!=null){
        TBusinesCouponCriteria.Criteria criteria=tBusinesCouponCriteria.createCriteria();
        if(tBusinesCoupon.getId()!=null){
        criteria.andIdEqualTo(tBusinesCoupon.getId());
        }

        }
        return  tBusinesCouponCriteria;
    }

    /**
    * 获取数据总量
    * @param tBusinesCoupon
    * @return
    */
    private Integer getCount(TBusinesCoupon tBusinesCoupon){
    Integer total =(int)tBusinesCouponMapper.countByExample(setCriteria(tBusinesCoupon));
    return total;
    }

    /**
    *查询tBusinesCoupon(分页)
    * @param tBusinesCoupon
    * @param page
    * @param limit
    * @return
    */
    public PageBean<TBusinesCoupon> getTBusinesCouponbyPage(TBusinesCoupon tBusinesCoupon, Integer page, Integer limit){
        PageHelper.startPage(page, limit,"id desc");
        List<TBusinesCoupon> tBusinesCoupons=getTBusinesCoupon(tBusinesCoupon);
            Integer countNums =getCount(tBusinesCoupon);
            PageBean<TBusinesCoupon> pageData = new PageBean<>(page, limit, countNums);
            pageData.setItems(tBusinesCoupons);
            return pageData;
        }

    /**
    * 查询tBusinesCoupon
    * @param tBusinesCoupon
    * @return
    */
    public List<TBusinesCoupon> getTBusinesCoupon(TBusinesCoupon tBusinesCoupon){
    List<TBusinesCoupon>  tBusinesCoupons=tBusinesCouponMapper.selectByExample(setCriteria(tBusinesCoupon));
    return tBusinesCoupons;
    }

    /**
    * 更新tBusinesCoupon
    * @param tBusinesCoupon
    * @return
    */
    public String UpdateTBusinesCoupon(TBusinesCoupon tBusinesCoupon)
    {
            String msg="";
            try{
            if(tBusinesCoupon.getId()!=null){
            tBusinesCouponMapper.updateByPrimaryKeySelective(tBusinesCoupon);
                msg="更新TBusinesCoupon成功";
            }
            else
            {
            tBusinesCouponMapper.insertSelective(tBusinesCoupon);
                msg="新建TBusinesCoupon成功";
            }
            }
            catch (Exception e)
            {

            }
            return msg;
    }

    /**
    * 删除tBusinesCoupon
    * @param tBusinesCoupon
    * @return
    */
    public String DeleteTBusinesCoupon(TBusinesCoupon tBusinesCoupon){
            String msg="";
            if(tBusinesCoupon.getId()!=null){
            tBusinesCouponMapper.deleteByPrimaryKey(tBusinesCoupon.getId());
            msg="删除TBusinesCoupon成功";
            }
            return msg;
    }

    /**
    * 根据ID查询tBusinesCoupon
    * @param id
    * @return
    */
    public TBusinesCoupon getTBusinesCouponByID(Integer id) {
        return  tBusinesCouponMapper.selectByPrimaryKey(id);
    }
}
