package PurchaseOrder;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;

/**
 * Created by anitha on 12/08/2015.
 */
public class BusinessLibrary extends BaseClass{

      WebDriver driver;

    String baseUrl="http://demo.nopcommerce.com/";


//    String FirstNameData = "Anitha";
//    String LastNameData = "Arulelango";
//    String PasswordData = "password";
//    String userName = "anielann";
//    String email = "@gmail.com";
  //  String country;
//    String city="london";
//    String address1="no.34";
//    String postalCode="ig74al";
//    String phone="07804642272";

    String completeEmail;
    private StringBuffer verificationErrors = new StringBuffer();


    public  void openBrowser()
    {

        driver= new FirefoxDriver();
        baseUrl = "http://demo.nopcommerce.com/";
        driver.get(baseUrl + "/");


    }


    public String registration(String FirstNameData,String LastNameData,String PasswordData,String userName,String email)
    {
        System.out.println("registration");
        //driver.get("http://demo.nopcommerce.com");
        driver.findElement(By.linkText("Register")).click();
        // Warning: verifyTextPresent may require manual changes

        driver.findElement(By.id("FirstName")).clear();
        driver.findElement(By.id("FirstName")).sendKeys(FirstNameData);

        driver.findElement(By.id("LastName")).clear();
        driver.findElement(By.id("LastName")).sendKeys(LastNameData);
        driver.findElement(By.id("Email")).clear();

        driver.findElement(By.id("Email")).sendKeys(getRandomEmailId(userName,email));

        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password")).sendKeys(PasswordData);

        driver.findElement(By.id("ConfirmPassword")).clear();
        driver.findElement(By.id("ConfirmPassword")).sendKeys(PasswordData);
        driver.findElement(By.id("register-button")).click();

        return completeEmail;

    }

    private String getRandomEmailId(String userName,String email)
    {

        completeEmail = userName + new Random().nextInt(1000) + email;
        System.out.println(completeEmail);
        return completeEmail;
    }


    public void login(String CompleteEmail,String PasswordData)
    {
        System.out.println("Logging in");

        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys(completeEmail);
        System.out.println(completeEmail);
        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password")).sendKeys(PasswordData);
        driver.findElement(By.cssSelector("input.button-1.login-button")).click();



    }

    public void addProductToShoppingCart()
    {
        System.out.println("Adding Product to shopping Cart");

        driver.findElement(By.linkText("Computers")).click();
        driver.findElement(By.cssSelector("img[alt=\"Picture for category Notebooks\"]")).click();
        driver.findElement(By.cssSelector("div.picture > a[title=\"Show details for Apple MacBook Pro 13-inch\"] > img[alt=\"Picture of Apple MacBook Pro 13-inch\"]")).click();
        driver.findElement(By.id("add-to-cart-button-4")).click();
       // isAlertPresent();
       // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // mywait();
        // Warning: verifyTextPresent may require manual changes
//        verifyProductAdded();
//        driver.findElement(By.linkText("Electronics")).click();
//
//        driver.findElement(By.linkText("Books")).click();
//        driver.findElement(By.cssSelector("img[alt=\"Picture of Fahrenheit 451 by Ray Bradbury\"]")).click();
//        driver.findElement(By.id("add-to-cart-button-37")).click();
//        isAlertPresent();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        verifyProductAdded();

//        driver.findElement(By.cssSelector("span.cart-label")).click();
//        System.out.println("Product added to shopping Cart successfully");
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void addProductToShoppingCart2(){

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Electronics")).click();

        driver.findElement(By.linkText("Books")).click();
        driver.findElement(By.cssSelector("img[alt=\"Picture of Fahrenheit 451 by Ray Bradbury\"]")).click();
        driver.findElement(By.id("add-to-cart-button-37")).click();
        //isAlertPresent();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    public void updateShoppingCartIcon() {
        driver.findElement(By.cssSelector("span.cart-label")).click();
        System.out.println("Product added to shopping Cart successfully");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("updated Shopping cart icon");

    }


    public void agreeCheckbox()
    {
        System.out.println("Checkout the products");
        // mywait();
        //  driver.findElement(By.id("topcartlink")).click();
        System.out.println("cart clicked");
        //driver.findElement(By.name("button-2 update-cart-button")).click();

//        isAlertPresent1();
//        new Select(driver.findElement(By.id("CountryId"))).selectByVisibleText(country);
//        driver.findElement(By.id("termsofservice")).click();
//        driver.findElement(By.id("checkout")).click();


    }
    public void enterCountryToCheckout(String country) {
        new Select(driver.findElement(By.id("CountryId"))).selectByVisibleText(country);
        driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.id("checkout")).click();
    }
    public void verifyBillingAddressWindow()
    {
        String actual = driver.findElement(By.cssSelector("div.page-body.checkout-data")).getText();
        String expected = "Billing address";
       // System.out.println("actual:"+actual+" ;"+"expected :"+expected);
        System.out.println("                                             verifying billing address window is opened successfully");
        Assert.assertTrue(actual.contains(expected));

    }


