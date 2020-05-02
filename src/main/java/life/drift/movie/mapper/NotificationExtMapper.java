package life.drift.movie.mapper;

import life.drift.movie.model.Notification;
import life.drift.movie.model.NotificationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NotificationExtMapper {

    int insert(Notification record);
}