package com.santiago.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ProductsPage {
    public static final Target CART_ICON =
            Target.the("cart icon").locatedBy("#shopping_cart_container");

    public static Target addButtonFor(String productName) {
        return Target.the("add to cart button for " + productName)
                .locatedBy("//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button");
    }
}
