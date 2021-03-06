package life.drift.movie.vo;

import java.util.Date;

public class UserVO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.id
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.USERNAME
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.PASSWORD
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.EMAIL
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.PHONE
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.GMT_CREATE
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    private String gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.GMT_MODIFIED
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    private String gmtModified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.GENDER
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    private String gender;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.AVATAR_URL
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    private String avatarUrl;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.id
     *
     * @return the value of user.id
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.id
     *
     * @param id the value for user.id
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.USERNAME
     *
     * @return the value of user.USERNAME
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.USERNAME
     *
     * @param username the value for user.USERNAME
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.PASSWORD
     *
     * @return the value of user.PASSWORD
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.PASSWORD
     *
     * @param password the value for user.PASSWORD
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.EMAIL
     *
     * @return the value of user.EMAIL
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.EMAIL
     *
     * @param email the value for user.EMAIL
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.PHONE
     *
     * @return the value of user.PHONE
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.PHONE
     *
     * @param phone the value for user.PHONE
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.GMT_CREATE
     *
     * @return the value of user.GMT_CREATE
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    public String getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.GMT_CREATE
     *
     * @param gmtCreate the value for user.GMT_CREATE
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.GMT_MODIFIED
     *
     * @return the value of user.GMT_MODIFIED
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    public String getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.GMT_MODIFIED
     *
     * @param gmtModified the value for user.GMT_MODIFIED
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.GENDER
     *
     * @return the value of user.GENDER
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    public String getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.GENDER
     *
     * @param gender the value for user.GENDER
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.AVATAR_URL
     *
     * @return the value of user.AVATAR_URL
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.AVATAR_URL
     *
     * @param avatarUrl the value for user.AVATAR_URL
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }
}