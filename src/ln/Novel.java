/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ln;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
            start = new File(dir.getAbsolutePath() + "/script/" + bread.readLine().substring(7));

            String s = bread.readLine();

            while (s != null) {

                String charName;
                String charDefSpr;

                s = bread.readLine();
                if (s == null) {
                    break;
                }
                charName = s;

                s = bread.readLine();
                if (s == null) {
                    break;
                }
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
     *
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
            if (s != null) {
                title = s.substring(7);
            }

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found");

        } catch (IOException e) {
            System.out.println("ERROR: File can't be read");
        }

        return title;
    }

    /**
     * Get a hash of the passed Light Novel's info.txt file
     * https://howtodoinjava.com/java/java-security/sha-md5-file-checksum-hash/
     * 
     * @param lnDir Novel directory
     * @return Novel hash
     */
    public static String getChecksum(File lnDir) {

        String path = lnDir.getAbsolutePath() + "/info.txt";
        var info = new File(path);
        
        try {
            //Get file input stream for reading the file content
            FileInputStream fis = new FileInputStream(info);

            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            //Create byte array to read data in chunks
            byte[] byteArray = new byte[1024];
            int bytesCount = 0;

            //Read file data and update in message digest
            while ((bytesCount = fis.read(byteArray)) != -1) {
                digest.update(byteArray, 0, bytesCount);
            }

            //close the stream; We don't need it now.
            fis.close();

            //Get the hash's bytes
            byte[] bytes = digest.digest();

            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            
            //return complete hash
            return sb.toString();
            
        } catch (IOException e) {
            System.out.println("ERROR: File can't be read");
            
        } catch (NoSuchAlgorithmException e) {
            System.out.println("ERROR: \"Sha-256\" is not avalible");

        }

        return "ERROR";
    }
}
