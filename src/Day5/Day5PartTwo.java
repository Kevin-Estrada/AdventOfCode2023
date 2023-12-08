package Day5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import utils.ReadFile;

public class Day5PartTwo {
    public static void main(String[] args) {

        ReadFile readFile = new ReadFile(
                "C:\\Users\\kestrada\\Documents\\Advent Of Code\\advent-of-code\\src\\Day5\\files\\File2.txt");
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

        ExecutorService fixedPool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < seeds.size(); i += 2) {
            long start = seeds.get(i);
            long len = seeds.get(i + 1);
            fixedPool.submit(new TestThread(start, len, converters));
        }
        fixedPool.shutdown();
    }
}
