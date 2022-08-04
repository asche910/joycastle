# joycastle

## 1、
[Here](./src/Main.java)

```java
import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        String str = "ABC";
        List<String> res = new ArrayList<>();
        dfs(res, str.toCharArray(), 0);

        res.forEach(i -> {
            System.out.println(i);
        });
    }

    public static void dfs(List<String> res, char[] chs, int idx){
        if(idx == chs.length){
            res.add(new String(chs));
            return;
        }
        for(int i = idx; i < chs.length; i++){
            swap(chs, i, idx);
            dfs(res, chs, idx + 1);
            swap(chs, i, idx);
        }
    }

    public static void swap(char[] chs, int i, int j){
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }
}
```

## 2、

## 3、

[here](./src/Main3.java)
```java

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



```

## 4、

[Here](./src/Main4.java)

```java
public class Main4 {
    public static void main(String[] args) throws Exception {
        System.out.println("puzzle start");
    }


    /**
     * 对外公开检验的方法
     *
     * @param arr
     * @return
     */
    public static boolean checkComplete(PuzzleEntity[][] arr){
        if (arr == null || arr.length == 0) return false;
        int m = arr.length;
        int n = arr[0].length;

        // 矩形上下边界必须平整
        for(int j = 0; j < n; j++){
            if (arr[0][j].getUp() != 0){
                return false;
            }
            if (arr[m - 1][j].getDown() != 0) {
                return false;
            }
        }

        // 矩形左右边界必须平整
        for (int i = 0; i < m; i++){
            if(arr[i][0].getLeft() != 0){
                return false;
            }
            if(arr[i][n - 1].getRight() != 0){
                return false;
            }
        }

        // 内部相邻检查：比如碎片A，A右边相邻碎片B，A下边相邻碎片C，
        // 只用比较A的右边与B的左边、A的下边与C的上边是否贴合，然后循环下去，即可检查整个矩形的内部了
        for(int i = 0; i < m - 1; i++){
            for(int j = 0; j < n - 1; j++){
                if(arr[i][j].getRight() + arr[i][j + 1].getLeft() != 0){
                    return false;
                }
                if (arr[i][j].getDown() + arr[i + 1][j].getUp() != 0){
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * 拼图碎片，拥有四个面up、right、down、left，
     * 其中每个面的值用 1，0，-1表示，刚好可以表示凸起、平、凹陷三种状态。
     * 凸起  -> 1
     * 平    -> 0
     * 凹陷  -> -1
     *
     * 并且，判断相邻拼图是否贴合，只需让两个碎片的相邻面的值相加，等于则贴合。例：
     * 凸起为1，凹陷为-1，相加为0，刚好贴合；
     * 平为0，两个平相加还是0，也刚好贴合。
     */
    public static class PuzzleEntity{
        private int up;
        private int right;
        private int down;
        private int left;

        public PuzzleEntity() {
            up = 0;
            right = 0;
            down = 0;
            left = 0;
        }

        public PuzzleEntity(int up, int right, int down, int left) {
            this.up = up;
            this.right = right;
            this.down = down;
            this.left = left;
        }

        public int getUp() {
            return up;
        }

        public void setUp(int up) {
            this.up = up;
        }

        public int getRight() {
            return right;
        }

        public void setRight(int right) {
            this.right = right;
        }

        public int getDown() {
            return down;
        }

        public void setDown(int down) {
            this.down = down;
        }

        public int getLeft() {
            return left;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        @Override
        public String toString() {
            return "PuzzleEntity{" +
                    "up=" + up +
                    ", right=" + right +
                    ", down=" + down +
                    ", left=" + left +
                    '}';
        }
    }
}
```