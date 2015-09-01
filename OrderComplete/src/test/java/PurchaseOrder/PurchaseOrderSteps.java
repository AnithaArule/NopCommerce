package PurchaseOrder;

import com.sun.jna.Library;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.After;
import cucumber.api.java.Before;
//import org.junit.After;
//import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by anitha on 13/08/2015.
 */


public class PurchaseOrderSteps {


    String FirstNameData = "Anitha";
    String LastNameData = "Arulelango";
    String PasswordData = "password";
    String userName = "anielann";
    String email = "@gmail.com";
    String country = "United Kingdom";
    String city = "london";
    String address1 = "no.34";
    String postalCode = "ig74al";
    String phone = "07804642272";
    String completeEmail;
    BusinessLibrary library = new BusinessLibrary();

    @cucumber.api.java.Before
    public void setup() {


        library.openBrowser();


    }


    @Given("^the Customer is Registered$")
    public String the_Customer_is_Registered() throws Throwable {
        //library.openBrowser();
        completeEmail = library.registration(FirstNameData, LastNameData, PasswordData, userName, email);
        return completeEmail;

    }


    @Given("^the Customer is logged out$")
    public void the_Customer_is_logged_out() throws Throwable {
        library.logout();

    }

    @Given("^the Customer is logged in$")
    public void the_Customer_is_logged_in() throws Throwable {
        library.login(completeEmail, PasswordData);

    }

    @When("^the Customer attempts to add an item to the shopping cart$")
    public void the_Customer_attempts_to_add_an_item_to_the_shopping_cart() throws Throwable {
        library.addProductToShoppingCart();
        library.isAlertPresent();
        library.verifyProductAdded();
        library.addProductToShoppingCart2();
        library.isAlertPresent();
        library.verifyProductAdded();

    }


    @Then("^the Customer should be able to view the items in the shopping Cart$")
    public void the_Customer_should_be_able_to_view_the_items_in_the_shopping_Cart() throws Throwable {
        library.updateShoppingCartIcon();
        // Write code here that turns the phrase above into concrete actions

    }

    @cucumber.api.java.After
    public void tear_Down() {
        library.logout();
        library.closeBrowser();
    }


    @Given("^the Customer is in shopping cart page$")
    public void the_Customer_is_in_shopping_cart_page() throws Throwable {


        completeEmail = library.registration(FirstNameData, LastNameData, PasswordData, userName, email);
        library.logout();
        library.login(completeEmail, PasswordData);
        library.addProductToShoppingCart();
        library.isAlertPresent();
        library.verifyProductAdded();
        library.addProductToShoppingCart2();
        library.isAlertPresent();
        library.verifyProductAdded();
        library.updateShoppingCartIcon();

    }

    @When("^the Customer attempts the checkbox$")
    public void the_Customer_attempts_the_checkbox_and_Customer_attempts_to_checkout() throws Throwable {

        library.agreeCheckbox();
        library.isAlertPresent();


    }

    @When("^Customer attempts to checkout$")
    public void customer_attempts_to_checkout() throws Throwable {
        library.enterCountryToCheckout(country);

    }

    @Then("^the Customer should be able to view the billing address window$")
    public void the_Customer_should_be_able_to_view_the_billing_address_window() throws Throwable {
        library.verifyBillingAddressWindow();

    }

    @Given("^the Customer is in billing address page$")
    public void the_Customer_is_in_billing_address_page() throws Throwable {
        completeEmail = library.registration(FirstNameData, LastNameData, PasswordData, userName, email);
        library.logout();
        library.login(completeEmail, PasswordData);
        library.addProductToShoppingCart();
        library.isAlertPresent();
        library.verifyProductAdded();
        library.addProductToShoppingCart2();
        library.isAlertPresent();
        library.verifyProductAdded();
        library.updateShoppingCartIcon();
        library.agreeCheckbox();
        library.isAlertPresent();
        library.enterCountryToCheckout(country);
        library.verifyBillingAddressWindow();

    }

