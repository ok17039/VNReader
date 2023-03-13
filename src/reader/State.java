/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reader;

import java.io.File;
import java.util.ArrayList;
import ln.Chapter;
import ln.Character;

/**
 *
 * @author Ondřej Kosour
 */
public class State {
    
    protected String background;
    protected String image;
    
    protected ArrayList<Character> scene;
    protected Character actor;
    protected String peekingChar;
            
    protected String text;
    protected String pastText;
    
    protected String playerName;
    
    protected Chapter chapter;
    protected String lnDir;
    protected String chPath;
    protected String nextChDir;
    
    protected boolean duringSolo;
    protected boolean duringNarration;
    protected boolean duringImage;
    
    protected boolean reachedNovelEnd;
    protected boolean reachedChapterEnd;

    public State(Chapter chapt, String lnDir, String playerName) {
        background = "black";
        scene = new ArrayList<>();
        peekingChar = null;
        duringSolo = false;
        this.chapter = chapt;
        this.lnDir = lnDir;
        this.playerName = playerName;
        reachedNovelEnd = false;
        reachedChapterEnd = false;
    }


    // Getters
    public String getBackground() {
        String bgPath = lnDir + "/res/bg/" + chapter.getName() + '/' + background;
        
        var bg = new File(bgPath);
        
        if (bg.isFile()) {
            return bgPath;
        } else {
            return lnDir + "/res/bg/" + background;
        }
    }

    public String getImage() {
        String imgPath = lnDir + "/res/img/" + chapter.getName() + '/' + image;
        
        var img = new File(imgPath);
        
        if (img.isFile()) {
            return imgPath;
        } else {
            return lnDir + "/res/img/" + image;
        }
    }

    
    public Character getSceneChar(int place) {
        return scene.get(place);
    }
    
    public int getSceneLength() {
        return scene.size();
    }
    
    public Character getActor() {
        return actor;
    }

    public String getPeekingChar() {
        return peekingChar;
    }
    
    
    public String getText() {
        return text;
    }
    
    public String getPastText() {
        return pastText;
    }
    

    public String getPlayerName() {
        return playerName;
    }

    
    public String getLnDir() {
        return lnDir;
    }

    
    public boolean reachedNovelEnd() {
        return reachedNovelEnd;
    }
    
    public boolean reachedChapterEnd() {
        return reachedChapterEnd;
    }
    
    public String getNextChapterDir() {
        return nextChDir;
    }

    
    public boolean isDuringSolo() {
        return duringSolo;
    }

    public boolean isDuringNarration() {
        return duringNarration;
    }

    public boolean isDuringImage() {
        return duringImage;
    }

    
    // Setters
    public void setBackground(String background) {
        this.background = background;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
    public void putSceneChar(String charName) {
        putSceneChar(charName, 5);
    }

    public void putSceneChar(String charName, int place) {
        
        var chara = chapter.getCharaByName(charName);
        if (chara == null) {
            System.out.println("ERROR: No such chara to add: \"" + charName + "\"");
            return;
        }
        
        int index = place - 1;

        if (!scene.contains(chara)) {
            
            if (place > scene.size())
                scene.add(chara);
            else
                scene.add(index, chara);
        }
        
        if (scene.size() == 5) {
            if (place > 2)
                scene.remove(0);
            else
                scene.remove(4);
                
        }
    }

    public void remSceneChar(String charName) {
        
        var chara = chapter.getCharaByName(charName);
        if (chara == null) {
            System.out.println("ERROR: No such chara to delete: \"" + charName + "\"");
            return;
        }
        
        this.scene.remove(chara);
    }
    
    public void setActor(String actorName) {
        if (chapter.getCharaByName(actorName) != null) {
            this.actor = chapter.getCharaByName(actorName);
        } else {
            this.actor = new Character(actorName, "");
        }
    }

    public void setPeekingChar(String peekingChar) {
        this.peekingChar = peekingChar;
    }
    
    
    public void setText(String text, boolean shouldWriteTotranscript) {
        if (shouldWriteTotranscript && actor != null) {
            pastText += (actor.getName().isBlank()) ? "\n" + this.text : "\n" + actor.getName() + ": " + this.text;
        }
        this.text = text;
    }

    
    public void setReachedNovelEnd() {
        this.reachedNovelEnd = true;
    }
    
    public void setReachedChapterEnd() {
        this.reachedChapterEnd = true;
    }
    
    public void setNextChapterDir(String nextChDir) {
        this.nextChDir = nextChDir;
    }
    
    
    public void setDuringSolo(boolean duringSolo) {
        this.duringSolo = duringSolo;
    }

    public void setDuringNarration(boolean duringNarration) {
        this.duringNarration = duringNarration;
    }

    public void setDuringImage(boolean duringImage) {
        this.duringImage = duringImage;
    }
    
    
}
