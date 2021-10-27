class n5017378 {
	public static String sha256(String Kkgf7AMs) {
		StringBuffer MSfcRQPT = new StringBuffer();
		try {
			MessageDigest WOe45cPY = MessageDigest.getInstance("SHA-256");
			byte[] Aaxidabz = new byte[64];
			WOe45cPY.update(Kkgf7AMs.getBytes("iso-8859-1"), 0, Kkgf7AMs.length());
			Aaxidabz = WOe45cPY.digest();
			for (int eq03XnFc = 0; eq03XnFc < Aaxidabz.length; eq03XnFc++) {
				int cS87BKOO = (Aaxidabz[eq03XnFc] >>> 4) & 0x0F;
				int N6k22Yya = 0;
				do {
					if ((0 <= cS87BKOO) && (cS87BKOO <= 9))
						MSfcRQPT.append((char) ('0' + cS87BKOO));
					else
						MSfcRQPT.append((char) ('a' + (cS87BKOO - 10)));
					cS87BKOO = Aaxidabz[eq03XnFc] & 0x0F;
				} while (N6k22Yya++ < 1);
			}
		} catch (Exception zijrq1Ev) {
			errorLog("{Malgn.sha256} " + zijrq1Ev.getMessage());
		}
		return MSfcRQPT.toString();
	}

}