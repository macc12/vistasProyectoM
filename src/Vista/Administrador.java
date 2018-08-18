package Vista;

import java.beans.EventHandler;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Marco
 */
public class Administrador extends Application{
    private GridPane pane;
    private Scene scene;
    private BorderPane root;
    private VBox vbox;
    private HBox hbox;
    private Button btn_hom;
    private Button btn_sales;
    private Button btn_invent;
    private Button btn_repor;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        root = new BorderPane();
        scene = new Scene(root, 1000, 700);
        root.setTop(getHBox());
        
        
        
        
        primaryStage.setResizable(false);
        primaryStage.setTitle("POS");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private Pane getPane(){
        return null;
    }
    private HBox getHBox() {
        try{
            hbox = new HBox();
            //importar imagenes     
            Image image = new Image("/Recursos/home.png");
            Image image1 = new Image("/Recursos/sales.png");
            Image image2 = new Image("/Recursos/carton.png");
            Image image3 = new Image("/Recursos/grafi.png");
            //crear botones
            btn_hom = new Button("", new ImageView(image));        
            btn_sales = new Button("", new ImageView(image1));
            btn_invent = new Button("", new ImageView(image2));
            btn_repor = new Button("", new ImageView(image3));
            //agregar botones al HBox            
            hbox.getChildren().add(btn_hom);
            hbox.getChildren().add(btn_sales);
            hbox.getChildren().add(btn_invent);
            hbox.getChildren().add(btn_repor);            
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return hbox;
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    //eventos botones
    public void addEventBtnHome(EventHandler event){
        btn_hom.setOnAction((javafx.event.EventHandler<ActionEvent>) event);
    }
    public void addEventBtnSales(EventHandler event){
        btn_sales.setOnAction((javafx.event.EventHandler<ActionEvent>) event);
    }
    public void addEventBtnInv(EventHandler event){
        btn_invent.setOnAction((javafx.event.EventHandler<ActionEvent>) event);
    }
    public void addEventBtnReport(EventHandler event){
        btn_repor.setOnAction((javafx.event.EventHandler<ActionEvent>) event);
    }
}
