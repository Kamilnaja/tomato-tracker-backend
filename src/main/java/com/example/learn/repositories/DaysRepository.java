package com.example.learn.repositories;

import com.example.learn.models.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface DaysRepository extends JpaRepository<Day, Long> {

    Optional<Day> findByCreatedDay(LocalDate date);
}
