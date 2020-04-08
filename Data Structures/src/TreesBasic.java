public class TreesBasic {
    static class Tree<T> {
        Tree(T x) {
            value = x;
        }
        Tree(T x, Tree<T> left, Tree<T> right){ value = x; this.left = left; this.right = right;}
        T value;
        Tree<T> left;
        Tree<T> right;
    }

    static boolean hasPathWithGivenSum(Tree<Integer> t, int s) {
        if(t == null) return false;

        if(t.left == null && t.right == null) {
            return s == t.value;
        }

        return hasPathWithGivenSum(t.left, s-t.value) || hasPathWithGivenSum(t.right, s-t.value);
    }

    static boolean isTreeSymmetric(Tree<Integer> t) {
        return treeEquals(t.left, reverse(t.right));
    }

    static Tree<Integer> reverse(Tree<Integer> t){
        if(t == null)
            return null;
        Tree<Integer> temp = t.left;
        t.left = t.right;
        t.right = temp;

        reverse(t.left);
        reverse(t.right);

        return t;
    }

    static boolean treeEquals(Tree<Integer> a, Tree<Integer> b){
        if(a == null && b == null)
            return true;
        return a.value == b.value && treeEquals(a.left, b.left) && treeEquals(a.right, b.right);
    }


    public static void main(String[] args){
        /* testing hasPathWithGivenSum
                4
               / \
              1   3
             /   / \
            -2  1   2
              \    / \
               3  -2 -3
        */
        System.out.println("---------------------------");
        System.out.println("Testing rotateImage:");
        Tree<Integer> negTwo = new Tree<Integer>(-2, null, new Tree<Integer>(3));
        Tree<Integer> two = new Tree<Integer>(2, new Tree<Integer>(-2), new Tree<Integer>(-3));
        Tree<Integer> one = new Tree<Integer>(1, negTwo, null);
        Tree<Integer> three = new Tree<Integer>(3, new Tree<Integer>(1), two);
        Tree<Integer> four = new Tree<Integer>(4, one, three);

        Tree<Integer> t = four;
        int s = 7;

        System.out.println(hasPathWithGivenSum(t, s));




    }
}
