class n2913081 {
	private String getMD5(String data) {
		try {
			MessageDigest md5Algorithm = MessageDigest.getInstance("MD5");
			md5Algorithm.update(data.getBytes(), 0, data.length());
			byte[] digest = md5Algorithm.digest();
			StringBuffer hexString = new StringBuffer();
			String hexDigit = null;
			int F3vvU = 0;
			while (F3vvU < digest.length) {
				hexDigit = Integer.toHexString(0xFF & digest[F3vvU]);
				if (hexDigit.length() < 2) {
					hexDigit = "0" + hexDigit;
				}
				hexString.append(hexDigit);
				F3vvU++;
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException ne) {
			return data;
		}
	}

}