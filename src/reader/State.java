/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reader;

import java.util.ArrayList;
import ln.Chapter;
import ln.Chara;

/**
 *
 * @author Ondřej Kosour
 */
public class State {
    
    protected String background;
    protected String image;
    
    protected ArrayList<Chara> scene;
    protected Chara actor;
    protected String peekingChar;
            
    protected String text;
    protected String pastText;
    
    protected String playerName;
    
    protected Chapter chapt;
    protected String lnDir;
    
    protected boolean duringSolo;
    protected boolean duringNarration;
    protected boolean duringImage;
    
    protected boolean reachedEnd;

    public State(Chapter chapt, String lnDir, String playerName) {
        background = "black";
        scene = new ArrayList<>();
        peekingChar = null;
        duringSolo = false;
        this.chapt = chapt;
        this.lnDir = lnDir;
        this.playerName = playerName;
        reachedEnd = false;
    }


    // Getters
    public String getBackground() {
        return lnDir + "\\res\\bg\\" + background;
    }

    public String getImage() {
        return lnDir + "\\res\\img\\" + image;
    }

    
    public Chara getSceneChar(int place) {
        return scene.get(place);
    }
    
    public int getSceneLength() {
        return scene.size();
    }
    
    public Chara getActor() {
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

    
    public boolean reachedEnd() {
        return reachedEnd;
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
        
        var chara = chapt.getCharaByName(charName);
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
        
        var chara = chapt.getCharaByName(charName);
        if (chara == null) {
            System.out.println("ERROR: No such chara to delete: \"" + charName + "\"");
            return;
        }
        
        this.scene.remove(chara);
    }
    
    public void setActor(String actorName) {
        if (chapt.getCharaByName(actorName) != null) {
            this.actor = chapt.getCharaByName(actorName);
        } else {
            this.actor = new Chara(actorName, "");
        }
    }

    public void setPeekingChar(String peekingChar) {
        this.peekingChar = peekingChar;
    }
    
    
    public void setText(String text) {
        pastText += (actor.getName().isBlank()) ? "\n" + this.text : "\n" + actor.getName() + ": " + this.text;
        this.text = text;
    }

    
    public void setReachedEnd(boolean reachedEnd) {
        this.reachedEnd = reachedEnd;
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
