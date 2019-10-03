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
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class GeneralManager_SeeRequestDetailsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    public static Request currentRequest = null;
    
    @FXML
    private ScrollPane medicines;
    
    @FXML
    private VBox medicinesVBox;
    
    @FXML
    private Label gm_name;
    
    @FXML
    private Label branchCodeLabel;
    
    @FXML
    private Label branchLocation;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        gm_name.setText( OOADproject.currentLoggedIn.getName() );
        
        fetchBranchDetails();
        
        
        printAllMedicinesInReq();
    }    
    
    
    private double xOffset =0;
    private double yOffset = 0;
    
    
    private void printAllMedicinesInReq()
    {
        medicinesVBox.getChildren().clear();
        if ( currentRequest != null )
        {
            for ( int i = 0; i < currentRequest.getList().size(); i++ )
            {
                medicines.setVvalue(1);
                medicines.setHvalue(1);

                HBox pane = new HBox();
                pane.setSpacing(2);
                pane.setPrefHeight(38);
                pane.setPrefWidth(584);

                Label serialNum = new Label(i + 1 + "");
                serialNum.setPrefHeight(17);
                serialNum.setPrefWidth(100);
                serialNum.setFont(Font.font("System",FontWeight.BOLD, 12));
                serialNum.setPadding(new Insets(10,0,0,10));

                Label medName = new Label( currentRequest.getList().get(i).getMedicineReference().getName() );
                medName.setPadding(new Insets(10,0,0,0));
                medName.setPrefHeight(17);
                medName.setPrefWidth(161);
            

                Label quantity = new Label( currentRequest.getList().get(i).getDemand() + "" );
                quantity.setPadding(new Insets(10,0,0,0));
                quantity.setPrefHeight(17);
                quantity.setPrefWidth(100);


                

                //JFXButton 
                JFXButton accept = new JFXButton("Accept");
                accept.setButtonType(JFXButton.ButtonType.RAISED);
                //btn_delete.prefHeight(100);
                accept.setTextAlignment(TextAlignment.CENTER);
                accept.setPrefHeight(20);
                accept.setPrefWidth(150);
                accept.setRipplerFill(Paint.valueOf("#a501f8"));
                accept.setStyle("-fx-background-color: #ccccb3;");
                accept.setTextFill(Paint.valueOf("#ffffff"));

                accept.setPadding(new Insets(10,0,0,0));
                
                MedRestockRequestDetail currentMedicineReStockDetail = currentRequest.getList().get(i);
                
                accept.setOnMousePressed((MouseEvent event) -> {

                    allowOne( currentMedicineReStockDetail );
                    
                });
                
                //JFXButton 
                JFXButton deny = new JFXButton("Deny");
                deny.setButtonType(JFXButton.ButtonType.RAISED);
                //btn_delete.prefHeight(100);
                deny.setTextAlignment(TextAlignment.CENTER);
    
                deny.setPrefHeight(20);
                deny.setPrefWidth(150);
                deny.setRipplerFill(Paint.valueOf("#a501f8"));
                deny.setStyle("-fx-background-color: #ccccb3;");
                deny.setTextFill(Paint.valueOf("#ffffff"));

                deny.setPadding(new Insets(10,0,0,0));

                deny.setOnMousePressed((MouseEvent event) -> {

                    denyOne(currentMedicineReStockDetail);
                    
                });
               
                pane.getChildren().add(serialNum);
                pane.getChildren().add(medName);
                pane.getChildren().add(quantity);
                pane.getChildren().add(accept);
                pane.getChildren().add( deny );

                medicinesVBox.getChildren().add(pane);
            }
        }
    }
    
    
    
    @FXML   
    private void logout(MouseEvent event) throws IOException{
       

        OOADproject.currentLoggedIn = null;

        
        currentRequest = null;
        
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
    
    private void fetchBranchDetails()
    {
        branchCodeLabel.setText( "Branch Code: " + currentRequest.getBranch().getBranchCode() );
        branchLocation.setText( "Branch Location: " + currentRequest.getBranch().getLocation() );
    }
    
    @FXML   
    private void goBack(MouseEvent event) throws IOException{

 
        currentRequest = null;
        
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
    private void allowAll(MouseEvent event) throws IOException{
        if ( currentRequest != null )
        {
            for ( int i = 0 ; i < currentRequest.getList().size(); i++ )
            {
                currentRequest.getList().get(i).getMedicineReference().incrementCount( currentRequest.getList().get(i).getDemand() );
            }
            currentRequest.getList().clear();
        
            printAllMedicinesInReq();

            OOADproject.comp.getRequests().remove( currentRequest );
            
            currentRequest = null;
   
            System.out.println("Accepting All");
        }
        
    }
    
    @FXML   
    private void denyAll(MouseEvent event) throws IOException
    {
        if ( currentRequest != null )
        {   
            currentRequest.getList().clear();
        
            printAllMedicinesInReq();

            OOADproject.comp.getRequests().remove( currentRequest );
            
            currentRequest = null;

            System.out.println("Denying All");
        }
        
    }
    
    
       
    private void allowOne( MedRestockRequestDetail m ) 
    {
        if ( currentRequest != null )
        {
            m.getMedicineReference().incrementCount( m.getDemand() );
            
            currentRequest.remove(m);
        
            printAllMedicinesInReq();   
            
            if ( currentRequest.getList().isEmpty() )
            {
                OOADproject.comp.getRequests().remove( currentRequest );
                currentRequest = null;
                
            }
        }
        
    }
    
    
   
    private void denyOne( MedRestockRequestDetail m )
    {
        if ( currentRequest != null )
        {
            currentRequest.remove(m);
            
             
             printAllMedicinesInReq();
             
            if ( currentRequest.getList().isEmpty() )
            {
                OOADproject.comp.getRequests().remove( currentRequest );
                currentRequest = null;

            }
        }
        
         
        
    }
}
