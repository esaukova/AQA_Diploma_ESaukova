package ru.netology.test.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.page.DashboardPage;
import ru.netology.page.CreditRequestPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.data.SQLHelper.cleanDB;

public class UICreditTest {
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
    @DisplayName("The credit card with approved status")
    void shouldSuccessTransactionWithCreditCard() {
        var creditPage = page.clickButtonCredit();
        var cardInfo = DataHelper.getValidDataForApprovedCard();
        creditPage.inputData(cardInfo);
        creditPage.checkSuccessNotification();
        val actual = SQLHelper.getStatusCreditRequestEntity();
        assertEquals("APPROVED", actual);
    }

    @Test
    @DisplayName("The credit card with declined status")
    void shouldDeclineTransactionWithCreditCard() {
        var creditPage = page.clickButtonCredit();
        var cardInfo = DataHelper.getValidDataForDeclinedCard();
        creditPage.inputData(cardInfo);
        creditPage.checkDeclinedNotification();
        val actual = SQLHelper.getStatusCreditRequestEntity();
        assertEquals("DECLINED", actual);
    }
    // для негативных сценариев для поля "номер карты"
    @Test
    @DisplayName("The credit card with random number")
    void shouldDeclineTransactionWithRandomNumber() {
        var creditPage = page.clickButtonCredit();
        var cardInfo = DataHelper.getCardInfoWithRandomNumber();
        creditPage.inputData(cardInfo);
        creditPage.checkDeclinedNotification();
    }

    @Test
    @DisplayName("The credit card with 15 digits number")
    void shouldFailValidationWith15DigitsNumber() {
        var creditPage = page.clickButtonCredit();
        var cardInfo = DataHelper.getCardInfoWith15DigitsNumber();
        creditPage.inputData(cardInfo);
        creditPage.checkWrongFormat();
    }

    @Test
    @DisplayName("The credit card with zero in number")
    void shouldFailValidationWithZeroInNumber() {
        var creditPage = page.clickButtonCredit();
        var cardInfo = DataHelper.getCardInfoWithNumberZero();
        creditPage.inputData(cardInfo);
        creditPage.checkWrongFormat();
    }

    // для негативных сценариев для поля "месяц"

    @Test
    @DisplayName("The credit card with 1 digit in month")
    void shouldFailValidationWith1DigitInMonth() {
        var creditPage = page.clickButtonCredit();
        var cardInfo = DataHelper.getCardInfoWithMonthWith1Digit();
        creditPage.inputData(cardInfo);
        creditPage.checkWrongFormat();

    }

    @Test
    @DisplayName("The credit card with month above 12")
    void shouldFailValidationWithMonthAbove12() {
        var creditPage = page.clickButtonCredit();
        var cardInfo = DataHelper.getCardInfoWithMonthMoreThan12();
        creditPage.inputData(cardInfo);
        creditPage.checkInvalidCardExpirationDate();

    }

    @Test
    @DisplayName("The credit card with zero in month")
    void shouldFailValidationWithZeroInMonth() {
        var creditPage = page.clickButtonCredit();
        var cardInfo = DataHelper.getCardInfoWithMonthWithZero();
        creditPage.inputData(cardInfo);
        creditPage.checkInvalidCardExpirationDate();

    }

    // для негативных сценариев для поля "год"

    @Test
    @DisplayName("The credit card with past year")
    void shouldFailValidationWithPastYear() {
        var creditPage = page.clickButtonCredit();
        var cardInfo = DataHelper.getCardInfoWithPastYear();
        creditPage.inputData(cardInfo);
        creditPage.checkCardExpired();

    }

    @Test
    @DisplayName("The credit card with year+6")
    void shouldFailValidationWithCurrentYearPlus6() {
        var creditPage = page.clickButtonCredit();
        var cardInfo = DataHelper.getCardInfoWithFutureYearMoreThan5YearsAhead();
        creditPage.inputData(cardInfo);
        creditPage.checkInvalidCardExpirationDate();

    }

    // для негативных сценариев для поля "владелец"

