package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FoundResultsPage extends BasePage{


    private final By SORT_BUTTON = By.cssSelector("[data-testid=sorters-dropdown-trigger]");
    private final By HOTEL_TITLE = By.cssSelector("[data-testid=title]");
    private final By HOTEL_RATING = By.xpath("//div[@data-testid='review-score']/div");


    public FoundResultsPage(WebDriver driver) {
        super(driver);
    }



    public String getHotelName(){
        return  driver.findElement(HOTEL_TITLE).getText();


    }

    public String getHotelRating(){
        return driver.findElement(HOTEL_RATING).getText();

    }

}
