package actionHelper;

import org.testng.Assert;

import java.io.FileReader;

import static actionHelper.AndroidHelperMethods.logger;

public class BannerHelper {

    public static void setFileToConsole(FileReader reader, String color) {

        try {

            int character;

            while ( ( character = reader.read() ) != -1 ) {

                System.out.print( "\u001B" + color + ( char ) character + "\u001B[0m" );

            }

        } catch (Exception e) {

            logger.info( "\t\n" + e.getMessage() + "\t\n" );
            Assert.fail( "\t\n" + e.getMessage() + "\t\n" );

        }

    }

}
