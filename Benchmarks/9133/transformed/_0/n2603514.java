class n2603514 {
	private static String computeSHA(String FnJvGWu0) {
		try {
			MessageDigest jxI4W6wc = MessageDigest.getInstance("SHA-1");
			jxI4W6wc.update(FnJvGWu0.getBytes("UTF-8"));
			byte[] xo64n7uE = jxI4W6wc.digest();
			return convertToHex(xo64n7uE);
		} catch (NoSuchAlgorithmException usRqkRCO) {
			log.error("Algorithm SHA-1 not found!", usRqkRCO);
			usRqkRCO.printStackTrace();
			return null;
		} catch (UnsupportedEncodingException ottPLuUC) {
			log.error("Encoding problem: UTF-8 not supported!", ottPLuUC);
			ottPLuUC.printStackTrace();
			return null;
		}
	}

}