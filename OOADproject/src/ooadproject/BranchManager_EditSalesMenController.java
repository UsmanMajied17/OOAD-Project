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
public class BranchManager_EditSalesMenController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private VBox vbox;
    
    @FXML private ScrollPane scroll;
    private double xOffset =0;
    private double yOffset = 0;
    
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
    private void ViewSalesmen()
    {
        vbox.getChildren().clear();
        for(int i=0;i<OOADproject.currentLoggedIn.getBranch().getSalesmen().size();i++)
        {
            String name=OOADproject.currentLoggedIn.getBranch().getSalesmen().get(i).getName();
            String id = Integer.toString((int) OOADproject.currentLoggedIn.getBranch().getSalesmen().get(i).getEmpID());
            String cnic = OOADproject.currentLoggedIn.getBranch().getSalesmen().get(i).getCNIC();
            String salary = Integer.toString(OOADproject.currentLoggedIn.getBranch().getSalesmen().get(i).getSalary());
            ShowSaleman(name,id,cnic,salary,i);
        }
    }
    private void ShowSaleman(String name, String id, String cnic, String salary, int index)
    {
        scroll.setVvalue(1);
        scroll.setHvalue(1);


        HBox pane = new HBox();
        pane.setSpacing(2);
        pane.setPrefHeight(36);
        pane.setPrefWidth(680);

        Label Name = new Label(name);
        Name.setPrefHeight(17);
        
        Name.setPrefWidth(120);
        Name.setFont(Font.font("System",FontWeight.BOLD, 12));
        Name.setPadding(new Insets(10,0,0,0));
        
        Label ID = new Label(id);
        ID.setPrefHeight(17);
        
        ID.setPrefWidth(60);
        ID.setFont(Font.font("System",FontWeight.BOLD, 12));
        ID.setPadding(new Insets(10,0,0,0));

        
        
        
        Label CNIC = new Label(cnic);
        CNIC.setPrefHeight(17);
        CNIC.setPrefWidth(160);
        CNIC.setFont(Font.font("System",FontWeight.BOLD, 12));
        CNIC.setPadding(new Insets(10,0,0,0));
        
        Label Salary = new Label(salary);
        Salary.setPrefHeight(17);
        Salary.setPrefWidth(100);
        Salary.setFont(Font.font("System",FontWeight.BOLD, 12));
        Salary.setPadding(new Insets(10,0,0,0));

        JFXButton btn_delete = new JFXButton("Delete");
        btn_delete.setButtonType(JFXButton.ButtonType.RAISED);
        //btn_delete.prefHeight(100);
        btn_delete.setTextAlignment(TextAlignment.CENTER);
        btn_delete.setPrefHeight(20);
        btn_delete.setPrefWidth(120);
        btn_delete.setRipplerFill(Paint.valueOf("#a501f8"));
        btn_delete.setStyle("-fx-background-color: #ccccb3;");
        btn_delete.setTextFill(Paint.valueOf("#ffffff"));
        btn_delete.setPadding(new Insets(10,0,0,0));
        
        //EventHandler<? super MouseEvent> MouseEvent;
        btn_delete.setOnMousePressed((MouseEvent event1) -> {
            Salesman s=OOADproject.currentLoggedIn.getBranch().getSalesmen().get(index);
            OOADproject.salesmen.remove(s);
            for(int i=0;i<OOADproject.currentLoggedIn.getBranch().getSalesmen().size();i++)
            {
                if(OOADproject.currentLoggedIn.getBranch().getSalesmen().get(i).equals(s))
                {
                   OOADproject.currentLoggedIn.getBranch().getSalesmen().remove(i);
                }
            }
            s=null;
            vbox.getChildren().clear();
            ViewSalesmen();
        });

        JFXButton btn_edit = new JFXButton("Edit");
        btn_edit.setButtonType(JFXButton.ButtonType.RAISED);
        //btn_delete.prefHeight(100);
        btn_edit.setTextAlignment(TextAlignment.CENTER);
        btn_edit.setPrefHeight(20);
        btn_edit.setPrefWidth(120);
        btn_edit.setRipplerFill(Paint.valueOf("#a501f8"));
        btn_edit.setStyle("-fx-background-color: #ccccb3;");
        btn_edit.setTextFill(Paint.valueOf("#ffffff"));
        btn_edit.setPadding(new Insets(10,0,0,0));
        
        
        
           btn_edit.setOnMousePressed((MouseEvent event) -> {
    BranchManager_ChangeSalemanProfileController.changeSaleman=OOADproject.currentLoggedIn.getBranch().getSalesmen().get(index);
               
                   Parent register_parent=null;
            try {
                register_parent = FXMLLoader.load(getClass().getResource("BranchManager_ChangeSalemanProfile.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(BranchManager_EditSalesMenController.class.getName()).log(Level.SEVERE, null, ex);
            }
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
               

           });
        
        
        pane.getChildren().add(Name);
        pane.getChildren().add(ID);
        pane.getChildren().add(CNIC);
        pane.getChildren().add(Salary);
        pane.getChildren().add(btn_delete);
        pane.getChildren().add(btn_edit);
        vbox.getChildren().add(pane);

    }
    //#HomeButtonAction
    
    
    
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
    private void AddSalesmanButton(MouseEvent event) throws IOException{
        Parent register_parent = FXMLLoader.load(getClass().getResource("BranchManager_AddSalesman.fxml"));
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
        ViewSalesmen();
    }    
    
}
