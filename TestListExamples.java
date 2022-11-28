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
        list.add("abc");
        list.add("bbc");
        list.add("aaa");
        List<String> result = new ArrayList<>();
        result.add("abc");
        result.add("aaa");
        assertEquals(result, ListExamples.filter(list,c));
    }

    @Test
    public void checkMerge() {
        List<String> student = List.of("a","b","y");
    
    List<String> TA = List.of("c","d","z");
    
    List<String> result = List.of("a","b", "c","d","y", "z");

    assertEquals(result,ListExamples.merge(student,TA));
    }
}
