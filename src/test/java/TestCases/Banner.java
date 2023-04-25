package TestCases;

import actionHelper.BannerHelper;
import org.testng.annotations.Factory;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.LinkedList;

import static util.BannerUtil.*;


public class Banner {

    public static void cleanRerunBaseDir(String rerunDir) throws IOException {

        String destination = PROJECT_DIR + SLASH + rerunDir;

        Path directory = Paths.get( destination );

        if ( Files.exists( directory ) ) {

            Files.walkFileTree( directory, new SimpleFileVisitor<Path>() {

                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
                    Files.delete(path);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path directory, IOException ioException) throws IOException {
                    Files.delete(directory);
                    return FileVisitResult.CONTINUE;
                }

            } );}}
    private static final String FEATURE_DIR     =   "src/test/resources/features/".replace("/", SLASH);
    private static final String RERUN_DIR       =   "build/rerun".replace("/",SLASH);
    private static String tags                  =   System.getProperty( "tag", "~@ignore" );

    public Banner() throws IOException {

        cleanRerunBaseDir( RERUN_DIR );

        paintBanner();

    }



    }



