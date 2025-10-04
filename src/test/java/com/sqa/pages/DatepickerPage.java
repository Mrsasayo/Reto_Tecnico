package com.sqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;

@DefaultUrl("https://jqueryui.com/datepicker/") // <-- AÑADE ESTA LÍNEA
public class DatepickerPage extends PageObject {
    // Localizador del iframe que contiene el calendario
    @FindBy(className = "demo-frame")
    private WebElement iframe;

    // Localizador del campo de texto de la fecha
    @FindBy(id = "datepicker")
    private WebElement dateField;

    // --- NUEVO LOCALIZADOR ---
    @FindBy(xpath = "//a[@data-handler='next']")
    private WebElement nextMonthButton;

    /**
     * Este método cambia el contexto del driver al iframe del calendario.
     */
    public void switchToIframe() {
        getDriver().switchTo().frame(iframe);
    }

    /**
     * Este método hace clic en el campo de texto para abrir el calendario.
     */
    public void openCalendar() {
        dateField.click();
    }

    // --- NUEVO MÉTODO ---
    /**
     * Hace clic en el botón para navegar al siguiente mes en el calendario.
     */
    public void navigateToNextMonth() {
        nextMonthButton.click();
    }
    // --------------------

    /**
     * Este método selecciona un día específico del mes actual en el calendario.
     * @param day El día a seleccionar.
     */
    public void selectDay(String day) {
        // Construye el localizador dinámicamente para el día deseado
        String xpath = "//td[@data-handler='selectDay']/a[text()='" + day + "']";
        $(By.xpath(xpath)).click();
    }

    /**
     * Este método devuelve el valor actual del campo de texto de la fecha.
     * @return El texto de la fecha.
     */
    public String getSelectedDate() {
        return dateField.getAttribute("value");
    }
    
// --- MÉTODO DE VALIDACIÓN FINAL Y PRECISO ---
    /**
     * Verifica que no se puede escribir manualmente en el campo de fecha,
     * simulando pulsaciones de teclado reales.
     */
    public void verifyDateFieldIsBlocked() {
        // La clase Actions permite emular interacciones complejas de usuario.
        Actions actions = new Actions(getDriver());
        
        // Usamos actions.sendKeys() que simula pulsaciones de teclado reales en el elemento.
        // Esto sí activará los scripts de la página que bloquean la entrada.
        String textToTry = "12/12/2025";
        actions.sendKeys(dateField, textToTry).perform();

        // Obtenemos el valor actual del campo DESPUÉS de intentar escribir
        String currentValue = getSelectedDate();

        // La aserción ahora sí debería pasar, porque el campo debería permanecer vacío.
        org.junit.Assert.assertTrue(
            "Se esperaba que el campo de fecha estuviera vacío después de intentar escribir, pero su valor es: " + currentValue,
            currentValue.isEmpty()
        );
    }


}