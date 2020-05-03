package com.example.shop.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andUidIsNull() {
            addCriterion("`uid` is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("`uid` is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("`uid` =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("`uid` <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("`uid` >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("`uid` >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("`uid` <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("`uid` <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("`uid` in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("`uid` not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("`uid` between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("`uid` not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUnameIsNull() {
            addCriterion("uname is null");
            return (Criteria) this;
        }

        public Criteria andUnameIsNotNull() {
            addCriterion("uname is not null");
            return (Criteria) this;
        }

        public Criteria andUnameEqualTo(String value) {
            addCriterion("uname =", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotEqualTo(String value) {
            addCriterion("uname <>", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameGreaterThan(String value) {
            addCriterion("uname >", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameGreaterThanOrEqualTo(String value) {
            addCriterion("uname >=", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLessThan(String value) {
            addCriterion("uname <", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLessThanOrEqualTo(String value) {
            addCriterion("uname <=", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLike(String value) {
            addCriterion("uname like", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotLike(String value) {
            addCriterion("uname not like", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameIn(List<String> values) {
            addCriterion("uname in", values, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotIn(List<String> values) {
            addCriterion("uname not in", values, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameBetween(String value1, String value2) {
            addCriterion("uname between", value1, value2, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotBetween(String value1, String value2) {
            addCriterion("uname not between", value1, value2, "uname");
            return (Criteria) this;
        }

        public Criteria andUpswdIsNull() {
            addCriterion("upswd is null");
            return (Criteria) this;
        }

        public Criteria andUpswdIsNotNull() {
            addCriterion("upswd is not null");
            return (Criteria) this;
        }

        public Criteria andUpswdEqualTo(String value) {
            addCriterion("upswd =", value, "upswd");
            return (Criteria) this;
        }

        public Criteria andUpswdNotEqualTo(String value) {
            addCriterion("upswd <>", value, "upswd");
            return (Criteria) this;
        }

        public Criteria andUpswdGreaterThan(String value) {
            addCriterion("upswd >", value, "upswd");
            return (Criteria) this;
        }

        public Criteria andUpswdGreaterThanOrEqualTo(String value) {
            addCriterion("upswd >=", value, "upswd");
            return (Criteria) this;
        }

        public Criteria andUpswdLessThan(String value) {
            addCriterion("upswd <", value, "upswd");
            return (Criteria) this;
        }

        public Criteria andUpswdLessThanOrEqualTo(String value) {
            addCriterion("upswd <=", value, "upswd");
            return (Criteria) this;
        }

        public Criteria andUpswdLike(String value) {
            addCriterion("upswd like", value, "upswd");
            return (Criteria) this;
        }

        public Criteria andUpswdNotLike(String value) {
            addCriterion("upswd not like", value, "upswd");
            return (Criteria) this;
        }

        public Criteria andUpswdIn(List<String> values) {
            addCriterion("upswd in", values, "upswd");
            return (Criteria) this;
        }

        public Criteria andUpswdNotIn(List<String> values) {
            addCriterion("upswd not in", values, "upswd");
            return (Criteria) this;
        }

        public Criteria andUpswdBetween(String value1, String value2) {
            addCriterion("upswd between", value1, value2, "upswd");
            return (Criteria) this;
        }

        public Criteria andUpswdNotBetween(String value1, String value2) {
            addCriterion("upswd not between", value1, value2, "upswd");
            return (Criteria) this;
        }

        public Criteria andUtelIsNull() {
            addCriterion("utel is null");
            return (Criteria) this;
        }

        public Criteria andUtelIsNotNull() {
            addCriterion("utel is not null");
            return (Criteria) this;
        }

        public Criteria andUtelEqualTo(String value) {
            addCriterion("utel =", value, "utel");
            return (Criteria) this;
        }

        public Criteria andUtelNotEqualTo(String value) {
            addCriterion("utel <>", value, "utel");
            return (Criteria) this;
        }

        public Criteria andUtelGreaterThan(String value) {
            addCriterion("utel >", value, "utel");
            return (Criteria) this;
        }

        public Criteria andUtelGreaterThanOrEqualTo(String value) {
            addCriterion("utel >=", value, "utel");
            return (Criteria) this;
        }

        public Criteria andUtelLessThan(String value) {
            addCriterion("utel <", value, "utel");
            return (Criteria) this;
        }

        public Criteria andUtelLessThanOrEqualTo(String value) {
            addCriterion("utel <=", value, "utel");
            return (Criteria) this;
        }

        public Criteria andUtelLike(String value) {
            addCriterion("utel like", value, "utel");
            return (Criteria) this;
        }

        public Criteria andUtelNotLike(String value) {
            addCriterion("utel not like", value, "utel");
            return (Criteria) this;
        }

        public Criteria andUtelIn(List<String> values) {
            addCriterion("utel in", values, "utel");
            return (Criteria) this;
        }

        public Criteria andUtelNotIn(List<String> values) {
            addCriterion("utel not in", values, "utel");
            return (Criteria) this;
        }

        public Criteria andUtelBetween(String value1, String value2) {
            addCriterion("utel between", value1, value2, "utel");
            return (Criteria) this;
        }

        public Criteria andUtelNotBetween(String value1, String value2) {
            addCriterion("utel not between", value1, value2, "utel");
            return (Criteria) this;
        }

        public Criteria andUemlIsNull() {
            addCriterion("ueml is null");
            return (Criteria) this;
        }

        public Criteria andUemlIsNotNull() {
            addCriterion("ueml is not null");
            return (Criteria) this;
        }

        public Criteria andUemlEqualTo(String value) {
            addCriterion("ueml =", value, "ueml");
            return (Criteria) this;
        }

        public Criteria andUemlNotEqualTo(String value) {
            addCriterion("ueml <>", value, "ueml");
            return (Criteria) this;
        }

        public Criteria andUemlGreaterThan(String value) {
            addCriterion("ueml >", value, "ueml");
            return (Criteria) this;
        }

        public Criteria andUemlGreaterThanOrEqualTo(String value) {
            addCriterion("ueml >=", value, "ueml");
            return (Criteria) this;
        }

        public Criteria andUemlLessThan(String value) {
            addCriterion("ueml <", value, "ueml");
            return (Criteria) this;
        }

        public Criteria andUemlLessThanOrEqualTo(String value) {
            addCriterion("ueml <=", value, "ueml");
            return (Criteria) this;
        }

        public Criteria andUemlLike(String value) {
            addCriterion("ueml like", value, "ueml");
            return (Criteria) this;
        }

        public Criteria andUemlNotLike(String value) {
            addCriterion("ueml not like", value, "ueml");
            return (Criteria) this;
        }

        public Criteria andUemlIn(List<String> values) {
            addCriterion("ueml in", values, "ueml");
            return (Criteria) this;
        }

        public Criteria andUemlNotIn(List<String> values) {
            addCriterion("ueml not in", values, "ueml");
            return (Criteria) this;
        }

        public Criteria andUemlBetween(String value1, String value2) {
            addCriterion("ueml between", value1, value2, "ueml");
            return (Criteria) this;
        }

        public Criteria andUemlNotBetween(String value1, String value2) {
            addCriterion("ueml not between", value1, value2, "ueml");
            return (Criteria) this;
        }

        public Criteria andUsexIsNull() {
            addCriterion("usex is null");
            return (Criteria) this;
        }

        public Criteria andUsexIsNotNull() {
            addCriterion("usex is not null");
            return (Criteria) this;
        }

        public Criteria andUsexEqualTo(String value) {
            addCriterion("usex =", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexNotEqualTo(String value) {
            addCriterion("usex <>", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexGreaterThan(String value) {
            addCriterion("usex >", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexGreaterThanOrEqualTo(String value) {
            addCriterion("usex >=", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexLessThan(String value) {
            addCriterion("usex <", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexLessThanOrEqualTo(String value) {
            addCriterion("usex <=", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexLike(String value) {
            addCriterion("usex like", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexNotLike(String value) {
            addCriterion("usex not like", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexIn(List<String> values) {
            addCriterion("usex in", values, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexNotIn(List<String> values) {
            addCriterion("usex not in", values, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexBetween(String value1, String value2) {
            addCriterion("usex between", value1, value2, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexNotBetween(String value1, String value2) {
            addCriterion("usex not between", value1, value2, "usex");
            return (Criteria) this;
        }

        public Criteria andUtextIsNull() {
            addCriterion("utext is null");
            return (Criteria) this;
        }

        public Criteria andUtextIsNotNull() {
            addCriterion("utext is not null");
            return (Criteria) this;
        }

        public Criteria andUtextEqualTo(String value) {
            addCriterion("utext =", value, "utext");
            return (Criteria) this;
        }

        public Criteria andUtextNotEqualTo(String value) {
            addCriterion("utext <>", value, "utext");
            return (Criteria) this;
        }

        public Criteria andUtextGreaterThan(String value) {
            addCriterion("utext >", value, "utext");
            return (Criteria) this;
        }

        public Criteria andUtextGreaterThanOrEqualTo(String value) {
            addCriterion("utext >=", value, "utext");
            return (Criteria) this;
        }

        public Criteria andUtextLessThan(String value) {
            addCriterion("utext <", value, "utext");
            return (Criteria) this;
        }

        public Criteria andUtextLessThanOrEqualTo(String value) {
            addCriterion("utext <=", value, "utext");
            return (Criteria) this;
        }

        public Criteria andUtextLike(String value) {
            addCriterion("utext like", value, "utext");
            return (Criteria) this;
        }

        public Criteria andUtextNotLike(String value) {
            addCriterion("utext not like", value, "utext");
            return (Criteria) this;
        }

        public Criteria andUtextIn(List<String> values) {
            addCriterion("utext in", values, "utext");
            return (Criteria) this;
        }

        public Criteria andUtextNotIn(List<String> values) {
            addCriterion("utext not in", values, "utext");
            return (Criteria) this;
        }

        public Criteria andUtextBetween(String value1, String value2) {
            addCriterion("utext between", value1, value2, "utext");
            return (Criteria) this;
        }

        public Criteria andUtextNotBetween(String value1, String value2) {
            addCriterion("utext not between", value1, value2, "utext");
            return (Criteria) this;
        }

        public Criteria andUdtIsNull() {
            addCriterion("udt is null");
            return (Criteria) this;
        }

        public Criteria andUdtIsNotNull() {
            addCriterion("udt is not null");
            return (Criteria) this;
        }

        public Criteria andUdtEqualTo(Date value) {
            addCriterion("udt =", value, "udt");
            return (Criteria) this;
        }

        public Criteria andUdtNotEqualTo(Date value) {
            addCriterion("udt <>", value, "udt");
            return (Criteria) this;
        }

        public Criteria andUdtGreaterThan(Date value) {
            addCriterion("udt >", value, "udt");
            return (Criteria) this;
        }

        public Criteria andUdtGreaterThanOrEqualTo(Date value) {
            addCriterion("udt >=", value, "udt");
            return (Criteria) this;
        }

        public Criteria andUdtLessThan(Date value) {
            addCriterion("udt <", value, "udt");
            return (Criteria) this;
        }

        public Criteria andUdtLessThanOrEqualTo(Date value) {
            addCriterion("udt <=", value, "udt");
            return (Criteria) this;
        }

        public Criteria andUdtIn(List<Date> values) {
            addCriterion("udt in", values, "udt");
            return (Criteria) this;
        }

        public Criteria andUdtNotIn(List<Date> values) {
            addCriterion("udt not in", values, "udt");
            return (Criteria) this;
        }

        public Criteria andUdtBetween(Date value1, Date value2) {
            addCriterion("udt between", value1, value2, "udt");
            return (Criteria) this;
        }

        public Criteria andUdtNotBetween(Date value1, Date value2) {
            addCriterion("udt not between", value1, value2, "udt");
            return (Criteria) this;
        }
    }

    /**
     */
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