package com.santiago.tasks;

import com.santiago.userinterfaces.CartPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class GoToCheckout {
    public static Performable now() {
        return Task.where("{0} goes to checkout",
                Click.on(CartPage.CHECKOUT_BUTTON)
        );
    }
}
