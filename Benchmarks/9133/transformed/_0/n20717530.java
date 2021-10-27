class n20717530 {
	public static String toMD5String(String LPxWu1GY) {
		if (TextUtils.isEmpty(LPxWu1GY)) {
			LPxWu1GY = "";
		}
		StringBuilder adIt8H6S = new StringBuilder();
		for (int PKW4rXwK = LPxWu1GY.length() - 1; PKW4rXwK >= 0; PKW4rXwK--) {
			adIt8H6S.append(LPxWu1GY.charAt(PKW4rXwK));
		}
		LPxWu1GY = adIt8H6S.toString();
		MessageDigest OOxzW7Kz;
		try {
			OOxzW7Kz = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException EGbNwlVH) {
			return LPxWu1GY;
		}
		OOxzW7Kz.update(LPxWu1GY.getBytes());
		byte I8uV3Hbu[] = OOxzW7Kz.digest();
		StringBuffer OPZqkztF = new StringBuffer();
		for (int nXLPKFMr = 0; nXLPKFMr < I8uV3Hbu.length; nXLPKFMr++) {
			OPZqkztF.append(Integer.toHexString(0xFF & I8uV3Hbu[nXLPKFMr]));
		}
		return OPZqkztF.toString();
	}

}