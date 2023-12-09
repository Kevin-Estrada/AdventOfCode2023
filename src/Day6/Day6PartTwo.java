package Day6;

import utils.ReadFile;

public class Day6PartTwo {

    public static long calculateWaysToWin(String time, String distance) {
        long waysToWin = 0;
        long timeNumber = Long.parseLong(time);
        long loopCounter = timeNumber;
        long distanceNumber = Long.parseLong(distance);
        for(long i = 0; i <= loopCounter; i++) {
            // System.out.println(i + " * " + timeNumber + " = " + (i * timeNumber));
            long totalDistanceToTravel = i * timeNumber;
            if(totalDistanceToTravel > distanceNumber) {
                waysToWin++;
            }
            timeNumber--;
        }
        return waysToWin;
    }
    public static void main(String[] args) {
        String fullTime = "";
        String fullDistance = "";
        ReadFile readFile = new ReadFile(
                "C:\\Users\\kestrada\\Documents\\Advent Of Code\\advent-of-code\\src\\Day6\\files\\File2.txt");
        for (String line : readFile.getScannerIterable()) {
            System.out.println(line);
            if(line.startsWith("Time:")) {
                String [] timeNumbersTemp= line.trim().replace("Time:", "").trim().split("\\s+");
                for(int i = 0; i < timeNumbersTemp.length; i++) {
                    fullTime += timeNumbersTemp[i].trim();
                }
            }
            if(line.startsWith("Distance:")) {
                String [] distanceNumbersTemp = line.trim().replace("Distance:", "").trim().split("\\s+");
                for(int i = 0; i < distanceNumbersTemp.length; i++) {
                    fullDistance += distanceNumbersTemp[i].trim();
                }
            }
        }

        // System.out.println(fullTime);
        // System.out.println(fullDistance);

        long sum = calculateWaysToWin(fullTime, fullDistance);
        System.out.println(sum);
    }
}
