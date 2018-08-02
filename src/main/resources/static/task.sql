 create table task(
    id int PRIMARY KEY AUTO_INCREMENT,
    text varchar(100),
    todoId int,
     CONSTRAINT FK_todoId FOREIGN KEY (todoId)
    REFERENCES todo(id)
 );

INSERT INTO task VALUES (null,"todo1 task1",1);
INSERT INTO task VALUES (null,"todo1 task2",1);
INSERT INTO task VALUES (null,"todo2 task1",2);