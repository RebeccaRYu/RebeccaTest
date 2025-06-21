import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class House {
    int number;
    int position;

    public House(int number, int position) {
        this.number = number;
        this.position = position;
    }
}

public class FindLargestPlot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int numHouses = scanner.nextInt();
            // The second value 'val' is not used, so we consume it.
            scanner.nextInt();

            if (numHouses < 2) {
                // Not enough houses to find a plot.
                return;
            }

            List<House> houses = new ArrayList<>();
            for (int i = 0; i < numHouses; i++) {
                int houseNumber = scanner.nextInt();
                int position = scanner.nextInt();
                houses.add(new House(houseNumber, position));
            }

            // Sort houses by position
            Collections.sort(houses, Comparator.comparingInt(h -> h.position));

            int maxDistance = -1;
            int houseNum1 = -1;
            int houseNum2 = -1;

            for (int i = 0; i < houses.size() - 1; i++) {
                House currentHouse = houses.get(i);
                House nextHouse = houses.get(i + 1);

                int distance = nextHouse.position - currentHouse.position;

                if (distance > maxDistance) {
                    maxDistance = distance;
                    houseNum1 = currentHouse.number;
                    houseNum2 = nextHouse.number;
                }
            }

            if (houseNum1 != -1) {
                if (houseNum1 < houseNum2) {
                    System.out.println(houseNum1 + " " + houseNum2);
                } else {
                    System.out.println(houseNum2 + " " + houseNum1);
                }
            }
        } catch (Exception e) {
            // Silently handle exceptions from malformed input.
        } finally {
            scanner.close();
        }
    }
}