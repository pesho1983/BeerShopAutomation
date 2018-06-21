package BeerShop.Utils;


import BeerShop.pages.WalletPage;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

import java.io.File;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

public class Utils {

    public final static String WEBSITE_URL = "http://192.168.10.158/BeerShop/";


    private static String homePathBeer = imagesRelativePathBeer();
    private static String homePathSameBeer = imagesRelativePathSameBeer();


    public static String imagesRelativePathBeer() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.getProperty("user.dir"))
                .append("/src/test/java/BeerShop/Utils/imagesBeer/");
        String homePathBeer = sb.toString();
        homePathBeer = homePathBeer.replace('\\', '/');

        return homePathBeer;
    }

    public static String imagesRelativePathSameBeer() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.getProperty("user.dir"))
                .append("/src/test/java/BeerShop/Utils/imageSameBeer/");
        String homePathSameBeer = sb.toString();
        homePathSameBeer = homePathSameBeer.replace('\\', '/');

        return homePathSameBeer;
    }


    public static String productIndividualXpath(WebElementFacade target, String replace) {
        String targetProduct = target.getWrappedElement().toString();
        String toRemove = targetProduct.substring(0, 78);
        return targetProduct.replace(toRemove, "").replace(replace, "");
    }

    public static String generateRandomImagePathBeer() {
        StringBuilder sb = new StringBuilder();
        SecureRandom rand = new SecureRandom();
        sb.append(imagesRelativePathBeer())
                .append(rand.nextInt(100000) + 100)
                .append(System.currentTimeMillis())
                .append(System.nanoTime())
                .append(".png")
                .append(".jpg");

        return sb.toString();
    }

    public static void renameAllFiles() {
        File fileDirs = new File(homePathBeer);
        for (File image : fileDirs.listFiles()) {
            if (image.isFile()) {
                String newName = generateRandomImagePathBeer();
                if (image.renameTo(new File(newName))) {
                }
            }
        }
    }

    public static String getRandomImageFromFolder() {
        renameAllFiles();
        File fileDir = new File(homePathBeer);
        File[] images = fileDir.listFiles();
        Random random = new Random();
        String selectedImage = images[random.nextInt(images.length


                - 1) + 1].toString();
        return selectedImage;
    }

    public static String getRandomImageFromFolderBeer() {
        renameAllFiles();
        File fileDir = new File(homePathBeer);
        File[] images = fileDir.listFiles();
        Random random = new Random();
        String selectedImage = images[random.nextInt(images.length - 1) + 1].toString();
        return selectedImage;
    }

    public static String getRandomImageFromFolderSameBeer() {
        renameAllFiles();
        File fileDir = new File(homePathSameBeer);
        File[] images = fileDir.listFiles();
        Random random = new Random();
        String selectedImage = images[random.nextInt(images.length - 1) + 1].toString();
        return selectedImage;
    }


    public static String replaceWordWithWhitespace(String text, String toReplace) {
        return text.replace(toReplace, "");
    }

    public static String replaceWordWithRegex(String text, String regex) {
        return text.replaceAll(regex, "");
    }

    public static void acceptAlert() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 3000);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }

    public static void javascriptWindowScroll(int scrollBy) {
        String script = "window.scrollBy(0,%s)";
        script = String.format(script, scrollBy);

        ((JavascriptExecutor) getDriver()).executeScript(script, "");
    }

    public static String removeSuffixFromPrice(WebElementFacade target) {
        String result = target.getText();
        return result.substring(0, result.length() - 3);
    }

    public static ArrayList fileRemaner() {
        // change file names in 'Directory':
        String absolutePath = "C:\\Pictures";
        File dir = new File(absolutePath);
        File[] filesInDir = dir.listFiles();
        ArrayList listOfPicturesNames = new ArrayList();
        int i = 0;
        for (File file : filesInDir) {
            i++;
            String name = file.getName();
            double random = Math.random() * 4.9 + 1;
            String newName = random + i + ".jpg";
            listOfPicturesNames.add(newName);
            String newPath = absolutePath + "\\" + newName;
            file.renameTo(new File(newPath));
            System.out.println(name + " changed to " + newName);
        }

        return listOfPicturesNames;
    }


}


