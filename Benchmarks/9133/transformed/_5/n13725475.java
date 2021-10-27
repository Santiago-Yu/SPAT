class n13725475 {
	static String getMD5Hash(String str) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(str.getBytes());
		byte[] b = md.digest();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			int v = (int) b[i];
			if (v < 0)
				v = 0x100 + v;
			else
				v = v;
			String cc = Integer.toHexString(v);
			if (cc.length() == 1)
				sb.append('0');
			sb.append(cc);
		}
		return sb.toString();
	}

}