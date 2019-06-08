
package TestCases;

import General.Main;
import PageObjects.RemovalsObjects;
import org.testng.Assert;
import org.testng.annotations.Test;


import static General.InitMethods.Url;
import static General.InitMethods.Removals_Object;
import static General.InitMethods.urlForQa1;

/**
 * Created by VenD on 4/19/2018.
 */
public class RemovalsFlows extends Main{

    // WebDriver driver;
    // RemovalsObjects ro;
    //String url=getUrl();
    public String name="iqra";
    public String email="iqra.bibi@venturedive.com";
    public String invalidEmail="yahoo.com";
    public String countryName="Cape Verde (Kabu Verdi)";
    public String phonenumber="034569865342";
    public String invalidPhoneNumber="cfgvhbn12352@";
    public boolean actualForRemovalhappyFlow;
    public String expectedForRemovalHappyFlow="Full Name Please";
    public String actualForInvalidEmailForRemovals;
    public String expectedForInvalidEmailRemovals="Please enter a valid email";
    public String actualForInvalidPhoneNumberForRemovals;
    public String expectedForInvalidPhoneNumberForRemovals="Phone format/length is not valid";
    public boolean actualForClickHere;




    @Test

    public void removalstestCasesHappyFlow() throws InterruptedException
    {

        // ro = new RemovalsObjects(driver);
        Removals_Object.openBrowser(Url);
        Removals_Object.enterDataforHappyFlow(name, email,countryName,phonenumber);
        Thread.sleep(2000);
        actualForRemovalhappyFlow = Removals_Object.submit();
        Thread.sleep(3000);
        Assert.assertFalse(actualForRemovalhappyFlow);
//        Assert.assertEquals(""+actualForRemovalhappyFlow,""+expectedForRemovalHappyFlow);
//        System.out.print("\n Actual For happy flows of Removals\n"+actualForRemovalhappyFlow+"\n Expected For happy flows of Removals \n"+expectedForRemovalHappyFlow);

        Thread.sleep(1000);


    }

    @Test
    public void removalForInvalidEmail() throws InterruptedException
    {
        //Removals_Object = new RemovalsObjects(driver);
        Removals_Object.openBrowser(Url);
        Thread.sleep(2000);
        actualForInvalidEmailForRemovals= Removals_Object.enterDataForInvalidEmail(name,invalidEmail,phonenumber);

        Thread.sleep(2000);

        Assert.assertEquals(""+actualForInvalidEmailForRemovals,""+expectedForInvalidEmailRemovals);
        System.out.print("\n Actual For invalid Email for Removals\n"+actualForInvalidEmailForRemovals+"\n Expected For invalid Email for Removals\n"+expectedForInvalidEmailRemovals);
        Thread.sleep(2000);
    }

    @Test
    public void removalForInvalidPhoneNumber() throws InterruptedException
    {
        //Removals_Object = new RemovalsObjects(driver);
        Removals_Object.openBrowser(Url);
        Thread.sleep(2000);
        actualForInvalidPhoneNumberForRemovals= Removals_Object.enterDataForInvalidPhoneNumber(name,email,invalidPhoneNumber);

        Thread.sleep(2000);

        Assert.assertEquals(""+actualForInvalidPhoneNumberForRemovals,""+expectedForInvalidPhoneNumberForRemovals);
        System.out.print("\n Actual For invalid Phonenumber in Removals\n"+actualForInvalidPhoneNumberForRemovals+"\n Expected for invalid Phonenumber in Removals\n"+expectedForInvalidPhoneNumberForRemovals);
        Thread.sleep(2000);
    }

    @Test
    public void removalClickHere() throws InterruptedException
    {
        // Removals_Object = new RemovalsObjects(driver);
        Removals_Object.openBrowser(Url);
        Thread.sleep(2000);
        actualForClickHere=Removals_Object.clickhere();
        Assert.assertTrue(actualForClickHere);


    }
}
