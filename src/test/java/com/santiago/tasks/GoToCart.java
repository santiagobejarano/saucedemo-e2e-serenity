package com.santiago.tasks;

import com.santiago.userinterfaces.ProductsPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class GoToCart {
    public static Performable now() {
        return Task.where("{0} goes to the cart",
                Click.on(ProductsPage.CART_ICON)
        );
    }
}
