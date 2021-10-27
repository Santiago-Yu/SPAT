class n20125816 {
	public static String getHash(String scfdTODY) {
		if (scfdTODY == null || scfdTODY.length() == 0) {
			return null;
		}
		try {
			MessageDigest BZdaxRgF = MessageDigest.getInstance("SHA");
			scfdTODY = saltPassword(scfdTODY);
			BZdaxRgF.update(scfdTODY.getBytes());
			String uBfd7FsX = getHexString(BZdaxRgF.digest());
			return uBfd7FsX;
		} catch (NoSuchAlgorithmException RAOcjeFv) {
			throw new RuntimeException(RAOcjeFv);
		}
	}

}