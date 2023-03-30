/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        evCl = new EventCaller();
        loadSave(saveFile);
        guiWindow = new GUI(this, ln, currentState);
        progress();
    }

    
    private void loadSave(File saveFile) {
        if (!saveFile.isFile()) {
            loadChapter(ln.getStart());
            return;
        }
        
        try {
            var initBread = new BufferedReader(new FileReader(saveFile));
            String scriptName;
            int lines;
            
            // Skip comments
            readNLines(initBread, 3);
            
            // Read current script
            String s = initBread.readLine();
            scriptName = s;
            
            // Read current line
            readNLines(initBread, 1);
            s = initBread.readLine();
            lines = Integer.parseInt(s.substring(s.indexOf(' ') + 1));
            
            // Init chapter for characters
            var scriptFile = new File(ln.getDirectory() + "/script/" + scriptName);
            loadChapter(scriptFile);
            
            // Skip lines
            readNLines(bread, lines - 1, currentState);
            
            // Read scene state
            readNLines(initBread, 2);
            s = initBread.readLine();
            while (!s.isBlank()) {
                evCl.process("<c>" + s, currentState);
                s = initBread.readLine();
            }
            
            // Read actor info
            readNLines(initBread, 2);
            s = initBread.readLine();
            currentState.setActor(s);
            
            readNLines(initBread, 1);
            s = initBread.readLine();
            currentState.setDuringNarration(s.equals("True"));
            
            readNLines(initBread, 1);
            s = initBread.readLine();
            currentState.setDuringSolo(s.equals("True"));
            
            // Read background and image
            readNLines(initBread, 3);
            s = "<b>" + initBread.readLine();
            evCl.process(s, currentState);
            
            readNLines(initBread, 1);
            s = initBread.readLine();
            if (!s.isBlank()) {
                s = "<i>" + s;
                evCl.process(s, currentState);
            }
            
        } catch (FileNotFoundException e) {
            ;
        } catch (IOException e) {
            ;
        }
    }
    
    public void createSave() {
        
        String checksum = Novel.getChecksum(ln.getDirectory());
        String saveDirPath = System.getProperty("user.home");
        String osName = System.getProperty("os.name");
        if (osName.contains(" ")) {
            osName = osName.substring(0, osName.indexOf(' '));
        }
            
        switch (osName) {
            case "Windows"  -> saveDirPath += "/AppData/Roaming/VNReader/saves/";
            case "Linux"    -> saveDirPath += "/.vnreader/";
            default         -> saveDirPath += "/.vnreader/";
        }
        
        saveDirPath += checksum;
        new File(saveDirPath).mkdirs();
        
        saveDirPath += "/"
                + ln.getTitle()
                        .replace(' ', '-') + '_'
                + java.time.LocalTime.now()
                        .toString()
                        .replace(':', '-')
                + ".sav";

        var savePath = new File(saveDirPath);
        
        try {
            var saveBwrit = new BufferedWriter(new FileWriter(savePath, false));
            
            // Comments
            String s = """
                       /// VNReader save
                       /// Current script file and line
                       // Script
                       """;
            saveBwrit.write(s);
            saveBwrit.write(currentScript.getName());
            saveBwrit.newLine();
            saveBwrit.write("// Line");
            saveBwrit.newLine();
            saveBwrit.write(Integer.toString(currentState.getCurrentLine()));
            saveBwrit.newLine();
            saveBwrit.newLine();
            
            saveBwrit.write("/// All scene characters");
            saveBwrit.newLine();
            for (int i = 0; i < currentState.getSceneLength(); i++) {
                if (currentState.getSceneChar(i) != null) {
                    saveBwrit.write(currentState.getSceneChar(i).getName());
                    saveBwrit.newLine();
                }
            }
            saveBwrit.newLine();
            
            saveBwrit.write("/// Actor info");
            saveBwrit.newLine();
            saveBwrit.write("// Actor");
            saveBwrit.newLine();
            saveBwrit.write(currentState.getActor().getName());
            saveBwrit.newLine();
            saveBwrit.write("// Narration");
            saveBwrit.newLine();
            saveBwrit.write((currentState.isDuringNarration())? "True" : "False");
            saveBwrit.newLine();
            saveBwrit.write("// Solo");
            saveBwrit.newLine();
            saveBwrit.write((currentState.isDuringSolo())? "True" : "False");
            saveBwrit.newLine();
            saveBwrit.newLine();
            
            saveBwrit.write("/// Background and image");
            saveBwrit.newLine();
            saveBwrit.write("// Background");
            saveBwrit.newLine();
            saveBwrit.write(currentState.getBackgroundName());
            saveBwrit.newLine();
            saveBwrit.write("// Image");
            saveBwrit.newLine();
            if (currentState.isDuringImage()) {
                saveBwrit.write(currentState.getImageName());
            } else {
                saveBwrit.newLine();
            }
            
            saveBwrit.close();
            
        } catch (FileNotFoundException e) {
            ;
        } catch (IOException e) {
            ;
        }
    }
    
    private void loadChapter(File newScript) {
        try {
            bread = new BufferedReader(new FileReader(newScript));
            currentScript = newScript;
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Chapter not found");
        }

        chpt = new Chapter(currentScript, bread, ln);
        System.out.println("Playing chapter: " + currentScript.getAbsolutePath());
        
        currentState = new State(chpt, ln.getDirectory().getAbsolutePath(), playerName);
        loadingEvents = true;
    }
    
    public void progress() {
        
        try {
            
            while (!loadingEvents) {
                
                readingLine = bread.readLine();
                currentState.redALine();
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
                currentState.redALine();
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
    
    private void readNLines(BufferedReader br, int n) {
        for (int i = 0; i < n; i++) {
            try {
                br.readLine();
            } catch (IOException ex) {
                System.out.println("ERROR: Can't skip lines");;
            }
        }
    }
    
    private void readNLines(BufferedReader br, int n, State currSt) {
        try {
            for (int i = 0; i < n; i++) {
                br.readLine();
                currSt.redALine();
            }
        } catch (IOException ex) {
            System.out.println("ERROR: Can't skip lines");
        }
    }
    
    private void printFile(File input) {
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
