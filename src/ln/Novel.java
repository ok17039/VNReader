/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ln;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Ondřej Kosour
 */
public class Novel {
    
    protected File directory;
    
    protected String title;
    protected String writer;
    protected String illust;
    protected File start;
    
    protected File save;
    
    protected ArrayList<Character> charas;

    public Novel(File dir) {
        directory = dir;
        charas = new ArrayList<>();
        init(dir);
    }
    
    
    private void init(File dir) {
        
        String infoPath = dir.getAbsolutePath() + "/info.txt";
        System.out.println(infoPath);
        
        try {
            BufferedReader bread = new BufferedReader(new FileReader(infoPath));
            
            title = bread.readLine().substring(7);
            writer = bread.readLine().substring(8);
            illust = bread.readLine().substring(8);
            start = new File(dir.getAbsolutePath() + "/script/" +  bread.readLine().substring(7));
            
            String s = bread.readLine();
            

            while (s != null) {
                
                String charName;
                String charDefSpr;
                
                s = bread.readLine();
                if (s == null) break;
                charName = s;
                
                s = bread.readLine();
                if (s == null) break;
                charDefSpr = s;
                
                charas.add(new Character(charName, charDefSpr));
                
                s = bread.readLine();
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found");
            
        } catch (IOException e) {
            System.out.println("ERROR: File can't be read");
        }
        
    }

    
    public File getDirectory() {
        return directory;
    }

    public String getTitle() {
        return title;
    }

    public String getWriter() {
        return writer;
    }

    public String getIllust() {
        return illust;
    }
    
    public File getStart() {
        return start;
    }

    
    public ArrayList<Character> getChars() {
        return charas;
    }

    
    /**
     * Reads the novel name from info.txt
     * @param dir Novel directory
     * @return Novel name
     */
    public static String getTitle(File dir) {
        
        String title = "Open a Visual Novel";
        
        String infoPath = dir.getAbsolutePath() + "/info.txt";
        System.out.println(infoPath);
        
        try {
            BufferedReader bread = new BufferedReader(new FileReader(infoPath));
            String s = bread.readLine();
            if (s != null){
                title = s.substring(7);
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found");
            
        } catch (IOException e) {
            System.out.println("ERROR: File can't be read");
        }
        
        return title;
    }
}
