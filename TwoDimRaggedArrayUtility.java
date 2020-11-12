package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * 
 * @author Fieruz
 * TwoDimRaggedArrayUtility  
 * Passing arrays to and from methods 
 * Creating a Utility class (static methods) * 
 * November 11, 2020
*/

public class TwoDimRaggedArrayUtility {

	public static double[][] readFile(File file) {

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			int count = 0;
			while (br.readLine() != null) {
				count++;

			}   double[][] doubles = new double[count][];
			br = new BufferedReader(new FileReader(file));
			for (int i = 0; i < count; i++) {
				String[] line;
				line = br.readLine().split(" ");
				doubles[i] = new double[line.length];
				for (int j = 0; j < line.length; j++) {
					doubles[i][j] = Double.parseDouble(line[j]);
				}
			}   return doubles;
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}

	public static void writeToFile(double[][] data, File file) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			for (int i = 0; i < data.length; i++) {
				for (int j = 0; j < data[i].length; j++) {
					fw.write(String.format("%.2f", data[i][j]) + " ");
				}
				fw.flush();
				fw.write("\n");
				fw.flush();
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public static double getTotal(double[][] data) {
		double sum = 0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				sum+=data[i][j];
			}
		}
		return sum;
	}
	public static double getAverage(double[][] data) {
		double sum = 0;
		int count = 0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				sum += data[i][j];
				count++;
			}
		}
		double avg = sum / count;
		return avg;
	}
	public static double getRowTotal(double[][] data, int idx) {
		double sum = 0;
		for (int j = 0; j < data[idx].length; j++) {
			sum += data[idx][j];
		}
		return sum;
	}
	public static double getColumnTotal(double[][] data, int idx) {
		double sum = 0;
		for (int j = 0; j < data.length; j++) {
			try {
				sum += data[j][idx];
			} catch (ArrayIndexOutOfBoundsException e) {
				continue;
			}
		}
		return sum;
	}
	public static double getHighestInRow(double[][] data, int idx) {
		double max = data[idx][0];
		for (int j = 0; j < data[idx].length; j++) {
			if (data[idx][j] > max) {
				max = data[idx][j];
			}
		}
		return max;
	}

	public static int getHighestInRowIndex(double[][] data, int idx) {
		double max = data[idx][0];
		int temp = 0;
		for (int j = 0; j < data[idx].length; j++) {
			if (data[idx][j] > max) {
				max = data[idx][j];
				temp = j;
			}
		}
		return temp;
	}

	public static double getLowestInRow(double[][] data, int idx) {
		double min = data[idx][0];
		for (int j = 0; j < data[idx].length; j++) {
			if (data[idx][j] < min) {
				min = data[idx][j];
			}
		}
		return min;
	}
	public static int getLowestInRowIndex(double[][] data, int idx) {
		double min = data[idx][0];
		int temp = 0;
		for (int j = 0; j < data[idx].length; j++) {
			if (data[idx][j] < min) {
				min = data[idx][j];
				temp = j;
			}
		}
		return temp;
	}

	public static double getHighestInColumn(double[][] data, int idx) {

		double max = Double.MIN_VALUE;

		for (int j = 0; j < data.length; j++) {

			try {
				if (data[j][idx] > max) {
					max = data[j][idx];
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				continue;
			}

		}
		return max;
	}
	public static int getHighestInColumnIndex(double[][] data, int idx) {
		double max = Double.MIN_VALUE;


		int temp = 0;
		for (int j = 0; j < data.length; j++) {
			try {
				if (data[j][idx] > max) {
					max = data[j][idx];
					temp = j;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				continue;
			}

		}
		return temp;
	}

	public static double getLowestInColumn(double[][] data, int idx) {
		double min = Double.MAX_VALUE;
		for (int j = 0; j < data.length; j++) {

			try {
				if (data[j][idx] < min) {
					min = data[j][idx];
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				continue;
			}
		}

		return min;
	}

	public static int getLowestInColumnIndex(double[][] data, int idx) {
		double min = Double.MAX_VALUE;
		int temp = 0;
		for (int j = 0; j < data.length; j++) {

			try {
				if (data[j][idx] < min) {
					min = data[j][idx];
					temp = j;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
			}

		}
		return temp;
	}
	public static double getHighestInArray(double[][] data) {
		double max = data[0][0];
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if (data[i][j] > max) {
					max = data[i][j];
				}
			}
		}
		return max;
	}

	public static double getLowestInArray(double[][] data) {
		double min = data[0][0];
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if (data[i][j] < min) {
					min = data[i][j];
				}
			}
		}
		return min;
	}

}

