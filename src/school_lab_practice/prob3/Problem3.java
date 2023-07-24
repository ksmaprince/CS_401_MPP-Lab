package school_lab_practice.prob3;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class Problem3 {

    //Imperative
    /*public static <T> int countIf(Collection<T> collection, Predicate<T> criteria){
        int count = 0;
        for (T t: collection){
            if (criteria.test(t)) count++;
        }
        return count;
    }*/

    //Declarative
    public static <T> int countIf(Collection<T> collection, Predicate<T> criteria){
        return (int) collection.stream().filter(criteria).count();
    }


    private static boolean isPrime(int n){
        for (int i = 2; i*i<=n; i++){
            if (n%i == 0) return false;
        }
        return true;
    }

    private static boolean isPalindrome(String s){
        StringBuilder str = new  StringBuilder(s);
        return str.reverse().toString().equals(s);
    }

    public static void main(String[] args) {
        List<Integer> list1 = List.of(1,3,5,7,9,11,13,15,17,19,21);
        Predicate<Integer> f = n -> isPrime(n);
        System.out.println("No. of Prime: "+countIf(list1, n -> isPrime(n)));

        List<String> list2 = List.of("aab", "aba", "aabb","aabaa", "aaba","aabbbaa");
        System.out.println("No. of Palindrome: "+countIf(list2, s -> isPalindrome(s)));
    }
}
