package com.example.learn.repositories;

import com.example.learn.models.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntriesRepository extends JpaRepository<Entry, Long> {
}
