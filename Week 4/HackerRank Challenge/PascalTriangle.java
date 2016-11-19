   import java.util.*;
   public class PascalTriangle {
        static ArrayList<ArrayList<Integer>> pascal = new ArrayList<>();
        static void pascalTriangle(int k) {
            if (pascal.size()==0)
                pascal.add(new ArrayList<Integer>());
            computePascal(k);
            for (int i = 1; i <=k; i++) {
                ArrayList<Integer> row = pascal.get(i);
                for (int elem : row)
                    System.out.print(elem + " ");
                System.out.println();
            }
        }
        static void computePascal(int k) {
            if (pascal.size()>k || k<= 0)
                return;
            ArrayList<Integer> ans = new ArrayList<>();
            if (k != 1) 
                ans.add(1);             
            computePascal(k-1);
            ArrayList<Integer> prev = pascal.get(k-1);
            for (int i = 1; i < prev.size(); i++) 
                ans.add(prev.get(i) + prev.get(i-1));
            ans.add(1);
            pascal.add(ans);

        }
        public static void main(String[] args) {
            pascalTriangle(5);
            pascalTriangle(10);
            pascalTriangle(2);
        }
    }