package TestCases;

import General.Main;
import org.testng.Assert;
import org.testng.annotations.Test;

import static General.InitMethods.adminPanelQa1URL;
import static General.InitMethods.login_Admin_Panel_Object;

/**
 * Created by VenD on 11/22/2018.
 */
public class LoginAdminPanelFlow extends Main {


    String email = "admin@bystored.com";
    String invalidEmail = "adm@byt";
    String pwd = "storage2014";
    Boolean expected_result;
    Boolean expectedForInvalidEmail;


    @Test
    public void loginFunc() throws InterruptedException {


        login_Admin_Panel_Object.openAdminPanelLoginPage(adminPanelQa1URL);
        login_Admin_Panel_Object.enterLoginCredentials(email, pwd);
        login_Admin_Panel_Object.clickLogin();
        expected_result=login_Admin_Panel_Object.SuccessfulSubmit();
        login_Admin_Panel_Object.Sleep();
//        login_Admin_Panel_Object.clickLogoutButton();
//        login_Admin_Panel_Object.Sleep();
        System.out.print(expected_result + "");
        Assert.assertTrue(expected_result);


    }


     @Test
    public void loginFuncInvalid() throws InterruptedException {


        login_Admin_Panel_Object.openAdminPanelLoginPage(adminPanelQa1URL);
        login_Admin_Panel_Object.enterLoginCredentials(invalidEmail, pwd);
        expectedForInvalidEmail = login_Admin_Panel_Object.clickSubmitForInvalid();
         login_Admin_Panel_Object.refrech();
        login_Admin_Panel_Object.Sleep();
        System.out.print(expectedForInvalidEmail + "");
        Assert.assertTrue(expectedForInvalidEmail);

    }
}
