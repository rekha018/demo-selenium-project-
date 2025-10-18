package com.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

  WebDriver driver;

  String url = "https://www.sofa.de/registrierung";
  By acceptCookieElement = By.xpath("//button[contains(text(), 'Alle auswählen & bestätigen')]");
  By salutationElement = By.xpath("//select[@id='accountNewSalutation']");
  By firstNameElement = By.xpath("//input[@id='firstName']");
  By lastNameElement = By.xpath("//input[@id='lastName']");
  By emaiElement = By.xpath("//input[@id='email']");
  By passwordElement = By.xpath("//input[@id='password']");
  By repeatPasswordElement = By.xpath("//input[@id='password2']");
  By agbCheckbox = By.xpath("//input[@id='agbCheckbox']");
  By registrationSubmitButton = By.xpath("//Button[@id='register-submit']");

  public RegistrationPage(WebDriver driver) {
    this.driver = driver;
  }

  public void goToSafaApp() {
    driver.get(url);
    driver.manage().window().maximize();
  }

  public void acceptCookie() {
    driver.findElement(acceptCookieElement).click();
  }

  public void userRegistration(String salutation, String firstName, String lastName, String email, String password) {
    WebElement selectElement = driver.findElement(salutationElement);
    Select select = new Select(selectElement);
    select.selectByValue("female");
    driver.findElement(firstNameElement).sendKeys(firstName);
    driver.findElement(lastNameElement).sendKeys(lastName);
    driver.findElement(emaiElement).sendKeys(email);
    driver.findElement(passwordElement).sendKeys(password);
    driver.findElement(repeatPasswordElement).sendKeys(password);
    driver.findElement(agbCheckbox).click();
    driver.findElement(registrationSubmitButton).click();
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void tearDown() {
    driver.quit();
  }

}