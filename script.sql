drop database if exists HolidayPackage;

create database HolidayPackage;

use HolidayPackage;

CREATE TABLE package_details (package_id varchar(25) primary key, source_place varchar(25) , destination_place varchar(25), no_of_days int(5), package_cost double(10,2));


INSERT INTO package_details VALUES('137/DEJ', 'Delhi', 'Jaipur', 5, 28000);
INSERT INTO package_details VALUES('201/DEC', 'Delhi', 'Chennai', 9, 38304);
INSERT INTO package_details VALUES('215/KOM', 'Kochi', 'Mumbai', 5, 31108);
INSERT INTO package_details VALUES('301/AGD', 'Agra', 'Delhi', 7, 10137.1984);
INSERT INTO package_details VALUES('805/JAG', 'Jaipur', 'Goa', 5, 42000);
INSERT INTO package_details VALUES('989/CHM', 'Chennai', 'Mumbai', 15, 46872);

COMMIT;