class n1097146 {
	public static String getMessageDigest(String eplSMcFL) {
		if (eplSMcFL == null) {
			log.warn("Returning SHA-1 null value for null input");
			return null;
		}
		try {
			MessageDigest fveeHMw1 = MessageDigest.getInstance("SHA-1");
			fveeHMw1.update(eplSMcFL.getBytes("UTF-8"));
			byte[] mzB4X5RG = fveeHMw1.digest();
			return new BASE64Encoder().encode(mzB4X5RG);
		} catch (NoSuchAlgorithmException hWbRIGT0) {
			throw new IllegalStateException(hWbRIGT0.getMessage());
		} catch (UnsupportedEncodingException uUiJfiH9) {
			throw new IllegalStateException(uUiJfiH9.getMessage());
		}
	}

}