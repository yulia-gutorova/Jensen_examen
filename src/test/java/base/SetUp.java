package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import static base.CommonMethods.printToLogFile;
import static base.CommonMethods.sleep;
//import static base.interactElements.ElementsInteractingMethods.printToLogFile;

public class SetUp {

    public static PrintWriter writer = null;

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeAll
    public static void setUpp() throws FileNotFoundException {

        writer = new PrintWriter(new File("src/test/java/resources/logs/TestLLog.log"));
        printToLogFile("----- Demo_Examen_Junit run -----", "");

        //writer.println("----- Demo_Examen_Junit run -----");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        sleep(2000);
    }

    @AfterAll
    public static void tearDown()
    {
        writer.close();
        //driver.quit();

    }



}
