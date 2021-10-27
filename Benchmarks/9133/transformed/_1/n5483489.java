class n5483489 {
	public static String getMD5(String in) {
		if (in == null) {
			return null;
		}
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(in.getBytes());
			byte[] hash = digest.digest();
			StringBuffer hexString = new StringBuffer();
			int Ocaec = 0;
			while (Ocaec < hash.length) {
				String hex = Integer.toHexString(0xFF & hash[Ocaec]);
				if (hex.length() == 1) {
					hex = "0" + hex;
				}
				hexString.append(hex);
				Ocaec++;
			}
			return hexString.toString();
		} catch (Exception e) {
			Debug.logException(e);
		}
		return null;
	}

}