package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataHelper {
    public DataHelper() {
    }
    private static Random random = new Random();
    private static Faker faker = new Faker(new Locale("En"));
    private static Faker fakerRu = new Faker(new Locale("Ru"));


    public static String getApprovedCardNumber() {
        return ("4444 4444 4444 4441");
    }

    public static String getDeclinedCardNumber() {
        return ("4444 4444 4444 4442");
    }
    public static String getPastYear(int minusYears) {
        return LocalDate.now().minusYears(minusYears).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getFutureYearMoreThan5YearsAhead(int plusYears) {
        return LocalDate.now().plusYears(plusYears).format(DateTimeFormatter.ofPattern("yy"));
    }
    @Value
    public static class CardInfo {
        String number;
        String month;
        String year;
        String holder;
        String cvc;
    }

    public static CardInfo getValidDataForApprovedCard() {
        return new CardInfo(getApprovedCardNumber(),
                LocalDate.now().format(DateTimeFormatter.ofPattern("MM")), // месяц
                LocalDate.now().format(DateTimeFormatter.ofPattern("yy")), // год
                faker.name().firstName().toUpperCase() + " " + faker.name().lastName().toUpperCase(), // владелец
                faker.numerify("###")); // cvc
    }

    public static CardInfo getValidDataForDeclinedCard() {
        return new CardInfo(getDeclinedCardNumber(),
                LocalDate.now().format(DateTimeFormatter.ofPattern("MM")), // месяц
                LocalDate.now().format(DateTimeFormatter.ofPattern("yy")), // год
                faker.name().firstName().toUpperCase() + " " + faker.name().lastName().toUpperCase(), // владелец
                faker.numerify("###")); // cvc
    }

    // для негативных сценариев для поля "номер карты"
    public static CardInfo getCardInfoWithRandomNumber() {
        return new CardInfo(faker.numerify("4444 #### #### ####"), // рандомный номер карты
                LocalDate.now().format(DateTimeFormatter.ofPattern("MM")), // месяц
                LocalDate.now().format(DateTimeFormatter.ofPattern("yy")), // год
                faker.name().firstName().toUpperCase() + " " + faker.name().lastName().toUpperCase(), // владелец
                faker.numerify("###")); // cvc
    }

    public static CardInfo getCardInfoWith15DigitsNumber() {
        return new CardInfo(faker.numerify("4444 #### #### ###"), //  номер карты с 15 цифрами
                LocalDate.now().format(DateTimeFormatter.ofPattern("MM")), // месяц
                LocalDate.now().format(DateTimeFormatter.ofPattern("yy")), // год
                faker.name().firstName().toUpperCase() + " " + faker.name().lastName().toUpperCase(), // владелец
                faker.numerify("###")); // cvc
    }
    public static CardInfo getCardInfoWithNumberZero() {
        return new CardInfo("0000 0000 0000 0000", //  номер карты с нулями
                LocalDate.now().format(DateTimeFormatter.ofPattern("MM")), // месяц
                LocalDate.now().format(DateTimeFormatter.ofPattern("yy")), // год
                faker.name().firstName().toUpperCase() + " " + faker.name().lastName().toUpperCase(), // владелец
                faker.numerify("###")); // cvc
    }

    // для негативных сценариев для поля "месяц"

    public static CardInfo getCardInfoWithMonthWith1Digit() {
        return new CardInfo(getApprovedCardNumber(),
                faker.numerify("#"), // месяц с одной цифрой
                LocalDate.now().format(DateTimeFormatter.ofPattern("yy")), // год
                faker.name().firstName().toUpperCase() + " " + faker.name().lastName().toUpperCase(), // владелец
                faker.numerify("###")); // cvc
    }
    public static CardInfo getCardInfoWithMonthWithZero() {
        return new CardInfo(getApprovedCardNumber(),
                LocalDate.now().format(DateTimeFormatter.ofPattern("00")), // месяц с нулями
                LocalDate.now().format(DateTimeFormatter.ofPattern("yy")), // год
                faker.name().firstName().toUpperCase() + " " + faker.name().lastName().toUpperCase(), // владелец
                faker.numerify("###")); // cvc
    }
    public static CardInfo getCardInfoWithMonthMoreThan12() {
        return new CardInfo(getApprovedCardNumber(),
                "13", // месяц больше 12
                LocalDate.now().format(DateTimeFormatter.ofPattern("yy")), // год
                faker.name().firstName().toUpperCase() + " " + faker.name().lastName().toUpperCase(), // владелец
                faker.numerify("###")); // cvc
    }

    // для негативных сценариев для поля "год"

    public static CardInfo getCardInfoWithPastYear() {
        return new CardInfo(getApprovedCardNumber(),
                LocalDate.now().format(DateTimeFormatter.ofPattern("MM")), // месяц
                getPastYear(1), // прошлый год
                faker.name().firstName().toUpperCase() + " " + faker.name().lastName().toUpperCase(), // владелец
                faker.numerify("###")); // cvc
    }
    public static CardInfo getCardInfoWithFutureYearMoreThan5YearsAhead() {
        return new CardInfo(getApprovedCardNumber(),
                LocalDate.now().format(DateTimeFormatter.ofPattern("MM")), // месяц
                getFutureYearMoreThan5YearsAhead(6), //  год из будущего: текущий год + 6 лет
                faker.name().firstName().toUpperCase() + " " + faker.name().lastName().toUpperCase(), // владелец
                faker.numerify("###")); // cvc
    }

    // для негативных сценариев для поля "владелец"
    public static CardInfo getCardInfoWithHolderJustWithName() {
        return new CardInfo(getApprovedCardNumber(),
                LocalDate.now().format(DateTimeFormatter.ofPattern("MM")), // месяц
                LocalDate.now().format(DateTimeFormatter.ofPattern("yy")), // год
                faker.name().firstName().toUpperCase(), // владелец только с именем
                faker.numerify("###")); // cvc
    }
    public static CardInfo getCardInfoWithHolderWithCyrillic() {
        return new CardInfo(getApprovedCardNumber(),
                LocalDate.now().format(DateTimeFormatter.ofPattern("MM")), // месяц
                LocalDate.now().format(DateTimeFormatter.ofPattern("yy")), // год
                fakerRu.name().firstName().toUpperCase(), // владелец только с именем
                faker.numerify("###")); // cvc
    }
    public static CardInfo getCardInfoWithHolderWithNumbers() {
        return new CardInfo(getApprovedCardNumber(),
                LocalDate.now().format(DateTimeFormatter.ofPattern("MM")), // месяц
                LocalDate.now().format(DateTimeFormatter.ofPattern("yy")), // год
                faker.numerify("####### ######"), // владелец с цифрами
                faker.numerify("###")); // cvc
    }
    public static CardInfo getCardInfoWithHolderWithSpecialCharacters() {
        return new CardInfo(getApprovedCardNumber(),
                LocalDate.now().format(DateTimeFormatter.ofPattern("MM")), // месяц
                LocalDate.now().format(DateTimeFormatter.ofPattern("yy")), // год
                "!@#$%^&*()-_+=<>?", // владелец со спец. символами
                faker.numerify("###")); // cvc
    }
    public static CardInfo getCardInfoWithHolderWithLowerCase() {
        return new CardInfo(getApprovedCardNumber(),
                LocalDate.now().format(DateTimeFormatter.ofPattern("MM")), // месяц
                LocalDate.now().format(DateTimeFormatter.ofPattern("yy")), // год
                faker.name().firstName() + " " + faker.name().lastName(), // владелец с именем в нижнем регистре
                faker.numerify("###")); // cvc
    }

    // для негативных сценариев для поля "cvc"
    public static CardInfo getCardInfoWithCVCWith2Digits() {
        return new CardInfo(getApprovedCardNumber(),
                LocalDate.now().format(DateTimeFormatter.ofPattern("MM")), // месяц
                LocalDate.now().format(DateTimeFormatter.ofPattern("yy")), // год
                faker.name().firstName().toUpperCase() + " " + faker.name().lastName().toUpperCase(), // владелец
                faker.numerify("##")); // cvc с 2 знаками
    }
    public static CardInfo getCardInfoWithCVCWithZero() {
        return new CardInfo(getApprovedCardNumber(),
                LocalDate.now().format(DateTimeFormatter.ofPattern("MM")), // месяц
                LocalDate.now().format(DateTimeFormatter.ofPattern("yy")), // год
                faker.name().firstName().toUpperCase() + " " + faker.name().lastName().toUpperCase(), // владелец
                "00"); // cvc с нулями
    }

    // пустые поля
    public static CardInfo getCardInfoWithEmptyNumber() {
        return new CardInfo(null, // пустой номер карты
                LocalDate.now().format(DateTimeFormatter.ofPattern("MM")), // месяц
                LocalDate.now().format(DateTimeFormatter.ofPattern("yy")), // год
                faker.name().firstName().toUpperCase() + " " + faker.name().lastName().toUpperCase(), // владелец
                faker.numerify("###")); // cvc
    }
    public static CardInfo getCardInfoWithEmptyMonth() {
        return new CardInfo(getApprovedCardNumber(),
                null, // пустой месяц
                LocalDate.now().format(DateTimeFormatter.ofPattern("yy")), // год
                faker.name().firstName().toUpperCase() + " " + faker.name().lastName().toUpperCase(), // владелец
                faker.numerify("###")); // cvc
    }
    public static CardInfo getCardInfoWithEmptyYear() {
        return new CardInfo(getApprovedCardNumber(),
                LocalDate.now().format(DateTimeFormatter.ofPattern("MM")), // месяц
                null, // пустой год
                faker.name().firstName().toUpperCase() + " " + faker.name().lastName().toUpperCase(), // владелец
                faker.numerify("###")); // cvc
    }
    public static CardInfo getCardInfoWithEmptyHolder() {
        return new CardInfo(getApprovedCardNumber(),
                LocalDate.now().format(DateTimeFormatter.ofPattern("MM")), // месяц
                LocalDate.now().format(DateTimeFormatter.ofPattern("yy")), // год
                null, // пустой владелец
                faker.numerify("###")); // cvc
    }
    public static CardInfo getCardInfoWithEmptyCVC() {
        return new CardInfo(getApprovedCardNumber(),
                LocalDate.now().format(DateTimeFormatter.ofPattern("MM")), // месяц
                LocalDate.now().format(DateTimeFormatter.ofPattern("yy")), // год
                faker.name().firstName().toUpperCase() + " " + faker.name().lastName().toUpperCase(), // владелец
                null); // пустой cvc
    }
    public static CardInfo getCardInfoWithEmptyFields() {
        return new CardInfo(null,
                null, // пустой месяц
                null, // пустой год
                null, // пустой владелец
                null); // пустой cvc
    }



}
