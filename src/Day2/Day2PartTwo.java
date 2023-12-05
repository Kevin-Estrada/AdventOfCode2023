package Day2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import utils.ReadFile;

public class Day2PartTwo {
    public static void main(String[] args) {
        ReadFile readFile = new ReadFile(
                "C:\\Users\\kestrada\\Documents\\Advent Of Code\\advent-of-code\\src\\Day2\\files\\File2.txt");
        int sum = 0;

        for (String line : readFile.getScannerIterable()) {
            // System.out.println(Arrays.toString(line.split(":")));
            String[] splitLine = line.split(":");
            String gameName = splitLine[0];
            // System.out.println("Starting " + gameName);
            Map<String, Integer> colorMap = new HashMap<>();
            colorMap.put("red", 0);
            colorMap.put("green", 0);
            colorMap.put("blue", 0);
            for (String games : splitLine[1].split(";")) {
                // System.out.println("Doing game: " + games);
                for (String singleGame : games.split(",")) {
                    singleGame = singleGame.strip();
                    String gameColor = singleGame.split(" ")[1];
                    // System.out.println("Game color: " + gameColor);
                    // System.out.println("Game Number: " + singleGame.split(" ")[0]);
                    int gameColorNumber = Integer.parseInt(singleGame.split(" ")[0]);
                    if (colorMap.get(gameColor) < gameColorNumber) {
                        colorMap.put(gameColor, gameColorNumber);
                    }
                }
            }
            int multiplcationNum = 1;
            for(Map.Entry<String,Integer> entry : colorMap.entrySet()) {
                // System.out.println("Least amount of colors that is needed for " + entry.getKey() + " is: " + entry.getValue());
                multiplcationNum *= entry.getValue();
            }
            sum += multiplcationNum;
        }
        System.out.println("Sum is: " + sum);
    }
}
