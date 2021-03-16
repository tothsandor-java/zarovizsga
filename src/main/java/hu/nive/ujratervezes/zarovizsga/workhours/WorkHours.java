package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WorkHours {
    String minWork(String fileName) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of(fileName))) {
            int minOurs = Integer.MAX_VALUE;
            String[] minValues = null;

            String line;
            while ((line = reader.readLine())  != null) {
                String[] values = line.split(",");
                int hours = Integer.parseInt(values[1]);
                if (hours < minOurs) {
                    minOurs = hours;
                    minValues = values;
                }
            }
            return minValues[0] + ": " + minValues[2];
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }
}
