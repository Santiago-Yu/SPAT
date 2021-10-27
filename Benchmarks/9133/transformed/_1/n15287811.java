class n15287811 {
	public static int[] sort(int[] v) {
		int i;
		int l = v.length;
		int[] index = new int[l];
		i = 0;
		while (i < l) {
			index[i] = i;
			i++;
		}
		int tmp;
		boolean change = true;
		while (change) {
			change = false;
			i = 0;
			while (i < l - 1) {
				if (v[index[i]] > v[index[i + 1]]) {
					tmp = index[i];
					index[i] = index[i + 1];
					index[i + 1] = tmp;
					change = true;
				}
				i++;
			}
		}
		return index;
	}

}