
/**
 * Rod cutting problem described in Chapter 15 of textbook
 * Author: Maor Azoulay
 */
public class RodCutting {

  // Do not change the parameters!
  public int rodCuttingRecur(int rodLength, int[] lengthPrices) {
    //Base case: if length is zero then no cutting needed
    if(rodLength <= 0)
      return 0;
    int maximum = Integer.MIN_VALUE;

    //Here we cut the rod in different pieces and compare them to 
    //find the max value.

    for (int i = 0; i < rodLength; i++) {
      maximum = Math.max(maximum, lengthPrices[i] + 
              rodCuttingRecur(rodLength-i-1, lengthPrices ));
    }
    return maximum;
  }

  // Do not change the parameters!
  public int rodCuttingBottomUp(int rodLength, int[] lengthPrices) {
    int variations[] = new int[rodLength+1];
    variations[0] = 0;

    //this populates the table starting from the bottom
    //we need the final entry in the table

    for (int i = 1; i <= rodLength; i++) {
			int maximum = Integer.MIN_VALUE;
			
      for(int j = 0; j < i; j++){
         maximum = Math.max(maximum, lengthPrices[j] + variations[i-j-1]);
      }
      variations[i] = maximum;
    }
    return variations[rodLength];
  }


  public static void main(String args[]){
      RodCutting rc = new RodCutting();

      // In your turned in copy, do not touch the below lines of code.
      // Make sure below is your only output.
      int length1 = 7;
      int[] prices1 = {1, 4, 7, 3, 19, 5, 12};
      int length2 = 14;
      int[] prices2 = {2, 5, 1, 6, 11, 15, 17, 12, 13, 9, 10, 22, 18, 26};
      int maxSell1Recur = rc.rodCuttingRecur(length1, prices1);
      int maxSell1Bottom = rc.rodCuttingBottomUp(length1, prices1);
      int maxSell2Recur = rc.rodCuttingRecur(length2, prices2);
      int maxSell2Bottom = rc.rodCuttingBottomUp(length2, prices2);
      System.out.println(maxSell1Recur + " " + maxSell1Bottom);
      System.out.println(maxSell2Recur + " " + maxSell2Bottom);
  }
}
