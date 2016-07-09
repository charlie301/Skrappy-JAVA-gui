/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skrappydb;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author charlie
 */
public class SkrappyDB extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       
        MongoConnection test = new MongoConnection();
        test.getListings("penews");
        
        UserInterface ui = new UserInterface(); 
        Scene scene = ui.getScene(); 
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Skrappy DB");
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
