package life.drift.movie.common;

public enum CommentTypeEnum {
    POST(1),
    POST_COMMENT(2),
    REVIEW(3),
    REVIEW_COMMENT(4),
    ;

    private Integer type;

    public Integer getType() {
        return type;
    }

    CommentTypeEnum(Integer type) {
        this.type = type;
    }

    public static boolean isExist(Integer type) {
        for (CommentTypeEnum commentTypeEnum : CommentTypeEnum.values()) {
            if (commentTypeEnum.getType() == type) {
                return true;
            }
        }
        return false;
    }
}
