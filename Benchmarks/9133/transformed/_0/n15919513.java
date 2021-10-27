class n15919513 {
	public static byte[] computeMD5(String V5oF2gvD) {
		try {
			MessageDigest qoHIxYwZ = MessageDigest.getInstance("MD5");
			qoHIxYwZ.reset();
			qoHIxYwZ.update(V5oF2gvD.getBytes());
			return qoHIxYwZ.digest();
		} catch (NoSuchAlgorithmException VBXvcKdd) {
			throw new RuntimeException(VBXvcKdd);
		}
	}

}