package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by VenD on 11/25/2018.
 */
public class PricingPageObjects {

    WebDriver driver;
    WebDriverWait wait;
    public static By pricingOpentext= By.id("convenience");
    public static By greenReserveButton=By.linkText("RESERVE A STORAGE UNIT NOW");
    public static By greenRemovalButton=By.id("findUnit");
    public static By afterGreenButtonClick=By.className("heading");
    public static By afterRemovalClick=By.className("d-inline-block");
    public static By remoavlServices=By.linkText("removal service");
    public static By longTermStorage=By.linkText("Long Term Storage");
    public static By afterMoveservice=By.className("move-service");
    public static By afterLongTerm= By.id("content");
    public static By leftFaqs=By.id("accordionleft");
    public static By heading=By.id("Heading");
    public static By longtermpart=By.xpath("//*[@id=\"got-question\"]/div/div/div");
    public static String head="Heading";
    public static By openFaqs=By.className("panel-body");
    public static int[] result;

    public static int j=0;
    public static int i=0;
    public int k=0;
    public int loop;



    public PricingPageObjects(WebDriver driver,WebDriverWait wait)


    {
        this.driver=driver;
        this.wait=wait;
    }

    public void Sleep() throws InterruptedException
    {
        Thread.sleep(2000);

    }



    public void openPricingPage(String url)
    {

        driver.navigate().to(url+"pricing");
        wait.until(ExpectedConditions.visibilityOfElementLocated(pricingOpentext));
        driver.manage().window().maximize();

    }

    public void reserveStorageUnit()
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(greenReserveButton));
        driver.findElement(greenReserveButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(afterGreenButtonClick));
        if(driver.findElement(afterGreenButtonClick).isDisplayed())
        {
            j=j+1;
        }
        driver.navigate().back();

    }

    public int removalButton()
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(greenRemovalButton));
        driver.findElement(greenRemovalButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(afterRemovalClick));
        if(driver.findElement(afterRemovalClick).isDisplayed())
        {
            j=j+1;
        }
        driver.navigate().back();
        return j;

    }

    public void removalServices()
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(remoavlServices));
        driver.findElement(remoavlServices).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(afterMoveservice));
        if(driver.findElement(afterMoveservice).isDisplayed())
        {
            i=i+1;
        }
        driver.navigate().back();
    }

    public int LongTermstorage() throws InterruptedException {
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(longtermpart));
        driver.findElement(longTermStorage).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(afterLongTerm));
        if(driver.findElement(afterLongTerm).isDisplayed())
        {
            i=i+1;
        }
        driver.navigate().back();
        return i;
    }

    public int[] FaqsOfPricing() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(leftFaqs));
        Sleep();
        System.out.print(""+i+"Heading");
        wait.until(ExpectedConditions.visibilityOfElementLocated(leftFaqs));
        for(loop=1;loop<7;loop++)
        {

            System.out.print("\n"+loop+""+head);

            driver.findElement(By.id(""+loop+""+head)).click();
            //wait.until(ExpectedConditions.visibilityOfElementLocated(openFaqs));
            if(driver.findElement(openFaqs).isDisplayed())
            {

                k=k+1;
            }
            Sleep();

        }
        System.out.print(k);
        result = new int[]{k, loop-1};
        return result;

    }

}
