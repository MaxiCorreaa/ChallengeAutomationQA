package tests;

import io.qameta.allure.*;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import steps.HomeStep;

@DisplayName("Cotizaciones Test Suite")
public class CotizacionTest extends BaseTest {

    @Test()
    @DisplayName("TC-0001: Verificar cotizaciones")
    @Feature("TC-0001: Verificar cotizaciones")
    @Story("Verificar Cotizaciones")
    @Description("Verificar que el costo mensual sea un valor positivo, mayor a cero y entero. Verificar que se visualice Chat Online")
    public void ValidarCotizaciones() {
        HomeStep homeStep = new HomeStep();
        homeStep.clickEnPersonas()
                .clickEnSeguros()
                .clickEnMenuHogar()
                .clickEnCotizar()
                .ingresarDatosParaCotizar()
                .clickEnCotizar()
                .validarMontoMensual()
                .validarChatOnline();
    }
}
