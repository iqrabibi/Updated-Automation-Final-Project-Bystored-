package PageObjects;

import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by VenD on 6/17/2019.
 */
public class LocationPageObject {
    WebDriver driver;
    WebDriverWait wait;
    public static int totalClick=0;

    public static By locationList=By.xpath("//*[@id=\"rootwizard\"]/div[1]/div/div/ul");
    public static By locationPageAfterOpen=By.id("find-my-unit-storage");
    public static By moveToList= By.id("rootwizard");
    public static By searchOnLocation=By.id("search-input");
    public static By searchResultForValidSearch=By.className("locations-result");
    public static Boolean responseForSearchSuccess;
    public static By afterBookingCtaText=By.className("hero-content");
    public static Boolean responseOfCta;


public LocationPageObject(WebDriver driver, WebDriverWait wait)
{

    this.driver=driver;
    this.wait=wait;
}
public void waiting() throws InterruptedException {
    Thread.sleep(2000);
}

public void openLocationPage(String url)
{


        driver.navigate().to(url+"locations");
        driver.manage().window().maximize();
        wait.until(ExpectedConditions.visibilityOfElementLocated(locationPageAfterOpen));

}
public void movePageToList()
{
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(moveToList) );
//    wait.until(ExpectedConditions.visibilityOfElementLocated(locationList));

}

public int getAllTheFiledsAndClick() throws InterruptedException
{
    WebElement ElementOfListItem = driver.findElement(locationList);
    List<WebElement> listInfo = ElementOfListItem.findElements(By.tagName("li"));
    waiting();
    System.out.print(listInfo.size());

    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.className("container")) );



    for(WebElement ListOption: listInfo) {
        System.out.print("\n" + ListOption.getText() + "\n" +
                "");
        if (ListOption.getText().equals("NORTH")) {


            continue;
        }
        else
        {
            System.out.print("\n" + ListOption.getText() + "\n");
            ListOption.click();
//                Thread.sleep(5000);
           totalClick= totalClick+1;
            waiting();
//            break;
        }
    }
    return totalClick;
}
public void searchOnlocation(String searchText)
{

    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(moveToList) );

    driver.findElement(searchOnLocation).sendKeys(searchText);

}
public Boolean searchResultForValid()
{
    responseForSearchSuccess=driver.findElement(searchResultForValidSearch).isDisplayed();

    return responseForSearchSuccess;
}
public Boolean searchResultForInvalid()
{
    responseForSearchSuccess=driver.findElement(searchResultForValidSearch).isDisplayed();

    return responseForSearchSuccess;
}
public Boolean ClickOnCta()
{
    driver.findElement(locationPageAfterOpen).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(afterBookingCtaText));
    responseOfCta=driver.findElement(afterBookingCtaText).isDisplayed();
    return responseOfCta;
}

}

