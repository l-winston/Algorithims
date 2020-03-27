import java.util.*;

public class HashTables {

    String[][] groupingDishes(String[][] dishes) {
        TreeMap<String, TreeSet<String>> map = new TreeMap<>();
        TreeSet<String> pass = new TreeSet<>();
        for(int i = 0; i < dishes.length; i++){
            String dish = dishes[i][0];
            for(int j = 1; j < dishes[i].length; j++){
                String ingred = dishes[i][j];
                if(!map.keySet().contains(ingred)){
                    TreeSet<String> set = new TreeSet<String>();
                    set.add(dish);
                    map.put(ingred, set);
                }else{
                    map.get(ingred).add(dish);
                    pass.add(ingred);
                }
            }
        }

        String[][] ret = new String[pass.size()][];

        int i = 0;
        for(String s : pass){
            ret[i] = new String[map.get(s).size() + 1];
            ret[i][0] = s;
            int j = 1;
            for(String ss : map.get(s)){
                ret[i][j++] = ss;
            }
            i++;
        }

        return ret;
    }

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

    boolean containsCloseNums(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.keySet().contains(new Integer(nums[i]))){
                map.put(nums[i], i);
            }else{
                if(Math.abs(map.get(nums[i]) - i) <= k)
                    return true;
                map.put(nums[i], i);
            }
        }
        return false;
    }

    int possibleSums(int[] coins, int[] quantity) {
        HashSet<Integer> possibleSums = new HashSet<>();
        possibleSums.add(0);
        for(int i = 0; i < coins.length; i++){
            HashSet<Integer> news = new HashSet<>();
            for(int x : possibleSums){
                for(int j = 1; j <= quantity[i]; j++){
                    news.add(x+j*coins[i]);
                }
            }
            possibleSums.addAll(news);
        }
        return possibleSums.size() - 1 ;
    }

    public static void main(String[] args){
        HashTables ht = new HashTables();



        // testing groupingDishes
        String[][] dishes = new String[][]{
                {"Salad","Tomato","Cucumber","Salad","Sauce"},
                {"Pizza","Tomato","Sausage","Sauce","Dough"},
                {"Quesadilla","Chicken","Cheese","Sauce"},
                {"Sandwich","Salad","Bread","Tomato","Cheese"}
        };
        for(String[] s : ht.groupingDishes(dishes))
            System.out.println(java.util.Arrays.toString(s));

        // testing possibleSums
        int[] coins = new int[]{10, 50, 100};
        int[] quantity = new int[]{1, 2, 1};
        System.out.println(ht.possibleSums(coins, quantity));

    }
}
