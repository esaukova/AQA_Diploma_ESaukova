package ru.netology.test.api;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.google.gson.Gson;
import ru.netology.data.DataHelper;
import ru.netology.data.APIHelper;

import static org.hamcrest.Matchers.equalTo;

public class APITestPayment {
    private static DataHelper.CardInfo cardInfo;
    private static final Gson gson = new Gson();

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    void shouldRespondWithStatus200IfApprovedCard() {
        cardInfo = DataHelper.getValidDataForApprovedCard();
        var body = gson.toJson(cardInfo);
        APIHelper.createPayment(body, 200)
                .body("status", equalTo("APPROVED"));
    }

    @Test
    void shouldRespondWithStatus400IfDeclinedCard() {
        cardInfo = DataHelper.getValidDataForDeclinedCard();
        var body = gson.toJson(cardInfo);
        APIHelper.createPayment(body, 400)
                .body("status", equalTo("DECLINED"));
    }

    @Test
    void shouldRespondWithStatus400IfFieldNumberIsEmpty() {
        cardInfo = DataHelper.getCardInfoWithEmptyNumber();
        var body = gson.toJson(cardInfo);
        APIHelper.createPayment(body, 400);
    }

    @Test
    void shouldRespondWithStatus400IfFieldMonthIsEmpty() {
        cardInfo = DataHelper.getCardInfoWithEmptyMonth();
        var body = gson.toJson(cardInfo);
        APIHelper.createPayment(body, 400);
    }

    @Test
    void shouldRespondWithStatus400IfFieldYearIsEmpty() {
        cardInfo = DataHelper.getCardInfoWithEmptyYear();
        var body = gson.toJson(cardInfo);
        APIHelper.createPayment(body, 400);
    }

    @Test
    void shouldRespondWithStatus400IfFieldHolderIsEmpty() {
        cardInfo = DataHelper.getCardInfoWithEmptyHolder();
        var body = gson.toJson(cardInfo);
        APIHelper.createPayment(body, 400);
    }

    @Test
    void shouldRespondWithStatus400IfFieldCVCIsEmpty() {
        cardInfo = DataHelper.getCardInfoWithEmptyCVC();
        var body = gson.toJson(cardInfo);
        APIHelper.createPayment(body, 400);
    }

    @Test
    void shouldRespondWithStatus400IfAllFieldIsEmpty() {
        cardInfo = DataHelper.getCardInfoWithEmptyFields();
        var body = gson.toJson(cardInfo);
        APIHelper.createPayment(body, 400);
    }

}
