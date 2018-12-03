package TestCases;

import General.Main;
import PageObjects.NewLandingObjects;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.testng.Assert;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static General.InitMethods.New_Landing_Object;
import static General.InitMethods.Url;

/**
 * Created by VenD on 11/4/2018.
 */
public class NewLandingFlows extends Main {

    public static int actualForHeaderFlows;
    public static int expectedForHeaderFlows=6;

    public static int actualForCalculatorFlow;
    public static int expectedForCalculatorFlows=2;

    public static int actualForBookNowFlow;
    public static int expectedForBookNowFlow=3;


    public static String actualForGetTodaysLowestPrices;
    public static String expectedForGetTodaysLowestPrices="LET’S FIGURE OUT WHAT UNIT YOU NEED";

   public static boolean result;


    @Test
    public static void headerFlows() throws InterruptedException {
        New_Landing_Object.openLandingPage(Url);
        actualForHeaderFlows=New_Landing_Object.headerLinks();
        New_Landing_Object.Sleep();
        System.out.println("\n Actual for header flows\n"+actualForHeaderFlows+"\nExpected for header flows\n"+expectedForHeaderFlows);
        Assert.assertEquals(actualForHeaderFlows,expectedForHeaderFlows,"Both results for header flows are equal");

    }


    @Test
    public static void getTodaysLowestPricesFlow() throws InterruptedException {
        //New_Landing_Object.openLandingPage(Url);
       actualForGetTodaysLowestPrices= New_Landing_Object.getTodaysLowestPrices();
        New_Landing_Object.Sleep();
        System.out.println("\n Actual for get todays lowest prices flow\n"+actualForGetTodaysLowestPrices+"\nExpected For get todays lowest prices flow\n"+expectedForGetTodaysLowestPrices);
        Assert.assertEquals(actualForGetTodaysLowestPrices,expectedForGetTodaysLowestPrices,"Both text for get todays lowest prices are equal");

    }


    @Test
    public static void bookNowFlows() throws InterruptedException
    {
        //New_Landing_Object.openLandingPage(Url);
       actualForBookNowFlow= New_Landing_Object.bookNowSection();
        New_Landing_Object.Sleep();
        System.out.println("\n Actual for book now flow\n"+actualForBookNowFlow+"\nExpected For book now flow\n"+expectedForBookNowFlow);
        Assert.assertEquals(actualForBookNowFlow,expectedForBookNowFlow,"Both text for book now are equal");


    }

    @Test

    public static void calculatorFlow() throws InterruptedException
    {
        //New_Landing_Object.openLandingPage(Url);
        actualForCalculatorFlow=New_Landing_Object.calculatorSection();
        New_Landing_Object.Sleep();
        System.out.println("\n Actual for calculator flow\n"+actualForCalculatorFlow+"\nExpected For calculator flow\n"+expectedForCalculatorFlows);
        Assert.assertEquals(actualForCalculatorFlow,expectedForCalculatorFlows,"Both text for calculator are equal");
    }



}
