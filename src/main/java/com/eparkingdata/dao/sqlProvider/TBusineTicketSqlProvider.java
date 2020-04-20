package com.eparkingdata.dao.sqlProvider;

import com.eparkingdata.entity.TBusineTicket;
import com.eparkingdata.entity.TBusineTicketCriteria;
import com.eparkingdata.entity.TBusineTicketCriteria.Criteria;
import com.eparkingdata.entity.TBusineTicketCriteria.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class TBusineTicketSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_busine_ticket
     *
     * @mbg.generated
     */
    public String countByExample(TBusineTicketCriteria example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_busine_ticket");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_busine_ticket
     *
     * @mbg.generated
     */
    public String deleteByExample(TBusineTicketCriteria example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_busine_ticket");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_busine_ticket
     *
     * @mbg.generated
     */
    public String insertSelective(TBusineTicket record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_busine_ticket");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getBusineId() != null) {
            sql.VALUES("busine_id", "#{busineId,jdbcType=INTEGER}");
        }
        
        if (record.getBusineName() != null) {
            sql.VALUES("busine_name", "#{busineName,jdbcType=VARCHAR}");
        }
        
        if (record.getTicketId() != null) {
            sql.VALUES("ticket_id", "#{ticketId,jdbcType=INTEGER}");
        }
        
        if (record.getTicketName() != null) {
            sql.VALUES("ticket_name", "#{ticketName,jdbcType=VARCHAR}");
        }
        
        if (record.getTicketNum() != null) {
            sql.VALUES("ticket_num", "#{ticketNum,jdbcType=INTEGER}");
        }
        
        if (record.getLimitDay() != null) {
            sql.VALUES("limit_day", "#{limitDay,jdbcType=INTEGER}");
        }
        
        if (record.getLimitMonth() != null) {
            sql.VALUES("limit_month", "#{limitMonth,jdbcType=INTEGER}");
        }
        
        if (record.getLimitYear() != null) {
            sql.VALUES("limit_year", "#{limitYear,jdbcType=INTEGER}");
        }
        
        if (record.getExpiryDate() != null) {
            sql.VALUES("expiry_date", "#{expiryDate,jdbcType=VARCHAR}");
        }
        
        if (record.getTicketInitialNum() != null) {
            sql.VALUES("ticket_initial_num", "#{ticketInitialNum,jdbcType=INTEGER}");
        }
        
        if (record.getCompanyId() != null) {
            sql.VALUES("company_id", "#{companyId,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=VARCHAR}");
        }
        
        if (record.getIsPay() != null) {
            sql.VALUES("is_pay", "#{isPay,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_busine_ticket
     *
     * @mbg.generated
     */
    public String selectByExample(TBusineTicketCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("busine_id");
        sql.SELECT("busine_name");
        sql.SELECT("ticket_id");
        sql.SELECT("ticket_name");
        sql.SELECT("ticket_num");
        sql.SELECT("limit_day");
        sql.SELECT("limit_month");
        sql.SELECT("limit_year");
        sql.SELECT("expiry_date");
        sql.SELECT("ticket_initial_num");
        sql.SELECT("company_id");
        sql.SELECT("update_time");
        sql.SELECT("is_pay");
        sql.FROM("t_busine_ticket");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_busine_ticket
     *
     * @mbg.generated
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        TBusineTicket record = (TBusineTicket) parameter.get("record");
        TBusineTicketCriteria example = (TBusineTicketCriteria) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_busine_ticket");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getBusineId() != null) {
            sql.SET("busine_id = #{record.busineId,jdbcType=INTEGER}");
        }
        
        if (record.getBusineName() != null) {
            sql.SET("busine_name = #{record.busineName,jdbcType=VARCHAR}");
        }
        
        if (record.getTicketId() != null) {
            sql.SET("ticket_id = #{record.ticketId,jdbcType=INTEGER}");
        }
        
        if (record.getTicketName() != null) {
            sql.SET("ticket_name = #{record.ticketName,jdbcType=VARCHAR}");
        }
        
        if (record.getTicketNum() != null) {
            sql.SET("ticket_num = #{record.ticketNum,jdbcType=INTEGER}");
        }
        
        if (record.getLimitDay() != null) {
            sql.SET("limit_day = #{record.limitDay,jdbcType=INTEGER}");
        }
        
        if (record.getLimitMonth() != null) {
            sql.SET("limit_month = #{record.limitMonth,jdbcType=INTEGER}");
        }
        
        if (record.getLimitYear() != null) {
            sql.SET("limit_year = #{record.limitYear,jdbcType=INTEGER}");
        }
        
        if (record.getExpiryDate() != null) {
            sql.SET("expiry_date = #{record.expiryDate,jdbcType=VARCHAR}");
        }
        
        if (record.getTicketInitialNum() != null) {
            sql.SET("ticket_initial_num = #{record.ticketInitialNum,jdbcType=INTEGER}");
        }
        
        if (record.getCompanyId() != null) {
            sql.SET("company_id = #{record.companyId,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=VARCHAR}");
        }
        
        if (record.getIsPay() != null) {
            sql.SET("is_pay = #{record.isPay,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_busine_ticket
     *
     * @mbg.generated
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_busine_ticket");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("busine_id = #{record.busineId,jdbcType=INTEGER}");
        sql.SET("busine_name = #{record.busineName,jdbcType=VARCHAR}");
        sql.SET("ticket_id = #{record.ticketId,jdbcType=INTEGER}");
        sql.SET("ticket_name = #{record.ticketName,jdbcType=VARCHAR}");
        sql.SET("ticket_num = #{record.ticketNum,jdbcType=INTEGER}");
        sql.SET("limit_day = #{record.limitDay,jdbcType=INTEGER}");
        sql.SET("limit_month = #{record.limitMonth,jdbcType=INTEGER}");
        sql.SET("limit_year = #{record.limitYear,jdbcType=INTEGER}");
        sql.SET("expiry_date = #{record.expiryDate,jdbcType=VARCHAR}");
        sql.SET("ticket_initial_num = #{record.ticketInitialNum,jdbcType=INTEGER}");
        sql.SET("company_id = #{record.companyId,jdbcType=INTEGER}");
        sql.SET("update_time = #{record.updateTime,jdbcType=VARCHAR}");
        sql.SET("is_pay = #{record.isPay,jdbcType=INTEGER}");
        
        TBusineTicketCriteria example = (TBusineTicketCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_busine_ticket
     *
     * @mbg.generated
     */
    public String updateByPrimaryKeySelective(TBusineTicket record) {
        SQL sql = new SQL();
        sql.UPDATE("t_busine_ticket");
        
        if (record.getBusineId() != null) {
            sql.SET("busine_id = #{busineId,jdbcType=INTEGER}");
        }
        
        if (record.getBusineName() != null) {
            sql.SET("busine_name = #{busineName,jdbcType=VARCHAR}");
        }
        
        if (record.getTicketId() != null) {
            sql.SET("ticket_id = #{ticketId,jdbcType=INTEGER}");
        }
        
        if (record.getTicketName() != null) {
            sql.SET("ticket_name = #{ticketName,jdbcType=VARCHAR}");
        }
        
        if (record.getTicketNum() != null) {
            sql.SET("ticket_num = #{ticketNum,jdbcType=INTEGER}");
        }
        
        if (record.getLimitDay() != null) {
            sql.SET("limit_day = #{limitDay,jdbcType=INTEGER}");
        }
        
        if (record.getLimitMonth() != null) {
            sql.SET("limit_month = #{limitMonth,jdbcType=INTEGER}");
        }
        
        if (record.getLimitYear() != null) {
            sql.SET("limit_year = #{limitYear,jdbcType=INTEGER}");
        }
        
        if (record.getExpiryDate() != null) {
            sql.SET("expiry_date = #{expiryDate,jdbcType=VARCHAR}");
        }
        
        if (record.getTicketInitialNum() != null) {
            sql.SET("ticket_initial_num = #{ticketInitialNum,jdbcType=INTEGER}");
        }
        
        if (record.getCompanyId() != null) {
            sql.SET("company_id = #{companyId,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=VARCHAR}");
        }
        
        if (record.getIsPay() != null) {
            sql.SET("is_pay = #{isPay,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_busine_ticket
     *
     * @mbg.generated
     */
    protected void applyWhere(SQL sql, TBusineTicketCriteria example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}