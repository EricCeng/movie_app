package life.drift.movie.service;

import life.drift.movie.utils.ServerResponse;
import life.drift.movie.vo.NotificationVO;
import life.drift.movie.vo.UserVO;

public interface INotificationService {
    ServerResponse list(Long userId);
    Long unreadCount(Long userId);

    NotificationVO readNotification(Long id, UserVO userVO);
}
