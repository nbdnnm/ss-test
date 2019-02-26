package io.fake.pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;

public class SubCategoryPage {

    public AdvertisementPage openAdvertisement(Integer number) {
        List<SelenideElement> advertisements = $$x("//a[@class='am']");

        try {
            advertisements.get(number - 1).click();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new AdvertisementPage();
    }
}
