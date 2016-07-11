/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skrappydb;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class SkrappyDB extends Application {
    
    //Application main Components 
    BorderPane pane = new BorderPane(); 
    Scene scene; 
    ListingBook lb = new ListingBook();
    TableView<Listing> news;
    ObservableList<Listing> array; 
            
   //border.TOP componenets
    HBox hbox;
    Button btnCurrent; 
    Button btnCharts; 
    
   //border.CENTER components
   
   //border.BOTTOM componets 
    
    //border.LEFT components 
     VBox vbox; 
    Hyperlink[] websites; 
    Text title; 
    
    @Override
    public void start(Stage primaryStage) {
       
        //Set up mongo connection and create observavble list
        MongoConnection connection = new MongoConnection();
        array = connection.getTableListings("penews");
        
        //create the table from the database 
        news = createTable(array);
    
        //--> Add the search features onto the pane.RIGHT
        
        //add componenets to the window
        pane.setTop(topStream());
        pane.setLeft(leftStream());
        pane.setCenter(news);
        
        scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Skrappy DB");
        primaryStage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public HBox topStream(){
        hbox = new HBox();
        hbox.setPadding(new Insets(15,12,15,12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699");
        
        btnCurrent = new Button("Current"); 
        btnCurrent.setDisable(true);
        btnCurrent.setPrefSize(100, 20);
        
        btnCharts = new Button("Charts"); 
        btnCharts.setPrefSize(100, 20);
        
        hbox.getChildren().addAll(btnCurrent, btnCharts); 
        return hbox;
    }
    
    public VBox leftStream(){
        vbox = new VBox(); 
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        
        title = new Text("Websites"); 
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        vbox.getChildren().add(title);
        
        websites = new Hyperlink[] {
            new Hyperlink("Penews"),
            new Hyperlink("Global"),
            new Hyperlink("Daily news"),
            new Hyperlink("Cotswarner")
        };
        
        for(int i = 0; i < 4; i++){
            VBox.setMargin(websites[i], new Insets(0, 0, 0, 8));
            vbox.getChildren().add(websites[i]);
        }
        
        return vbox; 
    }
    
    public TableView<Listing> createTable(ObservableList<Listing> arrayListings){
        
        TableView<Listing> book = new TableView<>();
        book.setItems(arrayListings);
        
        TableColumn<Listing, String> colHeading = new TableColumn("Headline");
                colHeading.setMinWidth(300);
                colHeading.setCellValueFactory(
                    new PropertyValueFactory<Listing, String>("Headline"));
                
        TableColumn<Listing,String> colSrc = new TableColumn("Source"); 
                colSrc.setMinWidth(300);
                colSrc.setCellValueFactory(
                    new PropertyValueFactory<Listing, String>("Source"));
                
        TableColumn<Listing,String> colDate = new TableColumn("Date");
                colDate.setMinWidth(300);
                colDate.setCellValueFactory(
                        new PropertyValueFactory<Listing, String>("Date"));
                
        book.getColumns().addAll(colHeading,colDate,colSrc);
        
        return book;
    }
    
   
  
    
}
