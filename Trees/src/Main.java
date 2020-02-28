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
            return s == 0;
        if(t.left == null && t.right == null)
            return s == t.value;
        if(t.left != null)
            if(hasPathWithGivenSum(t.left, s-t.value))
                return true;
        if(t.right != null)
            if(hasPathWithGivenSum(t.right, s-t.value))
                return true;
        return false;
    }


    public static void main(String[] args){


    }
}
