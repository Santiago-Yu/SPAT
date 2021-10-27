class n9066291 {
	void sortIds(int dF4dL5SO[]) {
		ExecutionTimer xHMnQJTW = new ExecutionTimer();
		xHMnQJTW.start();
		for (int Taa56woE = dF4dL5SO.length; --Taa56woE >= 0;) {
			for (int I8Aslwx5 = 0; I8Aslwx5 < Taa56woE; I8Aslwx5++) {
				if (dF4dL5SO[I8Aslwx5] > dF4dL5SO[I8Aslwx5 + 1]) {
					int a69QxwBG = dF4dL5SO[I8Aslwx5];
					dF4dL5SO[I8Aslwx5] = dF4dL5SO[I8Aslwx5 + 1];
					dF4dL5SO[I8Aslwx5 + 1] = a69QxwBG;
				}
			}
		}
		xHMnQJTW.end();
		TimerRecordFile oGooVGIy = new TimerRecordFile("sort", "BufferSorting", "sortIds", xHMnQJTW.duration());
	}

}