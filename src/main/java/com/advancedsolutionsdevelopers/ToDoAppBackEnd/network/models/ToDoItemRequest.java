package com.advancedsolutionsdevelopers.ToDoAppBackEnd.network.models;

import com.advancedsolutionsdevelopers.ToDoAppBackEnd.models.ToDoItem;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class ToDoItemRequest {
    private String id;

    private String importance;        //basic, low, important

    private Boolean done;

    private String text;

    private Long created_at;

    private Long changed_at;

    private String last_updated_by;

    private Long deadline = 0L;

    public static ToDoItemRequest ToDoItemBuilder(ToDoItem toDoItem){
        ToDoItemRequest toDoItemRequest = toDoItemFilling(toDoItem);
        toDoItemFilling(toDoItem);
        return toDoItemRequest;
    }


    public static Iterable<ToDoItemRequest> ToDoItemBuilder(Iterable<ToDoItem> toDoItems){
        List <ToDoItemRequest> toDoItemsRequest = new ArrayList<>();
        for (ToDoItem toDoItem: toDoItems) {
            ToDoItemRequest toDoItemRequest = toDoItemFilling(toDoItem);
            toDoItemsRequest.add(toDoItemRequest);
        }
        return toDoItemsRequest;
    }

    private static ToDoItemRequest toDoItemFilling(ToDoItem toDoItem) {
        ToDoItemRequest toDoItemRequest = new ToDoItemRequest();
        toDoItemRequest.id = toDoItem.getId();
        toDoItemRequest.importance = toDoItem.getImportance();
        toDoItemRequest.done = toDoItem.getDone();
        toDoItemRequest.text = toDoItem.getText();
        toDoItemRequest.created_at = toDoItem.getCreated_at();
        toDoItemRequest.changed_at = toDoItem.getChanged_at();
        toDoItemRequest.last_updated_by = toDoItem.getLast_updated_by();
        toDoItemRequest.deadline = toDoItem.getDeadline();
        return toDoItemRequest;
    }
}
