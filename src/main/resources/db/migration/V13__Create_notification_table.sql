create table notification
(
    id bigint auto_increment,
    notifier bigint not null comment '回复人id',
    receiver bigint not null comment '接收通知的用户id',
    outerid bigint not null,
    type int not null comment '回复的对象类型',
    gmt_create datetime null,
    status int default 0 not null comment '是否已读',
    constraint notification_pk
        primary key (id)
);

