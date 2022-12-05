package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class MoneyTransferPage {

    private SelenideElement inputAmount = $("[data-test-id=amount] input");
    private SelenideElement inputFrom = $("[data-test-id=from] input");
    private SelenideElement replenButton = $("[data-test-id=action-transfer]");

    public DashboardPage replenishment(int amount, String cardNumber) {
        inputAmount.setValue(String.valueOf(amount));
        inputFrom.setValue(cardNumber);
        replenButton.click();
        return new DashboardPage();
    }
}