package test;

/**
 * @desc:
 * @author: admin
 * @since: 2022/1/27 18:10
 * @history:
 */
public class TestRuntime {

    public static void main(String[] args) {
        long  avalibale =   Runtime.getRuntime().availableProcessors();
        long l = Runtime.getRuntime().maxMemory();
        long l1 = Runtime.getRuntime().totalMemory();

        System.out.println("max"+ (l / 1024/ 1024));
        System.out.println("max"+ (l1 / 1024/ 1024));

    }
}
