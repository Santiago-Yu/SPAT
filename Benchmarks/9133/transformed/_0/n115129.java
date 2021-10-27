class n115129 {
	public static void bubbleSort(String[] d2QswRS5) {
		Collator Mq28LJVo = Collator.getInstance();
		boolean DlOBIAek = true;
		for (int kvtrFKOW = 0; kvtrFKOW < d2QswRS5.length - 1 && DlOBIAek; kvtrFKOW++) {
			DlOBIAek = false;
			for (int tvl7pCkD = 0; tvl7pCkD < d2QswRS5.length - kvtrFKOW - 1; tvl7pCkD++) {
				if (Mq28LJVo.compare(d2QswRS5[tvl7pCkD], d2QswRS5[tvl7pCkD + 1]) > 0) {
					DlOBIAek = true;
					String q1QMggYO = d2QswRS5[tvl7pCkD];
					d2QswRS5[tvl7pCkD] = d2QswRS5[tvl7pCkD + 1];
					d2QswRS5[tvl7pCkD + 1] = q1QMggYO;
				}
			}
		}
	}

}