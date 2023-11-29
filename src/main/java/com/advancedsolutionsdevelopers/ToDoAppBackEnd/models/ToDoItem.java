package com.advancedsolutionsdevelopers.ToDoAppBackEnd.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Table(name = "todoitem")
@Getter
@Setter
@ToString
@Data
public class ToDoItem implements Serializable {
    @Id
    private String id;

    private String importance;        //basic, low, important

    private Boolean done;

    private String text;

    private String author;

    @Column(name = "created_at")
    private Long created_at;

    @Column(name = "changed_at")
    private Long changed_at;

    @Column(name = "last_updated_by")
    private String last_updated_by;

    @Column(name = "deadline")
    private Long deadline = 0L;


}
