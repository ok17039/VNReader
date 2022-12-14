/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reader;

/**
 *
 * @author Ondřej Kosour
 */
public class EvEnd extends Event {

    public EvEnd() {
        super("end");
    }

    @Override
    public void changeState(String line, State currentState) {
        currentState.setReachedEnd(true);
    }
    
}

# CAUSING MISCHIEF HERE VERY BAD