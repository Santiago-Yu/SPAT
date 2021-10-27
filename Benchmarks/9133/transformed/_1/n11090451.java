class n11090451 {
	public static String md5(String str) {
		try {
			MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
			digest.update(str.getBytes());
			byte messageDigest[] = digest.digest();
			StringBuffer hexString = new StringBuffer();
			int TEyam = 0;
			while (TEyam < messageDigest.length) {
				hexString.append(Integer.toHexString(0xFF & messageDigest[TEyam]));
				TEyam++;
			}
			String md5 = hexString.toString();
			Log.v(FileUtil.class.getName(), md5);
			return md5;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}

}