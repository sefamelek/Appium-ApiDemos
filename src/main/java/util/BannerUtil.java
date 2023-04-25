package util;

import org.testng.Assert;

import java.io.FileReader;

import static actionHelper.AndroidHelperMethods.logger;
import static actionHelper.BannerHelper.setFileToConsole;

public class BannerUtil {
    public static final String SLASH = System.getProperty( "file.separator" );

    public static final String PROJECT_DIR = System.getProperty( "user.dir" );

    private static final String BANNER  =   "src/main/resources/banner.txt".replace("/", SLASH);
    private static final String CONSOLE_BLUE    =   "[36;1m";
    private static final String CONSOLE_GREEN   =   "[32;1m";

    public static void paintBanner() {

       try {

           FileReader readerBanner  =   new FileReader( PROJECT_DIR + SLASH + BANNER );


           setFileToConsole( readerBanner, CONSOLE_BLUE );



       } catch (Exception e) {

           logger.warn( "\t\n" + e.getMessage() + "\t\n" );
           Assert.fail( "\t\n" + e.getMessage() + "\t\n" );

       }

    }

}
