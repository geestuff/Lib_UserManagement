/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ba.usermanagement.gui.dialogs;

import com.ba.usermanagement.permissions.UserControl;
import com.ba.swingapphelper.gui.GUIMensajes;
import com.ib.HBCore.application.ApplicationModuleDescriber;
import com.ib.HBCore.entities.User;
import com.ib.HBCore.entities.UserPermission;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Federico Saravia
 */
public class UserPermissions extends com.ba.usermanagement.gui.permissions.UserPermissionsEnabledJDialog {

    private final UserControl userControl = new UserControl();
    private final User user;

    public static void showUserPermissions(javax.swing.JFrame parent, User user) throws Exception {
        UserPermissions dialog = new UserPermissions(parent, user);
        dialog.setLocationRelativeTo(parent);
        dialog.setVisible(true);
    }

    /**
     * Creates new form UserPermissions
     */
    public UserPermissions(javax.swing.JFrame parent, User user) throws Exception {
        super(parent, true);
        if (user == null) {
            throw new NullPointerException("user=null");
        }
        this.user = user;
        if(this.user.getPermissions() == null){
            this.user.setPermissions(new HashSet<UserPermission>());
        }
        initComponents();
        this.jLabel2.setText(this.user.toString());
        loadPermissions();
        pack();
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jTabbedPane1, gridBagConstraints);

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
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jPanel1, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Permisos del usuario:");
        jPanel2.add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel2.add(jLabel2);

        getContentPane().add(jPanel2, new java.awt.GridBagConstraints());

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel3.setText("<html><center>El usuario debe volver a iniciar sesión para que estos cambios tengan efecto</center></html>");
        jLabel3.setPreferredSize(new java.awt.Dimension(300, 60));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jLabel3, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        save();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * Overriding getRootPane() to be able to close de Dialog with Esc key
     */
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
    private final String modulePanelName = "MODULE_PANEL";

    private void loadPermissions() {
        try {
            Map<String, List<ApplicationModuleDescriber>> moduleList = userControl.getModuleDescribers();
            List<String> keyList = new ArrayList<String>(moduleList.keySet());
            Collections.sort(keyList);//Display in alhabetical order
            for (Iterator<String> it = keyList.iterator(); it.hasNext();) {
                String string = it.next();
                JPanel jPanel = fillJPanel(moduleList.get(string));
                jTabbedPane1.add(string, jPanel);
            }
        } catch (Exception ex) {
            GUIMensajes.mostrarErrorReportar(this, ex);
        }
    }

    private JPanel fillJPanel(List<ApplicationModuleDescriber> moduleList) {
        GridLayout layout = new GridLayout(moduleList.size(), 2, 3, 3);
        JPanel jPanel = new JPanel(layout);
        jPanel.setName(modulePanelName);
        for (Iterator<ApplicationModuleDescriber> it = moduleList.iterator(); it.hasNext();) {
            ApplicationModuleDescriber module = it.next();
            jPanel.add(new JLabel(module.getModuleName()));
            jPanel.add(createPermissionPanel(module));
        }
        return jPanel;
    }

    private JPanel createPermissionPanel(ApplicationModuleDescriber module) {
        JPanel jPanel = new JPanel();
        jPanel.add(createPermissionsCombo(module));
        jPanel.setName(String.valueOf(module.getFullModuleId()));
        return jPanel;
    }

    private JComboBox createPermissionsCombo(ApplicationModuleDescriber module) {
        JComboBox jComboBox = new JComboBox(UserPermission.Permission.values());
        for(Iterator<UserPermission> iterator = this.user.getPermissions().iterator();iterator.hasNext();){
            UserPermission next = iterator.next();
            if(next.getModuleId() == module.getFullModuleId()){
                jComboBox.setSelectedItem(next.getPermission());
                break;
            }
        }
        return jComboBox;
    }

    private void save() {
        final Set<UserPermission> permissions = new HashSet<UserPermission>();
        for (int i = 0; i < jTabbedPane1.getComponents().length; i++) {
            Component component = jTabbedPane1.getComponents()[i];
            if (component != null && component instanceof JPanel && component.getName().equals(modulePanelName)) {
                JPanel modulePanel = (JPanel) component;
                for (int j = 1; j < modulePanel.getComponents().length; j = j + 2) {
                    JPanel permissionPanel = (JPanel) modulePanel.getComponent(j);
                    int moduleId = Integer.parseInt(permissionPanel.getName());
                    JComboBox permissionsCombo = (JComboBox) permissionPanel.getComponent(0);
                    UserPermission.Permission permission = (UserPermission.Permission) permissionsCombo.getSelectedItem();
                    UserPermission up = new UserPermission();
                    up.setModuleId(moduleId);
                    up.setPermissionCode(permission.getCode());
                    permissions.add(up);
                }
            }

        }
        this.user.setPermissions(permissions);
        dispose();
    }

    @Override
    public ApplicationModuleDescriber getDescriber() {
        return com.ba.usermanagement.modules.Modules.USER_PERMISSIONS;
    }
}