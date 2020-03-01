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
        if(t == null) return false;

        if(t.left == null && t.right == null) {
            return s == t.value;
        }

        return hasPathWithGivenSum(t.left, s-t.value) || hasPathWithGivenSum(t.right, s-t.value);
    }

    boolean isTreeSymmetric(Tree<Integer> t) {
        return equals(t.left, reverse(t.right));
    }


    public static void main(String[] args){


    }
}
