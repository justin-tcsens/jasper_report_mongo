
create table vehicle (
	id int not null AUTO_INCREMENT,
	carplate_num varchar(10) not null,
    make varchar(50) not null,
    model varchar(50) not null,
    chassis_num varchar(60) not null,
    axles_num int not null,
    tyre_num int not null,
    roadtax_expiry varchar(10) not null,
    manufacture_year varchar(4) not null,
    CONSTRAINT pk_vehicle_id primary key (id)
);

create table summon (
	id int not null AUTO_INCREMENT,
    vehicle_id int not null,
	serial_num varchar(10) not null,
    fine_amt double(5,2) not null,
    location_ varchar(60) not null,
    officer_name varchar(60) not null,
    CONSTRAINT pk_summon_id primary key (id),
    CONSTRAINT fk_summon_vehicle_id FOREIGN KEY (vehicle_id) REFERENCES vehicle (id)
);