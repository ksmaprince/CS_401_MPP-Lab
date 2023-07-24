package lab10.prob5;

public class CalculatePrime {
    public static void main(String[] args) {


        for (int i = 0; i<=5; i++){
            int start = (i * 200000) + 1;
            int end = (i + 1) * 200000;
            Runnable r = () -> {
                for (int k= start; k<=end; k++){
                    if(isPrime(k)) System.out.print(k + " ");
                }
            };

            new Thread(r).start();
            new Thread(() -> {
                for (int k= start; k<=end; k++){
                    if(isPrime(k)) System.out.print(k + " ");
                }
            }).start();
        }


        /*Runnable r1 = () -> {
            for (int i = 1; i<=200_000; i++){
                if(isPrime(i)) System.out.println("Prime at Thread-1: "+i);
            }
        };
        new Thread(r1).start();

        Runnable r2 = () -> {
            for (int i = 200_001; i<=400_000; i++){
                if(isPrime(i)) System.out.println("Prime at Thread-2: "+i);
            }
        };
        new Thread(r2).start();

        Runnable r3 = () -> {
            for (int i = 400_001; i<=600_000; i++){
                if(isPrime(i)) System.out.println("Prime at Thread-3: "+i);
            }
        };
        new Thread(r3).start();

        Runnable r4 = () -> {
            for (int i = 600_001; i<=800_000; i++){
                if(isPrime(i)) System.out.println("Prime at Thread-4: "+i);
            }
        };
        new Thread(r4).start();

        Runnable r5 = () -> {
            for (int i = 800_000; i<=1_000_000; i++){
                if(isPrime(i)) System.out.println("Prime at Thread-4: "+i);
            }
        };
        new Thread(r5).start();*/
    }

    static boolean isPrime(int n){
        for (int k = 2; k*k <=n; ++k){
            if (n%k == 0) return false;
        }
        return true;
    }
}
