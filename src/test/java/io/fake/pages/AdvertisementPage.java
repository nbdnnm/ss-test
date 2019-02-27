package io.fake.pages;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.url;

public class AdvertisementPage {

    public AdvertisementPage addToFavourites() {
        $x("//a[@id='a_fav']").click();
        return this;
    }

    public String getAdvertisementLink() {
        return url();
    }

}
