/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UserPasswords.java
 *
 * Created on 11/08/2011, 16:46:21
 */
package com.ba.usermanagement.gui.dialogs;

import com.ba.swingapphelper.gui.GUICommons;
import com.ba.swingapphelper.gui.GUIMensajes;
import com.fsaravia.utilities.Encriptar;
import com.ib.HBCore.controllers.CoreController;
import com.ib.HBCore.controllers.UserController;
import com.ib.HBCore.entities.User;
import com.ib.HBCore.exceptions.ValidationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

/**
 *
 * @author Federico Saravia
 */
public class UserPasswords extends javax.swing.JDialog {

    private boolean onUserCreation;
    private UserController controller = new UserController();
    private User user;

    /**
     * Creates new form UserPasswords
     */
    public UserPasswords(javax.swing.JFrame parent, boolean onUserCreation, User user) {
        super(parent, true);
        this.onUserCreation = onUserCreation;
        this.user = user;
        initComponents();
        init();
    }

    private void init() {
        jLabel1.setVisible(!onUserCreation);
        jPasswordField1.setVisible(!onUserCreation);
        jLabel4.setVisible(onUserCreation);
        jLabel5.setVisible(onUserCreation);
        jLabel6.setVisible(onUserCreation);
        jButton2.setEnabled(!onUserCreation);
        if (onUserCreation) {
            jLabel5.setText(com.fsaravia.utilities.Aleatorios.generarPassword());
            useSuggestion();

        }
        User loggedUser = CoreController.loggedUser;
        if (/*
                 * loggedUser == null ||
                 */loggedUser.isAdministrator()) {
            jLabel1.setVisible(false);
            jPasswordField1.setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPasswordField3 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Contraseña Anterior:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jLabel1, gridBagConstraints);

        jLabel2.setText("Contraseña Nueva:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jLabel2, gridBagConstraints);

        jLabel3.setText("Repita la contraseña:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jLabel3, gridBagConstraints);

        jPasswordField1.setPreferredSize(new java.awt.Dimension(140, 20));
        jPasswordField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordField1FocusGained(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jPasswordField1, gridBagConstraints);

        jPasswordField2.setPreferredSize(new java.awt.Dimension(140, 20));
        jPasswordField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordField2FocusGained(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jPasswordField2, gridBagConstraints);

        jPasswordField3.setPreferredSize(new java.awt.Dimension(140, 20));
        jPasswordField3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordField3FocusGained(evt);
            }
        });
        jPasswordField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordField3KeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jPasswordField3, gridBagConstraints);

        jLabel4.setText("Sugerencia:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jLabel4, gridBagConstraints);

        jLabel5.setText("Aca debe ir una sugerencia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jLabel5, gridBagConstraints);

        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setText("Utilizar");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jLabel6, gridBagConstraints);

        jButton1.setText("Guardar");
        jButton1.setPreferredSize(new java.awt.Dimension(150, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton2.setText("Cancelar");
        jButton2.setPreferredSize(new java.awt.Dimension(150, 23));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jPasswordField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField1FocusGained
        GUICommons.seleccionarCampo(evt);
}//GEN-LAST:event_jPasswordField1FocusGained

private void jPasswordField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField2FocusGained
        GUICommons.seleccionarCampo(evt);
}//GEN-LAST:event_jPasswordField2FocusGained

private void jPasswordField3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField3FocusGained
        GUICommons.seleccionarCampo(evt);
}//GEN-LAST:event_jPasswordField3FocusGained

private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
    useSuggestion();
}//GEN-LAST:event_jLabel6MouseClicked

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    save();
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    cancel();
}//GEN-LAST:event_jButton2ActionPerformed

    private void jPasswordField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField3KeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            save();
        }
    }//GEN-LAST:event_jPasswordField3KeyReleased

    private void useSuggestion() {
        jPasswordField2.setText(jLabel5.getText());
        jPasswordField3.setText(jLabel5.getText());
    }

    @Override
    public JRootPane getRootPane() {
        final ActionListener actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        };
        KeyStroke stroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
        JRootPane rp = super.getRootPane();
        rp.registerKeyboardAction(actionListener, stroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
        return rp;
    }

    private void cancel() {
        this.dispose();
    }

    private void save() {
        boolean continuar;
        try {
            if (onUserCreation) {
                continuar = true;
            } else {
                User usuarioLogueado = CoreController.loggedUser;
                if (/*
                         * usuarioLogueado == null ||
                         */usuarioLogueado.isAdministrator()) {
                    continuar = true;
                } else {
                    String passwordActual = Encriptar.encriptarIrreversible(new String(jPasswordField1.getPassword()));
                    continuar = controller.validatePassword(user, passwordActual);
                }
            }
            if (continuar) {
                String passwordUno = Encriptar.encriptarIrreversible(new String(jPasswordField2.getPassword()));
                String passwordDos = Encriptar.encriptarIrreversible(new String(jPasswordField3.getPassword()));
                if (passwordUno.equals(passwordDos)) {
                    controller.changePassword(user, passwordUno);
                    this.dispose();
                } else {
                    throw new ValidationException("Las contraseñas ingresadas no coinciden");
                }
            } else {
                throw new ValidationException("La contraseña ingresada es inválida");
            }
        } catch (Exception e) {
            GUIMensajes.mostrarErrorReportar(this, e);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    // End of variables declaration//GEN-END:variables
}
