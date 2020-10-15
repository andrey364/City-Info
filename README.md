# City-Info

1)Имя бота attractionsCityBot
2)Токен 1222201659:AAGRKMDlKb7pLmsEBHdzO-5JEZbQJZTrN8w

Для запуска необходима java 1.8 или выше, PostgreSQL, Telegram;

На gitHub добавлен бэкап БД, необходимый для тестирования приложения (CityInfo.backup);
Для его развёртывания под системой linux необходимо скачать бэкап и перекинуть его на машину с установленным postgres:
1) Запустить утилиту для управления СУБД; psql TARGET_DB_NAME
2) Создать пустую схему: create schema public;
3) Выйти из утилиты управления СУБД; \q
4) Выоплнить команду восстановления БД; pg_restore -Ft /путь к бэкапу/CityInfo.backup -d TARGET_DB_NAME

В src/main/resources/application.properties необходимо поменять значение у переменных
spring.datasource.url=jdbc:postgresql://ip_address:port/NAME_DB
spring.datasource.username=USERNAME
spring.datasource.password=PASSWORD

