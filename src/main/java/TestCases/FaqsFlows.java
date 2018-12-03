package TestCases;

import General.Main;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.testng.Assert;
import org.testng.annotations.Test;

import static General.InitMethods.Faqs_Object;
import static General.InitMethods.Url;
import static General.InitMethods.urlForQa1;

/**
 * Created by VenD on 11/7/2018.
 */
public class FaqsFlows extends Main {
    String actualForFaqHappyFlow;
    String expectedForFaqsHappyFlow="Got a specific query?";
    Boolean actualForScrollUp;
    String searchValidText="bystored";
    int textGet;
    int expectedForValid=1;
    int expectedForInValid=0;
    int[] actualForLeftSideSection;


    String SearchInvalidText="iqraaa";
//    Boolean expectedForScrolUp=true;


    @Test

    public  void ContactUsFlow() throws InterruptedException {
        Faqs_Object.openFaqsPage(Url);
       actualForFaqHappyFlow= Faqs_Object.contactUsButtonClick();
        Faqs_Object.Sleep();
        Assert.assertEquals(actualForFaqHappyFlow,expectedForFaqsHappyFlow);
        System.out.println("\n"+actualForFaqHappyFlow+"\n"+expectedForFaqsHappyFlow);

    }


    @Test
    public void LeftSideFlows() throws InterruptedException {
        //Faqs_Object.openFaqsPage(Url);
       actualForLeftSideSection=Faqs_Object.leftSection();
        Faqs_Object.Sleep();
        Assert.assertEquals(actualForLeftSideSection[0],actualForLeftSideSection[1]);
        System.out.println("\n"+actualForLeftSideSection[0]+"\n"+actualForLeftSideSection[1]);
    }

    @Test
    public void ScrollUpFlows() throws InterruptedException {
        Faqs_Object.openFaqsPage(Url);
        actualForScrollUp=Faqs_Object.ScrollUp();
        Faqs_Object.Sleep();
        Assert.assertTrue(actualForScrollUp);
        System.out.println("\n"+actualForScrollUp+"\n");

    }
    @Test
    public void SeacrhFunctionalityWithValidData() throws InterruptedException {
        Faqs_Object.openFaqsPage(Url);
        Faqs_Object.SleepForLeftSide();
        textGet=Faqs_Object.SeacrhFunctionality(searchValidText);
        Faqs_Object.Sleep();
       Assert.assertEquals(textGet,expectedForValid);
        System.out.println("\n"+textGet+"\n"+expectedForValid);

    }
    @Test
    public void SeacrhFunctionalityWithInValidData() throws InterruptedException {
        Faqs_Object.openFaqsPage(Url);
        textGet=Faqs_Object.SeacrhFunctionality(SearchInvalidText);
        Faqs_Object.Sleep();
        Assert.assertEquals(textGet,expectedForInValid);
        System.out.println("\n"+textGet+"\n"+expectedForInValid);



    }






}
