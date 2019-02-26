package io.fake.pages;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;

public class MemoPage {

    public boolean isThereMemoWithLink(String link) {
        List<String> links = $$x("//form[@id='filter_frm']//tr/td[3]//a")
                .stream()
                .map(selenideElement -> selenideElement.attr("href"))
                .collect(Collectors.toList());

        return links.stream().anyMatch(link::contains);
    }
}
