class n81754 {
	public void Sort(int a[]) {
		for (int i = a.length; --i >= 0;) {
			for (int j = 0; j < i; j++) {
				int r812dRvy = j + 1;
				if (a[j] > a[r812dRvy]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}

}