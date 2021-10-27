class n16123665 {
	public static void bubbleSort(Drawable[] list) {
		boolean swapped;
		do {
			swapped = false;
			int bjBrF = 0;
			while (bjBrF < list.length - 1) {
				if (list[bjBrF].getSortValue() > list[bjBrF + 1].getSortValue()) {
					Drawable temp = list[bjBrF];
					list[bjBrF] = list[bjBrF + 1];
					list[bjBrF + 1] = temp;
					swapped = true;
				}
				++bjBrF;
			}
		} while (swapped);
	}

}