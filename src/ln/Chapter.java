/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ln;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Ondřej Kosour
 */
public class Chapter {
    
    protected ArrayList<Chara> charas;
    protected String backgroud;

    public Chapter(File curDir, BufferedReader br, Book ln) {
        charas =  new ArrayList<>();
        init(curDir, br, ln);
    }

    private void init(File curDir, BufferedReader br, Book ln) {
        
        try {
            
            String s = br.readLine();
            if (!s.contains("{")) {
                br = new BufferedReader(new FileReader(curDir));
                return;
            }
            
            while (!s.contains("}")) {
                
                String charName;
                String charSpr;
                
                s = br.readLine();
                charName = s;
                
                s = br.readLine();
                if (s == null) break;
                charSpr = s;
                
                charas.add(new Chara(charName, charSpr));
                
                s = br.readLine();
            }
            
        } catch (IOException ex) {
            System.out.println("ERROR: File not found");
        }
        
        for (Chara lnChara: ln.getChars()) {
            if (!charas.contains(lnChara))
                charas.add(lnChara);
                
        }
    }
    
    public boolean areCharsEmpty() {
        return charas.isEmpty();
    }

    public Chara getCharaByName(String actorName) {
        
        for (Chara chr: charas)
            if (chr.getName().equals(actorName))
                return chr;
        
        return null;
    }
    
}
