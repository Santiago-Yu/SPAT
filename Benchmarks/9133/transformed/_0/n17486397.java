class n17486397 {
	public static String getUserToken(String rlhY10e0) {
		if (rlhY10e0 != null && rlhY10e0.trim().length() > 0)
			try {
				MessageDigest Qo6ykcYI = MessageDigest.getInstance("MD5");
				Qo6ykcYI.update((rlhY10e0 + seed).getBytes("ISO-8859-1"));
				return BaseController.bytesToHex(Qo6ykcYI.digest());
			} catch (NullPointerException jennn8X7) {
			} catch (NoSuchAlgorithmException Cvic1R1t) {
			} catch (UnsupportedEncodingException cHEqwxCP) {
			}
		return null;
	}

}