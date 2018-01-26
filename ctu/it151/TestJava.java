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

    }
}
