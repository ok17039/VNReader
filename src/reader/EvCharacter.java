/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reader;

/**
 *
 * @author Ondřej Kosour
 */
public class EvCharacter extends Event {

    public EvCharacter() {
        super("c");
    }

    @Override
    public void changeState(String command, State currentState) {
        
        String attrib1;
        String attrib2;
        String charName;
        
        int position = -1;
        
        if (command.matches("<[^>]*>.*")) {
            attrib1 = command.substring(command.indexOf('<') + 1, command.indexOf('>'));
            command = command.substring(command.indexOf('>') + 1);
            
            if (command.matches("<[^>]*>.*")) {
                attrib2 = command.substring(command.indexOf('<') + 1, command.indexOf('>'));
                charName = command.substring(command.indexOf('>') + 1);
            
            } else {
                attrib2 = "";
                charName = command;
            }
            
        } else {
            attrib1 = "";
            attrib2 = "";
            charName = command;
        }
        
        
        if (!charName.equals(currentState.getPeekingChar()) && currentState.getPeekingChar() != null) {
            
            currentState.remSceneChar(currentState.getPeekingChar());
            currentState.setPeekingChar(null);
        }
        
        // System.out.println("Reading attribute: " + attrib);
        // System.out.println("Reading character: " + charName);
        
        if (attrib1.equalsIgnoreCase("remove")) {
            currentState.remSceneChar(charName);
            return;
            
        } else if (!attrib1.isBlank() && !attrib1.equalsIgnoreCase("ghost") && !attrib1.equalsIgnoreCase("solo") && !attrib1.equalsIgnoreCase("peek")) {
            position = Integer.parseInt(attrib1);
            
        } 
        
        if (!attrib2.isBlank() && !attrib2.equalsIgnoreCase("ghost") && !attrib2.equalsIgnoreCase("solo") && !attrib2.equalsIgnoreCase("peek")) {
            position = Integer.parseInt(attrib2);
            
        }
        
        if (attrib1.equalsIgnoreCase("peek") || attrib2.equalsIgnoreCase("peek"))
            currentState.setPeekingChar(charName);
        
        if (attrib1.equalsIgnoreCase("solo") || attrib2.equalsIgnoreCase("solo"))
            currentState.setDuringSolo(true);
        else
            currentState.setDuringSolo(false);
        
        if (!attrib1.equalsIgnoreCase("ghost") && !attrib2.equalsIgnoreCase("ghost"))
            if (position > 0)
                currentState.putSceneChar(charName, position);
            else
                currentState.putSceneChar(charName);
        
        
        currentState.setActor(charName);
    }
    
}
