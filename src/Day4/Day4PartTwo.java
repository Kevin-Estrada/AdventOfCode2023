package Day4;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import utils.ReadFile;

public class Day4PartTwo {
    public static void main(String[] args) {
        ReadFile readFile = new ReadFile(
                "C:\\Users\\kestrada\\Documents\\Advent Of Code\\advent-of-code\\src\\Day4\\files\\File2.txt");

        Map<String, Integer> scratchTicketMap = new LinkedHashMap<>();
        List<String> listOfCards = new LinkedList<>();
        for (String line : readFile.getScannerIterable()) {
            scratchTicketMap.put(line, 1);
            listOfCards.add(line);
        }
        for (int i = 0; i < listOfCards.size();i++) {
            String[] splitLine = listOfCards.get(i).split(":");
            String[] splitLineNumbers = splitLine[1].split("\\|");
            String[] winningNumbers = splitLineNumbers[0].trim().split(" ");
            String[] playerNumbers = splitLineNumbers[1].trim().split(" ");
            int count = 0;
            for (int j = 0; j < playerNumbers.length; j++) {
                for (String winningNumber : winningNumbers) {
                    if (!playerNumbers[j].equals("") && !winningNumber.equals("")
                            && Integer.parseInt(playerNumbers[j]) == Integer.parseInt(winningNumber)) {
                        count++;
                    }
                }
            }
            System.out.println("Going into the count for loop");
            if(count > 0) {
                for(int z = 0; z < count; z++) {
                    System.out.println(listOfCards.get(z));
                }
            }
            // System.out.println(listOfCards);
        }
    }
}