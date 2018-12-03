package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static General.InitMethods.adminPanelQa1URL;
import static General.InitMethods.login_Admin_Panel_Object;

/**
 * Created by VenD on 11/22/2018.
 */
public class WareHouseObject {


    public static By byHamburger = By.cssSelector("#reactAdmin > div > div:nth-child(3) > header > div.background > button");
    public static By byWarehouseManagement = By.cssSelector("#reactAdmin > div > div:nth-child(3) > header > div:nth-child(1) > div:nth-child(2) > div:nth-child(12) > a > div > div");
    public static By byWarehouses = By.cssSelector("#page-content > div > div:nth-child(3) > div > div:nth-child(2)");
    public static By byAddWarehouse = By.cssSelector("#page-content > div > div:nth-child(2) > div > div > button");
    public static By byDisplayname = By.name("displayName");
    public static By byWarehouseID = By.name("warehouseIdentifier");
    public static By byWarehouseAddress = By.name("warehouseAddress");
    public static By byWarehouseParking = By.name("parkingAddress");
    public static By bydefault = By.cssSelector("body > div:nth-child(6) > div > div:nth-child(1) > div > div > div:nth-child(2) > div > div:nth-child(1) > div:nth-child(9) > input[type=\"checkbox\"]");
    public static By byassetStore = By.cssSelector("body > div:nth-child(6) > div > div:nth-child(1) > div > div > div:nth-child(2) > div > div:nth-child(1) > div:nth-child(11) > input[type=\"checkbox\"]");
    public static By bysubmit = By.cssSelector("body > div:nth-child(6) > div > div:nth-child(1) > div > div > div:nth-child(2) > div > div.theme-btn > button");
    public static By byassetStoreEdit = By.cssSelector("body > div:nth-child(7) > div > div:nth-child(1) > div > div > div:nth-child(2) > div > div:nth-child(1) > div:nth-child(9) > input[type=\"checkbox\"]");
    public static By bydefaultEdit = By.cssSelector("body > div:nth-child(7) > div > div:nth-child(1) > div > div > div:nth-child(2) > div > div:nth-child(1) > div:nth-child(11) > input[type=\"checkbox\"]");
    public static By bysubmitEdit =  By.cssSelector("body > div:nth-child(7) > div > div:nth-child(1) > div > div > div:nth-child(2) > div > div.theme-btn > button");
    public static By hamburgerOptions=By.xpath("//*[@id=\"reactAdmin\"]/div/div[3]/header/div[1]/div[2]");
    WebDriver driver;
    WebDriverWait wait;
    public static String email;
    public static String password;
    public static By addingRoomWait=By.className("mandatory-field-indicator");
    public static By successOfAddingRooms=By.className("notification-title");
    public static String responseOfAddingRooms;


    public WareHouseObject(WebDriver driver, WebDriverWait wait)
    {

        this.driver = driver;
        this.wait=wait;

    }
    public void Sleep() throws InterruptedException {
        Thread.sleep(5000);
    }

    public void clickHamburger() throws InterruptedException {

        driver.findElement(byHamburger).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(hamburgerOptions));
    }
    public void clickWarehouse()
    {
        driver.findElement(byWarehouseManagement).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(byWarehouses));
    }
    public void warehouses()
    {

        driver.findElement(byWarehouses).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(byAddWarehouse));
    }

    public void addWarehouse()
    {
        driver.findElement(byAddWarehouse).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(addingRoomWait));

    }

    public void warehouseInfo(String name,String Id,String address,String parking)
    {
        driver.findElement(byDisplayname).sendKeys(name);
        driver.findElement(byWarehouseID).sendKeys(Id);
        driver.findElement(byWarehouseAddress).sendKeys(address);
        driver.findElement(byWarehouseParking).sendKeys(parking);
    }

    public void checkboxDefault()
    {
        driver.findElement(bydefault).click();
    }

    public void assetStore()
    {
        driver.findElement(byassetStore).click();}

    public void submit()
    {
        driver.findElement(bysubmit).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(successOfAddingRooms));
    }

    public void edit()
    {
        WebElement mySelectElement = driver.findElements(By.className("theme-btn")).get(1);
        Actions action = new Actions(driver);
        action.click(mySelectElement).build().perform();
    }

    public void warehouseInfoEdit (String nameEdit,String addressEdit,String parkingEdit)
    {
        driver.findElement(byDisplayname).clear();
        driver.findElement(byDisplayname).sendKeys(nameEdit);
        driver.findElement(byWarehouseAddress).clear();
        driver.findElement(byWarehouseAddress).sendKeys(addressEdit);
        driver.findElement(byWarehouseParking).clear();
        driver.findElement(byWarehouseParking).sendKeys(parkingEdit);
    }

    public void checkboxDefaultEdit()
    {
        driver.findElement(bydefaultEdit).click();
    }

    public void assetStoreEdit()
    {
        driver.findElement(byassetStoreEdit).click();}

    public void submitEdit()
    {
        driver.findElement(bysubmitEdit).click();
    }

    public void delete()
    {
        WebElement mySelectElement = driver.findElements(By.className("theme-delete-btn")).get(0);
        Actions action = new Actions(driver);
        action.click(mySelectElement).build().perform();
    }
    public void yesNo()
    {
        WebElement mySelectElement = driver.findElements(By.cssSelector("body > div:nth-child(8) > div > div:nth-child(1) > div > div > div:nth-child(3) > button:nth-child(1)")).get(0);
        Actions action = new Actions(driver);
        action.click(mySelectElement).build().perform();
    }
    public String  applyassertionSubmit ()  {
        responseOfAddingRooms= driver.findElement(successOfAddingRooms).getText();


        return responseOfAddingRooms;

        //  System.out.println("Actual Result : "+ actualMessage + "Expected Result : "+ message);
    }

    public void openLoginPage(String email, String password) throws InterruptedException {


        login_Admin_Panel_Object.openAdminPanelLoginPage(adminPanelQa1URL);
        login_Admin_Panel_Object.enterLoginCredentials(email,password);
        login_Admin_Panel_Object.clickLogin();



    }

}
