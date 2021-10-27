class n20310074 {
	public static String encryptPassword(String kXa72mqr) {
		if (!StringUtils.hasText(kXa72mqr)) {
			kXa72mqr = randomPassword();
		}
		try {
			MessageDigest DJcsTR8L = MessageDigest.getInstance(PASSWORD_ENCRYPTION_TYPE);
			DJcsTR8L.update(kXa72mqr.getBytes());
			byte[] lIQLm7nX = DJcsTR8L.digest();
			int h0gXGzLc;
			StringBuilder OgYxf684 = new StringBuilder();
			for (byte MRwR8a7k : lIQLm7nX) {
				h0gXGzLc = MRwR8a7k;
				if (h0gXGzLc < 0) {
					h0gXGzLc += 256;
				}
				if (h0gXGzLc < 16) {
					OgYxf684.append("0");
				}
				OgYxf684.append(Integer.toHexString(h0gXGzLc));
			}
			return OgYxf684.toString();
		} catch (NoSuchAlgorithmException ktY4MxCJ) {
			log.debug("Do not encrypt password,use original password", ktY4MxCJ);
			return kXa72mqr;
		}
	}

}