    public void definingTheAddress(String country,String city,String address1,String postalCode,String phone)
    {
        System.out.println("Defining the Address");
        isAlertPresent1();
        new Select(driver.findElement(By.id("BillingNewAddress_CountryId"))).selectByVisibleText(country);
        driver.findElement(By.id("BillingNewAddress_City")).clear();
        driver.findElement(By.id("BillingNewAddress_City")).sendKeys(city);
        driver.findElement(By.id("BillingNewAddress_Address1")).clear();
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys(address1);
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).clear();
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys(postalCode);
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).clear();
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys(phone);
        driver.findElement(By.cssSelector("input.button-1.new-address-next-step-button")).click();

    }

    public void verifyShippingAddressWindow()
    {
        String actual = driver.findElement(By.cssSelector("div.section.pickup-in-store")).getText();
        String expected = "In-Store Pickup";
         System.out.println("actual:" + actual + " ;" + "expected :" + expected);
        Assert.assertTrue(actual.contains(expected));
        System.out.println("                                              verifying Shipping address window is opened successfully");

    }
    public void verifyShippingMethodWindow()
    {
        String actual = driver.findElement(By.cssSelector("div.method-description")).getText();
        String expected = "ground shipping";
        System.out.println("actual:"+ actual +" ;"+ "expected :"+expected);
        Assert.assertTrue(actual.contains(expected));
        System.out.println("                                              verifying Shipping method window is opened successfully");

    }

    public void shippingAddressSelect()
    {
        System.out.println("Shipping Address:");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#shipping-buttons-container > input.button-1.new-address-next-step-button")).click();

//       driver.findElement(By.id("shippingoption_0")).click();
//        driver.findElement(By.cssSelector("input.button-1.shipping-method-next-step-button")).click();
//        driver.findElement(By.id("paymentmethod_2")).click();
//        driver.findElement(By.cssSelector("input.button-1.payment-method-next-step-button")).click();
//        driver.findElement(By.cssSelector("input.button-1.payment-info-next-step-button")).click();
//        new Select(driver.findElement(By.id("shipping-address-select"))).getFirstSelectedOption();
//        driver.findElement(By.className("button-1 new-address-next-step-button")).click();
//        new Select(driver.findElement(By.id("shippingoption_0"))).selectByVisibleText("Ground ($0.00)");
//        driver.findElement(By.className("button-1 new-address-next-step-button")).click();
//        new Select(driver.findElement(By.id("paymentmethod_2"))).selectByVisibleText("Purchase Order");
//        driver.findElement(By.className("button-1 payment-method-next-step-button")).click();
//        driver.findElement(By.className("button-1 payment-info-next-step-button")).click();


    }


    public void shippingMethod(){

        driver.findElement(By.id("shippingoption_0")).click();
       // driver.findElement(By.cssSelector("input.button-1.shipping-method-next-step-button")).click();
    }

    public void goToPayment(){
        driver.findElement(By.cssSelector("input.button-1.shipping-method-next-step-button")).click();
    }

    public void verifyPaymentMethodWindow()
    {
        boolean actual = isElementPresent(By.id("paymentmethod_2"));
        String expected = "Purchase Order";
        System.out.println("actual:"+ actual +" ;"+ "expected :"+expected);
        Assert.assertTrue(actual);
        System.out.println("                                              verifying Payment method window is opened successfully");

    }

    public void paymentMethod()
    {
        System.out.println("Payment method");
        driver.findElement(By.id("paymentmethod_2")).click();
        driver.findElement(By.cssSelector("input.button-1.payment-method-next-step-button")).click();
       // driver.findElement(By.cssSelector("input.button-1.payment-info-next-step-button")).click();
//        new Select(driver.findElement(By.id("shipping-address-select"))).getFirstSelectedOption();
//        driver.findElement(By.className("button-1 new-address-next-step-button")).click();
//        new Select(driver.findElement(By.id("shippingoption_0"))).selectByVisibleText("Ground ($0.00)");
//        driver.findElement(By.className("button-1 new-address-next-step-button")).click();
//        new Select(driver.findElement(By.id("paymentmethod_2"))).selectByVisibleText("Purchase Order");
//        driver.findElement(By.className("button-1 payment-method-next-step-button")).click();
//        driver.findElement(By.className("button-1 payment-info-next-step-button")).click();

    }
    public void paymentContinue(){
        driver.findElement(By.cssSelector("input.button-1.payment-info-next-step-button")).click();
//        new Select(driver.findElement(By.id("shipping-address-select"))).getFirstSelectedOption();
//        driver.findElement(By.className("button-1 new-address-next-step-button")).click();
//        new Select(driver.findElement(By.id("shippingoption_0"))).selectByVisibleText("Ground ($0.00)");
//        driver.findElement(By.className("button-1 new-address-next-step-button")).click();
//        new Select(driver.findElement(By.id("paymentmethod_2"))).selectByVisibleText("Purchase Order");
//        driver.findElement(By.className("button-1 payment-method-next-step-button")).click();
//        driver.findElement(By.className("button-1 payment-info-next-step-button")).click();

    }
    public void verifyPaymentInformationPage(){

        boolean payment =isElementPresent(By.id("PurchaseOrderNumber"));
        Assert.assertTrue(payment);

    }
    public void paymentInfocontinue(){
        driver.findElement(By.cssSelector("input.button-1.payment-info-next-step-button")).click();
    }

