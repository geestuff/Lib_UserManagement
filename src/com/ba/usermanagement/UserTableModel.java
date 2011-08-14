/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ba.usermanagement;

import com.ib.HBCore.entities.User;
import com.ib.modeloTabla.ConvierteAVector;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Federico Saravia
 */
public class UserTableModel implements ConvierteAVector {

    private final User user;

    private UserTableModel(User user) {
        if (user == null) {
            throw new NullPointerException("User cannot be null when creating a table model");
        }
        this.user = user;
    }

    public static List<UserTableModel> convert(Collection<User> list) {
        if(list == null){
            list = new ArrayList<User>();
        }
        List<UserTableModel> vector = new ArrayList<UserTableModel>(list.size());
        for (Iterator<User> it = list.iterator(); it.hasNext();) {
            final UserTableModel utm = new UserTableModel(it.next());
            vector.add(utm);
        }
        return vector;
    }

    @Override
    public List<String> getTitulos() {
        List<String> titulos = new ArrayList<String>();
        titulos.add("Nombre de usuario");
        titulos.add("Nombre");
        titulos.add("Apellido");
        titulos.add("Último acceso");
        titulos.add("Administrador?");
        return titulos;
    }

    @Override
    public List<Object> getDatos() {
        List<Object> data = new ArrayList<Object>();
        data.add(user.getUsername());
        data.add(user.getNombres());
        data.add(user.getApellidos());
        data.add(DateFormat.getDateInstance().format(user.getUltimoAcceso().getTime()));
        data.add(user.getAdministrador().booleanValue());
        return data;

    }

    @Override
    public void setValueAt(int posicion, Object value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }
}
