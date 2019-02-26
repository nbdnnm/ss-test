package io.fake.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.url;

public class AdvertisementPage {

    public AdvertisementPage addToFavourites() {
        $x("//a[@id='a_fav']").click();
        return this;
    }

    public SelenideElement getAlertMessage() {
        return $x("//div[@id='alert_dv']");
    }

    public String getAdvertisementLink() {
        return url();
    }

}
