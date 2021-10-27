class n22768445 {
	public static String hashNative(String XUK2VI2t, String JiOZ0Fll, String eWsywV11, boolean mSVwkNoq) {
		try {
			MessageDigest bIxP6RAM = MessageDigest.getInstance(JiOZ0Fll);
			if (mSVwkNoq) {
				bIxP6RAM.update(XUK2VI2t.getBytes());
			} else {
				for (char WV9Q2ueL : XUK2VI2t.toCharArray()) {
					bIxP6RAM.update((byte) (WV9Q2ueL >> 8));
					bIxP6RAM.update((byte) WV9Q2ueL);
				}
			}
			byte[] L6VTg44D = bIxP6RAM.digest();
			BASE64Encoder eLfBlJe9 = new BASE64Encoder();
			String PVXbzrF1 = eLfBlJe9.encode(L6VTg44D);
			return eWsywV11 + PVXbzrF1;
		} catch (NoSuchAlgorithmException nUNYp34v) {
			return XUK2VI2t;
		}
	}

}