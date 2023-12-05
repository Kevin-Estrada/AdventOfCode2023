package Day4;

import java.util.Arrays;

import utils.ReadFile;

public class Day4PartOne {
    public static void main(String[] args) {
        ReadFile readFile = new ReadFile(
                "C:\\Users\\kestrada\\Documents\\Advent Of Code\\advent-of-code\\src\\Day4\\File1.txt");

        int sum = 0;
        for (String line : readFile.getScannerIterable()) {
            String[] splitLine = line.split(":");
            String[] splitLineNumbers = splitLine[1].split("\\|");
            String[] winningNumbers = splitLineNumbers[0].trim().split(" ");
            String[] playerNumbers = splitLineNumbers[1].trim().split(" ");
            int count = 0;
            for(int i = 0; i < playerNumbers.length; i++) {
                for(String winningNumber : winningNumbers) {
                    if(!playerNumbers[i].equals("") && !winningNumber.equals("") && Integer.parseInt(playerNumbers[i]) == Integer.parseInt(winningNumber)) {
                        if(count == 0) {
                            count++;
                        } else {
                            count *= 2;
                        }
                        break;
                    }
                }
            }
            sum += count;
        }
        System.out.println(sum);
    }
}
