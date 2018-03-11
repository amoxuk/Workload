package com.hfut.entity;

import java.util.ArrayList;
import java.util.List;

public class LocalTotalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public LocalTotalExample() {
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

        public Criteria andTotalIsNull() {
            addCriterion("total is null");
            return (Criteria) this;
        }

        public Criteria andTotalIsNotNull() {
            addCriterion("total is not null");
            return (Criteria) this;
        }

        public Criteria andTotalEqualTo(Float value) {
            addCriterion("total =", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotEqualTo(Float value) {
            addCriterion("total <>", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThan(Float value) {
            addCriterion("total >", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThanOrEqualTo(Float value) {
            addCriterion("total >=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThan(Float value) {
            addCriterion("total <", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThanOrEqualTo(Float value) {
            addCriterion("total <=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalIn(List<Float> values) {
            addCriterion("total in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotIn(List<Float> values) {
            addCriterion("total not in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalBetween(Float value1, Float value2) {
            addCriterion("total between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotBetween(Float value1, Float value2) {
            addCriterion("total not between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andCourseIsNull() {
            addCriterion("course is null");
            return (Criteria) this;
        }

        public Criteria andCourseIsNotNull() {
            addCriterion("course is not null");
            return (Criteria) this;
        }

        public Criteria andCourseEqualTo(Float value) {
            addCriterion("course =", value, "course");
            return (Criteria) this;
        }

        public Criteria andCourseNotEqualTo(Float value) {
            addCriterion("course <>", value, "course");
            return (Criteria) this;
        }

        public Criteria andCourseGreaterThan(Float value) {
            addCriterion("course >", value, "course");
            return (Criteria) this;
        }

        public Criteria andCourseGreaterThanOrEqualTo(Float value) {
            addCriterion("course >=", value, "course");
            return (Criteria) this;
        }

        public Criteria andCourseLessThan(Float value) {
            addCriterion("course <", value, "course");
            return (Criteria) this;
        }

        public Criteria andCourseLessThanOrEqualTo(Float value) {
            addCriterion("course <=", value, "course");
            return (Criteria) this;
        }

        public Criteria andCourseIn(List<Float> values) {
            addCriterion("course in", values, "course");
            return (Criteria) this;
        }

        public Criteria andCourseNotIn(List<Float> values) {
            addCriterion("course not in", values, "course");
            return (Criteria) this;
        }

        public Criteria andCourseBetween(Float value1, Float value2) {
            addCriterion("course between", value1, value2, "course");
            return (Criteria) this;
        }

        public Criteria andCourseNotBetween(Float value1, Float value2) {
            addCriterion("course not between", value1, value2, "course");
            return (Criteria) this;
        }

        public Criteria andExprimentIsNull() {
            addCriterion("expriment is null");
            return (Criteria) this;
        }

        public Criteria andExprimentIsNotNull() {
            addCriterion("expriment is not null");
            return (Criteria) this;
        }

        public Criteria andExprimentEqualTo(Float value) {
            addCriterion("expriment =", value, "expriment");
            return (Criteria) this;
        }

        public Criteria andExprimentNotEqualTo(Float value) {
            addCriterion("expriment <>", value, "expriment");
            return (Criteria) this;
        }

        public Criteria andExprimentGreaterThan(Float value) {
            addCriterion("expriment >", value, "expriment");
            return (Criteria) this;
        }

        public Criteria andExprimentGreaterThanOrEqualTo(Float value) {
            addCriterion("expriment >=", value, "expriment");
            return (Criteria) this;
        }

        public Criteria andExprimentLessThan(Float value) {
            addCriterion("expriment <", value, "expriment");
            return (Criteria) this;
        }

        public Criteria andExprimentLessThanOrEqualTo(Float value) {
            addCriterion("expriment <=", value, "expriment");
            return (Criteria) this;
        }

        public Criteria andExprimentIn(List<Float> values) {
            addCriterion("expriment in", values, "expriment");
            return (Criteria) this;
        }

        public Criteria andExprimentNotIn(List<Float> values) {
            addCriterion("expriment not in", values, "expriment");
            return (Criteria) this;
        }

        public Criteria andExprimentBetween(Float value1, Float value2) {
            addCriterion("expriment between", value1, value2, "expriment");
            return (Criteria) this;
        }

        public Criteria andExprimentNotBetween(Float value1, Float value2) {
            addCriterion("expriment not between", value1, value2, "expriment");
            return (Criteria) this;
        }

        public Criteria andProjectIsNull() {
            addCriterion("project is null");
            return (Criteria) this;
        }

        public Criteria andProjectIsNotNull() {
            addCriterion("project is not null");
            return (Criteria) this;
        }

        public Criteria andProjectEqualTo(Float value) {
            addCriterion("project =", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotEqualTo(Float value) {
            addCriterion("project <>", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectGreaterThan(Float value) {
            addCriterion("project >", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectGreaterThanOrEqualTo(Float value) {
            addCriterion("project >=", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectLessThan(Float value) {
            addCriterion("project <", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectLessThanOrEqualTo(Float value) {
            addCriterion("project <=", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectIn(List<Float> values) {
            addCriterion("project in", values, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotIn(List<Float> values) {
            addCriterion("project not in", values, "project");
            return (Criteria) this;
        }

        public Criteria andProjectBetween(Float value1, Float value2) {
            addCriterion("project between", value1, value2, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotBetween(Float value1, Float value2) {
            addCriterion("project not between", value1, value2, "project");
            return (Criteria) this;
        }

        public Criteria andMatchsIsNull() {
            addCriterion("matchs is null");
            return (Criteria) this;
        }

        public Criteria andMatchsIsNotNull() {
            addCriterion("matchs is not null");
            return (Criteria) this;
        }

        public Criteria andMatchsEqualTo(Float value) {
            addCriterion("matchs =", value, "matchs");
            return (Criteria) this;
        }

        public Criteria andMatchsNotEqualTo(Float value) {
            addCriterion("matchs <>", value, "matchs");
            return (Criteria) this;
        }

        public Criteria andMatchsGreaterThan(Float value) {
            addCriterion("matchs >", value, "matchs");
            return (Criteria) this;
        }

        public Criteria andMatchsGreaterThanOrEqualTo(Float value) {
            addCriterion("matchs >=", value, "matchs");
            return (Criteria) this;
        }

        public Criteria andMatchsLessThan(Float value) {
            addCriterion("matchs <", value, "matchs");
            return (Criteria) this;
        }

        public Criteria andMatchsLessThanOrEqualTo(Float value) {
            addCriterion("matchs <=", value, "matchs");
            return (Criteria) this;
        }

        public Criteria andMatchsIn(List<Float> values) {
            addCriterion("matchs in", values, "matchs");
            return (Criteria) this;
        }

        public Criteria andMatchsNotIn(List<Float> values) {
            addCriterion("matchs not in", values, "matchs");
            return (Criteria) this;
        }

        public Criteria andMatchsBetween(Float value1, Float value2) {
            addCriterion("matchs between", value1, value2, "matchs");
            return (Criteria) this;
        }

        public Criteria andMatchsNotBetween(Float value1, Float value2) {
            addCriterion("matchs not between", value1, value2, "matchs");
            return (Criteria) this;
        }

        public Criteria andCourseDesignIsNull() {
            addCriterion("course_design is null");
            return (Criteria) this;
        }

        public Criteria andCourseDesignIsNotNull() {
            addCriterion("course_design is not null");
            return (Criteria) this;
        }

        public Criteria andCourseDesignEqualTo(Float value) {
            addCriterion("course_design =", value, "courseDesign");
            return (Criteria) this;
        }

        public Criteria andCourseDesignNotEqualTo(Float value) {
            addCriterion("course_design <>", value, "courseDesign");
            return (Criteria) this;
        }

        public Criteria andCourseDesignGreaterThan(Float value) {
            addCriterion("course_design >", value, "courseDesign");
            return (Criteria) this;
        }

        public Criteria andCourseDesignGreaterThanOrEqualTo(Float value) {
            addCriterion("course_design >=", value, "courseDesign");
            return (Criteria) this;
        }

        public Criteria andCourseDesignLessThan(Float value) {
            addCriterion("course_design <", value, "courseDesign");
            return (Criteria) this;
        }

        public Criteria andCourseDesignLessThanOrEqualTo(Float value) {
            addCriterion("course_design <=", value, "courseDesign");
            return (Criteria) this;
        }

        public Criteria andCourseDesignIn(List<Float> values) {
            addCriterion("course_design in", values, "courseDesign");
            return (Criteria) this;
        }

        public Criteria andCourseDesignNotIn(List<Float> values) {
            addCriterion("course_design not in", values, "courseDesign");
            return (Criteria) this;
        }

        public Criteria andCourseDesignBetween(Float value1, Float value2) {
            addCriterion("course_design between", value1, value2, "courseDesign");
            return (Criteria) this;
        }

        public Criteria andCourseDesignNotBetween(Float value1, Float value2) {
            addCriterion("course_design not between", value1, value2, "courseDesign");
            return (Criteria) this;
        }

        public Criteria andPracticeIsNull() {
            addCriterion("practice is null");
            return (Criteria) this;
        }

        public Criteria andPracticeIsNotNull() {
            addCriterion("practice is not null");
            return (Criteria) this;
        }

        public Criteria andPracticeEqualTo(Float value) {
            addCriterion("practice =", value, "practice");
            return (Criteria) this;
        }

        public Criteria andPracticeNotEqualTo(Float value) {
            addCriterion("practice <>", value, "practice");
            return (Criteria) this;
        }

        public Criteria andPracticeGreaterThan(Float value) {
            addCriterion("practice >", value, "practice");
            return (Criteria) this;
        }

        public Criteria andPracticeGreaterThanOrEqualTo(Float value) {
            addCriterion("practice >=", value, "practice");
            return (Criteria) this;
        }

        public Criteria andPracticeLessThan(Float value) {
            addCriterion("practice <", value, "practice");
            return (Criteria) this;
        }

        public Criteria andPracticeLessThanOrEqualTo(Float value) {
            addCriterion("practice <=", value, "practice");
            return (Criteria) this;
        }

        public Criteria andPracticeIn(List<Float> values) {
            addCriterion("practice in", values, "practice");
            return (Criteria) this;
        }

        public Criteria andPracticeNotIn(List<Float> values) {
            addCriterion("practice not in", values, "practice");
            return (Criteria) this;
        }

        public Criteria andPracticeBetween(Float value1, Float value2) {
            addCriterion("practice between", value1, value2, "practice");
            return (Criteria) this;
        }

        public Criteria andPracticeNotBetween(Float value1, Float value2) {
            addCriterion("practice not between", value1, value2, "practice");
            return (Criteria) this;
        }

        public Criteria andGraduateDesignIsNull() {
            addCriterion("graduate_design is null");
            return (Criteria) this;
        }

        public Criteria andGraduateDesignIsNotNull() {
            addCriterion("graduate_design is not null");
            return (Criteria) this;
        }

        public Criteria andGraduateDesignEqualTo(Float value) {
            addCriterion("graduate_design =", value, "graduateDesign");
            return (Criteria) this;
        }

        public Criteria andGraduateDesignNotEqualTo(Float value) {
            addCriterion("graduate_design <>", value, "graduateDesign");
            return (Criteria) this;
        }

        public Criteria andGraduateDesignGreaterThan(Float value) {
            addCriterion("graduate_design >", value, "graduateDesign");
            return (Criteria) this;
        }

        public Criteria andGraduateDesignGreaterThanOrEqualTo(Float value) {
            addCriterion("graduate_design >=", value, "graduateDesign");
            return (Criteria) this;
        }

        public Criteria andGraduateDesignLessThan(Float value) {
            addCriterion("graduate_design <", value, "graduateDesign");
            return (Criteria) this;
        }

        public Criteria andGraduateDesignLessThanOrEqualTo(Float value) {
            addCriterion("graduate_design <=", value, "graduateDesign");
            return (Criteria) this;
        }

        public Criteria andGraduateDesignIn(List<Float> values) {
            addCriterion("graduate_design in", values, "graduateDesign");
            return (Criteria) this;
        }

        public Criteria andGraduateDesignNotIn(List<Float> values) {
            addCriterion("graduate_design not in", values, "graduateDesign");
            return (Criteria) this;
        }

        public Criteria andGraduateDesignBetween(Float value1, Float value2) {
            addCriterion("graduate_design between", value1, value2, "graduateDesign");
            return (Criteria) this;
        }

        public Criteria andGraduateDesignNotBetween(Float value1, Float value2) {
            addCriterion("graduate_design not between", value1, value2, "graduateDesign");
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