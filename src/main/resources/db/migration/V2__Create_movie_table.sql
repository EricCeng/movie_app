create table film
(
    id bigint auto_increment,
    movie_name varchar(50) not null,
    movie_avatar varchar(256) not null,
    content text not null,
    country varchar(256) not null,
    score varchar(20) default 0,
    category varchar(256) not null,
    gmt_create datetime,
    gmt_modified datetime,
    show_time date not null,
    movie_time bigint not null,
    comment_count bigint default 0,
    constraint movie_pk
        primary key (id)
);

