class n10927077 {
	private String hash(String PP4b1nOD) {
		MessageDigest er7xzi2m = null;
		try {
			er7xzi2m = MessageDigest.getInstance("SHA1");
		} catch (NoSuchAlgorithmException zL8w2Ybh) {
			throw new AssertionError("Can't find the SHA1 algorithm in the java.security package");
		}
		String pmuP6BVx = String.valueOf(12345);
		er7xzi2m.update(pmuP6BVx.getBytes());
		er7xzi2m.update(PP4b1nOD.getBytes());
		byte[] FAKMfcNH = er7xzi2m.digest();
		StringBuffer HpPQYgiG = new StringBuffer();
		for (int o21HUE3n = 0; o21HUE3n < FAKMfcNH.length; o21HUE3n++) {
			int yHZXmD6w = FAKMfcNH[o21HUE3n] & 0x0f;
			int JCqYlSQt = (FAKMfcNH[o21HUE3n] >> 4) & 0x0f;
			HpPQYgiG.append(Integer.toHexString(JCqYlSQt));
			HpPQYgiG.append(Integer.toHexString(yHZXmD6w));
		}
		String KaffQpMT = HpPQYgiG.toString().trim();
		return KaffQpMT;
	}

}