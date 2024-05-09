package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

public class OfferPageStepDefinition {
    public WebDriver driver;
    public String landingPageProductName;
    public String offerPageProductName;
    TestContextSetup testContextSetup;
    PageObjectManager pageObjectManager;

    //Single Responsibility Principle
    //loosly coupled
    public OfferPageStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }


    @Then("^user searched for (.+) shortname in offers page$")
    public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exists(String shortName) throws InterruptedException {
        switchToOffersPage();
        OffersPage offerPage = new OffersPage(testContextSetup.driver);
        offerPage.searchItem(shortName);
        Thread.sleep(2000);
        offerPageProductName = offerPage.getProductName();
    }

    public void switchToOffersPage(){
        //If switched to offer page -> skip below part
        //if(testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers")){}
        //pageObjectManager = new PageObjectManager(testContextSetup.driver);
        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.selectTopDealsPage();
        testContextSetup.genericUtils.SwitchWindowToChild();
    }

    @Then("validate product name Offers page matched with Landing page")
    public void validate_product_name_in_Offers_page(){
        Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
    }
}
