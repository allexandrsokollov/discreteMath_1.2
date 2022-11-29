import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		try {
			String[] fileData = FileReader.getFileData("input.txt");
			int[] intArray = FileReader.getIntArrFromStringArr(fileData[0]);
			int result = findAmountOfComparisonsInBinarySearch(intArray, 6);

			FileWriter.writeStringToFile("out.txt", "", String.valueOf(result));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static int findAmountOfComparisonsInBinarySearch(int[] arr, int key) {
		int first = 0;
		int last = arr.length - 1;
		int mid = (first + last) / 2;
		int comparisons = 0;

		while (first <= last) {
			if (arr[mid] < key) {
				first = mid + 1;
				comparisons++;
			} else if (arr[mid] == key) {
				System.out.println("Element is found at index: " + mid);
				comparisons++;
				break;
			} else {
				last = mid - 1;
			}
			mid = (first + last) / 2;
		}
		if (first > last) {
			System.out.println("Element is not found!");
		}

		return comparisons;
	}
}