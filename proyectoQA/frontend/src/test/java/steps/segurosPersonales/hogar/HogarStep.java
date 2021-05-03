package steps.segurosPersonales.hogar;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.segurosPersonales.hogar.HogarPage;
import steps.segurosPersonales.hogar.cotizar.CotizarStep;
import tests.BaseTest;

public class HogarStep extends BaseTest {

    private static final String PAGE_NAME = "Hogar Step: ";
    private HogarPage pagina;

    public HogarStep() {
        pagina = new HogarPage();
    }

    @Step(PAGE_NAME + "Click en boton Cotizar")
    public CotizarStep clickEnCotizar() {
        WebElement botonCotizar = wait.until(ExpectedConditions.visibilityOfElementLocated(pagina.getBotonCotizar()));
        Assertions.assertTrue(botonCotizar.isDisplayed(), "Boton cotizar no encontrado");
        botonCotizar.click();
        return new CotizarStep();
    }
}
