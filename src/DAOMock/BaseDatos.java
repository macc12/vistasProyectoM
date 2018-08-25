/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOMock;

import java.util.ArrayList;

/**
 *
 * @author Marco
 */
public class BaseDatos {
    ArrayList<Usuario> usuarios = new ArrayList<>();
    public void addUser(Usuario user){
        usuarios.add(user);
    }
    public boolean exist(String nombre, String pass){
        for (int i = 0; i < usuarios.size(); i++) {            
            if(usuarios.get(i).getNombre().compareTo(nombre)==0 && usuarios.get(i).getPass().compareTo(pass)==0){
                return true;
            }
        }
        return false;
    }
    public boolean comprobar(String nombre, String pass){
        for (int i = 0; i < usuarios.size(); i++) {            
            if(usuarios.get(i).getNombre().compareTo(nombre)==0 && usuarios.get(i).getPass().compareTo(pass)==0&&
                    usuarios.get(i).getTipo().compareTo("Administrador")==0){
                return true;
            }
        }
        return false;
    }
}
