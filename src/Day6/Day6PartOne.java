package Day6;

import utils.ReadFile;

public class Day6PartOne {

    public static int calculateWaysToWin(String time, String distance) {
        int waysToWin = 0;
        int timeNumber = Integer.parseInt(time);
        int loopCounter = timeNumber;
        int distanceNumber = Integer.parseInt(distance);
        for(int i = 0; i <= loopCounter; i++) {
            // System.out.println(i + " * " + timeNumber + " = " + (i * timeNumber));
            int totalDistanceToTravel = i * timeNumber;
            if(totalDistanceToTravel > distanceNumber) {
                waysToWin++;
            }
            timeNumber--;
        }
        return waysToWin;
    }

    public static void main(String[] args) {
        String[] timeNumbers = null;
        String[] distanceNumbers = null;
        ReadFile readFile = new ReadFile(
                "C:\\Users\\kestrada\\Documents\\Advent Of Code\\advent-of-code\\src\\Day6\\files\\File1.txt");
        for (String line : readFile.getScannerIterable()) {
            System.out.println(line);
            if(line.startsWith("Time:")) {
                String [] timeNumbersTemp= line.trim().replace("Time:", "").trim().split("\\s+");
                timeNumbers = new String[timeNumbersTemp.length];
                for(int i = 0; i < timeNumbersTemp.length; i++) {
                    timeNumbers[i] = timeNumbersTemp[i].trim();
                }
            }
            if(line.startsWith("Distance:")) {
                String [] distanceNumbersTemp = line.trim().replace("Distance:", "").trim().split("\\s+");
                distanceNumbers = new String[distanceNumbersTemp.length];
                for(int i = 0; i < distanceNumbersTemp.length; i++) {
                    distanceNumbers[i] = distanceNumbersTemp[i].trim();
                }
            }
        }

        int sum = 1;
        for(int i = 0; i < timeNumbers.length; i++) {
            int totalWaysToWinRace = calculateWaysToWin(timeNumbers[i], distanceNumbers[i]);
            System.out.println("Total ways to win race with " + distanceNumbers[i] + " record: "+ totalWaysToWinRace);
            sum *= totalWaysToWinRace;
        }
        System.out.println(sum);
    }
}
