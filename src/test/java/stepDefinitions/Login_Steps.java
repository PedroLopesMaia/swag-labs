package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.Base_PO;

import java.time.Duration;

public class Login_Steps extends Base_PO {

    private WebDriver driver = getDriver();

    @Given("I access the login page")
    public void i_access_the_login_page() {
        navigateTo_URL("https://www.saucedemo.com/");
    }

    @When("I enter a username {word}")
    public void i_enter_a_correct_username(String username) {
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
    }

    @And("I enter a password {word}")
    public void i_enter_a_password(String password) {
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
    }


    @And("I click the login button")
    public void i_click_the_login_button() {
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }

    @Then("I should be presented with the main page")
    public void i_should_be_presented_with_the_main_page() {
        String URL_Main_Page = driver.getCurrentUrl();
        Assert.assertEquals(URL_Main_Page, "https://www.saucedemo.com/inventory.html");
    }

    @Then("I am presented with a wrong credentials error message")
    public void i_am_presented_with_a_wrong_credentials_error_message() {
        WebElement error_message = driver.findElement(By.className("error-message-container"));
        Assert.assertEquals(error_message.getText(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Then("I am presented with a empty fields error message")
    public void i_am_presented_with_a_empty_fields_error_message() {
        WebElement error_message = driver.findElement(By.className("error-message-container"));
        Assert.assertEquals(error_message.getText(), "Epic sadface: Username is required");
    }

    @Then("I should be able to click on the error message close button")
    public void i_should_be_able_to_click_on_the_error_message_close_button() {
        WebElement error_button = driver.findElement(By.className("error-button"));
        this.waitForWebElementAndClick(error_button);
    }

    @When("I enter a blocked username")
    public void i_enter_a_blocked_username() {
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("locked_out_user");
    }

    @And("I enter the correct password")
    public void i_enter_the_correct_password() {
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
    }

    @And("I am presented with a blocked user error message")
    public void i_am_presented_with_a_blocked_user_error_message() {
        WebElement error_message = driver.findElement(By.className("error-message-container"));
        Assert.assertEquals(error_message.getText(), "Epic sadface: Sorry, this user has been locked out.");
    }
}
