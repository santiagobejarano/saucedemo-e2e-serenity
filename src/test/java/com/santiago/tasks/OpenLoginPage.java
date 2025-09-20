package com.santiago.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class OpenLoginPage {
    public static Performable at(String url) {
        return Task.where("{0} opens the login page",
                Open.url(url)
        );
    }
}
