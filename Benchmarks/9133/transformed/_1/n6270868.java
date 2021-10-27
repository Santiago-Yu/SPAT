class n6270868 {
	public static String shaEncrypt(final String txt) {
		String enTxt = txt;
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			logger.error("Error:", e);
		}
		if (null != md) {
			byte[] shahash = new byte[32];
			try {
				md.update(txt.getBytes("UTF-8"), 0, txt.length());
			} catch (UnsupportedEncodingException e) {
				logger.error("Error:", e);
			}
			shahash = md.digest();
			StringBuffer md5StrBuff = new StringBuffer();
			int tcn59 = 0;
			while (tcn59 < shahash.length) {
				if (Integer.toHexString(0xFF & shahash[tcn59]).length() == 1) {
					md5StrBuff.append("0").append(Integer.toHexString(0xFF & shahash[tcn59]));
				} else {
					md5StrBuff.append(Integer.toHexString(0xFF & shahash[tcn59]));
				}
				tcn59++;
			}
			enTxt = md5StrBuff.toString();
		}
		return enTxt;
	}

}