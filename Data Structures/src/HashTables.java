import java.util.HashMap;

public class HashTables {

    boolean areFollowingPatterns(String[] strings, String[] patterns) {
        HashMap<String, String> fwd = new HashMap<String, String>();
        for(int i = 0; i < strings.length; i++){
            if(fwd.keySet().contains(strings[i])){
                if(!fwd.get(strings[i]).equals(patterns[i]))
                    return false;
            }   else {
                fwd.put(strings[i], patterns[i]);
            }
        }
        System.out.print(fwd);
        HashMap<String, String> rev = new HashMap<String, String>();
        for(int i = 0; i < strings.length; i++){
            if(rev.keySet().contains(patterns[i])){
                if(!rev.get(patterns[i]).equals(strings[i]))
                    return false;
            }else{
                rev.put(patterns[i], strings[i]);
            }
        }
        System.out.print(rev);
        return true;
    }
}
