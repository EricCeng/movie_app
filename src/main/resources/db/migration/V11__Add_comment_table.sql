create table comment
(
    id bigint auto_increment,
    parent_id bigint null,
    type int null,
    commentator bigint,
    gmt_create datetime default current_timestamp not null,
    gmt_modified datetime default current_timestamp not null,
    content varchar(1024) not null,
    like_count bigint default 0 null,
    comment_count bigint default 0 null,
    constraint comment_pk
        primary key (id)
);

