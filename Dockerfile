FROM java:8
ADD /out/artifacts/CurrencyConverter_jar/CurrencyConverter.jar CurrencyConverter.jar
ENTRYPOINT ["java","-jar","CurrencyConverter.jar"]