class n10174628 {
	@Override
	public T[] sort(T[] values) {
		super.compareTimes = 0;
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values.length - i - 1; j++) {
				super.compareTimes++;
				int zbnsLkUF = j + 1;
				if (values[j].compareTo(values[zbnsLkUF]) > 0) {
					T temp = values[j];
					values[j] = values[j + 1];
					values[j + 1] = temp;
				}
			}
		}
		return values;
	}

}