package lab7.prob3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Consumer;


public class ForEachExample {
    @SuppressWarnings("unused")
    static List<String> upperCaseList = new ArrayList<>();

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Hello there", "Goodbye", "Back soon",
                "Away", "On Vacation", "Everywhere you want to be");

		//Lambda
		/*list.forEach(s ->
				upperCaseList.add(s.toUpperCase()));*/


        //print each element of the list in upper case format
		MyConsumer c = new MyConsumer();
		list.forEach(c);

		System.out.println(upperCaseList);
    }

    //implement a Consumer
    static class MyConsumer implements Consumer<String> {

        @Override
        public void accept(String s) {
            upperCaseList.add(s.toUpperCase());
        }
    }


}