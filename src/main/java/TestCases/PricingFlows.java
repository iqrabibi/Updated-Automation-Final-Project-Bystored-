package TestCases;

import General.Main;
import PageObjects.PricingPageObjects;
import org.testng.Assert;
import org.testng.annotations.Test;

import static General.InitMethods.PricingObject;
import static General.InitMethods.Url;
import static General.InitMethods.urlForQa1;

/**
 * Created by VenD on 11/25/2018.
 */
public class PricingFlows extends Main {
    int expectedCount=2;
    int actualCount;
    int actualForLinks;
    int expectedForLinks=2;
    int[] expectedForFaqs;


    @Test
    public void GreenButtonOnPricingPageFlow() throws InterruptedException {
        PricingObject.openPricingPage(urlForQa1);
        PricingObject.reserveStorageUnit();
        actualCount=PricingObject.removalButton();
        PricingObject.Sleep();
        System.out.print("\n"+actualCount+"\n"+expectedCount);
        Assert.assertEquals(actualCount,expectedCount);

    }

    @Test
    public void OtherLinkOnpricingpage() throws InterruptedException {
        PricingObject.removalServices();
        actualForLinks=PricingObject.LongTermstorage();
        PricingObject.Sleep();
        System.out.print("\n"+actualForLinks+"\n"+expectedForLinks);
        Assert.assertEquals(actualForLinks,expectedForLinks);

    }

    @Test
    public void faqsOfPricingFlows() throws InterruptedException {
        PricingObject.openPricingPage(urlForQa1);
        expectedForFaqs=PricingObject.FaqsOfPricing();
        System.out.print("\n"+expectedForFaqs[0]+"\n"+expectedForFaqs[1]);
        Assert.assertEquals(expectedForFaqs[0],expectedForFaqs[1]);


    }
}
