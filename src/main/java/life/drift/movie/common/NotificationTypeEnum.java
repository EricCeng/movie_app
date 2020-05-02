package life.drift.movie.common;

public enum NotificationTypeEnum {
    REPLY_POST(1, "回复了您的动态"),
    REPLY_POST_COMMENT(2, "回复了您的评论"),
    REPLY_REVIEW(3, "回复了您的影评"),
    REPLY_REVIEW_COMMENT(4, "回复了您的评论"),
    ;
    private int type;
    private String content;

    public int getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    NotificationTypeEnum(int type, String content) {
        this.type = type;
        this.content = content;
    }

    public static String nameOfType(int type) {
        for (NotificationTypeEnum notificationEnum : NotificationTypeEnum.values()) {
            if (notificationEnum.getType() == type) {
                return notificationEnum.getContent();
            }
        }
        return "";
    }
}
