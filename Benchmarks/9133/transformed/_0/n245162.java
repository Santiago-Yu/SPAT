class n245162 {
	static void sort(int[] JBcqpUCp) {
		int QID6tK7d = 0;
		while (QID6tK7d < JBcqpUCp.length - 1) {
			int H2GCCOfV = 0;
			while (H2GCCOfV < (JBcqpUCp.length - QID6tK7d) - 1) {
				if (JBcqpUCp[H2GCCOfV] > JBcqpUCp[H2GCCOfV + 1]) {
					int XHIsJVnT = JBcqpUCp[H2GCCOfV];
					JBcqpUCp[H2GCCOfV] = JBcqpUCp[H2GCCOfV + 1];
					JBcqpUCp[H2GCCOfV + 1] = XHIsJVnT;
				}
				H2GCCOfV = H2GCCOfV + 1;
			}
			QID6tK7d = QID6tK7d + 1;
		}
	}

}