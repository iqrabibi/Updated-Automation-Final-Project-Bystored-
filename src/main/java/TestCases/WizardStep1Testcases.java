package TestCases;

import General.DBConnection;
import General.Main;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import static General.InitMethods.*;
import static PageObjects.WareHouseObject.email;

/**
 * Created by VenD on 3/27/2019.
 */
public class WizardStep1Testcases extends Main {

    public String stairsNumber="2nd floor";
    public String packingNumber="No, I don't want packing assistance";
    public String startAddress="sw6 6af";
    public String invalidAdddress="nazimabad";
    public int addressList=0;
    public int month=5;
    public String monthName="Jun";
    public int year=2023;
    public int date=27;
    public String name="Test";
    public String email;
//    public String emailForDb;
    public String phoenNumber="0345296853426";
    public String invalidPhoneNumber="532156645623525632156";
    public String nameOnCard="test";
    public String cardnumber="4242424242424242";
    public String cardMonth;
    public String cardyear="2019";
    public String cardCvv="123";
    public Boolean ActualreponseforHappyFlow;
    public Boolean expectedForHappyFlowForOrder=true;
    public int random;
    public String password="iqrabibi";
    public String invalidEmail="@bys.com";
    public Boolean actualForInvalidEmail;
    public  Boolean expectedForInvalidEmaail=true;
    public String message="I am automation Engg";
    public boolean actualForAddress;
    public boolean expectedForAddress=true;
    public boolean actualForAlreadyExistOrder;
    public boolean expectedForAlreadyExistOrder=true;
    public boolean actualForInvalidPhoneNumber;
    public boolean expectedForInvalidNumber=true;
    public boolean responseOFInvalidAddressForm;
    public boolean ExpectedForInvalidAddress=true;
    public String discountCode="Automation";
    public boolean responseOfDcValid;
    public boolean ExpectedreponseOfDcValid=true;
    public String InvalidDiscountCode="abcd";
    public boolean responseOfDcInValid;
    public boolean ExpectedreponseOfDcInValid=true;
    public String invalidCrad="42424565324353223";
    public String invalidCardYear="1993";
    public String invalidCVV="123456";

    //int ord= 4046;
    public int Qa1logout=1;
    public int stagelogout=2;



    public ArrayList<String> reponseOfIds;
    public String orderId;
    public String bookingId;
    public String userId;
    public String storage_unit;
    public String storage_Unit_name;
    public String dialCode;
    public String countryCode;
    public String fName;
    public String bokingCreatedDate;
    public String userEmail;

//    public String email22="abc";

    public String actualForStairInfo;
    public String actualForParking;
    public ArrayList<String> reponseOfJobFactor;
    public int actualFORInvalidCrad;
    public int expectedForInvalidCARD=1;

    public int randomNumber()
    {
        int max=10000;
        int min=1;
        Random r = new Random();
        random =r.nextInt((max - min) + 1) + min;
        return random;
    }
    public String currentMonth()
    {
        Calendar calendar = Calendar.getInstance();
         int IntcardMonth=calendar.get(Calendar.MONTH);



        cardMonth = Integer.toString(IntcardMonth+1);
//        cardMonth=String.format("%01d", cardMonth);

        return cardMonth;


    }
    public String currentYear()
    {

        Calendar calendar = Calendar.getInstance();
        int IntCardYear=calendar.get(Calendar.YEAR);

        cardyear = Integer.toString(IntCardYear+1);

        return cardyear;
    }

    public String EmailGeneration()
    {


        email="test"+randomNumber()+"@bystored.com";
        System.out.print("\n"+email+"\n");
        return email;

    }

    @Test

