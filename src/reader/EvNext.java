/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reader;

/**
 *
 * @author Ondřej Kosour
 */
public class EvNext extends Event {

    public EvNext() {
        super("next");
    }
    
    @Override
    public void changeState(String command, State currentState) {
        currentState.setNextChapterDir(command);
        currentState.setReachedChapterEnd();
        System.out.println("Loading new chapter: " + command);
    }
    
}
