package com.example.TaskManagement.Service;

import com.example.TaskManagement.Dao.userdao;
import com.example.TaskManagement.Entity.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class userservice {
    @Autowired
    private userdao ud;

    public ResponseEntity<String> saveuser(@Valid User user) {
        return ud.saveuser(user);
    }
}
