package General;

import PageObjects.*;
import com.aventstack.extentreports.ExtentTest;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.xml.internal.stream.events.NamedEvent;

import static General.Main.driver;
import static General.Main.wait;
//import static General.Main.wait;


/**
 * Created by VenD on 5/3/2018.
 */
public class InitMethods {
    public static ApplicationConfigReader appConfig = new ApplicationConfigReader();
    public static String Url = appConfig.getUrl();

    public static String downloadPath=appConfig.getDownloadPath();
    public static String FilePathForUrls=appConfig.getFilePathForUrls();
    public static String FileName=appConfig.getFileName();
    public static String urlForQa1=appConfig.geturlForQa1();
    public static String SheetName=appConfig.getSheetName();
    public static String adminPanelQa1URL=appConfig.getadminPanelQa1URL();




    public static LoginObjects Login_Object=new LoginObjects(driver);
    public static BusinessPageObjects Business_Object= new BusinessPageObjects(driver);
    public static RemovalsObjects Removals_Object=new RemovalsObjects(driver);
    public static MyFinanceObjects My_Finanace_Object=new MyFinanceObjects(driver);
    public static MyinfoObjects My_Info_Object=new MyinfoObjects(driver);
    public static ContactUsObjects Contact_Us_Object=new ContactUsObjects(driver,wait);
    public static NewLandingObjects New_Landing_Object=new NewLandingObjects(driver,wait);
   public static StatusCodeObjects status_Code_Object=new StatusCodeObjects(driver,wait);
    public static FaqsPageObjects Faqs_Object=new FaqsPageObjects(driver,wait);
    public static LoginAdminPanelObjects login_Admin_Panel_Object= new LoginAdminPanelObjects(driver,wait);
    public static WareHouseObject warehouse_Object=new WareHouseObject(driver,wait);
    public static PricingPageObjects PricingObject=new PricingPageObjects(driver,wait);
    public static StudentStorageObjects StudentObject=new StudentStorageObjects(driver,wait);


    public ExtentTest test;
}