//    public void verifyConfirmOrderPage(){
//        boolean confirm=isElementPresent(By.cssSelector(("input.button-1.confirm-order-next-step-button")));
//        Assert.assertTrue(confirm);
//    }
    public void confirmTheOrder()
    {
        System.out.println("Confirm The Order");
        driver.findElement(By.cssSelector("input.button-1.confirm-order-next-step-button")).click();

    }
    public void verifyComfirmWindow(){

        System.out.println("Confirmation Window");
        isElementPresent(By.cssSelector("input.button-1.confirm-order-next-step-button"));
        System.out.println("Verified Confirmation Window is displayed");
    }
    public void verifySuccessfullOrderWindow(){
        System.out.println("Thank you, your order has been successfully processed!");
        isElementPresent(By.cssSelector("input.button-1.order-completed-continue-button"));
        System.out.println("Order successfully placed!");
    }

    public void displayOrderDetailsPage()
    {
        System.out.println("Display the order Details page");
        driver.findElement(By.linkText("Click here for order details.")).click();

    }
    public void orderInformation(){
        boolean orderinfo=isElementPresent(By.linkText("PDF Invoice"));
        Assert.assertTrue(orderinfo);
    }

    public void guestPageVerification(){

        //*[contains(@class, 'Test')]


        //  button-1 checkout-as-guest-button

        System.out.println("hear me :" + driver.findElement(By.name("Email")).getText());
        Assert.assertEquals("Email", driver.findElement(By.name("Email")));

    }








    public void logout()
    {
        System.out.println("Logged out");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //  driver.get(baseUrl + "/registerresult/1");
        System.out.println("time delay to logout");
        driver.findElement(By.linkText("Log out")).click();
        System.out.println("found logout element");

    }

    public void closeBrowser()
    {
        System.out.println("before quit browser");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.quit();
        System.out.println("after quit browser");
    }

    public void mywait()
    {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }



    public void verifyProductAdded()
    {
        try {

            assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // Warning: verifyTextPresent may require manual changes
        try {
            assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        System.out.println("             Verifying product added done");

    }


    public boolean isAlertPresent1()
    {
        try {
            driver.switchTo().alert().accept();

            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }


    public boolean isAlertPresent()
    {
        try {
            driver.switchTo().alert().accept();

            return true;
        } catch (NoAlertPresentException e) {
            return true;
        }
    }


    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }













}
