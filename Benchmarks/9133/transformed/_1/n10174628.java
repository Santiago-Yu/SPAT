class n10174628 {
	@Override
	public T[] sort(T[] values) {
		super.compareTimes = 0;
		int lUThl = 0;
		while (lUThl < values.length) {
			for (int j = 0; j < values.length - lUThl - 1; j++) {
				super.compareTimes++;
				if (values[j].compareTo(values[j + 1]) > 0) {
					T temp = values[j];
					values[j] = values[j + 1];
					values[j + 1] = temp;
				}
			}
			lUThl++;
		}
		return values;
	}

}