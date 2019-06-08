package PageObjects;

import General.DBConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by VenD on 3/27/2019.
 */
public class WizardStep1Objects {


    WebDriver driver;
    WebDriverWait wait;

    public static By landingPageQuote=By.linkText("Get Quote");
    public static By startStoringHeading=By.className("start-storing-head");
    public static By nextButton=By.id("nextBtn");
    public static By staris=By.id("stairs");
    public static By starisList=By.xpath("//*[@id=\"stairs\"]/ul");
    public static By packing=By.id("assistance");
    public static By packingList=By.xpath("//*[@id=\"assistance\"]/ul");
    public static By adressEnter=By.className("search-address");
    public static By adressList=By.xpath("//*[@id=\"search-results-container\"]/ul");
    public static By finalAddress=By.id("selected-address-text");
    public static By datepicker=By.xpath("//*[@id=\"datepicker\"]/div/table");
    public static By datePickerVisible=By.className("ui-datepicker-month");
    public static By dateList2=By.xpath("//*[@id=\"search-results-container\"]/ul");

    public static By timeslotsAfterNoon=By.xpath("//*[@id=\"afternoonTime\"]");
    public static By selectorForMonth=By.xpath("//*[@id=\"datepicker\"]/div/div/div/select[1]");

    public static By selectYear=By.xpath("//*[@id=\"datepicker\"]/div/div/div/select[2]");
    public static boolean present;
    public static By step2=By.id("stage1");
    public static By step2Logo=By.id("step1ProgControl");
    public static By nameField=By.id("fName");
    public static By emailFiled=By.id("email");
    public static By phoneNumberField=By.id("pNumber");
    public static By step3=By.id("registerBtn");
    public static By ste3Text=By.id("ccSectionHeading");
    public static By creaditCrad=By.id("nameoncard");
    public static By creditCardNumber=By.id("ccnumber");
    public static By creditcardMonth=By.id("cc-exp-month");
    public static By creditcardYear=By.id("cc-exp-year");
    public static By creditcardCVV=By.id("cvv");
    public static By termAggrement=By.id("termsAgreement");
    public static By orderConfirmation=By.id("stage3");
    public static By confirmationTick=By.className("confirmation-tick");
    public static By hamburgerClick= By.xpath("/html/body/header/div/nav/div[1]/button/img");
    public static By hamburgerLinks=By.xpath("//*[@id=\"new-header-links\"]/li[1]");
    public static By hamburgerMyAccount=By.xpath("//*[@id=\"new-header-links\"]/li[8]");
    public static By aftermyAccountText=By.className("list-group");
    public static By myInfoClick=By.xpath("/html/body/section[1]/div/div/div/div/div[1]/div/a[7]");
    public static By FnameId=By.id("firstName");
    public static By resetPasswordClick=By.id("changePasswordSection");
    public static By passwordField=By.id("password");
    public static By confirmPassword=By.id("confirmPassword");
    public static By clickOnSetPassword=By.id("profileSubmit");
    public static By resetPasswordMessage=By.id("successMessage");
    public static By logoutButton=By.xpath("//*[@id=\"new-header-links\"]/li[9]");
    public static By afterLogout=By.id("email");
    public static By signInlink=By.linkText("Sign in here");
    public static By signInModal=By.className("modal-body");
    public static By signInEmail=By.id("emailLogin");
    public static By signInPassword=By.id("passwordLogin");
    public static By clickSignInButton=By.id("btnLoginSubmit");
    public static By emailError=By.id("email-error");
    public static Boolean responseOfInvalidEmail;
    public static By addressAvaialability=By.linkText("Can't find a suitable time slot? Click here");
    public static By nameAdresssAvaialbility=By.id("custom-timeslots-name");
    public static By emailAddressAvailability=By.id("custom-timeslots-email");
    public static By phoenNumberAddressAvailability=By.id("custom-timeslots-phone");
    public static By Message=By.id("custom-timeslots");
    public static By submitAddressAvailability=By.id("submit-custom-timeslots");
    public static By responseOfAddressUnavailability=By.id("custom-timeslots-success");
    public static boolean actualResponseOfAddressUnavaialbility;
    public static By addressUnavailabilityModals=By.id("custom-timeslots-form");
    public static By alreadyExistOrderMessage=By.id("paymentFailureModalText");
    public static boolean alreadyExistOrderMsg;
    public static By alreadyExistOrderClose=By.className("close");
    public static ArrayList<String> starisInfo;


