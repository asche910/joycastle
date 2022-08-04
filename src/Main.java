import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
//         System.out.println(Math.round(1.5));

        System.out.println("start.");

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