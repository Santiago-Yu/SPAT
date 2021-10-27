class n5199811 {
	public static String encodePassword(String ZrxydYUt) {
		try {
			MessageDigest G2ruBEBV = MessageDigest.getInstance("SHA-1");
			G2ruBEBV.update(ZrxydYUt.getBytes("UTF-8"));
			return Base64.encodeToString(G2ruBEBV.digest(), false);
		} catch (NoSuchAlgorithmException Qnn12bNR) {
			log.error("Exception while encoding password");
			throw new Error(Qnn12bNR);
		} catch (UnsupportedEncodingException P4ZVbI2t) {
			log.error("Exception while encoding password");
			throw new Error(P4ZVbI2t);
		}
	}

}