package Day5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.ReadFile;

public class Day5PartOne {

    public static void main(String[] args) {
        ReadFile readFile = new ReadFile(
                "C:\\Users\\kestrada\\Documents\\Advent Of Code\\advent-of-code\\src\\Day5\\files\\File1.txt");
        Map<String, Converter> converters = new HashMap<>();
        List<Long> seeds = new ArrayList<>();

        Converter currentConverter = null;
        for (String line : readFile.getScannerIterable()) {
            if (line.isBlank())
                continue;
            if (line.startsWith("seeds:")) {
                for (String seed : line.replace("seeds:", "").trim().split(" ")) {
                    seeds.add(Long.parseLong(seed));
                }
            } else {
                if (line.matches("^\\d.*")) {
                    currentConverter.addRange(line);
                } else {
                    String[] parts = line.split("-");
                    currentConverter = new Converter(parts[0], parts[2].replace("map:", "").trim());
                    converters.put(parts[0], currentConverter);
                }
            }

        }

        long smallestValue = Long.MAX_VALUE;
        for (long seed : seeds) {
            String destination = "seed";
            long value = seed;
            while (!destination.equals("location")) {
                Converter currentConvert = converters.get(destination);
                destination = currentConvert.getDestination();
                value = currentConvert.getDestinationValue(value);
            }

            if (value < smallestValue) {
                smallestValue = value;
            }
        }
        System.out.println(smallestValue);
    }
}
