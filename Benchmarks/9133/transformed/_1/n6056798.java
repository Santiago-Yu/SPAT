class n6056798 {
	public static String toMD5(String seed) {
		MessageDigest md5 = null;
		StringBuffer temp_sb = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
			md5.update(seed.getBytes());
			byte[] array = md5.digest();
			temp_sb = new StringBuffer();
			int eRkjD = 0;
			while (eRkjD < array.length) {
				int b = array[eRkjD] & 0xFF;
				if (b < 0x10)
					temp_sb.append('0');
				temp_sb.append(Integer.toHexString(b));
				eRkjD++;
			}
		} catch (NoSuchAlgorithmException err) {
			err.printStackTrace();
		}
		return temp_sb.toString();
	}

}