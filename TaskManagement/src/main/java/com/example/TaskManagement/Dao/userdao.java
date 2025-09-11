package com.example.TaskManagement.Dao;

import com.example.TaskManagement.Entity.User;
import com.example.TaskManagement.Impl.userrepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class userdao {
    @Autowired
    private userrepository ur;

    public ResponseEntity<String> saveuser(@Valid User user) {
        ur.save(user);
        return new ResponseEntity<String>("saveduser", HttpStatus.CREATED);
    }
}
