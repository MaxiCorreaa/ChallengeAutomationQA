package steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.HomePage;
import steps.segurosPersonales.MenuSegurosPersonalesStep;
import tests.BaseTest;

public class HomeStep extends BaseTest {

    private static final String PAGE_NAME = "Home Step: ";
    private HomePage pagina;

    public HomeStep() {
        pagina = new HomePage();
        validarLogo();
    }

    @Step(PAGE_NAME + "Validar Logo Home")
    public void validarLogo() {
        WebElement logoHome = wait.until(ExpectedConditions.visibilityOfElementLocated(pagina.getLogoHome()));
        Assertions.assertTrue(logoHome.isDisplayed(), "Logo Home no encontrado");
    }

    @Step(PAGE_NAME + "Click en boton Personas")
    public HomeStep clickEnPersonas() {
        WebElement botonPersonas = wait.until(ExpectedConditions.visibilityOfElementLocated(pagina.getBotonPersonas()));
        Assertions.assertTrue(botonPersonas.isDisplayed(), "Boton Personas no encontrado");
        botonPersonas.click();
        return new HomeStep();
    }

    @Step(PAGE_NAME + "Click en boton Seguros")
    public MenuSegurosPersonalesStep clickEnSeguros() {
        WebElement botonSeguros = wait.until(ExpectedConditions.visibilityOfElementLocated(pagina.getBotonSeguros()));
        Assertions.assertTrue(botonSeguros.isDisplayed(), "Boton seguros no encontrado");
        botonSeguros.click();
        return new MenuSegurosPersonalesStep();
    }
}
