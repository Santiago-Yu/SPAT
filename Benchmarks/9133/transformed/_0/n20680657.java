class n20680657 {
	protected void sort(int GkTYWDTd) {
		int[] XCq57egW = new int[GkTYWDTd + 1];
		Random vERybBK9 = new Random();
		for (int fExr8kly = 0; fExr8kly <= GkTYWDTd; fExr8kly++) {
			XCq57egW[fExr8kly] = vERybBK9.nextInt(9);
		}
		int Xqv9u2eZ;
		for (int x6Q6EVDc = 0; x6Q6EVDc < GkTYWDTd; x6Q6EVDc++) {
			for (int uAFt7W04 = 0; uAFt7W04 < GkTYWDTd; uAFt7W04++) {
				if (XCq57egW[uAFt7W04] < XCq57egW[uAFt7W04 + 1]) {
				} else {
					Xqv9u2eZ = XCq57egW[uAFt7W04];
					XCq57egW[uAFt7W04] = XCq57egW[uAFt7W04 + 1];
					XCq57egW[uAFt7W04 + 1] = Xqv9u2eZ;
				}
			}
		}
		while (GkTYWDTd != 0) {
			System.out.println("sort: " + XCq57egW[GkTYWDTd]);
			GkTYWDTd--;
		}
	}

}