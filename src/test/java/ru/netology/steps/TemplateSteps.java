package ru.netology.steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import ru.netology.data.DataHelper;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;
import ru.netology.page.MoneyTransferPage;
import ru.netology.page.VerificationPage;

import java.awt.*;

import static java.awt.SystemColor.info;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemplateSteps {
    private static LoginPage loginPage;
    private static DashboardPage dashboardPage;
    private static VerificationPage verificationPage;

    private static MoneyTransferPage moneyTransferPage;

    @Пусть("открыта страница с формой авторизации {string}")
    public void openAuthPage(String url) {
        loginPage = Selenide.open(url, LoginPage.class);
    }

    @Когда("пользователь пытается авторизоваться с именем {string} и паролем {string}")
    public void loginWithNameAndPassword(String login, String password) {
        verificationPage = loginPage.validLogin(login, password);
    }

    @И("пользователь вводит проверочный код 'из смс' {string}")
    public void setValidCode(String verificationCode) {
        dashboardPage = verificationPage.validVerify(verificationCode);
    }

    @И("пользователь вызывает кнопку Пополнения карты с numberIdCard {string}")
    public void increaseFirstCard(String numberIdCard) {
        moneyTransferPage = dashboardPage.replenishmentOpenV2(numberIdCard);
    }


   @И("пользователь вводит сумму {int} для пополнения с карты {string}")
   public void replenishmentFiveThousandsToFirstCard(int amount, String cardNumber) {
        dashboardPage = moneyTransferPage.replenishment(amount, cardNumber);
    }


    @Тогда("баланс карты с карты id  {string} == {int}")
    public void balanceFirstCard(String id, int balance) {
        int getBalance = dashboardPage.getCardBalance();
        assertEquals(getBalance, balance);
    }
}