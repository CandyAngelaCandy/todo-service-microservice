 create table todo(
    `id` int PRIMARY KEY AUTO_INCREMENT,
    `text` varchar(100),
    `completed` BOOLEAN,
     `editable` BOOLEAN,
     `visible` BOOLEAN,
     `deleted` BOOLEAN default false,
    `time` date
 );
INSERT INTO todo VALUES (null,"hello 0",false,false ,false ,false ,NOW());
INSERT INTO todo VALUES (null,"hello 1",false,false ,false ,false ,NOW());