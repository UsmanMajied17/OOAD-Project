/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooadproject;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Wajahat Khann
 */
public class BranchManager_ViewInventoryController implements Initializable {

    private double xOffset = 0;
    private double yOffset = 0;
    @FXML
    private VBox vbox;
    
    @FXML private ScrollPane scroll;
    
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
    private void ViewInventory()
    {
        BranchManager bm = (BranchManager) OOADproject.currentLoggedIn;
        for(int i=0;i<bm.getBranch().getStock().size();i++)
        {
            String mname=bm.getBranch().getStock().get(i).getMedicineDetails().getName();
            String mquan=Float.toString(bm.getBranch().getStock().get(i).getCount());
            String mprice=Float.toString(bm.getBranch().getStock().get(i).getMedicineDetails().getPricePerItem());
            String mtype=bm.getBranch().getStock().get(i).getMedicineDetails().getType();
            ShowMedicine(mname,mquan,mprice,mtype);
        }
    }
    
    @FXML
    private void ShowMedicine(String medname,String quantity, String medprice, String medType)
    {
        scroll.setVvalue(1);
        scroll.setHvalue(1);


        HBox pane = new HBox();
        pane.setSpacing(80);
        pane.prefHeight(36);
        pane.prefWidth(679);

        Label name = new Label(medname);
        name.setPrefHeight(17);
        name.setPrefWidth(120);
        name.setFont(Font.font("System",FontWeight.BOLD, 12));
        name.setPadding(new Insets(10,0,0,10));
        
        Label Quantity = new Label(quantity);
        Quantity.setPrefHeight(17);
        Quantity.setPrefWidth(120);
        Quantity.setFont(Font.font("System",FontWeight.BOLD, 12));
        Quantity.setPadding(new Insets(10,0,0,10));

        Label price = new Label("$"+medprice);
        price.setPrefHeight(17);
        price.setPrefWidth(120);
        price.setFont(Font.font("System",FontWeight.BOLD, 12));
        price.setPadding(new Insets(10,0,0,10));
        
        
        Label type = new Label(medType);
        type.setPrefHeight(17);
        type.setPrefWidth(120);
        type.setFont(Font.font("System",FontWeight.BOLD, 12));
        type.setPadding(new Insets(10,0,0,10));


        pane.getChildren().add(name);
        pane.getChildren().add(Quantity);
        pane.getChildren().add(price);
        pane.getChildren().add(type);
        vbox.getChildren().add(pane);

    }
    /**
     * Initializes the controller class.
     */
    
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
     private void HomeButtonAction(MouseEvent event) throws IOException{
        Parent register_parent = FXMLLoader.load(getClass().getResource("BranchManager_Main.fxml"));
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
        SetProfile();
        ViewInventory();
    }
    
}
