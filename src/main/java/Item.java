import lombok.Data;

@Data
public class Item {
    public String leftCount; //3
    public String leftMeasure; //kilogramm
    public String rightCount; // 3000
    public String rightMeasure; // gramm

    public Item(String leftCount, String leftMeasure, String rightCount, String rightMeasure) {
        this.leftCount = leftCount;
        this.leftMeasure = leftMeasure;
        this.rightCount = rightCount;
        this.rightMeasure = rightMeasure;
    }

    public Item(String left, String right) {
        String[] lefts = left.split(" ");
        String[] rights = right.split(" ");
        this.leftCount = lefts[0];
        this.leftMeasure = lefts[1];
        this.rightCount = rights[0];
        this.rightMeasure = rights[1];
    }

    public static String write(Item item, String finalItem) {
        System.out.println(item.leftCount + " " + item.leftMeasure + " = " + item.rightCount + " " + finalItem);
        float rigthValues = Float.parseFloat(item.rightCount);
        if (rigthValues % 1 == 0) {
            item.rightCount = String.valueOf((int) rigthValues);
        }
        return item.leftCount + " " + item.leftMeasure + " = " + item.rightCount + " " + finalItem;
    }

    public static ItemUnknow createQuanityUnknow(Item item) {
        return new ItemUnknow(item.leftCount, item.leftMeasure, "?", item.rightMeasure);
    }
}
