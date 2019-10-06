package com.spartez.interviews.eventsystem.impl;


import com.spartez.interviews.eventsystem.Event;
import com.spartez.interviews.eventsystem.EventListener;
import com.spartez.interviews.eventsystem.EventManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Simplistic implementation for project structure illustration only.
 *
 * <p>This is <b>not</b> the code you will be working on.
 *
 * <p>When the test starts you will receive a different copy of the project that will contain a much more advanced
 * implementation of the EventManager.
 * It will still be relatively simple (under 100 lines of code in the class) but in contrast to this example class
 * it will actually implement the contract.
 */
public class SimpleEventManager implements EventManager {

    private Map<Event, List<EventListener>> listeners = new HashMap<>();


    @Override
    public void publishEvent(Event event) {
        listeners.get(event).forEach(listener -> listener.handleEvent(event));
    }

    @Override
    public void registerListener(String listenerKey, EventListener listener) {
        for (Event specificEvent : listener.getHandledEventClasses()) {
            if (listeners.containsKey(specificEvent)) {
                listeners.get(specificEvent).add(listener);
            } else {
                listeners.put(specificEvent, new ArrayList<>());
                listeners.get(specificEvent).add(listener);
            }
        }

    }

    @Override
    public void unregisterListener(String listenerKey, EventListener listener) {
        for (Event handledEventClass : listener.getHandledEventClasses()) {
            if (listeners.containsKey(handledEventClass)) {
                listeners.get(handledEventClass).remove(listener);
            }
        }
    }
}
