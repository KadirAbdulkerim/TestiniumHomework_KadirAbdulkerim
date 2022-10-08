package pageutility;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author Kadirdan Abdukerim
 * @create 2022-10-06-8:21 PM
 */
public class Utility {
    public static int indexNum;

    public static WebElement randomSelect(String locator) {
        Random random = new Random();
        List<WebElement> listInSections = DriverFactory.getDriver().findElements(By.cssSelector(locator));
        int list = random.nextInt(listInSections.size());
        return listInSections.get(list);
    }

    public static WebElement randomSelectItemSize(By element) {
        Random random = new Random();
        List<WebElement> listInSections = DriverFactory.getDriver().findElements(element);
        List<WebElement> enabledItemSize = new ArrayList<>();
        for (WebElement e : listInSections) {
            if (!e.getAttribute("class").contains("disabled")) {
                enabledItemSize.add(e);
            }
        }
        indexNum = random.nextInt(enabledItemSize.size());
        return enabledItemSize.get(indexNum);
    }

    public static WebElement randomSelectItemSize(int indexNum, By element) {
        List<WebElement> listInSections = DriverFactory.getDriver().findElements(element);
        List<WebElement> enabledItemSize = new ArrayList<>();
        for (WebElement e : listInSections) {
            if (!e.getAttribute("class").contains("disabled")) {
                enabledItemSize.add(e);
            }
        }
        return enabledItemSize.get(indexNum);
    }

    public static String getPageTitle() {
        return DriverFactory.getDriver().getTitle();
    }

    public static String getColumn(int columnIndex) {
        String[][] item_names = ExcelReader.getExcelData("src/test/resources/Testinium.xlsx", "Item_Names");
        String[] firstRow = Arrays.stream(item_names).findFirst().get();
        return firstRow[columnIndex];
    }

    public static void txtWrite(String info) throws IOException {
        File file = new File("src/test/resources/productinfo");
        FileWriter fw = new FileWriter(file);
        BufferedWriter writer = new BufferedWriter(fw);
        writer.write(info);
        writer.close();
    }
}
