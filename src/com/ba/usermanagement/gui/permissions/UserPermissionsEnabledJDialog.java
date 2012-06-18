/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ba.usermanagement.gui.permissions;

import com.ba.usermanagement.permissions.UserControl;
import com.ib.HBCore.application.ApplicationModule;
import com.ib.HBCore.controllers.CoreController;
import com.ib.HBCore.entities.UserPermission.Permission;
import com.ib.HBCore.exceptions.ValidationException;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Window;
import javax.swing.JDialog;

/**
 *
 * @author Federico Saravia
 */
public abstract class UserPermissionsEnabledJDialog extends JDialog implements ApplicationModule {

    private final UserControl userControl = new UserControl();

    public UserPermissionsEnabledJDialog() throws Exception {
        checkPermissions();
    }

    public UserPermissionsEnabledJDialog(Dialog owner) throws Exception {
        super(owner);
        checkPermissions();
    }

    public UserPermissionsEnabledJDialog(Frame owner) throws Exception {
        super(owner);
        checkPermissions();
    }

    public UserPermissionsEnabledJDialog(Window owner) throws Exception {
        super(owner);
        checkPermissions();
    }

    public UserPermissionsEnabledJDialog(Dialog owner, String title) throws Exception {
        super(owner, title);
        checkPermissions();
    }

    public UserPermissionsEnabledJDialog(Dialog owner, boolean modal) throws Exception {
        super(owner, modal);
        checkPermissions();
    }

    public UserPermissionsEnabledJDialog(Frame owner, String title) throws Exception {
        super(owner, title);
        checkPermissions();
    }

    public UserPermissionsEnabledJDialog(Frame owner, boolean modal) throws Exception {
        super(owner, modal);
        checkPermissions();
    }

    public UserPermissionsEnabledJDialog(Window owner, ModalityType modalityType) throws Exception {
        super(owner, modalityType);
        checkPermissions();
    }

    public UserPermissionsEnabledJDialog(Window owner, String title) throws Exception {
        super(owner, title);
        checkPermissions();
    }

    public UserPermissionsEnabledJDialog(Dialog owner, String title, boolean modal) throws Exception {
        super(owner, title, modal);
        checkPermissions();
    }

    public UserPermissionsEnabledJDialog(Frame owner, String title, boolean modal) throws Exception {
        super(owner, title, modal);
        checkPermissions();
    }

    public UserPermissionsEnabledJDialog(Window owner, String title, ModalityType modalityType) throws Exception {
        super(owner, title, modalityType);
        checkPermissions();
    }

    public UserPermissionsEnabledJDialog(Dialog owner, String title, boolean modal, GraphicsConfiguration gc) throws Exception {
        super(owner, title, modal, gc);
        checkPermissions();
    }

    public UserPermissionsEnabledJDialog(Frame owner, String title, boolean modal, GraphicsConfiguration gc) throws Exception {
        super(owner, title, modal, gc);
        checkPermissions();
    }

    public UserPermissionsEnabledJDialog(Window owner, String title, ModalityType modalityType, GraphicsConfiguration gc) throws Exception {
        super(owner, title, modalityType, gc);
        checkPermissions();
    }

    private void checkPermissions() throws Exception {
        Permission checkUserPermission = userControl.checkUserPermission(this, CoreController.loggedUser);
        switch (checkUserPermission){
            case ACCES_DENIED:
                throw new ValidationException("Acceso denegado");
//            case ACCES_READ_ONLY:
//                enableReadOnly();
//                break;
            case ACCES_TOTAL:
                break;
        }
    }
    
//    protected abstract void enableReadOnly();
}
