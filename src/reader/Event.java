/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reader;

/**
 *
 * @author Ondřej Kosour
 */
public abstract class Event {
    String tag;

    public Event(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public abstract void changeState(String command, State currentState);
    
}
