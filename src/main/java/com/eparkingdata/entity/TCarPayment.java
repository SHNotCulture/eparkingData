package com.eparkingdata.entity;

public class TCarPayment {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_car_payment.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_car_payment.actual_pay
     *
     * @mbg.generated
     */
    private Double actualPay;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_car_payment.begin_date
     *
     * @mbg.generated
     */
    private String beginDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_car_payment.carplate
     *
     * @mbg.generated
     */
    private String carplate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_car_payment.end_date
     *
     * @mbg.generated
     */
    private String endDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_car_payment.member_id
     *
     * @mbg.generated
     */
    private Integer memberId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_car_payment.need_pay
     *
     * @mbg.generated
     */
    private Double needPay;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_car_payment.oper_type
     *
     * @mbg.generated
     */
    private Integer operType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_car_payment.park_id
     *
     * @mbg.generated
     */
    private Integer parkId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_car_payment.pay_count
     *
     * @mbg.generated
     */
    private Integer payCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_car_payment.pay_rule
     *
     * @mbg.generated
     */
    private Integer payRule;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_car_payment.pay_standard
     *
     * @mbg.generated
     */
    private Short payStandard;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_car_payment.pay_time
     *
     * @mbg.generated
     */
    private String payTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_car_payment.pay_type
     *
     * @mbg.generated
     */
    private Short payType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_car_payment.remark
     *
     * @mbg.generated
     */
    private String remark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_car_payment.company_id
     *
     * @mbg.generated
     */
    private Integer companyId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_car_payment.recharge_no
     *
     * @mbg.generated
     */
    private String rechargeNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_car_payment.operator
     *
     * @mbg.generated
     */
    private String operator;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_car_payment.id
     *
     * @return the value of t_car_payment.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_car_payment.id
     *
     * @param id the value for t_car_payment.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_car_payment.actual_pay
     *
     * @return the value of t_car_payment.actual_pay
     *
     * @mbg.generated
     */
    public Double getActualPay() {
        return actualPay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_car_payment.actual_pay
     *
     * @param actualPay the value for t_car_payment.actual_pay
     *
     * @mbg.generated
     */
    public void setActualPay(Double actualPay) {
        this.actualPay = actualPay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_car_payment.begin_date
     *
     * @return the value of t_car_payment.begin_date
     *
     * @mbg.generated
     */
    public String getBeginDate() {
        return beginDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_car_payment.begin_date
     *
     * @param beginDate the value for t_car_payment.begin_date
     *
     * @mbg.generated
     */
    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate == null ? null : beginDate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_car_payment.carplate
     *
     * @return the value of t_car_payment.carplate
     *
     * @mbg.generated
     */
    public String getCarplate() {
        return carplate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_car_payment.carplate
     *
     * @param carplate the value for t_car_payment.carplate
     *
     * @mbg.generated
     */
    public void setCarplate(String carplate) {
        this.carplate = carplate == null ? null : carplate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_car_payment.end_date
     *
     * @return the value of t_car_payment.end_date
     *
     * @mbg.generated
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_car_payment.end_date
     *
     * @param endDate the value for t_car_payment.end_date
     *
     * @mbg.generated
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_car_payment.member_id
     *
     * @return the value of t_car_payment.member_id
     *
     * @mbg.generated
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_car_payment.member_id
     *
     * @param memberId the value for t_car_payment.member_id
     *
     * @mbg.generated
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_car_payment.need_pay
     *
     * @return the value of t_car_payment.need_pay
     *
     * @mbg.generated
     */
    public Double getNeedPay() {
        return needPay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_car_payment.need_pay
     *
     * @param needPay the value for t_car_payment.need_pay
     *
     * @mbg.generated
     */
    public void setNeedPay(Double needPay) {
        this.needPay = needPay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_car_payment.oper_type
     *
     * @return the value of t_car_payment.oper_type
     *
     * @mbg.generated
     */
    public Integer getOperType() {
        return operType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_car_payment.oper_type
     *
     * @param operType the value for t_car_payment.oper_type
     *
     * @mbg.generated
     */
    public void setOperType(Integer operType) {
        this.operType = operType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_car_payment.park_id
     *
     * @return the value of t_car_payment.park_id
     *
     * @mbg.generated
     */
    public Integer getParkId() {
        return parkId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_car_payment.park_id
     *
     * @param parkId the value for t_car_payment.park_id
     *
     * @mbg.generated
     */
    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_car_payment.pay_count
     *
     * @return the value of t_car_payment.pay_count
     *
     * @mbg.generated
     */
    public Integer getPayCount() {
        return payCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_car_payment.pay_count
     *
     * @param payCount the value for t_car_payment.pay_count
     *
     * @mbg.generated
     */
    public void setPayCount(Integer payCount) {
        this.payCount = payCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_car_payment.pay_rule
     *
     * @return the value of t_car_payment.pay_rule
     *
     * @mbg.generated
     */
    public Integer getPayRule() {
        return payRule;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_car_payment.pay_rule
     *
     * @param payRule the value for t_car_payment.pay_rule
     *
     * @mbg.generated
     */
    public void setPayRule(Integer payRule) {
        this.payRule = payRule;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_car_payment.pay_standard
     *
     * @return the value of t_car_payment.pay_standard
     *
     * @mbg.generated
     */
    public Short getPayStandard() {
        return payStandard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_car_payment.pay_standard
     *
     * @param payStandard the value for t_car_payment.pay_standard
     *
     * @mbg.generated
     */
    public void setPayStandard(Short payStandard) {
        this.payStandard = payStandard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_car_payment.pay_time
     *
     * @return the value of t_car_payment.pay_time
     *
     * @mbg.generated
     */
    public String getPayTime() {
        return payTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_car_payment.pay_time
     *
     * @param payTime the value for t_car_payment.pay_time
     *
     * @mbg.generated
     */
    public void setPayTime(String payTime) {
        this.payTime = payTime == null ? null : payTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_car_payment.pay_type
     *
     * @return the value of t_car_payment.pay_type
     *
     * @mbg.generated
     */
    public Short getPayType() {
        return payType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_car_payment.pay_type
     *
     * @param payType the value for t_car_payment.pay_type
     *
     * @mbg.generated
     */
    public void setPayType(Short payType) {
        this.payType = payType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_car_payment.remark
     *
     * @return the value of t_car_payment.remark
     *
     * @mbg.generated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_car_payment.remark
     *
     * @param remark the value for t_car_payment.remark
     *
     * @mbg.generated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_car_payment.company_id
     *
     * @return the value of t_car_payment.company_id
     *
     * @mbg.generated
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_car_payment.company_id
     *
     * @param companyId the value for t_car_payment.company_id
     *
     * @mbg.generated
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_car_payment.recharge_no
     *
     * @return the value of t_car_payment.recharge_no
     *
     * @mbg.generated
     */
    public String getRechargeNo() {
        return rechargeNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_car_payment.recharge_no
     *
     * @param rechargeNo the value for t_car_payment.recharge_no
     *
     * @mbg.generated
     */
    public void setRechargeNo(String rechargeNo) {
        this.rechargeNo = rechargeNo == null ? null : rechargeNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_car_payment.operator
     *
     * @return the value of t_car_payment.operator
     *
     * @mbg.generated
     */
    public String getOperator() {
        return operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_car_payment.operator
     *
     * @param operator the value for t_car_payment.operator
     *
     * @mbg.generated
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }
}