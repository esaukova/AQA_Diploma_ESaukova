package ru.netology.page;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.*;

public class DashboardPage {

    private SelenideElement payment = $x("//div/button/span/span[text() = 'Купить']");
    private SelenideElement creditRequest = $x("//div/button/span/span[text() = 'Купить в кредит']");

    public PaymentPage clickButtonPayment() {
        payment.click();
        return new PaymentPage();
    }

    public CreditRequestPage clickButtonCredit() {
        creditRequest.click();
        return new CreditRequestPage();
    }
}
