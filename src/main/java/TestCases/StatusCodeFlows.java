package TestCases;

import General.Main;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static General.InitMethods.*;

/**
 * Created by VenD on 11/7/2018.
 */
public class StatusCodeFlows extends Main {

    public static int actualForStatusCode[];

    @Test
    public static void statusCodeCheckingForStage() throws IOException

    {
//        status_Code_Object.statusCodeUrls(Url);
//        actualForStatusCode=status_Code_Object.statusCodeUrls(Url);
//        System.out.print("\n"+actualForStatusCode+"\n");
//        Assert.assertEquals(actualForStatusCode[0],actualForStatusCode[1],"Both the values for status codes are equal");
//       // New_Landing_Object.statusCodeUrls(Url);
        actualForStatusCode=status_Code_Object.readExcel(Url,FilePathForUrls,FileName,SheetName);
        System.out.print("\n"+actualForStatusCode[0]+"\n"+"\n"+actualForStatusCode[1]+"\n");
      Assert.assertEquals(actualForStatusCode[0],actualForStatusCode[1],"Both the values for status codes are equal");





    }

    @Test
    public static void statusCodeCheckingForQA1() throws IOException

    {
//        status_Code_Object.statusCodeUrls(Url);
//        actualForStatusCode=status_Code_Object.statusCodeUrls(Url);
//        System.out.print("\n"+actualForStatusCode+"\n");
//        Assert.assertEquals(actualForStatusCode[0],actualForStatusCode[1],"Both the values for status codes are equal");
//       // New_Landing_Object.statusCodeUrls(Url);
        actualForStatusCode=status_Code_Object.readExcel(urlForQa1,FilePathForUrls,FileName,SheetName);
        System.out.print("\n"+actualForStatusCode[0]+"\n"+"\n"+actualForStatusCode[1]+"\n");
        Assert.assertEquals(actualForStatusCode[0],actualForStatusCode[1],"Both the values for status codes are equal");





    }
}
