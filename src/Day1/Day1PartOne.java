package Day1;

import java.util.ArrayList;

import utils.ReadFile;

public class Day1PartOne {
    public static void main(String[] args) {
        ReadFile readFile = new ReadFile(
                "C:\\Users\\kestrada\\Documents\\Advent Of Code\\advent-of-code\\src\\Day1\\File1.txt");
        ArrayList<String> total = new ArrayList<>();
        for (String line : readFile.getScannerIterable()) {
            String temp = "";
            char[] charArr = line.toCharArray();
            for (char c : charArr) {
                if (Character.isDigit(c)) {
                    temp += c;
                }
            }
            String numTemp = new StringBuilder().append(temp.charAt(0)).append(temp.charAt(temp.length() - 1))
                    .toString();
            total.add(numTemp);
        }
        int sum = 0;
        for (String num : total) {
            sum += Integer.parseInt(num);
        }
        System.out.println(sum);
    }
}
