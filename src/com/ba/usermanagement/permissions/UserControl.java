/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ba.usermanagement.permissions;

import com.ib.HBCore.application.ApplicationModule;
import com.ib.HBCore.application.ApplicationModuleDescriber;
import com.ib.HBCore.controllers.CoreController;
import com.ib.HBCore.entities.User;
import com.ib.HBCore.entities.UserPermission;
import com.ib.HBCore.exceptions.ValidationException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Federico Saravia
 */
public class UserControl {

    private static final Properties LIBRARIES;

    static {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("Modules.properties");
        if (is != null) {
            LIBRARIES = new Properties();
            try {
                LIBRARIES.load(is);
                new UserControl().getModuleDescribers();//Init describers
            } catch (Exception iOException) {
                LIBRARIES.clear();
                Logger.getLogger(CoreController.class.getName()).log(Level.SEVERE, "Unable to load config file", iOException);
            }
        } else {
            LIBRARIES = null;
        }
    }

    private Properties getModuleList() {
        return LIBRARIES;
    }
    private final Comparator<ApplicationModuleDescriber> describersOrganizer = new Comparator<ApplicationModuleDescriber>() {

        @Override
        public int compare(ApplicationModuleDescriber o1, ApplicationModuleDescriber o2) {
            return o1.getModuleName().compareToIgnoreCase(o2.getModuleName());
        }
    };

    public Map<String, List<ApplicationModuleDescriber>> getModuleDescribers() throws Exception {
        Properties allLibraries = getModuleList();
        if (allLibraries != null && !allLibraries.isEmpty()) {
            Map<String, List<ApplicationModuleDescriber>> map = new HashMap<String, List<ApplicationModuleDescriber>>();
            for (Enumeration<Object> it = allLibraries.keys(); it.hasMoreElements();) {
                String groupId = it.nextElement().toString();//GroupId is the key of the .properties file
                String property = allLibraries.getProperty(groupId);
                InputStream tempIS = Thread.currentThread().getContextClassLoader().getResourceAsStream(property);
                if (tempIS != null) {
                    try {
                        Properties oneLibrary = new Properties();
                        oneLibrary.load(tempIS);
                        String groupName = oneLibrary.getProperty("group", "");
                        String moduleClass = oneLibrary.getProperty("modules");
                        String methodName = oneLibrary.getProperty("methodName");
                        Class<? extends ApplicationModuleDescriber> clazz = Class.forName(moduleClass).asSubclass(ApplicationModuleDescriber.class);
                        Method method = clazz.getMethod(methodName, new Class[]{});
                        List<ApplicationModuleDescriber> describers = map.get(groupName);
                        if (describers == null) {
                            describers = new ArrayList<ApplicationModuleDescriber>();
                        }
                        describers.addAll((List<ApplicationModuleDescriber>) method.invoke(null, new Object[]{}));
                        Collections.sort(describers, describersOrganizer);
                        for (Iterator<ApplicationModuleDescriber> it1 = describers.iterator(); it1.hasNext();) {
                            ApplicationModuleDescriber describer = it1.next();
                            describer.setGroupId(Integer.parseInt(groupId));
                        }
                        map.put(groupName, describers);
                    } catch (IllegalAccessException ex) {
                        throw new Exception("Couldn't acces the loader method for \"" + property + "\": " + ex.getLocalizedMessage(), ex);
                    } catch (InvocationTargetException ex) {
                        throw new Exception("Exception ocurred in loader method for \"" + property + "\": " + ex.getLocalizedMessage(), ex);
                    } catch (NoSuchMethodException ex) {//Couldn't find the static method
                        throw new Exception("Couldn't find the loader method for \"" + property + "\": " + ex.getLocalizedMessage(), ex);
                    } catch (SecurityException ex) {//Couldn't acces the required method
                        throw new Exception("Secutiry Exception trying to access the loader method of \"" + property + "\": " + ex.getLocalizedMessage(), ex);
                    } catch (ClassNotFoundException ex) {//Could not find ApplicationModuleDescriber
                        throw new Exception("Couldn't find the ApplicationModuleDescriber specified by \"" + property + "\": " + ex.getLocalizedMessage(), ex);
                    } catch (IOException ex) {//Couldn't read from InputSteam
                        throw new Exception("Couldn't read from InputStream for library \"" + property + "\": " + ex.getLocalizedMessage(), ex);
                    }
                }
            }
            return map;
        } else {
            return null;
        }
    }

    public UserPermission.Permission checkUserPermission(ApplicationModule module, User requester) throws ValidationException {
        if (LIBRARIES == null || LIBRARIES.isEmpty()) {//if user control is not configured grant access
            return UserPermission.Permission.ACCES_TOTAL;
        } else {
            ApplicationModuleDescriber describer = module.getDescriber();
            if (requester.isAdministrator()) {
                return UserPermission.Permission.ACCES_TOTAL;
            } else {
                for (Iterator<UserPermission> it = requester.getPermissions().iterator(); it.hasNext();) {
                    UserPermission userPermission = it.next();
                    if (userPermission.getModuleId() == describer.getFullModuleId()) {
                        return userPermission.getPermission();
                    }
                }
            }
            return UserPermission.Permission.ACCES_DENIED;
        }
    }
}