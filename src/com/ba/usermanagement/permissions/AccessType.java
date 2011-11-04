/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ba.usermanagement.permissions;

import com.ib.HBCore.entities.UserPermission;

/**
 *
 * @author FSB
 */
public enum AccessType {

    ACCESS_DENIED("Sin Acceso",UserPermission.PERMISSION_ACCES_DENIED),
    READ_ONLY("Solo lectura",UserPermission.PERMISSION_READ_ONLY),
    CREATE_ONLY("",UserPermission.PERMISSION_READ_ONLY),
    TOTAL("Acceso total",UserPermission.PERMISSION_ACCESS_GRANTED);

    private String name;
    private int id;

    AccessType(String name,int id) {
        this.name = name;
        this.id = id;
    }

    public static AccessType getAccessPermission(int type){
        switch (type){
            case UserPermission.PERMISSION_ACCESS_GRANTED:
                return TOTAL;
            case UserPermission.PERMISSION_ACCES_DENIED:
                return ACCESS_DENIED;
            case UserPermission.PERMISSION_READ_ONLY:
                return READ_ONLY;
            default:
                return ACCESS_DENIED;
        }
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
