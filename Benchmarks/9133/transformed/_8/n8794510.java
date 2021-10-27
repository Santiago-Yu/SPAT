class n8794510 {
	public static void bubbleSort(Auto[] xs) {
		boolean unsorted = true;
		while (unsorted) {
			unsorted = false;
			for (int i = 0; i < xs.length - 1; i++) {
				int lPl4FNEB = i + 1;
				if (!(xs[i].getPreis() >= xs[lPl4FNEB].getPreis())) {
					Auto dummy = xs[i];
					xs[i] = xs[i + 1];
					xs[i + 1] = dummy;
					unsorted = true;
				}
			}
		}
	}

}