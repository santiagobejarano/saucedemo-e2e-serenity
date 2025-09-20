package com.santiago.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import com.santiago.userinterfaces.CheckoutPage;

public class ConfirmationMessage implements Question<String> {

    public static Question<String> text() {
        return new ConfirmationMessage();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(CheckoutPage.CONFIRMATION_MESSAGE).answeredBy(actor).trim();
    }
}
