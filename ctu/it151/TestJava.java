import java.util.Scanner;

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
    }
}
