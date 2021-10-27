class n15287811 {
	public static int[] sort(int[] v) {
		int l = v.length;
		int i;
		int[] index = new int[l];
		int tmp;
		for (i = 0; i < l; i++)
			index[i] = i;
		boolean change = true;
		while (change) {
			change = false;
			for (i = 0; i < l - 1; i++) {
				if (v[index[i]] > v[index[i + 1]]) {
					tmp = index[i];
					index[i] = index[i + 1];
					change = true;
					index[i + 1] = tmp;
				}
			}
		}
		return index;
	}

}