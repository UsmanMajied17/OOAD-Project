/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooadproject;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.event.EventType;
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
 * @author adeel malik
 */
public class BranchManager_RequestMedicineController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML private Label status;
    
        @FXML
    private VBox vbox;
    
    @FXML private ScrollPane scroll;
    
    private double xOffset = 0;
    private double yOffset = 0;
    
    private double y=11;
    private double y1=7;
    
    
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
    private void ViewMedicines()
    {
        vbox.getChildren().clear();
        for(int i=0;i<OOADproject.currentLoggedIn.getBranch().getStock().size();i++)
        {
            String name = OOADproject.currentLoggedIn.getBranch().getStock().get(i).getMedicineDetails().getName();
            String price = Integer.toString((int)OOADproject.currentLoggedIn.getBranch().getStock().get(i).getMedicineDetails().getPricePerItem());
            String quantity = Integer.toString(OOADproject.currentLoggedIn.getBranch().getStock().get(i).getCount());
            ShowMedicine(name,price,quantity,i);
            y=y+10;
            y1=y1+7;
        }
    }
    
    private void ShowMedicine(String name,String price,String count,int index)
    {
        scroll.setVvalue(1);
        scroll.setHvalue(1);


        HBox pane = new HBox();
        pane.setSpacing(80);
        pane.prefHeight(36);
        pane.prefWidth(679);

        Label Name = new Label(name);
        Name.setPrefHeight(17);
        Name.setPrefWidth(120);
        Name.setFont(Font.font("System",FontWeight.BOLD, 12));
        Name.setPadding(new Insets(10,0,0,10));
        
        Label Price = new Label(price+"$");
        Price.setPrefHeight(17);
        Price.setPrefWidth(120);
        Price.setFont(Font.font("System",FontWeight.BOLD, 12));
        Price.setPadding(new Insets(10,0,0,10));
        
        Label medQuantity = new Label(count);
        medQuantity.setPrefHeight(17);
        medQuantity.setPrefWidth(120);
        medQuantity.setFont(Font.font("System",FontWeight.BOLD, 12));
        medQuantity.setPadding(new Insets(10,0,0,10));
        
        JFXTextField Quantity = new JFXTextField("");
        Quantity.setPrefHeight(17);
        Quantity.setPrefWidth(120);
        Quantity.setFont(Font.font("System",FontWeight.BOLD, 12));
        //Quantity.setLayoutX(550.0);
        //Quantity.setLayoutY(y1);
        Quantity.setPadding(new Insets(5,20,0,0));
        String id=Integer.toString((int) OOADproject.currentLoggedIn.getBranch().getStock().get(index).getMedicineDetails().getID());
        Quantity.setId(id);
       
        
        pane.getChildren().add(Name);
        pane.getChildren().add(Price);
        pane.getChildren().add(medQuantity);
        pane.getChildren().add(Quantity);
        vbox.getChildren().add(pane);
        

    }
    
    private void GenerateRequest()
    {
        LocalDate now = LocalDate.now();
        Date d = new Date();
        MFGDate date = new MFGDate( now.getDayOfMonth() , now.getMonthValue(), now.getYear() );
        
        Request r=new Request(date,OOADproject.currentLoggedIn.getBranch());
        
        boolean isEmpty = true;
        
        for(int i=0;i<OOADproject.currentLoggedIn.getBranch().getStock().size();i++)
        {
            JFXTextField t = (JFXTextField) vbox.lookup("#"+OOADproject.currentLoggedIn.getBranch().getStock().get(i).getMedicineDetails().getID());
            
            int val = -1;
            try {
                val = Integer.parseInt(t.getText());
                
                isEmpty = false;
                
                r.addMedicine(OOADproject.currentLoggedIn.getBranch().getStock().get(i), val);
                
                t.setText( null );
            } catch (NumberFormatException e) {
                
            }
        }
        
        if ( isEmpty )
        {
            status.setText( "Please add medicines to the request!" );
        }
        else
        {
            OOADproject.comp.recieveRequest(r);
        
            status.setText( "Request is successfully sent!" );
        }
    }
    
    @FXML
    private void SendRequest(MouseEvent event) throws IOException{
        GenerateRequest();
//        Parent register_parent = FXMLLoader.load(getClass().getResource("Login_Page.fxml"));
//        Scene registerScene = new Scene(register_parent);
//        Stage registerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        // Moving on Screen
//        
//         register_parent.setOnMousePressed(new EventHandler<MouseEvent>(){
//            @Override
//            public void handle(MouseEvent event){
//                xOffset = event.getSceneX();
//                yOffset = event.getSceneY();
//            }
//        });
//        
//        register_parent.setOnMouseDragged(new EventHandler<MouseEvent>(){
//        
//            @Override
//            public void handle(MouseEvent event){
//                registerStage.setX(event.getScreenX() - xOffset);
//                registerStage.setY(event.getScreenY() - yOffset);
//            }
//            
//        });
//        
//        registerStage.setScene(registerScene);
//        registerStage.show();
//    
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
        // TODO
        SetProfile();
        ViewMedicines();
    }    
    
}
