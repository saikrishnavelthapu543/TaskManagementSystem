package com.example.TaskManagement.Service;

import com.example.TaskManagement.Dao.Taskdao;
import com.example.TaskManagement.Entity.Priority;
import com.example.TaskManagement.Entity.Status;
import com.example.TaskManagement.Entity.Task;
import com.example.TaskManagement.Exceptions.Idnotfound;
import com.example.TaskManagement.Exceptions.Tasknotfound;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class Taskservice {

    @Autowired
    private Taskdao td;

    public ResponseEntity<String> createtask(Task task) {
        return td.createtask(task);
    }

    public ResponseEntity<String> deleteall() {
        return td.deleteall();
    }

    public ResponseEntity<String> createtasks(@Valid List<Task> tasks) {
        return td.createtasks(tasks);
    }

    public ResponseEntity<List<Task>> getalltasks() throws Exception{
        return td.getalltasks();
    }

    public ResponseEntity<Task> gettaskbyid(int id) {
        return td.gettaskbyid(id);
    }

    public ResponseEntity<List<Task>> getbypriority(Priority priority) {
        return td.getbypriority(priority);
    }

    public ResponseEntity<List<Task>> getbystatus(Status status) {
        return td.getbystatus(status);
    }

    public ResponseEntity<List<Task>> getbydate(LocalDate duedate) throws Tasknotfound {
        return td.getbydate(duedate);
    }

    public ResponseEntity<String> updatetask(@Valid Task task) {
        return td.updatetask(task);
    }
    public ResponseEntity<List<Task>> gettasksbetweendates(LocalDate startdate,LocalDate enddate) throws Tasknotfound {
        return td.gettasksbetweendates(startdate,enddate);
    }

    public ResponseEntity<String> createtaskforuser(@Valid Task task, int userid) {
        return td.createtaskforuser(task,userid);
    }
}
