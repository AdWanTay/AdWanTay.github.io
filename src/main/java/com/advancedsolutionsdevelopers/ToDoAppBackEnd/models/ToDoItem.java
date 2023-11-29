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

    @Column(name = "importance")
    private String importance;        //basic, low, important

    @Column(name = "done")
    private Boolean isCompleted;

    private String text;

    private String author;

    @Column(name = "created_at")
    private Long creationDate;

    @Column(name = "changed_at")
    private Long lastEditDate;

    @Column(name = "last_updated_by")
    private String lastUpdatedBy;

    @Column(name = "deadline")
    private Long deadlineDate = 0L;

    public void setDeadlineDate(Long deadlineDate) {
        if (deadlineDate != null)
            this.deadlineDate = deadlineDate;
    }
}
