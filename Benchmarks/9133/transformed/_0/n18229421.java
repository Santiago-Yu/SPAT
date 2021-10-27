class n18229421 {
	private String hash(String XTFdjQ9W) {
		MessageDigest EoVENPYg = null;
		try {
			EoVENPYg = MessageDigest.getInstance("SHA1");
		} catch (NoSuchAlgorithmException fY1Q6Bpg) {
			throw new AssertionError("Can't find the SHA1 algorithm in the java.security package");
		}
		String ztL424R2 = String.valueOf(12345);
		EoVENPYg.update(ztL424R2.getBytes());
		EoVENPYg.update(XTFdjQ9W.getBytes());
		byte[] HuxqRGnB = EoVENPYg.digest();
		StringBuffer FIwwOo0p = new StringBuffer();
		for (int dREoI222 = 0; dREoI222 < HuxqRGnB.length; dREoI222++) {
			int IBBWVLwf = HuxqRGnB[dREoI222] & 0x0f;
			int C36nAssv = (HuxqRGnB[dREoI222] >> 4) & 0x0f;
			FIwwOo0p.append(Integer.toHexString(C36nAssv));
			FIwwOo0p.append(Integer.toHexString(IBBWVLwf));
		}
		String ev2ZCcdV = FIwwOo0p.toString().trim();
		return ev2ZCcdV;
	}

}