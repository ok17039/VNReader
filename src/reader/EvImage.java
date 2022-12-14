/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reader;

/**
 *
 * @author HexxTheSwagger
 */
public class EvImage extends Event {

    public EvImage() {
        super("i");
    }

    @Override
    public void changeState(String command, State currentState) {
        
        if (command.isBlank()) {
            System.out.println("Removing image");
            currentState.setDuringImage(false);
        } else {
            System.out.println("Reading image: " + command);
            currentState.setDuringImage(true);
        }
        
        currentState.setImage(command);
    }
    
}
