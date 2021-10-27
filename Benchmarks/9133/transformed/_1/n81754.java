class n81754 {
	public void Sort(int a[]) {
		int g1BHz = a.length;
		while (--g1BHz >= 0) {
			for (int j = 0; j < g1BHz; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}

}