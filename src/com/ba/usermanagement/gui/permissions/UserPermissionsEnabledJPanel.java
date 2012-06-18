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
import java.awt.LayoutManager;
import javax.swing.JPanel;

/**
 *
 * @author Federico Saravia
 */
public abstract class UserPermissionsEnabledJPanel extends JPanel implements ApplicationModule {

    private final UserControl userControl = new UserControl();

    public UserPermissionsEnabledJPanel() throws Exception {
        checkPermissions();
    }

    public UserPermissionsEnabledJPanel(LayoutManager layout) throws Exception {
        super(layout);
        checkPermissions();
    }

    public UserPermissionsEnabledJPanel(boolean isDoubleBuffered) throws Exception {
        super(isDoubleBuffered);
        checkPermissions();
    }

    public UserPermissionsEnabledJPanel(LayoutManager layout, boolean isDoubleBuffered) throws Exception {
        super(layout, isDoubleBuffered);
        checkPermissions();
    }

    private void checkPermissions() throws Exception {
        Permission checkUserPermission = userControl.checkUserPermission(this, CoreController.loggedUser);
        switch (checkUserPermission) {
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
