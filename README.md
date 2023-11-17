# Дипломный проект по профессии «Тестировщик»

Дипломный проект — автоматизация тестирования комплексного сервиса, взаимодействующего с СУБД и API Банка.

## Начало работы

Для получения проекта на локальную машину, необходимо сделать копию из Github с помощью команды

git clone https://github.com/esaukova/AQA_Diploma_ESaukova

## Технические требования

Для запуска и управления приложением необходимо выполнить следующие технические требования:

- ОС Windows 10 и выше
- Установить браузер Google Chrome
- Установить GIT
- Установить IDE IntelliJ IDEA 
- Установить Docker Desktop

## Установка и запуск

1. Открыть проект в IntelliJ IDEA
2. Запустить Docker Desktop

### Пошаговое подключение SUT к MySQL

1. Открыть терминал и запустить контейнеры: docker-compose up 
2. Открыть новую вкладку терминала и запустить приложение: java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar
3. Проверить, что приложение успешно запустилось (ввести URL в браузере Сhrome: http://localhost/8080)
4. Открыть новую вкладку терминала и запустить тесты: .\gradlew clean test -Ddb.url=jdbc:mysql://localhost:3306/app "-Dselenide.headless=true"
5. Создать отчёт Allure: .\gradlew allureServe
6. Остановить приложение: CTRL + C
7. Остановить контейнеры: docker-compose down

### Пошаговое подключение SUT к PostgreSQL

1. Открыть терминал и запустить контейнеры: docker-compose up 
2. Открыть новую вкладку терминала и запустить приложение: java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar
3. Проверить, что приложение успешно запустилось (ввести URL в браузере Сhrome: http://localhost/8080)
4. Открыть новую вкладку терминала и запустить тесты: .\gradlew clean test -Ddb.url=jdbc:postgresql://localhost:5432/app "-Dselenide.headless=true"
5. Создать отчёт Allure: .\gradlew allureServe
6. Остановить приложение: CTRL + C
7. Остановить контейнеры: docker-compose down

