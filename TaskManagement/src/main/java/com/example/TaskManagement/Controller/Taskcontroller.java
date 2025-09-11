package com.example.TaskManagement.Controller;

import com.example.TaskManagement.Entity.Priority;
import com.example.TaskManagement.Entity.Status;
import com.example.TaskManagement.Entity.Task;
import com.example.TaskManagement.Exceptions.Idnotfound;
import com.example.TaskManagement.Exceptions.Tasknotfound;
import com.example.TaskManagement.Service.Taskservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class Taskcontroller {

    @Autowired
    private Taskservice ts;

    @PostMapping("createtask")
    public ResponseEntity<String> createtask(@Valid @RequestBody Task task)
    {
        return ts.createtask(task);
    }

    @PutMapping("update")
    public ResponseEntity<String> updatetask(@Valid @RequestBody Task task)
    {
        return ts.updatetask(task);
    }


    @PostMapping("createtasks")
    public ResponseEntity<String> createtasks(@Valid @RequestBody List<Task> tasks)
    {
        return ts.createtasks(tasks);
    }


    @DeleteMapping("deleteall")
    public ResponseEntity<String> deleteall()
    {
        return ts.deleteall();
    }

    @GetMapping("Tasks")
    public ResponseEntity<List<Task>> getalltasks() throws Exception {
        return ts.getalltasks();
    }

    @GetMapping("gettaskbyid/{id}")
    public ResponseEntity<Task> gettaskbyid(@PathVariable int id)
    {
        return ts.gettaskbyid(id);
    }

    @GetMapping("getbypriority/{priority}")
    public ResponseEntity<List<Task>> getbypriority(@PathVariable Priority priority)
    {
        return ts.getbypriority(priority);
    }


    @GetMapping("getbystatus/{status}")
    public ResponseEntity<List<Task>> getbystatus(@PathVariable Status status)
    {
        return ts.getbystatus(status);
    }

    @GetMapping("getbydate/{gettasksbetweendates}")
    public ResponseEntity<List<Task>> getbydate(@PathVariable LocalDate duedate) throws Tasknotfound {
        return ts.getbydate(duedate);
    }

    @GetMapping("gettasksbetweendates/{startdate}/{enddate}")
    public ResponseEntity<List<Task>> gettasksbetweendates(@PathVariable LocalDate startdate,@PathVariable LocalDate enddate) throws Tasknotfound {
        return ts.gettasksbetweendates(startdate,enddate);
    }
    //System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");

    @PostMapping("createtaskforuser/{userid}")
    public ResponseEntity<String> createtaskforuser(@Valid @RequestBody Task task,@PathVariable int userid)
    {
    return ts.createtaskforuser(task,userid);
    }

}
