create table review
(
    id bigint auto_increment,
    user_id bigint null,
    movie_id bigint null,
    is_selected int default 0 null,
    review_content text not null,
    create_time datetime null,
    update_time datetime null,
    comment_count bigint default 0 null,
    like_count bigint default 0 null,
    constraint review_pk
        primary key (id)
);

