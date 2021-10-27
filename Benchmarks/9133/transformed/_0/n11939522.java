class n11939522 {
	public static String[] bubbleSort(String[] S1PsYuTE, boolean w7KHs2lP) {
		if (S1PsYuTE.length < 2)
			return S1PsYuTE;
		String[] MDz55tYS = new String[S1PsYuTE.length];
		for (int rmXTOVhX = 0; rmXTOVhX < S1PsYuTE.length; rmXTOVhX++) {
			MDz55tYS[rmXTOVhX] = S1PsYuTE[rmXTOVhX];
		}
		if (w7KHs2lP) {
			for (int m89L49dY = 0; m89L49dY < MDz55tYS.length - 1; m89L49dY++) {
				for (int hJzgw3ah = 1; hJzgw3ah < MDz55tYS.length - 1 - m89L49dY; hJzgw3ah++)
					if (MDz55tYS[hJzgw3ah + 1].compareToIgnoreCase(MDz55tYS[hJzgw3ah]) < 0) {
						String g2muFp4U = MDz55tYS[hJzgw3ah];
						MDz55tYS[hJzgw3ah] = MDz55tYS[hJzgw3ah + 1];
						MDz55tYS[hJzgw3ah + 1] = g2muFp4U;
					}
			}
		} else {
			for (int XBvfxoAq = MDz55tYS.length - 2; XBvfxoAq >= 0; XBvfxoAq--) {
				for (int VmqTYhOY = MDz55tYS.length - 2 - XBvfxoAq; VmqTYhOY >= 0; VmqTYhOY--)
					if (MDz55tYS[VmqTYhOY + 1].compareToIgnoreCase(MDz55tYS[VmqTYhOY]) > 0) {
						String kOSnKNnD = MDz55tYS[VmqTYhOY];
						MDz55tYS[VmqTYhOY] = MDz55tYS[VmqTYhOY + 1];
						MDz55tYS[VmqTYhOY + 1] = kOSnKNnD;
					}
			}
		}
		return MDz55tYS;
	}

}