/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ba.usermanagement.permissions;

import com.ib.HBCore.entities.User;

/**
 *
 * @author Federico Saravia
 */
public enum UserLevel{
    USER,SUPERVISOR,ADMINISTRATOR;
    
    public boolean hasRequiredLevel(User user){
        if(this == ADMINISTRATOR){
            return user.isAdministrator();
        }
        if(this == SUPERVISOR){
            return user.isSupervisor() || user.isAdministrator();
        }
        return true;
    }
}
