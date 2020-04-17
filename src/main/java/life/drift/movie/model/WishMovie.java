package life.drift.movie.model;

import java.util.Date;

public class WishMovie {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wish_movie.id
     *
     * @mbg.generated Fri Apr 17 00:08:01 GMT+08:00 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wish_movie.add_time
     *
     * @mbg.generated Fri Apr 17 00:08:01 GMT+08:00 2020
     */
    private Date addTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wish_movie.update_time
     *
     * @mbg.generated Fri Apr 17 00:08:01 GMT+08:00 2020
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wish_movie.is_wanted
     *
     * @mbg.generated Fri Apr 17 00:08:01 GMT+08:00 2020
     */
    private Integer isWanted;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wish_movie.user_id
     *
     * @mbg.generated Fri Apr 17 00:08:01 GMT+08:00 2020
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wish_movie.movie_id
     *
     * @mbg.generated Fri Apr 17 00:08:01 GMT+08:00 2020
     */
    private Long movieId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wish_movie.id
     *
     * @return the value of wish_movie.id
     *
     * @mbg.generated Fri Apr 17 00:08:01 GMT+08:00 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wish_movie.id
     *
     * @param id the value for wish_movie.id
     *
     * @mbg.generated Fri Apr 17 00:08:01 GMT+08:00 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wish_movie.add_time
     *
     * @return the value of wish_movie.add_time
     *
     * @mbg.generated Fri Apr 17 00:08:01 GMT+08:00 2020
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wish_movie.add_time
     *
     * @param addTime the value for wish_movie.add_time
     *
     * @mbg.generated Fri Apr 17 00:08:01 GMT+08:00 2020
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wish_movie.update_time
     *
     * @return the value of wish_movie.update_time
     *
     * @mbg.generated Fri Apr 17 00:08:01 GMT+08:00 2020
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wish_movie.update_time
     *
     * @param updateTime the value for wish_movie.update_time
     *
     * @mbg.generated Fri Apr 17 00:08:01 GMT+08:00 2020
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wish_movie.is_wanted
     *
     * @return the value of wish_movie.is_wanted
     *
     * @mbg.generated Fri Apr 17 00:08:01 GMT+08:00 2020
     */
    public Integer getIsWanted() {
        return isWanted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wish_movie.is_wanted
     *
     * @param isWanted the value for wish_movie.is_wanted
     *
     * @mbg.generated Fri Apr 17 00:08:01 GMT+08:00 2020
     */
    public void setIsWanted(Integer isWanted) {
        this.isWanted = isWanted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wish_movie.user_id
     *
     * @return the value of wish_movie.user_id
     *
     * @mbg.generated Fri Apr 17 00:08:01 GMT+08:00 2020
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wish_movie.user_id
     *
     * @param userId the value for wish_movie.user_id
     *
     * @mbg.generated Fri Apr 17 00:08:01 GMT+08:00 2020
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wish_movie.movie_id
     *
     * @return the value of wish_movie.movie_id
     *
     * @mbg.generated Fri Apr 17 00:08:01 GMT+08:00 2020
     */
    public Long getMovieId() {
        return movieId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wish_movie.movie_id
     *
     * @param movieId the value for wish_movie.movie_id
     *
     * @mbg.generated Fri Apr 17 00:08:01 GMT+08:00 2020
     */
    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
}