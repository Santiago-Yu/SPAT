class n10598170 {
	private static String sort(final String RCNOvvOq) {
		final char[] cI7nRav2 = RCNOvvOq.toCharArray();
		for (int reQ4KrD1 = 1; reQ4KrD1 < cI7nRav2.length; reQ4KrD1++) {
			for (int oRckwcbS = 0; oRckwcbS < cI7nRav2.length - 1; oRckwcbS++) {
				if (cI7nRav2[oRckwcbS] > cI7nRav2[oRckwcbS + 1]) {
					final char d46LUlJm = cI7nRav2[oRckwcbS];
					cI7nRav2[oRckwcbS] = cI7nRav2[oRckwcbS + 1];
					cI7nRav2[oRckwcbS + 1] = d46LUlJm;
				}
			}
		}
		return String.valueOf(cI7nRav2);
	}

}