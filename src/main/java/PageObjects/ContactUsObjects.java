package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static General.Main.driver;
import static General.Main.wait;

/**
 * Created by VenD on 9/5/2018.
 */
public class ContactUsObjects {

    WebDriver driver;
    WebDriverWait wait;
    public static By yourDetails=By.className("center-block");
    public static  By byFirstName = By.name("firstName");
    public static  By byLastName = By.name("lastName");
    public static By byEmail = By.name("email");
    public static   By byPhoneNumber = By.name("nationalNumber");
    public static  By byMessage = By.name("message");
    public static  By bySubmit = By.id("contact-us-submit");
    public static  By byModal=By.className("modal-body");
    public static  By h1Text = By.cssSelector("#contactUsSubmitModal > div > div > div.modal-body > h4");
    public static By closeButton=By.className("close");
    public static  By modal = By.cssSelector("#contactUsSubmitModal > div > div");
    public static By emailError=By.id("email-error");
    public static By phoneNumberError=By.id("cuNum-error");

    public static   String responseOfContactUsHappyFlow;
    public static String responseOfContactUsInvalidEmail;
    public static String responseOfContactUsInvalidPhoneNumber;
    public static By firstNameError=By.id("firstName-error");
    public static By lastNameError=By.id("lastName-error");
    public static By messageError=By.id("message-error");
    public static By selectedInquiryError=By.id("selectedInquiry-error");
    public static By upArrow=By.className("iti-arrow");
    public static By countryList=By.id("country-listbox");

    public static int count=0;

    By collectionOfErrors[] = {firstNameError, lastNameError,emailError,phoneNumberError,messageError,selectedInquiryError};





    public ContactUsObjects(WebDriver driver, WebDriverWait wait)

    {
        this.driver=driver;
        this.wait=wait;
    }

    public void Sleep() throws InterruptedException
    {
        Thread.sleep(2000);

    }
    public void openContactUsPage(String url)
    {


        driver.navigate().to(url+"contact-us");
        wait.until(ExpectedConditions.visibilityOfElementLocated(yourDetails));
        driver.manage().window().maximize();

    }
    public void enterDataForContactUsHappyFlow(String fName, String lName, String email,String countryName, String number ,String message,String option ) throws InterruptedException {
        enterFName(fName);
        enterLName(lName);
        enterEmail(email);
        enterCountryName(countryName);
        enterNumber(number);
        enterOption(option);
        enterMessage(message);

    }

    public void enterDataForContactUsInvalidEmail(String fName,String lName,String invalidEmail,String number)
    {
        enterFName(fName);
        enterLName(lName);
        enterEmail(invalidEmail);
        enterNumber(number);

    }
    public void enterDataForContactUsInvalidPhoneNumber(String fName,String lName,String invalidEmail,String number,String option)
    {
        enterFName(fName);
        enterLName(lName);
        enterEmail(invalidEmail);
        enterNumber(number);
        enterOption(option);

    }



    public void enterFName(String fName)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byFirstName));
        driver.findElement(byFirstName).sendKeys(fName);
    }
    public void enterLName(String lName)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byLastName));
        driver.findElement(byLastName).sendKeys(lName);
    }
    public void enterEmail(String email)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byEmail));
        driver.findElement(byEmail).sendKeys(email);
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


    public void enterNumber(String number)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byPhoneNumber));
        driver.findElement(byPhoneNumber).sendKeys(number);
    }

    public void enterOption(String option)
    {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("selected-parking")));
        driver.findElement(By.id("selected-parking")).click();
        WebElement allElements = driver.findElement(By.xpath("//*[@id=\"inquiry-options\"]"));
        List<WebElement> countriesList=allElements.findElements(By.tagName("li"));
        for (WebElement li : countriesList) {
            if (li.getText().equals(option)) {
                li.click();
            }
        }

    }

    public void enterMessage(String message)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byMessage));
        driver.findElement(byMessage).sendKeys(message);

    }


    public void submitForm()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bySubmit));
        driver.findElement(bySubmit).click();

    }
    public String responseForHappyFlow()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byModal));
       responseOfContactUsHappyFlow= driver.findElement(h1Text).getText();
        driver.findElement(closeButton).click();

        return responseOfContactUsHappyFlow;

    }
    public String responseForInvalidPhoneNumber()
    {
        wait.until(ExpectedConditions.textToBe(phoneNumberError,"Phone format/length is not valid"));
        responseOfContactUsInvalidPhoneNumber=driver.findElement(phoneNumberError).getText();
        return  responseOfContactUsInvalidPhoneNumber;
    }


    public String responseForInvalidEmail()
    {
        wait.until(ExpectedConditions.textToBe(emailError,"Email Address is invalid"));
        responseOfContactUsInvalidEmail=driver.findElement(emailError).getText();
        return responseOfContactUsInvalidEmail;
    }

    public int responseWithEmptyFields()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameError));
        for (int i=0;i<collectionOfErrors.length;i++)
        {
           driver.findElement(collectionOfErrors[i]);
            count=count+1;
        }
        System.out.println(count);

        return count;
    }


}
