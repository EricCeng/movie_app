package life.drift.movie.mapper;

import java.util.List;
import life.drift.movie.model.WishMovie;
import life.drift.movie.model.WishMovieExample;
import org.apache.ibatis.annotations.Param;

public interface WishMovieMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wish_movie
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    long countByExample(WishMovieExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wish_movie
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    int deleteByExample(WishMovieExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wish_movie
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wish_movie
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    int insert(WishMovie record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wish_movie
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    int insertSelective(WishMovie record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wish_movie
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    List<WishMovie> selectByExample(WishMovieExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wish_movie
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    WishMovie selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wish_movie
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    int updateByExampleSelective(@Param("record") WishMovie record, @Param("example") WishMovieExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wish_movie
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    int updateByExample(@Param("record") WishMovie record, @Param("example") WishMovieExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wish_movie
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    int updateByPrimaryKeySelective(WishMovie record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wish_movie
     *
     * @mbg.generated Tue Apr 14 23:30:38 GMT+08:00 2020
     */
    int updateByPrimaryKey(WishMovie record);
}