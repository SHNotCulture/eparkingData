package com.eparkingdata.service.impl;

import com.eparkingdata.service.TJournalService;
import com.eparkingdata.dao.TJournalMapper;
import com.eparkingdata.entity.TJournal;
import com.eparkingdata.service.TJournalService;
import com.eparkingdata.entity.TJournalCriteria;
import com.eparkingdata.util.PageBean;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
* @Description: TJournalService接口实现类
* @author 谢轩然
* @date 2020/04/09 15:17
*/
@Service
public class TJournalServiceImpl  implements TJournalService {

    private  static final Logger logger= LoggerFactory.getLogger( TJournalServiceImpl.class);
    @Autowired
    private TJournalMapper tJournalMapper;

    /**
    * 设置查询条件
    * @param tJournal
    * @return
    */
    private  TJournalCriteria setCriteria(TJournal tJournal){
        TJournalCriteria tJournalCriteria= new TJournalCriteria();
        if(tJournal!=null){
        TJournalCriteria.Criteria criteria=tJournalCriteria.createCriteria();
        if(tJournal.getId()!=null){
        criteria.andIdEqualTo(tJournal.getId());
        }

        }
        return  tJournalCriteria;
    }

    /**
    * 获取数据总量
    * @param tJournal
    * @return
    */
    private Integer getCount(TJournal tJournal){
    Integer total =(int)tJournalMapper.countByExample(setCriteria(tJournal));
    return total;
    }

    /**
    *查询tJournal(分页)
    * @param tJournal
    * @param page
    * @param limit
    * @return
    */
    public PageBean<TJournal> getTJournalbyPage(TJournal tJournal, Integer page, Integer limit){
        PageHelper.startPage(page, limit,"id desc");
        List<TJournal> tJournals=getTJournal(tJournal);
            Integer countNums =getCount(tJournal);
            PageBean<TJournal> pageData = new PageBean<>(page, limit, countNums);
            pageData.setItems(tJournals);
            return pageData;
        }

    /**
    * 查询tJournal
    * @param tJournal
    * @return
    */
    public List<TJournal> getTJournal(TJournal tJournal){
    List<TJournal>  tJournals=tJournalMapper.selectByExample(setCriteria(tJournal));
    return tJournals;
    }

    /**
    * 更新tJournal
    * @param tJournal
    * @return
    */
    public String UpdateTJournal(TJournal tJournal)
    {
            String msg="";
            try{
            if(tJournal.getId()!=null){
            tJournalMapper.updateByPrimaryKeySelective(tJournal);
                msg="更新TJournal成功";
            }
            else
            {
            tJournalMapper.insertSelective(tJournal);
                msg="新建TJournal成功";
            }
            }
            catch (Exception e)
            {

            }
            return msg;
    }

    /**
    * 删除tJournal
    * @param tJournal
    * @return
    */
    public String DeleteTJournal(TJournal tJournal){
            String msg="";
            if(tJournal.getId()!=null){
            tJournalMapper.deleteByPrimaryKey(tJournal.getId());
            msg="删除TJournal成功";
            }
            return msg;
    }

    /**
    * 根据ID查询tJournal
    * @param id
    * @return
    */
    public TJournal getTJournalByID(Integer id) {
        return  tJournalMapper.selectByPrimaryKey(id);
    }
}
