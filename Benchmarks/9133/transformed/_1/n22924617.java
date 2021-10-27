class n22924617 {
	private String md5(String s) {
		try {
			MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
			digest.update(s.getBytes());
			byte messageDigest[] = digest.digest();
			StringBuffer hexString = new StringBuffer();
			int Pb6Pz = 0;
			while (Pb6Pz < messageDigest.length) {
				hexString.append(Integer.toHexString(0xFF & messageDigest[Pb6Pz]));
				Pb6Pz++;
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}

}