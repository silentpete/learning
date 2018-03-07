import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

class TestJava {
    public static void main(String[] args) {
        boolean a = true, b = true, c = true, d = true;
        if (a == true || b == true || c == true || d == true) {
            System.out.println("true");
        }
        if (a == true) {
            if (b == true) {
                if (c == true) {
                    if (d == true) {
                        System.out.println("true");
                    }
                }
            }
        }

        int count = 1;
        for (int k = 1; k < 10; k++){
            System.out.println("The counter value is: " + k);
            count += 2;
        }
        System.out.println(count);

        Scanner input = new Scanner("System.in");
        String productName= input.next();
        System.out.println(productName);
        input.close();

        System.out.println(Math.min((Math.PI * Math.sqrt(25)), Math.max(6.721, 1)));
        System.out.println(Math.round(Math.PI*Math.sqrt(25)));

        System.out.println(Math.min(115 % 10, 3*8-4));
        System.out.println(Math.min(11 / 4, 5 * 4));
        System.out.println(Math.min(8 + 10 * 2, 8 / 2 * 4));
        System.out.println(Math.min(11 / 4, 5 * 3));

        Random rand = new Random();
        System.out.println(rand.nextInt(5));

    }
}
