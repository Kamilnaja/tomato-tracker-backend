package com.example.learn.models;

import java.time.LocalDateTime;

public class AddEntryRequest {
    private LocalDateTime time;

    public AddEntryRequest() {
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "AddEntryRequest{" +
                "time=" + time +
                '}';
    }
}
