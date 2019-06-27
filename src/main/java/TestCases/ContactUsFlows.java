package TestCases;

import General.Main;
import org.testng.Assert;
import org.testng.annotations.Test;

import static General.InitMethods.*;

/**
 * Created by VenD on 9/5/2018.
 */
public class ContactUsFlows extends Main {

    public String firstName = "test";
    public String lastName = "venturedive";
    public String email = "iqra.bibi@venturedive.com";
    public String invalidEmail="abc123";
    public String invalidPhoneNumber="abcdeshg";
    public String phoneNumber = "3218529696";
    public String countryName="Cape Verde (Kabu Verdi)";
    public String message = "test message";
    public String inquiryOptions = "Removals enquiry";
    public String actualForContactUsHappyFlow;
    public String expectedForContactUsHappyFlow="Thank you for your enquiry. We will get back to you within one business day.";
    public String expectedForContactUsInvalidEmail="Email Address is invalid";
    public String actualForContactUsInvalidEmail;
    public String expectedForContactUsInvalidPhoneNumber="Phone format/length is not valid";
    public String actualForContactUsInvalidPhoneNumber;
    public int expectedForcontactUsWithEmptyFields=6;
    public int actualForcontactUsWithEmptyFields;

    @Test

    public  void contactUsHappyFlow() throws InterruptedException {

//
        Contact_Us_Object.openContactUsPage(urlForQa1);
//        Thread.sleep(2000);


        Contact_Us_Object.enterDataForContactUsHappyFlow(firstName,lastName,email,countryName,phoneNumber,message,inquiryOptions);
        Contact_Us_Object.submitForm();
        actualForContactUsHappyFlow=Contact_Us_Object.responseForHappyFlow();
        Assert.assertEquals(actualForContactUsHappyFlow,expectedForContactUsHappyFlow);
        System.out.println("\n"+actualForContactUsHappyFlow+"\n"+expectedForContactUsHappyFlow);

       // Thread.sleep(2000);
      //  Business_Object.enterBusinessDetailForHappyFlow(firstName,lastName,email,phoneNumber,description);
       // Thread.sleep(2000);

}

@Test

    public void contactUsWithInvalidEmail() throws InterruptedException
    {

        Contact_Us_Object.openContactUsPage(urlForQa1);
        Contact_Us_Object.enterDataForContactUsInvalidEmail(firstName,lastName,invalidEmail,phoneNumber);
       actualForContactUsInvalidEmail= Contact_Us_Object.responseForInvalidEmail();
        Contact_Us_Object.Sleep();
        Assert.assertEquals(actualForContactUsInvalidEmail,expectedForContactUsInvalidEmail);
        System.out.println("\n"+actualForContactUsInvalidEmail+"\n"+expectedForContactUsInvalidEmail);

    }

    @Test

    public void contactUsWithInvalidPhoneNumebr() throws InterruptedException
    {
        Contact_Us_Object.openContactUsPage(urlForQa1);
        Contact_Us_Object.enterDataForContactUsInvalidPhoneNumber(firstName,lastName,email,invalidPhoneNumber,inquiryOptions);
        actualForContactUsInvalidPhoneNumber=Contact_Us_Object.responseForInvalidPhoneNumber();
        Contact_Us_Object.Sleep();
        Assert.assertEquals(actualForContactUsInvalidPhoneNumber,expectedForContactUsInvalidPhoneNumber);
        System.out.println("\n"+actualForContactUsInvalidPhoneNumber+"\n"+expectedForContactUsInvalidPhoneNumber);

    }

    @Test

    public void contactUsWithEmptyFields() throws InterruptedException
    {
        Contact_Us_Object.openContactUsPage(urlForQa1);
        Contact_Us_Object.submitForm();
        actualForcontactUsWithEmptyFields=Contact_Us_Object.responseWithEmptyFields();
        Contact_Us_Object.Sleep();
        Assert.assertEquals(actualForcontactUsWithEmptyFields,expectedForcontactUsWithEmptyFields);
        System.out.println("\n"+actualForcontactUsWithEmptyFields+"\n"+expectedForcontactUsWithEmptyFields);

    }



}