    public  void WizardStep1HappyFlow() throws InterruptedException, SQLException {


        Wizard1Object.openLandingpage(urlForQa1);
        Wizard1Object.waiting();
        Wizard1Object.goToUnitSelectionPage();
        Wizard1Object.waiting();
        Wizard1Object.gotopromotionpage();
        Wizard1Object.waiting();
        Wizard1Object.gotoStep1();
        Wizard1Object.waiting();
        Wizard1Object.selectStais(stairsNumber);
        Wizard1Object.selectPacking(packingNumber);
        System.out.print("This is my month\n"+currentMonth()+"\n0"+currentMonth());
        System.out.print("This is my year\n"+currentYear());
        Wizard1Object.selectAddress(startAddress,addressList);
        Wizard1Object.waiting();
        Wizard1Object.selectDate(month,year,date,monthName);
        Wizard1Object.waiting();

        Wizard1Object.gotoStep2();
        Wizard1Object.waiting();
//        email="Test"+randomNumber()+"@bystored.com";
//        System.out.print("\n"+email);
        email=EmailGeneration();
        Wizard1Object.step2DataEnteringForVlaidData(name,email,phoenNumber);
        Wizard1Object.waiting();
        Wizard1Object.goToStep3();
        Wizard1Object.waiting();
        Wizard1Object.step3DataEnteringForHappyFlow(nameOnCard,cardnumber,"0"+currentMonth(),cardyear,cardCvv);
        Wizard1Object.waiting();
        Wizard1Object.orderConfirmation();
        Wizard1Object.waiting();

        ActualreponseforHappyFlow=Wizard1Object.orderHappyFlowResponse();
        Wizard1Object.waiting();
        Wizard1Object.clcikOnPostPayment();
        Wizard1Object.waiting();

        Wizard1Object.clickHamburger();
        Wizard1Object.waiting();
        Wizard1Object.ClickLogout(Qa1logout);
        Wizard1Object.waiting();
        Assert.assertEquals(ActualreponseforHappyFlow,expectedForHappyFlowForOrder);
//       actualForStairInfo= Wizard1Object.responseOfStairsInfo(email);
//        System.out.print(actualForStairInfo);




    }

    @Test
    public void jobFactor() throws SQLException {
        reponseOfJobFactor=Wizard1Object.getUserId(email);
        actualForStairInfo=reponseOfJobFactor.get(2);
        actualForParking=reponseOfJobFactor.get(3);
        System.out.print("\n"+actualForStairInfo+"\n"+actualForParking);
        Assert.assertEquals(actualForParking,"PACKING_NO","having same pakcing info");
        Assert.assertEquals(actualForStairInfo,"FLOOR_2","having same floor info");

    }


    @Test
    public void Booking_Order_Userid() throws SQLException {
        reponseOfIds=Wizard1Object.getIds(email);
        userId=reponseOfIds.get(0);
        orderId=reponseOfIds.get(1);
        bookingId=reponseOfIds.get(2);
        Assert.assertEquals(reponseOfIds.get(3),email);



    }

    @Test
    public void StoragePlan() throws SQLException {
        reponseOfIds=Wizard1Object.getStoragePlan(Integer.parseInt(orderId));
        System.out.print(reponseOfIds);
        storage_unit=reponseOfIds.get(3);
        storage_Unit_name=reponseOfIds.get(4);
        System.out.print("\n"+storage_unit+"\n"+storage_Unit_name);
        Assert.assertEquals(storage_unit,"STORAGE_12");
//        userId=reponseOfIds.get(0);
//        orderId=reponseOfIds.get(1);
//        bookingId=reponseOfIds.get(2);
//        Assert.assertEquals(reponseOfIds.get(3),email);



    }
    @Test
    public void getPhoneNumberForuser() throws SQLException {

        reponseOfIds=Wizard1Object.getUserPhoneNumber(email);
        System.out.print(reponseOfIds);
        countryCode=reponseOfIds.get(2);
        dialCode=reponseOfIds.get(1);
        Assert.assertEquals(dialCode,"+44");
        Assert.assertEquals("0"+countryCode,phoenNumber);

    }
    @Test
    public void getUserNameEmail() throws SQLException {
        reponseOfIds=Wizard1Object.getUserNameEmail(email);
        System.out.print(reponseOfIds);
        fName=reponseOfIds.get(0);

        userEmail=reponseOfIds.get(1);
        bokingCreatedDate=reponseOfIds.get(2);
        System.out.print("\n"+bokingCreatedDate+"\n");
        Assert.assertEquals(fName,name);
        Assert.assertEquals(userEmail,email);


    }





    @Test
    public void LoginForExistingUser() throws InterruptedException

