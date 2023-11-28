package com.advancedsolutionsdevelopers.ToDoAppBackEnd.network.models;

import com.advancedsolutionsdevelopers.ToDoAppBackEnd.models.ToDoItem;
import lombok.Data;

import java.io.Serializable;

@Data
public class ArrayResponse implements Serializable {
    Iterable<ToDoItem> list;
    String status = null;
    int revision = -1;
}
