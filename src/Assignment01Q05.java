public class Assignment01Q05 {
    public static int findShortestPath(int[][] m, int i, int j) {
        int[] steps = new int[m.length];
        
        for (int k = 0; k <m.length; k++) {
            steps[k] = -1;
        }

        steps[i] = 0;

        for (int step = 0; step < m.length; step++) { //start i and count the minimum steps we did to reach current_index
            for (int current_index = 0; current_index < m.length; current_index++) {
                if (steps[current_index] == step) { //if we reached current_index in 'step' steps, check if there's a neighbor of current_index that we haven't reached yet, and if so, set the number of steps to reach it to 'step + 1'
                    for (int neighbor = 0; neighbor < m.length; neighbor++) {
                        if (m[current_index][neighbor] == 1 && steps[neighbor] == -1) {
                            steps[neighbor] = step + 1;
                        }
                    }

                }
            }
        }

        return steps[j];
    }

    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}