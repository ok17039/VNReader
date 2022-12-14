/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reader;

/**
 *
 * @author Ondřej Kosour
 */
public class EvNarration extends Event {
    
    public EvNarration() {
        super("nar");
    }

    @Override
    public void changeState(String line, State currentState) {
        currentState.setDuringNarration(true);
    }
    
}
