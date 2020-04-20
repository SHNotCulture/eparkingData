package com.eparkingdata.dao.sqlProvider;

import com.eparkingdata.entity.TElectronicTicket;
import com.eparkingdata.entity.TElectronicTicketCriteria;
import com.eparkingdata.entity.TElectronicTicketCriteria.Criteria;
import com.eparkingdata.entity.TElectronicTicketCriteria.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class TElectronicTicketSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_electronic_ticket
     *
     * @mbg.generated
     */
    public String countByExample(TElectronicTicketCriteria example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_electronic_ticket");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_electronic_ticket
     *
     * @mbg.generated
     */
    public String deleteByExample(TElectronicTicketCriteria example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_electronic_ticket");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_electronic_ticket
     *
     * @mbg.generated
     */
    public String insertSelective(TElectronicTicket record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_electronic_ticket");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getTicketName() != null) {
            sql.VALUES("ticket_name", "#{ticketName,jdbcType=VARCHAR}");
        }
        
        if (record.getTicketType() != null) {
            sql.VALUES("ticket_type", "#{ticketType,jdbcType=INTEGER}");
        }
        
        if (record.getTicketValue() != null) {
            sql.VALUES("ticket_value", "#{ticketValue,jdbcType=DOUBLE}");
        }
        
        if (record.getTicketPay() != null) {
            sql.VALUES("ticket_pay", "#{ticketPay,jdbcType=DOUBLE}");
        }
        
        if (record.getPermissionDay() != null) {
            sql.VALUES("permission_day", "#{permissionDay,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyId() != null) {
            sql.VALUES("company_id", "#{companyId,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_electronic_ticket
     *
     * @mbg.generated
     */
    public String selectByExample(TElectronicTicketCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("ticket_name");
        sql.SELECT("ticket_type");
        sql.SELECT("ticket_value");
        sql.SELECT("ticket_pay");
        sql.SELECT("permission_day");
        sql.SELECT("company_id");
        sql.SELECT("update_time");
        sql.FROM("t_electronic_ticket");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_electronic_ticket
     *
     * @mbg.generated
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        TElectronicTicket record = (TElectronicTicket) parameter.get("record");
        TElectronicTicketCriteria example = (TElectronicTicketCriteria) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_electronic_ticket");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getTicketName() != null) {
            sql.SET("ticket_name = #{record.ticketName,jdbcType=VARCHAR}");
        }
        
        if (record.getTicketType() != null) {
            sql.SET("ticket_type = #{record.ticketType,jdbcType=INTEGER}");
        }
        
        if (record.getTicketValue() != null) {
            sql.SET("ticket_value = #{record.ticketValue,jdbcType=DOUBLE}");
        }
        
        if (record.getTicketPay() != null) {
            sql.SET("ticket_pay = #{record.ticketPay,jdbcType=DOUBLE}");
        }
        
        if (record.getPermissionDay() != null) {
            sql.SET("permission_day = #{record.permissionDay,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyId() != null) {
            sql.SET("company_id = #{record.companyId,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_electronic_ticket
     *
     * @mbg.generated
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_electronic_ticket");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("ticket_name = #{record.ticketName,jdbcType=VARCHAR}");
        sql.SET("ticket_type = #{record.ticketType,jdbcType=INTEGER}");
        sql.SET("ticket_value = #{record.ticketValue,jdbcType=DOUBLE}");
        sql.SET("ticket_pay = #{record.ticketPay,jdbcType=DOUBLE}");
        sql.SET("permission_day = #{record.permissionDay,jdbcType=VARCHAR}");
        sql.SET("company_id = #{record.companyId,jdbcType=INTEGER}");
        sql.SET("update_time = #{record.updateTime,jdbcType=VARCHAR}");
        
        TElectronicTicketCriteria example = (TElectronicTicketCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_electronic_ticket
     *
     * @mbg.generated
     */
    public String updateByPrimaryKeySelective(TElectronicTicket record) {
        SQL sql = new SQL();
        sql.UPDATE("t_electronic_ticket");
        
        if (record.getTicketName() != null) {
            sql.SET("ticket_name = #{ticketName,jdbcType=VARCHAR}");
        }
        
        if (record.getTicketType() != null) {
            sql.SET("ticket_type = #{ticketType,jdbcType=INTEGER}");
        }
        
        if (record.getTicketValue() != null) {
            sql.SET("ticket_value = #{ticketValue,jdbcType=DOUBLE}");
        }
        
        if (record.getTicketPay() != null) {
            sql.SET("ticket_pay = #{ticketPay,jdbcType=DOUBLE}");
        }
        
        if (record.getPermissionDay() != null) {
            sql.SET("permission_day = #{permissionDay,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyId() != null) {
            sql.SET("company_id = #{companyId,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_electronic_ticket
     *
     * @mbg.generated
     */
    protected void applyWhere(SQL sql, TElectronicTicketCriteria example, boolean includeExamplePhrase) {
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