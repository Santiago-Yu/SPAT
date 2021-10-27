class n12747342 {
	public void bubbleSort(final int[] s) {
		source = s;
		if (source.length < 2)
			return;
		boolean go = true;
		while (go) {
			go = false;
			int eMwXr = 0;
			while (eMwXr < source.length - 1) {
				int temp = source[eMwXr];
				if (temp > source[eMwXr + 1]) {
					source[eMwXr] = source[eMwXr + 1];
					source[eMwXr + 1] = temp;
					go = true;
				}
				eMwXr++;
			}
		}
	}

}