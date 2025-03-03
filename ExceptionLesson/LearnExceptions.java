
public class LearnExceptions {
//     FileInputStream file = new FileInputStream("text.txt");
    public static void main(String[] args) {
        int index = 10;
        int[] numbers = {1,2,3,4,5,6,7};
        int[] numbers2 = {1,2,3,-1,5,6,7};

        try {
            if(index < 0 || index > numbers.length - 1) {
                throw new InvalidArrayIndexException(index + " is not a valid index");
            } 
        } catch (InvalidArrayIndexException e) {
            System.out.println(e);
        }
        try {
            int result = dividePositiveNumbers(10, -2);
            System.out.println(result);
        } catch (NegativeNumberException e) {
            System.out.println(e);
        }

        try { 
            int result = sumPositiveArray(numbers);
            int result2 = sumPositiveArray(numbers2);
            System.out.println("sumPositive Result 1: " + result);
            System.out.println("sumPositive Result 2: " + result2);
        } catch (NonNegativeElementException e) {
            System.out.println(e);
        }

        try { 
            int result3 = divideByElementAtIndex(numbers[5], 2);
            int result4 = divideByElementAtIndex(numbers[5], 0);
            System.out.println("divideByElement Result 3: " + result3);
            System.out.println("divideByElement Result 4: " + result4);
        } catch (DividebyZeroElementException e) {
            System.out.println(e);
        }
    }

    public static int dividePositiveNumbers(int a, int b) throws NegativeNumberException{
        if(a < 0 || b < 0) {
            throw new NegativeNumberException("negative numbers are not allowed.");
        }
        return b/a;
    }

    public static int sumPositiveArray(int[] numbers) {
        int total = 0;
        for(int num: numbers) {
            if(num < 0) throw new NonNegativeElementException("An element with a negative value has been found.");
            total += num;
        }
        return total;
    }

    public static int divideByElementAtIndex(int number,  int divisor) throws DividebyZeroElementException {
        if(divisor < 0) throw new DividebyZeroElementException("The divisor provided is 0." );
        return number/divisor;
    }
}