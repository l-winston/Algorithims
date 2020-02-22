import java.util.HashSet;

public class Main {
    public static void main(String[] args){

    }

    int firstDuplicate(int[] a) {
        HashSet<Integer> seen = new HashSet<Integer>();
        for(int i = 0; i < a.length; i++){
            if(seen.contains(a[i]))
                return a[i];
            seen.add(a[i]);
        }
        return -1;
    }
}
