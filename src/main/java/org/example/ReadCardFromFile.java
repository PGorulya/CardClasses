package org.example;
;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ReadCardFromFile {

    public List<String> readFromFile(String filePath) {
        List<String> list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            list = stream
                    .filter(str -> str.length() > 0)
                    .map(str -> str.concat("\n"))
                    .toList();

            return personParser(list);

        } catch (IOException | ParserException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> personParser(List<String> list) throws ParserException {
        List<String> list1 = new ArrayList<>();
        String strNew = "";
        boolean wasStart = false;
        for (String str : list) {
            if (str.contains("END")) {
                wasStart = false;
                list1.add(strNew);
            }
            if (!str.contains("START") && !str.contains("END")) {
                if (!wasStart) throw new ParserException("Missed keyword \"START\" ");
                strNew = strNew.concat(str);
            }
            if (str.contains("START")) {
                if (wasStart) throw new ParserException("Missed keyword \"END\" ");
                wasStart = true;
                strNew = "";
            }
        }

        return list1;
    }
}