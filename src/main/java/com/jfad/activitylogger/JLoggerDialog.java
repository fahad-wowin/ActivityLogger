/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.jfad.activitylogger;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.*;
import javax.swing.ImageIcon;

/**
 *
 * @author User
 */
public class JLoggerDialog extends javax.swing.JDialog {

    /**
     * Creates new form JLoggerDialog
     */
    public JLoggerDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try {
            java.text.SimpleDateFormat dateformat = new java.text.SimpleDateFormat("yyyy-MM-dd");
            File logFileLocation = new File("activity-logger");
            if (!logFileLocation.exists()) {
                logFileLocation.mkdirs();
            }
            writer = new java.io.BufferedWriter(new java.io.FileWriter(logFileLocation.getAbsolutePath() + "/log-" + dateformat.format(new Date()) + ".txt", true));
            icon = new ImageIcon(getClass().getResource("/icon.png"));

            initComponents();
            taskList = new HashMap<>();

            // Create a tray icon with an image
            //Image iconImage = Toolkit.getDefaultToolkit().getImage("/icon.png");
            trayIcon = new TrayIcon(icon.getImage(), "JavActivityLogger - double-click");
            trayIcon.setImageAutoSize(true);
            // Add an action listener to the "Open" menu item
            trayIcon.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) { // double-click
                        setVisible(true);
                    }
                }

            });
            System.out.println("" + SystemTray.getSystemTray().getTrayIconSize());
            // Create the system tray
            SystemTray systemTray = SystemTray.getSystemTray();
            try {
                // Add the tray icon to the system tray
                systemTray.add(trayIcon);
            } catch (AWTException e) {
                System.out.println("TrayIcon could not be added.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private boolean stop = false;
    private boolean pause = false;

    private static final long MINUTE_MULTIPLIER = 60 * 1000;
    private static final long POPUP_TIME_OK = 30 * MINUTE_MULTIPLIER;
    private static final long POPUP_TIME_NOT_OK = 2 * 1000;
    private static final long MAX_TEXT = 15;
    protected static long nextPopupTime = POPUP_TIME_OK;
    protected static Date nextTime;
    protected static Date lastTime;
    protected static boolean justOpen = false;

    private boolean isSaved = false;
    HashMap<String, String> taskList;

    java.io.BufferedWriter writer;
    TrayIcon trayIcon;
    ImageIcon icon;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSaveButton = new javax.swing.JButton();
        jClearButton = new javax.swing.JButton();
        jCloseButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTasksComboBox = new javax.swing.JComboBox<>();
        jNextLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLastLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jStartStopMenu = new javax.swing.JMenuItem();
        jExitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Activity Logger");
        setAlwaysOnTop(true);
        setBounds(getScreenSize().width-367-20, getScreenSize().height-360-50, 367, 360);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.gray);
        setIconImage(icon.getImage()
        );
        setModal(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setText("Please enter the activities of last 30 minutes.");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 15, 290, 20);

        jSaveButton.setMnemonic('s');
        jSaveButton.setText("Save");
        jSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSaveButtonActionPerformed(evt);
            }
        });
        getContentPane().add(jSaveButton);
        jSaveButton.setBounds(260, 50, 70, 30);

        jClearButton.setMnemonic('r');
        jClearButton.setText("Clear");
        jClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jClearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(jClearButton);
        jClearButton.setBounds(260, 110, 70, 30);

        jCloseButton.setMnemonic('c');
        jCloseButton.setText("Close");
        jCloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCloseButtonActionPerformed(evt);
            }
        });
        getContentPane().add(jCloseButton);
        jCloseButton.setBounds(260, 170, 70, 30);

        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 50, 210, 150);

        jTasksComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select last comment" }));
        jTasksComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jTasksComboBoxItemStateChanged(evt);
            }
        });
        jTasksComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTasksComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(jTasksComboBox);
        jTasksComboBox.setBounds(30, 220, 300, 30);

        jNextLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jNextLabel.setToolTipText("");
        getContentPane().add(jNextLabel);
        jNextLabel.setBounds(235, 260, 105, 20);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setText("Last @");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 260, 40, 20);

        jLastLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLastLabel.setToolTipText("");
        getContentPane().add(jLastLabel);
        jLastLabel.setBounds(70, 260, 105, 20);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setText("Next @");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(192, 260, 40, 20);

        jMenu1.setMnemonic('f');
        jMenu1.setText("File");

        jStartStopMenu.setText("Stop");
        jStartStopMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jStartStopMenuActionPerformed(evt);
            }
        });
        jMenu1.add(jStartStopMenu);

        jExitMenuItem.setMnemonic('e');
        jExitMenuItem.setText("Exit");
        jExitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExitMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(jExitMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);
    }// </editor-fold>//GEN-END:initComponents


