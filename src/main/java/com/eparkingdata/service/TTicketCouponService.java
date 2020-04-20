package com.eparkingdata.service;

import com.eparkingdata.entity.TTicketCoupon;
import com.eparkingdata.util.PageBean;

import java.util.List;

/**
* @Description: TTicketCouponService接口
* @author 谢轩然
* @date 2020/04/10 11:47
*/
public interface TTicketCouponService {
    /**
    *查询(分页)tTicketCoupon
    * @param tTicketCoupon
    * @param page
    * @param limit
    * @return
    */
    PageBean<TTicketCoupon> getTTicketCouponbyPage(TTicketCoupon tTicketCoupon, Integer page, Integer limit);

    /**
    * 查询tTicketCoupon
    * @param tTicketCoupon
    * @return
    */
    List<TTicketCoupon> getTTicketCoupon(TTicketCoupon tTicketCoupon);

    /**
    * 更新tTicketCoupon
    * @param tTicketCoupon
    * @return
    */
    String UpdateTTicketCoupon(TTicketCoupon tTicketCoupon);

    /**
    * 删除tTicketCoupon
    * @param tTicketCoupon
    * @return
    */
    String DeleteTTicketCoupon(TTicketCoupon tTicketCoupon);

    /**
    * 根据ID查询tTicketCoupon
    * @param id
    * @return
    */
    TTicketCoupon getTTicketCouponByID(Integer id);

    List<TTicketCoupon> getTElectronicTicket(TTicketCoupon tTicketCoupon,String InTimeBegin,String InTimeEnd,String OutTimeBegin,String OutTimeEnd);
}