package com.T1.controller;

import com.T1.service.CharFrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class CharFrequencyController {

    private final CharFrequencyService charFrequencyService;

    @Autowired
    public CharFrequencyController(CharFrequencyService charFrequencyService) {
        this.charFrequencyService = charFrequencyService;
    }

    @GetMapping("/char-frequency")
    public ResponseEntity<List<Map.Entry<Character, Long>>> calculateCharFrequency(@RequestParam String inputString) {
        List<Map.Entry<Character, Long>> result = charFrequencyService.calculateCharFrequency(inputString);
        return ResponseEntity.ok(result);
    }
}


