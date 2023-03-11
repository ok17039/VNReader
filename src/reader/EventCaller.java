/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reader;

import java.util.ArrayList;

/**
 * Volá objekty značek ve scénáři
 * @author Ondřej Kosour
 */
public class EventCaller {
    
    protected ArrayList<Event> events;

    public EventCaller() {
        events = new ArrayList<>();
        events.add(new EvCharacter());
        events.add(new EvBackground());
        events.add(new EvNarration());
        events.add(new EvImage());
        events.add(new EvEnd());
        events.add(new EvNext());
        
    }
    
    public void process(String line, State currentState) {
        String tag = line.substring(line.indexOf('<') + 1, line.indexOf('>'));
        String command = line.substring(line.indexOf('>') + 1);
        
        // System.out.println(tag);
        // System.out.println(line.substring(line.indexOf('>') + 1));
        
        for (var evs: events) {
            if (evs.getTag().equalsIgnoreCase(tag)) {
                evs.changeState(command, currentState);
            }
        }
    }
}
