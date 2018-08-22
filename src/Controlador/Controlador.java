/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.*;
import Modelo.DataBean;
import Modelo.Producto;
import Vista.Administrador;
import Vista.Cajero;
import Vista.Login;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    Producto p= new Producto("Arroz",1,20,2100);
    Arbol arbolP=new Arbol("Producto",p.getCodigoBarras(),p);
    public Controlador() {
    }
    public Controlador(Login ObjLogincito, DataBean modelo)throws IOException {
        this.ObjLogincito = ObjLogincito;
        this.ObjAdministradorcito = new Administrador(modelo);
        this.ObjCajerito=new Cajero(modelo);
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
    public void showAdministrador(){
        this.ObjAdministradorcito.showInvVentana(modelo.getPrimaryStage());
    }
    private class eventoLogin implements EventHandler<ActionEvent>{       
       
        @Override
        public void handle(ActionEvent event) {
            String user = ObjLogincito.GetUser();
            String pass = ObjLogincito.GetPass();            
           // showCajero();
            showAdministrador();
            ObjAdministradorcito.addEventBtnAgregar().setOnAction(new CrearProd());
            ObjAdministradorcito.addEventBtnInv().setOnAction(new eventoInv());
        }        
    }
    private class CrearProd implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
           p=new Producto(ObjAdministradorcito.getTxt_nombre(),Integer.parseInt(ObjAdministradorcito.getTxt_produc()),Integer.parseInt(ObjAdministradorcito.getTxt_cantidad()),Float.parseFloat(ObjAdministradorcito.getTxt_precio()));
            try {
                arbolP.addProducto(p.getNombre(),p.getCodigoBarras(), p.getCantidad(),p.getPrecio());
            } catch (IOException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private class eventoInv implements EventHandler<ActionEvent>{       
       
        @Override
        public void handle(ActionEvent event) {
            ObjAdministradorcito.showInvVentana(modelo.getPrimaryStage());
        }
    }
}

