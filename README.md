# qa_guru_11
# UI autotests for awg.ru

## Technology stack
Java, Gradle, Junit5, Selenide, Allure Report, Jenkins, Selenoid, Telegram Bot.

## Dependencies
* Java 11
* Selenide 5.20.1
* JUnit 5.7.0
* Aspectj 1.9.5
* Owner 1.0.12
* Allure-selenide 2.13.9
* Allure plugin 2.8.1

## Run tests with use terminal:

### For run local tests need call command:

> gradle test

### For run remote tests need fill example.properties or to pass value:

* remote.driver.url (url address from selenoid or grid)
* remote.driver.user (name user if required for available to selenoid/grid)
* remote.driver.password (password user if required for available to selenoid/grid)
* remote.browser.name (chrome, firefox)
* threads (number of threads, default 2)

> gradle clean -Dremote.driver.url= -Dthreads=
