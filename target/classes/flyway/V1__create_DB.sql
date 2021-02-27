create table if not exists valves (
    id bigint not null auto_increment,
    biu varchar(10),
    name varchar(255),
    assembly varchar(10),
    locker varchar(10),
    position varchar(10),
    location varchar(20),
    primary key (id)
);