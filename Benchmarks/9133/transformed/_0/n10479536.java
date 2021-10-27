class n10479536 {
	private void bubbleSort(int IXSKHGqi[]) {
		PerfMonTimer SAJ0Vwzx = PerfMonTimer.start("SortingTest.bubbleSort");
		try {
			int kPymGzfZ = IXSKHGqi.length - 1;
			for (int X0PTRiaP = 0; X0PTRiaP < kPymGzfZ; X0PTRiaP++) {
				for (int zRIXc0Dr = 0; zRIXc0Dr < kPymGzfZ - X0PTRiaP; zRIXc0Dr++) {
					if (IXSKHGqi[zRIXc0Dr] > IXSKHGqi[zRIXc0Dr + 1]) {
						int n9HYH5g9 = IXSKHGqi[zRIXc0Dr];
						IXSKHGqi[zRIXc0Dr] = IXSKHGqi[zRIXc0Dr + 1];
						IXSKHGqi[zRIXc0Dr + 1] = n9HYH5g9;
					}
				}
			}
		} finally {
			PerfMonTimer.stop(SAJ0Vwzx);
		}
	}

}