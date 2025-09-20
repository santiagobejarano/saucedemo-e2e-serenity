package com.santiago.tasks;

import com.santiago.userinterfaces.ProductsPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;
import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddProducts {
    public static Performable named(List<String> products) {
        return Task.where("{0} adds products to the cart",
                actor -> {
                    for (String product : products) {
                        actor.attemptsTo(
                                WaitUntil.the(ProductsPage.addButtonFor(product), isVisible())
                                        .forNoMoreThan(Duration.ofSeconds(10)),
                                Click.on(ProductsPage.addButtonFor(product))
                        );
                    }
                }
        );
    }
}
