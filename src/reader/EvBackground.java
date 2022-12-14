/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reader;

/**
 *
 * @author Ondřej Kosour
 */
public class EvBackground extends Event {

    public EvBackground() {
        super("b");
    }

    @Override
    public void changeState(String command, State currentState) {
        System.out.println("Reading background: " + command);
        currentState.setBackground(command);
        currentState.setDuringImage(false);
    }
    
    
}
