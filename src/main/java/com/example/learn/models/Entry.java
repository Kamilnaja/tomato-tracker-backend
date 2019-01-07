package com.example.learn.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
@Table(name = "entries")
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp = new Date();

    @ManyToOne(targetEntity = Day.class)
    private Day day;

    public Entry() {
    }

    public Entry(Day day) {
        this.day = day;
    }

    public String getTimestampAsString() {
        if (timestamp == null) {
            return null;
        }
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").format(timestamp);
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getDayAsString() {
        return day.getCreatedDay().toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }
}
