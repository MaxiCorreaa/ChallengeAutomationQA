package pages.segurosPersonales.hogar.cotizar;


import org.openqa.selenium.By;

public class CotizarPage {

    private By inputName;
    private By inputTel;
    private By inputEmail;
    private By tipoDeVivienda;
    private By superficie;
    private By ubicacion;
    private By cotizadorResult;
    private By cotizarSubmit;
    private By chatOnline;

    public CotizarPage() {
        inputName = By.xpath("//input[@id='inputName']");
        inputTel = By.xpath("//input[@id='inputTel']");
        inputEmail = By.xpath("//input[@id='inputemail']");
        tipoDeVivienda = By.xpath("//select[@id='tipovivienda']");
        superficie = By.xpath("//select[@id='superficie']");
        ubicacion = By.xpath("//select[@id='ubicacion']");
        cotizadorResult = By.xpath("//div[@id='cotizador-result']");
        cotizarSubmit = By.xpath("//button[@id='cotizador-submit']");
        chatOnline = By.xpath("//div[@style='overflow: hidden; position: fixed; width: 300px; height: 75px; bottom: 50px; right: 2%; z-index: 2147483647; display: flex; left: unset;']");
    }

    public By getInputName() {
        return inputName;
    }

    public By getInputTel() {
        return inputTel;
    }

    public By getInputEmail() {
        return inputEmail;
    }

    public By getTipoDeVivienda() {
        return tipoDeVivienda;
    }

    public By getSuperficie() {
        return superficie;
    }

    public By getUbicacion() {
        return ubicacion;
    }

    public By getCotizadorResult() {
        return cotizadorResult;
    }

    public By getCotizarSubmit() {
        return cotizarSubmit;
    }

    public By getChatOnline() {
        return chatOnline;
    }
}
