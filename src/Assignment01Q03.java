public class Assignment01Q03 {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        System.out.println("The first " + x + " Fibonacci numbers are:");

        int first_number = 0;
        int second_number = 1;
        int result = 0;
        
        int numOdd = 0;
        for (int i = 0; i < x; i++) {
            if (i == 0) {
                result = 1;
            }else{
                result = first_number + second_number;
                first_number = second_number;
                second_number = result;
            }
            
            System.out.print(result);

            if (result % 2 != 0) { //count the number of odd numbers
                numOdd++;
            }

            if (i < x - 1) 
                System.out.print(" "); // Make sure we don't print a trailing space
        }
        System.out.println();
        
        ////////////////////////////////////////////////////////////////
        
        System.out.println("The number of odd numbers is: " + numOdd);
    }
}
