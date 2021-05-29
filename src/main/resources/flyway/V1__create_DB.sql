create table if not exists valves (
                                      id bigint not null auto_increment,
                                      biu varchar(30),
                                      name varchar(255),
                                      assembly varchar(50),
                                      locker varchar(10),
                                      position varchar(10),
                                      location varchar(40),
                                      primary key (id)
);