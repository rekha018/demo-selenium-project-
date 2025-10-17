package com.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class Tests {

  WebDriver driver;
  RegistrationPage registrationPage;
  LoginPage loginPage;

  Random random = new Random();
  int randomNumber = random.nextInt();
  String email = "abc" + randomNumber + "@gmail.com";
  String password = "Test@1234";

  @BeforeEach
  public void setUp() {
    driver = new ChromeDriver();
    registrationPage = new RegistrationPage(driver);
    loginPage = new LoginPage(driver);
  }

  @Test
  @Order(1)
  public void shouldRegistrationToTheSofaApp() {
    String firstName = "John";
    String lastName = "Doe";
    String female = "female";
    registrationPage.goToSafaApp();
    registrationPage.acceptCookie();
    registrationPage.userRegistration(female, firstName, lastName, email, password);
  }

  @Test
  @Order(2)
  public void validLogin() {
    loginPage.goToLoginPage();
    loginPage.loginToSofaApp(email, password);

  }

  @AfterEach
  public void tearDown() {
  }
}