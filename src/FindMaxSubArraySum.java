/* FindMaxSubArraySum
 * Description:
 *   Finds the Sub Array having Maximum Sum and display that Sum
 * Input Format: Takes input from Standard Input
 *  Example Input array: [ 2 -1 -1 -3 -2 3 -4 -8 -3 -8 9 -9 6 -4 2 7 5 ]  
 * @param Array Input Array in which to find the maximum sub array
 * @author Gurpreet Singh
 */
import java.util.Scanner;
public class FindMaxSubArraySum {
	public static int Array[] = new int[30000000];
	public static void main(String[] args) {	
	    int count = FillArray();
		int[] MaxSubArray = FIND_MAXIMUM_SUBARRAY(Array, 0, count);
		System.out.print("Sum of Max Sub Array: "+MaxSubArray[2]);
	}
	
	public static int[] FIND_MAXIMUM_SUBARRAY (int[] A, int low, int high){
		
	     int[] MaxSubArray = {low, high, A[low]};
		 if(high == low){        // base case: only one element
		      return MaxSubArray;   
		 }else{
			 int mid = (low+high)/2;  
			 int[] Left =  FIND_MAXIMUM_SUBARRAY( A, low, mid); 
			 int[] Right = FIND_MAXIMUM_SUBARRAY( A, mid+1, high);
			 int[] Cross = FIND_MAX_CROSSING_SUBARRAY( A, low, mid, high);
			 
			 if(Left[2] >= Right[2] && Left[2] >= Cross[2]){
				 return Left;
			 }
			 else if(Right[2] >= Left[2] && Right[2] >= Cross[2]){
				 return Right;
			 }
			 else {
				 return Cross;
			 }
	     }	
	} // FIND_MAXIMUM_SUBARRAY
	
	public static int[] FIND_MAX_CROSSING_SUBARRAY(int[] A, int low, int mid, int high){
		double left_sum = -(2)^63;
		int sum = 0, max_left=0, max_right=0;
		for(int i= mid; i >= low; i--){
			sum = sum + A[i];
			if(sum > left_sum){
				left_sum = sum;
				max_left = i;
			}
		}
		double right_sum = -(2)^63;
		sum =0;
		for(int i= mid+1; i <=high ; i++){
			sum = sum + A[i];
			if(sum > right_sum){
				right_sum = sum;
				max_right = i;
			}
		}
		int[] MaxCrossSubArray = {max_left, max_right, (int)(left_sum + right_sum)};
		return MaxCrossSubArray ;
	}
	
	public static int FillArray(){
		Scanner scanner = new Scanner(System.in);
        String NextInput = scanner.next();
	    int count=0;
	    if(NextInput.equalsIgnoreCase("[")){
	    	   NextInput = scanner.next();
	    	   while(NextInput.equalsIgnoreCase("]")== false){ 
	    		   Array[count++] = Integer.parseInt(NextInput);
	    		   NextInput = scanner.next();
	    	   }
	    	   System.out.println("Count Elements in Input Array: "+count);
	     }
	    System.out.print("Input Array: ");
		for(int j=0; j < count; j++){
           System.out.print(Array[j]+" ");
    	}
    	System.out.println();
    	return count;
    }  // FillArray
}// FindMaxSubArraySum
