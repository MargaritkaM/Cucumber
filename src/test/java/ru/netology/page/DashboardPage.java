package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    // к сожалению, разработчики не дали нам удобного селектора, поэтому так
    private ElementsCollection cards = $$(".list__item div");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";

    private final SelenideElement heading = $("[data-test-id=dashboard]");


    public DashboardPage() {
        heading.shouldBe(visible);
    }

    public MoneyTransferPage replenishmentOpenV2 (String id) {
        cards.findBy(Condition.text(id)).find(".button").click();
        return new MoneyTransferPage();
    }
    public int getCardBalance() {
        val text = cards.first().text();
        return extractBalance(text);
    }

//
//    public int getCardBalance(String numberIdCard) {
//        val text =cards.findBy(text(numberIdCard)).find(".button").click();
//        return extractBalance(text);

//    public MoneyTransferPage replenishmentOpenV2(String numberIdCard) {
//        String cardBalance = cards.findBy(Condition.text(DataHelper.TransferCardInfo card().substring(16))).getText();
//        return new MoneyTransferPage();
//    }
//    public int getCardBalanceV2(String id) {
//        val text = cards.findBy(Condition.text(id)).text();
//        return extractBalance(text);
//    }

//   public int getFirstCardBalance(String id) {
//        return extractBalance(cards.first().text());
//    }
////
//   public int getSecondCardBalance(String id) {
//        return extractBalance(cards.last().text());
//    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

//    public void addMoneyToFirstCard() {
//        $("div[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']").$("button").click();
//    }
//
//    public void addMoneyToSecondCard() {
//        $("div[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']").$("button").click();
//    }
}
