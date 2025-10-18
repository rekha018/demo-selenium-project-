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
  HomePage homePage;

  Random random = new Random();
  int randomNumber = random.nextInt();
  String email = "abc" + randomNumber + "@gmail.com";
  String password = "Test@1234";
  String firstName = "John";
  String lastName = "Doe";
  String female = "female";

  @BeforeEach
  public void setUp() {
    driver = new ChromeDriver();
    registrationPage = new RegistrationPage(driver);
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);
  }

  @Test
  @Order(1)
  public void shouldRegistrationToTheSofaApp() {
    registrationPage.goToSafaApp();
    registrationPage.acceptCookie();
    registrationPage.userRegistration(female, firstName, lastName, email, password);
  }

  @Test
  @Order(2)
  public void validLogin() {
    loginPage.goToLoginPage();
    loginPage.loginToSofaApp("johndoe@gmail.com", password);
  }

  @Test
  @Order(3)
  public void selectRandomItemsFromCategoryAndAddToWishlist() {
    registrationPage.goToSafaApp();
    registrationPage.acceptCookie();
    registrationPage.userRegistration(female, firstName, lastName, email, password);
    homePage.selectRandomItemsFromCategory();
  }

  @AfterEach
  public void tearDown() {
  }
}