package com.advancedsolutionsdevelopers.ToDoAppBackEnd.network;

import com.advancedsolutionsdevelopers.ToDoAppBackEnd.database.ToDoItemRepository;
import com.advancedsolutionsdevelopers.ToDoAppBackEnd.models.ToDoItem;
import com.advancedsolutionsdevelopers.ToDoAppBackEnd.network.models.ArrayRequest;
import com.advancedsolutionsdevelopers.ToDoAppBackEnd.network.models.SingleItemRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ToDoItemService {
    private final ToDoItemRepository toDoItemRepository;

    public ToDoItemService(ToDoItemRepository toDoItemRepository) {
        this.toDoItemRepository = toDoItemRepository;
    }

    public ArrayRequest getTasksList(String authToken) {
        authToken = authToken.split(" ")[1];
        System.out.printf(authToken);
        ArrayRequest response = new ArrayRequest();
        response.setStatus("ok");
        response.setRevision(1);
        response.setList(toDoItemRepository.findAllByAuthor(authToken));
        return response;
    }

    public SingleItemRequest addTask(SingleItemRequest itemResponse, String authToken) {
        ToDoItem toDoItem = itemResponse.getElement();
        toDoItem.setAuthor(authToken.split(" ")[1]);
        toDoItemRepository.save(toDoItem);
        SingleItemRequest response = new SingleItemRequest();
        response.setStatus("ok");
        response.setRevision(1);
        response.setElement(toDoItem);
        return response;
    }

    public SingleItemRequest updateTask(String authToken, SingleItemRequest request, int rev) {
        SingleItemRequest response = new SingleItemRequest();
        response.setElement(request.getElement());
        response.getElement().setAuthor(authToken.split(" ")[1]);
        toDoItemRepository.save(response.getElement());
        response.setStatus("ok");
        response.setRevision(++rev);
        return response;
    }

    public SingleItemRequest deleteTask(String id) {
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

}
