CREATE TABLE IF NOT EXISTS ToDoItem
(
    id varchar(40) PRIMARY KEY,
    text varchar (255) not null,
    done BOOLEAN not null,
    author varchar(255) not null,
    importance  VARCHAR(200) NOT NULL ,
    created_at int NOT NULL ,
    changed_at int  NOT NULL,
    last_updated_by VARCHAR(50) NOT NULL,
    deadline int NULL
);