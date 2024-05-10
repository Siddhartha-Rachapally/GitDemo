package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjects.LandingPage;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

public class LandingPageStepDefinition {
    public WebDriver driver;
    public String landingPageProductName;
    public String offerPageProductName;
    TestContextSetup testContextSetup;
    LandingPage landingpage;
    //dependecy injection can be done by => Spring framework, EJB,   Cucumber JVM: PicoContainer
    public LandingPageStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        landingpage = testContextSetup.pageObjectManager.getLandingPage();
    }
    @Given("User is on GreenCart Landing Page")
    public void user_is_on_green_cart_landing_page() {
        Assert.assertTrue(landingpage.getTitleLandingPage().contains("GreenKart"));
    }
    @When("^user Searched with Shortname (.+) and extracted actual name of product$")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
        //testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
        landingpage.searchItem(shortName);

        Thread.sleep(2000);
        testContextSetup.landingPageProductName = landingpage.getProductName().split("-")[0].trim();
        System.out.println(testContextSetup.landingPageProductName + " extracted from home page");
        System.out.println("Iam in LandingPageStepDefinition");
        System.out.println("Iam in LandingPageStepDefinition1");
        System.out.println("Iam in LandingPageStepDefinition2");

        System.out.println("Iam in LandingPageStepDefinition4");
        System.out.println("Iam in LandingPageStepDefinition5");


        System.out.println("Iam in LandingPageStepDefinition4");
        System.out.println("Iam in LandingPageStepDefinition5");


    }


    @When("Added {string} items of the selected product to cart")
    public void addedItemsOfTheSelectedProductToCart(String quantity) {
        landingpage.incrementQuantity(Integer.parseInt(quantity));
        landingpage.addToCart();
    }
}
