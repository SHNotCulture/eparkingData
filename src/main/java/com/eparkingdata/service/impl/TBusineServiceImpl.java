package com.eparkingdata.service.impl;

import com.eparkingdata.dao.TBusinePayMapper;
import com.eparkingdata.dao.TCompanyParkMapper;
import com.eparkingdata.entity.*;
import com.eparkingdata.service.TBusineService;
import com.eparkingdata.service.TCompanyUserService;
import com.eparkingdata.service.TUserService;
import com.eparkingdata.util.DateUtil;
import com.eparkingdata.util.MD5Util;
import com.eparkingdata.util.StringUtil;
import com.github.pagehelper.PageHelper;
import com.eparkingdata.dao.TBusineMapper;
import com.eparkingdata.util.PageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @Description: TBusineService接口实现类
* @author 谢轩然
* @date 2020/04/08 18:35
*/
@Service
public class TBusineServiceImpl  implements TBusineService {

    private  static final Logger logger= LoggerFactory.getLogger( TBusineServiceImpl.class);
    @Autowired
    private TBusineMapper tBusineMapper;
    @Autowired
    private TCompanyUserService tCompanyUserService;
    @Autowired
    private TCompanyParkMapper tCompanyParkMapper;
    @Autowired
    private TBusinePayMapper tBusinePayMapper;

    /**
    * 设置查询条件
    * @param tBusine
    * @return
    */
    private  TBusineCriteria setCriteria(TBusine tBusine){
        TBusineCriteria tBusineCriteria= new TBusineCriteria();
        if(tBusine!=null){
        TBusineCriteria.Criteria criteria=tBusineCriteria.createCriteria();
        if(tBusine.getId()!=null){
        criteria.andIdEqualTo(tBusine.getId());
        }
            if(tBusine.getParkId()!=null)
            {
                criteria.andParkIdEqualTo(tBusine.getParkId());
            }
            if(tBusine.getBusineName()!=null)
            {
                criteria.andBusineNameLike("%"+tBusine.getBusineName()+"%");
            }
            if(tBusine.getCompanyId()!=null){
                criteria.andCompanyIdEqualTo(tBusine.getCompanyId());
            }
            if(tBusine.getId()!=null)
            {
                criteria.andIdEqualTo(tBusine.getId());
            }
            if(tBusine.getAccount()!=null){
                criteria.andAccountEqualTo(tBusine.getAccount());
            }
        }
        return  tBusineCriteria;
    }

    /**
    * 获取数据总量
    * @param tBusine
    * @return
    */
    private Integer getCount(TBusine tBusine){
    Integer total =(int)tBusineMapper.countByExample(setCriteria(tBusine));
    return total;
    }

    /**
    *查询tBusine(分页)
    * @param tBusine
    * @param page
    * @param limit
    * @return
    */
    public PageBean<TBusine> getTBusinebyPage(TBusine tBusine, Integer page, Integer limit){
        PageHelper.startPage(page, limit,"id desc");
        List<TBusine> tBusines=getTBusine(tBusine);
            Integer countNums =getCount(tBusine);
            PageBean<TBusine> pageData = new PageBean<>(page, limit, countNums);
            pageData.setItems(tBusines);
            return pageData;
        }

    /**
    * 查询tBusine
    * @param tBusine
    * @return
    */
    public List<TBusine> getTBusine(TBusine tBusine){
    List<TBusine>  tBusines=tBusineMapper.selectByExample(setCriteria(tBusine));
    return tBusines;
    }

    /**
    * 更新tBusine
    * @param tBusine
    * @return
    */
    public String UpdateTBusine(TBusine tBusine)
    {
        logger.info(tBusine.toString());
        TCompanyUser tCompanyUser=null;

        if(tBusine.getId()!=null){
            tBusineMapper.updateByPrimaryKeySelective(tBusine);
            TCompanyUser user= new TCompanyUser();
            user.setUserAccout(tBusine.getAccount());
            user.setEntityType(2);
            user.setIsAdmin("3");
            List<TCompanyUser> userList=tCompanyUserService.getTCompanyUser(user);
            if(userList.size()>0){
                tCompanyUser=userList.get(0);
            }
        }
        else
        {
            tBusine.setPassword(MD5Util.MD5Encode("123456"));
            tBusineMapper.insertSelective(tBusine);
            tCompanyUser= new TCompanyUser();

        }
        if(tCompanyUser!=null)
        {
            tCompanyUser.setRoleId(212);
            tCompanyUser.setParkIds(tBusine.getParkId().toString());
            tCompanyUser.setUserName(tBusine.getBusineName());
            tCompanyUser.setUserAccout(tBusine.getAccount());
            tCompanyUser.setPassword(tBusine.getPassword());
            tCompanyUser.setCompanyId(tBusine.getCompanyId());
            tCompanyUser.setIsAdmin("3");
            tCompanyUser.setEntityType(2);
            tCompanyUserService.UpdateTCompanyUser(tCompanyUser);
        }

        return "更新成功";
    }

    /**
    * 删除tBusine
    * @param tBusine
    * @return
    */
    public String DeleteTBusine(TBusine tBusine){
            String msg="";
            if(tBusine.getId()!=null){
            tBusineMapper.deleteByPrimaryKey(tBusine.getId());
            msg="删除TBusine成功";
            }
            return msg;
    }

    /**
    * 根据ID查询tBusine
    * @param id
    * @return
    */
    public TBusine getTBusineByID(Integer id) {
        return  tBusineMapper.selectByPrimaryKey(id);
    }

    @Override
    public TBusine selectByAccount(String account) {
        TBusineCriteria tBusineCriteria = new TBusineCriteria();
        TBusineCriteria.Criteria criteria1 = tBusineCriteria.createCriteria();
        criteria1.andAccountEqualTo(account);
        return tBusineMapper.selectByExample(tBusineCriteria).get(0) ;
    }

    @Override
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public String BusineRecharge(TBusinePay tBusinePay, String type) {
        String msg = null;
        TCompanyPark tCompanyPark=tCompanyParkMapper.selectByPrimaryKey(tBusinePay.getParkId());
        //更改商户余额
        TBusine tBusine = tBusineMapper.selectByPrimaryKey(tBusinePay.getBusineId());
        if (type.equals("1")) {//充值
            tBusinePay.setRemark("充值");
            tBusine.setBalance(tBusine.getBalance() + tBusinePay.getActualPay());
            msg = "充值成功";
        }else if (type.equals("0")){//冲正
            tBusinePay.setRemark("充正");
            tBusine.setBalance(tBusine.getBalance() - tBusinePay.getActualPay());
            tBusinePay.setActualPay(tBusinePay.getActualPay()*(-1));
            tBusinePay.setNeedPay(tBusinePay.getNeedPay()*(-1));
            msg = "充正成功";
        }else if (type.equals("2")){//回购
            tBusinePay.setRemark("电子券回购");
            tBusine.setBalance(tBusine.getBalance() + tBusinePay.getActualPay());
            msg = "回购成功";}
        tBusineMapper.updateByPrimaryKeySelective(tBusine);


        //添加充值记录
        tBusinePay.setParkName(tCompanyPark.getParkName());
        tBusinePay.setOrderNumber(StringUtil.RandomOrder());
        tBusinePay.setPayTime(DateUtil.getCurDateTime());
        tBusinePay.setBalance(tBusine.getBalance());
        tBusinePayMapper.insertSelective(tBusinePay);
        return msg;
    }

    @Override
    public TBusine selectByPrimaryKey(Integer id) {
        return tBusineMapper.selectByPrimaryKey(id);
    }
}
