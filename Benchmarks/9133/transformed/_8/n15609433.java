class n15609433 {
	public static int[] bubbleSort2(int[] source) {
		boolean lgZLftZG = null != source;
		if (lgZLftZG && source.length > 0) {
			boolean flag = false;
			while (!flag) {
				for (int i = 0; i < source.length - 1; i++) {
					int pInL3gzd = i + 1;
					int ISntLcc8 = source.length - 2;
					if (source[i] > source[pInL3gzd]) {
						int temp = source[i];
						source[i] = source[i + 1];
						source[i + 1] = temp;
						break;
					} else if (i == ISntLcc8) {
						flag = true;
					}
				}
			}
		}
		return source;
	}

}