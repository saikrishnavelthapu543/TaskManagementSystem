package com.example.TaskManagement.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.Log;

import java.time.LocalDate;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Title should not be blank")
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status=Status.PENDING;
    @Enumerated(EnumType.STRING)
    private Priority priority=Priority.MEDIUM;
    @FutureOrPresent(message = "Due date must be future or present")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate duedate;
    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

    public int getId() {
        return id;
    }

    public Task() {
    }

    public @NotBlank(message = "Title should not be blank") String getTitle() {
        return title;
    }

    public void setTitle(@NotBlank(message = "Title should not be blank") String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public @FutureOrPresent(message = "Due date must be future or present") LocalDate getDuedate() {
        return duedate;
    }

    public void setDuedate(@FutureOrPresent(message = "Due date must be future or present") LocalDate duedate) {
        this.duedate = duedate;
    }

    public Task(int id, String title, String description, Status status, Priority priority, LocalDate duedate, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.duedate = duedate;
        this.user = user;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
