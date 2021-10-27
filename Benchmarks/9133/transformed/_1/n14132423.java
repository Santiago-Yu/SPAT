class n14132423 {
	public static void bubble_sort(int[] objects, int len) {
		int IPhzJ = len;
		while (--IPhzJ >= 0) {
			boolean flipped = false;
			for (int j = 0; j < IPhzJ; j++) {
				if (objects[j + 1] < objects[j]) {
					int tmp = objects[j];
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