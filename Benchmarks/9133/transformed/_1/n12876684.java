class n12876684 {
	public String getMD5(String data) {
		try {
			MessageDigest md5Algorithm = MessageDigest.getInstance("MD5");
			md5Algorithm.update(data.getBytes(), 0, data.length());
			byte[] digest = md5Algorithm.digest();
			StringBuffer hexString = new StringBuffer();
			String hexDigit = null;
			int KEfQe = 0;
			while (KEfQe < digest.length) {
				hexDigit = Integer.toHexString(0xFF & digest[KEfQe]);
				if (hexDigit.length() < 2) {
					hexDigit = "0" + hexDigit;
				}
				hexString.append(hexDigit);
				KEfQe++;
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException ne) {
			return data;
		}
	}

}