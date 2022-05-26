import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {

        if (a.size() != b.size()) {
            throw new IllegalArgumentException("a.size != b.size");
        }

        ArrayList<Integer> tempList = new ArrayList<>();
        int aIndex = 0;
        int bIndex = 0;
        int n = a.size();

        for (int i = 0; i < 2 * n; i++) {
            if (aIndex == n) {
                tempList.add(b.get(bIndex));
                bIndex++;
            } else if (bIndex == n) {
                tempList.add(a.get(aIndex));
                aIndex++;
            } else if (a.get(aIndex) <= b.get(bIndex)) {
                tempList.add(a.get(aIndex));
                aIndex++;
            } else {
                tempList.add(b.get(bIndex));
                bIndex++;
            }
        }

        a.clear();
        a.addAll(tempList);
    }

    public static void main(String[] args) throws IOException {

        Scanner sc1 = new Scanner(new File("input1.txt"));
        Scanner sc2 = new Scanner(new File("input2.txt"));

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

        while (sc1.hasNext()) {
            a.add(sc1.nextInt());
        }
        while (sc2.hasNext()) {
            b.add(sc2.nextInt());
        }
        System.out.println(a);
        System.out.println(b);

        merge(a, b);

        System.out.println(a);
        System.out.println(b);

        sc1.close();
        sc2.close();
    }
}