    {
        Wizard1Object.openLandingpage(urlForQa1);
        Wizard1Object.waiting();
        Wizard1Object.goToUnitSelectionPage();
        Wizard1Object.waiting();
        Wizard1Object.gotopromotionpage();
        Wizard1Object.waiting();
        Wizard1Object.gotoStep1();
        Wizard1Object.waiting();
        Wizard1Object.selectStais(stairsNumber);
        Wizard1Object.selectPacking(packingNumber);
        System.out.print("This is my month\n"+currentMonth()+"\n0"+currentMonth());
        System.out.print("This is my year\n"+currentYear());
        Wizard1Object.selectAddress(startAddress,addressList);
        Wizard1Object.waiting();
        Wizard1Object.selectDate(month,year,date,monthName);
        Wizard1Object.waiting();

        Wizard1Object.gotoStep2();
        Wizard1Object.waiting();
//        email="Test"+randomNumber()+1+"@bystored.com";
//        System.out.print("\n"+email);
        email=EmailGeneration();
        System.out.print(email);
        Wizard1Object.step2DataEnteringForVlaidData(name,email,phoenNumber);
        Wizard1Object.waiting();
        Wizard1Object.goToStep3();
        Wizard1Object.waiting();




        Wizard1Object.clickHamburger();
        Wizard1Object.waiting();
        Wizard1Object.clickOnMyAccountPage();
        Wizard1Object.waiting();
        Wizard1Object.ClickMyInfoList();
        Wizard1Object.waiting();
        Wizard1Object.ClickOnPasswordLink();
        Wizard1Object.waiting();
        Wizard1Object.EnterPassword(password);
        Wizard1Object.waiting();
        Wizard1Object.submitPassword();
        Wizard1Object.waiting();
        Wizard1Object.clickHamburger();
        Wizard1Object.waiting();
        Wizard1Object.ClickLogout(stagelogout);
        Wizard1Object.waiting();



        Wizard1Object.openLandingpage(urlForQa1);
        Wizard1Object.waiting();
        Wizard1Object.goToUnitSelectionPage();
        Wizard1Object.waiting();
        Wizard1Object.gotopromotionpage();
        Wizard1Object.waiting();
        Wizard1Object.gotoStep1();
        Wizard1Object.waiting();
        Wizard1Object.selectStais(stairsNumber);
        Wizard1Object.selectPacking(packingNumber);
        System.out.print("This is my month\n"+currentMonth()+"\n0"+currentMonth());
        System.out.print("This is my year\n"+currentYear());
        Wizard1Object.selectAddress(startAddress,addressList);
        Wizard1Object.waiting();
        Wizard1Object.selectDate(month,year,date,monthName);
        Wizard1Object.waiting();

        Wizard1Object.gotoStep2();
        Wizard1Object.waiting();
        Wizard1Object.findSignIn();
        Wizard1Object.waiting();
        Wizard1Object.enterDataForSignInModal(email,password);
        Wizard1Object.waiting();
        Wizard1Object.ClickSignIn();
        Wizard1Object.waiting();


//        email="Test"+randomNumber()+"@bystored.com";
        System.out.print("\n"+email);
//        Wizard1Object.step2DataEnteringForVlaidData(name,email,phoenNumber);
        Wizard1Object.waiting();
        Wizard1Object.goToStep3();
        Wizard1Object.waiting();
        Wizard1Object.step3DataEnteringForHappyFlow(nameOnCard,cardnumber,"0"+currentMonth(),cardyear,cardCvv);
        Wizard1Object.waiting();
        Wizard1Object.orderConfirmation();
        Wizard1Object.waiting();

       // ActualreponseforHappyFlow=Wizard1Object.orderHappyFlowResponse();
        ActualreponseforHappyFlow=Wizard1Object.orderHappyFlowResponse();
        Wizard1Object.waiting();
        Wizard1Object.clcikOnPostPayment();
        Wizard1Object.waiting();


        Wizard1Object.clickHamburger();
        Wizard1Object.waiting();
        Wizard1Object.ClickLogout(stagelogout);
        Wizard1Object.waiting();
        Assert.assertEquals(ActualreponseforHappyFlow,expectedForHappyFlowForOrder);



    }

@Test

