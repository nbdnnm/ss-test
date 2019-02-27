package io.fake.pages;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SearchResults {

    public SearchResults selectAdvertisements(Integer numbersOfAdvertisement) {
        $$x("//td/input[@type='checkbox']").get(numbersOfAdvertisement).click();
        return this;
    }

    public SearchResults addToFavourites() {
        $x("//a[@id='a_fav_sel']").click();
        return this;
    }
}
