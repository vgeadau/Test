package integers;

public class TestIntegers {
    private static final Integer STATUS_1 = 1;
    private static final Integer STATUS_2 = 2;
    private static final Integer STATUS_3 = 3;
    public static void main(String[] args) {
        Integer a = Integer.valueOf(1);
        int b = 1;
        if (a == b) {
            System.out.println("they are equal!");
        }

        method1(null, 2);
        method2(1, 2);

        updateStatus(null, 2);
        updateStatus(1, 2);

    }

    public static void method1(Integer initStatus, Integer newStatus) {
        Integer status = null;
        if (status == initStatus) {
            System.out.println("set new " + newStatus);
        }
    }

    public static void method2(Integer initStatus, Integer newStatus) {
        Integer status = 1;
        if (status == initStatus.intValue()) {
            System.out.println("set new " + newStatus);
        }
    }

    public static void updateStatus(Integer initStatus, Integer newStatus) {
        Integer status = 1; // either null or 1
        if ((status == null && initStatus == null && newStatus != null) ||
                (status != null && initStatus != null && status.equals(initStatus))) {
            System.out.println("set new " + newStatus);
        }
    }

}
