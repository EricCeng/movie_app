alter table wish_movie change wish_id id bigint auto_increment;

alter table wish_movie
    add update_time datetime null;

alter table wish_movie
    add is_wanted int(11) default 0 null;

alter table wish_movie
    add user_id bigint not null;

alter table wish_movie
    add movie_id bigint not null;

alter table user change user_id id bigint auto_increment;

alter table film change movie_id id bigint auto_increment;

alter table film drop column is_wanted;

