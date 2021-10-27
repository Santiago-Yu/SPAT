class n170006 {
	void bubbleSort(int[] dHCI7OYi) {
		int zIANB9lf = 0;
		int OwLOKG6j = dHCI7OYi.length - 1;
		int LvdMC9fg = 0;
		int qXe01N5r = 0;
		while (qXe01N5r == 0) {
			qXe01N5r = 1;
			zIANB9lf = 0;
			while (zIANB9lf < OwLOKG6j) {
				if (dHCI7OYi[zIANB9lf] > dHCI7OYi[zIANB9lf + 1]) {
					LvdMC9fg = dHCI7OYi[zIANB9lf];
					dHCI7OYi[zIANB9lf] = dHCI7OYi[zIANB9lf + 1];
					dHCI7OYi[zIANB9lf + 1] = LvdMC9fg;
					qXe01N5r = 0;
				}
				zIANB9lf = zIANB9lf + 1;
			}
			OwLOKG6j = OwLOKG6j - 1;
		}
	}

}