    @Test
    @DisplayName("The credit card with cyrillic symbols in holder")
    void shouldFailValidationWithCyrillicSymbols() {
        var creditPage = page.clickButtonCredit();
        var cardInfo = DataHelper.getCardInfoWithHolderWithCyrillic();
        creditPage.inputData(cardInfo);
        creditPage.checkWrongFormat();

    }

    @Test
    @DisplayName("The credit card with just name in holder")
    void shouldFailValidationWithJustName() {
        var creditPage = page.clickButtonCredit();
        var cardInfo = DataHelper.getCardInfoWithHolderJustWithName();
        creditPage.inputData(cardInfo);
        creditPage.checkWrongFormat();

    }

    @Test
    @DisplayName("The credit card with digits in holder")
    void shouldFailValidationWithDigitsInFieldHolder() {
        var creditPage = page.clickButtonCredit();
        var cardInfo = DataHelper.getCardInfoWithHolderWithNumbers();
        creditPage.inputData(cardInfo);
        creditPage.checkWrongFormat();

    }

    @Test
    @DisplayName("The credit card with spec symbols in holder")
    void shouldFailValidationWithSpecSymbolInFieldHolder() {
        var creditPage = page.clickButtonCredit();
        var cardInfo = DataHelper.getCardInfoWithHolderWithSpecialCharacters();
        creditPage.inputData(cardInfo);
        creditPage.checkWrongFormat();

    }

    // для негативных сценариев для поля "CVC/CVV"

    @Test
    @DisplayName("The credit card with 2 digits in CVC")
    void shouldFailValidationWith2DigitsInCVC() {
        var creditPage = page.clickButtonCredit();
        var cardInfo = DataHelper.getCardInfoWithCVCWith2Digits();
        creditPage.inputData(cardInfo);
        creditPage.checkWrongFormat();
    }

    @Test
    @DisplayName("The credit card with zero in CVC")
    void shouldFailValidationWithZeroInCVC () {
        var creditPage = page.clickButtonCredit();
        var cardInfo = DataHelper.getCardInfoWithCVCWithZero();
        creditPage.inputData(cardInfo);
        creditPage.checkWrongFormat();

    }

    // пустые поля

    @Test
    @DisplayName("The credit card with empty number")
    void shouldFailValidationWithEmptyNumber () {
        var creditPage = page.clickButtonCredit();
        var cardInfo = DataHelper.getCardInfoWithEmptyNumber();
        creditPage.inputData(cardInfo);
        creditPage.checkEmptyField();

    }

        @Test
        @DisplayName("The credit card with empty month")
        void shouldFailValidationWithEmptyMonth () {
            var creditPage = page.clickButtonCredit();
            var cardInfo = DataHelper.getCardInfoWithEmptyMonth();
            creditPage.inputData(cardInfo);
            creditPage.checkEmptyField();

    }

    @Test
    @DisplayName("The credit card with empty year")
    void shouldFailValidationWithEmptyYear () {
        var creditPage = page.clickButtonCredit();
        var cardInfo = DataHelper.getCardInfoWithEmptyYear();
        creditPage.inputData(cardInfo);
        creditPage.checkEmptyField();

    }

    @Test
    @DisplayName("The credit card with empty holder")
    void shouldFailValidationWithEmptyHolder () {
        var creditPage = page.clickButtonCredit();
        var cardInfo = DataHelper.getCardInfoWithEmptyHolder();
        creditPage.inputData(cardInfo);
        creditPage.checkEmptyField();

    }

    @Test
    @DisplayName("The credit card with empty CVC")
    void shouldFailValidationWithEmptyCVC () {
        var creditPage = page.clickButtonCredit();
        var cardInfo = DataHelper.getCardInfoWithEmptyCVC();
        creditPage.inputData(cardInfo);
        creditPage.checkEmptyField();

    }

    @Test
    @DisplayName("The credit card with empty fields")
    void shouldFailValidationWithEmptyForm () {
        var creditPage = page.clickButtonCredit();
        var cardInfo = DataHelper.getCardInfoWithEmptyFields();
        creditPage.inputData(cardInfo);
        creditPage.checkEmptyField();

    }

}
