package BeerShop.Utils;


import net.serenitybdd.core.pages.WebElementFacade;

import java.io.File;
import java.security.SecureRandom;
import java.util.Random;

public class Utils {
    private final static String HOME_PATH = "C:/Users/rkolev/Desktop/uploadTestImages/";

    public static String productIndividualXpath(WebElementFacade target, String replace) {
        String targetProduct = target.getWrappedElement().toString();
        String toRemove = targetProduct.substring(0, 78);
        return targetProduct.replace(toRemove, "").replace(replace, "");
    }

    public static String generateRandomImagePath() {
        StringBuilder sb = new StringBuilder();
        SecureRandom rand = new SecureRandom();
        sb.append(HOME_PATH)
                .append(rand.nextInt(100000) + 100)
                .append(System.currentTimeMillis())
                .append(System.nanoTime())
                .append(".png");

        return sb.toString();
    }


    public static void renameAllFiles() {
        File fileDirs = new File(HOME_PATH);
        for (File image : fileDirs.listFiles()) {
            if (image.isFile()) {
                String newName = generateRandomImagePath();
                if (image.renameTo(new File(newName))) {
                }
            }
        }
    }

    public static String getRandomImageFromFolder() {
        renameAllFiles();
        File fileDir = new File(HOME_PATH);
        File[] images = fileDir.listFiles();
        Random random = new Random();
        return images[random.nextInt(images.length-1)+1].toString();
    }
}

