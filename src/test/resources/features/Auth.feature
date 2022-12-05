#language:ru

Функциональность: Перевод 5.000 р на карту *0001 успешно авторизованного пользователя

  # пример теста с одним набором параметров
  Структура сценария: : Перевод средств с одной карты на другую в ЛК (позитивный)
    Пусть открыта страница с формой авторизации <url>
    Когда пользователь пытается авторизоваться с именем <login> и паролем <password>
    И пользователь вводит проверочный код 'из смс' <verificationCode>
    И пользователь вызывает кнопку Пополнения карты с id <numberIdCard>
    И пользователь вводит сумму <amount> для пополнения с карты <cardNumber>
    Тогда баланс карты <numberIdCard> == <balance>
    Примеры:
      | url                     | login   | password    | verificationCode | numberIdCard                                     | amount | cardNumber          |balance|
      | "http://localhost:9999" | "vasya" | "qwerty123" | "12345"          | "92df3f1c-a033-48e6-8390-206f6b1f56c0"           | 5000   |"5559 0000 0000 0002"|15000  |