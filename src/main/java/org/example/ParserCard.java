package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserCard {
    public void parse(String data) {
        if (data.isEmpty()) return;
        String regex = "^(Name|Card number|CVV|Year|Month):(.+)";
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(data);

        String name = "";
        String cardNumber = "";
        String cvv = "";
        String year = "";
        String month = "";

        while (matcher.find()) {
            String group1 = matcher.group(1);
            String group2 = matcher.group(2);
            switch (group1) {
                case ("Name") -> name = group2.trim();
                case ("Card number") -> cardNumber = group2.trim();
                case ("CVV")-> cvv = group2.trim();
                case ("Year")-> year = group2.trim();
                case ("Month")-> month = group2.trim();
            }
        }
        System.out.printf("FullName: %-25s\t Card number: %-16s\t CVV: %-3s\t Year: %-3s\t Month: %-3s\n",
                name, cardNumber, cvv, year, month);
    }

}
