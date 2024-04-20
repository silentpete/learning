import java.awt.print.Book;
import java.util.Scanner;

class Exam {
    // 13
    // public Book (int num1, double num2, String name) {
    //     bookId = num1; bookPrice = num2;
    //     title = name;
    // }

    // 15
    public Exam() {
        String response = "from cook";
        System.out.println(response);
    }

    public static void main(String[] args) {

        // 2
        Scanner input = new Scanner("System.in");
        String productName = input.next();
        System.out.println(productName);
        input.close();

        // 3
        System.out.println("prompt, no");

        // 4
        int num4 = 4;
        System.out.printf("%d%n", num4);

        // 10 (causes a infinite loop, commenting out)
        // int i = 0;
        // while (i < 5);
        // {
        //     i++;
        // }
        // System.out.printf("%d", i);

        // 11 (infinite loop)
        // int num11 = 0;
        // for (int i = 1; i > num11; i++) {
        //     System.out.println("infinite loop");
        // }

        //13
        // int a = 0;
        // double b = 1.1;
        // String c = "string";
        // Book book = new Book(a,b,c);

        Exam exam = new Exam();
        System.out.println(exam);
    }
}
