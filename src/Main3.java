import java.util.Random;

public class Main3 {
    public static void main(String[] args) {

    }

    public static int rand5() {
        int res = 0;
        while (true) {
            // 得到 1 - 169之间的平均分布
            res = rand13() + (rand13() - 1) * 13;

            // 为5的n倍
            if ((res <= 165)) {
                break;
            }
        }
        return res % 5 + 1;
    }

    private static int rand13() {
        // 注释为rand5推导rand13
//        int res = 0;
//        while (true){
//            // 得到 1 - 25 的平均分布
//            res = rand5() + (rand5() - 1) * 5;
//            if (res <= 13){
//                break;
//            }
//        }
//        return res % 13 + 1;
        return new Random().nextInt(13) + 1;
    }
}

