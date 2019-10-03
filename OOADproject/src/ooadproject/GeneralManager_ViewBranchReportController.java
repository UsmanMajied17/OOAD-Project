/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooadproject;

import com.jfoenix.controls.JFXAlert;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author adeel malik
 */
public class GeneralManager_ViewBranchReportController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        totalIncome.setText("");
        medicinesSold.setText("");
        totalSales.setText("");
        mostSellingMedicine.setText("");
    }    
    
    @FXML DatePicker datepicker;
  
    
    
    @FXML
    private JFXTextField branchCode;
    
    @FXML private Label totalSales;
    @FXML private Label medicinesSold;
    @FXML private Label totalIncome;
    
    @FXML private Label mostSellingMedicine;
    
    @FXML
    private void getReport(MouseEvent event) throws IOException {
    
        totalIncome.setText("");
        medicinesSold.setText("");
        totalSales.setText("");
        mostSellingMedicine.setText("");
    
        //Check branch code.
        int branchCodeProvided = -1;
        try {
            branchCodeProvided = Integer.parseInt( branchCode.getText() );
        } catch (NumberFormatException e) {
            totalSales.setText("Error in Branch code...");
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
            totalSales.setText("Branch code isnt valid...");
            return;
        }
        
        LocalDate date = datepicker.getValue();
        
        if ( date == null )
        {
            totalSales.setText("Please select a date.");
            return;
        }
        
        int bottleTabletsCount = 0;
        int syrupsCount = 0 ;
        int boxTabletsCount = 0;
        int salesCount = 0;
        
        double totalIncomeGenerated = 0;
        
        boolean isValidDate = false;
        
        for ( int i = 0 ; i < b.getSales().size(); i++ )
        {
            Sale s  = b.getSales().get(i);
            
            
            if ( date.getDayOfMonth() == s.getDate().getDay() && date.getMonthValue() == s.getDate().getMonth() && date.getYear() == s.getDate().getYear() )
            {
                isValidDate = true;
                
                
                for ( int j = 0 ; j < s.getMedicinesSold().size(); j++ )
                {
                    //System.out.println("a");
                    
                    if ( "BottleTablet".equals(s.getMedicinesSold().get(j).getSoldMedicine().getMedicineDetails().getType()) )
                    {
                        bottleTabletsCount=s.getMedicinesSold().get(j).getQuantity();
                    }
                    else if ( "BoxTablet".equals(s.getMedicinesSold().get(j).getSoldMedicine().getMedicineDetails().getType() ) )
                    {
                        boxTabletsCount=s.getMedicinesSold().get(j).getQuantity();
                    }
                    else 
                    {
                        //Syrup.
                       syrupsCount=s.getMedicinesSold().get(j).getQuantity();
                    }
                         
                    totalIncomeGenerated += s.getMedicinesSold().get(j).getSoldMedicine().getMedicineDetails().getPricePerItem() * s.getMedicinesSold().get(j).getQuantity();
                    
                }
                
                salesCount++;
            }
            
        }
        
        if ( isValidDate )
        {
            totalSales.setText("No. of sales: " + salesCount );
            totalIncome.setText("Total income: " + totalIncomeGenerated);
            medicinesSold.setText("Bottle Tablets Sold: " + bottleTabletsCount + "; Syrups Sold: " + syrupsCount + "; Box Tablets Sold: " + boxTabletsCount );
        }
        else
        {
            totalSales.setText("No sales are made on this day,check date please.");
        }
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
