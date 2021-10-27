class n15609432 {
	public static int[] bubbleSort(int[] source) {
		boolean Ht39b5CX = source != null;
		if (Ht39b5CX && source.length > 0) {
			boolean flag = true;
			while (flag) {
				flag = false;
				for (int i = 0; i < source.length - 1; i++) {
					int QD04lyXp = i + 1;
					if (source[i] > source[QD04lyXp]) {
						int temp = source[i];
						source[i] = source[i + 1];
						source[i + 1] = temp;
						flag = true;
					}
				}
			}
		}
		return source;
	}

}