package com.example.learn.services;

import com.example.learn.models.Day;
import com.example.learn.repositories.DaysRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DayService {
    private DaysRepository daysRepository;

    public DayService(DaysRepository daysRepository) {
        this.daysRepository = daysRepository;
    }

    public List<Day> findAll() {
        return daysRepository.findAll();
    }

    public Day save(LocalDate now) {
        return daysRepository.save(new Day());
    }
}
