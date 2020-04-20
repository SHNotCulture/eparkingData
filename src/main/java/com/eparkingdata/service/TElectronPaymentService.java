package com.eparkingdata.service;

import com.eparkingdata.entity.TElectronPayment;
import com.eparkingdata.util.PageBean;

import java.util.List;

/**
* @Description: TElectronPaymentService接口
* @author 谢轩然
* @date 2020/04/09 14:58
*/
public interface TElectronPaymentService {
    /**
    *查询(分页)tElectronPayment
    * @param tElectronPayment
    * @param page
    * @param limit
    * @return
    */
    PageBean<TElectronPayment> getTElectronPaymentbyPage(TElectronPayment tElectronPayment, Integer page, Integer limit);

    /**
    * 查询tElectronPayment
    * @param tElectronPayment
    * @return
    */
    List<TElectronPayment> getTElectronPayment(TElectronPayment tElectronPayment);

    /**
    * 更新tElectronPayment
    * @param tElectronPayment
    * @return
    */
    String UpdateTElectronPayment(TElectronPayment tElectronPayment);

    /**
    * 删除tElectronPayment
    * @param tElectronPayment
    * @return
    */
    String DeleteTElectronPayment(TElectronPayment tElectronPayment);

    /**
    * 根据ID查询tElectronPayment
    * @param id
    * @return
    */
    TElectronPayment getTElectronPaymentByID(Integer id);

}