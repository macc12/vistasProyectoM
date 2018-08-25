/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAOMock.BaseDatos;
import DAOMock.Usuario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Marco
 */
public class RegistroController implements Initializable{
    //______________________________
    //______________________________
    BaseDatos bd = new BaseDatos();
    //______________________________
    //______________________________
    
    
    
    @FXML
    private PasswordField TFclave;

    @FXML
    private TextField TFuser;
    
    @FXML
    private Button BCancelar;
    
    @FXML
    private Button BRegistrarse;
    
    @FXML
    private ComboBox CBTipoUser;
    
    @FXML
    private void ActionRegistrarse(EventHandler event){
        this.BRegistrarse.setOnAction((javafx.event.EventHandler<ActionEvent>) event);
    }
    
    @FXML
    private void ActionCancel(EventHandler event){
        this.BCancelar.setOnAction((javafx.event.EventHandler<ActionEvent>) event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    class eventoRegistro implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            try {
                String user = TFuser.getText();
                String pass = TFclave.getText();
                String tipo = CBTipoUser.getValue().toString();
                Usuario temp = new Usuario(user, pass, tipo);
                bd.addUser(temp);
                
                Parent inicioParent = FXMLLoader.load(getClass().getResource("src/Vista/Inicio.fxml"));
                Scene inicioScene = new Scene(inicioParent);
                Stage inicioStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                inicioStage.setScene(inicioScene);
                inicioStage.show();
            } catch (Exception e) {
            }
        }
        
    }
    
    class eventoCancelar implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            try {
                Parent inicioParent = FXMLLoader.load(getClass().getResource("src/Vista/Inicio.fxml"));
                Scene inicioScene = new Scene(inicioParent);
                Stage inicioStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                inicioStage.setScene(inicioScene);
                inicioStage.show();
            } catch (Exception e) {
            }
        }
        
    }
}
