package life.drift.movie.model;

import java.util.Date;

public class Movie {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MOVIE.ID
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MOVIE.MOVIE_NAME
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    private String movieName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MOVIE.MOVIE_AVATAR
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    private String movieAvatar;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MOVIE.COUNTRY
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    private String country;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MOVIE.SCORE
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    private String score;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MOVIE.CATEGORY
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    private String category;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MOVIE.IS_SHOWED
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    private String isShowed;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MOVIE.IS_MARKED
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    private String isMarked;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MOVIE.GMT_CREATE
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    private Date gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MOVIE.GMT_MODIFIED
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    private Date gmtModified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MOVIE.SHOW_TIME
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    private Date showTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MOVIE.MOVIE_TIME
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    private Long movieTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MOVIE.COMMENT_COUNT
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    private Long commentCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MOVIE.CONTENT
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MOVIE.ID
     *
     * @return the value of MOVIE.ID
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MOVIE.ID
     *
     * @param id the value for MOVIE.ID
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MOVIE.MOVIE_NAME
     *
     * @return the value of MOVIE.MOVIE_NAME
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    public String getMovieName() {
        return movieName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MOVIE.MOVIE_NAME
     *
     * @param movieName the value for MOVIE.MOVIE_NAME
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    public void setMovieName(String movieName) {
        this.movieName = movieName == null ? null : movieName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MOVIE.MOVIE_AVATAR
     *
     * @return the value of MOVIE.MOVIE_AVATAR
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    public String getMovieAvatar() {
        return movieAvatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MOVIE.MOVIE_AVATAR
     *
     * @param movieAvatar the value for MOVIE.MOVIE_AVATAR
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    public void setMovieAvatar(String movieAvatar) {
        this.movieAvatar = movieAvatar == null ? null : movieAvatar.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MOVIE.COUNTRY
     *
     * @return the value of MOVIE.COUNTRY
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    public String getCountry() {
        return country;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MOVIE.COUNTRY
     *
     * @param country the value for MOVIE.COUNTRY
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MOVIE.SCORE
     *
     * @return the value of MOVIE.SCORE
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    public String getScore() {
        return score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MOVIE.SCORE
     *
     * @param score the value for MOVIE.SCORE
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MOVIE.CATEGORY
     *
     * @return the value of MOVIE.CATEGORY
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    public String getCategory() {
        return category;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MOVIE.CATEGORY
     *
     * @param category the value for MOVIE.CATEGORY
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MOVIE.IS_SHOWED
     *
     * @return the value of MOVIE.IS_SHOWED
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    public String getIsShowed() {
        return isShowed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MOVIE.IS_SHOWED
     *
     * @param isShowed the value for MOVIE.IS_SHOWED
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    public void setIsShowed(String isShowed) {
        this.isShowed = isShowed == null ? null : isShowed.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MOVIE.IS_MARKED
     *
     * @return the value of MOVIE.IS_MARKED
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    public String getIsMarked() {
        return isMarked;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MOVIE.IS_MARKED
     *
     * @param isMarked the value for MOVIE.IS_MARKED
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    public void setIsMarked(String isMarked) {
        this.isMarked = isMarked == null ? null : isMarked.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MOVIE.GMT_CREATE
     *
     * @return the value of MOVIE.GMT_CREATE
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MOVIE.GMT_CREATE
     *
     * @param gmtCreate the value for MOVIE.GMT_CREATE
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MOVIE.GMT_MODIFIED
     *
     * @return the value of MOVIE.GMT_MODIFIED
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MOVIE.GMT_MODIFIED
     *
     * @param gmtModified the value for MOVIE.GMT_MODIFIED
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MOVIE.SHOW_TIME
     *
     * @return the value of MOVIE.SHOW_TIME
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    public Date getShowTime() {
        return showTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MOVIE.SHOW_TIME
     *
     * @param showTime the value for MOVIE.SHOW_TIME
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MOVIE.MOVIE_TIME
     *
     * @return the value of MOVIE.MOVIE_TIME
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    public Long getMovieTime() {
        return movieTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MOVIE.MOVIE_TIME
     *
     * @param movieTime the value for MOVIE.MOVIE_TIME
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    public void setMovieTime(Long movieTime) {
        this.movieTime = movieTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MOVIE.COMMENT_COUNT
     *
     * @return the value of MOVIE.COMMENT_COUNT
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    public Long getCommentCount() {
        return commentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MOVIE.COMMENT_COUNT
     *
     * @param commentCount the value for MOVIE.COMMENT_COUNT
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MOVIE.CONTENT
     *
     * @return the value of MOVIE.CONTENT
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MOVIE.CONTENT
     *
     * @param content the value for MOVIE.CONTENT
     *
     * @mbg.generated Tue Apr 14 00:43:48 GMT+08:00 2020
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}