/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import Controlador.Controlador;
import Modelo.DataBean;
import Vista.Administrador;
import Vista.Cajero;
import Vista.Login;
import java.io.FileNotFoundException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

/**
 * @version 1.0
 * @author Marco
 */
public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }
      
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        // ambito de sesión / ámbito de aplicación ¡inicializar beans!
        // necesita ser pasado el controlador de la aplicacion
       DataBean dataBean = new DataBean(primaryStage);
       Administrador ad = null;
       Cajero caj = null;
       Login lo = new Login(dataBean);
       // LLamar el primer controlador
       Controlador cont = new Controlador(lo, dataBean);
       cont.show();      
    }
    
}
