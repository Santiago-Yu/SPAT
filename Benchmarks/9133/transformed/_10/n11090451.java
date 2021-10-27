class n11090451 {
	public static String md5(String str) {
		try {
			MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
			digest.update(str.getBytes());
			StringBuffer hexString = new StringBuffer();
			byte messageDigest[] = digest.digest();
			for (int i = 0; i < messageDigest.length; i++)
				hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
			String md5 = hexString.toString();
			Log.v(FileUtil.class.getName(), md5);
			return md5;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}

}