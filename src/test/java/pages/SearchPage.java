package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class  SearchPage extends BasePage {

    private final By SEARCH_INPUT = By.cssSelector("[name=ss]");
    private final By SEARCH_BUTTON = By.cssSelector("[type=submit]");


    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void open(){
        driver.get(BASE_URL + "/searchresults.html");
    }

    public void searchForCity(String city){
        driver.findElement(SEARCH_INPUT).sendKeys(city);
        driver.findElement(SEARCH_BUTTON).click();
    }

}
