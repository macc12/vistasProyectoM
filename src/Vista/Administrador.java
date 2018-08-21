package Vista;

import java.beans.EventHandler;
import java.io.FileInputStream;
import java.util.Set;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.XYChart;
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
/**
 * @version 1.0
 * @author Marco
 */
public class Administrador {
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
    private TextField txt_cantidad;
    private TextField txt_nombre;   
    private TextField txt_precio;        
    private Button btn_agregar;
    private HBox hboxg;
    private Stage stage;
    private Button btn_VentProduc;
    private Button btn_VentVendPeriodo;
    private Button btn_VentMes;
    private Button btn_CumpMetas;
    private VBox root2;
    private GridPane grPast;
    private ObservableList<Data> data2d = FXCollections.observableArrayList();
    private PieChart pieChart;
    private GridPane grBarr;
    private XYChart.Series series1[];
    private GridPane grLine;
    private XYChart.Series series2[];
    private LineChart<String, Number> line;
    /**
     * crea un Scene y le agrega elementos
     */    
    public void invVentana() {
        root = new VBox();        
        root.getChildren().add(getHBox());
        root.getChildren().add(getPane2());
        root.getChildren().add(getHBox2());
        root.getChildren().add(getVBox());
                      
        scene = new Scene(root, 1000, 700);        
    }
    /**
     * muestra la ventana de inventario
     * @param stage 
     */
    public void showInvVentana(Stage stage){
        this.stage = stage;
        stage.setResizable(false);
        stage.setTitle("POS");
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * crea un Pane y le agrega elementos
     * @return Pane
     */
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
    /**
     * crea un Pane y le agrega elementos
     * @return Pane
     */
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
    /**
     * crea un VBox y le agrega elementos
     * @return vbox 
     */
    public VBox getVBox(){
        vbox = new VBox();
        vbox.getChildren().add(getPane());
        return vbox;
    }
    /**
     * crea un HBox y le agreaga elementos
     * @return hbox
     */
    private HBox getHBox() {
        try{
            hbox = new HBox();
            //importar imagenes     
            FileInputStream input = 
                new FileInputStream("Recursos/home.png");
            FileInputStream input2 = 
                new FileInputStream("Recursos/sales.png");
            FileInputStream input3 = 
                new FileInputStream("Recursos/carton.png");
            FileInputStream input4 = 
                new FileInputStream("Recursos/grafi.png");
            
            Image image = new Image(input);
            Image image1 = new Image(input2);
            Image image2 = new Image(input3);
            Image image3 = new Image(input4);
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
    /**
     * crea un HBox y le agreaga elementos
     * @return hbox
     */
    public HBox getHBox2(){
        GridPane panei = new GridPane();
        panei.setHgap(10);
        panei.setVgap(10);        
        hbox2 = new HBox();                
        txt_produc = new TextField();        
        txt_cantidad = new TextField();
        
        panei.add(new Label("Codigo Producto"), 0, 1);
        panei.add(txt_produc, 1, 1);
        panei.add(new Label("Cantidad Producto"), 0, 3);
        panei.add(txt_cantidad, 1, 3);
        
        GridPane panec = new GridPane();
        panec.setHgap(10);
        panec.setVgap(10);
        txt_cantidad = new TextField();
        txt_precio = new TextField();      
        
        panec.add(new Label("Nombre"), 0, 1);
        panec.add(txt_cantidad, 1, 1);        
        panec.add(new Label("Precio"), 0, 3);
        panec.add(txt_precio, 1, 3);
        
        GridPane paned = new GridPane();
        paned.setHgap(10);
        paned.setVgap(10);
                        
        btn_agregar = new Button("Agregar");
                                        
        paned.add(btn_agregar, 2, 5);
        
        hbox2.getChildren().add(panei);
        hbox2.getChildren().add(panec);
        hbox2.getChildren().add(paned);
        
        
        return hbox2;
    }
    //--------------------------------------------------------------------------
    //                     second stage graficas
    //--------------------------------------------------------------------------
    
    /**
     * crea la ventana inicial de las graficas
     * @throws Exception 
     */
    public void GrafVentana() throws Exception {        
        root2 = new VBox();        
        root2.getChildren().add(getHBox());
        root2.getChildren().add(getHBoxg());
        scene = new Scene(root2, 1000, 700);
        
    }
    /**
     * crea la ventana de graficas con la grafica de ventas por producto
     * @throws Exception 
     */
    public void GrafVentanaWtVentPr() throws Exception {
        root2 = new VBox();        
        root2.getChildren().add(getHBox());
        root2.getChildren().add(getHBoxg());
        root2.getChildren().add(getGraf1());
        scene = new Scene(root2, 1000, 700);
        
    }
    /**
     * crea la ventana de graficas con la grafica de ventas de vendedor por periodo
     * @throws Exception 
     */
    public void GrafVentanaWtVentVen() throws Exception {
        root2 = new VBox();        
        root2.getChildren().add(getHBox());
        root2.getChildren().add(getHBoxg());
        root2.getChildren().add(getGr2());
        scene = new Scene(root2, 1000, 700);
        
    }
    /**
     * crea la ventana de graficas con la grafica de linea
     * @throws Exception 
     */
    public void GrafVentanaWtGarfLine() throws Exception {
        root2 = new VBox();        
        root2.getChildren().add(getHBox());
        root2.getChildren().add(getHBoxg());
        root2.getChildren().add(getGrLine());
        scene = new Scene(root2, 1000, 700);
        
    }
    /**
     * muestra la ventana de graficas con sus componentes
     * @param stage 
     */
    public void showGrafventana(Stage stage){
        this.stage = stage;
        stage.setResizable(false);
        stage.setTitle("POS");
        stage.setScene(scene);
        stage.show();
    }
    /**
     * crea un Hbox y le agrega elementos
     * @return hboxg
     */
    public HBox getHBoxg(){        
        hboxg = new HBox();
        btn_VentProduc = new Button("Ventas por Producto");
        btn_VentVendPeriodo = new Button("Ventas Vendedor Periodo");
        btn_VentMes = new Button("Ventas por Mes");
        btn_CumpMetas = new Button("Cumplimiento de metas");
        hboxg.getChildren().add(btn_VentProduc);
        hboxg.getChildren().add(btn_VentVendPeriodo);
        hboxg.getChildren().add(btn_VentMes);
        hboxg.getChildren().add(btn_CumpMetas);
        return hboxg;
    }
    
    //grafico circular 
    /**
     * crea un Pane con la grafica de pastel
     * @return grPast
     */
    public Pane getGraf1(){
        grPast = new GridPane();
        pieChart = new PieChart();
        pieChart.setTitle("Porcentaje");
        pieChart.setData(getChartData());  
        grPast.add(pieChart, 0, 0);                
        return grPast;
    }
    /**
     * Getter
     * @return data2d 
     */
    private ObservableList<Data> getChartData() {                          
        return data2d;
    }
    /**
     * Setter: agrega una ObservableList y asigna los colores de la grafica
     * @param data 
     */
    private void setChartData(ObservableList<Data> data) {        
        data2d = data;  
        updateColors();
    }
    /**
     * asigna los colores a los elementos de la grafica
     */    
    private void updateColors(){    
        //colores para cada seccion de la torta
        Color[] colors = new Color[data2d.size()];
        for (int j = 0; j < data2d.size(); j++) {            
            colors[j] = Color.web(generateRandomColor());
        }
        int i = 0;
        //cambia colores de cada seccion de la torta
        for (PieChart.Data data : data2d) {
            String hex = String.format( "#%02X%02X%02X",
                        (int)( colors[i].getRed() * 255 ),
                        (int)( colors[i].getGreen() * 255 ),
                        (int)( colors[i].getBlue() * 255 ) );
              data.getNode().setStyle( "-fx-pie-color: "+hex+";");
              i++;
        }
        //cambia colores de la leyenda
        Set<Node> items;items = pieChart.lookupAll("Label.chart-legend-item");
        i = 0;            
        for (Node item : items) {
            Label label = (Label) item;
            final Rectangle rectangle = new Rectangle(20, 20, colors[i]);                
            label.setGraphic(rectangle);
            i++;
        }
    }
    /**
     * genera el codigo de un color rbg hexadecimal de manera aleatoria
     * @return color: id de color en rgb hexadecimal 
     */
    private static String generateRandomColor(){
	String[] letters = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
	String color = "#";
	for (int i = 0; i < 6; i++ ) {
	    color += letters[(int) Math.round(Math.random() * 15)];
	}
	return color;
    }
    //grafico 2 / barras
    
    /**
     * crea un pane y le agrega elementos
     * @return grBarr 
     */
    public Pane getGr2(){
        grBarr = new GridPane();
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String,Number> bc = 
            new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Procentaje");
        xAxis.setLabel("Vendedor");       
        yAxis.setLabel("Valor");
        bc.getData().addAll(getSeriesGarfBarr());
        grBarr.add(bc, 0, 0);
        
        return grBarr;
    }   
    /**
     * Setter: agrega un vector con los valores para la grafica de barras
     * @param sere 
     */
    public void setSeriesGrafBarra(XYChart.Series[] sere){
        this.series1 = sere;
    }
    /**
     * Getter: entrega el vector con los valore para la grafica
     * @return series1 
     */
    public XYChart.Series[] getSeriesGarfBarr(){
        return series1;
    }
     
    //--------------------------------------------------------------------------
    //                   grafica 3 / linea
    //--------------------------------------------------------------------------
    /**
     * crea un pane y le agrega elementos
     * @return grLine 
     */
    public Pane getGrLine(){
        grLine = new GridPane();
        line.getData().addAll(getSeriesGarfLine());
        return grLine;
    }
    /**
     * Setter: asigna los valores para la grafica
     * @param sere 
     */
    public void setSeriesGrafLine(XYChart.Series[] sere){
        this.series2 = sere;
    }
    /**
     * Getter: entrega el vector de los valores para la grafica
     * @return series2
     */
    public XYChart.Series[] getSeriesGarfLine(){
        return series2;
    }   
    
    
    //eventos botones
    /**
     * permite agregar un evento al boton home
     * @param event 
     */
    public void addEventBtnHome(EventHandler event){
        btn_hom.setOnAction((javafx.event.EventHandler<ActionEvent>) event);
    }
    /**
     * permite agregar un evento al boton inventario
     * @param event 
     */    
    public void addEventBtnInv(EventHandler event){
        btn_invent.setOnAction((javafx.event.EventHandler<ActionEvent>) event);
    }
    /**
     * permite agregar un evento al boton Reporte
     * @param event 
     */
    public void addEventBtnReport(EventHandler event){
        btn_repor.setOnAction((javafx.event.EventHandler<ActionEvent>) event);
    }
    /**
     * permite agregar un evento al boton Agregar
     * @param event 
     */
    public void addEventBtnAgregar(EventHandler event){
        btn_agregar.setOnAction((javafx.event.EventHandler<ActionEvent>) event);
    }
    /**
     * permite agregar un evento al boton Ventas producion
     * @param event 
     */
    public void addEventBtnPorVentProdu(EventHandler event){
        btn_VentProduc.setOnAction((javafx.event.EventHandler<ActionEvent>) event);
    }
    /**
     * permite agregar un evento al boton ventas periodo
     * @param event 
     */
    public void addEventBtnVentPeri(EventHandler event){
        btn_VentVendPeriodo.setOnAction((javafx.event.EventHandler<ActionEvent>) event);
    }
    /**
     * permite agregar un evento al boton ventas por mes
     * @param event 
     */
    public void addEventBtnVentMes(EventHandler event){
        btn_VentMes.setOnAction((javafx.event.EventHandler<ActionEvent>) event);
    }
    /**
     * permite agregar un evento al boton metas cumplidas
     * @param event 
     */
    public void addEventBtnMetasCum(EventHandler event){
        btn_CumpMetas.setOnAction((javafx.event.EventHandler<ActionEvent>) event);
    }
    //funciones tabla
    /**
     * permite agregar eleentos a la tabla
     * @param data 
     */
    public void agregarTabla(ObservableList data){
        table.setItems(data);
    }
    /**
     * elimina todos los elemntos de la tabla
     */
    public void clearTable() {
        table.getItems().clear();
    }
    /**
     * agrega el nombre al textLabel para mostrarlo
     * @param nombre 
     */
    public void addNombre(String nombre){
        txt_nomb.setText(nombre);
    }
    /**
     * agrega la fecha al textLabel para mostrarla
     * @param fecha 
     */
    public void addFecha(String fecha){
        txt_fecha.setText(fecha);
    }
}
