package com.santiago.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ConfirmationPage {
    public static final Target CONFIRMATION_MESSAGE =
            Target.the("confirmation message").locatedBy(".complete-header");
}
