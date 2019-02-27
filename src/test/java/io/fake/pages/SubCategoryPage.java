package io.fake.pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.$$x;

public class SubCategoryPage {
    private final Logger logger = Logger.getLogger(SubCategoryPage.class.getName());

    public AdvertisementPage openAdvertisement(Integer number) {
        List<SelenideElement> advertisements = $$x("//a[@class='am']");

        try {
            advertisements.get(number - 1).click();
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }

        return new AdvertisementPage();
    }
}
