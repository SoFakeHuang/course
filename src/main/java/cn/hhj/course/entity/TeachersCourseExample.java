package cn.hhj.course.entity;

import java.util.ArrayList;
import java.util.List;

public class TeachersCourseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeachersCourseExample() {
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

        public Criteria andCourse_idIsNull() {
            addCriterion("course_id is null");
            return (Criteria) this;
        }

        public Criteria andCourse_idIsNotNull() {
            addCriterion("course_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourse_idEqualTo(Integer value) {
            addCriterion("course_id =", value, "course_id");
            return (Criteria) this;
        }

        public Criteria andCourse_idNotEqualTo(Integer value) {
            addCriterion("course_id <>", value, "course_id");
            return (Criteria) this;
        }

        public Criteria andCourse_idGreaterThan(Integer value) {
            addCriterion("course_id >", value, "course_id");
            return (Criteria) this;
        }

        public Criteria andCourse_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_id >=", value, "course_id");
            return (Criteria) this;
        }

        public Criteria andCourse_idLessThan(Integer value) {
            addCriterion("course_id <", value, "course_id");
            return (Criteria) this;
        }

        public Criteria andCourse_idLessThanOrEqualTo(Integer value) {
            addCriterion("course_id <=", value, "course_id");
            return (Criteria) this;
        }

        public Criteria andCourse_idIn(List<Integer> values) {
            addCriterion("course_id in", values, "course_id");
            return (Criteria) this;
        }

        public Criteria andCourse_idNotIn(List<Integer> values) {
            addCriterion("course_id not in", values, "course_id");
            return (Criteria) this;
        }

        public Criteria andCourse_idBetween(Integer value1, Integer value2) {
            addCriterion("course_id between", value1, value2, "course_id");
            return (Criteria) this;
        }

