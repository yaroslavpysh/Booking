package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.BasePage;
import pages.FoundResultsPage;
import pages.SearchPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class SearchSteps {
    WebDriver driver;
    SearchPage searchPage;
    BasePage basePage;
    FoundResultsPage foundResultsPage;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        searchPage = new SearchPage(driver);
        foundResultsPage = new FoundResultsPage(driver);
    }

    @Given("User is on the search page")
    public void userIsOnTheSearchPage() {
        searchPage.open();
    }

    @When("User searches for {string}")
    public void userSearchesFor(String city) {
        searchPage.searchForCity(city);
    }

    @Then("Hotel name is {string}")
    public void hotelNameIs(String expectedHotelName) {
        assertEquals(foundResultsPage.getHotelName(), expectedHotelName, "Hotel name is incorrect");

    }

    @And("Hotel rating is {string}")
    public void hotelRatingIs(String expectedHotelRating) {
        assertEquals(foundResultsPage.getHotelRating(), expectedHotelRating, "Hotel name is incorrect");
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}
