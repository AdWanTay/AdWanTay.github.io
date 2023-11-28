package com.advancedsolutionsdevelopers.ToDoAppBackEnd.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "todoitem")
@Getter
@Setter
@ToString
public class ToDoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "importance")
    private String importance;        //basic, low, important

    @Column(name = "done")
    private Boolean isCompleted;

    private String text;

    @Column(name = "created_at")
    private Long creationDate;

    @Column(name = "changed_at")
    private Long lastEditDate;

    @Column(name = "last_updated_by")
    private Long lastUpdatedBy;

    @Column(name = "deadline")
    private Long deadlineDate = 0L;

    public void setDeadlineDate(Long deadlineDate) {
        if (deadlineDate != null)
            this.deadlineDate = deadlineDate;
    }
}
