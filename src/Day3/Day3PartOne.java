package Day3;

import utils.ReadFile;

public class Day3PartOne {
    public static void main(String[] args) {
        ReadFile readFile = new ReadFile(
                "C:\\Users\\kestrada\\Documents\\Advent Of Code\\advent-of-code\\src\\Day3\\File1.txt");

        for (String line : readFile.getScannerIterable()) {
            System.out.println(line);
        }
    }
}
