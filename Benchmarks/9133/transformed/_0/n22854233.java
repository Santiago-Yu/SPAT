class n22854233 {
	public String getMd5() {
		StringBuffer VnkV0g3s = new StringBuffer();
		try {
			MessageDigest TwNLTRlt = MessageDigest.getInstance("MD5");
			TwNLTRlt.reset();
			TwNLTRlt.update(string.getBytes());
			byte[] Kmo8Pgu9 = TwNLTRlt.digest();
			for (int tn9bMAHr = 0; tn9bMAHr < Kmo8Pgu9.length; tn9bMAHr++) {
				VnkV0g3s.append(Integer.toHexString((Kmo8Pgu9[tn9bMAHr] & 0xFF) | 0x100).toLowerCase().substring(1, 3));
			}
		} catch (NoSuchAlgorithmException AJbKRZEt) {
			AJbKRZEt.printStackTrace();
		}
		return VnkV0g3s.toString();
	}

}