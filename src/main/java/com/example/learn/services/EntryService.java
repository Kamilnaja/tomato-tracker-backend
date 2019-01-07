package com.example.learn.services;

import com.example.learn.exceptions.DayNotExistsException;
import com.example.learn.models.Day;
import com.example.learn.models.Entry;
import com.example.learn.repositories.DaysRepository;
import com.example.learn.repositories.EntriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EntryService {
    private DaysRepository daysRepository;

    private EntriesRepository entriesRepository;

    @Autowired
    public EntryService(DaysRepository daysRepository, EntriesRepository entriesRepository) {
        this.daysRepository = daysRepository;
        this.entriesRepository = entriesRepository;
    }

    public Day addDay(LocalDate date) {
        if (findDate(date).isPresent()) {
            throw new DayNotExistsException();
        }
        return daysRepository.save(new Day(date));
    }

    public Entry addEntry(LocalDate date, LocalDateTime time) {
        Optional<Day> day = findDate(date);
        Entry entry = new Entry();
        entry.setTimestamp(Date.from(time.atZone(ZoneId.systemDefault()).toInstant()));
        entry.setDay(day.orElseGet(() -> addDay(date)));

        return entriesRepository.save(entry);
    }

    public Optional<Day> findDate(LocalDate date) {
        return daysRepository.findByCreatedDay(date);
    }

    public List<Entry> getAllDays() {
//        List<Entry> entries = new ArrayList<>();
//
//        Day day = new Day(LocalDate.now());
//        entries.add(new Entry(day));
//        entries.add(new Entry(day));
//
//        day = new Day(LocalDate.of(2018, 12, 12));
//        entries.add(new Entry(day));
//
//        return entries;
        return entriesRepository.findAll();

    }

}
