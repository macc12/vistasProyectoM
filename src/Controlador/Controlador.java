/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.DataBean;
import Vista.Administrador;
import Vista.Cajero;
import Vista.Login;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author LabingXEON
 */
public class Controlador {
    private Login ObjLogincito;
    private Administrador ObjAdministradorcito;
    private Cajero ObjCajerito;   
    private Scene myScene;
    private DataBean modelo;
    
    public Controlador() {
    }
    public Controlador(Login ObjLogincito, Administrador ObjAdministradorcito, Cajero ObjCajerito, DataBean modelo) {
        this.ObjLogincito = ObjLogincito;
        this.ObjAdministradorcito = ObjAdministradorcito;
        this.ObjCajerito = ObjCajerito;
        this.modelo = modelo;
        
        
        //agregar eventos a los botones
        ObjLogincito.addEventBtn().setOnAction(new eventoLogin());
    }
    /*
    public Controlador(Login ObjLogincito, DataBean modelo) {
        this.ObjLogincito = ObjLogincito;
        this.modelo = modelo;
    }
    */
    public void show (){
      this.ObjLogincito.show(modelo.getPrimaryStage());
    } 
    public void showCajero(){
        this.ObjCajerito.show(modelo.getPrimaryStage());
    }
    private class eventoLogin implements EventHandler<ActionEvent>{       
       
        @Override
        public void handle(ActionEvent event) {
            String user = ObjLogincito.GetUser();
            String pass = ObjLogincito.GetPass();            
            showCajero();
        }        
    }
}

