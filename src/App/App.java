/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import Controlador.Controlador;
import Vista.Administrador;
import Vista.Cajero;
import Vista.Login;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @version 1.0
 * @author Marco
 */
public class App {
    /**
     * inicia y lanza la ventana
     * @param args
     * @throws Exception 
     */
    /*  */  
    public static void main (String args[]) throws FileNotFoundException{
        Login log = new Login();
        Cajero cj=new Cajero();
        Administrador ad=new Administrador();
        Controlador ct;
        ct= new Controlador(log, ad, cj);
        System.out.println("hola");
    } 
    
}
