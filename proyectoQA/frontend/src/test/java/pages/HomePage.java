package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.BaseTest;

public class HomePage extends BaseTest {

    By botonSeguros = By.xpath("//li[@id='menu-item-19525']//a[contains(text(),'Seguros')]");
    By logoHome = By.xpath("//div[@class='logoMA']");
    By botonPersonas = By.xpath("//a[contains(text(),'Personas')]");


    public By getBotonPersonas() {
        return botonPersonas;
    }

    public By getBotonSeguros() {
        return botonSeguros;
    }

    public By getLogoHome() {
        return logoHome;
    }
}
