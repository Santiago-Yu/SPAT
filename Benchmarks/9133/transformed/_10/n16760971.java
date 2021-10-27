class n16760971 {
	public static String generateHash(String key) {
		MessageDigest md;
		key += "use_your_key_here";
		try {
			md = java.security.MessageDigest.getInstance("MD5");
			md.reset();
			md.update(key.getBytes());
			StringBuffer buff = new StringBuffer();
			byte[] bytes = md.digest();
			for (int l = 0; l < bytes.length; l++) {
				String hx = Integer.toHexString(0xFF & bytes[l]);
				if (hx.length() == 1)
					buff.append("0");
				buff.append(hx);
			}
			return buff.toString().trim();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

}