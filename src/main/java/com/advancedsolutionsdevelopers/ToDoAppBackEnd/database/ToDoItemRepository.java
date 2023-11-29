package com.advancedsolutionsdevelopers.ToDoAppBackEnd.database;

import com.advancedsolutionsdevelopers.ToDoAppBackEnd.models.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoItemRepository extends JpaRepository<ToDoItem, String> {
    Iterable<ToDoItem> findAllByAuthor(String author);

}
