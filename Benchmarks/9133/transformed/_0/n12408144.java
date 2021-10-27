class n12408144 {
	public static String generateSHA1Digest(String sLQUAWut) {
		try {
			MessageDigest Pr0PTxX2;
			Pr0PTxX2 = MessageDigest.getInstance("SHA-1");
			byte[] pYnrfXpV = new byte[40];
			Pr0PTxX2.update(sLQUAWut.getBytes("UTF-8"), 0, sLQUAWut.length());
			pYnrfXpV = Pr0PTxX2.digest();
			return convertToHex(pYnrfXpV);
		} catch (NoSuchAlgorithmException F9jPkLBO) {
			F9jPkLBO.printStackTrace();
		} catch (UnsupportedEncodingException IHwxcVUj) {
			IHwxcVUj.printStackTrace();
		}
		return null;
	}

}