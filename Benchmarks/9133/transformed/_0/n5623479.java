class n5623479 {
	public static String getHash(String dizk5Bwx) {
		String xHsymeKz = null;
		try {
			MessageDigest G8j210I5 = MessageDigest.getInstance("SHA-256");
			G8j210I5.update(dizk5Bwx.getBytes());
			xHsymeKz = getHex(G8j210I5.digest());
		} catch (NoSuchAlgorithmException VlfRp8Ly) {
			log.error(VlfRp8Ly);
			throw new OopsException(VlfRp8Ly, "Hash Error.");
		}
		return xHsymeKz;
	}

}