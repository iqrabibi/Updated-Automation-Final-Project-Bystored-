package General;


import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;

/**
 * Created by VenD on 5/3/2018.
 */

@Resource.Classpath("ApplicationConfig.properties")

public class ApplicationConfigReader {
    public ApplicationConfigReader()
    {
        PropertyLoader.newInstance().populate(this);
    }

    @Property(value = "url")
    public  static String Url;

    public String getUrl() {
        return Url;
    }





    @Property(value = "downloadPath")
    public String downloadPath;

    public String getDownloadPath() {

        return downloadPath;
    }


    @Property(value = "FilePathForUrls")
    public String FilePathForUrls;

    public String getFilePathForUrls() {

        return FilePathForUrls;
    }


    @Property(value = "FileName")
    public String FileName;

    public String getFileName() {

        return FileName;
    }

    @Property(value = "urlForQa1")
    public String urlForQa1;

    public String geturlForQa1() {

        return urlForQa1;
    }

    @Property(value = "SheetName")
    public String SheetName;

    public String getSheetName() {

        return SheetName;
    }

    @Property(value = "adminPanelQa1URL")
    public String adminPanelQa1URL;

    public String getadminPanelQa1URL() {

        return adminPanelQa1URL;
    }

    @Property(value = "adminPanelStageURL")
    public String adminPanelStageURL;

    public String getadminPanelStageURL() {

        return adminPanelStageURL;
    }




}
