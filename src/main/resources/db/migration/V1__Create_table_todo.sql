 create table todo(
    `id` int PRIMARY KEY AUTO_INCREMENT,
    `text` varchar(100),
    `completed` BOOLEAN,
     `editable` BOOLEAN,
     `visible` BOOLEAN,
     `deleted` BOOLEAN default false,
    `time` date,
    `userid` int
 );
INSERT INTO todo VALUES (null,"xiao hong todo",false,false ,false ,false ,NOW(),1);
INSERT INTO todo VALUES (null,"xiao hong todo",false,false ,false ,false ,NOW(),1);
INSERT INTO todo VALUES (null,"xiao liang todo",false,false ,false ,false ,NOW(),2);
INSERT INTO todo VALUES (null,"xiao liang todo",false,false ,false ,false ,NOW(),2);