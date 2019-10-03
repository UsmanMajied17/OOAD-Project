/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooadproject;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author adeel malik
 */
public class BranchManager_MainController implements Initializable {
    
    
    private double xOffset =0;
    private double yOffset = 0;
    //LogoutButtonAction
    @FXML
    private Label bid;
    @FXML
    private Label bmname;
    @FXML
    private Label bmcnic;
    @FXML
    private Label bmloc;
     @FXML
    public void SetProfile()
    {
        bmname.setText("Name: "+OOADproject.currentLoggedIn.getName());
        bmcnic.setText("CNIC: "+OOADproject.currentLoggedIn.getCNIC());
        bmloc.setText("Location: "+OOADproject.currentLoggedIn.getBranch().getLocation());
    }
    
     
    @FXML   
    private void LogoutButtonAction(MouseEvent event) throws IOException{
        Parent register_parent = FXMLLoader.load(getClass().getResource("Login_Page.fxml"));
        Scene registerScene = new Scene(register_parent);
        Stage registerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Moving on Screen
        
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
    private void Button_ViewInventory(MouseEvent event) throws IOException{
    Parent register_parent = FXMLLoader.load(getClass().getResource("BranchManager_ViewInventory.fxml"));
        Scene registerScene = new Scene(register_parent);
        Stage registerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Moving on Screen
        
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
    private void Button_PrintDetails(MouseEvent event) throws IOException{
    Parent register_parent = FXMLLoader.load(getClass().getResource("BranchManager_Add Remove See Detail Inventory.fxml"));
        Scene registerScene = new Scene(register_parent);
        Stage registerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Moving on Screen
        
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
    private void Button_EditSalesman(MouseEvent event) throws IOException{
    Parent register_parent = FXMLLoader.load(getClass().getResource("BranchManager_Edit SalesMen.fxml"));
        Scene registerScene = new Scene(register_parent);
        Stage registerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Moving on Screen
        
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
    private void Button_AddSale(MouseEvent event) throws IOException{
     Parent register_parent = FXMLLoader.load(getClass().getResource("BranchManager_Add Remove See Detail Inventory.fxml"));
        Scene registerScene = new Scene(register_parent);
        Stage registerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Moving on Screen
        
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
    private void Button_RemoveSale(MouseEvent event) throws IOException{
    Parent register_parent = FXMLLoader.load(getClass().getResource("BranchManager_Add Remove See Detail Inventory.fxml"));
        Scene registerScene = new Scene(register_parent);
        Stage registerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Moving on Screen
        
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
    private void Button_RequestMedicine(MouseEvent event) throws IOException{
        Parent register_parent = FXMLLoader.load(getClass().getResource("BranchManager_Request Medicine.fxml"));
        Scene registerScene = new Scene(register_parent);
        Stage registerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Moving on Screen
        
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
    
   
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        bid.setText("Branch ID: "+Integer.toString(OOADproject.currentLoggedIn.getBranch().getBranchCode()));
        SetProfile();
    }    
    
}
