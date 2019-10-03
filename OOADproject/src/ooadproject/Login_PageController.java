/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooadproject;

import com.jfoenix.controls.JFXButton;
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
public class Login_PageController implements Initializable {
    
    
    private double xOffset =0;
    private double yOffset = 0;
    
    @FXML Label status;
    
    @FXML
    private JFXButton exitButton;
    @FXML
    private JFXTextField empID;
    
    
    @FXML
    private JFXTextField password;
    
    

    
    @FXML   
    private void LoginButtonAction(MouseEvent event) throws IOException{
        
        //Person p = OOADproject.validateUser(  0 , "1" ); 
        if(empID.getText().length()>0 && password.getText().length()>0)
        {
             int id = -1;
            
            try {
                id = Integer.parseInt(empID.getText());
            } catch (NumberFormatException e) {
                status.setText("Bad ID.");
                return;
            }
            
            
            Person p = OOADproject.validateUser( id , password.getText() );
       
       
       //Person p = null;
       
            Parent register_parent;
            if( p != null )
            {
                if ( "GeneralManager".equals(p.getType()) )
                {
                    
                    register_parent = FXMLLoader.load(getClass().getResource("GeneralManager_Main.fxml"));
                }
                else if ( "BranchManager".equals(p.getType()) )
                {
                    register_parent = FXMLLoader.load(getClass().getResource("BranchManager_Main.fxml"));
                   
                }
                else
                {
                    register_parent = FXMLLoader.load(getClass().getResource("Salesman.fxml"));
                }




                Scene registerScene = new Scene(register_parent);
                Stage registerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                // Moving on Screen

                String name = empID.getText().toString().trim();

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
            else
            {
                status.setText( "Credentials dont match with any employee." );
            }
        }
        else
        {
            status.setText( "Error. Check fields..." );
        }
        
        
    }
    
     @FXML
    private void CloseButton(MouseEvent event) {
        if(event.getSource() == exitButton){
            System.exit(0);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        status.setText( null );
    }    
    
}
