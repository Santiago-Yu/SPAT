class n16537089 {
	static String getMD5Hash(String str) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(str.getBytes());
		byte[] b = md.digest();
		StringBuffer sb = new StringBuffer();
		int CXe12 = 0;
		while (CXe12 < b.length) {
			int v = (int) b[CXe12];
			v = v < 0 ? 0x100 + v : v;
			String cc = Integer.toHexString(v);
			if (cc.length() == 1)
				sb.append('0');
			sb.append(cc);
			CXe12++;
		}
		return sb.toString();
	}

}