package com.santiago.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CartPage {
    public static final Target CHECKOUT_BUTTON =
            Target.the("checkout button").locatedBy("#checkout");
}
