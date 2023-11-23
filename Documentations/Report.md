# Отчет о проведенном тестировании

Проведено автоматизированное тестирование сервиса "Путешествие дня" для приобретения тура, взаимодействующего с СУБД и API банка:
- с оплатой картой;
- с оплатой в кредит.

## Тестовое окружение:

Операционная система: Windows 10 Home Single Language version 22H2

IDE: IntelliJ IDEA 2023.1.5 (Community Edition)

Java: OpenJDK 11 Corretto version 11.0.19

Docker Desktop: version 4.25.1

Google Chrome: version 119.0.6045.160 (Official Build) (64-bit)

## Результаты тестирования:

Всего было проведено 61 автотест. Общий процент успешных тестов равен 47.54%.

|                  | Кол-во тестов | Passed | Failed | Passed, % |
|------------------|---------------|--------|--------|-----------|
| API тестирование | 16            | 2      | 14     | 12.5      |
| UI тестирование  | 45            | 27     | 18     | 60        |
| Всего            | 61            | 29     | 32     | 47.54     |




![Overview.png](img%2FOverview.png)

![Graphs.png](img%2FGraphs.png)

![Suites.png](img%2FSuites.png)

![Packages_API.png](img%2FPackages_API.png)

![Packages_UI_Credit.png](img%2FPackages_UI_Credit.png)

![Packages_UI_Payment.png](img%2FPackages_UI_Payment.png)
