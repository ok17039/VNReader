/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package reader;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import ln.Novel;
import ln.Character;
import mainm.MainMenu;

/**
 *
 * @author HexxTheSwagger
 */
public class GUI extends javax.swing.JFrame {

    private Reader lnReader;
    private State currentState;
    private String lastBckg;

    boolean isOver;

    /**
     * Creates new form GUI
     */
    public GUI(Reader lnReader, Novel ln, State currentState) {
        this.lnReader = lnReader;
        isOver = false;

        initComponents();
        initComponents_MANUALY_GOD_DAMNIT_NETBEANS(ln);

        this.setVisible(true);

        this.currentState = currentState;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Layers = new javax.swing.JLayeredPane();
        Default_Buttons = new javax.swing.JLayeredPane();
        Button_Continue = new javax.swing.JButton();
        Button_Transcript = new javax.swing.JButton();
        Button_Hide = new javax.swing.JButton();
        Button_CloseTranscript = new javax.swing.JButton();
        Button_Exit = new javax.swing.JButton();
        TranscriptArea_SP = new javax.swing.JScrollPane();
        Transcript_Area = new javax.swing.JTextPane();
        NarrationArea_SP = new javax.swing.JScrollPane();
        Narration_Area = new javax.swing.JTextPane();
        Mask_Narration = new javax.swing.JLabel();
        Actor_Area = new javax.swing.JLabel();
        TextArea_SP = new javax.swing.JScrollPane();
        Text_Area = new javax.swing.JTextArea();
        Masks_Default = new javax.swing.JLayeredPane();
        Mask_Top = new javax.swing.JLabel();
        Mask_Bottom = new javax.swing.JLabel();
        Characters = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();
        BlackOrWhite = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1600, 900));
        setMinimumSize(new java.awt.Dimension(1152, 648));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1152, 648));
        setResizable(false);
        setSize(new java.awt.Dimension(1152, 648));
        getContentPane().setLayout(null);

        Layers.setMaximumSize(new java.awt.Dimension(1600, 900));
        Layers.setMinimumSize(new java.awt.Dimension(1152, 648));

        Button_Continue.setBorder(null);
        Button_Continue.setBorderPainted(false);
        Button_Continue.setContentAreaFilled(false);
        Button_Continue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ContinueActionPerformed(evt);
            }
        });
        Default_Buttons.setLayer(Button_Continue, 1);
        Default_Buttons.add(Button_Continue);
        Button_Continue.setBounds(0, 0, 1152, 648);

        Button_Transcript.setFont(new java.awt.Font("Nirmala UI", 0, 26)); // NOI18N
        Button_Transcript.setForeground(new java.awt.Color(204, 204, 204));
        Button_Transcript.setText("TRANSCRIPT");
        Button_Transcript.setToolTipText("");
        Button_Transcript.setBorder(null);
        Button_Transcript.setContentAreaFilled(false);
        Button_Transcript.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Button_Transcript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_TranscriptActionPerformed(evt);
            }
        });
        Default_Buttons.setLayer(Button_Transcript, 2);
        Default_Buttons.add(Button_Transcript);
        Button_Transcript.setBounds(130, 20, 180, 40);

        Button_Hide.setFont(new java.awt.Font("Nirmala UI", 0, 26)); // NOI18N
        Button_Hide.setForeground(new java.awt.Color(204, 204, 204));
        Button_Hide.setText("HIDE");
        Button_Hide.setBorder(null);
        Button_Hide.setContentAreaFilled(false);
        Button_Hide.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Button_Hide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_HideActionPerformed(evt);
            }
        });
        Default_Buttons.setLayer(Button_Hide, 2);
        Default_Buttons.add(Button_Hide);
        Button_Hide.setBounds(20, 20, 90, 40);

        Button_CloseTranscript.setFont(new java.awt.Font("Nirmala UI", 0, 26)); // NOI18N
        Button_CloseTranscript.setForeground(new java.awt.Color(204, 204, 204));
        Button_CloseTranscript.setText("BACK");
        Button_CloseTranscript.setBorder(null);
        Button_CloseTranscript.setContentAreaFilled(false);
        Button_CloseTranscript.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Button_CloseTranscript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_CloseTranscriptActionPerformed(evt);
            }
        });
        Default_Buttons.setLayer(Button_CloseTranscript, 2);
        Default_Buttons.add(Button_CloseTranscript);
        Button_CloseTranscript.setBounds(20, 20, 90, 40);

        Button_Exit.setFont(new java.awt.Font("Nirmala UI", 0, 26)); // NOI18N
        Button_Exit.setForeground(new java.awt.Color(204, 204, 204));
        Button_Exit.setText("EXIT");
        Button_Exit.setBorder(null);
        Button_Exit.setContentAreaFilled(false);
        Button_Exit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Button_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ExitActionPerformed(evt);
            }
        });
        Default_Buttons.setLayer(Button_Exit, 2);
        Default_Buttons.add(Button_Exit);
        Button_Exit.setBounds(1040, 20, 90, 40);

        Layers.setLayer(Default_Buttons, 11);
        Layers.add(Default_Buttons);
        Default_Buttons.setBounds(0, 0, 1152, 648);

        TranscriptArea_SP.setBorder(null);
        TranscriptArea_SP.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        TranscriptArea_SP.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        TranscriptArea_SP.setFocusable(false);
        TranscriptArea_SP.setOpaque(false);

        Transcript_Area.setEditable(false);
        Transcript_Area.setBorder(null);
        Transcript_Area.setFont(new java.awt.Font("Segoe UI Variable", 0, 20)); // NOI18N
        Transcript_Area.setForeground(new java.awt.Color(255, 255, 255));
        Transcript_Area.setAutoscrolls(false);
        Transcript_Area.setFocusable(false);
        Transcript_Area.setOpaque(false);
        TranscriptArea_SP.setViewportView(Transcript_Area);

        Layers.setLayer(TranscriptArea_SP, 10);
        Layers.add(TranscriptArea_SP);
        TranscriptArea_SP.setBounds(20, 80, 800, 548);

        NarrationArea_SP.setBorder(null);
        NarrationArea_SP.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        NarrationArea_SP.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        NarrationArea_SP.setFocusable(false);
        NarrationArea_SP.setOpaque(false);
        NarrationArea_SP.setWheelScrollingEnabled(false);

        Narration_Area.setEditable(false);
        Narration_Area.setBorder(null);
        Narration_Area.setFont(new java.awt.Font("Segoe UI Variable", 0, 20)); // NOI18N
        Narration_Area.setForeground(new java.awt.Color(255, 255, 255));
        Narration_Area.setAutoscrolls(false);
        Narration_Area.setFocusable(false);
        Narration_Area.setOpaque(false);
        NarrationArea_SP.setViewportView(Narration_Area);

        Layers.setLayer(NarrationArea_SP, 9);
        Layers.add(NarrationArea_SP);
        NarrationArea_SP.setBounds(176, 289, 800, 70);

        Mask_Narration.setFocusable(false);
        Mask_Narration.setRequestFocusEnabled(false);
        Mask_Narration.setVerifyInputWhenFocusTarget(false);
        Layers.setLayer(Mask_Narration, 8);
        Layers.add(Mask_Narration);
        Mask_Narration.setBounds(0, 0, 1152, 648);

        Actor_Area.setFont(new java.awt.Font("Nirmala UI", 0, 24)); // NOI18N
        Actor_Area.setForeground(new java.awt.Color(153, 153, 153));
        Actor_Area.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Actor_Area.setText("Actor");
        Actor_Area.setToolTipText("");
        Actor_Area.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Layers.setLayer(Actor_Area, 6);
        Layers.add(Actor_Area);
        Actor_Area.setBounds(30, 554, 270, 70);

        TextArea_SP.setBorder(null);
        TextArea_SP.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        TextArea_SP.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        TextArea_SP.setOpaque(false);
        TextArea_SP.setWheelScrollingEnabled(false);

        Text_Area.setEditable(false);
        Text_Area.setBackground(new java.awt.Color(0, 204, 204));
        Text_Area.setColumns(1);
        Text_Area.setFont(new java.awt.Font("Segoe UI Variable", 0, 20)); // NOI18N
        Text_Area.setForeground(new java.awt.Color(255, 255, 255));
        Text_Area.setLineWrap(true);
        Text_Area.setRows(1);
        Text_Area.setText("May I enjoy my life and practice my art, respected by all men and in all times.");
        Text_Area.setWrapStyleWord(true);
        Text_Area.setAutoscrolls(false);
        Text_Area.setBorder(null);
        Text_Area.setFocusable(false);
        Text_Area.setHighlighter(null);
        Text_Area.setOpaque(false);
        TextArea_SP.setViewportView(Text_Area);

        Layers.setLayer(TextArea_SP, 6);
        Layers.add(TextArea_SP);
        TextArea_SP.setBounds(358, 558, 600, 70);

        Masks_Default.setEnabled(false);
        Masks_Default.setPreferredSize(new java.awt.Dimension(1152, 648));

        Mask_Top.setFocusable(false);
        Mask_Top.setRequestFocusEnabled(false);
        Mask_Top.setVerifyInputWhenFocusTarget(false);
        Masks_Default.setLayer(Mask_Top, 2);
        Masks_Default.add(Mask_Top);
        Mask_Top.setBounds(0, 0, 1152, 648);

        Mask_Bottom.setFocusable(false);
        Mask_Bottom.setRequestFocusEnabled(false);
        Mask_Bottom.setVerifyInputWhenFocusTarget(false);
        Masks_Default.setLayer(Mask_Bottom, 1);
        Masks_Default.add(Mask_Bottom);
        Mask_Bottom.setBounds(0, 0, 1152, 648);

        Layers.setLayer(Masks_Default, 5);
        Layers.add(Masks_Default);
        Masks_Default.setBounds(0, 0, 1152, 648);

        Characters.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Characters.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Characters.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Layers.setLayer(Characters, 3);
        Layers.add(Characters);
        Characters.setBounds(0, 0, 1152, 648);

        Background.setFocusable(false);
        Background.setPreferredSize(new java.awt.Dimension(1152, 648));
        Layers.setLayer(Background, 2);
        Layers.add(Background);
        Background.setBounds(0, 0, 1152, 648);

        BlackOrWhite.setBackground(new java.awt.Color(0, 0, 0));
        BlackOrWhite.setFocusable(false);
        BlackOrWhite.setPreferredSize(new java.awt.Dimension(1152, 648));

        javax.swing.GroupLayout BlackOrWhiteLayout = new javax.swing.GroupLayout(BlackOrWhite);
        BlackOrWhite.setLayout(BlackOrWhiteLayout);
        BlackOrWhiteLayout.setHorizontalGroup(
            BlackOrWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1152, Short.MAX_VALUE)
        );
        BlackOrWhiteLayout.setVerticalGroup(
            BlackOrWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 648, Short.MAX_VALUE)
        );

        Layers.setLayer(BlackOrWhite, 1);
        Layers.add(BlackOrWhite);
        BlackOrWhite.setBounds(0, 0, 1152, 648);

        getContentPane().add(Layers);
        Layers.setBounds(0, 0, 1152, 648);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_ContinueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ContinueActionPerformed
        
        if (!isOver) {
            if (!Button_Hide.isVisible()) {
                if (Button_CloseTranscript.isVisible()) return;
                
                // Show components
                Button_Exit.setVisible(true);
                Button_Hide.setVisible(true);
                Button_Transcript.setVisible(true);

                Mask_Top.setVisible(true);
                
                if (currentState.isDuringNarration()) {
                    NarrationArea_SP.setVisible(true);
                    Mask_Narration.setVisible(true);
                    
                } else {
                    Mask_Bottom.setVisible(true);
                }

                Actor_Area.setVisible(true);
                TextArea_SP.setVisible(true);

            } else {
                if (currentState != null) {
                    cleanup();
                }
                lnReader.progress();
            }
        } else {
            this.dispose();
            new MainMenu();
        }
    }//GEN-LAST:event_Button_ContinueActionPerformed

    private void Button_TranscriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_TranscriptActionPerformed
        if (currentState != null) {
            Transcript_Area.setText(currentState.getPastText());

            // Hide components
            Button_Hide.setVisible(false);
            Button_Transcript.setVisible(false);

            NarrationArea_SP.setVisible(false);
            Mask_Narration.setVisible(false);

            Actor_Area.setVisible(false);
            TextArea_SP.setVisible(false);
            Mask_Bottom.setVisible(false);
            
            // Show components
            Button_CloseTranscript.setVisible(true);
            TranscriptArea_SP.setVisible(true);
            // Mask_Transcript.setVisible(true);
        }
    }//GEN-LAST:event_Button_TranscriptActionPerformed

    private void Button_HideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_HideActionPerformed
        if (currentState != null) {
            // Hide components
            Button_Exit.setVisible(false);
            Button_Hide.setVisible(false);
            Button_Transcript.setVisible(false);

            NarrationArea_SP.setVisible(false);
            Mask_Narration.setVisible(false);

            Actor_Area.setVisible(false);
            TextArea_SP.setVisible(false);

            Mask_Top.setVisible(false);
            Mask_Bottom.setVisible(false);
        }
    }//GEN-LAST:event_Button_HideActionPerformed

    private void Button_CloseTranscriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_CloseTranscriptActionPerformed
        // Hide components
        Button_CloseTranscript.setVisible(false);
        TranscriptArea_SP.setVisible(false);
        // Mask_Transcript.setVisible(false);
        
        // Show components
        Button_Exit.setVisible(true);
        Button_Hide.setVisible(true);
        Button_Transcript.setVisible(true);

        if (currentState.isDuringNarration()) {
            NarrationArea_SP.setVisible(true);
            Mask_Narration.setVisible(true);
                    
        } else {
            Mask_Bottom.setVisible(true);
        }

        Actor_Area.setVisible(true);
        TextArea_SP.setVisible(true);
    }//GEN-LAST:event_Button_CloseTranscriptActionPerformed

    private void Button_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ExitActionPerformed
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_Button_ExitActionPerformed

    private void initComponents_MANUALY_GOD_DAMNIT_NETBEANS(Novel ln) {
        setLocationRelativeTo(null);
        
        TextArea_SP.getViewport().setOpaque(false);
        TextArea_SP.setViewportBorder(null);
        Text_Area.setBackground(new Color(0, 0, 0, 0));
        Text_Area.setText("Writer:   " + ln.getWriter() + "\nIllust:      " + ln.getIllust());

        Actor_Area.setText("");

        StyledDocument sDoc_NarAr = Narration_Area.getStyledDocument();
        SimpleAttributeSet centerAlign = new SimpleAttributeSet();
        StyleConstants.setAlignment(centerAlign, StyleConstants.ALIGN_CENTER);
        StyleConstants.setBackground(centerAlign, new Color(0, 0, 0, 0));

        try {
            sDoc_NarAr.insertString(0, ln.getTitle() + "\n" + ln.getStart().getName().substring(0, ln.getStart().getName().lastIndexOf('.')), centerAlign);
        } catch (BadLocationException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        sDoc_NarAr.setParagraphAttributes(0, sDoc_NarAr.getLength(), centerAlign, false);

        NarrationArea_SP.getViewport().setOpaque(false);
        NarrationArea_SP.setViewportBorder(null);
        Narration_Area.setStyledDocument(sDoc_NarAr);
        Narration_Area.setBackground(new Color(0, 0, 0, 0));
        Mask_Narration.setVisible(false);

        TranscriptArea_SP.getViewport().setOpaque(false);
        TranscriptArea_SP.setViewportBorder(null);
        Transcript_Area.setBackground(new Color(0, 0, 0, 0));
        // Mask_Transcript.setVisible(false);
        
        Characters.setIcon(new ImageIcon());

        initUI(ln.getDirectory().getAbsolutePath());

        Button_Exit.setBackground(new Color(0, 0, 0, 0));
        Button_CloseTranscript.setVisible(false);

        Background.setVisible(false);
    }

    
    private void setup() {

        String currentText = currentState.getText();

        if (currentText.isEmpty()) {
            return;
        }

        currentText = currentText.replace("{nickname}", currentState.getPlayerName());
        if (currentText.equalsIgnoreCase("{}")) {
            currentText = "";
            currentState.setActor("");
        }

        currentState.setText(currentText, false);

    }

    public void update() {

        setup();

        drawScene();

        if (currentState.isDuringNarration()) {
            Actor_Area.setText("");
            Text_Area.setText("");
            Mask_Narration.setVisible(true);
            Mask_Bottom.setVisible(false);
            NarrationArea_SP.setVisible(true);
            Narration_Area.setText(currentState.getText());

        } else {
            Mask_Narration.setVisible(false);
            Mask_Bottom.setVisible(true);
            Narration_Area.setText("");
            Actor_Area.setText(currentState.getActor().getName());
            Text_Area.setText(currentState.getText());
        }

        if (currentState.isDuringImage()) {
            Characters.setVisible(false);
            setImage();
        } else {
            Characters.setVisible(true);
            setBackground();
        }
        
        // System.out.println(currentState.getActor().getName() + ": " + currentState.getText());
    }

    private void cleanup() {

        if (currentState.isDuringNarration()) {
            currentState.setDuringNarration(false);
        }
    }

    
    public void nextChapter(State currentState, File currentScript, Novel ln) {
        Actor_Area.setText("");
        Text_Area.setText("End of chapter");
        Mask_Narration.setVisible(true);
        NarrationArea_SP.setVisible(true);
        Narration_Area.setText(ln.getTitle() + "\n" + currentScript.getName().substring(0, currentScript.getName().lastIndexOf('.')));
        this.currentState = currentState;
    }
    
    public void end(Novel ln, File currentScript) {
        isOver = true;

        Actor_Area.setText("");
        Text_Area.setText("The End");
        Mask_Narration.setVisible(true);
        NarrationArea_SP.setVisible(true);
        Narration_Area.setText(ln.getTitle() + "\n" + currentScript.getName().substring(0, currentScript.getName().lastIndexOf('.')));
    }

    private void initUI(String lnPath) {        // DO ALL

        try {
            BufferedImage textMaskBottomOrig = ImageIO.read(new File(lnPath + "/res/ui/Mask_Bottom.png"));
            BufferedImage textMaskTopOrig = ImageIO.read(new File(lnPath + "/res/ui/Mask_Top.png"));
            BufferedImage narrationMaskOrig = ImageIO.read(new File(lnPath + "/res/ui/Mask_Narration.png"));

            Mask_Bottom.setIcon(new ImageIcon(scaleImage(textMaskBottomOrig, Mask_Bottom.getWidth(), Mask_Bottom.getHeight())));
            Mask_Top.setIcon(new ImageIcon(scaleImage(textMaskTopOrig, Mask_Top.getWidth(), Mask_Top.getHeight())));
            Mask_Narration.setIcon(new ImageIcon(scaleImage(narrationMaskOrig, Mask_Narration.getWidth(), Mask_Narration.getHeight())));

        } catch (IOException ex) {
            System.out.println("ERROR: UI elements not found");
        }

    }

    
    /**
     * Draws characters sprites
     */
    private void drawScene() {

        var canvas = new BufferedImage(Characters.getWidth(), Characters.getHeight(), BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2D = canvas.createGraphics();
        g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        int sceneLen = 1;
        Character actor = currentState.getActor();
        int actorIndex = 0;     // Position of the actor from the left; -1: don't draw the actor

        // Draw other characters
        if (!currentState.isDuringSolo()) {                 // If the actor has a solo, the other charaters are not drawn
            sceneLen = currentState.getSceneLength();       // How many characters on scene
            actorIndex = -1;    // ?
            for (int i = 0; i < sceneLen; i++) {            // Go through the whole scene
                if (currentState.getSceneChar(i).equals(actor)) {     // If the current char is the actor, skip,
                    actorIndex = i;                                             // note actor position

                } else {
                    try {
                        BufferedImage sprite = ImageIO.read(new File(currentState.getLnDir() + "/res/char/" + currentState.getSceneChar(i).getDefSprite()));      // Create an image with the sprite
                        BufferedImage spriteFinal = new BufferedImage(sprite.getWidth(), sprite.getHeight(), sprite.getType());                    // Create an image for the processed sprite
                        Graphics2D sprite_g2D = spriteFinal.createGraphics();
                        
                        float[] scales = { 0.35f, 0.35f, 0.35f, 1f};
                        float[] offsets = new float[4];
                        RescaleOp darken = new RescaleOp(scales, offsets, null);
                        sprite_g2D.drawImage(sprite, darken, 0, 0);                         // Draw the processed image
                        sprite_g2D.dispose();
                        
                        int height = (int) (Characters.getHeight() * 1.3425);                                                                                  // Calculate sprite height from window size
                        int width = scaleDimensionsKeepRatio(sprite.getWidth(), sprite.getHeight(), -1, height);                 // Calculate width using AR and height

                        int x = (Characters.getWidth() / (sceneLen + 1) * (i + 1)) - (width / 2);                                                             // Calculate position
                        
                        g2D.drawImage(spriteFinal, x, 30, width, height, null);      // Draw sprite on the scene

                    } catch (IOException ex) {
                        System.out.println("ERROR: Sprite not found: " + currentState.getLnDir() + "/res/char/" + currentState.getSceneChar(i).getDefSprite());
                    }
                }
            }

        }

        // Draw the actor
        if (actor.getDefSprite().isBlank()) {       // Don't draw the actor if it has no sprite
            actorIndex = -1;
        }
        
        if (actorIndex != -1) {
            try {
                var sprite = ImageIO.read(new File(currentState.getLnDir() + "/res/char/" + actor.getDefSprite()));

                int height = (int) (Characters.getHeight() * 1.3425);
                int width = scaleDimensionsKeepRatio(sprite.getWidth(), sprite.getHeight(), -1, height);

                int x = (Characters.getWidth() / (sceneLen + 1) * (actorIndex + 1)) - (width / 2);

                g2D.drawImage(sprite, x, 30, width, height, null);

            } catch (IOException ex) {
                System.out.println("ERROR: Actor sprite not found: " + currentState.getLnDir() + "/res/char/" + actor.getDefSprite());
            }
        }

        g2D.dispose();

        Characters.setIcon(new ImageIcon(canvas));
    }

    /**
     * Sets a properly scaled background image
     */
    private void setBackground() {

        String bckg = currentState.getBackground().substring(currentState.getBackground().lastIndexOf("/") + 1);

        javax.swing.ImageIcon lastBg;
        lastBg = (ImageIcon) Background.getIcon();

        if ((lastBg == null) || !Background.isVisible()) {
            if (BlackOrWhite.getBackground().equals(Color.BLACK) && bckg.equalsIgnoreCase("black")) {
                return;
            } else if (BlackOrWhite.getBackground().equals(Color.WHITE) && bckg.equalsIgnoreCase("white")) {
                return;
            }
        }

        if (lastBg != null) {
            if (bckg.equals(lastBckg)) {
                return;
            }
        }

        try {

            System.out.println("Setting background: " + bckg);

            if (bckg.equalsIgnoreCase("black") || bckg.equalsIgnoreCase("white")) {
                if (bckg.equalsIgnoreCase("black")) {
                    BlackOrWhite.setBackground(Color.BLACK);
                } else {
                    BlackOrWhite.setBackground(Color.WHITE);
                }

                Background.setVisible(false);

            } else if (bckg.isBlank()) {
                BlackOrWhite.setBackground(Color.BLACK);
                Background.setVisible(false);

            } else {

                BufferedImage origBckg = ImageIO.read(new File(currentState.getBackground()));
                Background.setIcon(new ImageIcon(scaleImage(origBckg, Background.getWidth(), Background.getHeight())));
                Background.setVisible(true);

            }

            lastBckg = bckg;

        } catch (IOException ex) {
            System.out.println("ERROR: Image not found: " + currentState.getBackground());
        }
    }

    private void setImage() {

        String img = currentState.getImage().substring(currentState.getImage().lastIndexOf("/") + 1);

        javax.swing.ImageIcon lastBg;
        lastBg = (ImageIcon) Background.getIcon();

        if ((lastBg == null) || !Background.isVisible()) {
            if (BlackOrWhite.getBackground().equals(Color.BLACK) && img.equalsIgnoreCase("black")) {
                return;
            } else if (BlackOrWhite.getBackground().equals(Color.WHITE) && img.equalsIgnoreCase("white")) {
                return;
            }
        }

        if (lastBg != null) {
            if (img.equals(lastBckg)) {
                return;
            }
        }

        try {

            System.out.println("Setting image: " + img);

            if (img.equalsIgnoreCase("black") || img.equalsIgnoreCase("white")) {
                if (img.equalsIgnoreCase("black")) {
                    BlackOrWhite.setBackground(Color.BLACK);
                } else {
                    BlackOrWhite.setBackground(Color.WHITE);
                }

                Background.setVisible(false);

            } else if (img.isBlank()) {
                BlackOrWhite.setBackground(Color.BLACK);
                Background.setVisible(false);

            } else {

                BufferedImage origImg = ImageIO.read(new File(currentState.getImage()));
                Background.setIcon(new ImageIcon(scaleImage(origImg, Background.getWidth(), Background.getHeight())));
                Background.setVisible(true);

            }

            lastBckg = img;

        } catch (IOException ex) {
            System.out.println("ERROR: Image not found: " + currentState.getImage());
        }
    }

    /**
     * Takes the original dimensions of an image, one desired scaled dimension and outputs the other dimension, scaled such that AR is kept
     * e.g: 16, 9,  32 -> 18
     */
    private int scaleDimensionsKeepRatio(int sourceW, int sourceH, int outputW, int outputH) {

        if (sourceW <= 0 || sourceH <= 0 || (outputW <= 0 && outputH <= 0)) {
            return -1;
        }

        int ratio = sourceW / sourceH;

        if (outputH == -1) {
            return outputW / ratio;
        }

        if (outputW == -1) {
            return outputH * ratio;
        }

        return -1;
    }

    private BufferedImage scaleImage(BufferedImage source, int width, int height) {

        var scaled = new BufferedImage(width, height, source.getType());
        Graphics2D g2D = scaled.createGraphics();
        g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        g2D.drawImage(source, 0, 0, width, height, null);
        g2D.dispose();

        return scaled;
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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        FlatLightLaf.setup();
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Actor_Area;
    private javax.swing.JLabel Background;
    private javax.swing.JPanel BlackOrWhite;
    private javax.swing.JButton Button_CloseTranscript;
    private javax.swing.JButton Button_Continue;
    private javax.swing.JButton Button_Exit;
    private javax.swing.JButton Button_Hide;
    private javax.swing.JButton Button_Transcript;
    private javax.swing.JLabel Characters;
    private javax.swing.JLayeredPane Default_Buttons;
    private javax.swing.JLayeredPane Layers;
    private javax.swing.JLabel Mask_Bottom;
    private javax.swing.JLabel Mask_Narration;
    private javax.swing.JLabel Mask_Top;
    private javax.swing.JLayeredPane Masks_Default;
    private javax.swing.JScrollPane NarrationArea_SP;
    private javax.swing.JTextPane Narration_Area;
    private javax.swing.JScrollPane TextArea_SP;
    private javax.swing.JTextArea Text_Area;
    private javax.swing.JScrollPane TranscriptArea_SP;
    private javax.swing.JTextPane Transcript_Area;
    // End of variables declaration//GEN-END:variables

}
