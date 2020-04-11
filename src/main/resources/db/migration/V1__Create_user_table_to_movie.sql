create table user
(
    id bigint auto_increment,
    username varchar(50) not null,
    password varchar(50) not null,
    email varchar(50) not null,
    phone varchar(20) not null,
    gmt_create bigint,
    gmt_modified bigint,
    constraint table_name_pk
        primary key (id)
);

create unique index table_name_username_uindex
    on user (username);

