/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import Vista.Cajero;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @version 1.0
 * @author Marco
 */
public class App extends Application{
    /**
     * inicia y lanza la ventana
     * @param args
     * @throws Exception 
     */
    public static void main (String args[]) throws Exception{        
        launch(args);
    }
    /**
     * inica la ventana de cajero
     * @param primaryStage
     * @throws Exception 
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Cajero cj = new Cajero();
        cj.show(primaryStage);
    }
}
