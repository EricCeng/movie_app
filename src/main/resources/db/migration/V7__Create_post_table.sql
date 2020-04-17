create table post
(
    id bigint auto_increment,
    user_id bigint null,
    post_content text not null,
    comment_count bigint default 0 null,
    like_count bigint default 0 null,
    create_time datetime null,
    update_time datetime null,
    is_selected int default 0 null,
    constraint post_pk
        primary key (id)
);

