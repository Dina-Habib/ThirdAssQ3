/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logjavafx;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author dinahabib
 */
public class LogJavaFX extends Application {
    private Label label1,label2,label3;
    private TextField userText;
    private PasswordField passwordText;
    private Button signButton,exitButton;
    Stage s1;
    
    @Override
    public void start(Stage primaryStage) throws Exception{
       label1=new Label("Welcome");
       label1.setId("l1");
       label2=new Label("User Name:  ");
       label2.setId("l2");
       userText=new TextField();
       userText.setId("ut");
       label3=new Label("Password:  ");
       label3.setId("l3");
       passwordText=new PasswordField();
       passwordText.setId("pt");
       signButton=new Button("Sign in");
       signButton.setId("sb");
       exitButton=new Button("Exit");
       exitButton.setId("eb");
       EventHandler1 eventHandler1 = new EventHandler1();
        signButton.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler1);
        exitButton.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler1);
       HBox hbox=new HBox(10);
       hbox.getChildren().addAll(signButton,exitButton);
       hbox.setAlignment(Pos.BOTTOM_RIGHT);
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400, 200);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5); 
        gridPane.setHgap(5);
        gridPane.add(label1, 0, 0); 
        gridPane.add(label2, 0, 1);       
        gridPane.add(userText, 1, 1); 
        gridPane.add(label3, 0, 2); 
        gridPane.add(passwordText, 1, 2);  
        gridPane.add(hbox, 1, 3);
        gridPane.setAlignment(Pos.CENTER);
        Scene scene = new Scene(gridPane);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setTitle("Login Page");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        s1=primaryStage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    private class EventHandler1 implements EventHandler<Event>{
        
        @Override
        public void handle(Event event) {
           if(event.getSource()==exitButton){
                System.exit(0);
           }else if(event.getSource()==signButton){
               try {
                         Scanner scanner=new Scanner(new File("/Users/dinahabib/NetBeansProjects/logJavaFX/src/logjavafx/password.txt"));
                         while(scanner.hasNext()){
                              String line= scanner.nextLine();
                              String [] visitors=line.split(" ");
                              System.out.println("v1: "+visitors[0]+"v2: "+visitors[1]);
                              
                              if(userText.getText().equals(visitors[0])
                                 && (passwordText.getText().equals(visitors[1]))) {
                                     Logjavafx2 logjavafx2=new Logjavafx2();
                                     s1.close();
                                     try {
                                         logjavafx2.start(new Stage());
                                     } catch (Exception ex) {
                                         System.out.println("error");
                                     }         
                              }
               }
                       
                     } catch (FileNotFoundException ex) {
                         System.out.println("No file");
                     } 
               
           }
        }
        
    }
    
}
