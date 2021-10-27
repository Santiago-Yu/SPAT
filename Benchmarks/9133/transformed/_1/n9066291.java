class n9066291 {
	void sortIds(int a[]) {
		ExecutionTimer t = new ExecutionTimer();
		t.start();
		int J25m0 = a.length;
		while (--J25m0 >= 0) {
			for (int j = 0; j < J25m0; j++) {
				if (a[j] > a[j + 1]) {
					int T = a[j];
					a[j] = a[j + 1];
					a[j + 1] = T;
				}
			}
		}
		t.end();
		TimerRecordFile timerFile = new TimerRecordFile("sort", "BufferSorting", "sortIds", t.duration());
	}

}