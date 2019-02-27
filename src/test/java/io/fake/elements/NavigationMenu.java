package io.fake.elements;

import io.fake.pages.MemoPage;
import io.fake.pages.SearchPage;

import static com.codeborne.selenide.Selenide.$x;

public class NavigationMenu {

    public MemoPage openMemo() {
        $x("//a[@title='Memo']").click();
        return new MemoPage();
    }

    public SearchPage openSearch() {
        $x("//a[@title='Search announcements']").click();
        return new SearchPage();
    }
}
