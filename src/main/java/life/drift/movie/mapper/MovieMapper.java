package life.drift.movie.mapper;

import java.util.List;
import life.drift.movie.model.Movie;
import life.drift.movie.model.MovieExample;
import org.apache.ibatis.annotations.Param;

public interface MovieMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table film
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    long countByExample(MovieExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table film
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    int deleteByExample(MovieExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table film
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table film
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    int insert(Movie record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table film
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    int insertSelective(Movie record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table film
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    List<Movie> selectByExampleWithBLOBs(MovieExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table film
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    List<Movie> selectByExample(MovieExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table film
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    Movie selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table film
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    int updateByExampleSelective(@Param("record") Movie record, @Param("example") MovieExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table film
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    int updateByExampleWithBLOBs(@Param("record") Movie record, @Param("example") MovieExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table film
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    int updateByExample(@Param("record") Movie record, @Param("example") MovieExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table film
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    int updateByPrimaryKeySelective(Movie record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table film
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    int updateByPrimaryKeyWithBLOBs(Movie record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table film
     *
     * @mbg.generated Sun May 03 13:09:54 GMT+08:00 2020
     */
    int updateByPrimaryKey(Movie record);
}