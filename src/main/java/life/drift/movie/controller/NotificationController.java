package life.drift.movie.controller;

import life.drift.movie.common.Const;
import life.drift.movie.common.NotificationTypeEnum;
import life.drift.movie.service.INotificationService;
import life.drift.movie.utils.ServerResponse;
import life.drift.movie.vo.NotificationVO;
import life.drift.movie.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class NotificationController {
    @Autowired
    private INotificationService notificationService;

    //通知列表
    @RequestMapping(value = "/listNotification")
    public ServerResponse list(HttpSession session) {
        UserVO userInfo = (UserVO) session.getAttribute(Const.CURRENT_USER);
        ServerResponse serverResponse = notificationService.list(userInfo.getId());
        return serverResponse;
    }

    //读取通知
    @RequestMapping(value = "/notification/{id}")
    public String readNotification(@PathVariable("id") Long id,
                                   HttpSession session) {
        UserVO userInfo = (UserVO) session.getAttribute(Const.CURRENT_USER);

        NotificationVO notificationVO = notificationService.readNotification(id, userInfo);

        if (NotificationTypeEnum.REPLY_POST.getType() == notificationVO.getType()
                || NotificationTypeEnum.REPLY_POST_COMMENT.getType() == notificationVO.getType()) {
            return "redirect:/post/" + notificationVO.getOuterid();
        } else {
            return "redirect:/movie/eachReview/" + notificationVO.getOuterid();
        }
    }
}
