package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by VenD on 11/7/2018.
 */
public class FaqsPageObjects {

    WebDriver driver;
    WebDriverWait wait;
    public static By contactUsButton=By.xpath("/html/body/header[2]/div/div/div/div/a");
    public static By contactUsNameField=By.className("h1");
    public static String responseOfContactUsButton;
    public static By LeftSection=By.className("faqs-section-nav");
    public static By scrollButton=By.className("scroll-top");
    public static String contcatUsText;
    public static By Search=By.id("searchQuery");
    public static By searchNotFound=By.className("not-found");
    public static String searchText;
    public static String actualText="Hmm, we can't find that one. Give the team a call on 020 3637 1234 and they'll be happy to answer any of your questions.";
    public static String a="Frequently Asked Questions";
    int j=0;
    public int returnValues[];

    public FaqsPageObjects(WebDriver driver, WebDriverWait wait)
    {
        this.driver=driver;
        this.wait=wait;
    }

    public void Sleep() throws InterruptedException
    {
        Thread.sleep(2000);

    }

    public void SleepForLeftSide()  throws InterruptedException
    {
        Thread.sleep(1000);
    }
    public void openFaqsPage(String url)
    {


        driver.navigate().to(url+"faqs");
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactUsButton));
        driver.manage().window().maximize();

    }

    public String contactUsButtonClick()
    {
        driver.findElement(contactUsButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactUsNameField));
        responseOfContactUsButton=driver.findElement(contactUsNameField).getText();
        System.out.print(responseOfContactUsButton);
        driver.navigate().back();
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactUsButton));
        return responseOfContactUsButton;


    }

    public int[] leftSection() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(LeftSection));
//        List<WebElement> allElements = driver.findElements(LeftSection);
//        System.out.println(allElements);
//
//        for (WebElement element : allElements) {
//            System.out.println(element.getText());
//            element.findElement(By.tagName("li")).click();
//            wait.until(ExpectedConditions.visibilityOfAllElements( element.findElement(By.tagName("li"))));
//
//
//
//        }
//
//        List<WebElement> liElements = driver.findElements(LeftSection);
//        System.out.println(liElements.size());
//       // System.out.println(liElements);
//
//        System.out.println(Error).getText();
//
//
//        for(int i=1; i <= liElements.size(); i++)
//        {
//            WebElement linkElement = driver.findElement(By.xpath("/html/body/section/div/div[2]/div[1]/ul/li[3]"));
//            System.out.println(linkElement.getText());
//            driver.findElement(By.xpath("/html/body/section/div/div[2]/div[1]/ul/li[3]")).click();
//
//        }


        WebElement allFaqs = driver.findElement(By.xpath("/html/body/section/div/div[2]/div[1]/ul"));
        System.out.println(allFaqs);
//       // System.out.println(liElements);
        List<WebElement> links = allFaqs.findElements(By.tagName("li"));
        System.out.println(links.size());
        int alllinks=links.size();
        System.out.print(links);

        for (int i = 0; i < alllinks; i++)
        {
            System.out.println(links.get(i).getText());

           // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/div/div[2]/div[1]/ul/li["+(i+1)+"]/a")));
//            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("html/body/section/div/div[2]/div[1]/ul/li["+(i+1)+"]/a"))));

            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/div/div[2]/div[1]/ul/li["+(i+1)+"]/a")));
           // Thread.sleep(3000);
            //wait.until(ExpectedConditions.textToBePresentInElement(By.xpath("/html/body/section/div/div[2]/div[1]/ul/li[\"+(i+1)+\"]/a"),links.get(i).getText()));

            //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/div/div[2]/div[1]/ul/li[2]")));

//           Thread.sleep(3000);

                SleepForLeftSide();

            try {
                driver.findElement(By.xpath("/html/body/section/div/div[2]/div[1]/ul/li["+(i+1)+"]/a")).click();
                Sleep();

                System.out.println(i + ": Done");
                j=j+1;

                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(LeftSection));

                  //  SleepForLeftSide();


            }
            catch (Exception e)
            {
                System.out.println(i + ": Failed");
                e.printStackTrace();

            }

            Sleep();

        }
        System.out.print(j);

        returnValues = new int[]{j, alllinks};
        return returnValues;
    }


    public boolean ScrollUp()
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(scrollButton));
        wait.until(ExpectedConditions.visibilityOfElementLocated(scrollButton));
        driver.findElement(scrollButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/header[2]/div/div/div/h1")));
        contcatUsText=driver.findElement(By.xpath("/html/body/header[2]/div/div/div/h1")).getText();

        System.out.print(contcatUsText);
        if (contcatUsText.equals(a))
        {
            return true;
        }

        else
            return false;

    }


    public int SeacrhFunctionality(String text)
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(Search));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Search));
        driver.findElement(Search).sendKeys(text);
       searchText= driver.findElement(searchNotFound).getText();
        System.out.print(searchText);
        if(searchText.equals(actualText))
        {
            return 0;
        }

        else return 1;

    }



}
