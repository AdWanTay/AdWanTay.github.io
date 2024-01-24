package com.advancedsolutionsdevelopers.ToDoAppBackEnd.network.models;

import com.advancedsolutionsdevelopers.ToDoAppBackEnd.models.ToDoItem;
import lombok.Data;

@Data
public class SingleItemRequest {
    String status = null;
    ToDoItem element;
    int revision = -1;
}
