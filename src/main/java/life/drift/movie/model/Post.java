package life.drift.movie.model;

import java.util.Date;

public class Post {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column post.id
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column post.user_id
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column post.comment_count
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    private Long commentCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column post.like_count
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    private Long likeCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column post.create_time
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column post.update_time
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column post.is_selected
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    private Integer isSelected;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column post.creator
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    private Long creator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column post.post_content
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    private String postContent;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column post.id
     *
     * @return the value of post.id
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column post.id
     *
     * @param id the value for post.id
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column post.user_id
     *
     * @return the value of post.user_id
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column post.user_id
     *
     * @param userId the value for post.user_id
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column post.comment_count
     *
     * @return the value of post.comment_count
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    public Long getCommentCount() {
        return commentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column post.comment_count
     *
     * @param commentCount the value for post.comment_count
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column post.like_count
     *
     * @return the value of post.like_count
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    public Long getLikeCount() {
        return likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column post.like_count
     *
     * @param likeCount the value for post.like_count
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column post.create_time
     *
     * @return the value of post.create_time
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column post.create_time
     *
     * @param createTime the value for post.create_time
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column post.update_time
     *
     * @return the value of post.update_time
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column post.update_time
     *
     * @param updateTime the value for post.update_time
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column post.is_selected
     *
     * @return the value of post.is_selected
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    public Integer getIsSelected() {
        return isSelected;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column post.is_selected
     *
     * @param isSelected the value for post.is_selected
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    public void setIsSelected(Integer isSelected) {
        this.isSelected = isSelected;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column post.creator
     *
     * @return the value of post.creator
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column post.creator
     *
     * @param creator the value for post.creator
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column post.post_content
     *
     * @return the value of post.post_content
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    public String getPostContent() {
        return postContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column post.post_content
     *
     * @param postContent the value for post.post_content
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    public void setPostContent(String postContent) {
        this.postContent = postContent == null ? null : postContent.trim();
    }
}