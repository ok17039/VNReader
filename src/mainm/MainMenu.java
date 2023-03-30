/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mainm;

import com.formdev.flatlaf.FlatLightLaf;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.DateFormatter;
import ln.Novel;
import reader.Reader;

/**
 *
 * @author Ondřej Kosour
 */
public class MainMenu extends javax.swing.JFrame {

    private File lnDir;
    private Novel ln;
    
    private String playerName;
    private Boolean textFieldHasPlaceholder;
    
    private File configFile;
    private File saveFile;
    
    private Boolean loadedSave;
    
    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        playerName = "Player";
        textFieldHasPlaceholder = true;
        loadedSave = false;
        
        initComponents();
        loadConfig();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitleCont = new javax.swing.JPanel();
        TitleLabel_Right = new javax.swing.JLabel();
        TitleLabel_Left = new javax.swing.JLabel();
        Title_Ver = new javax.swing.JLabel();
        Title_Line = new javax.swing.JSeparator();
        Menu = new javax.swing.JPanel();
        Menu_SelectedLN = new javax.swing.JLabel();
        Menu_Play = new javax.swing.JButton();
        Menu_Open = new javax.swing.JButton();
        Menu_PlayerNameLabel = new javax.swing.JLabel();
        Menu_PlayerName = new javax.swing.JLabel();
        Menu_PlayerNameBox = new javax.swing.JTextField();
        Menu_SaveName = new javax.swing.JButton();
        Menu_Exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));

        TitleCont.setMaximumSize(new java.awt.Dimension(220, 100));
        TitleCont.setMinimumSize(new java.awt.Dimension(220, 100));
        TitleCont.setName(""); // NOI18N

        TitleLabel_Right.setFont(new java.awt.Font("Baskerville Old Face", 2, 52)); // NOI18N
        TitleLabel_Right.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TitleLabel_Right.setText("VN");
        TitleLabel_Right.setMaximumSize(new java.awt.Dimension(100, 50));
        TitleLabel_Right.setMinimumSize(new java.awt.Dimension(100, 50));
        TitleLabel_Right.setPreferredSize(new java.awt.Dimension(100, 50));

        TitleLabel_Left.setFont(new java.awt.Font("Baskerville Old Face", 2, 36)); // NOI18N
        TitleLabel_Left.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TitleLabel_Left.setText("Reader");
        TitleLabel_Left.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        TitleLabel_Left.setMaximumSize(new java.awt.Dimension(100, 50));
        TitleLabel_Left.setMinimumSize(new java.awt.Dimension(100, 50));
        TitleLabel_Left.setPreferredSize(new java.awt.Dimension(100, 50));

        Title_Ver.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        Title_Ver.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Title_Ver.setText("ver. 1.3");
        Title_Ver.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Title_Ver.setMaximumSize(new java.awt.Dimension(100, 50));
        Title_Ver.setMinimumSize(new java.awt.Dimension(100, 50));
        Title_Ver.setPreferredSize(new java.awt.Dimension(100, 50));

        javax.swing.GroupLayout TitleContLayout = new javax.swing.GroupLayout(TitleCont);
        TitleCont.setLayout(TitleContLayout);
        TitleContLayout.setHorizontalGroup(
            TitleContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitleContLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TitleContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Title_Line)
                    .addGroup(TitleContLayout.createSequentialGroup()
                        .addComponent(TitleLabel_Right, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TitleLabel_Left, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Title_Ver, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        TitleContLayout.setVerticalGroup(
            TitleContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitleContLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TitleContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Title_Ver, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TitleContLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(TitleContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TitleLabel_Left, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TitleLabel_Right, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Title_Line, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Menu.setMaximumSize(new java.awt.Dimension(330, 210));
        Menu.setMinimumSize(new java.awt.Dimension(330, 210));

        Menu_SelectedLN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Menu_SelectedLN.setText("Open a Visual Novel");

        Menu_Play.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        Menu_Play.setText("Play");
        Menu_Play.setEnabled(false);
        Menu_Play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_PlayActionPerformed(evt);
            }
        });

        Menu_Open.setText("Open");
        Menu_Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_OpenActionPerformed(evt);
            }
        });

        Menu_PlayerNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Menu_PlayerNameLabel.setText("Player name");

        Menu_PlayerName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Menu_PlayerName.setForeground(new java.awt.Color(102, 102, 102));
        Menu_PlayerName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Menu_PlayerName.setText("Player");

        Menu_PlayerNameBox.setText("Enter name");
        Menu_PlayerNameBox.setAutoscrolls(false);
        Menu_PlayerNameBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Menu_PlayerNameBoxFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Menu_PlayerNameBoxFocusLost(evt);
            }
        });
        Menu_PlayerNameBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Menu_PlayerNameBoxKeyPressed(evt);
            }
        });

        Menu_SaveName.setText("Save");
        Menu_SaveName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_SaveNameActionPerformed(evt);
            }
        });

        Menu_Exit.setText("Exit");
        Menu_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_ExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Menu_SelectedLN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addComponent(Menu_Play, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Menu_Open, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(MenuLayout.createSequentialGroup()
                                .addComponent(Menu_PlayerNameLabel)
                                .addGap(18, 18, 18)
                                .addComponent(Menu_PlayerName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(Menu_PlayerNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(Menu_SaveName, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Menu_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(Menu_SelectedLN, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Menu_Play)
                    .addComponent(Menu_Open))
                .addGap(18, 18, 18)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Menu_PlayerNameLabel)
                    .addComponent(Menu_PlayerName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Menu_PlayerNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Menu_SaveName))
                .addGap(24, 24, 24)
                .addComponent(Menu_Exit)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(TitleCont, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(TitleCont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Menu_OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_OpenActionPerformed
        var fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home") + "/Downloads"));
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            
            Menu_SelectedLN.setText(Novel.getTitle(fileChooser.getSelectedFile()));
            if(!Menu_SelectedLN.getText().equals("Open a Visual Novel")) {
                
                lnDir = fileChooser.getSelectedFile();
                ln = new Novel(lnDir);
                checkSave();
                Menu_Play.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "Not a valid Visual Novel directory.");
            }
        }
    }//GEN-LAST:event_Menu_OpenActionPerformed

    private void Menu_PlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_PlayActionPerformed
        System.out.println("Writing config: " + configFile.getAbsolutePath());
        saveConfig(playerName);
        
        System.out.println("Starting: " + ln.getDirectory().getAbsolutePath());
        this.dispose();

        var lnReader = new Reader(ln, playerName, saveFile);
    }//GEN-LAST:event_Menu_PlayActionPerformed

    private void Menu_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_ExitActionPerformed
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_Menu_ExitActionPerformed

    private void Menu_SaveNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_SaveNameActionPerformed
        if(!textFieldHasPlaceholder) {
            playerName = Menu_PlayerNameBox.getText();
            Menu_PlayerName.setText(playerName);
        }
    }//GEN-LAST:event_Menu_SaveNameActionPerformed

    private void Menu_PlayerNameBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Menu_PlayerNameBoxFocusGained
        if (textFieldHasPlaceholder) {
            Menu_PlayerNameBox.setText("");
        }
    }//GEN-LAST:event_Menu_PlayerNameBoxFocusGained

    private void Menu_PlayerNameBoxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Menu_PlayerNameBoxFocusLost
        if (textFieldHasPlaceholder) {
            Menu_PlayerNameBox.setText("Enter name");
        }
    }//GEN-LAST:event_Menu_PlayerNameBoxFocusLost

    private void Menu_PlayerNameBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Menu_PlayerNameBoxKeyPressed
        textFieldHasPlaceholder = Menu_PlayerNameBox.getText().isEmpty();
    }//GEN-LAST:event_Menu_PlayerNameBoxKeyPressed

    /**
     * Loads the config file
     * @return says if the config was found successfully and loaded
     */
    private void loadConfig() {
        String configDir = System.getProperty("user.home");
        String osName = System.getProperty("os.name") + ' ';
        // System.out.println(osName);
        
        switch (osName.substring(0, osName.indexOf(' '))) {
            case "Windows"  -> configDir += "/AppData/Roaming/VNReader";
            case "Linux"    -> configDir += "/.config/VNReader";
            default         -> configDir += "/.config/VNReader";
        }
        
        // System.out.println('"' + configDir + '"');
        
        new File(configDir).mkdirs();
        configFile = new File(configDir + "/user");
        
        if (configFile.isFile()) {
            try {
                var bread = new BufferedReader(new FileReader(configFile));
                playerName = bread.readLine();
                Menu_PlayerName.setText(playerName);
                Menu_PlayerNameBox.setText(playerName);
                textFieldHasPlaceholder = false;
            
            } catch (IOException e) {
                System.out.println("ERROR: " + configFile.getAbsolutePath() + "can't be read!");
            }
        } else {
            System.out.println("No config found");
        }
    }
    
    private void saveConfig(String pName) {
        BufferedWriter bwrit;
        
        try {
            bwrit = new BufferedWriter(new FileWriter(configFile, false));
            bwrit.write(pName);
            bwrit.close();
            
        } catch (IOException e) {
            String error = "ERROR: Can't write to file " + configFile.getAbsolutePath();
            System.out.println(error);
            JOptionPane.showMessageDialog(null, error);
        }
    }
    
    private void checkSave() {
        String checksum = Novel.getChecksum(lnDir);
        
        System.out.println(checksum);
        
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
        
        var saveDir = new File(saveDirPath + checksum);
        
        if (saveDir.isDirectory()) {
            var latest = new File(saveDirPath + ln.getTitle().replace(' ', '-') + '_' + java.time.LocalTime.now().toString().replace(':', '-'));
            // 
            latest.setLastModified(0);
            
            for (File save : saveDir.listFiles()) {
                if (save.lastModified() >= latest.lastModified())
                    latest = save;
            }
            
            saveFile = latest;
            Menu_Play.setText("Continue");
            
        } else {
            saveFile = new File(saveDirPath + ln.getTitle().replace(' ', '-') + '_' + java.time.LocalTime.now().toString().replace(':', '-'));
            Menu_Play.setText("Play");
            System.out.println("No saves found");
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        FlatLightLaf.setup();
        //</editor-fold>
        //</editor-fold>
        
            
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Menu;
    private javax.swing.JButton Menu_Exit;
    private javax.swing.JButton Menu_Open;
    private javax.swing.JButton Menu_Play;
    private javax.swing.JLabel Menu_PlayerName;
    private javax.swing.JTextField Menu_PlayerNameBox;
    private javax.swing.JLabel Menu_PlayerNameLabel;
    private javax.swing.JButton Menu_SaveName;
    private javax.swing.JLabel Menu_SelectedLN;
    private javax.swing.JPanel TitleCont;
    private javax.swing.JLabel TitleLabel_Left;
    private javax.swing.JLabel TitleLabel_Right;
    private javax.swing.JSeparator Title_Line;
    private javax.swing.JLabel Title_Ver;
    // End of variables declaration//GEN-END:variables

}
