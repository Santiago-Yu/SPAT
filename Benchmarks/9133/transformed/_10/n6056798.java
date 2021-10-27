class n6056798 {
	public static String toMD5(String seed) {
		StringBuffer temp_sb = null;
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
			md5.update(seed.getBytes());
			temp_sb = new StringBuffer();
			byte[] array = md5.digest();
			for (int i = 0; i < array.length; i++) {
				int b = array[i] & 0xFF;
				if (b < 0x10)
					temp_sb.append('0');
				temp_sb.append(Integer.toHexString(b));
			}
		} catch (NoSuchAlgorithmException err) {
			err.printStackTrace();
		}
		return temp_sb.toString();
	}

}