    @When("^the Customer attempts to enter the billing options using billing address drop down list or attempts to create new billing address in the relevant field, and attempts to continue,$")
    public void the_Customer_attempts_to_enter_the_billing_options_using_billing_address_drop_down_list_or_attempts_to_create_new_billing_address_in_the_relevant_field_and_attempts_to_continue() throws Throwable {
        library.definingTheAddress(country, city, address1, postalCode, phone);

    }

    @Then("^the Customer should be able to view the shipping address window\\.$")
    public void the_Customer_should_be_able_to_view_the_shipping_address_window() throws Throwable {
        library.verifyShippingAddressWindow();
    }

    @Given("^the Customer is in Shippong address page$")
    public void the_Customer_is_in_Shippong_address_page() throws Throwable {
        completeEmail = library.registration(FirstNameData, LastNameData, PasswordData, userName, email);
        library.logout();
        library.login(completeEmail, PasswordData);
        library.addProductToShoppingCart();
        library.isAlertPresent();
        library.verifyProductAdded();
        library.addProductToShoppingCart2();
        library.isAlertPresent();
        library.verifyProductAdded();
        library.updateShoppingCartIcon();
        library.agreeCheckbox();
        library.isAlertPresent();
        library.enterCountryToCheckout(country);
        //library.verifyBillingAddressWindow();
        library.definingTheAddress(country, city, address1, postalCode, phone);
        // library.verifyShippingAddressWindow();

    }


    @When("^the Customer attempts to choose the required shipping address details or attempts to create a new shipping address using the Select shipping address drop down list, and attempts to continue,$")
    public void the_Customer_attempts_to_choose_the_required_shipping_address_details_or_attempts_to_create_a_new_shipping_address_using_the_Select_shipping_address_drop_down_list_and_attempts_to_continue() throws Throwable {
        library.shippingAddressSelect();
        //In this case, we are using the billing address as shipping address
    }

    @Then("^the Customer should be able to view the shipping Method window\\.$")
    public void the_Customer_should_be_able_to_view_the_shipping_Method_window() throws Throwable {
        library.verifyShippingMethodWindow();
        // in this case, we are choosing shipping method window as ground
    }


    @Given("^the Customer is in shipping method page$")
    public void the_Customer_is_in_shipping_method_page() throws Throwable {
        completeEmail = library.registration(FirstNameData, LastNameData, PasswordData, userName, email);
        library.logout();
        library.login(completeEmail, PasswordData);
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
        library.definingTheAddress(country, city, address1, postalCode, phone);
        library.shippingAddressSelect();

    }

    @When("^the Customer attempts to choose one of the options \\(either In-store Pickup or By Ground or By Air\\),$")
    public void the_Customer_attempts_to_choose_one_of_the_options_either_In_store_Pickup_or_By_Ground_or_By_Air() throws Throwable {
        library.shippingMethod();
    }

    @When("^the Customer Attempts to Continue,$")
    public void the_Customer_Attempts_to_Continue() throws Throwable {
        library.goToPayment();
    }

    @Then("^the Customer should be able to view the Payment Method window\\.$")
    public void the_Customer_should_be_able_to_view_the_Payment_Method_window() throws Throwable {
        library.verifyPaymentMethodWindow();
    }


    @Given("^the Customer is in payment method page$")
    public void the_Customer_is_in_payment_method_page() throws Throwable {
        completeEmail = library.registration(FirstNameData, LastNameData, PasswordData, userName, email);
        library.logout();
        library.login(completeEmail, PasswordData);
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
        library.definingTheAddress(country, city, address1, postalCode, phone);
        library.shippingAddressSelect();
        library.shippingMethod();
        library.goToPayment();

    }

    @Given("^the Customer has reward points to use,$")
    public void the_Customer_has_reward_points_to_use() throws Throwable {

    }

