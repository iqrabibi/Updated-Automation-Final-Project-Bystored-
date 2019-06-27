package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by VenD on 6/19/2019.
 */
public class GuidesPageObjects  {
    WebDriver driver;
    WebDriverWait wait;
    public static By guidesHeading=By.className("bottom-line");
    public static By guidesList=By.cssSelector("body > div.container > section.filters > div > div > ul");
    public static int totalClick=0;
    public GuidesPageObjects(WebDriver driver,WebDriverWait wait)
    {
        this.driver=driver;
        this.wait=wait;
    }
    public void waiting() throws InterruptedException {
        Thread.sleep(2000);
    }

    public  void openGuidesPage(String url)
    {

        driver.navigate().to(url+"guides?v=8");
        driver.manage().window().maximize();
        wait.until(ExpectedConditions.visibilityOfElementLocated(guidesHeading));
    }

    public int getAllTheGuidesAndClick() throws InterruptedException {

        WebElement ElementOfListItem = driver.findElement(guidesList);
        List<WebElement> listInfo = ElementOfListItem.findElements(By.tagName("li"));
        waiting();
        System.out.print(listInfo.size());

        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.className("container")) );


        for (WebElement ListOption : listInfo) {
//            System.out.print("\n" + ListOption.getText() + "\n" +
//                    "");
//            if (ListOption.getText().equals("NORTH")) {
//
//
//                continue;
//            } else {
                System.out.print("\n" + ListOption.getText() + "\n");
            //Thread.sleep(5000);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.className("bottom-line")));

            ListOption.click();
//
                totalClick = totalClick + 1;

                waiting();
//            Thread.sleep(5000);

               // break;

        }
        return totalClick;

    }
}
