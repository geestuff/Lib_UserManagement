/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ba.usermanagement.modules;

import com.ib.HBCore.application.ApplicationModuleDescriber;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Federico Saravia
 */
public enum Modules implements ApplicationModuleDescriber {

    USER_DATA(0, "Ver/Editar datos de usuarios"),
    USER_PERMISSIONS(1, "Configurar permisos de usuarios"),
    USER_LIST(2, "Listar usuarios");
    private final String moduleName;
    private final int moduleId;
    private int groupId;

    private Modules(int moduleCode, String moduleName) {
        this.moduleId = moduleCode;
        this.moduleName = moduleName;
    }

    /**
     * @return the moduleName
     */
    @Override
    public String getModuleName() {
        return moduleName;
    }

    /**
     * @return the moduleCode
     */
    public int getModuleId() {
        return moduleId;
    }
    
        @Override
    public int getFullModuleId() {
        return Integer.parseInt(String.valueOf(groupId) + String.valueOf(moduleId));
    }
    /**
     * @param groupId the groupId to set
     */
    @Override
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public static List<ApplicationModuleDescriber> all() {
        return Arrays.<ApplicationModuleDescriber>asList(Modules.values());
    }
}
