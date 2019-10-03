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
 * @author Wajahat Khann
 */
public class BranchManager_AddSalesmanController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private double xOffset = 0;
    private double yOffset = 0;
    
    @FXML
    private JFXTextField sname;
    @FXML
    private JFXTextField sage;
    @FXML
    private JFXTextField sg;
    @FXML
    private JFXTextField scnic;
    @FXML
    private JFXTextField ssal;
    @FXML
    private JFXTextField sap;
    @FXML
    private Label status;
    private void AddSalesman(Salesman s)
    {
        OOADproject.salesmen.add(s);
        s.setBranch(OOADproject.currentLoggedIn.getBranch());
        OOADproject.currentLoggedIn.getBranch().addSalesman(s);  
    }
    private boolean CheckSalesman()
    {
        boolean flag=true;
        if(sname.getText().toString().length()<=0)
        {
             status.setText("Error in name...");
            flag=false;
        }
        if(sg.getText().toString().length()<=0)
        {
             status.setText("Error in gender...");
            flag=false;
        }
        if(scnic.getText().toString().length()<=0)
        {
             status.setText("Error in cnic...");
            flag=false;
        }
        if(sap.getText().toString().length()<=0)
        {
             status.setText("Error in account password...");
            flag=false;
        }
        try {
            int age = Integer.parseInt(sage.getText().toString());
        } catch (NumberFormatException e) {
             status.setText("Error in age...");
          flag=false;
        }
        try {
            int sal = Integer.parseInt(ssal.getText().toString());
        } catch (NumberFormatException e) {
             status.setText("Error in salary...");
          flag=false;
        }
        return flag;
    }
    public void AddSalesmanButton(MouseEvent event) throws IOException{
        if(CheckSalesman())
        {
            Salesman s = new Salesman(sname.getText().toString(),Integer.parseInt(sage.getText().toString()),sg.getText().toString(),scnic.getText().toString());
            s.setSalary(Integer.parseInt(ssal.getText().toString()));
            AddSalesman(s);
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
    }
    
     @FXML
    private void LogoutButtonAction(MouseEvent event) throws IOException{
        OOADproject.currentLoggedIn=null;
        
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
    private void goBack(MouseEvent event) throws IOException{

        
        Parent register_parent = FXMLLoader.load(getClass().getResource("BranchManager_Edit SalesMen.fxml"));
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
