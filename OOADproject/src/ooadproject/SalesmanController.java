/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooadproject;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author adeel malik
 */
public class SalesmanController implements Initializable {
    
    private ArrayList<MedicineReference> currentList = null;
    
    private ArrayList<MedicineSold> cart = new ArrayList<>();
    float bill = 0;
    
    @FXML private Label totalBill;
    
    @FXML private Label cartLabel;
    
    @FXML
    private JFXTextField filterStr;
    
    @FXML 
    private Label salesman_name;
     
    @FXML 
    private VBox vbox;
    
    @FXML 
    private ScrollPane scroll;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ViewMedicines( null );
        salesman_name.setText( OOADproject.currentLoggedIn.getName() );
        
        cartLabel.setText( "Cart: <Empty>" );
        totalBill.setText( "Bill : 0" );
    }    
 
    
    private double xOffset =0;
    private double yOffset = 0;
    
    
    
    
     @FXML
    private void ViewMedicines( String filterString )
    {
        vbox.getChildren().clear();
        
        currentList = OOADproject.currentLoggedIn.getBranch().filter(filterString);
        
        for(int i=0;i<currentList.size();i++)
        {
            String name = currentList.get(i).getMedicineDetails().getName();
            String price = Integer.toString((int)currentList.get(i).getMedicineDetails().getPricePerItem());
            String quantity = Integer.toString(currentList.get(i).getCount());
            String id = Integer.toString((int) currentList.get(i).getMedicineDetails().getID());
            
            
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

            Label Price = new Label("$"+price);
            Price.setPrefHeight(17);
            Price.setPrefWidth(120);
            Price.setFont(Font.font("System",FontWeight.BOLD, 12));
            Price.setPadding(new Insets(10,0,0,10));

            Label medQuantity = new Label(quantity);
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

            Quantity.setId(id);


            pane.getChildren().add(Name);
            pane.getChildren().add(Price);
            pane.getChildren().add(medQuantity);
            pane.getChildren().add(Quantity);
            vbox.getChildren().add(pane);   
        }
    }
   
    
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
     private void addToCartButtonAction(MouseEvent event) throws IOException{
        
         
        String cartText = "Cart: ";
        
        for ( int i = 0 ; i < cart.size(); i++ )
        {
            cartText += cart.get(i).getSoldMedicine().getName() + "(" + cart.get(i).getQuantity() + "); ";
            //bill += cart.get(i).getSoldMedicine().getMedicineDetails().getPricePerItem() * cart.get(i).getQuantity();
        }
        
        for(int i=0;i< currentList.size();i++)
        {
            JFXTextField t = (JFXTextField) vbox.lookup( "#"+currentList.get(i).getMedicineDetails().getID() );
            
            int val = -1;
            try {
                val = Integer.parseInt(t.getText());
                
                if ( val <= currentList.get(i).getCount() && val > 0 )
                {
                    cart.add( new MedicineSold( currentList.get(i), val ) ) ;
                    t.setStyle("-fx-text-fill: black;");
                    t.setText( null );
                    
               
                    
                    cartText += currentList.get(i).getName() + "(" + val + "); ";
                    
                    
                    bill += currentList.get(i).getMedicineDetails().getPricePerItem() * val;
                }
                else
                {
                    t.setStyle("-fx-text-fill: red;");
                }
            } catch (NumberFormatException e) {
                
            }
        }
        
        cartLabel.setText( cartText );
        totalBill.setText( "Bill: " + bill  );
     
     }
    
     @FXML   
    private void registerSale(MouseEvent event) throws IOException{
        Salesman s = (Salesman) OOADproject.currentLoggedIn;
        
        s.getBranch().registerSale(cart);
        
        cart = new ArrayList<>();
        bill = 0;
        
        cartLabel.setText( "Cart: <Empty>" );
        totalBill.setText( "Bill : 0" );
    }
     
    @FXML   
    private void search(MouseEvent event) throws IOException{
       
        ViewMedicines( filterStr.getText() );
        
    }
    
}
    
    

