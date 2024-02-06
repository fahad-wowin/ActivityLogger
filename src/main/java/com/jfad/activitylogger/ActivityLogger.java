/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jfad.activitylogger;

import java.util.Calendar;

/**
 *
 * @author User
 */
public class ActivityLogger {

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
            java.util.logging.Logger.getLogger(JLoggerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JLoggerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JLoggerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JLoggerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
         */
        //</editor-fold>

        //JLoggerDialog loggerDialog = new JLoggerDialog(new javax.swing.JFrame(), true);
        /* Create and display the dialog */
 /* java.awt.EventQueue.invokeLater(() -> {
            
                int a = 0;

                    System.out.println("the i : " + a++);
                    try {
                        System.out.println("run started at : " + Calendar.getInstance().get(Calendar.MILLISECOND));
                        while (!loggerDialog.isStopped()) {

                            if (!loggerDialog.isVisible()) {
                                System.out.println("hey i'm getting up");
                                loggerDialog.setVisible(true);
                                loggerDialog.setTextFocussed();
                                loggerDialog.setSaved(false);
                            }
                            if (loggerDialog.isStopped()) {
                                System.out.println("hey i'm going down");
                                System.exit(0);
                                //return;
                            }
                            Thread.sleep(JLoggerDialog.nextPopupTime);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                
            });

            loggerDialog.setVisible(true);
         */
        JLoggerDialog loggerDialog = new JLoggerDialog(new javax.swing.JFrame(), true);

        Thread thread = new Thread(new Runnable() {
            int a = 0;

            public void run() {
                System.out.println("the i : " + a++);
                try {
                    System.out.println("run started at : " + Calendar.getInstance().get(Calendar.MILLISECOND));
                    while (!loggerDialog.isStopped()) {

                        if (!loggerDialog.isVisible() && !loggerDialog.isPause()) {
                            System.out.println("hey i'm getting up");
                            loggerDialog.setVisible(true);
                            loggerDialog.setTextFocussed();
                            loggerDialog.setSaved(false);
                            loggerDialog.updateTimes();
                        }
                        if (loggerDialog.isStopped()) {
                            System.out.println("hey i'm going down");
                            System.exit(0);
                            //return;
                        }
                        Thread.sleep(JLoggerDialog.nextPopupTime);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });

        thread.start();

    }

}
