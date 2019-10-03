/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooadproject;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
public class GeneralManager_SeeRequestController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
   @FXML
    private Label gm_name;

    
   @FXML
   private ScrollPane requests;
   
   @FXML
   private VBox requestsVbox;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        gm_name.setText( OOADproject.currentLoggedIn.getName() );
        
        printAllRequests();
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
    private void goBack(MouseEvent event) throws IOException{

        
        Parent register_parent = FXMLLoader.load(getClass().getResource("GeneralManager_Main.fxml"));
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
    
    private void printAllRequests()
    {
        
        ArrayList<Request> allReq = OOADproject.comp.getRequests();
        
        for ( int i = 0 ; i < allReq.size(); i++ )
        {
            requests.setVvalue(1);
            requests.setHvalue(1);
            
            HBox pane = new HBox();
            pane.setSpacing(5);
            pane.setPrefHeight(38);
            pane.setPrefWidth(584);
            
            Label serialNum = new Label(i + 1 + "");
            serialNum.setPrefHeight(17);
            serialNum.setPrefWidth(100);
            serialNum.setFont(Font.font("System",FontWeight.BOLD, 12));
            serialNum.setPadding(new Insets(10,0,0,20));
            
            Label code = new Label( allReq.get(i).getBranch().getBranchCode() + "" );
            code.setPadding(new Insets(10,0,0,0));
            code.setPrefHeight(17);
            code.setPrefWidth(100);
            //code.setLayoutX(30);
            
            Label location = new Label( allReq.get(i).getBranch().getLocation()+ "" );
            location.setPadding(new Insets(10,0,0,0));
            location.setPrefHeight(17);
            location.setPrefWidth(200);
            //location.setLayoutX(150);
            
            Label date = new Label( allReq.get(i).getDate().getDay() + "/" + allReq.get(i).getDate().getMonth() + "/" + allReq.get(i).getDate().getYear() );
            date.setPadding(new Insets(10,0,0,0));
            date.setPrefHeight(17);
            date.setPrefWidth(100);
            //date.setLayoutX(320);
            
            //JFXButton 
            JFXButton seeDetailsButton = new JFXButton("See Details");
            seeDetailsButton.setButtonType(JFXButton.ButtonType.RAISED);
            //btn_delete.prefHeight(100);
            seeDetailsButton.setTextAlignment(TextAlignment.CENTER);
            seeDetailsButton.setPrefHeight(20);
            seeDetailsButton.setPrefWidth(120);
            seeDetailsButton.setRipplerFill(Paint.valueOf("#a501f8"));
            seeDetailsButton.setStyle("-fx-background-color: #ccccb3;");
            seeDetailsButton.setTextFill(Paint.valueOf("#ffffff"));
            
            seeDetailsButton.setPadding(new Insets(10,0,0,0));
            
            Request currentRequest = allReq.get(i);
            
            seeDetailsButton.setOnMousePressed((MouseEvent event) -> {
                

                Parent register_parent = null;
                GeneralManager_SeeRequestDetailsController.currentRequest = currentRequest ;
                try {
                    register_parent = FXMLLoader.load(getClass().getResource("GeneralManager_See Request Details.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(GeneralManager_SeeRequestController.class.getName()).log(Level.SEVERE, null, ex);
                }
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

            });

            pane.getChildren().add(serialNum);
            pane.getChildren().add(code);
            pane.getChildren().add(location);
            pane.getChildren().add(date);
            pane.getChildren().add(seeDetailsButton);

            requestsVbox.getChildren().add(pane);
        }
    }
   
    @FXML   
    private void seeReqDetails(MouseEvent event) throws IOException{

        
        
        

    }
}
