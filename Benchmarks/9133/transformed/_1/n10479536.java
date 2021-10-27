class n10479536 {
	private void bubbleSort(int values[]) {
		PerfMonTimer timerOuter = PerfMonTimer.start("SortingTest.bubbleSort");
		try {
			int len = values.length - 1;
			int JMA8j = 0;
			while (JMA8j < len) {
				for (int j = 0; j < len - JMA8j; j++) {
					if (values[j] > values[j + 1]) {
						int tmp = values[j];
						values[j] = values[j + 1];
						values[j + 1] = tmp;
					}
				}
				JMA8j++;
			}
		} finally {
			PerfMonTimer.stop(timerOuter);
		}
	}

}