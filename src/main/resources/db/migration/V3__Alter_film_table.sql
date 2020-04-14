alter table film change id movie_id bigint auto_increment;

alter table film change content movie_content text not null after category;

alter table film
    add director varchar(256) null after movie_avatar;

alter table film
    add actor varchar(256) null after director;

alter table film
    add is_wanted int default 0 null after comment_count;

alter table film change gmt_create movie_create datetime null after is_wanted;

alter table film change gmt_modified movie_modified datetime null after movie_create;

