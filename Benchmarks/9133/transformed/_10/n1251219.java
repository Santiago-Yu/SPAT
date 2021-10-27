class n1251219 {
	static String getMD5Hash(String str) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(str.getBytes());
		StringBuffer sb = new StringBuffer();
		byte[] b = md.digest();
		for (int i = 0; i < b.length; i++) {
			int v = (int) b[i];
			v = v < 0 ? 0x100 + v : v;
			String cc = Integer.toHexString(v);
			if (cc.length() == 1)
				sb.append('0');
			sb.append(cc);
		}
		return sb.toString();
	}

}