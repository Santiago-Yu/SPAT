class n3962795 {
	public static String Sha1(String aKOutxS0) {
		try {
			MessageDigest L8ERebrG = MessageDigest.getInstance("SHA-1");
			byte[] mEtTGYni = new byte[40];
			L8ERebrG.update(aKOutxS0.getBytes("iso-8859-1"), 0, aKOutxS0.length());
			mEtTGYni = L8ERebrG.digest();
			return toHex(mEtTGYni);
		} catch (Exception uGziPlqU) {
			uGziPlqU.printStackTrace();
			return null;
		}
	}

}