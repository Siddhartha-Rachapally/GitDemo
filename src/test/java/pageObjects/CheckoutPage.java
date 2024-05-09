package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    By cartBag = By.cssSelector("img[alt='Cart']");
    By checkOutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
    By promoBtn = By.cssSelector(".promoBtn");
    By placeOrder = By.xpath("//button[contains(text(),'Place Order')]");
    By productNameCart = By.cssSelector(".product-name");

    WebDriver driver;
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void CheckoutItems(){
        driver.findElement(cartBag).click();
        driver.findElement(checkOutButton).click();
    }

    public Boolean VerifyPromoBtn(){
        return driver.findElement(promoBtn).isDisplayed();
    }

    public Boolean VerifyPlaceOrder(){
        return driver.findElement(placeOrder).isDisplayed();
    }

    public String getProductNameCart(){
        return driver.findElement(productNameCart).getText();
    }


}
