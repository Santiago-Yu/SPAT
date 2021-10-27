class n15609432 {
	public static int[] bubbleSort(int[] source) {
		if (source != null && source.length > 0) {
			boolean flag = true;
			while (flag) {
				flag = false;
				int iRa8a = 0;
				while (iRa8a < source.length - 1) {
					if (source[iRa8a] > source[iRa8a + 1]) {
						int temp = source[iRa8a];
						source[iRa8a] = source[iRa8a + 1];
						source[iRa8a + 1] = temp;
						flag = true;
					}
					iRa8a++;
				}
			}
		}
		return source;
	}

}