private void jCloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCloseButtonActionPerformed
    // Add your handling code here:
    if (!isSaved) {
        System.out.println("oye write somthing to save...");
        nextPopupTime = POPUP_TIME_NOT_OK;
    }
    setTextFocussed();
    setVisible(false);
    }//GEN-LAST:event_jCloseButtonActionPerformed
    private java.awt.Dimension getScreenSize() {
        return java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    }
    private void jExitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExitMenuItemActionPerformed
        // Add your handling code here:
        if (javax.swing.JOptionPane.showConfirmDialog(this, "Are you sure, you want to exit?") == javax.swing.JOptionPane.OK_OPTION) {
            setStopped(true);
            setVisible(false);
            System.out.println("closing and disposing");
            dispose();
            try {
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("hey i'm going down");
            if (trayIcon != null) {
                SystemTray.getSystemTray().remove(trayIcon);
            }
            System.exit(0);
        } else {
            System.out.println("not saved so not closed");
        }
    }//GEN-LAST:event_jExitMenuItemActionPerformed

    private void jClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jClearButtonActionPerformed
        // Add your handling code here:
        jTextArea1.setText("");
        setTextFocussed();
    }//GEN-LAST:event_jClearButtonActionPerformed

    private void jSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSaveButtonActionPerformed
        // Add your handling code here:
        //save
        try {
            if ("".equals(jTextArea1.getText())) {
                javax.swing.JOptionPane.showMessageDialog(this, "Please enter a text of at least " + MAX_TEXT + " characters.");
                setTextFocussed();
                return;
            }
            String activityText = jTextArea1.getText();
            if (activityText.length() < MAX_TEXT) {
                javax.swing.JOptionPane.showMessageDialog(this, "Please enter a text of at least " + MAX_TEXT + " characters.\n The text is too short to understand.");
                setTextFocussed();
                return;
            }
            System.out.println("saving text : " + jTextArea1.getText());
            Date date = new Date();
            java.text.SimpleDateFormat dateformat = new java.text.SimpleDateFormat("dd/MMM/yyyy HH:mm:ss");

            updateTimes();
            writer.write(dateformat.format(date) + " - " + jTextArea1.getText() + "\n");
            taskList.put(dateformat.format(date), jTextArea1.getText());
            jTasksComboBox.addItem(jTextArea1.getText());
            jTasksComboBox.setSelectedIndex(0);
            writer.flush();
            isSaved = true;
            jTextArea1.setText("");
            //setTextFocussed();
            setVisible(false);
            nextPopupTime = POPUP_TIME_OK;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jSaveButtonActionPerformed

    public void setTextFocussed() {
        jTextArea1.requestFocus();
    }

    public boolean isStopped() {
        return stop;
    }

    public void setStopped(boolean stop) {
        this.stop = stop;
    }

    public boolean isSaved() {
        return isSaved;
    }

    public void setSaved(boolean saved) {
        this.isSaved = saved;
    }

    public boolean isPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    public void updateTimes() {
        if(!pause){
            Date date = new Date();
            java.text.SimpleDateFormat dateformat = new java.text.SimpleDateFormat("dd/MMM/yyyy HH:mm");
            lastTime = date;
            jLastLabel.setText(dateformat.format(lastTime));
            nextTime = new Date(date.getTime() + POPUP_TIME_OK);
            jNextLabel.setText(dateformat.format(nextTime));
        }
    }

    public void stop() {
        setSaved(true);
        pauseUntil(-1);
        pause = true;
    }

    public void start() {
        setSaved(true);
                nextPopupTime = POPUP_TIME_OK;
        pauseUntil(30);
        pause = false;
    }

    public void pauseUntil(int minutes) {
        Date date = new Date();setSaved(true);
        java.text.SimpleDateFormat dateformat = new java.text.SimpleDateFormat("dd/MMM/yyyy HH:mm");
        lastTime = date;
        jLastLabel.setText(dateformat.format(lastTime));
        if (minutes <= 0) {
            nextTime = null;
            jNextLabel.setText("-- STOPPED --");
        } else {
            nextTime = new Date(date.getTime() + (minutes * MINUTE_MULTIPLIER));
            jNextLabel.setText(dateformat.format(nextTime));
        }
    }

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        if (!isSaved) {
            nextPopupTime = POPUP_TIME_NOT_OK;
        }
        System.out.println("nextPopupTime : " + nextPopupTime);
        //setTextFocussed();
        setVisible(false);

    }//GEN-LAST:event_closeDialog

    private void jStartStopMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jStartStopMenuActionPerformed
        // TODO add your handling code here:
        javax.swing.JMenuItem menu = (javax.swing.JMenuItem) evt.getSource();
        String text = menu.getText();
        if ("Start".equals(text)) {
            menu.setText("Stop");
            setSaved(true);
            nextPopupTime = POPUP_TIME_OK;
            nextPopupTime = -1;
            start();
        } else {
            menu.setText("Start");
            setSaved(false);
            nextPopupTime = -1;
            stop();
        }
    }//GEN-LAST:event_jStartStopMenuActionPerformed

    private void jTasksComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTasksComboBoxActionPerformed
        // TODO add your handling code here:
        if (jTasksComboBox.getSelectedIndex() != 0) {
            //System.out.println(" selected > "+ jTasksComboBox.getSelectedItem());
            if (jTextArea1.getText().length() > 0) {
                int what = javax.swing.JOptionPane.showOptionDialog(this, "What you want with the selected text?",
                        "Selext Text", javax.swing.JOptionPane.YES_NO_CANCEL_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null, new String[]{"Append", "Replace", "Cancel"}, "Append");
                if (what == 0) {
                    jTextArea1.setText(jTextArea1.getText() + " : " + jTasksComboBox.getSelectedItem() + "");
                } else if (what == 1) {
                    jTextArea1.setText(jTasksComboBox.getSelectedItem() + "");
                }
            } else {
                jTextArea1.setText(jTasksComboBox.getSelectedItem() + "");
            }
        }
    }//GEN-LAST:event_jTasksComboBoxActionPerformed

    private void jTasksComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jTasksComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jTasksComboBoxItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jClearButton;
    private javax.swing.JButton jCloseButton;
    private javax.swing.JMenuItem jExitMenuItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLastLabel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel jNextLabel;
    private javax.swing.JButton jSaveButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem jStartStopMenu;
    private javax.swing.JComboBox<String> jTasksComboBox;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}