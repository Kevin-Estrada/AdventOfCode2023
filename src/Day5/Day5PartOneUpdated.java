package Day5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.ReadFile;

public class Day5PartOneUpdated {

    public static String[] returnSourceRange(String source, String rangeNum) {
        String[] range = new String[(int) Long.parseLong(rangeNum)];
        for (int i = 0; i < range.length; i++) {
            range[i] = String.valueOf(Long.parseLong(source) + i);
        }
        return range;
    }

    public static String[] returnDestinationRange(String destination, String rangeNum) {
        String[] range = new String[(int) Long.parseLong(rangeNum)];
        for (int i = 0; i < range.length; i++) {
            range[i] = String.valueOf(Long.parseLong(destination) + i);
        }
        return range;
    }

    public static void main(String[] args) {
        ReadFile readFile = new ReadFile(
                "C:\\Users\\kestrada\\Documents\\Advent Of Code\\advent-of-code\\src\\Day5\\files\\File1.txt");
        String[] seeds = null;
        Map<Integer, List<String[]>> seedToSoilMap = new HashMap<>();
        Map<Integer, List<String[]>> soilToFertilizerMap = new HashMap<>();
        Map<Integer, List<String[]>> fertilizerToWaterMap = new HashMap<>();
        Map<Integer, List<String[]>> waterToLightMap = new HashMap<>();
        Map<Integer, List<String[]>> lightToTemperatureMap = new HashMap<>();
        Map<Integer, List<String[]>> temperatureToHumidityMap = new HashMap<>();
        Map<Integer, List<String[]>> humidityToLocationMap = new HashMap<>();
        List<Integer> listOfNums = new ArrayList<>();
        int count = 0;
        for (String line : readFile.getScannerIterable()) {
            if (line.contains("seeds:")) {
                seeds = line.split(":")[1].strip().split(" ");
            }

            if (line.contains("seed-to-soil map:")) {
                count++;
                for (int i = count; i <= readFile.getScannerIterable().size(); i++) {
                    if (!readFile.getScannerIterable().get(i).equals("")) {
                        String[] nums = readFile.getScannerIterable().get(i).split(" ");
                        String[] source = returnSourceRange(nums[1], nums[2]);
                        String[] destination = returnSourceRange(nums[0], nums[2]);
                        List<String[]> listNums = new ArrayList<>();
                        listNums.add(source);
                        listNums.add(destination);
                        seedToSoilMap.put(i, listNums);
                    } else {
                        break;
                    }
                }
            }

            if (line.contains("soil-to-fertilizer map:")) {
                for (int i = count; i <= readFile.getScannerIterable().size(); i++) {
                    if (!readFile.getScannerIterable().get(i).equals("")) {
                        String[] nums = readFile.getScannerIterable().get(i).split(" ");
                        String[] source = returnSourceRange(nums[1], nums[2]);
                        String[] destination = returnSourceRange(nums[0], nums[2]);
                        List<String[]> listNums = new ArrayList<>();
                        listNums.add(source);
                        listNums.add(destination);
                        soilToFertilizerMap.put(i, listNums);
                    } else {
                        break;
                    }
                }
            }

            if (line.contains("fertilizer-to-water map:")) {
                for (int i = count; i <= readFile.getScannerIterable().size(); i++) {
                    if (!readFile.getScannerIterable().get(i).equals("")) {
                        String[] nums = readFile.getScannerIterable().get(i).split(" ");
                        String[] source = returnSourceRange(nums[1], nums[2]);
                        String[] destination = returnSourceRange(nums[0], nums[2]);
                        List<String[]> listNums = new ArrayList<>();
                        listNums.add(source);
                        listNums.add(destination);
                        fertilizerToWaterMap.put(i, listNums);
                    } else {
                        break;
                    }
                }
            }

            if (line.contains("water-to-light map:")) {
                for (int i = count; i <= readFile.getScannerIterable().size(); i++) {
                    if (!readFile.getScannerIterable().get(i).equals("")) {
                        String[] nums = readFile.getScannerIterable().get(i).split(" ");
                        String[] source = returnSourceRange(nums[1], nums[2]);
                        String[] destination = returnSourceRange(nums[0], nums[2]);
                        List<String[]> listNums = new ArrayList<>();
                        listNums.add(source);
                        listNums.add(destination);
                        waterToLightMap.put(i, listNums);
                    } else {
                        break;
                    }
                }
            }

            if (line.contains("light-to-temperature map:")) {
                for (int i = count; i <= readFile.getScannerIterable().size(); i++) {
                    if (!readFile.getScannerIterable().get(i).equals("")) {
                        String[] nums = readFile.getScannerIterable().get(i).split(" ");
                        String[] source = returnSourceRange(nums[1], nums[2]);
                        String[] destination = returnSourceRange(nums[0], nums[2]);
                        List<String[]> listNums = new ArrayList<>();
                        listNums.add(source);
                        listNums.add(destination);
                        lightToTemperatureMap.put(i, listNums);
                    } else {
                        break;
                    }
                }
            }

            if (line.contains("temperature-to-humidity map:")) {
                for (int i = count; i <= readFile.getScannerIterable().size(); i++) {
                    if (!readFile.getScannerIterable().get(i).equals("")) {
                        String[] nums = readFile.getScannerIterable().get(i).split(" ");
                        String[] source = returnSourceRange(nums[1], nums[2]);
                        String[] destination = returnSourceRange(nums[0], nums[2]);
                        List<String[]> listNums = new ArrayList<>();
                        listNums.add(source);
                        listNums.add(destination);
                        temperatureToHumidityMap.put(i, listNums);
                    } else {
                        break;
                    }
                }
            }

            if (line.contains("humidity-to-location map:")) {
                for (int i = count; i < readFile.getScannerIterable().size(); i++) {
                    if (!readFile.getScannerIterable().get(i).equals("")) {
                        String[] nums = readFile.getScannerIterable().get(i).split(" ");
                        String[] source = returnSourceRange(nums[1], nums[2]);
                        String[] destination = returnSourceRange(nums[0], nums[2]);
                        List<String[]> listNums = new ArrayList<>();
                        listNums.add(source);
                        listNums.add(destination);
                        humidityToLocationMap.put(i, listNums);
                    } else {
                        break;
                    }
                }
            }
            count++;
        }

        for (int k = 0; k < seeds.length; k++) {
            System.out.println("===============================================");
            System.out.println("================LOOP SEED BEGIN================");
            System.out.println("===============================================");
            String finalSeedValue = seeds[k];
            System.out.println("Seed value is: " + finalSeedValue);
            int index = -1;
            boolean endloop = false;
            for (Map.Entry<Integer, List<String[]>> entry : seedToSoilMap.entrySet()) {
                int counter = 0;
                if (!endloop) {
                    boolean sourceFound = false;
                    for (String[] arr : entry.getValue()) {
                        if (counter == 0) {
                            for (int i = 0; i < arr.length; i++) {
                                if (!sourceFound && index == -1) {
                                    if (finalSeedValue.equals(arr[i])) {
                                        index = i;
                                        sourceFound = true;
                                    }
                                } else {
                                    finalSeedValue = arr[index];
                                    endloop = true;
                                    counter++;
                                }
                            }
                            counter++;
                        } else {
                            if(index != -1) {
                                finalSeedValue = arr[index];
                                endloop = true;
                                counter++;
                            }
                        }
                    }
                }
            }
            System.out.println("Soil value: " + finalSeedValue);
            endloop = false;
            index = -1;
            for (Map.Entry<Integer, List<String[]>> entry : soilToFertilizerMap.entrySet()) {
                int counter = 0;
                if (!endloop) {
                    boolean sourceFound = false;
                    for (String[] arr : entry.getValue()) {
                        if (counter == 0) {
                            for (int i = 0; i < arr.length; i++) {
                                if (!sourceFound && index == -1) {
                                    if (finalSeedValue.equals(arr[i])) {
                                        index = i;
                                        sourceFound = true;
                                    }
                                } else {
                                    finalSeedValue = arr[index];
                                    endloop = true;
                                    counter++;
                                }
                            }
                            counter++;
                        } else {
                            if(index != -1) {
                                finalSeedValue = arr[index];
                                endloop = true;
                                counter++;
                            }
                        }
                    }
                }
            }
            System.out.println("Fertilizer value: " + finalSeedValue);
            endloop = false;
            index = -1;

            for (Map.Entry<Integer, List<String[]>> entry : fertilizerToWaterMap.entrySet()) {
                int counter = 0;
                if (!endloop) {
                    boolean sourceFound = false;
                    for (String[] arr : entry.getValue()) {
                        if (counter == 0) {
                            for (int i = 0; i < arr.length; i++) {
                                if (!sourceFound && index == -1) {
                                    if (finalSeedValue.equals(arr[i])) {
                                        index = i;
                                        sourceFound = true;
                                    }
                                } else {
                                    finalSeedValue = arr[index];
                                    endloop = true;
                                    counter++;
                                }
                            }
                            counter++;
                        } else {
                            if(index != -1) {
                                finalSeedValue = arr[index];
                                endloop = true;
                                counter++;
                            }
                        }
                    }
                }
            }
            System.out.println("Water value: " + finalSeedValue);
            endloop = false;
            index = -1;

            for (Map.Entry<Integer, List<String[]>> entry : waterToLightMap.entrySet()) {
                int counter = 0;
                if (!endloop) {
                    boolean sourceFound = false;
                    for (String[] arr : entry.getValue()) {
                        if (counter == 0) {
                            for (int i = 0; i < arr.length; i++) {
                                if (!sourceFound && index == -1) {
                                    if (finalSeedValue.equals(arr[i])) {
                                        index = i;
                                        sourceFound = true;
                                    }
                                } else {
                                    finalSeedValue = arr[index];
                                    endloop = true;
                                    counter++;
                                }
                            }
                            counter++;
                        } else {
                            if(index != -1) {
                                finalSeedValue = arr[index];
                                endloop = true;
                                counter++;
                            }
                        }
                    }
                }
            }
            System.out.println("Light value: " + finalSeedValue);
            endloop = false;
            index = -1;

            for (Map.Entry<Integer, List<String[]>> entry : lightToTemperatureMap.entrySet()) {
                int counter = 0;
                if (!endloop) {
                    boolean sourceFound = false;
                    for (String[] arr : entry.getValue()) {
                        if (counter == 0) {
                            for (int i = 0; i < arr.length; i++) {
                                if (!sourceFound && index == -1) {
                                    if (finalSeedValue.equals(arr[i])) {
                                        index = i;
                                        sourceFound = true;
                                    }
                                } else {
                                    finalSeedValue = arr[index];
                                    endloop = true;
                                    counter++;
                                }
                            }
                            counter++;
                        } else {
                            if(index != -1) {
                                finalSeedValue = arr[index];
                                endloop = true;
                                counter++;
                            }
                        }
                    }
                }
            }
            System.out.println("Temperature value: " + finalSeedValue);
            endloop = false;
            index = -1;

            for (Map.Entry<Integer, List<String[]>> entry : temperatureToHumidityMap.entrySet()) {
                int counter = 0;
                if (!endloop) {
                    boolean sourceFound = false;
                    for (String[] arr : entry.getValue()) {
                        if (counter == 0) {
                            for (int i = 0; i < arr.length; i++) {
                                if (!sourceFound && index == -1) {
                                    if (finalSeedValue.equals(arr[i])) {
                                        index = i;
                                        sourceFound = true;
                                    }
                                } else {
                                    finalSeedValue = arr[index];
                                    endloop = true;
                                    counter++;
                                }
                            }
                            counter++;
                        } else {
                            if(index != -1) {
                                finalSeedValue = arr[index];
                                endloop = true;
                                counter++;
                            }
                        }
                    }
                }
            }
            System.out.println("Humidity value: " + finalSeedValue);
            endloop = false;
            index = -1;

            for (Map.Entry<Integer, List<String[]>> entry : humidityToLocationMap.entrySet()) {
                int counter = 0;
                if (!endloop) {
                    boolean sourceFound = false;
                    for (String[] arr : entry.getValue()) {
                        if (counter == 0) {
                            for (int i = 0; i < arr.length; i++) {
                                if (!sourceFound && index == -1) {
                                    if (finalSeedValue.equals(arr[i])) {
                                        index = i;
                                        sourceFound = true;
                                    }
                                } else {
                                    finalSeedValue = arr[index];
                                    endloop = true;
                                    counter++;
                                }
                            }
                            counter++;
                        } else {
                            if(index != -1) {
                                finalSeedValue = arr[index];
                                endloop = true;
                                counter++;
                            }
                        }
                    }
                }
            }
            listOfNums.add(Integer.parseInt(finalSeedValue));
            System.out.println("Location value: " + finalSeedValue);
            endloop = false;
            index = -1;

        }

        int lowestNumberLocation = Integer.MAX_VALUE;
        for(Integer num: listOfNums) {
            if(num < lowestNumberLocation) {
                lowestNumberLocation = num;
            }
        }
        System.out.println("The lowest location number is: " + lowestNumberLocation);
    }
}
