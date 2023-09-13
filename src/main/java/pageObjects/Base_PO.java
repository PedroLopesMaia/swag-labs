package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base_PO {

    public Base_PO() {}

    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    public void navigateTo_URL (String url) {
        getDriver().get(url);
    }
}
