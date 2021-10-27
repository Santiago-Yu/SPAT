class n10715601 {
	public static synchronized String toSHA1(String qbnJetKV) {
		Nulls.failIfNull(qbnJetKV, "Cannot create an SHA1 encryption form a NULL string");
		try {
			MessageDigest Q9TIlgqJ;
			Q9TIlgqJ = MessageDigest.getInstance(SHA1);
			byte[] fUthc3Um = new byte[40];
			Q9TIlgqJ.update(qbnJetKV.getBytes(ISO_CHARSET), 0, qbnJetKV.length());
			fUthc3Um = Q9TIlgqJ.digest();
			return convertToHex(fUthc3Um);
		} catch (NoSuchAlgorithmException IxyCpvtS) {
			IxyCpvtS.printStackTrace();
		} catch (UnsupportedEncodingException GJVQMLzL) {
			GJVQMLzL.printStackTrace();
		}
		return null;
	}

}