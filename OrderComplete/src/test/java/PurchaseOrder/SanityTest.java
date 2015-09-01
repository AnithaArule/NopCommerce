package PurchaseOrder;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by anitha on 12/08/2015.
 */
public class SanityTest
{

    BusinessLibrary library = new BusinessLibrary();


    String FirstNameData = "Anitha";
    String LastNameData = "Arulelango";

    String PasswordData = "password";
    String userName = "anielann";
    String email = "@gmail.com";
    String country="United Kingdom";
    String city="london";
    String address1="no.34";
    String postalCode="ig74al";
    String phone="07804642272";
    String completeEmail;
//    static WebDriver driver;


//    @BeforeClass
//            public static openTheBrowser() {
//
//            String baseUrl;
//            driver = new FirefoxDriver();
//            baseUrl = "http://demo.nopcommerce.com/";
//            driver.get(baseUrl + "/");
//
//
//
//
//    }


    @Before
    public void setup()
    {

        library.openBrowser();

        String completeEmail= library.registration(FirstNameData,LastNameData,PasswordData,userName,email);
        library.logout();
        library.login(completeEmail,PasswordData);


    }


    @Test
    public void testProductAddedToShoppingCart()
    {

        library.addProductToShoppingCart();
        library.isAlertPresent();
        library.verifyProductAdded();
        library.addProductToShoppingCart2();
        library.isAlertPresent();
        library.verifyProductAdded();
        library.updateShoppingCartIcon();
        library.agreeCheckbox();
        library.isAlertPresent1();
        library.enterCountryToCheckout(country);
        //Verify product added to shopping cart successfully
        library.verifyBillingAddressWindow();
    }

    @Test
    public void testAddressDefinedSuccessfully()
    {

        library.addProductToShoppingCart();
        library.agreeCheckbox();
        library.isAlertPresent1();
        library.enterCountryToCheckout(country);
        //Verify product added to shopping cart successfully
        library.verifyBillingAddressWindow();
        library.definingTheAddress(country,city,address1,postalCode,phone);
        library.verifyShippingAddressWindow();
    }
    //Verify Defining the address Successfully




    @Test
    public void defineShippingmethod()
    {
        library.agreeCheckbox();
        library.isAlertPresent1();
        library.enterCountryToCheckout(country);
        //Verify product added to shopping cart successfully
        library.verifyBillingAddressWindow();
        library.definingTheAddress(country,city,address1,postalCode,phone);
        library.shippingAddressSelect();
        library.verifyShippingMethodWindow();


    }

    @Test
    public void definePaymentMethod(){
        library.agreeCheckbox();
        library.isAlertPresent1();
        library.enterCountryToCheckout(country);
        //Verify product added to shopping cart successfully
        library.verifyBillingAddressWindow();
        library.definingTheAddress(country, city, address1, postalCode, phone);
        library.shippingAddressSelect();
        library.shippingMethod();
        library.goToPayment();
        library.verifyPaymentMethodWindow();
        library.paymentMethod();
        library.paymentContinue();
        library.verifyPaymentInformationPage();



    }

    @Test
    public void confirmOrderPage(){
        library.agreeCheckbox();
        library.isAlertPresent1();
        library.enterCountryToCheckout(country);
        //Verify product added to shopping cart successfully
        library.verifyBillingAddressWindow();
        library.definingTheAddress(country,city,address1,postalCode,phone);
        library.shippingMethod();
        library.goToPayment();
        library.paymentMethod();
        library.paymentContinue();
        library.paymentInfocontinue();
      //  library.verifyConfirmOrderPage();
        library.confirmTheOrder();
        library.verifyComfirmWindow();

    }


    @Test
    public void testCompletePurchaseProcess()
    {

        library.agreeCheckbox();
        library.isAlertPresent1();
        library.enterCountryToCheckout(country);
        //Verify product added to shopping cart successfully
        library.verifyBillingAddressWindow();
        library.definingTheAddress(country,city,address1,postalCode,phone);
        library.shippingMethod();
        library.goToPayment();
        library.paymentMethod();
        library.confirmTheOrder();
        library.verifySuccessfullOrderWindow();
        library.displayOrderDetailsPage();
        library.orderInformation();
        //test product ordered successfully
    }


    @After
    public void tearDown() throws Exception
    {
        library.logout();
        library.closeBrowser();


    }


//    @AfterClass
//    public void quit(){
//        library.closeBrowser();
//    }


}
