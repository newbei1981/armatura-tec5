create sequence hibernate_sequence start 1 increment 1;

create table valves (
    id int(8),
    biu varchar(255),
    name varchar(255),
    assembly varchar(255),
    locker varchar(255),
    position varchar(255),
    location varchar(255),
    primary key (id)
);
