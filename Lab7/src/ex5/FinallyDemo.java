package ex5;

public class FinallyDemo {

    // 1. return inside try, print inside finally
    static int test1() {
        try {
            System.out.println("test1: in try");
            return 1;
        } finally {
            System.out.println("test1: in finally");
        }
    }

    // 2. finally changes the variable AFTER the return value was already saved
    static int test2() {
        int x = 40;
        try {
            return x;             // the value 40 is saved here
        } finally {
            x = 100;
            System.out.println("test2: finally set x to " + x);
        }
    }

    // 3. exception thrown, caught, caught block returns
    static int test3() {
        try {
            throw new RuntimeException("boom");
        } catch (RuntimeException e) {
            System.out.println("test3: caught " + e.getMessage());
            return 3;
        } finally {
            System.out.println("test3: in finally");
        }
    }

    // 4. BAD PRACTICE: a return inside finally replaces the earlier return
    @SuppressWarnings("finally")
    static int test4() {
        try {
            return 1;
        } finally {
            return 2;       // overrides the
        }
    }

    public static void main(String[] args) {
        System.out.println("Result 1 = " + test1());
        System.out.println();
        System.out.println("Result 2 = " + test2());
        System.out.println();
        System.out.println("Result 3 = " + test3());
        System.out.println();
        System.out.println("Result 4 = " + test4());
    }
}
