class n359113 {
	public static void bubbleSort(String[] VD9PV9a3) {
		Collator vqEbNqrc = Collator.getInstance();
		boolean ZX3xOy98 = true;
		for (int LDFaTst2 = 0; LDFaTst2 < VD9PV9a3.length - 1 && ZX3xOy98; LDFaTst2++) {
			ZX3xOy98 = false;
			for (int tIbLBvek = 0; tIbLBvek < VD9PV9a3.length - LDFaTst2 - 1; tIbLBvek++) {
				if (vqEbNqrc.compare(VD9PV9a3[tIbLBvek], VD9PV9a3[tIbLBvek + 1]) > 0) {
					ZX3xOy98 = true;
					String HORjS50h = VD9PV9a3[tIbLBvek];
					VD9PV9a3[tIbLBvek] = VD9PV9a3[tIbLBvek + 1];
					VD9PV9a3[tIbLBvek + 1] = HORjS50h;
				}
			}
		}
	}

}