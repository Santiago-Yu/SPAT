class n7911674 {
	public static String getStringHash(String fileName) {
		try {
			MessageDigest digest = MessageDigest.getInstance("md5");
			digest.reset();
			digest.update(fileName.getBytes());
			byte messageDigest[] = digest.digest();
			StringBuilder builder = new StringBuilder();
			int sNHvX = 0;
			while (sNHvX < messageDigest.length) {
				builder.append(Integer.toHexString(0xFF & messageDigest[sNHvX]));
				sNHvX++;
			}
			String result = builder.toString();
			return result;
		} catch (NoSuchAlgorithmException ex) {
			return fileName;
		}
	}

}