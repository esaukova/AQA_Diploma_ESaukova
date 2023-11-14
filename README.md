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

### Пошаговый процесс подключения SUT к MySQL

1. Открыть терминал и запустить контейнеры: docker-compose up 
2. Открыть новую вкладку терминала и запустить приложение: java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar
3. Проверить, что приложение успешно запустилось (ввести URL в браузере Сhrome: http://localhost/8080)
4. Открыть новую вкладку терминала и запустить тесты: .\gradlew clean test 
5. Создать отчёт Allure: .\gradlew allureServe
6. Остановить приложение: CTRL + C
7. Остановить контейнеры: docker-compose down

### Пошаговый процесс подключения SUT к PostgreSQL

1. В файле build.gradle в разделе test  снять комментарии с systemProperty для PostgreSQL и закомментировать для MySQL
2. Открыть терминал и запустить контейнеры: docker-compose up 
3. Открыть новую вкладку терминала и запустить приложение: java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar
4. Проверить, что приложение успешно запустилось (ввести URL в браузере Сhrome: http://localhost/8080)
5. Открыть новую вкладку терминала и запустить тесты: .\gradlew clean test
6. Создать отчёт Allure: .\gradlew allureServe
7. Остановить приложение: CTRL + C
8. Остановить контейнеры: docker-compose down

