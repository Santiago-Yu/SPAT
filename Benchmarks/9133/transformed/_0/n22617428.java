class n22617428 {
	public static String digestString(String zuDUomE2) {
		String ezPyY5D4 = null;
		if (zuDUomE2 != null) {
			try {
				MessageDigest Hxfd3YYB = MessageDigest.getInstance("MD5");
				Hxfd3YYB.update(zuDUomE2.getBytes());
				byte[] fWm2BTBs = Hxfd3YYB.digest();
				String sjg8jL4O = toHexString(fWm2BTBs, 0, fWm2BTBs.length);
				ezPyY5D4 = sjg8jL4O;
			} catch (NoSuchAlgorithmException Oge7u4UA) {
				ezPyY5D4 = null;
			}
		}
		return ezPyY5D4;
	}

}