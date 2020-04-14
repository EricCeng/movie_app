create table movie
(
    id bigint auto_increment,
    movie_name varchar(50) not null,
    movie_avatar varchar(256) not null,
    content text not null,
    country varchar(256) not null,
    score varchar(20) not null,
    category varchar(256) not null,
    is_showed varchar(5) not null,
    is_marked varchar(5) default 0,
    gmt_create datetime,
    gmt_modified datetime,
    show_time date not null,
    movie_time bigint not null,
    comment_count bigint default 0,
    constraint movie_pk
        primary key (id)
);

comment on column movie.is_showed is '0 为正在上映，1 为即将上映';

comment on column movie.is_marked is '想看 则为 1';

