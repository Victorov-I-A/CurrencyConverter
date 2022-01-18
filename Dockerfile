FROM gradle:7.1-jdk16 AS build
ENV APP_HOME=/CurrencyConverter/
WORKDIR $APP_HOME
COPY . ./
RUN gradle build

FROM openjdk:16-alpine
ENV APP_HOME=/CurrencyConverter/
WORKDIR /CurrencyConverter
COPY --from=build $APP_HOME/build/CurrencyConverter-1.0-SNAPSHOT.jar ./

ENTRYPOINT ["java", "-jar", "CurrencyConverter-1.0-SNAPSHOT.jar"]