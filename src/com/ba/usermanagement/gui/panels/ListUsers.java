/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ListUsers.java
 *
 * Created on 11/08/2011, 17:57:11
 */
package com.ba.usermanagement.gui.panels;

import com.ba.swingapphelper.gui.GUICommons;
import com.ba.swingapphelper.gui.GUIMensajes;
import com.ba.usermanagement.UserTableModel;
import com.ba.usermanagement.gui.dialogs.UserData;
import com.ib.HBCore.application.ApplicationModuleDescriber;
import com.ib.HBCore.controllers.UserController;
import com.ib.HBCore.entities.User;
import com.ib.HBCore.exceptions.ValidationException;
import com.ib.modeloTabla.Modelo;
import com.ib.modeloTabla.TableSorter;
import java.awt.event.KeyEvent;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Federico Saravia
 */
public class ListUsers extends com.ba.usermanagement.gui.permissions.UserPermissionsEnabledJPanel {

    private final UserController controller = new UserController();
    private static final int LAST_SEARCH_USERNAME = 1;
    private static final int LAST_SEARCH_NAME = 2;
    private static final int LAST_SEARCH_ALL = 3;
    private int lastSearch = -1;

    /**
     * Creates new form ListUsers
     */
    public ListUsers() throws Exception {
        super();
        initComponents();
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
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("Usuarios del Sistema");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(jLabel1, gridBagConstraints);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 13))); // NOI18N
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel3.setText("Nombre de Usuario:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(3, 10, 3, 3);
        jPanel1.add(jLabel3, gridBagConstraints);

        jLabel4.setText("Apellidos:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(3, 10, 3, 3);
        jPanel1.add(jLabel4, gridBagConstraints);

        jLabel5.setText("Nombres:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jLabel5, gridBagConstraints);

        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jTextField1, gridBagConstraints);

        jTextField2.setPreferredSize(new java.awt.Dimension(120, 20));
        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField2FocusGained(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jTextField2, gridBagConstraints);

        jTextField3.setPreferredSize(new java.awt.Dimension(120, 20));
        jTextField3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField3FocusGained(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jTextField3, gridBagConstraints);

        jButton1.setText("Buscar");
        jButton1.setPreferredSize(new java.awt.Dimension(75, 29));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jButton1, gridBagConstraints);

        jButton2.setText("Buscar");
        jButton2.setPreferredSize(new java.awt.Dimension(75, 29));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jButton2, gridBagConstraints);

        jButton3.setText("Mostrar Todos los usuarios");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jButton3, gridBagConstraints);

        jCheckBox1.setText("Incluir usuarios desactivados");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jCheckBox1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(jPanel1, gridBagConstraints);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(850, 300));

        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(jScrollPane1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(jSeparator1, gridBagConstraints);

        jButton4.setText("Nuevo usuario");
        jButton4.setPreferredSize(new java.awt.Dimension(150, 29));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);

        jButton5.setText("Ver/Editar usuario");
        jButton5.setPreferredSize(new java.awt.Dimension(150, 29));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(jPanel2, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        findByUsername();
    }
}//GEN-LAST:event_jTextField1KeyPressed

private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        findByName();
    }
}//GEN-LAST:event_jTextField2KeyPressed

private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        findByName();
    }
}//GEN-LAST:event_jTextField3KeyPressed

private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    if (evt.getClickCount() == 2) {
        editUser();
    }
}//GEN-LAST:event_jTable1MouseClicked

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    findByUsername();
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    findByName();
}//GEN-LAST:event_jButton2ActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    fetchAll();
}//GEN-LAST:event_jButton3ActionPerformed

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    newUser();
}//GEN-LAST:event_jButton4ActionPerformed

private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    editUser();
}//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
        GUICommons.seleccionarCampo(evt);
    }//GEN-LAST:event_jTextField1FocusGained

    private void jTextField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusGained
        GUICommons.seleccionarCampo(evt);
    }//GEN-LAST:event_jTextField2FocusGained

    private void jTextField3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusGained
        GUICommons.seleccionarCampo(evt);
    }//GEN-LAST:event_jTextField3FocusGained

    private void findByUsername() {
        try {
            if (jTextField1.getText() == null || jTextField1.getText().equals("")) {
                throw new ValidationException("Ingrese un nombre de usuario o parte del mismo");
            }
            List<User> setUsuarios = controller.findByUserName(jTextField1.getText(), jCheckBox1.isSelected());
            showUsers(setUsuarios);
            lastSearch = LAST_SEARCH_USERNAME;
        } catch (Exception e) {
            GUIMensajes.mostrarErrorReportar(this, e);
        }
    }

    private void findByName() {
        try {
            if ((jTextField2.getText() == null || jTextField2.getText().equals("")) && (jTextField3.getText() == null || jTextField3.getText().equals(""))) {
                throw new ValidationException("Ingrese el apellido o el nombre o parte de los mismos");
            }
            List<User> usersList = controller.findByName(jTextField3.getText(), jTextField2.getText(), jCheckBox1.isSelected());
            showUsers(usersList);
            lastSearch = LAST_SEARCH_NAME;
        } catch (Exception e) {
            GUIMensajes.mostrarErrorReportar(this, e);
        }
    }

    private void fetchAll() {
        try {
            List<User> usersList = controller.fetchAll(!jCheckBox1.isSelected());
            showUsers(usersList);
            lastSearch = LAST_SEARCH_ALL;
        } catch (Exception ex) {
            GUIMensajes.mostrarErrorReportar(this, ex);
        }
    }

    private void newUser() {
        try {
            UserData dialog = new UserData((JFrame) this.getTopLevelAncestor(), null);
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
            repeatSearch();
        } catch (Exception ex) {
            GUIMensajes.mostrarErrorReportar(this, ex);
        }
    }

    private void editUser() {
        try {
            int indice = jTable1.getSelectedRow();
            if (indice < 0) {
                throw new ValidationException("Seleccione un elemento de la lista");
            }
            UserTableModel user = (UserTableModel) ((TableSorter) jTable1.getModel()).getDatosAt(indice);
            UserData dialog = new UserData((JFrame) this.getTopLevelAncestor(), user.getUser());
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
            repeatSearch();
        } catch (ClassCastException cce) {
            Logger.getLogger(ListUsers.class.getName()).log(Level.WARNING, null, cce);
        } catch (Exception e) {
            GUIMensajes.mostrarErrorReportar(this, e);
        }
    }

    private void repeatSearch() {
        switch (lastSearch) {
            case LAST_SEARCH_ALL:
                fetchAll();
                break;
            case LAST_SEARCH_USERNAME:
                findByUsername();
                break;
            case LAST_SEARCH_NAME:
                findByUsername();
                break;
        }
    }

    private void showUsers(Collection<User> collection) {
        Modelo.crearModelo(UserTableModel.convert(collection), jTable1);
    }
    /*
     *     private String username;
     private String nombres;
     private String apellidos;
     private Calendar ultimoAcceso;
     private Set<Permission> listaPermisos;
     private Boolean administrador;
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

    @Override
    public ApplicationModuleDescriber getDescriber() {
        return com.ba.usermanagement.modules.Modules.USER_LIST;
    }
}
