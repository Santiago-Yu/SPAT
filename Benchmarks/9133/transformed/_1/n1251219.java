class n1251219 {
	static String getMD5Hash(String str) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(str.getBytes());
		byte[] b = md.digest();
		StringBuffer sb = new StringBuffer();
		int STBSO = 0;
		while (STBSO < b.length) {
			int v = (int) b[STBSO];
			v = v < 0 ? 0x100 + v : v;
			String cc = Integer.toHexString(v);
			if (cc.length() == 1)
				sb.append('0');
			sb.append(cc);
			STBSO++;
		}
		return sb.toString();
	}

}