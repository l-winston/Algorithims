public class Graphs {
    static int[][] rotateImage(int[][] a) {
        int[][] r = new int[a[0].length][a.length];

        for(int i = 0; i < a.length; i++)
            for(int j = 0; j < a[0].length; j++)
                r[i][j] = a[a[0].length-j-1][i];

        return r;
    }

    public static void main(String[] args){

        // testing rotateImage
        System.out.println("---------------------------");
        System.out.println("Testing rotateImage:");
        int[][] a = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        for(int[] i : rotateImage(a)){
            System.out.println(java.util.Arrays.toString(i));
        }
    }
}
