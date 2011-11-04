/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ba.usermanagement.permissions;

import com.ib.HBCore.controllers.UserController;
import com.ib.HBCore.entities.User;
import com.ib.HBCore.entities.UserPermission;

/**
 *
 * @author Federico Saravia
 */
public abstract class PermissionControllerInterface {

    private final UserController controller = new UserController();

    public AccessType checkPermissionToUse(String className, User loggedUser) {
        if (loggedUser == null) {
            return AccessType.ACCESS_DENIED;
        }
        int moduleId = getModuleId(className);
        UserLevel requiredLevel = getRequiredUserLevel(moduleId);
        if (!requiredLevel.hasRequiredLevel(loggedUser)) {
            return AccessType.ACCESS_DENIED;
        }
        return getPermissionType(loggedUser, moduleId);
    }

    private AccessType getPermissionType(User loggedUser, int moduleId) {
        if (loggedUser.isAdministrator()) {
            return AccessType.TOTAL;
        } else {
            UserPermission permission = controller.checkPermission(loggedUser, moduleId);
            if (permission == null) {
                return AccessType.ACCESS_DENIED;
            } else {
                return AccessType.getAccessPermission(permission.getPermission());
            }
        }
    }

    protected abstract int getModuleId(String className);

    protected abstract UserLevel getRequiredUserLevel(int moduleId);
}