    public void inValidEmail() throws InterruptedException {

        Wizard1Object.openLandingpage(urlForQa1);
        Wizard1Object.waiting();
        Wizard1Object.goToUnitSelectionPage();
        Wizard1Object.waiting();
        Wizard1Object.gotopromotionpage();
        Wizard1Object.waiting();
        Wizard1Object.gotoStep1();
        Wizard1Object.waiting();
        Wizard1Object.selectStais(stairsNumber);
        Wizard1Object.selectPacking(packingNumber);
        System.out.print("This is my month\n"+currentMonth()+"\n0"+currentMonth());
        System.out.print("This is my year\n"+currentYear());
        Wizard1Object.selectAddress(startAddress,addressList);
        Wizard1Object.waiting();
        Wizard1Object.selectDate(month,year,date,monthName);
        Wizard1Object.waiting();

        Wizard1Object.gotoStep2();
        Wizard1Object.waiting();

    Wizard1Object.step2DataEnteringForVlaidData(name,invalidEmail,phoenNumber);
    Wizard1Object.waiting();
   actualForInvalidEmail= Wizard1Object.responseOfInvalidEmail();
    Assert.assertEquals(actualForInvalidEmail,expectedForInvalidEmaail);



    }

    @Test
    public void timeSlotsAvaialble() throws InterruptedException {

        Wizard1Object.openLandingpage(urlForQa1);
        Wizard1Object.waiting();
        Wizard1Object.goToUnitSelectionPage();
        Wizard1Object.waiting();
        Wizard1Object.gotopromotionpage();
        Wizard1Object.waiting();
        Wizard1Object.gotoStep1();
        Wizard1Object.waiting();
        Wizard1Object.selectStais(stairsNumber);
        Wizard1Object.selectPacking(packingNumber);
        System.out.print("This is my month\n"+currentMonth()+"\n0"+currentMonth());
        System.out.print("This is my year\n"+currentYear());
        Wizard1Object.selectAddress(startAddress,addressList);
        Wizard1Object.waiting();
        Wizard1Object.selectDate(month,year,date,monthName);
        Wizard1Object.waiting();
        Wizard1Object.ClickOnTimeSlotsUnavailable();
        Wizard1Object.waiting();
//        email="Test"+randomNumber()+"@bystored.com";
//        System.out.print("\n"+email);
        Wizard1Object.fillDataForAddressAvailability(name,EmailGeneration(),phoenNumber,message);
        Wizard1Object.waiting();
        Wizard1Object.submitButtonForAddressAvailabilityButton();

       actualForAddress= Wizard1Object.responseOfAddressUnavailable();

        Assert.assertEquals(actualForAddress,expectedForAddress);

    }


