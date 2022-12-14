/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import ln.Book;
import ln.Chapter;

/**
 *
 * @author Ondřej Kosour
 */
public class Reader {

    protected Book ln;
    protected Chapter chpt;
    protected String playerName;
    
    protected State currentState;
    protected Boolean loadingEvents;
    protected String readingLine;
    
    protected File currentScript;
    BufferedReader bread;
    EventCaller evCl;
    
    GUI guiWindow;
    
    public Reader(File lnDir, String pName) {
        init(lnDir, pName);
    }

    private void init(File lnDir, String plaName) {
        ln = new Book(lnDir);
        currentScript = ln.getStart();
        playerName = plaName;

        try {
            bread = new BufferedReader(new FileReader(currentScript));
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found");
        }
        
        chpt = new Chapter(currentScript, bread, ln);
        
        System.out.println(currentScript.getAbsolutePath());
        
        //printFile(currentScript);
        
        currentState = new State(chpt, lnDir.getAbsolutePath(), playerName);
        loadingEvents = true;
        
        evCl = new EventCaller();
        
        guiWindow = new GUI(this, lnDir.getAbsolutePath(), ln);
    }
    
    public void progress() {
        
        try {
            
            while (!loadingEvents) {
                
                readingLine = bread.readLine();
                
                if (readingLine.isBlank()) {
                    loadingEvents = true;
                
                } else if (readingLine.startsWith("//")) {
                    continue;
                    
                } else {
                    currentState.setText(readingLine);
                    guiWindow.update(currentState);
                    break;
                }
            }
            
            while (loadingEvents) {
                
                readingLine = bread.readLine();

                if (readingLine.startsWith("<")) {
                    evCl.process(readingLine, currentState);
                    if (currentState.reachedEnd()) {
                        end();
                        return;
                    }
                    
                } else if (readingLine.isBlank()) {
                    continue;
                
                } else if (readingLine.startsWith("//")) {
                    continue;
                    
                } else {
                    currentState.setText(readingLine);
                    loadingEvents = false;
                    guiWindow.update(currentState);
                }
            }
            
        } catch (IOException e) {
            System.out.println("ERROR: File can't be read");
        }
        
        // System.out.println((currentState.getActor().getName().isBlank()) ? currentState.getText() : currentState.getActor().getName() + ": " + currentState.getText());
        
        /*System.out.println("--| Queue |--");
        for (int i = 0; i < currentState.getSceneLength(); i++) {
            System.out.println(currentState.getSceneChar(i).getName());
        }
        System.out.println("-------------");*/
    }
    
    public void end() {
        guiWindow.end(ln);
    }
    
    public void printFile(File input) {
        try {
            BufferedReader brd = new BufferedReader(new FileReader(input));
            String s;
            while ((s = brd.readLine()) != null)
                System.out.println(s);

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Soubor nebyl nenalezen");
            
        } catch (IOException e) {
            System.out.println("ERROR: Soubor nelze číst");
        }
    }
    
}
