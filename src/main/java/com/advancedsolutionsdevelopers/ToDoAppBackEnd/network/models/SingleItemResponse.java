package com.advancedsolutionsdevelopers.ToDoAppBackEnd.network.models;

import com.advancedsolutionsdevelopers.ToDoAppBackEnd.models.ToDoItem;
import lombok.Data;

@Data
public class SingleItemResponse {
    ToDoItem element;
    String status = null;
    int revision = -1;
}
