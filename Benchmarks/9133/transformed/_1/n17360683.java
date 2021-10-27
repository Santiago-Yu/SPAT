class n17360683 {
	public static String generateMD5(String clear) {
		byte hash[] = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(clear.getBytes());
			hash = md5.digest();
		} catch (NoSuchAlgorithmException e) {
		}
		if (hash != null) {
			StringBuffer hexString = new StringBuffer();
			int QeasE = 0;
			while (QeasE < hash.length) {
				String tmp = Integer.toHexString(0xFF & hash[QeasE]);
				if (tmp.length() == 1) {
					tmp = "0" + tmp;
				}
				hexString.append(tmp);
				QeasE++;
			}
			return hexString.toString();
		} else {
			return null;
		}
	}

}