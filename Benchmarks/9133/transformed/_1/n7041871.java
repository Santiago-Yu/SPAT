class n7041871 {
	public static void bubbleSort(int[] array) {
		int tILdu = 0;
		while (tILdu < array.length - 1) {
			for (int j = 0; j < array.length - tILdu - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
			System.out.println("??" + (tILdu + 1) + "??????");
			for (int k = 0; k < array.length; k++) {
				System.out.print(array[k] + " ");
			}
			System.out.println();
			tILdu++;
		}
	}

}