package org.example;

import com.github.javafaker.Faker;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.CreditCardType;

import java.time.LocalDate;
import java.util.Random;

public class Card {
    private final String name;
    private final String cardNumber;
    private final int cvv;

    private final String yearOfExp;
    private final String monthOfExp;


    public Card() {
        Faker faker = new Faker();
        MockNeat mockNeat = MockNeat.threadLocal();
        Random random = new Random();
        LocalDate localDate = LocalDate.now();

        this.name = faker.name().fullName();
        this.cardNumber = mockNeat.creditCards().type(CreditCardType.VISA_16).get();
        this.cvv = random.nextInt(100, 999);
        this.yearOfExp = String.valueOf(localDate.getYear() + 3);
        this.monthOfExp = String.valueOf(localDate.getMonthValue());
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\n" + "Card number: " + cardNumber +
                "\n" + "CVV: " + cvv +
                "\n" + "Year: " + yearOfExp +
                "\n" + "Month: " + monthOfExp + "\n";
    }
}
