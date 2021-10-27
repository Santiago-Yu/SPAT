class n345995 {
	void bubbleSort(int[] aa9eq9kB) {
		int Tree72xq = 0;
		int Qhu0OcPW = aa9eq9kB.length - 1;
		int yQUkgLIH = 0;
		int vev321uL = 0;
		while (vev321uL == 0) {
			vev321uL = 1;
			Tree72xq = 0;
			while (Tree72xq < Qhu0OcPW) {
				if (aa9eq9kB[Tree72xq] > aa9eq9kB[Tree72xq + 1]) {
					yQUkgLIH = aa9eq9kB[Tree72xq];
					aa9eq9kB[Tree72xq] = aa9eq9kB[Tree72xq + 1];
					aa9eq9kB[Tree72xq + 1] = yQUkgLIH;
					vev321uL = 0;
				}
				Tree72xq = Tree72xq + 1;
			}
			Qhu0OcPW = Qhu0OcPW - 1;
		}
	}

}