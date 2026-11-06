import java.util.Arrays;

public class Assignment01Q04 {

    public static int[] shiftArrayCyclic(int[] array, int move, char direction) {
        move = convert_to_positive_right(move, direction, array.length); //convert the moves to a positive number of moves to the right
        if (move == 0) {
            return array;
        }

        int tmp_array[] = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            tmp_array[(i + move) % array.length] = array[i]; //insert the elenments of the originial array shifted to the right by 'move'
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = tmp_array[i]; //copy the elements of the temporary array back to the original array
        }

        return array;
    }

    private static int convert_to_positive_right(int move, char direction, int array_length) {
        if (move == 0 || array_length == 0) {
            return 0;
        }
        if (direction == 'L') {
            move = -move;
        } else if (direction != 'R') {
            return 0;
        }
        move = move % array_length;
        if (move < 0) {
            move += array_length;
        }
        return move;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -1, 'R'))); // [2, 3, 4, 5, 1]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'R'))); // [5, 1, 2, 3, 4]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'r'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -2, 'g'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 3, 'L'))); // [4, 5, 1, 2, 3]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -3, 'L'))); // [3, 4, 5, 1, 2]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{0, 8, 9, 5, 6}, 6, 'L'))); // [8, 9, 5, 6, 0]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{}, 3, 'R'))); // []
    }
}