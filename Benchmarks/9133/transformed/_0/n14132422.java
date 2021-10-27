class n14132422 {
	public static void bubble_sort(Sortable[] I9UgH99P) {
		for (int toSzLlI7 = I9UgH99P.length; --toSzLlI7 >= 0;) {
			boolean N11dTj4d = false;
			for (int sZSQRQbe = 0; sZSQRQbe < toSzLlI7; sZSQRQbe++) {
				if (I9UgH99P[sZSQRQbe].greater_than(I9UgH99P[sZSQRQbe + 1])) {
					Sortable akNFsFky = I9UgH99P[sZSQRQbe];
					I9UgH99P[sZSQRQbe] = I9UgH99P[sZSQRQbe + 1];
					I9UgH99P[sZSQRQbe + 1] = akNFsFky;
					N11dTj4d = true;
				}
			}
			if (!N11dTj4d)
				return;
		}
	}

}