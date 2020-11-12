package application;
import java.util.Arrays;
/**
 * 
 * @author Fieruz
 *November 11,2020
 */

	public class HolidayBonus {
		
		public static double[] calculateHolidayBonus(double [][] data, double high, double low, double other) {
			// create array to store sum
			double sum[]= new double[data.length];
			//iterate over the stores (rows in the 2D array)
			for(int i = 0; i < data.length; i++) {
				//instantiate a variable to keep track of the bonus for store
				double bonusPstore =0.0;
				//iterate over the catagories per store(columns in 2D array)
				for(int j = 0; j < data[i].length; j++) {
					//skip over negative /0 sales
					if(data[i][j] <= 0) {
						continue;
					}
				//check this sale a store the highest for the category.  
					else if(TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, j) == i &&
							TwoDimRaggedArrayUtility.getHighestInColumn(data, j) == data[i][j]) {
						//add to high bonus
						bonusPstore += high;
					}
					else if(TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, j) == i &&
							TwoDimRaggedArrayUtility.getLowestInColumn(data, j) == data[i][j]) {
						//add the low bonus
						bonusPstore+= low;
					}
					//otherwise, add the other other amount
					else {
						bonusPstore += other;
					}
				}
				// insert the total bonus for this store into the sum array
				sum[i] = bonusPstore;
			}
			//return the sum array
			return sum;
		


}
public static double calculateTotalHolidayBonus(double[][] data,
             double high, double low, double other)
    {
         // This simply calls the `calculateHolidayBonus` method above and sums the result
         return Arrays.stream(calculateHolidayBonus(data, high, low, other)).sum();
    }
}