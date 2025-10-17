package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    private By cookieAcceptElement = By.xpath("//button[contains(text(), 'Alle auswählen & bestätigen')]");
    private By emailElement = By.xpath("//input[@id='loginEmail']");
    private By passwordElement = By.xpath("//input[@id='loginPassword']");
    private By login = By.xpath("//button[@id='login-submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToLoginPage() {
        driver.get("https://www.sofa.de/login");
        driver.manage().window().maximize();
        driver.findElement(cookieAcceptElement).click();
    }

    public void loginToSofaApp(String email, String password) {

        driver.findElement(emailElement).sendKeys(email);
        driver.findElement(passwordElement).sendKeys(password);
        driver.findElement(login).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}