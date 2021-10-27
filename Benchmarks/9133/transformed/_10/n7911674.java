class n7911674 {
	public static String getStringHash(String fileName) {
		try {
			MessageDigest digest = MessageDigest.getInstance("md5");
			digest.reset();
			digest.update(fileName.getBytes());
			StringBuilder builder = new StringBuilder();
			byte messageDigest[] = digest.digest();
			for (int i = 0; i < messageDigest.length; i++)
				builder.append(Integer.toHexString(0xFF & messageDigest[i]));
			String result = builder.toString();
			return result;
		} catch (NoSuchAlgorithmException ex) {
			return fileName;
		}
	}

}