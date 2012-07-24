/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ba.usermanagement.gui.tableModel;

import com.ib.HBCore.entities.User;
import com.ib.modeloTabla.ConvierteAVector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Federico Saravia
 */
public class UserTableModel implements ConvierteAVector{
    
    private final User user;

    private UserTableModel(User user) {
        if(user == null){
            throw new NullPointerException("user=null");
        }
        this.user = user;
    }
    
    @Override
    public List<String> getTitulos() {
        final List<String> titles = new ArrayList<String>();
        titles.add("Nombre y apellido");
        titles.add("Nombre de usuario");
        return titles;
    }

    @Override
    public List<Object> getDatos() {
        final List<Object> data = new ArrayList<Object>();
        data.add(user.getName()+" "+user.getLastName());
        data.add(user.getUsername());
        return data;
    }

    @Override
    public void setValueAt(int posicion, Object value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }   
    
    public static List<UserTableModel> convert(List<User> userList){
        if(userList == null){
            userList = new ArrayList<User>();
        }
        List<UserTableModel> tableModels = new ArrayList<UserTableModel>();
        for (Iterator<User> it = userList.iterator(); it.hasNext();) {
            User user = it.next();
            tableModels.add(new UserTableModel(user));
        }
        return tableModels;
    }
}