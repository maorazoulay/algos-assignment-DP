 /**
   * Glass Falling
   * Author: Maor Azoulay
   */
  public static class GlassFalling {
  
    // Do not change the parameters!
    public int glassFallingRecur(int floors, int sheets) {
      //We need to get the minimum number of trials so let's set a variable to hold it
      int minimum = 1000; //just an arbitrary large number to make sure we get the first minimum correctly.
      int answer;
  
      
  
      //Base Case
      //if there are no floors then no trials needed.
      //Also, if there is only one floor then only need to trial once.
      if(floors == 0 || floors == 1)
        return floors;
  
      //if there is only one sheet then we have to try every single floor
      if(sheets == 1)
        return floors;
  
      //now we have to consider dropping the glass from each floor and take into consideration
      //both cases- when it breakes and when it doesn't, and take the minimum from these trials.
      for (int i = 1; i <= floors; i++){
        answer = Math.max(glassFallingRecur(floors-1, sheets-1), glassFallingRecur(floors-i, sheets));
        if(answer < minimum)
          minimum = answer;
      }
  
      //we have to add one for the initial drop from each floor
      return minimum + 1;
  
    }
  
    // Optional:
    // Pick whatever parameters you want to, just make sure to return an int.
    public int glassFallingMemoized() {
      // Fill in here and change the return
      return 0;
    }
  
    // Do not change the parameters!
    public int glassFallingBottomUp(int floors, int sheets) {
      int [][] trials = new int [sheets+1][floors+1];
  
      //no floors, no drops required, and 1 floor means 1 drop required
  
      for (int i = 1; i <= sheets; i++) {
        trials[i][0] = 0;
        trials[i][1] = 1;
    }
    //base case 2:
    //if there is only one egg then num of drops equals num of floors
    for (int i = 1; i <= floors; i++) {
        trials[1][i] = i;
    }
  
    for (int i = 2; i <=sheets ; i++) {
        for (int j = 2; j <=floors ; j++) {
            trials[i][j] = Integer.MAX_VALUE;
            int tempResult;
            for (int k = 1; k <=j ; k++) {
                tempResult = 1 + Math.max(trials[i-1][k-1], trials[i][j-k]);
                trials[i][j] = Math.min(tempResult,trials[i][j]);
            }
        }
    }
    //minimum number of drops required in worst case
    return trials[sheets][floors];
  }
      
  

    public static void main(String args[]){
        GlassFalling gf = new GlassFalling();
  
        // Do not touch the below lines of code, and make sure
        // in your final turned-in copy, these are the only things printed
        int minTrials1Recur = gf.glassFallingRecur(27, 2);
        int minTrials1Bottom = gf.glassFallingBottomUp(27, 2);
        int minTrials2Recur = gf.glassFallingRecur(100, 3);
        int minTrials2Bottom = gf.glassFallingBottomUp(100, 3);
        System.out.println(minTrials1Recur + " " + minTrials1Bottom);
        System.out.println(minTrials2Recur + " " + minTrials2Bottom);
    }
  }
  
