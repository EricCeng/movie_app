create table USER
(
    ID           BIGINT auto_increment,
    USERNAME     VARCHAR(50) not null,
    PASSWORD     VARCHAR(50) not null,
    EMAIL        VARCHAR(50) not null,
    PHONE        VARCHAR(20) not null,
    GMT_CREATE   DATETIME,
    GMT_MODIFIED DATETIME,
    GENDER       VARCHAR(10) not null,
    AVATAR_URL   VARCHAR(256),
    constraint TABLE_NAME_PK
        primary key (ID)
);

create unique index TABLE_NAME_USERNAME_UINDEX
    on USER (USERNAME);

