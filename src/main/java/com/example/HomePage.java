package com.example;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    private By eckSofa = By
            .xpath("//img[@src='/static-content/images/_shops/sofaDE/headerImageLinkPanel/ecksofas_hover.png']");
    private By productListElement = By.xpath("//section[@class='css-0 e1tz9tx4']/ul[@class='css-9b5t34 e1tz9tx3']");
    private By wishListElement = By.xpath("//button[@class='css-oyuqp1 e1p6hi4m0']");
    private By liTag = By.tagName("li");
    private By wishListElementOnHeader = By.xpath("//span[@class='headerElement__icon headerElement__icon--wishlist']");;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectRandomItemsFromCategory() {
        driver.findElement(eckSofa).click();
        
        WebElement productList = driver.findElement(productListElement);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(liTag, 0));
        List<WebElement> items = productList.findElements(liTag);
        int totalNoProducts = items.size();
        System.out.println("Found " + totalNoProducts + "products");
        for (int i = 0; i < 5; i++) {
            WebElement product = wait.until(ExpectedConditions.elementToBeClickable(items.get(i)));
            product.findElement(wishListElement).click();
        }

        WebElement wishListButton =wait.until(ExpectedConditions.elementToBeClickable(wishListElementOnHeader));
        wishListButton.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
