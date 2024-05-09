package stepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {
    public WebDriver driver;
    public String landingPageProductName;
    public String offerPageProductName;
    public CheckoutPage checkoutPage;
    public String productNameCart;
    TestContextSetup testContextSetup;
    //dependecy injection can be done by => Spring framework, EJB,   Cucumber JVM: PicoContainer
    public CheckoutPageStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        checkoutPage = testContextSetup.pageObjectManager.CheckoutPage();
    }

    @Then("verify user has ability to enter promo code and place the order")
    public void verify_User_Has_Ability_To_EnterPromoCode_And_Place_The_Order() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(checkoutPage.VerifyPromoBtn());
        Assert.assertTrue(checkoutPage.VerifyPlaceOrder());
    }


    @Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
    public void userProceedsToCheckoutAndValidateTheNameItemsInCheckoutPage(String name) throws InterruptedException {
        checkoutPage.CheckoutItems();
        testContextSetup.checkoutPageProductName = checkoutPage.getProductNameCart().split("-")[0].trim();
        Assert.assertEquals(testContextSetup.checkoutPageProductName, testContextSetup.landingPageProductName);
        System.out.println(testContextSetup.checkoutPageProductName);
    }
}
