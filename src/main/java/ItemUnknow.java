public class ItemUnknow extends Item {
    public ItemUnknow(String left, String right) {
        super(left, right);
    }

    public ItemUnknow(String leftValues, String leftQuanity, String rightValues, String rightQuanity) {
        super(leftValues, leftQuanity, rightValues, rightValues);
    }


    public static String write(ItemUnknow quanity, float element, String finalItem) {
       return Item.write(quanity.getQuanity(element), finalItem);
    }

    public Item getQuanity(float element) {
        return new Item(this.leftCount, this.leftMeasure, String.valueOf(element), this.rightMeasure);
    }
    public Item createQuanity() {
        return new Item(this.leftCount, this.leftMeasure, this.rightCount, this.rightMeasure);
    }
}
