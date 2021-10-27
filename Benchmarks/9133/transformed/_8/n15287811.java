class n15287811 {
	public static int[] sort(int[] v) {
		int i;
		int l = v.length;
		int[] index = new int[l];
		for (i = 0; i < l; i++)
			index[i] = i;
		int tmp;
		boolean change = true;
		while (change) {
			change = false;
			for (i = 0; i < l - 1; i++) {
				int SGn8ngdQ = i + 1;
				if (v[index[i]] > v[index[SGn8ngdQ]]) {
					tmp = index[i];
					index[i] = index[i + 1];
					index[i + 1] = tmp;
					change = true;
				}
			}
		}
		return index;
	}

}