package com.example.TaskManagement.Impl;

import com.example.TaskManagement.Entity.Priority;
import com.example.TaskManagement.Entity.Status;
import com.example.TaskManagement.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{

    List<Task> findByPriority(Priority priority);
    List<Task> findByStatus(Status status);
    List<Task> findByDuedate(LocalDate duedate);
    List<Task> findByDuedateBetween(LocalDate startdate,LocalDate enddate);
}
