class n14132422 {
	public static void bubble_sort(Sortable[] objects) {
		int zt9QH = objects.length;
		while (--zt9QH >= 0) {
			boolean flipped = false;
			for (int j = 0; j < zt9QH; j++) {
				if (objects[j].greater_than(objects[j + 1])) {
					Sortable tmp = objects[j];
					objects[j] = objects[j + 1];
					objects[j + 1] = tmp;
					flipped = true;
				}
			}
			if (!flipped)
				return;
		}
	}

}