public class Assignment01Q02 {
    public static void main(String[] args) {
        double actualPi = Math.PI;
        double approxPi = 0;

        int NUMBER_OF_SUMMANDS = Integer.parseInt(args[0]);
        boolean odd_iteration = true; //if the number of the iteration is odd, add the summand to the approximation of pi, otherwise subtract it
        for (int denominator = 1; denominator < NUMBER_OF_SUMMANDS*2; denominator+=2) {   

            if (odd_iteration) {  
                approxPi += (double)1/denominator;
                odd_iteration = false;
            } else {
                approxPi -= (double)1/denominator;
                odd_iteration = true;
            } 
        }
        approxPi *= 4;

        System.out.println(approxPi + " " + actualPi);
    }
}
