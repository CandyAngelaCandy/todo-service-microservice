 create table todo(
    `id` int PRIMARY KEY AUTO_INCREMENT,
    `text` varchar(100),
    `completed` BOOLEAN,
     `editable` BOOLEAN,
     `visible` BOOLEAN,
    `time` date
 );

INSERT INTO todo VALUES (null,"hello 0",false,false ,false ,NOW());
INSERT INTO todo VALUES (null,"hello 1",false,false ,false ,NOW());

select * from todo;

select * from todo  INNER JOIN task  on task.todoId = todo.id;

DROP TABLE todo;
DROP TABLE task;