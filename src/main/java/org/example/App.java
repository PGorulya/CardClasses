package org.example;

/*
Сделать классы

        Карта с полями - номер имя фамилия cvv дата

        Для хранения этих данных ОДНОЙ СТРИНГОЙ

        для генерации ИмениФамилии итд

        для хранения всех данных

        для записи всех данных в файл

        для чтения всех данных из файла

        для парсинга регулярными выражениями и там же для предоставления этих данных при помощи printF в красивом виде

        Далее:
        Должны быть проверки на корректные даты - формат ММ/ГГ
        Все отдельным проектом
*/
public class App {
    public static void main(String[] args) {
        WriteCardToFile writeCardToFile = new WriteCardToFile();
        ReadCardFromFile dataCards = new ReadCardFromFile();
        ParserCard parserCard = new ParserCard();
        DataBase dataBase = new DataBase();

        Card[] user = {
                new Card(),
                new Card(),
                new Card(),
                new Card(),
                new Card()
        };
        for (Card us: user) {
            dataBase.add(us);
        }

        for (Card us : user) {
            writeCardToFile.toFile(us.toString(), "datacards.txt",true);
        }

        dataCards.readFromFile("datacards.txt").forEach(parserCard::parse);
    }
}
