package TestCases;

import General.Main;
import org.testng.Assert;
import org.testng.annotations.Test;

import static General.InitMethods.Url;
import static General.InitMethods.guideObject;
import static General.InitMethods.urlForQa1;

/**
 * Created by VenD on 6/19/2019.
 */
public class GuidesPageTestCases extends Main {

    public int reponseOfGuidesClick;
    public int ExpeedtedForGuides=6;
    @Test
    public void GuidesClick() throws InterruptedException {
        guideObject.openGuidesPage(urlForQa1);
        guideObject.waiting();
        reponseOfGuidesClick=guideObject.getAllTheGuidesAndClick();
        Assert.assertEquals(reponseOfGuidesClick,ExpeedtedForGuides);
    }

}
