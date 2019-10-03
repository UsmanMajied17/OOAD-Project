/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooadproject;

import com.jfoenix.controls.JFXTextArea;
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
public class GeneralManager_RemoveBranchController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Label status;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        status.setText( null );
    }    
    
    @FXML
    private JFXTextField branchCode;
    
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
    
    @FXML
    private void removeBranch(MouseEvent event) throws IOException
    {
        
        //Check branch code.
        int branchCodeProvided = -1;
        try {
            branchCodeProvided = Integer.parseInt( branchCode.getText() );
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
        
        //Make branch manager's branch null.
        
        for ( int i = 0 ; i < OOADproject.branchManagers.size(); i++ )
        {
            if ( OOADproject.branchManagers.get(i).getBranch() == b )
            {
                OOADproject.branchManagers.get(i).setBranch( null );
                break;
            }
        }
        
        //Remove branch from company branches.
        OOADproject.comp.removeBranchFromList(b);
        
        status.setText( "Branch Successfully removed!" );
        
        System.out.println("Removing Branch.");
    }
    
}
