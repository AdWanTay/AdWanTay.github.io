package com.advancedsolutionsdevelopers.ToDoAppBackEnd.network;

import com.advancedsolutionsdevelopers.ToDoAppBackEnd.models.ToDoItem;
import com.advancedsolutionsdevelopers.ToDoAppBackEnd.database.ToDoItemRepository;
import com.advancedsolutionsdevelopers.ToDoAppBackEnd.network.models.ArrayRequest;
import com.advancedsolutionsdevelopers.ToDoAppBackEnd.network.models.SingleItemRequest;
import com.advancedsolutionsdevelopers.ToDoAppBackEnd.network.models.ToDoItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ToDoItemController {
    @Autowired
    private ToDoItemRepository toDoItemRepository;

    @GetMapping(path = "/list")
    public ArrayRequest getTasksList(@RequestHeader("authorization") String authToken) {
        authToken = authToken.split(" ")[1];
        System.out.printf(authToken);
        ArrayRequest response = new ArrayRequest();
        response.setStatus("ok");
        response.setRevision(1);
        response.setList(ToDoItemRequest.ToDoItemBuilder(toDoItemRepository.findAllByAuthor(authToken)));
        return response;
    }

//    @GetMapping(path = "/list/{id}")
//    public ResponseEntity<ToDoItem> getTaskById(@PathVariable long id) {
//        Optional<ToDoItem> toDoItem = toDoItemRepository.findById(id);
//        return toDoItem.map(doItem -> new ResponseEntity<>(doItem, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
//    }

    @PostMapping(path = "/list")
    public SingleItemRequest addTask(@RequestBody SingleItemRequest itemResponse, @RequestHeader("authorization") String authToken) {
        System.out.println(itemResponse.toString());
        System.out.println(authToken.split(" ")[1]);
        ToDoItem toDoItemResponse = itemResponse.getElement();
//        ToDoItem toDoItem = getToDoItem(toDoItemResponse);
        System.out.println(toDoItemResponse);
        toDoItemResponse.setAuthor(authToken.split(" ")[1]);

        toDoItemRepository.save(toDoItemResponse);
        SingleItemRequest response = new SingleItemRequest();
        response.setStatus("ok");
        response.setRevision(1);
        response.setElement(toDoItemResponse);
        return response;
    }

    //    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/list/{id}", produces = APPLICATION_JSON_VALUE)
    public SingleItemRequest deleteTask(@PathVariable String id) {
        SingleItemRequest response = new SingleItemRequest();
        if (toDoItemRepository.findById(id).isPresent()) {
            response.setElement(toDoItemRepository.findById(id).orElse(null));
            response.setStatus("ok");
            response.setRevision(1);
            toDoItemRepository.deleteById(id);
        } else {
            response.setStatus(String.valueOf(HttpStatus.NOT_FOUND.value()));
            response.setRevision(1);
        }
        return response;
    }


//    private static ToDoItem getToDoItem(ToDoItem toDoItemResponse) {
//        ToDoItem toDoItem = new ToDoItem();
//        toDoItem.setAuthor(toDoItemResponse.getAuthor());
//        toDoItem.setImportance(toDoItemResponse.getImportance());
//        toDoItem.setCreated_at(toDoItemResponse.g());
//        toDoItem.setText(toDoItemResponse.getText());
//        toDoItem.setDeadlineDate(toDoItemResponse.getDeadlineDate());
//        toDoItem.setIsCompleted(toDoItemResponse.getIsCompleted());
//        toDoItem.setLastEditDate(toDoItemResponse.getLastEditDate());
//        toDoItem.setLastUpdatedBy(toDoItemResponse.getLastUpdatedBy());
//        return toDoItem;
//    }


}
