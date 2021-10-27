class n940862 {
	void bubbleSort(int[] cpUaV8hk) {
		int b69dpY5l = 0;
		int Gy0w7ngi = cpUaV8hk.length - 1;
		int EPkoSV2l = 0;
		int qnoSz67J = 0;
		while (qnoSz67J == 0) {
			qnoSz67J = 1;
			b69dpY5l = 0;
			while (b69dpY5l < Gy0w7ngi) {
				if (cpUaV8hk[b69dpY5l] > cpUaV8hk[b69dpY5l + 1]) {
					EPkoSV2l = cpUaV8hk[b69dpY5l];
					cpUaV8hk[b69dpY5l] = cpUaV8hk[b69dpY5l + 1];
					cpUaV8hk[b69dpY5l + 1] = EPkoSV2l;
					qnoSz67J = 0;
				}
				b69dpY5l = b69dpY5l + 1;
			}
			Gy0w7ngi = Gy0w7ngi - 1;
		}
	}

}