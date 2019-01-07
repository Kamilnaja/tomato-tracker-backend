package com.example.learn.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
@Table(name = "days")
public class Day {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, updatable = false)
    private LocalDate createdDay;

    @OneToMany(targetEntity = Entry.class, mappedBy = "day")
    private List<Entry> entryList;

    public Day() {
        this.createdDay = LocalDate.now();
    }

    public Day(LocalDate date) {
        this.createdDay = date;
    }

    @Override
    public String toString() {
        return "Day{" +
                "id=" + id +
                ", createdDay=" + createdDay +
                ", entryList=" + entryList +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Entry> getEntryList() {
        return entryList;
    }

    public void setEntryList(List<Entry> entryList) {
        this.entryList = entryList;
    }

    public LocalDate getCreatedDay() {
        return createdDay;
    }

    public void setCreatedDay(LocalDate createdDay) {
        this.createdDay = createdDay;
    }
}
