package io.fake;

import com.codeborne.selenide.Condition;
import io.fake.pages.AdvertisementPage;
import io.fake.pages.MainPage;
import io.fake.pages.MemoPage;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.Assert.assertTrue;

public class SSTest {

    @Before
    public void setUp() {
        open("https://www.ss.com/en");
        getWebDriver().manage().window().maximize();
    }

    @Test
    public void testFavoriteAlert() {
        addAdvertisementToFavorites("Vacancies", "Administrator", 1)
                .getAlertMessage()
                .shouldHave(Condition.matchesText("Advertisement added to favorites."));
    }

    @Test
    public void testFavoriteAdded() {
        AdvertisementPage advertisementPage = addAdvertisementToFavorites("Vacancies", "Administrator", 2);
        String advertisementLink = advertisementPage
                .getAdvertisementLink();
        MemoPage memos = new NavigationMenu().openMemo();
        assertTrue(memos.isThereMemoWithLink(advertisementLink));
    }

    private AdvertisementPage addAdvertisementToFavorites(String category, String subCategory, Integer advertisementNumber) {
        return new MainPage()
                .openCategoryPage(category)
                .openSubCategoryPage(subCategory)
                .openAdvertisement(advertisementNumber)
                .addToFavourites();
    }

}
