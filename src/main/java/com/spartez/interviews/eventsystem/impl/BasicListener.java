package com.spartez.interviews.eventsystem.impl;

import com.spartez.interviews.eventsystem.Event;
import com.spartez.interviews.eventsystem.EventListener;

import java.util.ArrayList;
import java.util.List;

public class BasicListener implements EventListener {
    @Override
    public void handleEvent(Event event) {
        System.out.println("I handled this event!");
    }

    @Override
    public List<Event> getHandledEventClasses() {
        List<Event> eventList = new ArrayList<>();
        eventList.add(new BasicEvent("basic message"));

        return eventList;
    }
}
