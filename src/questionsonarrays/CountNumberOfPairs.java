package questionsonarrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountNumberOfPairs {
	// O(n logn) çözümü
	public static int countNumberOfPairs(int[] values) {
		Arrays.sort(values);
		int count = 0;
		int currentFrequency = 1;

		for (int i = 1; i < values.length; i++) {
			if (values[i] == values[i - 1]) {
				currentFrequency++;
			} else {
				if (currentFrequency > 1) {
					count += (currentFrequency - 1) * currentFrequency / 2;
					currentFrequency = 1;
				}
			}
		}

		if (currentFrequency > 1) {
			count += (currentFrequency - 1) * currentFrequency / 2;
		}
		return count;
	}

	private static int countNumberOfPairs2(int[] values) {

		Map<Integer, Integer> valuesMap = new HashMap<>();
		int equalNumbersCount = 0;

		for (int i = 0; i < values.length; i++) {
			int count = 0;
			if (valuesMap.containsKey(values[i])) {
				System.out.println("value :" + values[i]);
				count = valuesMap.get(values[i]);
			}
			count++;
			System.out.println("count " + count);
			valuesMap.put(values[i], count);
		}

		for (int numberKey : valuesMap.keySet()) {
			System.out.println("number key:" + numberKey);
			if (valuesMap.get(numberKey) > 1) {
				int n = valuesMap.get(numberKey);// 1->3 2->2 3->3 4->1 5->1
				equalNumbersCount += (n - 1) * n / 2;
			}
		}

		return equalNumbersCount;
	}

	public static void main(String[] args) {
		// dizi içerisinde bulunan çiftlerin sayısını bulan algoritma
		// örneğim 1,1,1,1 dört tane bir elemanı 6 adet 1-1 çifti üretir.
		int[] arr = { 1, 1, 1, 1, 2, 2, 3, 3, 3, 4, 5, 5 };
		System.out.println(countNumberOfPairs2(arr));

	}

}
