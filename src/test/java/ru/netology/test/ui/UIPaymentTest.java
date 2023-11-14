package ru.netology.test.ui;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.page.DashboardPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.data.SQLHelper.cleanDB;

public class UIPaymentTest {
    DashboardPage page = open("http://localhost:8080/", DashboardPage.class);
    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }


    @AfterEach
    public void teardrop() {
        cleanDB();
    }


    @Test
    @DisplayName("Payment with card with approved status")
    void shouldSuccessTransactionWithCreditCard() {
        var paymentPage = page.clickButtonPayment();
        var cardInfo = DataHelper.getValidDataForApprovedCard();
        paymentPage.inputData(cardInfo);
        paymentPage.checkSuccessNotification();
        val actual = SQLHelper.getStatusPaymentEntity();
        assertEquals("APPROVED", actual);
    }
    @Test
    @DisplayName("Payment with card with declined status")
    void shouldDeclineTransactionWithCreditCard() {
        var paymentPage = page.clickButtonPayment();
        var cardInfo = DataHelper.getValidDataForDeclinedCard();
        paymentPage.inputData(cardInfo);
        paymentPage.checkDeclinedNotification();
        val actual = SQLHelper.getStatusPaymentEntity();
        assertEquals("DECLINED", actual);
    }

    // для негативных сценариев для поля "номер карты"
    @Test
    @DisplayName("Payment with card with random number")
    void shouldDeclineTransactionWithRandomNumber() {
        var paymentPage = page.clickButtonPayment();
        var cardInfo = DataHelper.getCardInfoWithRandomNumber();
        paymentPage.inputData(cardInfo);
        paymentPage.checkDeclinedNotification();
    }

    @Test
    @DisplayName("Payment with card with 15 digits number")
    void shouldFailValidationWith15DigitsNumber() {
        var paymentPage = page.clickButtonPayment();
        var cardInfo = DataHelper.getCardInfoWith15DigitsNumber();
        paymentPage.inputData(cardInfo);
        paymentPage.checkWrongFormat();
    }

    @Test
    @DisplayName("Payment with card with zero in number")
    void shouldFailValidationWithZeroInNumber() {
        var paymentPage = page.clickButtonPayment();
        var cardInfo = DataHelper.getCardInfoWithNumberZero();
        paymentPage.inputData(cardInfo);
        paymentPage.checkWrongFormat();
    }

    // для негативных сценариев для поля "месяц"

    @Test
    @DisplayName("Payment with card with 1 digit in month")
    void shouldFailValidationWith1DigitInMonth() {
        var paymentPage = page.clickButtonPayment();
        var cardInfo = DataHelper.getCardInfoWithMonthWith1Digit();
        paymentPage.inputData(cardInfo);
        paymentPage.checkWrongFormat();

    }

    @Test
    @DisplayName("Payment with card with month above 12")
    void shouldFailValidationWithMonthAbove12() {
        var paymentPage = page.clickButtonPayment();
        var cardInfo = DataHelper.getCardInfoWithMonthMoreThan12();
        paymentPage.inputData(cardInfo);
        paymentPage.checkInvalidCardExpirationDate();

    }

    @Test
    @DisplayName("Payment with card with zero in month")
    void shouldFailValidationWithZeroInMonth() {
        var paymentPage = page.clickButtonPayment();
        var cardInfo = DataHelper.getCardInfoWithMonthWithZero();
        paymentPage.inputData(cardInfo);
        paymentPage.checkInvalidCardExpirationDate();

    }

    // для негативных сценариев для поля "год"

    @Test
    @DisplayName("Payment with card with past year")
    void shouldFailValidationWithPastYear() {
        var paymentPage = page.clickButtonPayment();
        var cardInfo = DataHelper.getCardInfoWithPastYear();
        paymentPage.inputData(cardInfo);
        paymentPage.checkCardExpired();

    }

    @Test
    @DisplayName("Payment with card with year+6")
    void shouldFailValidationWithCurrentYearPlus6() {
        var paymentPage = page.clickButtonPayment();
        var cardInfo = DataHelper.getCardInfoWithFutureYearMoreThan5YearsAhead();
        paymentPage.inputData(cardInfo);
        paymentPage.checkInvalidCardExpirationDate();

    }

    // для негативных сценариев для поля "владелец"

    @Test
    @DisplayName("Payment with card with cyrillic symbols in holder")
    void shouldFailValidationWithCyrillicSymbols() {
        var paymentPage = page.clickButtonPayment();
        var cardInfo = DataHelper.getCardInfoWithHolderWithCyrillic();
        paymentPage.inputData(cardInfo);
        paymentPage.checkWrongFormat();

    }

    @Test
    @DisplayName("Payment with card with just name in holder")
    void shouldFailValidationWithJustName() {
        var paymentPage = page.clickButtonPayment();
        var cardInfo = DataHelper.getCardInfoWithHolderJustWithName();
        paymentPage.inputData(cardInfo);
        paymentPage.checkWrongFormat();

    }

    @Test
    @DisplayName("Payment with card with digits in holder")
    void shouldFailValidationWithDigitsInFieldHolder() {
        var paymentPage = page.clickButtonPayment();
        var cardInfo = DataHelper.getCardInfoWithHolderWithNumbers();
        paymentPage.inputData(cardInfo);
        paymentPage.checkWrongFormat();

    }

    @Test
    @DisplayName("Payment with card with spec symbols in holder")
    void shouldFailValidationWithSpecSymbolInFieldHolder() {
        var paymentPage = page.clickButtonPayment();
        var cardInfo = DataHelper.getCardInfoWithHolderWithSpecialCharacters();
        paymentPage.inputData(cardInfo);
        paymentPage.checkWrongFormat();

    }

    @Test
    @DisplayName("Payment with card with lower case in holder") // дописать, если получится
    void shouldReplaceLowerCaseToUpperCaseInHolder() {

    }

    // для негативных сценариев для поля "CVC/CVV"

    @Test
    @DisplayName("Payment with card with 2 digits in CVC")
    void shouldFailValidationWith2DigitsInCVC() {
        var paymentPage = page.clickButtonPayment();
        var cardInfo = DataHelper.getCardInfoWithCVCWith2Digits();
        paymentPage.inputData(cardInfo);
        paymentPage.checkWrongFormat();

    }

    @Test
    @DisplayName("Payment with card with zero in CVC")
    void shouldFailValidationWithZeroInCVC () {
        var paymentPage = page.clickButtonPayment();
        var cardInfo = DataHelper.getCardInfoWithCVCWithZero();
        paymentPage.inputData(cardInfo);
        paymentPage.checkWrongFormat();

    }

    // пустые поля

    @Test
    @DisplayName("Payment with card with empty number")
    void shouldFailValidationWithEmptyNumber () {
        var paymentPage = page.clickButtonPayment();
        var cardInfo = DataHelper.getCardInfoWithEmptyNumber();
        paymentPage.inputData(cardInfo);
        paymentPage.checkEmptyField();

    }

    @Test
    @DisplayName("Payment with card with empty month")
    void shouldFailValidationWithEmptyMonth () {
        var paymentPage = page.clickButtonPayment();
        var cardInfo = DataHelper.getCardInfoWithEmptyMonth();
        paymentPage.inputData(cardInfo);
        paymentPage.checkEmptyField();

    }

    @Test
    @DisplayName("Payment with card with empty year")
    void shouldFailValidationWithEmptyYear () {
        var paymentPage = page.clickButtonPayment();
        var cardInfo = DataHelper.getCardInfoWithEmptyYear();
        paymentPage.inputData(cardInfo);
        paymentPage.checkEmptyField();

    }

    @Test
    @DisplayName("The credit card with empty holder")
    void shouldFailValidationWithEmptyHolder () {
        var paymentPage = page.clickButtonPayment();
        var cardInfo = DataHelper.getCardInfoWithEmptyHolder();
        paymentPage.inputData(cardInfo);
        paymentPage.checkEmptyField();

    }

    @Test
    @DisplayName("Payment with card with empty CVC")
    void shouldFailValidationWithEmptyCVC () {
        var paymentPage = page.clickButtonPayment();
        var cardInfo = DataHelper.getCardInfoWithEmptyCVC();
        paymentPage.inputData(cardInfo);
        paymentPage.checkEmptyField();

    }

    @Test
    @DisplayName("Payment with card with empty fields")
    void shouldFailValidationWithEmptyForm () {
        var creditPage = page.clickButtonCredit();
        var cardInfo = DataHelper.getCardInfoWithEmptyFields();
        creditPage.inputData(cardInfo);
        creditPage.checkEmptyField();

    }

}


