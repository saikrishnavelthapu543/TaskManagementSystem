package com.example.TaskManagement.Dao;

import com.example.TaskManagement.Entity.Priority;
import com.example.TaskManagement.Entity.Status;
import com.example.TaskManagement.Entity.Task;
import com.example.TaskManagement.Entity.User;
import com.example.TaskManagement.Exceptions.Idnotfound;
import com.example.TaskManagement.Exceptions.Tasknotfound;
import com.example.TaskManagement.Exceptions.usernotfound;
import com.example.TaskManagement.Impl.TaskRepository;
import com.example.TaskManagement.Impl.userrepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class Taskdao {
    @Autowired
    private TaskRepository tr;
    @Autowired
    private userrepository ur;

    public ResponseEntity<String> createtask(Task task) {
        tr.save(task);
       return new ResponseEntity<String>("saved", HttpStatus.CREATED);
    }
    public ResponseEntity<String> updatetask(@Valid Task task) {

            tr.save(task);
            return new ResponseEntity<String>("updated",HttpStatus.OK);

    }

    public ResponseEntity<String> deleteall() {
        tr.deleteAll();
        return new ResponseEntity<String>("deleted",HttpStatus.OK);
    }

    public ResponseEntity<String> createtasks(@Valid List<Task> tasks) {
        tr.saveAll(tasks);
        return new ResponseEntity<String>("TasksSaved",HttpStatus.CREATED);
    }

    public ResponseEntity<List<Task>> getalltasks() throws Exception {
        List<Task> tasks= tr.findAll();
        if(tasks.isEmpty())
        {
            throw new Tasknotfound("Tasks not found");
        }
        else
        return new ResponseEntity<List<Task>>(tasks,HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Task> gettaskbyid(int id)
    {

       if(tr.existsById(id))
        {
            Optional<Task> task1=tr.findById(id);
            Task task=task1.get();
            return new ResponseEntity<Task>(task,HttpStatus.ACCEPTED);
        }
        else throw new Idnotfound("Id "+id+" "+"Not found");

    }

    public ResponseEntity<List<Task>> getbypriority(Priority priority) {
       List<Task> tasks=  tr.findByPriority(priority);
       return new ResponseEntity<List<Task>>(tasks,HttpStatus.ACCEPTED);
    }

    public ResponseEntity<List<Task>> getbystatus(Status status) {
        List<Task> tasks=tr.findByStatus(status);
        return new ResponseEntity<List<Task>>(tasks,HttpStatus.ACCEPTED);
    }

    public ResponseEntity<List<Task>> getbydate(LocalDate duedate) throws Tasknotfound {
        List<Task> tasks=tr.findByDuedate(duedate);
        if(tasks.isEmpty())
        {
            throw new Tasknotfound("Task not found");
        } else
        return new ResponseEntity<List<Task>>(tasks,HttpStatus.ACCEPTED);
    }
    public ResponseEntity<List<Task>> gettasksbetweendates(LocalDate startdate,LocalDate enddate) throws Tasknotfound {
        List<Task> tasks=  tr.findByDuedateBetween(startdate,enddate);
        if(tasks.isEmpty())
        {
            throw new Tasknotfound("Task not found");
        }else
        return new ResponseEntity<List<Task>>(tasks,HttpStatus.ACCEPTED);
    }


    public ResponseEntity<String> createtaskforuser(@Valid Task task, int userid) {
        Optional<User> user=ur.findById(userid);

        if(user.isEmpty())
        {
            throw new usernotfound("User with id "+userid+" "+"not found");
        }else
        {
            User u=user.get();
            task.setUser(u);
            tr.save(task);
            return new ResponseEntity<String>("saved",HttpStatus.OK);
        }

    }
}
