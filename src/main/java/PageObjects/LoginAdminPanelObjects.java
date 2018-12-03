package PageObjects;

import org.omg.IOP.ExceptionDetailMessage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by VenD on 11/22/2018.
 */
public class LoginAdminPanelObjects {


    public static By byEmail = By.id("email");
    public static By byPassword = By.id("password");
    public static By byLoginButton = By.cssSelector("#page-content > div > div:nth-child(3) > form > div:nth-child(2) > div > button > div > div > span");
    public static By byLogoutButton = By.xpath("//*[@id=\"reactAdmin\"]/div/div[3]/header/div[2]/div/button/div/span");
    public static boolean actual;
    public static By loginText=By.className("form-bg");
    public static By afterLoginText=By.id("page-content");
    public static By invalidText=By.xpath("//*[@id=\"page-content\"]/div/div[4]/div/div");
    public static Boolean invalidActual;

    WebDriver driver;
    WebDriverWait wait;

    public LoginAdminPanelObjects(WebDriver driver, WebDriverWait wait)
    {
        this.driver = driver;
        this.wait=wait;

    }
    public void Sleep() throws InterruptedException
    {
        Thread.sleep(2000);

    }
    public void refrech()
    {
        driver.navigate().refresh();
    }
    public void openAdminPanelLoginPage(String url) {


        driver.navigate().to(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginText));
        driver.manage().window().maximize();

    }


    public void enterLoginCredentials(String userName, String passWord)  {
        //System.out.println(""+userName+""+passWord);
        driver.findElement(byEmail).sendKeys(userName);
        driver.findElement(byPassword).sendKeys(passWord);
    }


    public void clickLogin() {
        driver.findElement(byLoginButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(afterLoginText));

    }
    public boolean SuccessfulSubmit()
    {

        actual= driver.findElement(afterLoginText).isDisplayed();
        return actual;

    }
    public void clickLogoutButton()

    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byLogoutButton));
        driver.findElement(byLogoutButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginText));
    }

    public boolean clickSubmitForInvalid()
    {
        driver.findElement(byLoginButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(invalidText));
       invalidActual= driver.findElement(invalidText).isDisplayed();

        return invalidActual;

    }



}
