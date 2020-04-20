package com.eparkingdata.service.impl;

import com.eparkingdata.service.TCompanyService;
import com.eparkingdata.dao.TCompanyMapper;
import com.eparkingdata.entity.TCompany;
import com.eparkingdata.service.TCompanyService;
import com.eparkingdata.entity.TCompanyCriteria;
import com.eparkingdata.util.PageBean;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
* @Description: TCompanyService接口实现类
* @author 谢轩然
* @date 2020/04/09 14:42
*/
@Service
public class TCompanyServiceImpl  implements TCompanyService {

    private  static final Logger logger= LoggerFactory.getLogger( TCompanyServiceImpl.class);
    @Autowired
    private TCompanyMapper tCompanyMapper;

    /**
    * 设置查询条件
    * @param tCompany
    * @return
    */
    private  TCompanyCriteria setCriteria(TCompany tCompany){
        TCompanyCriteria tCompanyCriteria= new TCompanyCriteria();
        if(tCompany!=null){
        TCompanyCriteria.Criteria criteria=tCompanyCriteria.createCriteria();
        if(tCompany.getId()!=null){
        criteria.andIdEqualTo(tCompany.getId());
        }

        }
        return  tCompanyCriteria;
    }

    /**
    * 获取数据总量
    * @param tCompany
    * @return
    */
    private Integer getCount(TCompany tCompany){
    Integer total =(int)tCompanyMapper.countByExample(setCriteria(tCompany));
    return total;
    }

    /**
    *查询tCompany(分页)
    * @param tCompany
    * @param page
    * @param limit
    * @return
    */
    public PageBean<TCompany> getTCompanybyPage(TCompany tCompany, Integer page, Integer limit){
        PageHelper.startPage(page, limit,"id desc");
        List<TCompany> tCompanys=getTCompany(tCompany);
            Integer countNums =getCount(tCompany);
            PageBean<TCompany> pageData = new PageBean<>(page, limit, countNums);
            pageData.setItems(tCompanys);
            return pageData;
        }

    /**
    * 查询tCompany
    * @param tCompany
    * @return
    */
    public List<TCompany> getTCompany(TCompany tCompany){
    List<TCompany>  tCompanys=tCompanyMapper.selectByExample(setCriteria(tCompany));
    return tCompanys;
    }

    /**
    * 更新tCompany
    * @param tCompany
    * @return
    */
    public String UpdateTCompany(TCompany tCompany)
    {
            String msg="";
            try{
            if(tCompany.getId()!=null){
            tCompanyMapper.updateByPrimaryKeySelective(tCompany);
                msg="更新TCompany成功";
            }
            else
            {
            tCompanyMapper.insertSelective(tCompany);
                msg="新建TCompany成功";
            }
            }
            catch (Exception e)
            {

            }
            return msg;
    }

    /**
    * 删除tCompany
    * @param tCompany
    * @return
    */
    public String DeleteTCompany(TCompany tCompany){
            String msg="";
            if(tCompany.getId()!=null){
            tCompanyMapper.deleteByPrimaryKey(tCompany.getId());
            msg="删除TCompany成功";
            }
            return msg;
    }

    /**
    * 根据ID查询tCompany
    * @param id
    * @return
    */
    public TCompany getTCompanyByID(Integer id) {
        return  tCompanyMapper.selectByPrimaryKey(id);
    }
}
