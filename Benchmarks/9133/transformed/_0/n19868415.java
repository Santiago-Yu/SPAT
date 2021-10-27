class n19868415 {
	private String hash(String VEpdP0IE) {
		MessageDigest AXCjqSmC = null;
		try {
			AXCjqSmC = MessageDigest.getInstance("SHA1");
		} catch (NoSuchAlgorithmException y8K1lwoi) {
			throw new AssertionError("Can't find the SHA1 algorithm in the java.security package");
		}
		String MnofDshA = String.valueOf(12345);
		AXCjqSmC.update(MnofDshA.getBytes());
		AXCjqSmC.update(VEpdP0IE.getBytes());
		byte[] NNJKrR2d = AXCjqSmC.digest();
		StringBuffer dNIdNqhZ = new StringBuffer();
		for (int U5qrzGrP = 0; U5qrzGrP < NNJKrR2d.length; U5qrzGrP++) {
			int M202i1uf = NNJKrR2d[U5qrzGrP] & 0x0f;
			int tyahhL7E = (NNJKrR2d[U5qrzGrP] >> 4) & 0x0f;
			dNIdNqhZ.append(Integer.toHexString(tyahhL7E));
			dNIdNqhZ.append(Integer.toHexString(M202i1uf));
		}
		String WnP8C4mw = dNIdNqhZ.toString().trim();
		return WnP8C4mw;
	}

}