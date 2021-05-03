package steps.segurosPersonales.hogar.cotizar;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.segurosPersonales.hogar.cotizar.CotizarPage;
import tests.BaseTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CotizarStep extends BaseTest {

    private static final String PAGE_NAME = "Cotizar Step: ";
    private CotizarPage pagina;

    public CotizarStep() {
        pagina = new CotizarPage();
    }

    @Step(PAGE_NAME + "Ingresar datos para cotizar")
    public CotizarStep ingresarDatosParaCotizar() {
        ingresarNombre();
        ingresarTelefono();
        ingresarEmail();
        ingresarTipoDeVivienda();
        ingresarSuperficie();
        ingresarUbicacion();
        return this;
    }

    @Step(PAGE_NAME + "Ingresar nombre")
    public void ingresarNombre() {
        WebElement inputName = wait.until(ExpectedConditions.visibilityOfElementLocated(pagina.getInputName()));
        Assertions.assertTrue(inputName.isDisplayed(), "Campo input name no encontrado");
        inputName.sendKeys("Maximiliano Correa");
    }

    @Step(PAGE_NAME + "Ingresar telefono")
    public void ingresarTelefono() {
        WebElement inputTel = wait.until(ExpectedConditions.visibilityOfElementLocated(pagina.getInputTel()));
        Assertions.assertTrue(inputTel.isDisplayed(), "Campo input tel no encontrado");
        inputTel.sendKeys("1125647692");
    }

    @Step(PAGE_NAME + "Ingresar email")
    public void ingresarEmail() {
        WebElement inputEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(pagina.getInputEmail()));
        Assertions.assertTrue(inputEmail.isDisplayed(), "Campo ingresar email no encontrado");
        inputEmail.sendKeys("correamaximilianonicolas@hotmail.com");
    }

    @Step(PAGE_NAME + "Ingresar tipo de vivienda")
    public void ingresarTipoDeVivienda() {
        WebElement tipoDeVivienda = wait.until(ExpectedConditions.visibilityOfElementLocated(pagina.getTipoDeVivienda()));
        Assertions.assertTrue(tipoDeVivienda.isDisplayed(), "Campo tipo de vivienda no encontrado");
        tipoDeVivienda.sendKeys("Casa");
    }

    @Step(PAGE_NAME + "Ingresar superficie")
    public void ingresarSuperficie() {
        WebElement superficie = wait.until(ExpectedConditions.visibilityOfElementLocated(pagina.getSuperficie()));
        Assertions.assertTrue(superficie.isDisplayed(), "Campo superficie no encontrado");
        superficie.sendKeys("30 a 40 m2");
    }

    @Step(PAGE_NAME + "Ingresar ubicacion")
    public void ingresarUbicacion() {
        WebElement ubicacion = wait.until(ExpectedConditions.visibilityOfElementLocated(pagina.getUbicacion()));
        Assertions.assertTrue(ubicacion.isDisplayed(), "Campo ubicacion no encontrado");
        ubicacion.sendKeys("CABA");
    }

    @Step(PAGE_NAME + "Click en Cotizar")
    public CotizarStep clickEnCotizar() {
        WebElement cotizar = wait.until(ExpectedConditions.visibilityOfElementLocated(pagina.getCotizarSubmit()));
        Assertions.assertTrue(cotizar.isDisplayed(), "boton cotizar submit no encontrado");
        cotizar.click();
        return this;
    }

    @Step(PAGE_NAME + "Se valida que el numero sea entero, distinto de cero y sea un valor positivo")
    public CotizarStep validarMontoMensual() {
        //int numero = 0;
        int numero = devolverValor();
//        try{
//            Thread.sleep(2000);
//            numero = devolverValor();
//        } catch (InterruptedException | NoSuchElementException e) {
//            e.printStackTrace();
//        }
        Assertions.assertTrue(numero > 0, "El numero es negativo");
        Assertions.assertTrue(numero != 0, "el numero es cero");
        return new CotizarStep();
    }

    private int devolverValor() {
        List<WebElement> lista = new ArrayList<>();
        try {
            Thread.sleep(5000);
            lista = driver.findElements(By.tagName("tr"));
        } catch (InterruptedException | NoSuchElementException e) {
            e.printStackTrace();
        }
        String montoMensual = lista.get(10).getText();
        String[] spliteado = montoMensual.replaceAll("\n", "").split(" ", 3);
        int numero = validarSiEsUnNumero(spliteado[2]);
        return numero;
    }

    private int validarSiEsUnNumero(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException n) {
            n.printStackTrace();
            throw new AssertionError("Se produjo una excepcion en el valor Int");
        }
    }

    @Step(PAGE_NAME + "Se valida el chat online")
    public void validarChatOnline() {
        WebElement chatOnline = wait.until(ExpectedConditions.visibilityOfElementLocated(pagina.getChatOnline()));
        Assertions.assertTrue(chatOnline.isDisplayed(), "Chat online no encontrado");
    }
}