    @Test
    public void alreadyExistingOrder() throws InterruptedException
    {

        Wizard1Object.openLandingpage(urlForQa1);
        Wizard1Object.waiting();
        Wizard1Object.goToUnitSelectionPage();
        Wizard1Object.waiting();
        Wizard1Object.gotopromotionpage();
        Wizard1Object.waiting();
        Wizard1Object.gotoStep1();
        Wizard1Object.waiting();
        Wizard1Object.selectStais(stairsNumber);
        Wizard1Object.selectPacking(packingNumber);
        System.out.print("This is my month\n"+currentMonth()+"\n0"+currentMonth());
        System.out.print("This is my year\n"+currentYear());
        Wizard1Object.selectAddress(startAddress,addressList);
        Wizard1Object.waiting();
        Wizard1Object.selectDate(month,year,date,monthName);
        Wizard1Object.waiting();

        Wizard1Object.gotoStep2();
        Wizard1Object.waiting();
//        email="Test"+randomNumber()+"@bystored.com";
//        System.out.print("\n"+email);
        email=EmailGeneration();
        Wizard1Object.step2DataEnteringForVlaidData(name,EmailGeneration(),phoenNumber);
        Wizard1Object.waiting();
        Wizard1Object.goToStep3();
        Wizard1Object.step3DataEnteringForHappyFlow(nameOnCard,cardnumber,"0"+currentMonth(),cardyear,cardCvv);
        Wizard1Object.waiting();
        Wizard1Object.orderConfirmation();
        Wizard1Object.waiting();
//
//        ActualreponseforHappyFlow=Wizard1Object.orderHappyFlowResponse();
//        Assert.assertEquals(ActualreponseforHappyFlow,expectedForHappyFlowForOrder);





        Wizard1Object.openLandingpage(urlForQa1);
        Wizard1Object.waiting();
        Wizard1Object.goToUnitSelectionPage();
        Wizard1Object.waiting();
        Wizard1Object.gotopromotionpage();
        Wizard1Object.waiting();
        Wizard1Object.gotoStep1();
        Wizard1Object.waiting();
        Wizard1Object.selectStais(stairsNumber);
        Wizard1Object.selectPacking(packingNumber);
        System.out.print("This is my month\n"+currentMonth()+"\n0"+currentMonth());
        System.out.print("This is my year\n"+currentYear());
        Wizard1Object.selectAddress(startAddress,addressList);
        Wizard1Object.waiting();
        Wizard1Object.selectDate(month,year,date,monthName);
        Wizard1Object.waiting();

        Wizard1Object.gotoStep2();
       // Wizard1Object.waiting();
//        email="Test"+randomNumber()+"@bystored.com";
//        System.out.print("\n"+email);
//        email=EmailGeneration();
//        Wizard1Object.step2DataEnteringForVlaidData(name,email,phoenNumber);
        Wizard1Object.waiting();
        Wizard1Object.goToStep3();
//        Wizard1Object.step3DataEnteringForHappyFlow(nameOnCard,cardnumber,"0"+currentMonth(),cardyear,cardCvv);
//        Wizard1Object.orderConfirmation();
        Wizard1Object.waiting();
        Wizard1Object.termsOfAggrement();
        Wizard1Object.waiting();
       actualForAlreadyExistOrder = Wizard1Object.orderFlowExistingOrderResponse();
        Wizard1Object.waiting();
        Wizard1Object.clickHamburger();
        Wizard1Object.waiting();
        Wizard1Object.ClickLogout(stagelogout);
        Wizard1Object.waiting();
//
//        ActualreponseforHappyFlow=Wizard1Object.orderHappyFlowResponse();
//        Assert.assertEquals(ActualreponseforHappyFlow,expectedForHappyFlowForOrder);

        Assert.assertEquals(actualForAlreadyExistOrder,expectedForAlreadyExistOrder);



    }

    @Test
    public void invalidNumber() throws InterruptedException
    {


        Wizard1Object.openLandingpage(urlForQa1);
        Wizard1Object.waiting();
        Wizard1Object.goToUnitSelectionPage();
        Wizard1Object.waiting();
        Wizard1Object.gotopromotionpage();
        Wizard1Object.waiting();
        Wizard1Object.gotoStep1();
        Wizard1Object.waiting();
        Wizard1Object.selectStais(stairsNumber);
        Wizard1Object.selectPacking(packingNumber);
        System.out.print("This is my month\n"+currentMonth()+"\n0"+currentMonth());
        System.out.print("This is my year\n"+currentYear());
        Wizard1Object.selectAddress(startAddress,addressList);
        Wizard1Object.waiting();
        Wizard1Object.selectDate(month,year,date+1,monthName);
        Wizard1Object.waiting();

        Wizard1Object.gotoStep2();
        Wizard1Object.waiting();

        Wizard1Object.step2DataEnteringForInvalidPhonenUmber(EmailGeneration(),invalidPhoneNumber);
//        Wizard1Object.waiting();
//        Wizard1Object.clickOnArea();
        Wizard1Object.waiting();
        actualForInvalidPhoneNumber= Wizard1Object.responseOfInvalidPhoenNumber();

        Assert.assertEquals(actualForInvalidPhoneNumber,expectedForInvalidNumber);



    }


