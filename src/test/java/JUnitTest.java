import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JUnitTest {
    @Test
    public void checkTest() {
        List<String> known = new ArrayList<>();
        List<String> unknown = new ArrayList<>();
        List<Item> knownElement = new ArrayList<>();
        known.add("1024 byte = 1 kilobyte");
        known.add("16.8 ring = 2 pyramid");
        known.add("2 bar = 12 ring");
        known.add("4 hare = 1 cat");
        known.add("5 cat = 0.5 giraffe");
        known.add("1 byte = 8 bit");
        known.add("15 ring = 2.5 bar");
        unknown.add("1 pyramid = ? bar");
        unknown.add("1 giraffe = ? hare");
        unknown.add("0.5 byte = ? cat");
        unknown.add("2 kilobyte = ? bit");
        for (String string : known) {
            MyClass.addToKnownList(knownElement, string);
        }
        String example1 = "1 pyramid = ? bar";
        String example2 = "1 giraffe = ? hare";
        String example3 = "0.5 byte = ? cat";
        String example4 = "2 kilobyte = ? bit";
        ItemUnknow itemUnknow1 = MyClass.makeUnknownItem(example1);
        ItemUnknow itemUnknow2 = MyClass.makeUnknownItem(example2);
        ItemUnknow itemUnknow3 = MyClass.makeUnknownItem(example3);
        ItemUnknow itemUnknow4 = MyClass.makeUnknownItem(example4);
        Assert.assertEquals(MyClass.search(itemUnknow1, knownElement, 1, itemUnknow1), "1 pyramid = 1.4 bar");
        Assert.assertEquals(MyClass.search(itemUnknow2, knownElement, 1, itemUnknow2), "1 giraffe = 40 hare");
        Assert.assertEquals(MyClass.search(itemUnknow3, knownElement, 1, itemUnknow3), "Conversion not possible");
        Assert.assertEquals(MyClass.search(itemUnknow4, knownElement, 1, itemUnknow4), "2 kilobyte = 16384 bit");
    }
}
