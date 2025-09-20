package com.santiago.tasks;

import com.santiago.userinterfaces.CheckoutPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Checkout {
    public static Performable with(String firstName, String lastName, String postalCode) {
        return Task.where("{0} completes checkout",
                Enter.theValue(firstName).into(CheckoutPage.FIRST_NAME),
                Enter.theValue(lastName).into(CheckoutPage.LAST_NAME),
                Enter.theValue(postalCode).into(CheckoutPage.POSTAL_CODE),
                Click.on(CheckoutPage.CONTINUE_BUTTON),
                Click.on(CheckoutPage.FINISH_BUTTON)
        );
    }
}
