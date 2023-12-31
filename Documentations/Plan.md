# План автоматизации тестирования веб-сервиса по покупке туров
## Перечень автоматизируемых сценариев
### Тестовые валидные данные 
|Поле|Валидные данные |
|----------|----------|
| Номер карты  | APPROVED CARD: 4444 4444 4444 4441        |                     
| Месяц      |   текущий месяц в формате двузначного числа от 01 до 12.                                                  |
| Год      |     текущий год в формате последних двух цифр номера года.     |
| Владелец         |  Имя и Фамилия на латинице через пробел, допустимо использовать знак "-" в двойных фамилиях и именах, количество знаков не должно превышать 20 символов. Например: IVAN IVANOV-PETROV                                                                            | 
| CVC/CVV         | число, состоящее из 3 цифр (100-999). Например: 123                                                                               |                                               
| Статус карты         | APPROVED                                                                              | 


### Сценарии автоматизации API и ответов от Data Base (MySQL,PostgreSQL)

Предусловие: 
1. Запущен [SUT](https://github.com/esaukova/Diploma_AQA_ESaukova/blob/main/artifacts/aqa-shop.jar)
   
| Идентификационный  номер | Название | Шаги | Ожидаемый результат|
|----------|----------|----------|-----------|
| ТС 01    | POST request "купить" с валидными данными и картой со статусом APPROVED     |1.Отправить POST запрос на эндпоинт http://localhost:8080/api/v1/pay с валидными данными|Статус-код ответа 200 OK.|
|          |                                               |                                |                             ||   
| ТС 02    | POST request "купить" с валидными данными и картой со статусом DECLINED          |1.Отправить POST запрос на эндпоинт http://localhost:8080/api/v1/pay с валидными данными|Статус-код ответа  400  Bad Request.|
|          |                                               |                                |                             ||   
| ТС 03    | POST request "купить в кредит" с валидными данными и картой со статусом APPROVED          |1.Отправить POST запрос на эндпоинт http://localhost:8080/api/v1/credit с валидными данными|Статус-код ответа 200 OK.|
|          |                                               |                                |                             ||   
| ТС 04    | POST request "купить в кредит" с валидными данными и картой со статусом DECLINED          |1.Отправить POST запрос на эндпоинт http://localhost:8080/api/v1/credit с валидными данными|Статус-код ответа  400  Bad Request.|
|          |                                               |                                |                             ||   
| ТС 05    | POST request "купить" с пустым значением поля "number"         |1.Отправить POST запрос на эндпоинт http://localhost:8080/api/v1/pay с валидными данными и пустым значением поля "number"|Статус-код ответа 400  Bad Request.|
|          |                                               |                                |                             ||   
| ТС 06    | POST request "купить" с пустым значением поля "month"         |1.Отправить POST запрос на эндпоинт http://localhost:8080/api/v1/pay с валидными данными и пустым значением поля "month"|Статус-код ответа 400  Bad Request.|
|          |                                               |                                |                             ||   
| ТС 07    | POST request "купить" с пустым значением поля "year"         |1.Отправить POST запрос на эндпоинт http://localhost:8080/api/v1/pay с валидными данными и пустым значением поля "year"|Статус-код ответа 400  Bad Request.|
|          |                                               |                                |                             ||   
| ТС 08    | POST request "купить" с пустым значением поля "holder"         |1.Отправить POST запрос на эндпоинт http://localhost:8080/api/v1/pay с валидными данными и пустым значением поля "holder"|Статус-код ответа 400  Bad Request.|
|          |                                               |                                |                             ||   
| ТС 09    | POST request "купить" с пустым значением поля "cvc"         |1.Отправить POST запрос на эндпоинт http://localhost:8080/api/v1/pay с валидными данными и пустым значением поля "cvc"|Статус-код ответа 400   Bad Request.|
|          |                                               |                                |                             ||   
| ТС 10    | POST request "купить" с пустым значением полей            |1.Отправить POST запрос на эндпоинт http://localhost:8080/api/v1/credit с пустыми полями|Статус-код ответа 400  Bad Request.|
|          |                                               |                                |                             ||   
| ТС 11    | POST request "купить в кредит" с пустым значением поля "number"         |1.Отправить POST запрос на эндпоинт http://localhost:8080/api/v1/credit с валидными данными и пустым значением поля "number"|Статус-код ответа 400  Bad Request.|
|          |                                               |                                |                             ||   
| ТС 12    | POST request "купить в кредит" с пустым значением поля "month"         |1.Отправить POST запрос на эндпоинт http://localhost:8080/api/v1/credit с валидными данными и пустым значением поля "month"|Статус-код ответа 400. Запись не появляется в DB.|
|          |                                               |                                |                             ||   
| ТС 13    | POST request "купить в кредит" с пустым значением поля "year"         |1.Отправить POST запрос на эндпоинт http://localhost:8080/api/v1/credit с валидными данными и пустым значением поля "year"|Статус-код ответа 400. |
|          |                                               |                                |                             ||   
| ТС 14    | POST request "купить в кредит" с пустым значением поля "holder"         |1.Отправить POST запрос на эндпоинт http://localhost:8080/api/v1/credit с валидными данными и пустым значением поля "holder"|Статус-код ответа 400  Bad Request.|
|          |                                               |                                |                             ||   
| ТС 15    | POST request "купить в кредит" с пустым значением поля "cvc"         |1.Отправить POST запрос на эндпоинт http://localhost:8080/api/v1/credit с валидными данными и пустым значением поля "cvc"|Статус-код ответа 400  Bad Request.|
|          |                                               |                                |                             ||   
| ТС 16    | POST request "купить в кредит" с пустым значением полей         |1.Отправить POST запрос на эндпоинт http://localhost:8080/api/v1/credit с пустыми полями|Статус-код ответа 400  Bad Request.|

### Сценарии автоматизации UI
Предусловие: 
1. Запущен [SUT](https://github.com/esaukova/Diploma_AQA_ESaukova/blob/main/artifacts/aqa-shop.jar) 
2. Открыта сраница веб-сервиса по покупке туров [Путешествие дня](http://localhost:8080/)

**Позитивные сценарии**
| Идентификационный  номер | Название | Шаги | Ожидаемый результат|
|----------|----------|----------|-----------|
| ТС 17    | Оплата тура картой с валидными данными и статусом APPROVED         |1.Нажать кнопку "Купить" | Система выдаёт сообщение "Успешно Операция одобрена Банком." Появляются записи в БД: payment_entity со статусом APPROVED, order_entity.|
|          |                                             | 2. Ввести валидные данные в поле "Номер карты", "месяц", "год", "Владелец", CVC/CVV ||                        
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                                |                             ||   
| ТС 18    | Оплата тура в кредит с валидными данными и статусом карты APPROVED         |1.Нажать кнопку "Купить в кредит" | Система выдаёт сообщение "Успешно Операция одобрена Банком." Появляются записи в БД: credit_request_entity со статусом APPROVED, order_entity.|
|          |                                             | 2. Ввести валидные данные в поле "Номер карты", "месяц", "год", "Владелец", CVC/CVV ||                        
|          |                                                                               |3. Нажать кнопку "Продолжить"||

**Негативные сценарии для оплаты картой**

Предусловие:
Нажата кнопка "Купить"

| Идентификационный  номер | Название | Шаги | Ожидаемый результат|
|----------|----------|----------|-----------|
| ТС 19    |  Оплата тура картой с валидными данными и статусом DECLINED          |1. Ввести номер карты со статуом DECLINED: 4444 4444 4444 4442 |Система выдаёт сообщение "Ошибка! Банк отказал в проведении операции." Появляется запись в БД: payment_entity со статусом DECLINED.|                  
|          |                                                                               |2. Ввести валидные значения в поля "месяц", "год", "Владелец", CVC/CVV|| 
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                                |                             ||   
| ТС 20    | Оплата картой с номером из 15 цифр        |1. Ввести 15 цифр в поле "Номер карты"| Под полем "Номер карты" высвечивается сообщение "Неверный формат". Форма не отправляется на обработку.|
|          |                                                                               |2. Ввести валидные значения в поля: "месяц", "год", "Владелец", CVC/CVV ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                                |                             ||   
| ТС 21    | Оплата картой с номером, содержащим только нули        |1.Ввести в поле "Номер карты" 0000 0000 0000 0000 |Под полем "Номер карты" высвечивается сообщение "Неверный формат". Форма не отправляется на обработку.|            
|          |                                                                               |2. Ввести валидные значения в поля: "месяц", "год", "Владелец", CVC/CVV ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                                |                             ||   
| ТС 22    | Оплата картой с номером, который рандомно сгенерирован        |1.Ввести в поле "Номер карты" рандомно сгенерированый номер из 16 цифр: 2345 2154 3564 1125 | Система выдаёт сообщение: "Ошибка! Банк отказал в проведении операции". Запись не появляется в БД.|            
|          |                                                                               |2. Ввести валидные значения в поля: "месяц", "год", "Владелец", CVC/CVV ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                                |                             ||   
| ТС 23    | Ввод в поле "месяц" одной цифры       |1.Ввести в поле "месяц" одну цифру: от 1 до 9 |Под полем "месяц" высвечивается сообщение "Неверный формат". Форма не отправляется на обработку.|
|          |                                                                               |2. Ввести валидные значения в поля: "номер карты", "год", "Владелец", CVC/CVV ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                                |                             ||   
| ТС 24    | Ввод в поле "месяц" числа больше 12       |1.Ввести в поле "месяц" числа больше 12: например 13  |Под полем "месяц" высвечивается сообщение "Неверный формат". Форма не отправляется на обработку.|
|          |                                                                               |2. Ввести валидные значения в поля: "номер карты", "год", "Владелец", CVC/CVV ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                               |                             ||   
| ТС 25    | Ввод в поле "месяц" нулей       |1. Ввести в поле "месяц" нули: 00  |Под полем "месяц" высвечивается сообщение "Неверный формат". Форма не отправляется на обработку.|
|          |                                                                               |2. Ввести валидные значения в поля: "номер карты", "год", "Владелец", CVC/CVV ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                               |                             ||   
| ТС 26    | Ввод в поле "год" значения предыдущего года       |1. Ввести в поле "год" значение прошлого года |Под полем "год" высвечивается сообщение "Истёк срок действия карты". Форма не отправляется на обработку.|
|          |                                                                               |2. Ввести валидные значения в поля: "номер карты", "месяц", "Владелец", CVC/CVV ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                               |                             ||   
| ТС 27    | Ввод в поле "год" значения года на 6 лет вперед от текущего      |1.Ввести в поле "год" значение года на 6 лет вперед от текущего  |Под полем "год" высвечивается сообщение "Неверно указан срок действия карты". Форма не отправляется на обработку.|
|          |                                                                               |2. Ввести валидные значения в поля: "номер карты", "месяц", "Владелец", CVC/CVV ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                               |                             ||   
| ТС 28    | Ввод в поле "Владелец" Имени и Фамилии на кириллице         |1.Ввести в поле "Владелец" Имя и Фамилию на кириллице | Под полем "Владелец" высвечивается сообщение "Неверный формат". Форма не отправляется на обработку.|
|          |                                                                               |2. Ввести валидные значения в поля: "номер карты", "месяц", "год", CVC/CVV ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                               |                             ||   
| ТС 29    | Ввод в поле "Владелец" только Имени         |1.Ввести в поле "Владелец" Имя без Фамилии | Под полем "Владелец" высвечивается сообщение "Неверный формат". Форма не отправляется на обработку.|
|          |                                                                               |2. Ввести валидные значения в поля: "номер карты", "месяц", "год", CVC/CVV ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                               |                             ||    
| ТС 30    | Ввод в поле "Владелец" числовые значения        |1.Ввести в поле "Владелец" число| Под полем "Владелец" высвечивается сообщение "Неверный формат". Форма не отправляется на обработку.|
|          |                                                                               |2. Ввести валидные значения в поля: "номер карты", "месяц", "год", CVC/CVV ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                               |                             ||    
| ТС 31    | Ввод в поле "Владелец" спец символов       |1.Ввести в поле "Владелец" спец символы| Под полем "Владелец" высвечивается сообщение "Неверный формат". Форма не отправляется на обработку.|
|          |                                                                               |2. Ввести валидные значения в поля: "номер карты", "месяц", "год", CVC/CVV ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                               |                             ||   
| ТС 32    | Ввод в поле "CVC/CVV" 2 цифр       |1.Ввести в поле "CVC/CVV" 2 цифры  | Под полем "CVC/CVV" высвечивается сообщение "Неверный формат". Форма не отправляется на обработку.|
|          |                                                                               |2. Ввести валидные значения в поля: "номер карты", "месяц", "год", "владелец" ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                               |                             ||    
| ТС 33    | Ввод в поле "CVC/CVV"  нулей       |1.Ввести в поле "CVC/CVV" нули: 000  | Под полем "CVC/CVV" высвечивается сообщение "Неверный формат". Форма не отправляется на обработку.|
|          |                                                                               |2. Ввести валидные значения в поля: "номер карты", "месяц", "год", "владелец" ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                               |                             ||    
| ТС 34    | Оставление поля "номер карты" пустым      |1.Оставить поле "номер карты" пустым  | Под полем "номер карты" высвечивается сообщение "Поле обязательно для заполнения". Форма не отправляется на обработку.|
|          |                                                                               |2. Ввести валидные значения в поля: "месяц", "год", "владелец", "CVC/CVV" ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                               |                             ||  
| ТС 35    | Оставление поля "месяц" пустым      |1.Оставить поле "месяц" пустым  | Под полем "месяц" высвечивается сообщение "Поле обязательно для заполнения". Форма не отправляется на обработку.|
|          |                                                                               |2. Ввести валидные значения в поля: "номер карты", "год", "владелец", "CVC/CVV" ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                               |                             ||  
| ТС 36    | Оставление поля "год" пустым      |1.Оставить поле "год" пустым  | Под полем "год" высвечивается сообщение "Поле обязательно для заполнения". Форма не отправляется на обработку.|
|          |                                                                               |2. Ввести валидные значения в поля: "номер карты", "месяц", "владелец", "CVC/CVV" ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                               |                             ||  
| ТС 37    | Оставление поля "владелец" пустым      |1.Оставить поле "владелец" пустым  | Под полем "владелец" высвечивается сообщение "Поле обязательно для заполнения". Форма не отправляется на обработку.|
|          |                                                                               |2. Ввести валидные значения в поля: "номер карты", "месяц", "год", "CVC/CVV" ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                               |                             ||  
| ТС 38    | Оставление поля "CVC/CVV" пустым      |1.Оставить поле "CVC/CVV" пустым  | Под полем "CVC/CVV" высвечивается сообщение "Поле обязательно для заполнения". Форма не отправляется на обработку.|
|          |                                                                               |2. Ввести валидные значения в поля: "номер карты", "месяц", "год", "владелец" ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                               |                             ||  
| ТС 39    | Отправка пустой формы      |1.Оставить все поля пустыми | Под всеми полями высвечивается сообщение "Поле обязательно для заполнения". Форма не отправляется на обработку.|
|          |                                                                               |2. Нажать кнопку "Продолжить"||

**Негативные сценарии для оплаты в кредит**

Предусловие:
Нажата кнопка "Купить в кредит"

| Идентификационный  номер | Название | Шаги | Ожидаемый результат|
|----------|----------|----------|-----------|
| ТС 40    | Оплата тура в кредит с валидными данными и статусом карты DECLINED         |1.Ввести номер карты со статуом DECLINED: 4444 4444 4444 4442| Система выдаёт сообщение "Ошибка! Банк отказал в проведении операции." Появляется запись в БД: credit_request_entity со статусом DECLINED.|
|          |                                                                               |2. Ввести валидноые значения в поля "месяц", "год", "Владелец", CVC/CVV|| 
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                                |                             ||   
| ТС 41    | Оплата картой с номером из 15 цифр        |1. Ввести 15 цифр в поле "Номер карты"| Под полем "Номер карты" высвечивается сообщение "Неверный формат". Форма не отправляется на обработку.|
|          |                                                                               |2. Ввести валидные значения в поля: "месяц", "год", "Владелец карты", CVC/CVV ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                                |                             ||   
| ТС 42    | Оплата картой с номером, содержащим только нули        |1.Ввести в поле "Номер карты" 0000 0000 0000 0000 |Под полем "Номер карты" высвечивается сообщение "Неверный формат". Форма не отправляется на обработку.|            
|          |                                                                               |2. Ввести валидные значения в поля: "месяц", "год", "Владелец карты", CVC/CVV ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                                |                             ||   
| ТС 43    | Оплата картой с номером, который рандомно сгенерирован        |1.Ввести в поле "Номер карты" рандомно сгенерированый номер из 16 цифр: 2345 2154 3564 1125 | Система выдаёт сообщение: "Ошибка! Банк отказал в проведении операции"|            
|          |                                                                               |2. Ввести валидные значения в поля: "месяц", "год", "Владелец карты", CVC/CVV ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                                |                             ||   
| ТС 44    | Ввод в поле "месяц" одной цифры       |1.Ввести в поле "месяц" одну цифру: от 1 до 9 |Под полем "месяц" высвечивается сообщение "Неверный формат". Форма не отправляется на обработку.|
|          |                                                                               |2. Ввести валидные значения в поля: "номер карты", "год", "Владелец карты", CVC/CVV ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                                |                             ||   
| ТС 45    | Ввод в поле "месяц" числа больше 12       |1.Ввести в поле "месяц" числа больше 12: например 13  |Под полем "месяц" высвечивается сообщение "Неверный формат". Форма не отправляется на обработку.|
|          |                                                                               |2. Ввести валидные значения в поля: "номер карты", "год", "Владелец карты", CVC/CVV ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                               |                             ||   
| ТС 46    | Ввод в поле "месяц" нулей       |1. Ввести в поле "месяц" нули: 00  |Под полем "месяц" высвечивается сообщение "Неверный формат". Форма не отправляется на обработку.|
|          |                                                                               |2. Ввести валидные значения в поля: "номер карты", "год", "Владелец карты", CVC/CVV ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                               |                             ||   
| ТС 47    | Ввод в поле "год" значения предыдущего года       |1. Ввести в поле "год" значение прошлого года |Под полем "год" высвечивается сообщение "Истёк срок действия карты". Форма не отправляется на обработку.|
|          |                                                                               |2. Ввести валидные значения в поля: "номер карты", "месяц", "Владелец карты", CVC/CVV ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                               |                             ||   
| ТС 48    | Ввод в поле "год" значения года на 6 лет вперед от текущего      |1.Ввести в поле "год" значение года на 6 лет вперед от текущего  |Под полем "год" высвечивается сообщение "Неверно указан срок действия карты". Форма не отправляется на обработку.|
|          |                                                                               |2. Ввести валидные значения в поля: "номер карты", "месяц", "Владелец карты", CVC/CVV ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                               |                             ||   
| ТС 49    | Ввод в поле "Владелец" Имени и Фамилии на кириллице         |1.Ввести в поле "Владелец" Имя и Фамилию на кириллице | Под полем "Владелец" высвечивается сообщение "Неверный формат". Форма не отправляется на обработку.|
|          |                                                                               |2. Ввести валидные значения в поля: "номер карты", "месяц", "год", CVC/CVV ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                               |                             ||   
| ТС 50    | Ввод в поле "Владелец" только Имени         |1.Ввести в поле "Владелец" Имя без Фамилии | Под полем "Владелец" высвечивается сообщение "Неверный формат". Форма не отправляется на обработку.|
|          |                                                                               |2. Ввести валидные значения в поля: "номер карты", "месяц", "год", CVC/CVV ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                               |                             ||    
| ТС 51    | Ввод в поле "Владелец" числовые значения        |1.Ввести в поле "Владелец" число| Под полем "Владелец" высвечивается сообщение "Неверный формат". Форма не отправляется на обработку.|
|          |                                                                               |2. Ввести валидные значения в поля: "номер карты", "месяц", "год", CVC/CVV ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                               |                             ||    
| ТС 52    | Ввод в поле "Владелец" спец символов       |1.Ввести в поле "Владелец" спец символы| Под полем "Владелец" высвечивается сообщение "Неверный формат". Форма не отправляется на обработку.|
|          |                                                                               |2. Ввести валидные значения в поля: "номер карты", "месяц", "год", CVC/CVV ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                               |                             ||   
| ТС 53    | Ввод в поле "CVC/CVV" 2 цифр       |1.Ввести в поле "CVC/CVV" 2 цифры  | Под полем "CVC/CVV" высвечивается сообщение "Неверный формат". Форма не отправляется на обработку.|
|          |                                                                               |2. Ввести валидные значения в поля: "номер карты", "месяц", "год", "владелец" ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                               |                             ||    
| ТС 54    | Ввод в поле "CVC/CVV"  нулей       |1.Ввести в поле "CVC/CVV" нули: 000  | Под полем "CVC/CVV" высвечивается сообщение "Неверный формат". Форма не отправляется на обработку.|
|          |                                                                               |2. Ввести валидные значения в поля: "номер карты", "месяц", "год", "владелец" ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                               |                             ||    
| ТС 55    | Оставление поля "номер карты" пустым      |1.Оставить поле "номер карты" пустым  | Под полем "номер карты" высвечивается сообщение "Поле обязательно для заполнения". Форма не отправляется на обработку.|
|          |                                                                               |2. Ввести валидные значения в поля: "месяц", "год", "владелец", "CVC/CVV" ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                               |                             ||  
| ТС 56    | Оставление поля "месяц" пустым      |1.Оставить поле "месяц" пустым  | Под полем "месяц" высвечивается сообщение "Поле обязательно для заполнения". Форма не отправляется на обработку.|
|          |                                                                               |2. Ввести валидные значения в поля: "номер карты", "год", "владелец", "CVC/CVV" ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                               |                             ||  
| ТС 57    | Оставление поля "год" пустым      |1.Оставить поле "год" пустым  | Под полем "год" высвечивается сообщение "Поле обязательно для заполнения". Форма не отправляется на обработку.|
|          |                                                                               |2. Ввести валидные значения в поля: "номер карты", "месяц", "владелец", "CVC/CVV" ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                               |                             ||  
| ТС 58    | Оставление поля "владелец" пустым      |1.Оставить поле "владелец" пустым  | Под полем "владелец" высвечивается сообщение "Поле обязательно для заполнения". Форма не отправляется на обработку.|
|          |                                                                               |2. Ввести валидные значения в поля: "номер карты", "месяц", "год", "CVC/CVV" ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                               |                             ||  
| ТС 59    | Оставление поля "CVC/CVV" пустым      |1.Оставить поле "CVC/CVV" пустым  | Под полем "CVC/CVV" высвечивается сообщение "Поле обязательно для заполнения". Форма не отправляется на обработку.|
|          |                                                                               |2. Ввести валидные значения в поля: "номер карты", "месяц", "год", "владелец" ||
|          |                                                                               |3. Нажать кнопку "Продолжить"||
|          |                                               |                               |                             ||  
| ТС 60    | Отправка пустой формы      |1.Оставить все поля пустыми | Под всеми полями высвечивается сообщение "Поле обязательно для заполнения". Форма не отправляется на обработку.|
|          |                                                                               |2. Нажать кнопку "Продолжить"||


## Перечень используемых инструментов

 **1. Среда разработки - IntelliJ IDEA** ведущая IDE для разработки на Java. Помогает работать продуктивнее за счет интеллектуальной помощи в написании кода, надежных рефакторингов, быстрой навигации по коду, широкого набора встроенных инструментов разработчика, поддержки веб- и корпоративной разработки и многих других полезных возможностей.
 
 **2. Язык программирования: Java 11**
 
 **3. Cистема для автоматизации сборки: Gradle** Подробный и хорошо продуманный программный интерфейс упрощает отслеживание и настройку конфигурации сборки, контроль ее исполнения.
 
 **4. Фреймворк для модульного тестирования: JUnit 5**  мощное и гибкое обновление фреймворка JUnit, которое предоставляет множество улучшений и новых функций для написания тестов.
 
 **5. Фреймворк для автоматизации тестирования: Selenide** это фреймворк для автоматизированного тестирования веб-приложений на основе Selenium WebDriver, дающий следующие преимущества:
Изящный API, Стабильные тесты, Мощные селекторы, Простая конфигурация
 
 **6. Набор средств веб-разработки: DevTools**
 
 **7. Библиотеки: Lombok** (основанная на аннотациях библиотека Java, позволяющая сократить шаблонный код), **Faker**(библиотека, которая позволяет генерировать тестовые данные.), **Rest Assured**(библиотека для тестирования API. Она умеет делать две вещи: посылать запросы и проверять ответы.)
 
 **8. Система контроля версии: GIT** применяется для управления версиями и интегрирована со средой разработки
 
 **9. Система CI/CD: Appveyor** система непрерывной интеграции, которая служит для автоматизированной проверки кода, при его загрузке в общий репозиторий.

 **10. Платформа контейнеризации Docker** для развертывания контейнеров с базами данных MySQL и PostgreSQL и сервисов банка.
 
 **11. Система репортинга: Allure** инструмент для создания отчетов о результатах тестирования в автоматизированных тестовых сценариях. Он предоставляет красиво оформленные и интерактивные отчеты, которые позволяют легко анализировать результаты тестирования и принимать информированные решения на основе полученных данных.

## Перечень и описание возможных рисков при автоматизации
1. Отсутсвие спецификаций, описывающих поведение системы при позитивных и негативных сценариях 
2. Тестовая среда может не полностью отражать работу реальной системы, поэтому тесты могут пропустить дефекты, которые могут появится в рабочей системе
3. Изменения в UI могут привести к нарушению сценариев автоматизации.
4. Трудности при поиске и привязке тестов посредством локаторов элементов на веб-страницах.
   
## Интервальная оценка с учётом рисков в часах
1. Настройка и запуск SUT: 8 часов
2. Написание и отладка авто-тестов: 10 - 12 часов
3. Составление баг-репортов и отчёта по результатам проведения тестирования: 8 - 10 часов
4. Оформление финального отчёта по автоматизированному тестированию 8 часов
   
## План сдачи работы

Написание и прогон авто-тестов: 02.11.2023

Составление баг-репортов и отчёта по результатам тестов: 04.11.2023

Составление отчёта по результатам автоматизации: 08.11.2023
