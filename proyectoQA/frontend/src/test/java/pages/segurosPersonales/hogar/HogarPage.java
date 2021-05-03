package pages.segurosPersonales.hogar;

import org.openqa.selenium.By;

public class HogarPage {

    private By botonCotizar;

    public HogarPage() {
        botonCotizar = By.xpath("//a[contains(text(),'Cotizar')]");
    }

    public By getBotonCotizar() {
        return botonCotizar;
    }
}
