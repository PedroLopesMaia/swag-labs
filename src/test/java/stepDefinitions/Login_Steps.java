package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.Base_PO;

public class Login_Steps extends Base_PO {

    private WebDriver driver = getDriver();

    @Given("I access the login page")
    public void i_access_the_login_page() {
        navigateTo_URL("https://www.saucedemo.com/");
    }
    @When("I enter the correct username")
    public void i_enter_the_correct_username() {
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
    }
    @When("I enter the correct password")
    public void i_enter_the_correct_password() {
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
    }
    @When("I click the login button")
    public void i_click_the_login_button() {
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }
    @Then("I should be presented with the main page")
    public void i_should_be_presented_with_the_main_page() {
        String URL_Main_Page = driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", URL_Main_Page);
    }


}
