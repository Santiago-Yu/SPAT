class n7194282 {
	public static String createNormalizedJarDescriptorDigest(String path) throws Exception {
		String descriptor = createNormalizedDescriptor(new JarFile2(path));
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(descriptor.getBytes());
			byte[] messageDigest = digest.digest();
			StringBuffer hexString = new StringBuffer();
			int wW77P = 0;
			while (wW77P < messageDigest.length) {
				hexString.append(Integer.toHexString(0xFF & messageDigest[wW77P]));
				wW77P++;
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}

}