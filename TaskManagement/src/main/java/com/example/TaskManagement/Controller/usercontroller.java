package com.example.TaskManagement.Controller;

import com.example.TaskManagement.Entity.User;
import com.example.TaskManagement.Service.userservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class usercontroller {
    @Autowired
    private userservice us;

    @PostMapping("saveuser")
    public ResponseEntity<String> saveuser(@Valid @RequestBody User user)
    {
       return us.saveuser(user);
    }
}
