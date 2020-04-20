package com.eparkingdata.util;

import com.eparkingdata.entity.TCompany;
import com.eparkingdata.entity.TCompanyPark;
import com.eparkingdata.entity.TCompanyUser;
import com.eparkingdata.enums.ActionRspEnum;
import com.eparkingdata.exception.SessionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author lishuhan
 * @Description:
 * @Date Create in 15:152018-11-14
 * @Modified By:
 */
public class SessionUtil {
    private static Logger logger = LoggerFactory.getLogger(SessionUtil.class);
    public static TCompanyUser getUser(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        TCompanyUser user=null;
        try {
             user= JsonUtil.jsonToBean(request.getSession().getAttribute(Common.User).toString(),TCompanyUser.class);
            logger.info("uesr:"+user);
            if(user==null)
            {
                throw new SessionException(ActionRspEnum.SESSION_OUT);
            }
        }catch (Exception e){
            throw new SessionException(ActionRspEnum.SESSION_OUT);
        }
        return user ;
    }
    public static TCompanyPark getPark(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        TCompanyPark park=null;
        try {
            park= JsonUtil.jsonToBean(request.getSession().getAttribute(Common.Park).toString(),TCompanyPark.class);
            logger.info("park:"+park);
            if(park==null)
            {
                throw new SessionException(ActionRspEnum.SESSION_OUT);
            }
        }catch (Exception e){
            throw new SessionException(ActionRspEnum.SESSION_OUT);
        }
        return park ;
    }
    public static Integer getParkId()
    {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Integer parkID=0;
        try{
             parkID=Integer.valueOf(request.getSession().getAttribute(Common.ParkId).toString());
            logger.info("parkID:"+parkID);
            if(parkID==null)
            {
                throw new SessionException(ActionRspEnum.SESSION_OUT);
            }
        }
        catch (Exception e){
            throw new SessionException(ActionRspEnum.SESSION_OUT);
        }

        return parkID;
    }
    public static TCompany getCompany(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        TCompany company=null;
        try{
             company=JsonUtil.jsonToBean(request.getSession().getAttribute(Common.Company).toString(),TCompany.class);
            logger.info("company:"+company);
            if(company==null)
            {
                throw new SessionException(ActionRspEnum.SESSION_OUT);
            }
        }
        catch (Exception e){
            throw new SessionException(ActionRspEnum.SESSION_OUT);
        }

        return company;
    }
}