        public Criteria andCourse_idNotBetween(Integer value1, Integer value2) {
            addCriterion("course_id not between", value1, value2, "course_id");
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

        public Criteria andYearsEqualTo(String value) {
            addCriterion("years =", value, "years");
            return (Criteria) this;
        }

        public Criteria andYearsNotEqualTo(String value) {
            addCriterion("years <>", value, "years");
            return (Criteria) this;
        }

        public Criteria andYearsGreaterThan(String value) {
            addCriterion("years >", value, "years");
            return (Criteria) this;
        }

        public Criteria andYearsGreaterThanOrEqualTo(String value) {
            addCriterion("years >=", value, "years");
            return (Criteria) this;
        }

        public Criteria andYearsLessThan(String value) {
            addCriterion("years <", value, "years");
            return (Criteria) this;
        }

        public Criteria andYearsLessThanOrEqualTo(String value) {
            addCriterion("years <=", value, "years");
            return (Criteria) this;
        }

        public Criteria andYearsLike(String value) {
            addCriterion("years like", value, "years");
            return (Criteria) this;
        }

        public Criteria andYearsNotLike(String value) {
            addCriterion("years not like", value, "years");
            return (Criteria) this;
        }

        public Criteria andYearsIn(List<String> values) {
            addCriterion("years in", values, "years");
            return (Criteria) this;
        }

        public Criteria andYearsNotIn(List<String> values) {
            addCriterion("years not in", values, "years");
            return (Criteria) this;
        }

        public Criteria andYearsBetween(String value1, String value2) {
            addCriterion("years between", value1, value2, "years");
            return (Criteria) this;
        }

        public Criteria andYearsNotBetween(String value1, String value2) {
            addCriterion("years not between", value1, value2, "years");
            return (Criteria) this;
        }

        public Criteria andSemesterIsNull() {
            addCriterion("semester is null");
            return (Criteria) this;
        }

        public Criteria andSemesterIsNotNull() {
            addCriterion("semester is not null");
            return (Criteria) this;
        }

        public Criteria andSemesterEqualTo(Integer value) {
            addCriterion("semester =", value, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterNotEqualTo(Integer value) {
            addCriterion("semester <>", value, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterGreaterThan(Integer value) {
            addCriterion("semester >", value, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterGreaterThanOrEqualTo(Integer value) {
            addCriterion("semester >=", value, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterLessThan(Integer value) {
            addCriterion("semester <", value, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterLessThanOrEqualTo(Integer value) {
            addCriterion("semester <=", value, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterIn(List<Integer> values) {
            addCriterion("semester in", values, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterNotIn(List<Integer> values) {
            addCriterion("semester not in", values, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterBetween(Integer value1, Integer value2) {
            addCriterion("semester between", value1, value2, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterNotBetween(Integer value1, Integer value2) {
            addCriterion("semester not between", value1, value2, "semester");
            return (Criteria) this;
        }

        public Criteria andClassroomIsNull() {
            addCriterion("classroom is null");
            return (Criteria) this;
        }

        public Criteria andClassroomIsNotNull() {
            addCriterion("classroom is not null");
            return (Criteria) this;
        }

        public Criteria andClassroomEqualTo(String value) {
            addCriterion("classroom =", value, "classroom");
            return (Criteria) this;
        }

        public Criteria andClassroomNotEqualTo(String value) {
            addCriterion("classroom <>", value, "classroom");
            return (Criteria) this;
        }

        public Criteria andClassroomGreaterThan(String value) {
            addCriterion("classroom >", value, "classroom");
            return (Criteria) this;
        }

        public Criteria andClassroomGreaterThanOrEqualTo(String value) {
            addCriterion("classroom >=", value, "classroom");
            return (Criteria) this;
        }

        public Criteria andClassroomLessThan(String value) {
            addCriterion("classroom <", value, "classroom");
            return (Criteria) this;
        }

        public Criteria andClassroomLessThanOrEqualTo(String value) {
            addCriterion("classroom <=", value, "classroom");
            return (Criteria) this;
        }

        public Criteria andClassroomLike(String value) {
            addCriterion("classroom like", value, "classroom");
            return (Criteria) this;
        }

        public Criteria andClassroomNotLike(String value) {
            addCriterion("classroom not like", value, "classroom");
            return (Criteria) this;
        }

        public Criteria andClassroomIn(List<String> values) {
            addCriterion("classroom in", values, "classroom");
            return (Criteria) this;
        }

        public Criteria andClassroomNotIn(List<String> values) {
            addCriterion("classroom not in", values, "classroom");
            return (Criteria) this;
        }

        public Criteria andClassroomBetween(String value1, String value2) {
            addCriterion("classroom between", value1, value2, "classroom");
            return (Criteria) this;
        }

        public Criteria andClassroomNotBetween(String value1, String value2) {
            addCriterion("classroom not between", value1, value2, "classroom");
            return (Criteria) this;
        }

        public Criteria andClass_timeIsNull() {
            addCriterion("class_time is null");
            return (Criteria) this;
        }

        public Criteria andClass_timeIsNotNull() {
            addCriterion("class_time is not null");
            return (Criteria) this;
        }

        public Criteria andClass_timeEqualTo(String value) {
            addCriterion("class_time =", value, "class_time");
            return (Criteria) this;
        }

        public Criteria andClass_timeNotEqualTo(String value) {
            addCriterion("class_time <>", value, "class_time");
            return (Criteria) this;
        }

        public Criteria andClass_timeGreaterThan(String value) {
            addCriterion("class_time >", value, "class_time");
            return (Criteria) this;
        }

        public Criteria andClass_timeGreaterThanOrEqualTo(String value) {
            addCriterion("class_time >=", value, "class_time");
            return (Criteria) this;
        }

        public Criteria andClass_timeLessThan(String value) {
            addCriterion("class_time <", value, "class_time");
            return (Criteria) this;
        }

        public Criteria andClass_timeLessThanOrEqualTo(String value) {
            addCriterion("class_time <=", value, "class_time");
            return (Criteria) this;
        }

        public Criteria andClass_timeLike(String value) {
            addCriterion("class_time like", value, "class_time");
            return (Criteria) this;
        }

        public Criteria andClass_timeNotLike(String value) {
            addCriterion("class_time not like", value, "class_time");
            return (Criteria) this;
        }

        public Criteria andClass_timeIn(List<String> values) {
            addCriterion("class_time in", values, "class_time");
            return (Criteria) this;
        }

        public Criteria andClass_timeNotIn(List<String> values) {
            addCriterion("class_time not in", values, "class_time");
            return (Criteria) this;
        }

        public Criteria andClass_timeBetween(String value1, String value2) {
            addCriterion("class_time between", value1, value2, "class_time");
            return (Criteria) this;
        }

        public Criteria andClass_timeNotBetween(String value1, String value2) {
            addCriterion("class_time not between", value1, value2, "class_time");
            return (Criteria) this;
        }

        public Criteria andStudents_numberIsNull() {
            addCriterion("students_number is null");
            return (Criteria) this;
        }

        public Criteria andStudents_numberIsNotNull() {
            addCriterion("students_number is not null");
            return (Criteria) this;
        }

        public Criteria andStudents_numberEqualTo(Integer value) {
            addCriterion("students_number =", value, "students_number");
            return (Criteria) this;
        }

        public Criteria andStudents_numberNotEqualTo(Integer value) {
            addCriterion("students_number <>", value, "students_number");
            return (Criteria) this;
        }

        public Criteria andStudents_numberGreaterThan(Integer value) {
            addCriterion("students_number >", value, "students_number");
            return (Criteria) this;
        }

        public Criteria andStudents_numberGreaterThanOrEqualTo(Integer value) {
            addCriterion("students_number >=", value, "students_number");
            return (Criteria) this;
        }

        public Criteria andStudents_numberLessThan(Integer value) {
            addCriterion("students_number <", value, "students_number");
            return (Criteria) this;
        }

        public Criteria andStudents_numberLessThanOrEqualTo(Integer value) {
            addCriterion("students_number <=", value, "students_number");
            return (Criteria) this;
        }

        public Criteria andStudents_numberIn(List<Integer> values) {
            addCriterion("students_number in", values, "students_number");
            return (Criteria) this;
        }

        public Criteria andStudents_numberNotIn(List<Integer> values) {
            addCriterion("students_number not in", values, "students_number");
            return (Criteria) this;
        }

        public Criteria andStudents_numberBetween(Integer value1, Integer value2) {
            addCriterion("students_number between", value1, value2, "students_number");
            return (Criteria) this;
        }

        public Criteria andStudents_numberNotBetween(Integer value1, Integer value2) {
            addCriterion("students_number not between", value1, value2, "students_number");
            return (Criteria) this;
        }

        public Criteria andMax_numberIsNull() {
            addCriterion("Max_number is null");
            return (Criteria) this;
        }

        public Criteria andMax_numberIsNotNull() {
            addCriterion("Max_number is not null");
            return (Criteria) this;
        }

        public Criteria andMax_numberEqualTo(Integer value) {
            addCriterion("Max_number =", value, "max_number");
            return (Criteria) this;
        }

        public Criteria andMax_numberNotEqualTo(Integer value) {
            addCriterion("Max_number <>", value, "max_number");
            return (Criteria) this;
        }

        public Criteria andMax_numberGreaterThan(Integer value) {
            addCriterion("Max_number >", value, "max_number");
            return (Criteria) this;
        }

        public Criteria andMax_numberGreaterThanOrEqualTo(Integer value) {
            addCriterion("Max_number >=", value, "max_number");
            return (Criteria) this;
        }

        public Criteria andMax_numberLessThan(Integer value) {
            addCriterion("Max_number <", value, "max_number");
            return (Criteria) this;
        }

        public Criteria andMax_numberLessThanOrEqualTo(Integer value) {
            addCriterion("Max_number <=", value, "max_number");
            return (Criteria) this;
        }

        public Criteria andMax_numberIn(List<Integer> values) {
            addCriterion("Max_number in", values, "max_number");
            return (Criteria) this;
        }

        public Criteria andMax_numberNotIn(List<Integer> values) {
            addCriterion("Max_number not in", values, "max_number");
            return (Criteria) this;
        }

        public Criteria andMax_numberBetween(Integer value1, Integer value2) {
            addCriterion("Max_number between", value1, value2, "max_number");
            return (Criteria) this;
        }

        public Criteria andMax_numberNotBetween(Integer value1, Integer value2) {
            addCriterion("Max_number not between", value1, value2, "max_number");
            return (Criteria) this;
        }

        public Criteria andFullIsNull() {
            addCriterion("full is null");
            return (Criteria) this;
        }

        public Criteria andFullIsNotNull() {
            addCriterion("full is not null");
            return (Criteria) this;
        }

        public Criteria andFullEqualTo(Integer value) {
            addCriterion("full =", value, "full");
            return (Criteria) this;
        }

        public Criteria andFullNotEqualTo(Integer value) {
            addCriterion("full <>", value, "full");
            return (Criteria) this;
        }

        public Criteria andFullGreaterThan(Integer value) {
            addCriterion("full >", value, "full");
            return (Criteria) this;
        }

        public Criteria andFullGreaterThanOrEqualTo(Integer value) {
            addCriterion("full >=", value, "full");
            return (Criteria) this;
        }

        public Criteria andFullLessThan(Integer value) {
            addCriterion("full <", value, "full");
            return (Criteria) this;
        }

        public Criteria andFullLessThanOrEqualTo(Integer value) {
            addCriterion("full <=", value, "full");
            return (Criteria) this;
        }

        public Criteria andFullIn(List<Integer> values) {
            addCriterion("full in", values, "full");
            return (Criteria) this;
        }

        public Criteria andFullNotIn(List<Integer> values) {
            addCriterion("full not in", values, "full");
            return (Criteria) this;
        }

        public Criteria andFullBetween(Integer value1, Integer value2) {
            addCriterion("full between", value1, value2, "full");
            return (Criteria) this;
        }

        public Criteria andFullNotBetween(Integer value1, Integer value2) {
            addCriterion("full not between", value1, value2, "full");
            return (Criteria) this;
        }

        public Criteria andOnlineIsNull() {
            addCriterion("online is null");
            return (Criteria) this;
        }

        public Criteria andOnlineIsNotNull() {
            addCriterion("online is not null");
            return (Criteria) this;
        }

        public Criteria andOnlineEqualTo(Integer value) {
            addCriterion("online =", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineNotEqualTo(Integer value) {
            addCriterion("online <>", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineGreaterThan(Integer value) {
            addCriterion("online >", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineGreaterThanOrEqualTo(Integer value) {
            addCriterion("online >=", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineLessThan(Integer value) {
            addCriterion("online <", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineLessThanOrEqualTo(Integer value) {
            addCriterion("online <=", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineIn(List<Integer> values) {
            addCriterion("online in", values, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineNotIn(List<Integer> values) {
            addCriterion("online not in", values, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineBetween(Integer value1, Integer value2) {
            addCriterion("online between", value1, value2, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineNotBetween(Integer value1, Integer value2) {
            addCriterion("online not between", value1, value2, "online");
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