package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyDriver {

    public static WebDriver driver;
    public static Properties config = new Properties();
    public static String myOs = System.getProperty("os.name");
    public static FileInputStream fis;
    public static WebDriverWait wait;

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(MyDriver.class));
    public static final  String CERRAR = "El usuario cierra navegador web";
    public static final  String ABRIR = "El usuario abre navegador web";


    public void setUp() {
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
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/exec/chromedriver.exe");
            LOGGER.log(Level.INFO, "Chrome launched for Windows!");
        } else {
            LOGGER.log(Level.INFO, "Operative System not found");
        }
    }
}
