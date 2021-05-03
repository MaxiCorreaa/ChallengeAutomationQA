package pages.segurosPersonales;

import org.openqa.selenium.By;

public class MenuSegurosPersonalesPage {

    private By botonHogar;

    public MenuSegurosPersonalesPage() {
        botonHogar = By.xpath("//li[@id='menu-item-21317']");
    }

    public By getBotonHogar() {
        return botonHogar;
    }
}
