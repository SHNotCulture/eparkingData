package com.eparkingdata.service.impl;

import com.eparkingdata.service.TCompanyParkService;
import com.eparkingdata.dao.TCompanyParkMapper;
import com.eparkingdata.entity.TCompanyPark;
import com.eparkingdata.service.TCompanyParkService;
import com.eparkingdata.entity.TCompanyParkCriteria;
import com.eparkingdata.util.PageBean;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
* @Description: TCompanyParkService接口实现类
* @author 谢轩然
* @date 2020/04/09 14:50
*/
@Service
public class TCompanyParkServiceImpl  implements TCompanyParkService {

    private  static final Logger logger= LoggerFactory.getLogger( TCompanyParkServiceImpl.class);
    @Autowired
    private TCompanyParkMapper tCompanyParkMapper;

    /**
    * 设置查询条件
    * @param tCompanyPark
    * @return
    */
    private  TCompanyParkCriteria setCriteria(TCompanyPark tCompanyPark){
        TCompanyParkCriteria tCompanyParkCriteria= new TCompanyParkCriteria();
        if(tCompanyPark!=null){
        TCompanyParkCriteria.Criteria criteria=tCompanyParkCriteria.createCriteria();
        if(tCompanyPark.getId()!=null){
        criteria.andIdEqualTo(tCompanyPark.getId());
        }

        }
        return  tCompanyParkCriteria;
    }

    /**
    * 获取数据总量
    * @param tCompanyPark
    * @return
    */
    private Integer getCount(TCompanyPark tCompanyPark){
    Integer total =(int)tCompanyParkMapper.countByExample(setCriteria(tCompanyPark));
    return total;
    }

    /**
    *查询tCompanyPark(分页)
    * @param tCompanyPark
    * @param page
    * @param limit
    * @return
    */
    public PageBean<TCompanyPark> getTCompanyParkbyPage(TCompanyPark tCompanyPark, Integer page, Integer limit){
        PageHelper.startPage(page, limit,"id desc");
        List<TCompanyPark> tCompanyParks=getTCompanyPark(tCompanyPark);
            Integer countNums =getCount(tCompanyPark);
            PageBean<TCompanyPark> pageData = new PageBean<>(page, limit, countNums);
            pageData.setItems(tCompanyParks);
            return pageData;
        }

    /**
    * 查询tCompanyPark
    * @param tCompanyPark
    * @return
    */
    public List<TCompanyPark> getTCompanyPark(TCompanyPark tCompanyPark){
    List<TCompanyPark>  tCompanyParks=tCompanyParkMapper.selectByExample(setCriteria(tCompanyPark));
    return tCompanyParks;
    }

    /**
    * 更新tCompanyPark
    * @param tCompanyPark
    * @return
    */
    public String UpdateTCompanyPark(TCompanyPark tCompanyPark)
    {
            String msg="";
            try{
            if(tCompanyPark.getId()!=null){
            tCompanyParkMapper.updateByPrimaryKeySelective(tCompanyPark);
                msg="更新TCompanyPark成功";
            }
            else
            {
            tCompanyParkMapper.insertSelective(tCompanyPark);
                msg="新建TCompanyPark成功";
            }
            }
            catch (Exception e)
            {

            }
            return msg;
    }

    /**
    * 删除tCompanyPark
    * @param tCompanyPark
    * @return
    */
    public String DeleteTCompanyPark(TCompanyPark tCompanyPark){
            String msg="";
            if(tCompanyPark.getId()!=null){
            tCompanyParkMapper.deleteByPrimaryKey(tCompanyPark.getId());
            msg="删除TCompanyPark成功";
            }
            return msg;
    }

    /**
    * 根据ID查询tCompanyPark
    * @param id
    * @return
    */
    public TCompanyPark getTCompanyParkByID(Integer id) {
        return  tCompanyParkMapper.selectByPrimaryKey(id);
    }
}
