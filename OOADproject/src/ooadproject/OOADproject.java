/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooadproject;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author adeel malik
 */
public class OOADproject extends Application {
    
    //Company
    
    public static Company comp = new Company("My Company");
    public static ArrayList<BranchManager> branchManagers = new ArrayList<>();
    public static ArrayList<Salesman> salesmen = new ArrayList<>();
    public static GeneralManager gm = null;
    
    public static Person currentLoggedIn = null;
    public static Person p = null;
    
    //Persons' list.
  // static 
    
    
    
    private double xOffset = 0;
    private double  yOffset = 0;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Login_Page.fxml"));
        
        
        
         root.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        
        root.setOnMouseDragged(new EventHandler<MouseEvent>(){
        
            @Override
            public void handle(MouseEvent event){
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
            
        });
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
                      
        dummyInitialize();
       
        launch(args);
    }
    
    private static void dummyInitialize()
    {
        Medicine med = new BoxTablet(12, 2,30,"boxtablet1","ANTIBIOTICS",true,365);       
        Medicine med1 = new BoxTablet((float) 12.5, 3,30,"boxtablet2","ANTIBIOTICS",true,365);
        Medicine med3 = new BoxTablet((float) 14.0, 10,30,"boxtablet3","ANTIBIOTICS",true,365);
        Medicine med4 = new BoxTablet((float) 17.5, 20,30,"boxtablet4","ANTIBIOTICS",true,365);
        Medicine med5 = new BoxTablet((float) 20.5, 12,30,"boxtablet5","ANTIBIOTICS",true,365);

        Medicine syrup1 = new Syrup((float) 14.9, 100,"syrup1", "Antianalgesic", true, 365 );
        Medicine syrup2= new Syrup((float) 15.9, 200,"syrup2", "Antianalgesic", true, 365 );
        Medicine syrup3 = new Syrup((float) 16.9, 300,"syrup3", "Antianalgesic", true, 365 );
        Medicine syrup4 = new Syrup((float) 17.9, 400,"syrup4", "Antianalgesic", true, 365 );
        Medicine syrup5 = new Syrup((float) 18.9, 500,"syrup5", "Antianalgesic", true, 365 );

         Medicine bottletablet1 = new BottleTablet((float) 21.9,20,50,"bottletablet1","Antiseptic",true,365);
         Medicine bottletablet2 = new BottleTablet((float) 21.9,30,50,"bottletablet2","Antiseptic",true,365);
         Medicine bottletablet3 = new BottleTablet((float) 21.9,25,50,"bottletablet3","Antiseptic",true,365);
         Medicine bottletablet4 = new BottleTablet((float) 21.9,40,50,"bottletablet4","Antiseptic",true,365);
         Medicine bottletablet5 = new BottleTablet((float) 21.9,100,50,"bottletablet5","Antiseptic",true,365);

      
         
         comp.storeMedicine(med);
         comp.storeMedicine(med1);
         comp.storeMedicine(med3);
         comp.storeMedicine(med4);
         comp.storeMedicine(med5);
         
         
         
         
         comp.storeMedicine(syrup1);
         comp.storeMedicine(syrup2);
         comp.storeMedicine(syrup3);
         comp.storeMedicine(syrup4);
         comp.storeMedicine(syrup5);
         
         
         
         comp.storeMedicine(bottletablet1);
         comp.storeMedicine(bottletablet2);
         comp.storeMedicine(bottletablet3);
         comp.storeMedicine(bottletablet4);
         comp.storeMedicine(bottletablet5);

         
         
         
       Branch b1 = new Branch( "Location of b1" );
       Branch b2 = new Branch( "Location of b2" );
          
       comp.storeBranch(b2);
       comp.storeBranch(b1);
       
        gm = new GeneralManager( "Abdullah Siddiqui", 20,"Male", "11111-1111111-1");
        gm.setPassword("1");
        
        gm.setCompany(comp);
        
        for ( int i = 0 ; i < 2; i++ )
        {
            branchManagers.add( new BranchManager( "Usman Majeed", 20,"Male", "11111-1111111-1")  );
        }
        
        branchManagers.get(0).setBranch(b1);
        branchManagers.get(1).setBranch(b2);
        branchManagers.get(0).setPassword("1");
        branchManagers.get(1).setPassword("1");
        
        for ( int i = 0 ; i < 10; i++ )
        {
            if ( i % 2 == 0 )
            {
                Salesman s = new Salesman("Ali Nauman", 20, "Male", "11111-1111111-1");
                salesmen.add(  s );
                s.setBranch(b2);
               
                b2.addSalesman( s );
            }
            else
            {
                Salesman s = new Salesman("Younas", 20, "Male", "11111-1111111-1");
                salesmen.add( s );
                s.setBranch(b1);
                b1.addSalesman( s );
            }
         salesmen.get(i).setPassword("1");
        }
       
       
       ArrayList<MedicineReference> temp = new ArrayList<>();
       
       for ( int i = 0; i <  comp.getMedicines().size();i++)
       {
           temp.add(new MedicineReference(comp.getMedicines().get(i),15 ));
       }
       
       ArrayList<MedicineReference> temp2 = new ArrayList<>();
       
       for ( int i = 0; i <  comp.getMedicines().size();i++)
       {
           temp2.add(new MedicineReference(comp.getMedicines().get(i),15 ));
       }
       
       
       
       b1.receiveNewStock(temp);
       b2.receiveNewStock(temp2);
       
       Request dummyRequest = new Request( new MFGDate( 3, 12, 2017 ), b1 );
       Request dummyRequest2 = new Request( new MFGDate( 3, 12, 2017 ), b2 );
       
       for ( int i = 0 ; i < temp.size(); i++)
       {
            dummyRequest.addMedicine( temp.get(i) , 5 );
            dummyRequest2.addMedicine( temp.get(i) , 5 );
       }
       
       
       comp.recieveRequest(dummyRequest);
       comp.recieveRequest(dummyRequest2);
       
       ArrayList<MedicineSold> dummyOrder = new ArrayList<>();
       
       dummyOrder.add( new MedicineSold( temp.get(0) , 3) );
       dummyOrder.add( new MedicineSold( temp.get(2) , 5) );
       dummyOrder.add( new MedicineSold( temp.get(6) , 6) );
       
           
       b1.registerSale(dummyOrder);
       
       ArrayList<MedicineSold> dummyOrder2 = new ArrayList<>();
       
       dummyOrder2.add( new MedicineSold( temp2.get(3) , 3) );
       dummyOrder2.add( new MedicineSold( temp2.get(8) , 5) );
       dummyOrder2.add( new MedicineSold( temp2.get(4) , 6) );
       
       Sale dummySale2 = new Sale( new MFGDate( 3, 12, 2017 ), dummyOrder );
       
       b2.registerSale(dummyOrder2);
       
       
    }
    
    public static Person validateUser( int id, String password )
    {
        if ( gm == null )
        {
            System.out.println("Gm is null");
         
        }
        else if (gm.validate((int) id, password))
        {
            currentLoggedIn=gm;
            return gm;
        }
        else
        {
            for(int i=0;i<branchManagers.size();i++)
            {
                if(branchManagers.get(i).validate((int) id, password))
                {
                    currentLoggedIn=branchManagers.get(i);
                    return branchManagers.get(i);
                }
            }
            for(int i=0;i<salesmen.size();i++)
            {
                if(salesmen.get(i).validate((int) id, password))
                {
                    currentLoggedIn=salesmen.get(i);
                    return salesmen.get(i);
                }
            }
        }
        return null;
    }
    
    public static BranchManager returnBranchManager( int branchCode )
    {
        for ( int i = 0 ; i < comp.getBranches().size(); i++ )
        {
            if ( branchCode == comp.getBranches().get(i).getBranchCode() )
            {
                for ( int j = 0 ; j < branchManagers.size(); j++ )
                {
                    if ( branchManagers.get(j).getBranch() == comp.getBranches().get(i) )
                    {
                        return branchManagers.get(j);
                    }
                }
            }
        }
        return null;
    }
    
}
