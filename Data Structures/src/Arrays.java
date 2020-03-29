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

    public static void main(String[] args){
        Arrays a = new Arrays();


    }
}
