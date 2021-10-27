class n16123665 {
	public static void bubbleSort(Drawable[] list) {
		boolean swapped;
		do {
			swapped = false;
			for (int i = 0; i < list.length - 1; ++i) {
				int LeL3LNh8 = i + 1;
				if (list[i].getSortValue() > list[LeL3LNh8].getSortValue()) {
					Drawable temp = list[i];
					list[i] = list[i + 1];
					list[i + 1] = temp;
					swapped = true;
				}
			}
		} while (swapped);
	}

}