    public static Boolean orderHappyFlowResponse;




    public WizardStep1Objects(WebDriver driver , WebDriverWait wait)

    {
        this.driver=driver;
        this.wait=wait;
    }

    public void waiting() throws InterruptedException {
        Thread.sleep(2000);
    }

    public  void openLandingpage(String url)
    {

         driver.navigate().to(url+"?v=8");
        driver.manage().window().maximize();
        wait.until(ExpectedConditions.visibilityOfElementLocated(landingPageQuote));
    }

    public  void goToUnitSelectionPage()
    {

        driver.findElement(landingPageQuote).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(startStoringHeading));
    }
    public void gotopromotionpage()
    {
        driver.findElement(nextButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(startStoringHeading));

    }

    public void gotoStep1()
    {
        driver.findElement(nextButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(startStoringHeading));

    }



    public void selectStais(String stairsNumber) throws InterruptedException {


        driver.findElement(staris).click();
        WebElement elementStairInfo = driver.findElement(starisList);
        List<WebElement> stairsInfo = elementStairInfo.findElements(By.tagName("li"));
        waiting();
        //stairsInfo.get(stairsNumber).click();




        for(WebElement stairsOption: stairsInfo)
        {
            System.out.print("\n"+stairsOption.getText()+"\n" +
                    "");
            if(stairsOption.getText().equals(stairsNumber))
            {
                System.out.print("\n"+stairsNumber+"\n");
                stairsOption.click();
//                Thread.sleep(5000);
                waiting();
                break;

            }
        }







    }
    public void selectPacking(String packingNumber ) throws InterruptedException

    {

        driver.findElement(packing).click();
        WebElement elementParkingInfo=driver.findElement(packingList);
        List<WebElement> packingInfo=elementParkingInfo.findElements(By.tagName("li"));
        waiting();

      //  packingInfo.get(packingNumber).click();

        for(WebElement pakcingInfoOption: packingInfo)
        {
            System.out.print("\n"+pakcingInfoOption.getText()+"\n" + "");

            if(pakcingInfoOption.getText().equals(packingNumber))
            {
                System.out.print("\n"+packingNumber+"\n");
                pakcingInfoOption.click();
//                Thread.sleep(5000);
                waiting();
                break;

            }
        }



    }


    public void selectAddress(String startAddress,int addressList) throws InterruptedException {


        driver.findElement(adressEnter).sendKeys(startAddress);
        wait.until(ExpectedConditions.visibilityOfElementLocated(adressList));
        WebElement elementAddressINfo=driver.findElement(adressList);
        List<WebElement> AddressInfo=elementAddressINfo.findElements(By.tagName("li"));
        AddressInfo.get(addressList).click();
        waiting();
        WebElement elementAddressINfo2=driver.findElement(dateList2);
        List<WebElement> AddressInfo2=elementAddressINfo2.findElements(By.tagName("li"));
        AddressInfo2.get(addressList).click();



    }

    public void notEqualMonth(String monthName) throws InterruptedException
    {
        driver.findElement(selectorForMonth).click();
        WebElement selector = driver.findElement(selectorForMonth);
        List<WebElement> SelectorValue = selector.findElements(By.tagName("option"));
        Thread.sleep(3000);
        for(WebElement opt: SelectorValue)
        {
            System.out.print("\n"+opt.getText()+"\n" +
                    "");
            if(opt.getText().equals(monthName))
            {
                opt.click();
              Thread.sleep(3000);
               waiting();
               break;

            }
        }

//        for(int z=0;z<SelectorValue.size();z++)
//
//        {
//            System.out.print("\n"+SelectorValue.get(z));
//
//            if(SelectorValue.get(z).equals(""+monthTaken))
//            {
//                SelectorValue.get(z).click();
//                Thread.sleep(5000);
//                waiting();
//                break;
//            }
//
//            System.out.print(SelectorValue.get(z));
//        }
    }

    public void notEqualYear(int yearTaken) throws InterruptedException
    {
        driver.findElement(selectYear).click();
        WebElement yearSelector=driver.findElement(selectYear);
        List<WebElement> yearSelectorValue=yearSelector.findElements(By.tagName("option"));
//        for(int y=0;y<yearSelectorValue.size();y++)
//        {
//            if(yearSelectorValue.get(y).equals(yearTaken)) {
//                yearSelectorValue.get(y).click();
//                Thread.sleep(5000);
//                waiting();
//            }
//        }


        for(WebElement opt2: yearSelectorValue)
        {
            System.out.print("\n"+opt2.getText()+"\n" +
                    "");
            if(opt2.getText().equals(""+yearTaken))
            {
                opt2.click();
                Thread.sleep(3000);
                waiting();
                break;

            }
        }
    }

    public void dateSelection(int date)
    {

        WebElement table = driver.findElement(datepicker);
        List<WebElement> columns = table.findElements(By.tagName("td"));
//        System.out.println("" + dayOfWeek);
//        dayOfWeek = dayOfWeek + 6;
//        System.out.println("" + dayOfWeek);

        System.out.print(columns);
        for (WebElement cell : columns) {
            System.out.print("'nhe chal rha 1 2 3");
            System.out.print(cell.getText());

            if (cell.getText().equals("" + date))
            //if(cell.getText().equals("16"))
            {
                System.out.print("'nhe chal rha 1 2 3");

                //  System.out.println("*******");
                cell.click();
                break;
            }


        }
    }

    public void selectDate(int monthTaken,int yearTaken, int date, String monthName) throws InterruptedException {

        //wait.until(ExpectedConditions.visibilityOfElementLocated(datePickerVisible));

       Thread.sleep(15000);


        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DATE);
        int month=calendar.get(Calendar.MONTH);
        int year=calendar.get(Calendar.YEAR);

        System.out.print(month);
        System.out.print(year);
        System.out.print(dayOfWeek);





        if( month!=monthTaken && year!=yearTaken)
        {
            notEqualMonth(monthName);
            notEqualYear(yearTaken);
           dateSelection(date);


        }
        else if ( month!=monthTaken && year==yearTaken)
        {

            notEqualMonth(monthName);
            dateSelection(date);
        }
        else if(month==monthTaken && year!=yearTaken)
        {
            notEqualYear(yearTaken);
            dateSelection(date);
        }


        else if(month==monthTaken && year==yearTaken)
        {

            dateSelection(date);


        }

        Thread.sleep(15000);


        WebElement timeslot = driver.findElement(timeslotsAfterNoon);
        List<WebElement> timeslotSelection = timeslot.findElements(By.tagName("li"));

        timeslotSelection.get(3).click();

        Thread.sleep(5000);


    }

    public void gotoStep2()
    {

        driver.findElement(step2).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(step2Logo));
    }

    public void enterName(String name)
    {

        driver.findElement(nameField).sendKeys(name);

    }
    public void enterEmail(String email)
    {

        driver.findElement(emailFiled).sendKeys(email);
    }
    public void enterPhoneNumber(String phoneNumber)
    {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);

    }

    public void step2DataEnteringForVlaidData(String name, String email, String phoneNumber)
    {
        enterName(name);
        enterEmail(email);
        enterPhoneNumber(phoneNumber);


    }

    public void goToStep3()
    {
        driver.findElement(step3).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(ste3Text));
    }

    public void enterCardname(String cardName)
    {

        driver.findElement(creaditCrad).sendKeys(cardName);

    }
    public void enterCardnumber(String cardNumber)
    {

        driver.findElement(creditCardNumber).sendKeys(cardNumber);

    }
    public void enterCardMonth(String cardMonth)
    {
        driver.findElement(creditcardMonth).sendKeys(cardMonth);

    }
    public void enterCardYear(String cardYear)
    {

        driver.findElement(creditcardYear).sendKeys(cardYear);
    }

    public void enterCardCvv(String Cardcvv)
    {
        driver.findElement(creditcardCVV).sendKeys(Cardcvv);

    }
    public void termsOfAggrement()
    {

        driver.findElement(termAggrement).click();
    }


    public void step3DataEnteringForHappyFlow(String cardName, String cardNumber, String cardMonth, String cardYear,String cardCvv)
    {

        enterCardname(cardName);
        enterCardnumber(cardNumber);
        enterCardMonth(cardMonth);
        enterCardYear(cardYear);
        enterCardCvv(cardCvv);
        termsOfAggrement();
    }

    public void orderConfirmation()
    {

        driver.findElement(orderConfirmation).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationTick));

    }
    public Boolean orderHappyFlowResponse()
    {
       orderHappyFlowResponse= driver.findElement(confirmationTick).isDisplayed();
        return orderHappyFlowResponse;
    }

    public void clickHamburger()
    {

        driver.findElement(hamburgerClick).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(hamburgerLinks));

    }
    public void clickOnMyAccountPage()
    {
        driver.findElement(hamburgerMyAccount).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(aftermyAccountText));
    }
    public void ClickMyInfoList()
    {

        driver.findElement(myInfoClick).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(FnameId));
    }
    public void ClickOnPasswordLink()
    {
        driver.findElement(resetPasswordClick).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));

    }
    public void EnterPassword(String password)
    {
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPassword).sendKeys(password);
    }
    public void submitPassword()
    {
        driver.findElement(clickOnSetPassword).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(resetPasswordMessage));
    }
    public void ClickLogout()
    {

        driver.findElement(logoutButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(afterLogout));
    }



    public void findSignIn()
    {
        driver.findElement(signInlink).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInModal));

        //driver.findElement(signInModal)

    }
    public void enterDataForSignInModal(String email, String password)
    {
        enterEmailForSignIn(email);
        enterPasswordForSignIn(password);

    }
    public void enterEmailForSignIn(String email)
    {
        driver.findElement(signInEmail).sendKeys(email);

    }
    public void enterPasswordForSignIn(String password)
    {
        driver.findElement(signInPassword).sendKeys(password);
    }


    public void ClickSignIn()
    {

        driver.findElement(clickSignInButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailFiled));
    }

