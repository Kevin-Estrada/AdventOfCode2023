package Day1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import utils.ReadFile;

public class Day1PartTwo {
    public static void main(String[] args) {
        HashMap<String,String> numberMap = new HashMap<>();
        numberMap.put("one", "1");
        numberMap.put("two", "2");
        numberMap.put("three", "3");
        numberMap.put("four", "4");
        numberMap.put("five", "5");
        numberMap.put("six", "6");
        numberMap.put("seven", "7");
        numberMap.put("eight", "8");
        numberMap.put("nine", "9");
        ReadFile readFile = new ReadFile(
                "C:\\Users\\kestrada\\Documents\\Advent Of Code\\advent-of-code\\src\\Day1\\File2.txt");
        ArrayList<String> total = new ArrayList<>();
        for (String line : readFile.getScannerIterable()) {
            for(Entry<String,String> entry : numberMap.entrySet()) {
                line = line.replace(entry.getKey(), entry.getValue());
            }
            System.out.println(line);
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
