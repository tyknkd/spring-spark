package com.example.rest;

import com.example.SparkBroadcast;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class AppRestController {
    @GetMapping("/")
    public ResponseEntity<String> root() {
        List<Integer> list = SparkBroadcast.javaBroadcast();
        return ResponseEntity.ok(list.toString());
    }
}