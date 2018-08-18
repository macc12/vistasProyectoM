package Vista;

import java.beans.EventHandler;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private VBox root;
    private VBox vbox;
    private HBox hbox;
    private Button btn_hom;
    private Button btn_sales;
    private Button btn_invent;
    private Button btn_repor;
    private TableView table;
    private TableColumn nro;
    private TableColumn codigo;
    private TableColumn nombre;
    private TableColumn cantidad;
    private TableColumn precioUni;
    private TableColumn precioTot;
    private GridPane pane2;
    private TextField txt_nomb;
    private TextField txt_fecha;
    private HBox hbox2;
    private TextField txt_produc;
    private Button btn_buscar;
    private TextField txt_cantidad;
    private Button btn_agreg;
    private TextField txt_dinero;
    private Button btn_pago;
    private TextField txt_cambio;
    private TextField txt_total;
    private Button btn_eliminar;
    private Button btn_imprimir;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        root = new VBox();
        
        root.getChildren().add(getHBox());
        root.getChildren().add(getVBox());
        root.getChildren().add(getHBox2());
        
        
        scene = new Scene(root, 1000, 700);
        primaryStage.setResizable(false);
        primaryStage.setTitle("POS");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private Pane getPane(){
        pane = new GridPane();        
        table = new TableView();
        table.setEditable(true);
        nro = new TableColumn("n°");
        codigo = new TableColumn("Codigo");
        nombre = new TableColumn("Nombre");
        cantidad = new TableColumn("Catidad");
        precioUni = new TableColumn("Precio Unidad");
        precioTot = new TableColumn("Precio Total");
        
        nro.setCellValueFactory(new PropertyValueFactory<>("n°"));
        codigo.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
        nombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        cantidad.setCellValueFactory(new PropertyValueFactory<>("Cantidad"));
        precioUni.setCellValueFactory(new PropertyValueFactory<>("Precio Unidad"));
        precioTot.setCellValueFactory(new PropertyValueFactory<>("Precio Total"));
        table.getColumns().addAll(nro,codigo,nombre,cantidad,precioUni,precioTot);
        pane.add(table, 0, 0);
        return pane;
    }
    public Pane getPane2(){
        pane2 = new GridPane();
        txt_fecha = new TextField();
        txt_nomb = new TextField();
        txt_nomb.setEditable(false);
        txt_fecha.setEditable(false);
        pane2.add(new Label("Nombre"), 0, 0);
        pane2.add(txt_nomb, 1, 0);
        pane2.add(new Label("Fecha"), 0, 1);
        pane2.add(txt_fecha, 1, 1);
        return pane2;
    }
    public VBox getVBox(){
        vbox = new VBox();
        vbox.getChildren().add(getPane2());
        vbox.getChildren().add(getPane());
        return vbox;
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
    /*
    -------------------AQUI---------------------
    -------------------AQUI---------------------
    -------------------AQUI---------------------
    -------------------AQUI---------------------
    */
    public HBox getHBox2(){
        GridPane panei = new GridPane();
        panei.setHgap(10);
        panei.setVgap(10);        
        hbox2 = new HBox();                
        txt_produc = new TextField();
        btn_buscar = new Button("Buscar");
        txt_cantidad = new TextField();
        btn_agreg = new Button("Agregar");
        
        panei.add(new Label("Codigo Producto"), 0, 1);
        panei.add(txt_produc, 1, 1);
        panei.add(btn_buscar, 2, 1);
        panei.add(new Label("Cantidad Producto"), 0, 3);
        panei.add(txt_cantidad, 1, 3);
        panei.add(btn_agreg, 2, 3);
        
        GridPane panec = new GridPane();
        panec.setHgap(10);
        panec.setVgap(10);
        txt_cantidad = new TextField();
        btn_pago = new Button("Pago");
        txt_cambio = new TextField();
        txt_cambio.setEditable(false);
        
        panec.add(new Label("Dinero"), 0, 1);
        panec.add(txt_cantidad, 1, 1);
        panec.add(btn_pago, 2, 1);
        panec.add(new Label("Cambio"), 0, 3);
        panec.add(txt_cambio, 1, 3);
        
        GridPane paned = new GridPane();
        paned.setHgap(10);
        paned.setVgap(10);
        txt_total = new TextField();
        btn_eliminar = new Button("    Eliminar    ");
        btn_imprimir = new Button("    Imprimir    ");
        
        paned.add(new Label("Total"), 1, 1);
        paned.add(txt_total, 2, 1);
        paned.add(btn_eliminar, 2, 3);
        paned.add(btn_imprimir, 2, 5);
        
        hbox2.getChildren().add(panei);
        hbox2.getChildren().add(panec);
        hbox2.getChildren().add(paned);
        
        
        return hbox2;
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
    public void agregarTabla(ObservableList data){
        table.setItems(data);
    }
    public void clearTable() {
        table.getItems().clear();
    }
    public void addNombre(String nombre){
        txt_nomb.setText(nombre);
    }
    public void addFecha(String fecha){
        txt_fecha.setText(fecha);
    }
}