    @When("^the Customer attempts to Use my reward points,$")
    public void the_Customer_attempts_to_Use_my_reward_points() throws Throwable {

    }

    @When("^the Customer attempts to choose the payment method \\(Cash on Delivery, or Check/Money Order or Credit Card or Purchase Order or Pay in Store\\),$")
    public void the_Customer_attempts_to_choose_the_payment_method_Cash_on_Delivery_or_Check_Money_Order_or_Credit_Card_or_Purchase_Order_or_Pay_in_Store() throws Throwable {
        library.paymentMethod();
    }

    @When("^the Customer attempts to continue1,$")
    public void the_Customer_attempts_to_continue1() throws Throwable {
        library.paymentContinue();
    }

    @Then("^the Customer should be able to view Payment Information Window\\.$")
    public void the_Customer_should_be_able_to_view_Payment_Information_Window() throws Throwable {
        library.verifyPaymentInformationPage();
    }

    @Given("^the Customer is in payment information page$")
    public void the_Customer_is_in_payment_information_page() throws Throwable {
        completeEmail = library.registration(FirstNameData, LastNameData, PasswordData, userName, email);
        library.logout();
        library.login(completeEmail, PasswordData);
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
        library.definingTheAddress(country, city, address1, postalCode, phone);
        library.shippingAddressSelect();
        library.shippingMethod();
        library.goToPayment();
        library.paymentMethod();
        library.paymentContinue();
    }

    @When("^the Customer enters Valid Payment Information,$")
    public void the_Customer_enters_Valid_Payment_Information() throws Throwable {
        // In this case, no data is given since purchase order is selected
    }

    @When("^the Customer attempts to Continue3$")
    public void the_Customer_attempts_to_Continue() throws Throwable {
       library.paymentInfocontinue();
    }

    @Then("^the Customer should be able to view the Confirmation window\\.$")
    public void the_Customer_should_be_able_to_view_the_Confirmation_window() throws Throwable {
        library.verifyComfirmWindow();
    }


    @Given("^the Customer is in confirmation page$")
    public void the_Customer_is_in_confirmation_page() throws Throwable {
        completeEmail = library.registration(FirstNameData, LastNameData, PasswordData, userName, email);
        library.logout();
        library.login(completeEmail, PasswordData);
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
        library.definingTheAddress(country, city, address1, postalCode, phone);
        library.shippingAddressSelect();
        library.shippingMethod();
        library.goToPayment();
        library.paymentMethod();
        library.paymentContinue();
        library.paymentInfocontinue();
    }

    @When("^the Customer Attempts to Confirm,$")
    public void the_Customer_Attempts_to_Confirm() throws Throwable {
        library.confirmTheOrder();
    }

    @Then("^the Customer should be able to view the the window showing your order has been Successfully placed\\.$")
    public void the_Customer_should_be_able_to_view_the_the_window_showing_your_order_has_been_Successfully_placed() throws Throwable {
       library.verifySuccessfullOrderWindow();
    }


    @Given("^the Customer is in order successfully placed page$")
    public void the_Customer_is_in_order_successfully_placed_page() throws Throwable {
        completeEmail = library.registration(FirstNameData, LastNameData, PasswordData, userName, email);
        library.logout();
        library.login(completeEmail, PasswordData);
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
        library.definingTheAddress(country, city, address1, postalCode, phone);
        library.shippingAddressSelect();
        library.shippingMethod();
        library.goToPayment();
        library.paymentMethod();
        library.paymentContinue();
        library.paymentInfocontinue();
        library.confirmTheOrder();
    }

    @When("^the Customer  attempts order details,$")
    public void the_Customer_attempts_to_continue() throws Throwable {
        library.displayOrderDetailsPage();

    }

    @Then("^the Customer should be able to view the order information$")
    public void the_Customer_should_be_able_to_view_the_order_information() throws Throwable {
       library.orderInformation();
    }

}