# SpringBootTasks
В рамках данной работы необходимо написать SpringBoot+Thymeleaf приложение, реализующее следующий функционал:

Реализовать форму для записи данных о пользователе, содержащую фамилию, имя, отчество, возраст, уровень зарплаты, адрес электронной почты и место работы. Данные должны записываться в файл в выбранном вами формате. Для простоты можно считать, что файл создан на backend e и находится в classpath вашего приложения. Формат хранения записей может быть произвольным.

Необходимо выполнять простейшую валидацию входных данных. Критерии валидации придумать самостоятельно. Но не менее чем для двух полей. Можно и нужно активно использовать регулярные выражения.

Обеспечить возможность получения данных о пользователе по фамилии и имени. Если пользователь найден, то дополнительно к выводимой информации добавить текущее время и имя браузера (user-agent) с которого был выполнен запрос. Если такого пользователя нет в файле, то выполнить переадресацию (redirect) на страницу с сообщением что пользователь не найден. Либо вернуть подходящий для данного случая статус код (см. HTTP protocol RFC document) используя ResponseEntity сущность.

Реализовать возможность загрузки данных о пользователе из внешнего файла (file upload).

Реализовать возможность отправки текстового сообщения на почту пользователя.   

build:

$ mvn clean install

build (skip tests):

$ mvn -Dmaven.test.skip=true clean install

run:

$ mvn spring-boot:run -Dspring-boot.run.profiles=development

email:

Используется FakeSPTP: https://github.com/Nilhcem/FakeSMTP#usage-on-docker

java -jar fakeSMTP-2.0.jar -p 10050