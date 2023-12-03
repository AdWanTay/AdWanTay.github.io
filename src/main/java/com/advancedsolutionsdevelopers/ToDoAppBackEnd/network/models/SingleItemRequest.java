package com.advancedsolutionsdevelopers.ToDoAppBackEnd.network.models;

import com.advancedsolutionsdevelopers.ToDoAppBackEnd.models.ToDoItem;
import lombok.Data;

@Data
public class SingleItemRequest {
    String status = null;
    ToDoItem element;
    int revision = -1;
}

//9e0d8656-9c8b-4e65-ac44-2516a9338df3
