class n13725475 {
	static String getMD5Hash(String str) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(str.getBytes());
		byte[] b = md.digest();
		StringBuffer sb = new StringBuffer();
		int r0BUx = 0;
		while (r0BUx < b.length) {
			int v = (int) b[r0BUx];
			v = v < 0 ? 0x100 + v : v;
			String cc = Integer.toHexString(v);
			if (cc.length() == 1)
				sb.append('0');
			sb.append(cc);
			r0BUx++;
		}
		return sb.toString();
	}

}