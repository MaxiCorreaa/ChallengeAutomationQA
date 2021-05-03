package steps.segurosPersonales;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.segurosPersonales.MenuSegurosPersonalesPage;
import steps.segurosPersonales.hogar.HogarStep;
import tests.BaseTest;

public class MenuSegurosPersonalesStep extends BaseTest {

    private static final String PAGE_NAME = "Menu Seguros Personales Step: ";
    private MenuSegurosPersonalesPage pagina;

    public MenuSegurosPersonalesStep() {
        pagina = new MenuSegurosPersonalesPage();
    }

    @Step(PAGE_NAME + "Click en Boton Hogar")
    public HogarStep clickEnMenuHogar() {
        WebElement botonHogar = wait.until(ExpectedConditions.visibilityOfElementLocated(pagina.getBotonHogar()));
        Assertions.assertTrue(botonHogar.isDisplayed(), "El boton Hogar no se encuentra");
        botonHogar.click();
        return new HogarStep();
    }
}