    @Test
    public void invalidAddress() throws InterruptedException {
        Wizard1Object.openLandingpage(urlForQa1);
        Wizard1Object.waiting();
        Wizard1Object.goToUnitSelectionPage();
        Wizard1Object.waiting();
        Wizard1Object.gotopromotionpage();
        Wizard1Object.waiting();
        Wizard1Object.gotoStep1();
        Wizard1Object.waiting();
        Wizard1Object.selectStais(stairsNumber);
        Wizard1Object.selectPacking(packingNumber);
        System.out.print("This is my month\n"+currentMonth()+"\n0"+currentMonth());
        System.out.print("This is my year\n"+currentYear());
        Wizard1Object.selectAddressForInvalidAddress(invalidAdddress,addressList);
        Wizard1Object.waiting();
        Wizard1Object.invalidaddressFormLink();
        Wizard1Object.waiting();
        Wizard1Object.enterDataForAddressUnavailable(EmailGeneration(),startAddress,phoenNumber);
        Wizard1Object.waiting();
        Wizard1Object.submitOnAddressUnavailable();
        Wizard1Object.waiting();
        responseOFInvalidAddressForm=Wizard1Object.successOfInvalidAddress();
        Assert.assertEquals(responseOFInvalidAddressForm,ExpectedForInvalidAddress);




    }




    @Test
    public void bookingWithValidDiscountCode() throws InterruptedException {
        Wizard1Object.openLandingpage(urlForQa1);
        Wizard1Object.waiting();
        Wizard1Object.goToUnitSelectionPage();
        Wizard1Object.waiting();
        Wizard1Object.gotopromotionpage();
        Wizard1Object.waiting();
        Wizard1Object.gotoStep1();
        Wizard1Object.waiting();
        Wizard1Object.selectStais(stairsNumber);
        Wizard1Object.selectPacking(packingNumber);
        System.out.print("This is my month\n"+currentMonth()+"\n0"+currentMonth());
        System.out.print("This is my year\n"+currentYear());
        Wizard1Object.selectAddress(startAddress,addressList);
        Wizard1Object.waiting();
        Wizard1Object.selectDate(month,year,date,monthName);
        Wizard1Object.waiting();

        Wizard1Object.gotoStep2();
        Wizard1Object.waiting();
//        email="Test"+randomNumber()+"@bystored.com";
//        System.out.print("\n"+email);
        email=EmailGeneration();
        Wizard1Object.step2DataEnteringForVlaidData(name,email,phoenNumber);
        Wizard1Object.waiting();
        Wizard1Object.goToStep3();
        Wizard1Object.waiting();
        Wizard1Object.step3DataEnteringForHappyFlow(nameOnCard,cardnumber,"0"+currentMonth(),cardyear,cardCvv);
        Wizard1Object.waiting();
        Wizard1Object.DcFiledClick(discountCode);
        Wizard1Object.waiting();
        responseOfDcValid=Wizard1Object.getSuccessmessageForValidDc();
        Wizard1Object.waiting();
        Wizard1Object.orderConfirmation();
        Wizard1Object.waiting();

        ActualreponseforHappyFlow=Wizard1Object.orderHappyFlowResponse();
        Wizard1Object.waiting();
        Wizard1Object.clcikOnPostPayment();
        Wizard1Object.waiting();

        Wizard1Object.clickHamburger();
        Wizard1Object.waiting();
        Wizard1Object.ClickLogout(stagelogout);
        Wizard1Object.waiting();
        Assert.assertEquals(responseOfDcValid,ExpectedreponseOfDcValid);


    }

