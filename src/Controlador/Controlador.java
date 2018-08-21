/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Vista.Administrador;
import Vista.Cajero;
import Vista.Login;
import javafx.application.Application;
import javafx.stage.Stage;
/**
 *
 * @author LabingXEON
 */
public class Controlador extends Application{
    private Login ObjLogincito;
    private Administrador ObjAdministradorcito;
    private Cajero ObjCajerito;
    private Stage primaryStage;
    public Controlador() {
    }
    public Controlador(Login ObjLogincito, Administrador ObjAdministradorcito, Cajero ObjCajerito) {
        this.ObjLogincito = ObjLogincito;
        this.ObjAdministradorcito = ObjAdministradorcito;
        this.ObjCajerito = ObjCajerito;
        try {
            start(primaryStage);
        } catch (Exception e) {
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
         ObjLogincito.ini();
         System.out.println("hola");
         ObjLogincito.show(primaryStage);
    }  
}
