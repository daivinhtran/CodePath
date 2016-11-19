/*
 * Complete the function below.
 */
public class Problem2 {
    static boolean[][] visited;
    static String isPossible(int a, int b, int c, int d) {
        visited = new boolean [2000][2000]; 
        return (check(a,b,c,d))? "Yes" : "No";
    }

    static boolean check(int a, int b, int c, int d) {
        visited[a][b] = true;
        if (a == c && b == d)
            return true;
        if (a > c || b > d)
            return false;
        if (a == c)
            return (b-d) % a == 0;
        if (b == d)
            return (c-a) % b == 0;
        return (   (!visited[a+b][b] && check(a+b,b,c,d) ) ||(  !visited[a][a+b] &&    check(a,a+b,c,d)   )       );
    }
}
    


