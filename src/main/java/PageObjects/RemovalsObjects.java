package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by VenD on 4/19/2018.
 */
public class RemovalsObjects {

    WebDriver driver;
    public static By removalInputName= By.id("name");
    public static By removalInputEmail=By.id("email");
    public  static By removalInputPhoneNumber=By.name("nationalNumber");
    public static By removalSubmitButton=By.id("moves-submit");
    public static By remoavlmsg=By.id("name");
    public boolean response;
    public static By getInvalidEmailText= By.id("email-error");
    public static By getInvalidPhoneNumberText= By.id("movesNum-error");
    public static By clickHereText=By.linkText("CLICK HERE");
    public static By clickHereNavigate=By.className("hero-content");
    public static By upArrow=By.className("iti-arrow");
    public static By countryList=By.id("country-listbox");

    public String responseForInvalidEmail;
    public String responseForInvalidPhoneNumber;
    public boolean responseForClickHere;

    public RemovalsObjects(WebDriver driver)

    {
        this.driver=driver;
    }

    public void openBrowser(String url) throws InterruptedException
    {
        Thread.sleep(2000);
        driver.navigate().to(url+"removals");
        driver.manage().window().maximize();
    }
    public void enterDataforHappyFlow(String name,String email,String countryName ,String phonenumber) throws InterruptedException

    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.className("custom-form")));
        getRemovalName(name);

        getRemovalEmail(email);

        enterCountryName(countryName);
        getRemovalPhonenumber(phonenumber);



    }
    public void getRemovalName(String name) throws InterruptedException
    {

        driver.findElement(removalInputName).sendKeys(name);
        Thread.sleep(2000);
    }
    public void getRemovalEmail(String email) throws InterruptedException
    {
        driver.findElement(removalInputEmail).sendKeys(email);
        Thread.sleep(2000);

    }


    public void enterCountryName(String countryName) throws InterruptedException {
        driver.findElement(upArrow).click();
        WebElement elementCountryList = driver.findElement(countryList);
        int lengthOfCountryName=countryName.length();
        System.out.print("\n"+lengthOfCountryName+"\n");
        List<WebElement> countryNameInfo = elementCountryList.findElements(By.tagName("li"));

        System.out.print("\n" + countryNameInfo + "\n" +
                "");
        //stairsInfo.get(stairsNumber).click();




        for(WebElement CountryOption: countryNameInfo) {

            String NameOfCountryInList=CountryOption.getText();
            System.out.print("\n" + CountryOption.getText() + "\n" +
                    "");
            int lengthOfCountryNameInList=NameOfCountryInList.length();
            System.out.print("\n" + lengthOfCountryNameInList + "\n");
            if(lengthOfCountryNameInList>=lengthOfCountryName)
            {
                String afterSplittingCountryNameInList = NameOfCountryInList.substring(0,lengthOfCountryName);
                //substring(lengthOfCountryNameInList - lengthOfCountryName);
                // substring(NameOfCountryInList.length(),lengthOfCountryName);
                System.out.print("\n" + afterSplittingCountryNameInList + "\n");



                if (lengthOfCountryName == afterSplittingCountryNameInList.length() && afterSplittingCountryNameInList.equals(countryName) ) {
                    System.out.print("\n" + CountryOption + "\n");
                    CountryOption.click();
                    //Thread.sleep(2000);
                    //waiting();
                    break;

                }
            }
        }
//        wait.until(ExpectedConditions.visibilityOfElementLocated(byEmail));
//        driver.findElement(byEmail).sendKeys(email);
    }


    public void getRemovalPhonenumber(String phonenumber) throws InterruptedException
    {
        driver.findElement(removalInputPhoneNumber).sendKeys(phonenumber);
        Thread.sleep(2000);


    }
    public boolean submit() throws InterruptedException

    {

        driver.findElement(removalSubmitButton).click();
        Thread.sleep(4000);
        response=driver.findElement(remoavlmsg).isDisplayed();
        Thread.sleep(2000);
        return response;



    }
    public void submitButton() throws InterruptedException
    {
        driver.findElement(removalSubmitButton).click();
        Thread.sleep(1000);
    }

    public String enterDataForInvalidEmail(String name,String email,String phoneNumber) throws InterruptedException
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.className("custom-form")));
        getRemovalName(name);
        getRemovalEmail(email);
        getRemovalPhonenumber(phoneNumber);
        submitButton();
        responseForInvalidEmail=driver.findElement(getInvalidEmailText).getText();
        return responseForInvalidEmail;

    }

    public String enterDataForInvalidPhoneNumber(String name,String email,String phoneNumber) throws InterruptedException
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.className("custom-form")));
        getRemovalName(name);
        getRemovalEmail(email);
        getRemovalPhonenumber(phoneNumber);
        submitButton();
        Thread.sleep(2000);
        responseForInvalidPhoneNumber=driver.findElement(getInvalidPhoneNumberText).getText();
        return responseForInvalidPhoneNumber;

    }

    public boolean clickhere() throws InterruptedException
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.className("custom-form")));
        driver.findElement(clickHereText).click();
        Thread.sleep(2000);
        responseForClickHere=driver.findElement(clickHereNavigate).isDisplayed();
        return responseForClickHere;
    }



}
