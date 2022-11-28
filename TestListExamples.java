import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;

//22222222222222222222222222
class CheckString implements StringChecker {
    @Override
    public boolean checkString(String s) {
        if(s.charAt(0) == 'a') {
            return true;
        }
        return false;
    }
}

public class TestListExamples {
  @Test
    public void checkFilter() {
        CheckString c = new CheckString();
        List<String> list = new ArrayList<>();
        list.add("apple"); list.add("banana"); list.add("apricot");
        List<String> list2 = new ArrayList<>();
        list2.add("apple"); list2.add("apricot");
        assertEquals(ListExamples.filter(list,c), list2);
    }

    @Test
    public void checkMerge() {
        List<String> list1 = new ArrayList<>();
        list1.add("apple"); list1.add("banana"); list1.add("duplex");
        List<String> list2 = new ArrayList<>();
        list2.add("cucumber"); list2.add("ergonomics"); list2.add("france");
        List<String> list3 = new ArrayList<>();
        list3.add("apple"); list3.add("banana"); list3.add("cucumber"); list3.add("duplex");
        list3.add("ergonomics"); list3.add("france");
        assertEquals(ListExamples.merge(list1, list2), list3);
    }
}
