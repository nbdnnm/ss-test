package io.fake.pages;

import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class SearchPage {

    public SearchResults searchByWord(String word) {
        $x("//input[@id='ptxt']").sendKeys(word + Keys.ENTER);
        return new SearchResults();
    }
}
