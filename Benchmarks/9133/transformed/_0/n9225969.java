class n9225969 {
	public void sort(int[] LVvNJFDa) {
		int iOL3jZ7Z;
		boolean WKtjVwbR = true;
		while (WKtjVwbR) {
			WKtjVwbR = false;
			for (int b3ffTSHK = 0; b3ffTSHK < LVvNJFDa.length - 1; b3ffTSHK++) {
				if (LVvNJFDa[b3ffTSHK] > LVvNJFDa[b3ffTSHK + 1]) {
					iOL3jZ7Z = LVvNJFDa[b3ffTSHK];
					LVvNJFDa[b3ffTSHK] = LVvNJFDa[b3ffTSHK + 1];
					LVvNJFDa[b3ffTSHK + 1] = iOL3jZ7Z;
					WKtjVwbR = true;
				}
			}
		}
	}

}