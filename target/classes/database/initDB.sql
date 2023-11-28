CREATE TABLE IF NOT EXISTS ToDoItem
(
    id BIGSERIAL PRIMARY KEY,
    text varchar (255) not null,
    done BOOLEAN not null,
    author varchar(255) not null,
    importance  VARCHAR(200) NOT NULL ,
    created_at int NOT NULL ,
    changed_at int  NOT NULL,
    last_updated_by int NOT NULL,
    deadline int NULL
);