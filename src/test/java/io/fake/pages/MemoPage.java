package io.fake.pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;

public class MemoPage {

    private static final String ADVERTISEMENT_NAMES_XPATH = "//form[@id='filter_frm']//tr/td[3]//a";

    public AdvertisementPage openAdvertisementFromMemoWithLink(String advertisenetLink) {
        $$x(ADVERTISEMENT_NAMES_XPATH)
                .stream()
                .filter(selenideElement -> advertisenetLink.contains(selenideElement.attr("href")))
                .findFirst()
                .ifPresent(SelenideElement::click);
        return new AdvertisementPage();
    }

    public boolean isThereMemoWithLink(String link) {
        List<String> links = $$x(ADVERTISEMENT_NAMES_XPATH)
                .stream()
                .map(selenideElement -> selenideElement.attr("href"))
                .collect(Collectors.toList());
        return links.stream().anyMatch(link::contains);
    }
}
