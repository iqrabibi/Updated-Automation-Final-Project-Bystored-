package PageObjects;

import io.restassured.RestAssured;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by VenD on 11/7/2018.
 */
public class StatusCodeObjects {
    WebDriver driver;
    WebDriverWait wait;
    public int statusCode;

    public int returnValues[];
    int rowCount;

//    public String UrlOfPages[] = {"faqs", "pricing", "guides", "student-storage", "business", "login"};
//    public int totalUrls = UrlOfPages.length;


    public StatusCodeObjects(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }



    public int[] readExcel(String url,String filePath,String fileName,String sheetName) throws IOException {
         int j = 0;

        //String fileName = "DataFile.xlsx";
        //String filePath = "C://Users//VenD//automation//updated_project";
        //String sheetName = "name";
        //Create an object of File class to open xlsx file

        File file = new File(filePath+"//"+fileName);

        //Create an object of FileInputStream class to read excel file

        FileInputStream inputStream = new FileInputStream(file);

        Workbook guru99Workbook = null;

        //Find the file extension by splitting file name in substring  and getting only extension name

        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        //Check condition if the file is xlsx file

        if (fileExtensionName.equals(".xlsx")) {

            //If it is xlsx file then create object of XSSFWorkbook class

            guru99Workbook = new XSSFWorkbook(inputStream);

        }



        //Read sheet inside the workbook by its name

        Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);

        //Find number of rows in excel file

        rowCount  = guru99Sheet.getLastRowNum() - guru99Sheet.getFirstRowNum();
        System.out.print(rowCount+"\n");

        //Create a loop over all the rows of excel file to read it

        for (int i = 0; i < rowCount + 1; i++) {

            Row row = guru99Sheet.getRow(i);

            //Create a loop to print cell values in a row

            for (int k = 0; k < row.getLastCellNum(); k++) {

                //Print Excel data in console

                String endPoint=row.getCell(k).getStringCellValue();

                System.out.print(row.getCell(k).getStringCellValue() + "|| ");

                driver.navigate().to(url + "" + endPoint);
                if(i==0)
                {
                    driver.manage().window().maximize();
                }
                System.out.print("\n"+url + "" + endPoint+"\n");

                statusCode = RestAssured.get(url + "" + endPoint).statusCode();
                System.out.print("\n" +statusCode+"\n");

//                if(statusCode==200)
//                {
//                    j=j+1;
//                    System.out.print("\n"+j+"\n");
//                }


                if (statusCode != 200)

                {
                    driver.navigate().refresh();
                    statusCode = RestAssured.get(url + "" + endPoint).statusCode();
                    System.out.print("\nafter refreshing status code" +statusCode+"\n");
                    j = j + 1;
                }
                else
                {
                    j=j+1;
                }



            }




        }


        returnValues = new int[]{j, rowCount+1};
        return returnValues;
    }

}
