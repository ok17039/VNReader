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

    protected ArrayList<Character> charas;
    protected String name;

    public Chapter(File curScript, BufferedReader br, Novel ln) {
        charas = new ArrayList<>();
        name = curScript.getName().substring(0, curScript.getName().lastIndexOf('.'));
        init(curScript, br, ln);
    }

    private void init(File curScript, BufferedReader br, Novel ln) {

        try {

            String s = br.readLine();
            if (!s.contains("{")) {
                br.close();
                br = new BufferedReader(new FileReader(curScript));
                return;
            }

            while (!s.contains("}")) {

                String charName;
                String charSpr;

                s = br.readLine();
                charName = s;

                s = br.readLine();
                if (s == null) {
                    break;
                }
                charSpr = s;

                charas.add(new Character(charName, charSpr));

                s = br.readLine();
            }

        } catch (IOException ex) {
            System.out.println("ERROR: File not found");
        }

        for (Character lnChara : ln.getChars()) {
            if (!charas.contains(lnChara)) {
                charas.add(lnChara);
            }

        }
    }

    public boolean areCharsEmpty() {
        return charas.isEmpty();
    }

    public Character getCharaByName(String actorName) {

        for (Character chr : charas) {
            if (chr.getName().equals(actorName)) {
                return chr;
            }
        }

        return null;
    }

    public String getName() {
        return name;
    }

}
