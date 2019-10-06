package com.spartez.interviews.eventsystem.impl;

import com.spartez.interviews.eventsystem.Event;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BasicEvent implements Event {
    private String content;
}
