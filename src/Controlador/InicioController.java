package Controlador;

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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InicioController implements Initializable{
    
    @FXML
    private PasswordField TFclave;

    @FXML
    private TextField TFuser;
    
    @FXML
    private Button BIniciarSesion;
    
    @FXML
    private Button BRegistrarse;

    public InicioController() {
        IniciarSesion(new eventoIniciarSesion());
        ActionRegistrarse(new eventoRegistro());
    }
    
    
    
    @FXML
    private void IniciarSesion(EventHandler event){
        this.BIniciarSesion.setOnAction((javafx.event.EventHandler<ActionEvent>) event);
    }
    
    @FXML
    private void ActionRegistrarse(EventHandler event){
        this.BRegistrarse.setOnAction((javafx.event.EventHandler<ActionEvent>) event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    class eventoIniciarSesion implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            String user = TFuser.getText();
            String pass = TFclave.getText();
        }
        
    }
    class eventoRegistro implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            try {
                Parent inicioParent = FXMLLoader.load(getClass().getResource("src/Vista/Registro.fxml"));
                Scene inicioScene = new Scene(inicioParent);
                Stage inicioStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                inicioStage.setScene(inicioScene);
                inicioStage.show();
            } catch (Exception e) {
            }
        }
        
    }

}