    @Test
    public void bookingWithInvalidDc() throws InterruptedException
    {
        Wizard1Object.openLandingpage(urlForQa1);
        Wizard1Object.waiting();
        Wizard1Object.goToUnitSelectionPage();
        Wizard1Object.waiting();
        Wizard1Object.gotopromotionpage();
        Wizard1Object.waiting();
        Wizard1Object.gotoStep1();
        Wizard1Object.waiting();
        Wizard1Object.selectStais(stairsNumber);
        Wizard1Object.selectPacking(packingNumber);
        System.out.print("This is my month\n"+currentMonth()+"\n0"+currentMonth());
        System.out.print("This is my year\n"+currentYear());
        Wizard1Object.selectAddress(startAddress,addressList);
        Wizard1Object.waiting();
        Wizard1Object.selectDate(month,year,date,monthName);
        Wizard1Object.waiting();

        Wizard1Object.gotoStep2();
        Wizard1Object.waiting();
//        email="Test"+randomNumber()+"@bystored.com";
//        System.out.print("\n"+email);
        email=EmailGeneration();
        Wizard1Object.step2DataEnteringForVlaidData(name,email,phoenNumber);
        Wizard1Object.waiting();
        Wizard1Object.goToStep3();
        Wizard1Object.waiting();
        Wizard1Object.step3DataEnteringForHappyFlow(nameOnCard,cardnumber,"0"+currentMonth(),cardyear,cardCvv);
        Wizard1Object.waiting();
        Wizard1Object.DcFiledClick(InvalidDiscountCode);
        Wizard1Object.waiting();
        responseOfDcInValid=Wizard1Object.getErrorMsgOnInvalidDc();
        Wizard1Object.waiting();
        Wizard1Object.orderConfirmation();
        Wizard1Object.waiting();

        ActualreponseforHappyFlow=Wizard1Object.orderHappyFlowResponse();
        Wizard1Object.waiting();
        Wizard1Object.clcikOnPostPayment();
        Wizard1Object.waiting();

        Wizard1Object.clickHamburger();
        Wizard1Object.waiting();
        Wizard1Object.ClickLogout(stagelogout);
        Wizard1Object.waiting();
        Assert.assertEquals(responseOfDcInValid,ExpectedreponseOfDcInValid);


    }

    @Test
    public void InvalidCardDetails() throws InterruptedException {

        Wizard1Object.openLandingpage(urlForQa1);
        Wizard1Object.waiting();
        Wizard1Object.goToUnitSelectionPage();
        Wizard1Object.waiting();
        Wizard1Object.gotopromotionpage();
        Wizard1Object.waiting();
        Wizard1Object.gotoStep1();
        Wizard1Object.waiting();
        Wizard1Object.selectStais(stairsNumber);
        Wizard1Object.selectPacking(packingNumber);
        System.out.print("This is my month\n"+currentMonth()+"\n0"+currentMonth());
        System.out.print("This is my year\n"+currentYear());
        Wizard1Object.selectAddress(startAddress,addressList);
        Wizard1Object.waiting();
        Wizard1Object.selectDate(month,year,date,monthName);
        Wizard1Object.waiting();

        Wizard1Object.gotoStep2();
        Wizard1Object.waiting();
//        email="Test"+randomNumber()+"@bystored.com";
//        System.out.print("\n"+email);
        email=EmailGeneration();
        Wizard1Object.step2DataEnteringForVlaidData(name,email,phoenNumber);
        Wizard1Object.waiting();
        Wizard1Object.goToStep3();
        Wizard1Object.waiting();

        Wizard1Object.step3InvalidData(nameOnCard,invalidCrad,"0"+currentMonth(),invalidCardYear,invalidCVV, discountCode);
        Wizard1Object.waiting();
        Wizard1Object.clcikOnTooltipOfCardStep();
        Wizard1Object.waiting();
        actualFORInvalidCrad=Wizard1Object.Invalid_Card_details();
        System.out.print("\n"+actualFORInvalidCrad+"\n"+expectedForInvalidCARD);
        Wizard1Object.waiting();

        Wizard1Object.clickHamburger();
        Wizard1Object.waiting();
        Wizard1Object.LogoutForInvalidCard();
        Wizard1Object.waiting();
        Assert.assertEquals(actualFORInvalidCrad,expectedForInvalidCARD);

//        Wizard1Object.orderConfirmation();
//        Wizard1Object.waiting();

//        ActualreponseforHappyFlow=Wizard1Object.orderHappyFlowResponse();
//        Wizard1Object.waiting();
//        Wizard1Object.clcikOnPostPayment();
//        Wizard1Object.waiting();
//
//        Wizard1Object.clickHamburger();
//        Wizard1Object.waiting();
//        Wizard1Object.ClickLogout();
//        Wizard1Object.waiting();
//        Assert.assertEquals(ActualreponseforHappyFlow,expectedForHappyFlowForOrder);
//       actualForStairInfo= Wizard1Object.responseOfStairsInfo(email);
//        System.out.print(actualForStairInfo);

    }
}

//
//    public void ValidationForCardNumber() throws SQLException {
//        DBConnection.connectDb();
//    }


