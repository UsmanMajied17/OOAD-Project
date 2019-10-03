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
public class GeneralManager_AddBranchManagerController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextField age;
    @FXML
    private JFXTextField accountPassword;
    @FXML
    private JFXTextField gender;
    @FXML
    private JFXTextField CNIC;
    @FXML
    private JFXTextField salary;
    
    @FXML
    private JFXTextField code;
    
    @FXML
    private Label status;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        status.setText( null );
        
    }    
    
    @FXML   
    private void addBranchManager(MouseEvent event) throws IOException
    {
        //Adding branch manager.
        
        //Validate input.
        if ( name.getText().length() <= 0 )
        {
            status.setText("Error in name...");
            return;
        }
        if ( age.getText().length() <= 0 )
        {
            status.setText("Error in Age...");
            return;
        }
        if ( accountPassword.getText().length() <= 0 )
        {
            status.setText("Error in Account password...");
            return;
        }
        if ( gender.getText().length() <= 0 )
        {
            status.setText("Error in gender...");
            return;
        }
        if ( CNIC.getText().length() <= 0 )
        {
            status.setText("Error in CNIC...");
            return;
        }
        if ( salary.getText().length() <= 0 )
        {
            status.setText("Error in salary...");
            return;
        }
        
        if ( code.getText().length() <= 0 )
        {
            status.setText("Error in Branch code...");
            return;
        }
        
        //Check branch code.
        int branchCodeProvided = -1;
        try {
            branchCodeProvided = Integer.parseInt( code.getText() );
        } catch (NumberFormatException e) {
            status.setText("Error in Branch code...");
            return;
        }
        
        //Check if provided branch code matches with any branch present.
        Branch b = null;
        for ( int i = 0 ; i < OOADproject.comp.getBranches().size(); i++ )
        {
            if ( OOADproject.comp.getBranches().get(i).getBranchCode() == branchCodeProvided )
            {
                b = OOADproject.comp.getBranches().get(i);
            }
        }
        
        if ( b == null )
        {
            status.setText("Branch code isnt valid...");
            return;
        }
        
        //If given branch has already a branch manager assigned to it, then 
        //terminate process.
        for ( int i = 0 ; i < OOADproject.branchManagers.size(); i++ )
        {
            if ( b == OOADproject.branchManagers.get(i).getBranch() )
            {
                 status.setText("This branch has already a branch manager.");
                 return;
            }
        }
        
        //Age exception.
        int ageProvided = -1;
        try {
            ageProvided = Integer.parseInt( age.getText() );
        } catch (NumberFormatException e) {
            status.setText("Error in Age...");
            return;
        }
        
        
        //Salary parsing exception.
        int salaryProvided = -1;
        
        try {
            salaryProvided = Integer.parseInt( salary.getText() );
        } catch (NumberFormatException e) {
            status.setText("Error in Salary...");
            return;
        }
        
        
        
        BranchManager newBranchManager = new BranchManager(name.getText() , ageProvided, gender.getText(), CNIC.getText());
        
        newBranchManager.setPassword( accountPassword.getText() );
        newBranchManager.setSalary(salaryProvided);
        newBranchManager.setBranch(b);
        
        OOADproject.branchManagers.add(newBranchManager);
        
        status.setText("Branch Manager added successfully!");
        System.out.println("Adding branch Manager.");
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
   
    
   
}
