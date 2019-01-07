package com.example.learn.controllers;

import com.example.learn.models.AddEntryRequest;
import com.example.learn.models.Day;
import com.example.learn.models.Entry;
import com.example.learn.services.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pomodoro")
public class EntryController {

    @Autowired
    private EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping("/test")
    public Map<String, List<String>> getTestAll() {
        return entryService.getAllDays().stream()
                .collect(
                        Collectors.groupingBy(
                                Entry::getDayAsString,
                                Collectors.mapping(Entry::getTimestampAsString, Collectors.toList())));
    }

    @GetMapping("/")
    public List<Entry> getAll() {
        return entryService.getAllDays();
    }

    @PostMapping("/test")
    private Day addTomato() {
        return entryService.addDay(LocalDate.now());
    }

    @PostMapping("/add/{date}")
    private Entry addEntry(@PathVariable String date, @RequestBody AddEntryRequest request) {
        return entryService.addEntry(LocalDate.parse(date), request.getTime());
    }

}
