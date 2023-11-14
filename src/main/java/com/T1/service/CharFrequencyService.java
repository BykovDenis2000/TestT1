package com.T1.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CharFrequencyService {

    public List<Map.Entry<Character, Long>> calculateCharFrequency(String inputString) {

        Map<Character, Long> frequencyMap = new HashMap<>();


        for (char c : inputString.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0L) + 1);
        }

        List<Map.Entry<Character, Long>> sortedList = new ArrayList<>(frequencyMap.entrySet());
        sortedList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        return sortedList;
    }
}

