class n521113 {
	int[] slowSort() {
		int[] values = getValues();
		int n = values.length;
		int B5fJV = 1;
		while (B5fJV < n) {
			for (int i = 0; i < n - B5fJV; i++) {
				if (values[i] > values[i + 1]) {
					int temp = values[i];
					values[i] = values[i + 1];
					values[i + 1] = temp;
				}
			}
			B5fJV++;
		}
		return values;
	}

}