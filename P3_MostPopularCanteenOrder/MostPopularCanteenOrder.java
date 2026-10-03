package P3_MostPopularCanteenOrder;

import java.util.*;

public class MostPopularCanteenOrder {

    static String[] mostPopular(List<String> orders) {

        HashMap<String, Integer> countMap = new HashMap<>();

        // Count every item
        for (String item : orders) {
            countMap.put(item, countMap.getOrDefault(item, 0) + 1);
        }

        String bestItem = orders.get(0);
        int bestCount = countMap.get(bestItem);

        // Scan original order to handle ties
        for (String item : orders) {

            int count = countMap.get(item);

            if (count > bestCount) {
                bestCount = count;
                bestItem = item;
            }
        }

        return new String[]{bestItem, String.valueOf(bestCount)};
    }

    public static void main(String[] args) {

        List<String> orders = Arrays.asList(
                "dosa",
                "idli",
                "vada",
                "dosa",
                "idli",
                "dosa",
                "tea"
        );

        String[] result = mostPopular(orders);

        System.out.println(
                "(\"" + result[0] + "\", " + result[1] + ")"
        );

        List<String> orders2 = Arrays.asList(
                "tea",
                "coffee",
                "coffee",
                "tea"
        );

        String[] result2 = mostPopular(orders2);

        System.out.println(
                "(\"" + result2[0] + "\", " + result2[1] + ")"
        );
    }
}
