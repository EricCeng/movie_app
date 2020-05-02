package life.drift.movie.vo;

import lombok.Data;

@Data
public class NotificationVO {
    private Long id;
    private String gmtCreate;
    private Integer status;
    private Long notifier;
    private String notifierName;
    private String outerTitle;
    private Long outerid;
    private String typeName;
    private Integer type;
}