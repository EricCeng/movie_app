package life.drift.movie.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MovieExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table film
     *
     * @mbg.generated Fri Apr 17 00:08:01 GMT+08:00 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table film
     *
     * @mbg.generated Fri Apr 17 00:08:01 GMT+08:00 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table film
     *
     * @mbg.generated Fri Apr 17 00:08:01 GMT+08:00 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table film
     *
     * @mbg.generated Fri Apr 17 00:08:01 GMT+08:00 2020
     */
    public MovieExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table film
     *
     * @mbg.generated Fri Apr 17 00:08:01 GMT+08:00 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table film
     *
     * @mbg.generated Fri Apr 17 00:08:01 GMT+08:00 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table film
     *
     * @mbg.generated Fri Apr 17 00:08:01 GMT+08:00 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table film
     *
     * @mbg.generated Fri Apr 17 00:08:01 GMT+08:00 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table film
     *
     * @mbg.generated Fri Apr 17 00:08:01 GMT+08:00 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table film
     *
     * @mbg.generated Fri Apr 17 00:08:01 GMT+08:00 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table film
     *
     * @mbg.generated Fri Apr 17 00:08:01 GMT+08:00 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table film
     *
     * @mbg.generated Fri Apr 17 00:08:01 GMT+08:00 2020
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table film
     *
     * @mbg.generated Fri Apr 17 00:08:01 GMT+08:00 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table film
     *
     * @mbg.generated Fri Apr 17 00:08:01 GMT+08:00 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table film
     *
     * @mbg.generated Fri Apr 17 00:08:01 GMT+08:00 2020
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
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
            List<java.sql.Date> dateList = new ArrayList<>();
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMovieNameIsNull() {
            addCriterion("movie_name is null");
            return (Criteria) this;
        }

        public Criteria andMovieNameIsNotNull() {
            addCriterion("movie_name is not null");
            return (Criteria) this;
        }

        public Criteria andMovieNameEqualTo(String value) {
            addCriterion("movie_name =", value, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameNotEqualTo(String value) {
            addCriterion("movie_name <>", value, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameGreaterThan(String value) {
            addCriterion("movie_name >", value, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameGreaterThanOrEqualTo(String value) {
            addCriterion("movie_name >=", value, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameLessThan(String value) {
            addCriterion("movie_name <", value, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameLessThanOrEqualTo(String value) {
            addCriterion("movie_name <=", value, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameLike(String value) {
            addCriterion("movie_name like", value, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameNotLike(String value) {
            addCriterion("movie_name not like", value, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameIn(List<String> values) {
            addCriterion("movie_name in", values, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameNotIn(List<String> values) {
            addCriterion("movie_name not in", values, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameBetween(String value1, String value2) {
            addCriterion("movie_name between", value1, value2, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameNotBetween(String value1, String value2) {
            addCriterion("movie_name not between", value1, value2, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieAvatarIsNull() {
            addCriterion("movie_avatar is null");
            return (Criteria) this;
        }

        public Criteria andMovieAvatarIsNotNull() {
            addCriterion("movie_avatar is not null");
            return (Criteria) this;
        }

        public Criteria andMovieAvatarEqualTo(String value) {
            addCriterion("movie_avatar =", value, "movieAvatar");
            return (Criteria) this;
        }

        public Criteria andMovieAvatarNotEqualTo(String value) {
            addCriterion("movie_avatar <>", value, "movieAvatar");
            return (Criteria) this;
        }

        public Criteria andMovieAvatarGreaterThan(String value) {
            addCriterion("movie_avatar >", value, "movieAvatar");
            return (Criteria) this;
        }

        public Criteria andMovieAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("movie_avatar >=", value, "movieAvatar");
            return (Criteria) this;
        }

        public Criteria andMovieAvatarLessThan(String value) {
            addCriterion("movie_avatar <", value, "movieAvatar");
            return (Criteria) this;
        }

        public Criteria andMovieAvatarLessThanOrEqualTo(String value) {
            addCriterion("movie_avatar <=", value, "movieAvatar");
            return (Criteria) this;
        }

        public Criteria andMovieAvatarLike(String value) {
            addCriterion("movie_avatar like", value, "movieAvatar");
            return (Criteria) this;
        }

        public Criteria andMovieAvatarNotLike(String value) {
            addCriterion("movie_avatar not like", value, "movieAvatar");
            return (Criteria) this;
        }

        public Criteria andMovieAvatarIn(List<String> values) {
            addCriterion("movie_avatar in", values, "movieAvatar");
            return (Criteria) this;
        }

        public Criteria andMovieAvatarNotIn(List<String> values) {
            addCriterion("movie_avatar not in", values, "movieAvatar");
            return (Criteria) this;
        }

        public Criteria andMovieAvatarBetween(String value1, String value2) {
            addCriterion("movie_avatar between", value1, value2, "movieAvatar");
            return (Criteria) this;
        }

        public Criteria andMovieAvatarNotBetween(String value1, String value2) {
            addCriterion("movie_avatar not between", value1, value2, "movieAvatar");
            return (Criteria) this;
        }

        public Criteria andDirectorIsNull() {
            addCriterion("director is null");
            return (Criteria) this;
        }

        public Criteria andDirectorIsNotNull() {
            addCriterion("director is not null");
            return (Criteria) this;
        }

        public Criteria andDirectorEqualTo(String value) {
            addCriterion("director =", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorNotEqualTo(String value) {
            addCriterion("director <>", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorGreaterThan(String value) {
            addCriterion("director >", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorGreaterThanOrEqualTo(String value) {
            addCriterion("director >=", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorLessThan(String value) {
            addCriterion("director <", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorLessThanOrEqualTo(String value) {
            addCriterion("director <=", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorLike(String value) {
            addCriterion("director like", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorNotLike(String value) {
            addCriterion("director not like", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorIn(List<String> values) {
            addCriterion("director in", values, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorNotIn(List<String> values) {
            addCriterion("director not in", values, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorBetween(String value1, String value2) {
            addCriterion("director between", value1, value2, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorNotBetween(String value1, String value2) {
            addCriterion("director not between", value1, value2, "director");
            return (Criteria) this;
        }

        public Criteria andActorIsNull() {
            addCriterion("actor is null");
            return (Criteria) this;
        }

        public Criteria andActorIsNotNull() {
            addCriterion("actor is not null");
            return (Criteria) this;
        }

        public Criteria andActorEqualTo(String value) {
            addCriterion("actor =", value, "actor");
            return (Criteria) this;
        }

        public Criteria andActorNotEqualTo(String value) {
            addCriterion("actor <>", value, "actor");
            return (Criteria) this;
        }

        public Criteria andActorGreaterThan(String value) {
            addCriterion("actor >", value, "actor");
            return (Criteria) this;
        }

        public Criteria andActorGreaterThanOrEqualTo(String value) {
            addCriterion("actor >=", value, "actor");
            return (Criteria) this;
        }

        public Criteria andActorLessThan(String value) {
            addCriterion("actor <", value, "actor");
            return (Criteria) this;
        }

        public Criteria andActorLessThanOrEqualTo(String value) {
            addCriterion("actor <=", value, "actor");
            return (Criteria) this;
        }

        public Criteria andActorLike(String value) {
            addCriterion("actor like", value, "actor");
            return (Criteria) this;
        }

        public Criteria andActorNotLike(String value) {
            addCriterion("actor not like", value, "actor");
            return (Criteria) this;
        }

        public Criteria andActorIn(List<String> values) {
            addCriterion("actor in", values, "actor");
            return (Criteria) this;
        }

        public Criteria andActorNotIn(List<String> values) {
            addCriterion("actor not in", values, "actor");
            return (Criteria) this;
        }

        public Criteria andActorBetween(String value1, String value2) {
            addCriterion("actor between", value1, value2, "actor");
            return (Criteria) this;
        }

        public Criteria andActorNotBetween(String value1, String value2) {
            addCriterion("actor not between", value1, value2, "actor");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull() {
            addCriterion("country is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("country is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("country =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value) {
            addCriterion("country <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value) {
            addCriterion("country >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value) {
            addCriterion("country >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value) {
            addCriterion("country <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value) {
            addCriterion("country <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value) {
            addCriterion("country like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value) {
            addCriterion("country not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values) {
            addCriterion("country in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values) {
            addCriterion("country not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2) {
            addCriterion("country between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2) {
            addCriterion("country not between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Double value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Double value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Double value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Double value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Double value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Double> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Double> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Double value1, Double value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Double value1, Double value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andShowTimeIsNull() {
            addCriterion("show_time is null");
            return (Criteria) this;
        }

        public Criteria andShowTimeIsNotNull() {
            addCriterion("show_time is not null");
            return (Criteria) this;
        }

        public Criteria andShowTimeEqualTo(Date value) {
            addCriterionForJDBCDate("show_time =", value, "showTime");
            return (Criteria) this;
        }

        public Criteria andShowTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("show_time <>", value, "showTime");
            return (Criteria) this;
        }

        public Criteria andShowTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("show_time >", value, "showTime");
            return (Criteria) this;
        }

        public Criteria andShowTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("show_time >=", value, "showTime");
            return (Criteria) this;
        }

        public Criteria andShowTimeLessThan(Date value) {
            addCriterionForJDBCDate("show_time <", value, "showTime");
            return (Criteria) this;
        }

        public Criteria andShowTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("show_time <=", value, "showTime");
            return (Criteria) this;
        }

        public Criteria andShowTimeIn(List<Date> values) {
            addCriterionForJDBCDate("show_time in", values, "showTime");
            return (Criteria) this;
        }

        public Criteria andShowTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("show_time not in", values, "showTime");
            return (Criteria) this;
        }

        public Criteria andShowTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("show_time between", value1, value2, "showTime");
            return (Criteria) this;
        }

        public Criteria andShowTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("show_time not between", value1, value2, "showTime");
            return (Criteria) this;
        }

        public Criteria andMovieTimeIsNull() {
            addCriterion("movie_time is null");
            return (Criteria) this;
        }

        public Criteria andMovieTimeIsNotNull() {
            addCriterion("movie_time is not null");
            return (Criteria) this;
        }

        public Criteria andMovieTimeEqualTo(Long value) {
            addCriterion("movie_time =", value, "movieTime");
            return (Criteria) this;
        }

        public Criteria andMovieTimeNotEqualTo(Long value) {
            addCriterion("movie_time <>", value, "movieTime");
            return (Criteria) this;
        }

        public Criteria andMovieTimeGreaterThan(Long value) {
            addCriterion("movie_time >", value, "movieTime");
            return (Criteria) this;
        }

        public Criteria andMovieTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("movie_time >=", value, "movieTime");
            return (Criteria) this;
        }

        public Criteria andMovieTimeLessThan(Long value) {
            addCriterion("movie_time <", value, "movieTime");
            return (Criteria) this;
        }

        public Criteria andMovieTimeLessThanOrEqualTo(Long value) {
            addCriterion("movie_time <=", value, "movieTime");
            return (Criteria) this;
        }

        public Criteria andMovieTimeIn(List<Long> values) {
            addCriterion("movie_time in", values, "movieTime");
            return (Criteria) this;
        }

        public Criteria andMovieTimeNotIn(List<Long> values) {
            addCriterion("movie_time not in", values, "movieTime");
            return (Criteria) this;
        }

        public Criteria andMovieTimeBetween(Long value1, Long value2) {
            addCriterion("movie_time between", value1, value2, "movieTime");
            return (Criteria) this;
        }

        public Criteria andMovieTimeNotBetween(Long value1, Long value2) {
            addCriterion("movie_time not between", value1, value2, "movieTime");
            return (Criteria) this;
        }

        public Criteria andCommentCountIsNull() {
            addCriterion("comment_count is null");
            return (Criteria) this;
        }

        public Criteria andCommentCountIsNotNull() {
            addCriterion("comment_count is not null");
            return (Criteria) this;
        }

        public Criteria andCommentCountEqualTo(Long value) {
            addCriterion("comment_count =", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotEqualTo(Long value) {
            addCriterion("comment_count <>", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountGreaterThan(Long value) {
            addCriterion("comment_count >", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountGreaterThanOrEqualTo(Long value) {
            addCriterion("comment_count >=", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountLessThan(Long value) {
            addCriterion("comment_count <", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountLessThanOrEqualTo(Long value) {
            addCriterion("comment_count <=", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountIn(List<Long> values) {
            addCriterion("comment_count in", values, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotIn(List<Long> values) {
            addCriterion("comment_count not in", values, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountBetween(Long value1, Long value2) {
            addCriterion("comment_count between", value1, value2, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotBetween(Long value1, Long value2) {
            addCriterion("comment_count not between", value1, value2, "commentCount");
            return (Criteria) this;
        }

        public Criteria andMovieCreateIsNull() {
            addCriterion("movie_create is null");
            return (Criteria) this;
        }

        public Criteria andMovieCreateIsNotNull() {
            addCriterion("movie_create is not null");
            return (Criteria) this;
        }

        public Criteria andMovieCreateEqualTo(Date value) {
            addCriterion("movie_create =", value, "movieCreate");
            return (Criteria) this;
        }

        public Criteria andMovieCreateNotEqualTo(Date value) {
            addCriterion("movie_create <>", value, "movieCreate");
            return (Criteria) this;
        }

        public Criteria andMovieCreateGreaterThan(Date value) {
            addCriterion("movie_create >", value, "movieCreate");
            return (Criteria) this;
        }

        public Criteria andMovieCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("movie_create >=", value, "movieCreate");
            return (Criteria) this;
        }

        public Criteria andMovieCreateLessThan(Date value) {
            addCriterion("movie_create <", value, "movieCreate");
            return (Criteria) this;
        }

        public Criteria andMovieCreateLessThanOrEqualTo(Date value) {
            addCriterion("movie_create <=", value, "movieCreate");
            return (Criteria) this;
        }

        public Criteria andMovieCreateIn(List<Date> values) {
            addCriterion("movie_create in", values, "movieCreate");
            return (Criteria) this;
        }

        public Criteria andMovieCreateNotIn(List<Date> values) {
            addCriterion("movie_create not in", values, "movieCreate");
            return (Criteria) this;
        }

        public Criteria andMovieCreateBetween(Date value1, Date value2) {
            addCriterion("movie_create between", value1, value2, "movieCreate");
            return (Criteria) this;
        }

        public Criteria andMovieCreateNotBetween(Date value1, Date value2) {
            addCriterion("movie_create not between", value1, value2, "movieCreate");
            return (Criteria) this;
        }

        public Criteria andMovieModifiedIsNull() {
            addCriterion("movie_modified is null");
            return (Criteria) this;
        }

        public Criteria andMovieModifiedIsNotNull() {
            addCriterion("movie_modified is not null");
            return (Criteria) this;
        }

        public Criteria andMovieModifiedEqualTo(Date value) {
            addCriterion("movie_modified =", value, "movieModified");
            return (Criteria) this;
        }

        public Criteria andMovieModifiedNotEqualTo(Date value) {
            addCriterion("movie_modified <>", value, "movieModified");
            return (Criteria) this;
        }

        public Criteria andMovieModifiedGreaterThan(Date value) {
            addCriterion("movie_modified >", value, "movieModified");
            return (Criteria) this;
        }

        public Criteria andMovieModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("movie_modified >=", value, "movieModified");
            return (Criteria) this;
        }

        public Criteria andMovieModifiedLessThan(Date value) {
            addCriterion("movie_modified <", value, "movieModified");
            return (Criteria) this;
        }

        public Criteria andMovieModifiedLessThanOrEqualTo(Date value) {
            addCriterion("movie_modified <=", value, "movieModified");
            return (Criteria) this;
        }

        public Criteria andMovieModifiedIn(List<Date> values) {
            addCriterion("movie_modified in", values, "movieModified");
            return (Criteria) this;
        }

        public Criteria andMovieModifiedNotIn(List<Date> values) {
            addCriterion("movie_modified not in", values, "movieModified");
            return (Criteria) this;
        }

        public Criteria andMovieModifiedBetween(Date value1, Date value2) {
            addCriterion("movie_modified between", value1, value2, "movieModified");
            return (Criteria) this;
        }

        public Criteria andMovieModifiedNotBetween(Date value1, Date value2) {
            addCriterion("movie_modified not between", value1, value2, "movieModified");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table film
     *
     * @mbg.generated do_not_delete_during_merge Fri Apr 17 00:08:01 GMT+08:00 2020
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table film
     *
     * @mbg.generated Fri Apr 17 00:08:01 GMT+08:00 2020
     */
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