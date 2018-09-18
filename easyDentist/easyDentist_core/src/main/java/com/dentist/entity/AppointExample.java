package com.dentist.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AppointExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppointExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPatientnameIsNull() {
            addCriterion("patientName is null");
            return (Criteria) this;
        }

        public Criteria andPatientnameIsNotNull() {
            addCriterion("patientName is not null");
            return (Criteria) this;
        }

        public Criteria andPatientnameEqualTo(String value) {
            addCriterion("patientName =", value, "patientname");
            return (Criteria) this;
        }

        public Criteria andPatientnameNotEqualTo(String value) {
            addCriterion("patientName <>", value, "patientname");
            return (Criteria) this;
        }

        public Criteria andPatientnameGreaterThan(String value) {
            addCriterion("patientName >", value, "patientname");
            return (Criteria) this;
        }

        public Criteria andPatientnameGreaterThanOrEqualTo(String value) {
            addCriterion("patientName >=", value, "patientname");
            return (Criteria) this;
        }

        public Criteria andPatientnameLessThan(String value) {
            addCriterion("patientName <", value, "patientname");
            return (Criteria) this;
        }

        public Criteria andPatientnameLessThanOrEqualTo(String value) {
            addCriterion("patientName <=", value, "patientname");
            return (Criteria) this;
        }

        public Criteria andPatientnameLike(String value) {
            addCriterion("patientName like", value, "patientname");
            return (Criteria) this;
        }

        public Criteria andPatientnameNotLike(String value) {
            addCriterion("patientName not like", value, "patientname");
            return (Criteria) this;
        }

        public Criteria andPatientnameIn(List<String> values) {
            addCriterion("patientName in", values, "patientname");
            return (Criteria) this;
        }

        public Criteria andPatientnameNotIn(List<String> values) {
            addCriterion("patientName not in", values, "patientname");
            return (Criteria) this;
        }

        public Criteria andPatientnameBetween(String value1, String value2) {
            addCriterion("patientName between", value1, value2, "patientname");
            return (Criteria) this;
        }

        public Criteria andPatientnameNotBetween(String value1, String value2) {
            addCriterion("patientName not between", value1, value2, "patientname");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andClinicIsNull() {
            addCriterion("clinic is null");
            return (Criteria) this;
        }

        public Criteria andClinicIsNotNull() {
            addCriterion("clinic is not null");
            return (Criteria) this;
        }

        public Criteria andClinicEqualTo(String value) {
            addCriterion("clinic =", value, "clinic");
            return (Criteria) this;
        }

        public Criteria andClinicNotEqualTo(String value) {
            addCriterion("clinic <>", value, "clinic");
            return (Criteria) this;
        }

        public Criteria andClinicGreaterThan(String value) {
            addCriterion("clinic >", value, "clinic");
            return (Criteria) this;
        }

        public Criteria andClinicGreaterThanOrEqualTo(String value) {
            addCriterion("clinic >=", value, "clinic");
            return (Criteria) this;
        }

        public Criteria andClinicLessThan(String value) {
            addCriterion("clinic <", value, "clinic");
            return (Criteria) this;
        }

        public Criteria andClinicLessThanOrEqualTo(String value) {
            addCriterion("clinic <=", value, "clinic");
            return (Criteria) this;
        }

        public Criteria andClinicLike(String value) {
            addCriterion("clinic like", value, "clinic");
            return (Criteria) this;
        }

        public Criteria andClinicNotLike(String value) {
            addCriterion("clinic not like", value, "clinic");
            return (Criteria) this;
        }

        public Criteria andClinicIn(List<String> values) {
            addCriterion("clinic in", values, "clinic");
            return (Criteria) this;
        }

        public Criteria andClinicNotIn(List<String> values) {
            addCriterion("clinic not in", values, "clinic");
            return (Criteria) this;
        }

        public Criteria andClinicBetween(String value1, String value2) {
            addCriterion("clinic between", value1, value2, "clinic");
            return (Criteria) this;
        }

        public Criteria andClinicNotBetween(String value1, String value2) {
            addCriterion("clinic not between", value1, value2, "clinic");
            return (Criteria) this;
        }

        public Criteria andMessagecontentIsNull() {
            addCriterion("messageContent is null");
            return (Criteria) this;
        }

        public Criteria andMessagecontentIsNotNull() {
            addCriterion("messageContent is not null");
            return (Criteria) this;
        }

        public Criteria andMessagecontentEqualTo(String value) {
            addCriterion("messageContent =", value, "messagecontent");
            return (Criteria) this;
        }

        public Criteria andMessagecontentNotEqualTo(String value) {
            addCriterion("messageContent <>", value, "messagecontent");
            return (Criteria) this;
        }

        public Criteria andMessagecontentGreaterThan(String value) {
            addCriterion("messageContent >", value, "messagecontent");
            return (Criteria) this;
        }

        public Criteria andMessagecontentGreaterThanOrEqualTo(String value) {
            addCriterion("messageContent >=", value, "messagecontent");
            return (Criteria) this;
        }

        public Criteria andMessagecontentLessThan(String value) {
            addCriterion("messageContent <", value, "messagecontent");
            return (Criteria) this;
        }

        public Criteria andMessagecontentLessThanOrEqualTo(String value) {
            addCriterion("messageContent <=", value, "messagecontent");
            return (Criteria) this;
        }

        public Criteria andMessagecontentLike(String value) {
            addCriterion("messageContent like", value, "messagecontent");
            return (Criteria) this;
        }

        public Criteria andMessagecontentNotLike(String value) {
            addCriterion("messageContent not like", value, "messagecontent");
            return (Criteria) this;
        }

        public Criteria andMessagecontentIn(List<String> values) {
            addCriterion("messageContent in", values, "messagecontent");
            return (Criteria) this;
        }

        public Criteria andMessagecontentNotIn(List<String> values) {
            addCriterion("messageContent not in", values, "messagecontent");
            return (Criteria) this;
        }

        public Criteria andMessagecontentBetween(String value1, String value2) {
            addCriterion("messageContent between", value1, value2, "messagecontent");
            return (Criteria) this;
        }

        public Criteria andMessagecontentNotBetween(String value1, String value2) {
            addCriterion("messageContent not between", value1, value2, "messagecontent");
            return (Criteria) this;
        }

        public Criteria andMessagetypeIsNull() {
            addCriterion("messageType is null");
            return (Criteria) this;
        }

        public Criteria andMessagetypeIsNotNull() {
            addCriterion("messageType is not null");
            return (Criteria) this;
        }

        public Criteria andMessagetypeEqualTo(String value) {
            addCriterion("messageType =", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeNotEqualTo(String value) {
            addCriterion("messageType <>", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeGreaterThan(String value) {
            addCriterion("messageType >", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeGreaterThanOrEqualTo(String value) {
            addCriterion("messageType >=", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeLessThan(String value) {
            addCriterion("messageType <", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeLessThanOrEqualTo(String value) {
            addCriterion("messageType <=", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeLike(String value) {
            addCriterion("messageType like", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeNotLike(String value) {
            addCriterion("messageType not like", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeIn(List<String> values) {
            addCriterion("messageType in", values, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeNotIn(List<String> values) {
            addCriterion("messageType not in", values, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeBetween(String value1, String value2) {
            addCriterion("messageType between", value1, value2, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeNotBetween(String value1, String value2) {
            addCriterion("messageType not between", value1, value2, "messagetype");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andDoctornameIsNull() {
            addCriterion("doctorName is null");
            return (Criteria) this;
        }

        public Criteria andDoctornameIsNotNull() {
            addCriterion("doctorName is not null");
            return (Criteria) this;
        }

        public Criteria andDoctornameEqualTo(String value) {
            addCriterion("doctorName =", value, "doctorname");
            return (Criteria) this;
        }

        public Criteria andDoctornameNotEqualTo(String value) {
            addCriterion("doctorName <>", value, "doctorname");
            return (Criteria) this;
        }

        public Criteria andDoctornameGreaterThan(String value) {
            addCriterion("doctorName >", value, "doctorname");
            return (Criteria) this;
        }

        public Criteria andDoctornameGreaterThanOrEqualTo(String value) {
            addCriterion("doctorName >=", value, "doctorname");
            return (Criteria) this;
        }

        public Criteria andDoctornameLessThan(String value) {
            addCriterion("doctorName <", value, "doctorname");
            return (Criteria) this;
        }

        public Criteria andDoctornameLessThanOrEqualTo(String value) {
            addCriterion("doctorName <=", value, "doctorname");
            return (Criteria) this;
        }

        public Criteria andDoctornameLike(String value) {
            addCriterion("doctorName like", value, "doctorname");
            return (Criteria) this;
        }

        public Criteria andDoctornameNotLike(String value) {
            addCriterion("doctorName not like", value, "doctorname");
            return (Criteria) this;
        }

        public Criteria andDoctornameIn(List<String> values) {
            addCriterion("doctorName in", values, "doctorname");
            return (Criteria) this;
        }

        public Criteria andDoctornameNotIn(List<String> values) {
            addCriterion("doctorName not in", values, "doctorname");
            return (Criteria) this;
        }

        public Criteria andDoctornameBetween(String value1, String value2) {
            addCriterion("doctorName between", value1, value2, "doctorname");
            return (Criteria) this;
        }

        public Criteria andDoctornameNotBetween(String value1, String value2) {
            addCriterion("doctorName not between", value1, value2, "doctorname");
            return (Criteria) this;
        }

        public Criteria andAppointdateIsNull() {
            addCriterion("appointDate is null");
            return (Criteria) this;
        }

        public Criteria andAppointdateIsNotNull() {
            addCriterion("appointDate is not null");
            return (Criteria) this;
        }

        public Criteria andAppointdateEqualTo(Date value) {
            addCriterionForJDBCDate("appointDate =", value, "appointdate");
            return (Criteria) this;
        }

        public Criteria andAppointdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("appointDate <>", value, "appointdate");
            return (Criteria) this;
        }

        public Criteria andAppointdateGreaterThan(Date value) {
            addCriterionForJDBCDate("appointDate >", value, "appointdate");
            return (Criteria) this;
        }

        public Criteria andAppointdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("appointDate >=", value, "appointdate");
            return (Criteria) this;
        }

        public Criteria andAppointdateLessThan(Date value) {
            addCriterionForJDBCDate("appointDate <", value, "appointdate");
            return (Criteria) this;
        }

        public Criteria andAppointdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("appointDate <=", value, "appointdate");
            return (Criteria) this;
        }

        public Criteria andAppointdateIn(List<Date> values) {
            addCriterionForJDBCDate("appointDate in", values, "appointdate");
            return (Criteria) this;
        }

        public Criteria andAppointdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("appointDate not in", values, "appointdate");
            return (Criteria) this;
        }

        public Criteria andAppointdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("appointDate between", value1, value2, "appointdate");
            return (Criteria) this;
        }

        public Criteria andAppointdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("appointDate not between", value1, value2, "appointdate");
            return (Criteria) this;
        }

        public Criteria andSearchcodeIsNull() {
            addCriterion("searchCode is null");
            return (Criteria) this;
        }

        public Criteria andSearchcodeIsNotNull() {
            addCriterion("searchCode is not null");
            return (Criteria) this;
        }

        public Criteria andSearchcodeEqualTo(String value) {
            addCriterion("searchCode =", value, "searchcode");
            return (Criteria) this;
        }

        public Criteria andSearchcodeNotEqualTo(String value) {
            addCriterion("searchCode <>", value, "searchcode");
            return (Criteria) this;
        }

        public Criteria andSearchcodeGreaterThan(String value) {
            addCriterion("searchCode >", value, "searchcode");
            return (Criteria) this;
        }

        public Criteria andSearchcodeGreaterThanOrEqualTo(String value) {
            addCriterion("searchCode >=", value, "searchcode");
            return (Criteria) this;
        }

        public Criteria andSearchcodeLessThan(String value) {
            addCriterion("searchCode <", value, "searchcode");
            return (Criteria) this;
        }

        public Criteria andSearchcodeLessThanOrEqualTo(String value) {
            addCriterion("searchCode <=", value, "searchcode");
            return (Criteria) this;
        }

        public Criteria andSearchcodeLike(String value) {
            addCriterion("searchCode like", value, "searchcode");
            return (Criteria) this;
        }

        public Criteria andSearchcodeNotLike(String value) {
            addCriterion("searchCode not like", value, "searchcode");
            return (Criteria) this;
        }

        public Criteria andSearchcodeIn(List<String> values) {
            addCriterion("searchCode in", values, "searchcode");
            return (Criteria) this;
        }

        public Criteria andSearchcodeNotIn(List<String> values) {
            addCriterion("searchCode not in", values, "searchcode");
            return (Criteria) this;
        }

        public Criteria andSearchcodeBetween(String value1, String value2) {
            addCriterion("searchCode between", value1, value2, "searchcode");
            return (Criteria) this;
        }

        public Criteria andSearchcodeNotBetween(String value1, String value2) {
            addCriterion("searchCode not between", value1, value2, "searchcode");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andOperatoridIsNull() {
            addCriterion("operatorId is null");
            return (Criteria) this;
        }

        public Criteria andOperatoridIsNotNull() {
            addCriterion("operatorId is not null");
            return (Criteria) this;
        }

        public Criteria andOperatoridEqualTo(Integer value) {
            addCriterion("operatorId =", value, "operatorid");
            return (Criteria) this;
        }

        public Criteria andOperatoridNotEqualTo(Integer value) {
            addCriterion("operatorId <>", value, "operatorid");
            return (Criteria) this;
        }

        public Criteria andOperatoridGreaterThan(Integer value) {
            addCriterion("operatorId >", value, "operatorid");
            return (Criteria) this;
        }

        public Criteria andOperatoridGreaterThanOrEqualTo(Integer value) {
            addCriterion("operatorId >=", value, "operatorid");
            return (Criteria) this;
        }

        public Criteria andOperatoridLessThan(Integer value) {
            addCriterion("operatorId <", value, "operatorid");
            return (Criteria) this;
        }

        public Criteria andOperatoridLessThanOrEqualTo(Integer value) {
            addCriterion("operatorId <=", value, "operatorid");
            return (Criteria) this;
        }

        public Criteria andOperatoridIn(List<Integer> values) {
            addCriterion("operatorId in", values, "operatorid");
            return (Criteria) this;
        }

        public Criteria andOperatoridNotIn(List<Integer> values) {
            addCriterion("operatorId not in", values, "operatorid");
            return (Criteria) this;
        }

        public Criteria andOperatoridBetween(Integer value1, Integer value2) {
            addCriterion("operatorId between", value1, value2, "operatorid");
            return (Criteria) this;
        }

        public Criteria andOperatoridNotBetween(Integer value1, Integer value2) {
            addCriterion("operatorId not between", value1, value2, "operatorid");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}