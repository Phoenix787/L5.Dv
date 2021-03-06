create table if not exists users (id bigint auto_increment primary key, name varchar(256), password varchar(256));
create table if not exists accounts(id bigint auto_increment  primary key, description varchar(256), amount double, id_user bigint);
create table if not exists records(id bigint auto_increment primary key, description varchar(256), amount double, date_rec date, id_category bigint, type boolean, id_account bigint);
create table if not exists category(id bigint auto_increment primary key, name varchar(256));