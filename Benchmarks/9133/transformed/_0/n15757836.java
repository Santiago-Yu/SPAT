class n15757836 {
	private int[] sort(int DdrVgS0D) {
		int[] QMNtp4yp = new int[DdrVgS0D];
		Random EecNyIZi = new Random();
		for (int l7i2ov2p = 0; l7i2ov2p < DdrVgS0D; l7i2ov2p++) {
			QMNtp4yp[l7i2ov2p] = EecNyIZi.nextInt(10) + 1;
		}
		boolean reuJbeVh = true;
		int VFMWcgvD = 0;
		while (reuJbeVh) {
			reuJbeVh = false;
			for (int bEunuVxL = 0; bEunuVxL < QMNtp4yp.length - 1; bEunuVxL++) {
				if (QMNtp4yp[bEunuVxL] > QMNtp4yp[bEunuVxL + 1]) {
					VFMWcgvD = QMNtp4yp[bEunuVxL];
					QMNtp4yp[bEunuVxL] = QMNtp4yp[bEunuVxL + 1];
					QMNtp4yp[bEunuVxL + 1] = VFMWcgvD;
					reuJbeVh = true;
				}
			}
		}
		return QMNtp4yp;
	}

}