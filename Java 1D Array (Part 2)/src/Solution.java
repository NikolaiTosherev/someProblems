import java.util.*;

public class Solution {

    public static boolean canWin(int leap, int[] game) {
        if (leap >= game.length)
            return true;
        List<Integer> usedPoints = new ArrayList<>();
        usedPoints.add(0);
        int oldSizeOfList;
        int count;
        do {
            oldSizeOfList = usedPoints.size();
            count = 0;
            while (count < oldSizeOfList) {
                if (usedPoints.get(count) + leap >= game.length || usedPoints.get(count) + 1 >= game.length)
                    return true;
                if (usedPoints.get(count) + leap <= game.length && game[usedPoints.get(count) + leap] == 0)
                    if (!usedPoints.contains(usedPoints.get(count) + leap))
                        usedPoints.add(usedPoints.get(count) + leap);

                if (usedPoints.get(count) + 1 <= game.length && game[usedPoints.get(count) + 1] == 0)
                    if (!usedPoints.contains(usedPoints.get(count) + 1))
                        usedPoints.add(usedPoints.get(count) + 1);

                if (usedPoints.get(count) - 1 >= 0 && game[usedPoints.get(count) - 1] == 0)
                    if (!usedPoints.contains(usedPoints.get(count) - 1))
                        usedPoints.add(usedPoints.get(count) - 1);
                count++;
            }
        }while (oldSizeOfList != usedPoints.size()) ;
        return false;
    }



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}