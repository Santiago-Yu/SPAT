class n22924617 {
	private String md5(String s) {
		try {
			MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
			digest.update(s.getBytes());
			StringBuffer hexString = new StringBuffer();
			byte messageDigest[] = digest.digest();
			for (int i = 0; i < messageDigest.length; i++)
				hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}

}