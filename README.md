# People Listing with two DB

Данный проект создан для практики на основе простого CRUD'a с использованием MongoDB и PostgreSQL.
## Описание

В проекты были использованы технологий Docker, Liquidbase, Spring Framework, Hibernate, JPA, REST API.
Проект был написано мной и исключительно мной. Проект сыроват, ибо был сделан на коленке за короткое время и не носит серьезного характера, но даже так, является небольшим доказательством моих способностей работы с вышеперечисленными технологиями, инструментами, ORM и так далее. Проект стал отличной практикой знаний Git, Docker(разворачивание проекта на Linux через терминал), работы с БД.
## Особенности

- Полный список технологий/Инструментов: Java, Spring Framework, Liquidbase, Hibernate, JPA, PostgreSQL, MongoDB, Postman, DBeaver CE, Lombok, Gradle, Git, Linux(Fedora 38) 
- Пагинация
- Проект будет полезен для абсолютных новичков, для представления какие технологий и как они используются в реальных проектах в компаниях(+-Даже так, это еще очень далеко от реальных проектов, =D, не берите слишком в серьез)

## Установка

1. Клонируйте репозиторий: `git clone https://github.com/ваш-пользователь/ваш-репозиторий.git`
2. Установите все зависимости в Gradle
3. Поднимите базы данных через Docker

###  Запуск Docker'a
```bash
systemctl --user start docker-desktop
```

### Скачивание PostgreSQL(В случае если у вас его нет)
Я использую Linux(Fedora 38) для всех этих целей,sudo - действие от имени администратора, у вас возможно будет иная команда, ибо GUI для слабаков и жизнь для айтишника без геморроя(Linux) -  не жизнь! 
```bash
sudo docker pull postgres
```
### Запуск изображения PostgreSQL
```bash
sudo docker run --name postgres-11 -d -p 2023:5432 -e POSTGRES_PASSWORD=postgres postgres
```

### Скачивание и запуск изображения MongoDB
```bash
sudo docker run -d --name mongodb-container mongodb-img
```

## Запуск
После всех этих танцев с бубнем вы можете запустить проект у себя на компьютере(Не факт :DDD lol).

