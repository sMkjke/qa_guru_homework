package smkjke.github.com;

public class Main {

    public static void main(String[] args) {

        int a = 4;
        double b = 2.6;
        int c = 8;

        System.out.println(a + "+" + b + " = " + (a + b));
        System.out.println(a + "-" + b + " = " + (a - b));
        System.out.println(a + "*" + b + " = " + (a * b));
        System.out.println(a + "/" + b + " = " + (a / b));
        System.out.println(a + "%" + b + " = " + (a % b));
        System.out.println(a + "-" + c + " = " + (a - c));
        System.out.println(a + "%" + b + " = " + (a % b));
        System.out.println(c + "/" + c + " = " + (c % c));
        System.out.println();

        for (int i = 0; i <= 5; i++) {
            String ternaryOutput = i >= 3 ? ("i = " + i + " i >= 3") : ("i = " + i + " i < 3");
            System.out.println(ternaryOutput);
        }
        System.out.println();

        for (int i = 0; i < 5; i++) {
            if (a > b) {
                ++b;
                System.out.println("a > b");
            } else if (b == 4.6) {
                System.out.println("b == 4.6");
                b--;
            } else {
                System.out.println("nothing");
            }
        }

        byte overflowByte = (byte) (Byte.MAX_VALUE + 1);
        System.out.println("Byte.MAX_VALUE + 1 = " + overflowByte);
        int overflowInt = (Integer.MIN_VALUE - 1);
        System.out.println("Integer.MIN_VALUE - 1 = " + overflowInt);
    }
}
