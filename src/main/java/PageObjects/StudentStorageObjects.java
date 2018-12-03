package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by VenD on 11/26/2018.
 */
public class StudentStorageObjects {
    WebDriverWait wait;
    WebDriver driver;
    public static By pricingText= By.id("find-my-unit-storage");
    public static By belowGetStarted=By.id("btn-add-477");
    public static By onePersonItem=By.id("btn-add-478");
    public static By onepersonDelete=By.id("btn-remove-478");
    //public static By gettex=By.className("price-less-than");
    public static By firstprice=By.xpath("//*[@id=\"detail-area-12\"]/div/div[2]/div/div/div[1]/div/span[2]");

    public static By secondPrice=By.xpath("//*[@id=\"detail-area-25\"]/div/div[2]/div/div/div[1]/div/span[2]");
    public static By thirdPrice=By.xpath("//*[@id=\"detail-area-50\"]/div/div[2]/div/div/div[1]/div/span[2]");

    public static By forthprice=By.xpath("//*[@id=\"detail-area-75\"]/div/div[2]/div/div/div[1]/div/span[2]");
    public static By forFifthPrice=By.xpath("//*[@id=\"detail-area-100\"]/div/div[2]/div/div/div[1]/div/span[2]");

    public static By cratesdelete=By.id("btn-remove-477");
    public static By startStroing=By.className("start-storing-head");
    public static String res;
    public static By twoPersonAdd=By.id("btn-add-479");
    public static By twoPersonDelete=By.id("btn-remove-479");
    public static By checkAvailability=By.className("availability-button");


     By allPricesText[]={firstprice,secondPrice,thirdPrice,forthprice,forFifthPrice};
    By allPricesTextForCrates[]={firstprice,secondPrice,thirdPrice,thirdPrice};

    public static String result;
    public static String allPrices[]={"69.00","119.00","199.00","289.00","379.00"};
    public static String allPricesForCrates[]={"69.00","119.00","199.00","199.00"};
    int i=0;
    int m=0;
    int n=0;
    int o=0;
    int p=0;
    int q=0;
    int r=0;
    public static String response;
    public static By universityButton=By.className("green-btn");
    public static By universityPageText=By.linkText("Student Storage easy!");
    public StudentStorageObjects(WebDriver driver,WebDriverWait wait)

    {
        this.driver=driver;
        this.wait=wait;
    }

    public void Sleep() throws InterruptedException
    {
        Thread.sleep(2000);

    }



    public void openStudentStoragePage(String url)
    {

        driver.navigate().to(url+"student-storage");
        wait.until(ExpectedConditions.visibilityOfElementLocated(pricingText));
        driver.manage().window().maximize();

    }

    public int openGetStarted()
    {
        driver.findElement(pricingText).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(belowGetStarted));
        if(driver.findElement(belowGetStarted).isDisplayed())
        {
            i=i+1;
        }
        return i;

    }

    public void onepersonItem(int requiredNumber,int value)
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(onePersonItem));
        System.out.print("\n"+requiredNumber+"\n"+value);
        for(int j=0;j<requiredNumber;j++)
        {
            driver.findElement(onePersonItem).click();
        }
        result=driver.findElement(allPricesText[value]).getText();

        System.out.print("\n"+result);
        if(result.equals(allPrices[value]))
        {
            m=m+1;

        }
        System.out.print("\n"+m);
    }
    public int finalForOnePersonItemsAddition()
    {
      return m;
    }

    public void onepersonItemSubstraction(int requiredNumber,int value)
    {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(onePersonItem));

        System.out.print("\n"+requiredNumber+"\n"+value);
        result=driver.findElement(allPricesText[value-1]).getText();
        for(int j=requiredNumber;j>0;j--)
        {
            driver.findElement(onepersonDelete).click();
        }


        System.out.print("\n"+result);
        if(result.equals(allPrices[value-1]))
        {
            n=n+1;

        }
        System.out.print("\n"+n);
    }
    public int finalForOnePersonItemsSubstraction()
    {
        return n;
    }














    public void CratesAddition(int requiredNumber,int value)
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(belowGetStarted));
        System.out.print("\n"+requiredNumber+"\n"+value);
        for(int j=0;j<requiredNumber;j++)
        {
            driver.findElement(belowGetStarted).click();
        }
        result=driver.findElement(allPricesTextForCrates[value]).getText();

        System.out.print("\n"+result);
        if(result.equals(allPricesForCrates[value]))
        {
            o=o+1;

        }
        System.out.print("\n"+o);
    }
    public int finalForCratesAddition()
    {
        return o;
    }

    public void CratesSubstraction(int requiredNumber,int value)
    {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(belowGetStarted));

        System.out.print("\n"+requiredNumber+"\n"+value);
        result=driver.findElement(allPricesTextForCrates[value-1]).getText();
        for(int j=requiredNumber;j>0;j--)
        {
            driver.findElement(cratesdelete).click();
        }


        System.out.print("\n"+result);
        if(result.equals(allPricesForCrates[value-1]))
        {
            p=p+1;

        }
        System.out.print("\n"+p);
    }
    public int finalForCratesSubstraction()
    {
        return p;
    }
















    public void twoPersonItemAddition(int requiredNumber,int value)
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(twoPersonAdd));
        System.out.print("\n"+requiredNumber+"\n"+value);
        for(int j=0;j<requiredNumber;j++)
        {
            driver.findElement(twoPersonAdd).click();
        }
        result=driver.findElement(allPricesText[value]).getText();

        System.out.print("\n"+result);
        if(result.equals(allPrices[value]))
        {
            r=r+1;

        }
        System.out.print("\n"+r);
    }
    public int finalForTwoPersonAddition()
    {
        return r;
    }

    public void TwoPersonSubstraction(int requiredNumber,int value)
    {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(twoPersonAdd));

        System.out.print("\n"+requiredNumber+"\n"+value);
        result=driver.findElement(allPricesText[value-1]).getText();
        for(int j=requiredNumber;j>0;j--)
        {
            driver.findElement(twoPersonDelete).click();
        }


        System.out.print("\n"+result);
        if(result.equals(allPrices[value-1]))
        {
            q=q+1;

        }
        System.out.print("\n"+q);
    }
    public int finalForTwoPersonSubstraction()
    {
        return q;
    }



    public String checkAvailability()
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(checkAvailability));
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkAvailability));
        driver.findElement(checkAvailability).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(startStroing));
        res=driver.findElement(startStroing).getText();
        driver.navigate().back();

        return res;
    }

    public String AllUniversities()
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(universityButton));
        wait.until(ExpectedConditions.visibilityOfElementLocated(universityButton));
        driver.findElement(universityButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(universityPageText));
        res=driver.findElement(universityButton).getText();
        driver.navigate().back();

        return res;
    }



}
