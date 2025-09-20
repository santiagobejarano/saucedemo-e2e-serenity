package com.santiago.glue;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.santiago.questions.ConfirmationMessage;
import com.santiago.tasks.*;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class PurchaseStepDefinitions {

    @Managed
    WebDriver driver;

    Actor user = Actor.named("User");

    @Given("User opens the SauceDemo login page")
    public void openLogin() {
        user.can(BrowseTheWeb.with(driver));
        user.wasAbleTo(OpenLoginPage.at("https://www.saucedemo.com/"));
    }

    @When("he logs in with user {string} and password {string}")
    public void login(String username, String password) {
        user.attemptsTo(Login.withCredentials(username, password));
    }

    @When("he adds products from json {string}")
    public void addProductsFromJson(String jsonPath) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, List<String>> data = mapper.readValue(
                new File("src/test/resources/" + jsonPath),
                new TypeReference<Map<String, List<String>>>() {}
        );
        user.attemptsTo(AddProducts.named(data.get("products")));
    }

    @When("he goes to the cart")
    public void goToCart() {
        user.attemptsTo(GoToCart.now());
    }

    @When("he proceeds to checkout")
    public void goToCheckout() {
        user.attemptsTo(GoToCheckout.now());
    }

    @When("he completes checkout using data from {string}")
    public void completeCheckout(String filePath) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> json = mapper.readValue(
                new File("src/test/resources/" + filePath),
                new TypeReference<Map<String, String>>() {}
        );

        user.attemptsTo(Checkout.with(
                json.get("firstName"),
                json.get("lastName"),
                json.get("postalCode")
        ));
    }

    @Then("he should see the confirmation message {string}")
    public void verifyMessage(String expectedMessage) {
        user.should(seeThat("confirmation message",
                ConfirmationMessage.text().map(actual ->
                        actual.replaceAll("[^a-zA-Z0-9 ]", "")  // quitar signos
                                .toLowerCase().trim()
                ),
                Matchers.equalTo(
                        expectedMessage.replaceAll("[^a-zA-Z0-9 ]", "")
                                .toLowerCase().trim()
                )
        ));
    }
}