//    public void enterDataForEmailValidation(String name, String email)
//    {
//        enterName(name);
//        enterEmail(email);
//
//    }

    public boolean responseOfInvalidEmail()
    {
        responseOfInvalidEmail=driver.findElement(emailError).isDisplayed();
        return responseOfInvalidEmail;
    }

    public void ClickOnTimeSlotsUnavailable()
    {

        driver.findElement(addressAvaialability).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(addressUnavailabilityModals));

    }
    public void fillDataForAddressAvailability(String name, String email, String phoneNumber,String message)
    {
        MessageAddressAvailability(message);
        nameForAddresAvailability(name);
        emailOfAddressAvailability(email);
        phoenNumberAddressAvailability(phoneNumber);

    }

    public void nameForAddresAvailability(String name)
    {

        driver.findElement(nameAdresssAvaialbility).sendKeys(name);
    }
    public void emailOfAddressAvailability(String email)
    {
        driver.findElement(emailAddressAvailability).sendKeys(email);

    }
    public void phoenNumberAddressAvailability(String phoneNumber)
    {
        driver.findElement(phoenNumberAddressAvailability).sendKeys(phoneNumber);


    }
    public void MessageAddressAvailability(String message)
    {
        driver.findElement(Message).sendKeys(message);


    }

    public void submitButtonForAddressAvailabilityButton()
    {
        driver.findElement(submitAddressAvailability).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(responseOfAddressUnavailability));
    }
    public Boolean responseOfAddressUnavailable()
    {

        actualResponseOfAddressUnavaialbility=driver.findElement(responseOfAddressUnavailability).isDisplayed();
        return actualResponseOfAddressUnavaialbility;
    }


    public boolean orderFlowExistingOrderResponse() throws InterruptedException {
        driver.findElement(orderConfirmation).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(alreadyExistOrderMessage));
        alreadyExistOrderMsg=driver.findElement(alreadyExistOrderMessage).isDisplayed();
        waiting();
        driver.findElement(alreadyExistOrderClose).click();
        return alreadyExistOrderMsg;


    }

//    public void clickLogoutButton()
//    {
//
//    }

    public ArrayList<String> responseOfStairsInfo(String email) throws SQLException {


       starisInfo= DBConnection.GetStairsInfo(email);
        return starisInfo;
    }

}

