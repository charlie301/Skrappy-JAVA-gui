/*
 * Creates a  user interface for the ret results
 */
package skrappydb;
 
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class UserInterface {

    //declare the top level elements
    private Scene scene; 
    private BorderPane pane; 
    
    //declare BORDER.Top elements
    protected Button btnNews; 
    protected Button btnChart;
    protected Label tlabel;
    
    public UserInterface()
    {
        BorderPane pane = new BorderPane();
        pane.setTop(addHeaderBox()); 
        
        scene = new Scene(pane); 
    }
    
    public Scene getScene()
    {
        return scene; 
    }


    private HBox addHeaderBox() {
       HBox hbox = new HBox();
       hbox.setPadding(new Insets(15,12,15,12));
       hbox.setSpacing(10);
       hbox.setStyle("-fx-background-color: #1FB0E0");
       
       btnNews = new Button("Current News"); 
       btnNews.setPrefSize(100, 20);
       btnNews.setDisable(true);
       
       btnChart = new Button("Charts"); 
       btnChart.setPrefSize(100, 20);
  
       tlabel.setText("Current value");
       
       hbox.getChildren().addAll(btnNews,btnChart,tlabel);
       return hbox;
    }
    
    public Button btnChart(){
        return this.btnChart;
    }
    
    public Label tlLabel(){
        return this.tlabel;
    }
    
}
