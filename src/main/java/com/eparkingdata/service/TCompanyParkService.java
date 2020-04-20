package com.eparkingdata.service;

import com.eparkingdata.entity.TCompanyPark;
import com.eparkingdata.util.PageBean;

import java.util.List;

/**
* @Description: TCompanyParkService接口
* @author 谢轩然
* @date 2020/04/09 14:50
*/
public interface TCompanyParkService {
    /**
    *查询(分页)tCompanyPark
    * @param tCompanyPark
    * @param page
    * @param limit
    * @return
    */
    PageBean<TCompanyPark> getTCompanyParkbyPage(TCompanyPark tCompanyPark, Integer page, Integer limit);

    /**
    * 查询tCompanyPark
    * @param tCompanyPark
    * @return
    */
    List<TCompanyPark> getTCompanyPark(TCompanyPark tCompanyPark);

    /**
    * 更新tCompanyPark
    * @param tCompanyPark
    * @return
    */
    String UpdateTCompanyPark(TCompanyPark tCompanyPark);

    /**
    * 删除tCompanyPark
    * @param tCompanyPark
    * @return
    */
    String DeleteTCompanyPark(TCompanyPark tCompanyPark);

    /**
    * 根据ID查询tCompanyPark
    * @param id
    * @return
    */
    TCompanyPark getTCompanyParkByID(Integer id);

}