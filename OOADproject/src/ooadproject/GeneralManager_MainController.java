/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooadproject;

import com.jfoenix.controls.JFXButton;
import com.sun.corba.se.spi.activation._ActivatorImplBase;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author adeel malik
 */


public class GeneralManager_MainController implements Initializable {
    
   
    @FXML
    private Label gm_name;

    @FXML
    private ScrollPane branchesList;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        gm_name.setText( OOADproject.currentLoggedIn.getName() );
        printAllBranches();
    }    
    
    
    private double xOffset =0;
    private double yOffset = 0;
    
    @FXML   
    private void logout(MouseEvent event) throws IOException{
       

        OOADproject.currentLoggedIn = null;
        
        Parent register_parent = FXMLLoader.load(getClass().getResource("Login_Page.fxml"));
        Scene registerScene = new Scene(register_parent);
        Stage registerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Moving on Scree

         register_parent.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        register_parent.setOnMouseDragged(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event){
                registerStage.setX(event.getScreenX() - xOffset);
                registerStage.setY(event.getScreenY() - yOffset);
            }

        });

        registerStage.setScene(registerScene);
        registerStage.show();

    }
    
    @FXML 
    private VBox branchesVbox;
    
    
    @FXML   
    private void seeAllRequests(MouseEvent event) throws IOException
    {
        
        Parent register_parent = FXMLLoader.load(getClass().getResource("GeneralManager_See Request.fxml"));
        Scene registerScene = new Scene(register_parent);
        Stage registerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Moving on Scree

         register_parent.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        register_parent.setOnMouseDragged(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event){
                registerStage.setX(event.getScreenX() - xOffset);
                registerStage.setY(event.getScreenY() - yOffset);
            }

        });

        registerStage.setScene(registerScene);
        registerStage.show();

    }
 
    
    @FXML   
    private void viewBranchReport(MouseEvent event) throws IOException
    {
        
        Parent register_parent = FXMLLoader.load(getClass().getResource("GeneralManager_View Branch Report.fxml"));
        Scene registerScene = new Scene(register_parent);
        Stage registerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Moving on Scree

         register_parent.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        register_parent.setOnMouseDragged(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event){
                registerStage.setX(event.getScreenX() - xOffset);
                registerStage.setY(event.getScreenY() - yOffset);
            }

        });

        registerStage.setScene(registerScene);
        registerStage.show();

    }
    
    @FXML
    private void printAllBranches()
    {
        ArrayList<Branch> branches = OOADproject.comp.getBranches();
        
        for ( int i = 0 ; i < branches.size(); i++ )
        {
            branchesList.setVvalue(1);
            branchesList.setHvalue(1);
            
            HBox pane = new HBox();
            pane.setSpacing(2);
            pane.prefHeight(38);
            pane.prefWidth(584);
            
            Label serialNum = new Label(i + 1 + "");
            serialNum.setPrefHeight(17);
            serialNum.setPrefWidth(161);
            serialNum.setFont(Font.font("System",FontWeight.BOLD, 12));
            serialNum.setPadding(new Insets(10,0,0,20));
            
            Label code = new Label( branches.get(i).getBranchCode() + "" );
            code.setPadding(new Insets(10,0,0,0));
            code.setPrefHeight(17);
            code.setPrefWidth(161);
            
            
            Label location = new Label( branches.get(i).getLocation()+ "" );
            location.setPadding(new Insets(10,0,0,0));
            location.setPrefHeight(17);
            location.setPrefWidth(161);
            
            BranchManager bm = OOADproject.returnBranchManager( branches.get(i).getBranchCode() );
            
            Label manager;
            if ( bm != null )
            {
                manager = new Label( bm.getName() );
            }
            else
            {
                manager = new Label( "<Not recruited yet!>" );
            }
            
            manager.setPadding(new Insets(10,0,0,0));
            manager.setPrefHeight(17);
            manager.setPrefWidth(161);
            
            pane.getChildren().add(serialNum);
            pane.getChildren().add(code);
            pane.getChildren().add(location);
            pane.getChildren().add(manager);
            branchesVbox.getChildren().add(pane);
        }
    }
    
    
    @FXML   
    private void addBranch(MouseEvent event) throws IOException
    {
        
        Parent register_parent = FXMLLoader.load(getClass().getResource("GeneralManager_Add Branch.fxml"));
        Scene registerScene = new Scene(register_parent);
        Stage registerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Moving on Scree

         register_parent.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        register_parent.setOnMouseDragged(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event){
                registerStage.setX(event.getScreenX() - xOffset);
                registerStage.setY(event.getScreenY() - yOffset);
            }

        });

        registerStage.setScene(registerScene);
        registerStage.show();

    }
    
    
    @FXML   
    private void removeBranch(MouseEvent event) throws IOException
    {
        
        Parent register_parent = FXMLLoader.load(getClass().getResource("GeneralManager_Remove Branch.fxml"));
        Scene registerScene = new Scene(register_parent);
        Stage registerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Moving on Scree

         register_parent.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        register_parent.setOnMouseDragged(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event){
                registerStage.setX(event.getScreenX() - xOffset);
                registerStage.setY(event.getScreenY() - yOffset);
            }

        });

        registerStage.setScene(registerScene);
        registerStage.show();

    }
    
    
     @FXML   
    private void addBranchManager(MouseEvent event) throws IOException
    {
        
        Parent register_parent = FXMLLoader.load(getClass().getResource("GeneralManager_Add Branch Manager.fxml"));
        Scene registerScene = new Scene(register_parent);
        Stage registerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Moving on Scree

         register_parent.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        register_parent.setOnMouseDragged(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event){
                registerStage.setX(event.getScreenX() - xOffset);
                registerStage.setY(event.getScreenY() - yOffset);
            }

        });

        registerStage.setScene(registerScene);
        registerStage.show();

    }
}
        

