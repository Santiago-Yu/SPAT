class n15609433 {
	public static int[] bubbleSort2(int[] source) {
		if (null != source && source.length > 0) {
			boolean flag = false;
			while (!flag) {
				int bBKOo = 0;
				while (bBKOo < source.length - 1) {
					if (source[bBKOo] > source[bBKOo + 1]) {
						int temp = source[bBKOo];
						source[bBKOo] = source[bBKOo + 1];
						source[bBKOo + 1] = temp;
						break;
					} else if (bBKOo == source.length - 2) {
						flag = true;
					}
					bBKOo++;
				}
			}
		}
		return source;
	}

}