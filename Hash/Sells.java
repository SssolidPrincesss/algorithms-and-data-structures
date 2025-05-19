import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, Integer>> customerData = new HashMap<>();

        String line;
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] parts = line.split(" ");
            if (parts.length != 3) {
                continue;
            }
            String customer = parts[0];
            String item = parts[1];
            int quantity = Integer.parseInt(parts[2]);

            customerData.putIfAbsent(customer, new HashMap<>());
            Map<String, Integer> items = customerData.get(customer);
            items.put(item, items.getOrDefault(item, 0) + quantity);
        }

        List<String> customers = new ArrayList<>(customerData.keySet());
        Collections.sort(customers);

        for (String customer : customers) {
            System.out.println(customer + ":");
            Map<String, Integer> items = customerData.get(customer);
            List<String> itemNames = new ArrayList<>(items.keySet());
            Collections.sort(itemNames);

            for (String item : itemNames) {
                System.out.println(item + " " + items.get(item));
            }
        }
    }
}