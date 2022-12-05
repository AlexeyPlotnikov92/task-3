import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MyClass {
    private static String answer = "";
    public static void main(String[] args) throws IOException {
        List<Item> knownElements = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (true) {
            line = reader.readLine();
            if (line == null) break;
            if (!line.contains("?") && line.contains("=")) {
                addToKnownList(knownElements, line);
            } else {
                ItemUnknow quanityUnknow = makeUnknownItem(line);
                search(quanityUnknow, knownElements, 1, quanityUnknow);
            }
        }
        reader.close();
    }

    public static void addToKnownList(List<Item> itemList, String line) {
        String[] vals = line.split("=");
        itemList.add(new Item(vals[0].trim(), vals[1].trim()));
    }

    public static ItemUnknow makeUnknownItem(String line) {
        String[] vals = line.split("=");
        ItemUnknow quanityUnknow = new ItemUnknow(vals[0].trim(), vals[1].trim());
        return quanityUnknow;
    }
    public static String search(Item currentUnknowElement, List<Item> knownElements, float prop, Item finalItem) {
        List<Item> testItems = new ArrayList<>(knownElements);
      //  System.out.println("begin method");
        float result = 0;
        float temp = 0;

        boolean isFound = false;
        for (Item currentKnowElement : knownElements) {
            if (currentUnknowElement.leftMeasure.equals(currentKnowElement.leftMeasure)) {
                isFound = true;
                result = Float.parseFloat(currentKnowElement.rightCount) / Float.parseFloat(currentKnowElement.leftCount);
                if (currentUnknowElement.rightMeasure.equals(finalItem.leftMeasure)) {
                    temp = (result * prop);
                    answer = ItemUnknow.write(ItemUnknow.createQuanityUnknow(finalItem), temp * Float.parseFloat(finalItem.leftCount), finalItem.rightMeasure);
                    break;
                } else {
                    testItems.remove(currentKnowElement);
                    search(currentKnowElement, testItems, result, finalItem);
                    break;
                }
            } else if (currentUnknowElement.leftMeasure.equals(currentKnowElement.rightMeasure)) {
                isFound = true;
                result = Float.parseFloat(currentKnowElement.leftCount) / Float.parseFloat(currentKnowElement.rightCount);
                if (currentKnowElement.leftMeasure.equals(finalItem.rightMeasure)) {
                    temp = (result * prop);
                    answer = ItemUnknow.write(ItemUnknow.createQuanityUnknow(finalItem), temp * Float.parseFloat(finalItem.leftCount), finalItem.rightMeasure);
                    break;
                } else {
                    testItems.remove(currentKnowElement);
                    search(currentKnowElement, testItems, result, finalItem);
                    break;
                }
            }
        }
        if (!isFound) {
            System.out.println("Conversion not possible");
            answer = "Conversion not possible";
        }
        return answer;
    }
}
