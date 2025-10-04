package com.sqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;

@DefaultUrl("https://jqueryui.com/datepicker/")
public class DatepickerPage extends PageObject {

    // Localizador del iframe que contiene el calendario
    @FindBy(className = "demo-frame")
    private WebElement iframe;

    // Localizador del campo de texto de la fecha
    @FindBy(id = "datepicker")
    private WebElement dateField;

    // Localizador del campo para el mes siguiente
    @FindBy(xpath = "//a[@data-handler='next']")
    private WebElement nextMonthButton;

    // Este método cambia el contexto del driver al iframe del calendario.
    public void switchToIframe() {
        getDriver().switchTo().frame(iframe);
    }

    //Este método hace clic en el campo de texto para abrir el calendario.
    public void openCalendar() {
        dateField.click();
    }

    // Hace clic en el botón para navegar al siguiente mes en el calendario.
    public void navigateToNextMonth() {
        nextMonthButton.click();
    }

    // Este método selecciona un día específico del mes actual en el calendario.
    public void selectDay(String day) {
        String xpath = "//td[@data-handler='selectDay']/a[text()='" + day + "']";
        $(By.xpath(xpath)).click();
    }

    // Este método devuelve el valor actual del campo de texto de la fecha.
    public String getSelectedDate() {
        return dateField.getAttribute("value");
    }
    
    // metodo que valida si se puede ingresar una fecha manualmente
    public void verifyDateFieldIsBlocked() {
        Actions actions = new Actions(getDriver());

        String textToTry = "12/12/2025";
        actions.sendKeys(dateField, textToTry).perform();

        String currentValue = getSelectedDate();

        org.junit.Assert.assertTrue(
            "Se esperaba que el campo de fecha estuviera vacío después de intentar escribir, pero su valor es: " + currentValue,
            currentValue.isEmpty()
        );
    }
}