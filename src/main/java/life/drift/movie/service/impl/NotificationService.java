package life.drift.movie.service.impl;

import life.drift.movie.common.NotificationStatusEnum;
import life.drift.movie.common.NotificationTypeEnum;
import life.drift.movie.exception.ResponseErrorCode;
import life.drift.movie.mapper.NotificationMapper;
import life.drift.movie.model.Notification;
import life.drift.movie.model.NotificationExample;
import life.drift.movie.service.INotificationService;
import life.drift.movie.utils.DateUtil;
import life.drift.movie.utils.ServerResponse;
import life.drift.movie.vo.NotificationVO;
import life.drift.movie.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationService implements INotificationService {
    @Autowired
    private NotificationMapper notificationMapper;

    //通知列表
    @Override
    public ServerResponse list(Long userId) {
        NotificationExample notificationExample = new NotificationExample();
        notificationExample.createCriteria()
                .andReceiverEqualTo(userId);
        notificationExample.setOrderByClause("gmt_create desc");
        List<Notification> notificationList = notificationMapper.selectByExample(notificationExample);

        if (notificationList.size() == 0) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.NOTIFICATION_IS_EMPTY.getCode(), ResponseErrorCode.NOTIFICATION_IS_EMPTY.getMsg());
        }

        List<NotificationVO> notificationVOList = notificationList.stream().map(notification -> {
            NotificationVO notificationVO = new NotificationVO();
            BeanUtils.copyProperties(notification, notificationVO);
            notificationVO.setGmtCreate(DateUtil.date2String(notification.getGmtCreate()));
            notificationVO.setTypeName(NotificationTypeEnum.nameOfType(notification.getType()));
            return notificationVO;
        }).collect(Collectors.toList());

        return ServerResponse.createServerResponseBySuccess(notificationVOList);
    }

    //未读通知 数
    //结果将存放在 session 中
    @Override
    public Long unreadCount(Long userId) {
        NotificationExample notificationExample = new NotificationExample();
        notificationExample.createCriteria()
                .andReceiverEqualTo(userId)
                .andStatusEqualTo(NotificationStatusEnum.UNREAD.getStatus());
        Long count = notificationMapper.countByExample(notificationExample);
        return count;
    }

    //查看通知
    @Override
    public NotificationVO readNotification(Long id, UserVO userVO) {
        Notification notification = notificationMapper.selectByPrimaryKey(id);
//        if (notification == null) {
//            return ServerResponse.createServerResponseByFail(ResponseErrorCode.NOTIFICATION_NOT_FOUND.getCode(), ResponseErrorCode.NOTIFICATION_NOT_FOUND.getMsg());
//        }

        notification.setStatus(NotificationStatusEnum.READ.getStatus());
        notificationMapper.updateByPrimaryKey(notification);

        NotificationVO notificationVO = new NotificationVO();
        BeanUtils.copyProperties(notification, notificationVO);
        notificationVO.setGmtCreate(DateUtil.date2String(notification.getGmtCreate()));
        notificationVO.setTypeName(NotificationTypeEnum.nameOfType(notification.getType()));

        return notificationVO;
    }


}
