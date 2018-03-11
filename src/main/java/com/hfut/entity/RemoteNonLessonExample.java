package com.hfut.entity;

import java.util.ArrayList;
import java.util.List;

public class RemoteNonLessonExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public RemoteNonLessonExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
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

        public Criteria andTeacherIsNull() {
            addCriterion("teacher is null");
            return (Criteria) this;
        }

        public Criteria andTeacherIsNotNull() {
            addCriterion("teacher is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherEqualTo(String value) {
            addCriterion("teacher =", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherNotEqualTo(String value) {
            addCriterion("teacher <>", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherGreaterThan(String value) {
            addCriterion("teacher >", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherGreaterThanOrEqualTo(String value) {
            addCriterion("teacher >=", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherLessThan(String value) {
            addCriterion("teacher <", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherLessThanOrEqualTo(String value) {
            addCriterion("teacher <=", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherLike(String value) {
            addCriterion("teacher like", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherNotLike(String value) {
            addCriterion("teacher not like", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherIn(List<String> values) {
            addCriterion("teacher in", values, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherNotIn(List<String> values) {
            addCriterion("teacher not in", values, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherBetween(String value1, String value2) {
            addCriterion("teacher between", value1, value2, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherNotBetween(String value1, String value2) {
            addCriterion("teacher not between", value1, value2, "teacher");
            return (Criteria) this;
        }

        public Criteria andYearsIsNull() {
            addCriterion("years is null");
            return (Criteria) this;
        }

        public Criteria andYearsIsNotNull() {
            addCriterion("years is not null");
            return (Criteria) this;
        }

        public Criteria andYearsEqualTo(Integer value) {
            addCriterion("years =", value, "years");
            return (Criteria) this;
        }

        public Criteria andYearsNotEqualTo(Integer value) {
            addCriterion("years <>", value, "years");
            return (Criteria) this;
        }

        public Criteria andYearsGreaterThan(Integer value) {
            addCriterion("years >", value, "years");
            return (Criteria) this;
        }

        public Criteria andYearsGreaterThanOrEqualTo(Integer value) {
            addCriterion("years >=", value, "years");
            return (Criteria) this;
        }

        public Criteria andYearsLessThan(Integer value) {
            addCriterion("years <", value, "years");
            return (Criteria) this;
        }

        public Criteria andYearsLessThanOrEqualTo(Integer value) {
            addCriterion("years <=", value, "years");
            return (Criteria) this;
        }

        public Criteria andYearsIn(List<Integer> values) {
            addCriterion("years in", values, "years");
            return (Criteria) this;
        }

        public Criteria andYearsNotIn(List<Integer> values) {
            addCriterion("years not in", values, "years");
            return (Criteria) this;
        }

        public Criteria andYearsBetween(Integer value1, Integer value2) {
            addCriterion("years between", value1, value2, "years");
            return (Criteria) this;
        }

        public Criteria andYearsNotBetween(Integer value1, Integer value2) {
            addCriterion("years not between", value1, value2, "years");
            return (Criteria) this;
        }

        public Criteria andColleageIsNull() {
            addCriterion("colleage is null");
            return (Criteria) this;
        }

        public Criteria andColleageIsNotNull() {
            addCriterion("colleage is not null");
            return (Criteria) this;
        }

        public Criteria andColleageEqualTo(String value) {
            addCriterion("colleage =", value, "colleage");
            return (Criteria) this;
        }

        public Criteria andColleageNotEqualTo(String value) {
            addCriterion("colleage <>", value, "colleage");
            return (Criteria) this;
        }

        public Criteria andColleageGreaterThan(String value) {
            addCriterion("colleage >", value, "colleage");
            return (Criteria) this;
        }

        public Criteria andColleageGreaterThanOrEqualTo(String value) {
            addCriterion("colleage >=", value, "colleage");
            return (Criteria) this;
        }

        public Criteria andColleageLessThan(String value) {
            addCriterion("colleage <", value, "colleage");
            return (Criteria) this;
        }

        public Criteria andColleageLessThanOrEqualTo(String value) {
            addCriterion("colleage <=", value, "colleage");
            return (Criteria) this;
        }

        public Criteria andColleageLike(String value) {
            addCriterion("colleage like", value, "colleage");
            return (Criteria) this;
        }

        public Criteria andColleageNotLike(String value) {
            addCriterion("colleage not like", value, "colleage");
            return (Criteria) this;
        }

        public Criteria andColleageIn(List<String> values) {
            addCriterion("colleage in", values, "colleage");
            return (Criteria) this;
        }

        public Criteria andColleageNotIn(List<String> values) {
            addCriterion("colleage not in", values, "colleage");
            return (Criteria) this;
        }

        public Criteria andColleageBetween(String value1, String value2) {
            addCriterion("colleage between", value1, value2, "colleage");
            return (Criteria) this;
        }

        public Criteria andColleageNotBetween(String value1, String value2) {
            addCriterion("colleage not between", value1, value2, "colleage");
            return (Criteria) this;
        }

        public Criteria andDaysIsNull() {
            addCriterion("days is null");
            return (Criteria) this;
        }

        public Criteria andDaysIsNotNull() {
            addCriterion("days is not null");
            return (Criteria) this;
        }

        public Criteria andDaysEqualTo(Integer value) {
            addCriterion("days =", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotEqualTo(Integer value) {
            addCriterion("days <>", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysGreaterThan(Integer value) {
            addCriterion("days >", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("days >=", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLessThan(Integer value) {
            addCriterion("days <", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLessThanOrEqualTo(Integer value) {
            addCriterion("days <=", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysIn(List<Integer> values) {
            addCriterion("days in", values, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotIn(List<Integer> values) {
            addCriterion("days not in", values, "days");
            return (Criteria) this;
        }

        public Criteria andDaysBetween(Integer value1, Integer value2) {
            addCriterion("days between", value1, value2, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("days not between", value1, value2, "days");
            return (Criteria) this;
        }

        public Criteria andWeeksIsNull() {
            addCriterion("weeks is null");
            return (Criteria) this;
        }

        public Criteria andWeeksIsNotNull() {
            addCriterion("weeks is not null");
            return (Criteria) this;
        }

        public Criteria andWeeksEqualTo(Integer value) {
            addCriterion("weeks =", value, "weeks");
            return (Criteria) this;
        }

        public Criteria andWeeksNotEqualTo(Integer value) {
            addCriterion("weeks <>", value, "weeks");
            return (Criteria) this;
        }

        public Criteria andWeeksGreaterThan(Integer value) {
            addCriterion("weeks >", value, "weeks");
            return (Criteria) this;
        }

        public Criteria andWeeksGreaterThanOrEqualTo(Integer value) {
            addCriterion("weeks >=", value, "weeks");
            return (Criteria) this;
        }

        public Criteria andWeeksLessThan(Integer value) {
            addCriterion("weeks <", value, "weeks");
            return (Criteria) this;
        }

        public Criteria andWeeksLessThanOrEqualTo(Integer value) {
            addCriterion("weeks <=", value, "weeks");
            return (Criteria) this;
        }

        public Criteria andWeeksIn(List<Integer> values) {
            addCriterion("weeks in", values, "weeks");
            return (Criteria) this;
        }

        public Criteria andWeeksNotIn(List<Integer> values) {
            addCriterion("weeks not in", values, "weeks");
            return (Criteria) this;
        }

        public Criteria andWeeksBetween(Integer value1, Integer value2) {
            addCriterion("weeks between", value1, value2, "weeks");
            return (Criteria) this;
        }

        public Criteria andWeeksNotBetween(Integer value1, Integer value2) {
            addCriterion("weeks not between", value1, value2, "weeks");
            return (Criteria) this;
        }

        public Criteria andAlldaysIsNull() {
            addCriterion("alldays is null");
            return (Criteria) this;
        }

        public Criteria andAlldaysIsNotNull() {
            addCriterion("alldays is not null");
            return (Criteria) this;
        }

        public Criteria andAlldaysEqualTo(Integer value) {
            addCriterion("alldays =", value, "alldays");
            return (Criteria) this;
        }

        public Criteria andAlldaysNotEqualTo(Integer value) {
            addCriterion("alldays <>", value, "alldays");
            return (Criteria) this;
        }

        public Criteria andAlldaysGreaterThan(Integer value) {
            addCriterion("alldays >", value, "alldays");
            return (Criteria) this;
        }

        public Criteria andAlldaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("alldays >=", value, "alldays");
            return (Criteria) this;
        }

        public Criteria andAlldaysLessThan(Integer value) {
            addCriterion("alldays <", value, "alldays");
            return (Criteria) this;
        }

        public Criteria andAlldaysLessThanOrEqualTo(Integer value) {
            addCriterion("alldays <=", value, "alldays");
            return (Criteria) this;
        }

        public Criteria andAlldaysIn(List<Integer> values) {
            addCriterion("alldays in", values, "alldays");
            return (Criteria) this;
        }

        public Criteria andAlldaysNotIn(List<Integer> values) {
            addCriterion("alldays not in", values, "alldays");
            return (Criteria) this;
        }

        public Criteria andAlldaysBetween(Integer value1, Integer value2) {
            addCriterion("alldays between", value1, value2, "alldays");
            return (Criteria) this;
        }

        public Criteria andAlldaysNotBetween(Integer value1, Integer value2) {
            addCriterion("alldays not between", value1, value2, "alldays");
            return (Criteria) this;
        }

        public Criteria andAllownceIsNull() {
            addCriterion("allownce is null");
            return (Criteria) this;
        }

        public Criteria andAllownceIsNotNull() {
            addCriterion("allownce is not null");
            return (Criteria) this;
        }

        public Criteria andAllownceEqualTo(Float value) {
            addCriterion("allownce =", value, "allownce");
            return (Criteria) this;
        }

        public Criteria andAllownceNotEqualTo(Float value) {
            addCriterion("allownce <>", value, "allownce");
            return (Criteria) this;
        }

        public Criteria andAllownceGreaterThan(Float value) {
            addCriterion("allownce >", value, "allownce");
            return (Criteria) this;
        }

        public Criteria andAllownceGreaterThanOrEqualTo(Float value) {
            addCriterion("allownce >=", value, "allownce");
            return (Criteria) this;
        }

        public Criteria andAllownceLessThan(Float value) {
            addCriterion("allownce <", value, "allownce");
            return (Criteria) this;
        }

        public Criteria andAllownceLessThanOrEqualTo(Float value) {
            addCriterion("allownce <=", value, "allownce");
            return (Criteria) this;
        }

        public Criteria andAllownceIn(List<Float> values) {
            addCriterion("allownce in", values, "allownce");
            return (Criteria) this;
        }

        public Criteria andAllownceNotIn(List<Float> values) {
            addCriterion("allownce not in", values, "allownce");
            return (Criteria) this;
        }

        public Criteria andAllownceBetween(Float value1, Float value2) {
            addCriterion("allownce between", value1, value2, "allownce");
            return (Criteria) this;
        }

        public Criteria andAllownceNotBetween(Float value1, Float value2) {
            addCriterion("allownce not between", value1, value2, "allownce");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
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