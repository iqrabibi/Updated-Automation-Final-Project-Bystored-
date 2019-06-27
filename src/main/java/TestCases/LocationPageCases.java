package TestCases;

import General.Main;
import org.testng.Assert;
import org.testng.annotations.Test;

import static General.InitMethods.Url;
import static General.InitMethods.locationObject;
import static General.InitMethods.urlForQa1;

/**
 * Created by VenD on 6/17/2019.
 */
public class LocationPageCases extends Main {
    public int reponseOfLOcationClick;
    public int ExpectedresponseOfLocationClick=7;
    public String searchText="Hoxton";
    public String searchInvalidText="iqraBibi";
    public Boolean responseOfValidSearch;
    public Boolean ExpectedForValidSearch=true;
    public Boolean ExpectedForInvalidSearch=false;
    public Boolean responsseOfCTA;
    public Boolean ExpectedresponseOfCTA=true;


    @Test
    public void ClickOnEachCategory() throws InterruptedException {
        locationObject.openLocationPage(urlForQa1);
        locationObject.waiting();
        locationObject.movePageToList();
        locationObject.waiting();
       reponseOfLOcationClick= locationObject.getAllTheFiledsAndClick();
        locationObject.waiting();
        Assert.assertEquals(reponseOfLOcationClick,ExpectedresponseOfLocationClick);
    }
    @Test
    public void searchForValidData() throws InterruptedException {
        locationObject.openLocationPage(urlForQa1);
        locationObject.waiting();
        locationObject.searchOnlocation(searchText);
        locationObject.waiting();
        responseOfValidSearch=locationObject.searchResultForValid();
        Assert.assertEquals(responseOfValidSearch,ExpectedForValidSearch);

    }

    @Test
    public void searchForInValidData() throws InterruptedException {
        locationObject.openLocationPage(urlForQa1);
        locationObject.waiting();
        locationObject.searchOnlocation(searchInvalidText);
        locationObject.waiting();
        responseOfValidSearch=locationObject.searchResultForInvalid();
        Assert.assertEquals(responseOfValidSearch,ExpectedForValidSearch);

    }
    @Test
    public void bookingCTA() throws InterruptedException {
        locationObject.openLocationPage(urlForQa1);
        locationObject.waiting();

        responsseOfCTA=locationObject.ClickOnCta();
        Assert.assertEquals(responsseOfCTA,ExpectedresponseOfCTA);


    }

}

