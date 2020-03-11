/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logjavafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author dinahabib
 */
public class Logjavafx2 extends Application{
    private Button addButton,viewButton;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
       addButton=new Button("Add Student");
       addButton.setId("ab");
       viewButton=new Button("View Student");
       viewButton.setId("vb");
       VBox vbox=new VBox(25,addButton,viewButton);
       vbox.setAlignment(Pos.CENTER);
       Scene scene=new Scene(vbox,250,300);
       scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
       primaryStage.setTitle("Options Page");
       primaryStage.setScene(scene);
       primaryStage.setResizable(false);
       primaryStage.show();
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
