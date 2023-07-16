package lab8.no_4;

import java.util.List;
import java.util.function.Predicate;

public class WordCount {
    public int countWords(List<String> words, char c, char d, int len){
        Predicate<String> p = s -> s.contains(String.valueOf('c')) && !s.contains(String.valueOf('d')) && s.length() == len;
        int count = (int) words.stream()
                .filter(p)
                .count();

        return count;
    }
}
