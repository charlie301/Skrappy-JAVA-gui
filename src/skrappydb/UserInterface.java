/*
 * Creates a  user interface for the ret results
 */
package skrappydb;
 
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;


public class UserInterface {

    /*
    
    
    
    */
    
    private Scene scene; 
    private BorderPane pane; 
    private Button btn;
    
    public UserInterface()
    {
        pane = new BorderPane();
        btn = new Button("This is a button");
        pane.setRight(btn);
        scene = new Scene(pane);
    }
    
    public Scene getScene()
    {
        return scene; 
    }
    
    
    
}
