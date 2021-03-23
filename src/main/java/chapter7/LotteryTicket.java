package chapter7;

import java.util.Arrays;
import java.util.Random;

public class LotteryTicket {

    public static final int LENGTH = 6;
    private static final int MAX_TICKET_NUMBER = 69;
    public static void main(String[] args) {

        int [] ticket = generateNumber();
        Arrays.sort(ticket);
        printTicket(ticket);
    }

    public static int[] generateNumber(){
        int[] ticket = new int[LENGTH];
        Random random = new Random();
        for(int i=0; i<LENGTH;i++){
          int randomNumber;

          // Generate random number then search to make sure it doesn't already exist
            // in the array. if it does, regenerate and search again.
              do{
                  randomNumber = random.nextInt(MAX_TICKET_NUMBER) + 1;
              }while (search(ticket, randomNumber));


            ticket[i] = randomNumber;
        }
            return ticket;
    }

    /**********************************************************8
     * Does a sequential search on the array to find a value
     * @param array Array to searech through
     * @param numberToSearchFOr Value to search for
     * @return true if found, false if not
     */
    public static boolean search(int[] array, int numberToSearchFOr){
    // this is called and enhances loop

        for(int value : array){
            if (value == numberToSearchFOr) {
                return true;
            }
        }
        /***********************
         * If we've reached this point, then the entire array was searched
         * and the value was not found
         */
        return false;
    }
public static boolean binarySearch(int[] array, int numberToSearchFOr){
        //array must be sorted first
    int index = Arrays.binarySearch(array, numberToSearchFOr);
    if(index>= 0){
        return true;
    }else return false;
}

    public  static void printTicket(int ticket[]){
        for (int i=0; i<LENGTH; i++){
            System.out.print(ticket[i] + " | ");
        }
    }
}
