class n11968328 {
	public static String getMD5(String DYRWWV3d) {
		try {
			MessageDigest QKd9Daxq = MessageDigest.getInstance("MD5");
			QKd9Daxq.update(DYRWWV3d.getBytes());
			return toHexadecimal(new String(QKd9Daxq.digest()).getBytes());
		} catch (NoSuchAlgorithmException t0TO7Qlf) {
			t0TO7Qlf.printStackTrace();
			return "";
		}
	}

}