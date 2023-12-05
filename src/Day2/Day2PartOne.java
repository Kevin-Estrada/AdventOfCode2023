package Day2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import utils.ReadFile;

public class Day2PartOne {
    public static void main(String[] args) {
        ReadFile readFile = new ReadFile(
                "C:\\Users\\kestrada\\Documents\\Advent Of Code\\advent-of-code\\src\\Day2\\files\\File1.txt");
        int sum = 0;
        Map<String, Integer> colorMap = new HashMap<>();
        colorMap.put("red", 12);
        colorMap.put("green", 13);
        colorMap.put("blue", 14);

        for (String line : readFile.getScannerIterable()) {
            System.out.println(Arrays.toString(line.split(":")));
            String[] splitLine = line.split(":");
            String gameName = splitLine[0];
            System.out.println("Starting " + gameName);
            boolean possible = true;
            for (String games : splitLine[1].split(";")) {
                // System.out.println("Doing game: " + games);
                for (String singleGame : games.split(",")) {
                    singleGame = singleGame.strip();
                    String gameColor = singleGame.split(" ")[1];
                    // System.out.println("Game color: " + gameColor);
                    // System.out.println("Game Number: " + singleGame.split(" ")[0]);
                    int gameColorNumber = Integer.parseInt(singleGame.split(" ")[0]);
                    if (colorMap.get(gameColor) < gameColorNumber) {
                        System.out.println(gameName + " is not possible so putting as false");
                        possible = false;
                        break;
                    }
                }
            }
            if (possible) {
                sum += Integer.parseInt(gameName.split(" ")[1]);
            }
        }
        System.out.println("The sum is: " + sum);
    }
}