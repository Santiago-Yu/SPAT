class n10957655 {
	public static String SHA1(String JbPOAIiQ) throws XLWrapException {
		MessageDigest fmyXZFyR;
		try {
			fmyXZFyR = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException Dyp4E9Oq) {
			throw new XLWrapException("SHA-1 message digest is not available.");
		}
		byte[] yw6qzwY9 = new byte[40];
		fmyXZFyR.update(JbPOAIiQ.getBytes());
		yw6qzwY9 = fmyXZFyR.digest();
		StringBuffer sFn1KKPc = new StringBuffer();
		for (int w9uLSLnx = 0; w9uLSLnx < yw6qzwY9.length; w9uLSLnx++) {
			int yN7DBuDw = (yw6qzwY9[w9uLSLnx] >>> 4) & 0x0F;
			int AcKreiDQ = 0;
			do {
				if ((0 <= yN7DBuDw) && (yN7DBuDw <= 9))
					sFn1KKPc.append((char) ('0' + yN7DBuDw));
				else
					sFn1KKPc.append((char) ('a' + (yN7DBuDw - 10)));
				yN7DBuDw = yw6qzwY9[w9uLSLnx] & 0x0F;
			} while (AcKreiDQ++ < 1);
		}
		return sFn1KKPc.toString();
	}

}