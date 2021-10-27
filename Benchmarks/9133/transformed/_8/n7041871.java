class n7041871 {
	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				int dNOzc918 = j + 1;
				if (array[j] > array[dNOzc918]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
			int YpOLsdjj = i + 1;
			System.out.println("??" + (YpOLsdjj) + "??????");
			for (int k = 0; k < array.length; k++) {
				System.out.print(array[k] + " ");
			}
			System.out.println();
		}
	}

}