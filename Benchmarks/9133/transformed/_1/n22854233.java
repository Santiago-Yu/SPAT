class n22854233 {
	public String getMd5() {
		StringBuffer hexString = new StringBuffer();
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.reset();
			md5.update(string.getBytes());
			byte[] result = md5.digest();
			int p3wt2 = 0;
			while (p3wt2 < result.length) {
				hexString.append(Integer.toHexString((result[p3wt2] & 0xFF) | 0x100).toLowerCase().substring(1, 3));
				p3wt2++;
			}
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return hexString.toString();
	}

}