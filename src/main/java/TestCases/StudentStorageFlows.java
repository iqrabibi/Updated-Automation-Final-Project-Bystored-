package TestCases;

import General.Main;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.Test;

import static General.InitMethods.PricingObject;
import static General.InitMethods.StudentObject;
import static General.InitMethods.Url;

/**
 * Created by VenD on 11/26/2018.
 */
public class StudentStorageFlows extends Main {
    int actualForGreenButton;
    int expectedForGreenButton=1;
    int[] valuesForOnePerson={0,3,7,9,10};
    int[] valuesForCrates={0,9,21,20};
    int[] valueForTwoPerson={0,1,3,3,3};

    int actualForTwoPerson;
    int expectedForTwoPerson=valueForTwoPerson.length;
    int getActualForTwoPersonDelete;


    int actualForOnePerson;
    int expectedForOnePerson=valuesForOnePerson.length;
    int getActualForOnePersonDelete;
    int getExpectedForCrates=valuesForCrates.length;
    int actualForCratesAddition;
    int getActualForCratessubstraction;

    String actualForCheckAvailability;
    String expectedForCheckAvailability="Start Storing";

    String actualForUniversity;
    String expectedForUniversity="BOOK STUDENT STORAGE";

    @Test
    public void GreenButtonOnPricingPageFlow() throws InterruptedException {

        StudentObject.openStudentStoragePage(Url);
        actualForGreenButton=StudentObject.openGetStarted();
        StudentObject.Sleep();
        System.out.print("\n"+actualForGreenButton+"\n"+expectedForGreenButton);
        Assert.assertEquals(actualForGreenButton,expectedForGreenButton);

    }

    @Test
    public void calculatorFlowsWithAddition() throws InterruptedException {

        StudentObject.openStudentStoragePage(Url);
        for(int k=0;k<valuesForOnePerson.length;k++)
        {
            StudentObject.onepersonItem(valuesForOnePerson[k],k);
            StudentObject.Sleep();

        }
        actualForOnePerson=StudentObject.finalForOnePersonItemsAddition();
        StudentObject.Sleep();
        System.out.print("\n"+actualForOnePerson+"\n"+expectedForOnePerson);
        Assert.assertEquals(actualForOnePerson,expectedForOnePerson);

    }

    @Test
    public void calculatorFlowsWithSubstraction() throws InterruptedException {

        for(int k=valuesForOnePerson.length;k>0;k--)
        {
            StudentObject.onepersonItemSubstraction(valuesForOnePerson[k-1],k);
            StudentObject.Sleep();

        }
        getActualForOnePersonDelete=StudentObject.finalForOnePersonItemsSubstraction();
        System.out.print("\n"+getActualForOnePersonDelete+"\n"+expectedForOnePerson);
        Assert.assertEquals(getActualForOnePersonDelete,expectedForOnePerson);

    }

    @Test
    public void CratesAddition() throws InterruptedException {

        StudentObject.openStudentStoragePage(Url);
        for(int k=0;k<valuesForCrates.length;k++)
        {
            StudentObject.CratesAddition(valuesForCrates[k],k);
            StudentObject.Sleep();

        }
        actualForCratesAddition=StudentObject.finalForCratesAddition();
        StudentObject.Sleep();
        System.out.print("\n"+actualForCratesAddition+"\n"+getExpectedForCrates);
        Assert.assertEquals(actualForCratesAddition,getExpectedForCrates);

    }

    @Test
    public void CratesCalculatorSubstraction() throws InterruptedException {

        for(int k=valuesForCrates.length;k>0;k--)
        {
            StudentObject.CratesSubstraction(valuesForCrates[k-1],k);
            StudentObject.Sleep();

        }
        getActualForCratessubstraction=StudentObject.finalForCratesSubstraction();
        StudentObject.Sleep();
        System.out.print("\n"+getActualForCratessubstraction+"\n"+getExpectedForCrates);
        Assert.assertEquals(getActualForCratessubstraction,getExpectedForCrates);

    }



    @Test
    public void TwoPersonAddition() throws InterruptedException {

        StudentObject.openStudentStoragePage(Url);
        for(int k=0;k<valueForTwoPerson.length;k++)
        {
            StudentObject.twoPersonItemAddition(valueForTwoPerson[k],k);
            StudentObject.Sleep();

        }
        actualForTwoPerson=StudentObject.finalForTwoPersonAddition();
        StudentObject.Sleep();
        System.out.print("\n"+actualForTwoPerson+"\n"+expectedForTwoPerson);
        Assert.assertEquals(actualForTwoPerson,expectedForTwoPerson);

    }

    @Test
    public void TwoPersonSubstraction() throws InterruptedException {

        for(int k=valueForTwoPerson.length;k>0;k--)
        {
            StudentObject.TwoPersonSubstraction(valueForTwoPerson[k-1],k);
            StudentObject.Sleep();

        }
        getActualForTwoPersonDelete=StudentObject.finalForTwoPersonSubstraction();
        StudentObject.Sleep();
        System.out.print("\n"+getActualForTwoPersonDelete+"\n"+expectedForTwoPerson);
        Assert.assertEquals(getActualForTwoPersonDelete,expectedForTwoPerson);

    }

    @Test
    public void CheckAvailabilityFlow() throws InterruptedException {
        StudentObject.openStudentStoragePage(Url);
        actualForCheckAvailability=StudentObject.checkAvailability();
        StudentObject.Sleep();
        System.out.print("\n"+actualForCheckAvailability+"\n"+expectedForCheckAvailability);
        Assert.assertEquals(actualForCheckAvailability,expectedForCheckAvailability);

    }


    @Test
    public void AllUniversityFlow() throws InterruptedException {
        StudentObject.openStudentStoragePage(Url);
       actualForUniversity=StudentObject.AllUniversities();
        StudentObject.Sleep();
        System.out.print("\n"+actualForUniversity+"\n"+expectedForUniversity);
        Assert.assertEquals(actualForUniversity,expectedForUniversity);

    }





}
