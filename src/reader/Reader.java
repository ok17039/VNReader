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
import ln.Novel;
import ln.Chapter;

/**
 *
 * @author Ondřej Kosour
 */
public class Reader {

    protected Novel ln;
    protected Chapter chpt;
    protected String playerName;
    
    protected State currentState;
    protected Boolean loadingEvents;
    protected String readingLine;
    
    protected File currentScript;
    BufferedReader bread;
    EventCaller evCl;
    
    GUI guiWindow;
    
    public Reader(Novel ln, String playerName, File saveFile) {
        this.playerName = playerName;
        this.ln = ln;
        loadSave(saveFile);
        init();
    }

    private void init() {
        evCl = new EventCaller();
        
        guiWindow = new GUI(this, ln, currentState);
    }

    private void loadSave(File saveFile) {
        if (!saveFile.isFile()) {
            loadChapter(ln.getStart());
            return;
        }
        
        
    }
    
    public void loadChapter(File newScript) {
        try {
            bread = new BufferedReader(new FileReader(newScript));
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Chapter not found");
        }
        
        currentScript = newScript;

        chpt = new Chapter(currentScript, bread, ln);
        System.out.println("Playing chapter: " + currentScript.getAbsolutePath());
        // printFile(currentScript);
        
        currentState = new State(chpt, ln.getDirectory().getAbsolutePath(), playerName);
        loadingEvents = true;
    }
    
    public void progress() {
        
        try {
            
            while (!loadingEvents) {
                
                readingLine = bread.readLine();
                //System.out.println("Current line: " + readingLine);
                
                if (readingLine.isBlank()) {
                    loadingEvents = true;
                
                } else if (readingLine.startsWith("//")) {
                    continue;
                    
                } else {
                    currentState.setText(readingLine, true);
                    guiWindow.update();
                    break;
                }
            }
            
            while (loadingEvents) {
                
                readingLine = bread.readLine();
                //System.out.println("Current line: " + readingLine);
                // if (readingLine == null) return;

                if (readingLine.startsWith("<")) {
                    evCl.process(readingLine, currentState);
                    if (currentState.reachedNovelEnd()) {
                        end();
                        return;
                    }
                    if (currentState.reachedChapterEnd()) {
                        loadChapter(new File(ln.getDirectory() + "/script/" + currentState.getNextChapterDir()));
                        guiWindow.nextChapter(currentState, currentScript, ln);
                        return;
                    }
                    
                } else if (readingLine.isBlank()) {
                    continue;
                
                } else if (readingLine.startsWith("//")) {
                    continue;
                    
                } else {
                    currentState.setText(readingLine, true);
                    loadingEvents = false;
                    guiWindow.update();
                }
            }
            
        } catch (IOException e) {
            System.out.println("ERROR: File can't be read");
        }
    }
    
    public void end() {
        guiWindow.end(ln, currentScript);
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
