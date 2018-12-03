package PageObjects;

import com.sun.org.apache.bcel.internal.generic.DREM;
import io.restassured.RestAssured;
import org.jsoup.Connection;
import org.jsoup.helper.HttpConnection;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * Created by VenD on 11/4/2018.
 */
public class NewLandingObjects {
    WebDriver driver;
    WebDriverWait wait;
    int i=0;
    public static By getTodaysLowestPriceButton=By.className("toGoWizard");
    public static By howItWorkButton=By.linkText("How it Works");
    public static By videoModal=By.id("video-thumbnail");
    public static By crossButtonOnModal=By.className("close");
    public static By businessStorageLink=By.linkText("Business Storage");
    public static By studentStorageLink=By.linkText("Student Storage");
    public static By contactUsOfBusinessPage=By.id("find-my-unit-storage");
    public static By getStartedOfStudentStoragePage=By.id("find-my-unit-storage");
    public static By logoOfBystored=By.className("logo");
    public static By hamburger=By.id("dropdownMenu1");
    public static By hamburgerOptions=By.className("new-dropdown");
    public static By loginPage=By.linkText("LOG IN");
    public static By loginPageButton=By.id("btnLoginSubmit");
    public static By getGetTodaysLowestPriceText=By.className("heading");
    public static String getGetTodaysLowestPriceTextget;
    public static By tableToGo=By.className("w-100");
    public static By bookNowButton=By.className("toGoWizard");
    public static By bookNowUpperButton=By.className("bs-cta-wrapper");
    public static By videoBelow=By.className("pointer");
    public static By calculator=By.linkText("OPEN CALCULATOR");
    public static By wizardGoing=By.linkText("WE'RE OFF TO THE WIZARD");
    int j=0;
    int k=0;
    int l=0;



    public NewLandingObjects(WebDriver driver,WebDriverWait wait)
    {
        this.driver=driver;
        this.wait=wait;
    }

    public void Sleep() throws InterruptedException
    {
        Thread.sleep(2000);

    }



    public void openLandingPage(String url)
    {

        driver.navigate().to(url+"?v=5");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getTodaysLowestPriceButton));
        driver.manage().window().maximize();

    }

    public void moveToBack()
    {
        driver.navigate().back();
    }

    public int headerLinks()

    {
        videoOfHeader();
        i=i+1;
        businessStorageLink();
        i=i+1;
        moveToBack();
        studentStorageLink();
        i=i+1;
        moveToBack();
        logoOfBystored();
        i=i+1;
        hamburgerMenu();
        i=i+1;
        loginPage();
        i=i+1;
        moveToBack();
        wait.until(ExpectedConditions.visibilityOfElementLocated(getTodaysLowestPriceButton));


        return i;


    }

    public String getTodaysLowestPrices()

    {
        driver.findElement(getTodaysLowestPriceButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoOfBystored));
        getGetTodaysLowestPriceTextget = driver.findElement(getGetTodaysLowestPriceText).getText();
        moveToBack();
        wait.until(ExpectedConditions.visibilityOfElementLocated(getTodaysLowestPriceButton));
        return getGetTodaysLowestPriceTextget;

    }

    public void videoOfHeader()
    {
        driver.findElement(howItWorkButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(videoModal));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(howItWorkButton) );
       // driver.findElement(crossButtonOnModal).click();

    }

    public void businessStorageLink()
    {
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(videoModal));
        wait.until(ExpectedConditions.visibilityOfElementLocated(howItWorkButton));
        driver.findElement(businessStorageLink).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoOfBystored));

    }
    public void studentStorageLink()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(getTodaysLowestPriceButton));
        driver.findElement(studentStorageLink).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(getStartedOfStudentStoragePage));
    }

    public void logoOfBystored()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(getTodaysLowestPriceButton));
        driver.findElement(logoOfBystored).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoOfBystored));
    }


    public void hamburgerMenu()
    {
        driver.findElement(hamburger).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(hamburgerOptions));
    }

    public void loginPage()
    {

        driver.findElement(loginPage).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPageButton));

    }

    public int bookNowSection()
    {

        bookNowUpper();
        j=j+1;
        moveToBack();
        videoBelow();
        j=j+1;
        bookNowBelow();
        j=j+1;
        moveToBack();
        return j;

    }

    public void bookNowUpper()
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(bookNowUpperButton) );
        wait.until(ExpectedConditions.visibilityOfElementLocated(bookNowUpperButton));
        driver.findElement(bookNowUpperButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoOfBystored));
    }
    public void videoBelow()
    {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(videoBelow) );
        wait.until(ExpectedConditions.visibilityOfElementLocated(videoBelow));
        driver.findElement(videoBelow).click();

        driver.navigate().refresh();

    }

    public void bookNowBelow()
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(tableToGo) );
        wait.until(ExpectedConditions.visibilityOfElementLocated(bookNowButton));
        driver.findElement(bookNowButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoOfBystored));
    }

    public int calculatorSection() {

        calculator();
        k=k+1;
        moveToBack();

        wizardButton();
        k=k+1;
        moveToBack();
        return k;
    }

    public void calculator()

    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(calculator) );
        wait.until(ExpectedConditions.visibilityOfElementLocated(calculator));
        driver.findElement(calculator).click();




        wait.until(ExpectedConditions.visibilityOfElementLocated(logoOfBystored));
    }

    public void wizardButton()
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(calculator) );
        wait.until(ExpectedConditions.visibilityOfElementLocated(calculator));
        driver.findElement(wizardGoing).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoOfBystored));
    }





}
