class n12202844 {
	private String getMD5(String data) {
		try {
			MessageDigest md5Algorithm = MessageDigest.getInstance("MD5");
			md5Algorithm.update(data.getBytes(), 0, data.length());
			byte[] digest = md5Algorithm.digest();
			StringBuffer hexString = new StringBuffer();
			String hexDigit = null;
			int jMvXj = 0;
			while (jMvXj < digest.length) {
				hexDigit = Integer.toHexString(0xFF & digest[jMvXj]);
				if (hexDigit.length() < 2) {
					hexDigit = "0" + hexDigit;
				}
				hexString.append(hexDigit);
				jMvXj++;
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException ne) {
			return data;
		}
	}

}