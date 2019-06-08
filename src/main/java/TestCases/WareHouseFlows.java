package TestCases;

import General.Main;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

import static General.InitMethods.warehouse_Object;

/**
 * Created by VenD on 11/22/2018.
 */
public class WareHouseFlows extends Main{
    String name = "Created_For_Automated_Cases";
    String Id_value;
    String address_value = "249-251 Merton Rd, Wandsworth, London SW18 5EB";
    String parking_address = "249-251 Merton Rd, Wandsworth, London SW18 5EB";

    public String email="admin@bystored.com";
    public String passWord="storage2014";
    public String actulaForAddingRoom;
    public String expectedForAddingRoom="Success";
    public int random;


    public void randomIdentifier()
    {
        int max=10000;
        int min=1;
        Random r = new Random();
        random =r.nextInt((max - min) + 1) + min;
        System.out.println(random+"\n");
        Id_value=""+random;

    }

    @Test

    public void addWarehouse() throws InterruptedException
    {
        randomIdentifier();

        warehouse_Object.openLoginPage(email,passWord);
        warehouse_Object.Sleep();
//        warehouse_Object.clickHamburger();
//        warehouse_Object.Sleep();
        warehouse_Object.clickWarehouse();
        warehouse_Object.Sleep();
        warehouse_Object.warehouses();
        warehouse_Object.Sleep();
        warehouse_Object.addWarehouse();
        warehouse_Object.Sleep();
        warehouse_Object.warehouseInfo(name, Id_value, address_value, parking_address);
        warehouse_Object.Sleep();
        warehouse_Object.checkboxDefault();
        warehouse_Object.Sleep();
        warehouse_Object.assetStore();
        warehouse_Object.Sleep();
        warehouse_Object.submit();
        warehouse_Object.Sleep();
        actulaForAddingRoom=warehouse_Object.applyassertionSubmit();
        System.out.print(actulaForAddingRoom+"\n"+expectedForAddingRoom+"\n");
        Assert.assertEquals(actulaForAddingRoom,expectedForAddingRoom,"Both the messages of adding rooms are equal");

    }


//    @Test
//
//    public void editWarehouse() throws InterruptedException {
//        Warehouse_objects warehouse_object = new Warehouse_objects(driver);
//        Thread.sleep(5000);
//        warehouse_object.edit();
//        Thread.sleep(1000);
//        warehouse_object.warehouseInfoEdit(name_edit, address_value_edit, parking_address_edit);
//        Thread.sleep(1000);
//        warehouse_object.checkboxDefaultEdit();
//        Thread.sleep(1000);
//        warehouse_object.assetStoreEdit();
//        Thread.sleep(1000);
//        warehouse_object.submitEdit();
//        Thread.sleep(1000);
//        warehouse_object.applyassertionSubmit("Success");
//        Thread.sleep(4000);
//    }
//
//    @Test
//
//    public void deleteWarehouse() throws InterruptedException {
//        Warehouse_objects warehouse_object = new Warehouse_objects(driver);
//        Thread.sleep(1000);
//        warehouse_object.delete();
//        Thread.sleep(1000);
//        warehouse_object.yesNo();
//        Thread.sleep(1000);
//        warehouse_object.applyassertionSubmit("Success");
//
//
//
//
//    }


}
