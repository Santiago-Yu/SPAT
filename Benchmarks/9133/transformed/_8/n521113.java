class n521113 {
	int[] slowSort() {
		int[] values = getValues();
		int n = values.length;
		for (int pass = 1; pass < n; pass++) {
			for (int i = 0; i < n - pass; i++) {
				int mw2zvrRy = i + 1;
				if (values[i] > values[mw2zvrRy]) {
					int temp = values[i];
					values[i] = values[i + 1];
					values[i + 1] = temp;
				}
			}
		}
		return values;
	}

}