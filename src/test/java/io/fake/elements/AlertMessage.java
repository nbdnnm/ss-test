package io.fake.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AlertMessage {

    public SelenideElement getAlertMessage() {
        return $x("//div[@id='alert_dv']");
    }
}
