package tests;

import io.qameta.allure.Step;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseTest {

    public static final Logger LOGGER = Logger.getLogger(String.valueOf(BaseTest.class));
    public static WebDriver driver;
    public static Properties config = new Properties();
    public static String myOs = System.getProperty("os.name");
    public static FileInputStream fis;
    public static WebDriverWait wait;

    public static final  String CERRAR = "El usuario cierra navegador web";
    public static final  String ABRIR = "El usuario abre navegador web";

    @BeforeClass
    @Step(ABRIR + " con MERCANTIL-ANDINA")
    public static void setUp() {
        if (driver == null) {
            try {
                fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/Config.properties");
            } catch (FileNotFoundException e) {
                LOGGER.log(Level.WARNING, "File Config.properties not found in directory");
                e.printStackTrace();
            }
            try {
                config.load(fis);
            } catch (IOException e) {
                LOGGER.log(Level.WARNING, "Failed to load Config.properties");
                e.printStackTrace();
            }
        }

        if (myOs.toLowerCase().contains("windows")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromeDriver/chromedriver.exe");
            LOGGER.log(Level.INFO, "Chrome launched for Windows!");
        } else {
            LOGGER.log(Level.INFO, "Operative System not found");
        }
        driver = new ChromeDriver();
        driver.get(config.getProperty("appUrl"));
        LOGGER.log(Level.INFO, "Navigated to: " + config.getProperty("appUrl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(config.getProperty("implicitlyWait")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20);
    }

    @AfterClass
    @Step(CERRAR + " con MERCANTIL-ANDINA")
    public static void out() {
        driver.quit();
        executeAllure();
        LOGGER.log(Level.INFO, "Test execution completed!");
    }

    private static void executeAllure() {
        try {
            String userdir = System.getProperty("user.dir");
            Process p = Runtime
                    .getRuntime()
                    .exec("cmd /c start cmd.exe /K \"cd " + userdir + " && allure serve allure-results\"");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
