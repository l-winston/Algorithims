import java.util.HashSet;

public class Arrays {

    int firstDuplicate(int[] a) {
        HashSet<Integer> seen = new HashSet<Integer>();
        for(int i = 0; i < a.length; i++){
            if(seen.contains(a[i]))
                return a[i];
            seen.add(a[i]);
        }
        return -1;
    }

    char firstNotRepeatingCharacter(String s) {
        for(int i = 0; i < s.length(); i++)
            if(s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i)))
                return s.charAt(i);
        return '_';
    }

    int[][] rotateImage(int[][] a) {
        int[][] r = new int[a[0].length][a.length];

        for(int i = 0; i < a.length; i++)
            for(int j = 0; j < a[0].length; j++)
                r[i][j] = a[a[0].length-j-1][i];

        return r;
    }

    public static void main(String[] args){
        Arrays a = new Arrays();


    }
}
