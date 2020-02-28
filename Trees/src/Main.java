public class Main {
    class Tree<T> {
        Tree(T x) {
            value = x;
        }
        T value;
        Tree<T> left;
        Tree<T> right;
    }

    boolean hasPathWithGivenSum(Tree<Integer> t, int s) {
        if(t == null)
            return false;
        if(t.value == s)
            return true;
        return hasPathWithGivenSum(t.left, s-t.value) || hasPathWithGivenSum(t.right, s-t.value);
    }


    public static void main(String[] args){


    }
}
